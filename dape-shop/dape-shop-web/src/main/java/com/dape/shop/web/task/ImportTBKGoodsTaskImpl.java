package com.dape.shop.web.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dape.common.util.PropertiesFileUtil;
import com.dape.shop.dao.model.*;
import com.dape.shop.rpc.api.ShopDetailImgUrlService;
import com.dape.shop.rpc.api.ShopGoodsService;
import com.dape.shop.rpc.api.ShopMaterialImportService;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgOptimusMaterialRequest;
import com.taobao.api.response.TbkDgOptimusMaterialResponse;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import java.io.*;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 定时导入淘宝客商品信息，每天凌晨2点执行
 */
@Component
public class ImportTBKGoodsTaskImpl {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImportTBKGoodsTaskImpl.class);

    @Autowired
    private ShopMaterialImportService shopMaterialImportService;

    @Autowired
    private ShopGoodsService shopGoodsService;

    @Autowired
    public ShopDetailImgUrlService shopDetailImgUrlService;

    private static String importTxtPath = null;

    /**
     * 根据物料id从淘宝客获取商品写本地文件
     */
    @Scheduled(cron = "0 30 1 * * ?")
    public void importGoods() {
        // 导入相关
        String tbkApiUrl = PropertiesFileUtil.getInstance().get("tbk.api.url");
        String tbkAppKey = PropertiesFileUtil.getInstance().get("tbk.appKey");
        String tbkSecret = PropertiesFileUtil.getInstance().get("tbk.secret");
        String tbkAdzoneId = PropertiesFileUtil.getInstance().get("tbk.adzoneId");
        String pageSize = PropertiesFileUtil.getInstance().get("tbk.pageSize");

        if(StringUtils.isBlank(importTxtPath)){
            importTxtPath = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String dateStr = format.format(new Date());

        Long tbkAdzoneIdL = Long.valueOf(tbkAdzoneId);
        Long pageSizeL = Long.valueOf(pageSize);

        // 查询需要导入的类目
        ShopMaterialImportExample smiE = new ShopMaterialImportExample();
        smiE.or().andIsEnabledEqualTo(true);
        List<ShopMaterialImport> shopMaterialImports = shopMaterialImportService.selectByExample(smiE);

        // 淘宝客client
        TaobaoClient client = new DefaultTaobaoClient(tbkApiUrl, tbkAppKey, tbkSecret);
        TbkDgOptimusMaterialRequest req = null;

        if (shopMaterialImports != null && shopMaterialImports.size() > 0) {
            for (ShopMaterialImport shopMaterialImport : shopMaterialImports) {

                int addNum = 0;// 新增条数
                int editNum = 0;// 编辑条数
                int failAddNum = 0;// 新增失败条数
                int failEditNum = 0;// 修改失败条数
                int requestNum = 0;// 请求次数
                int queryNum = 0;// 查询到的总条数
                int filterNum = 0;// 过滤条数

                String materialIdStr = shopMaterialImport.getMaterialId();

                if (StringUtils.isBlank(materialIdStr)) {
                    shopMaterialImport.setLastImportDate(new Date());
                    shopMaterialImport.setLastImportResult("物料为空");
                    shopMaterialImportService.updateByPrimaryKey(shopMaterialImport);
                    continue;
                }
                Long materialId = null;
                try {
                    materialId = Long.valueOf(materialIdStr);
                } catch (Exception e) {
                    shopMaterialImport.setLastImportDate(new Date());
                    shopMaterialImport.setLastImportResult(materialIdStr + ":不是数字|");
                    shopMaterialImportService.updateByPrimaryKey(shopMaterialImport);
                    continue;
                }

                if (shopMaterialImport.getChildType() == null) {
                    shopMaterialImport.setLastImportDate(new Date());
                    shopMaterialImport.setLastImportResult("child_type为空");
                    shopMaterialImportService.updateByPrimaryKey(shopMaterialImport);
                    continue;
                }

                Long pageNo = 1L;
                importLoop:
                while (true) {
                    System.out.println("当前页:" + pageNo + ", materialId:" + materialIdStr);
                    req = new TbkDgOptimusMaterialRequest();
                    req.setPageSize(pageSizeL);
                    req.setAdzoneId(tbkAdzoneIdL);
                    req.setPageNo(pageNo);
                    req.setMaterialId(materialId);

                    try {
                        TbkDgOptimusMaterialResponse rsp = client.execute(req);
                        String resultJson = rsp.getBody();
                        requestNum++;// 记录请求的总次数

                        // 返回结果转json
                        JSONObject jsonObject = JSON.parseObject(resultJson);
                        JSONObject tbkDgOptimusMaterialResponse = jsonObject.getJSONObject("tbk_dg_optimus_material_response");// 各个接口的结果集字段不一样
                        JSONObject errorResponse = jsonObject.getJSONObject("error_response");

                        if (errorResponse != null) {//返回错误
                            String subMsg = errorResponse.getString("sub_msg");
                            if (subMsg.equals("无结果")) {// 无结果跳出当前循环
                                break importLoop;
                            }
                        } else if (tbkDgOptimusMaterialResponse != null) {//查询成功
                            String requestId = tbkDgOptimusMaterialResponse.getString("request_id");
                            JSONObject resultList = tbkDgOptimusMaterialResponse.getJSONObject("result_list");
                            JSONArray mapData = resultList.getJSONArray("map_data");
                            if (mapData == null || mapData.size() <= 0) {// 无结果跳出当前循环
                                break importLoop;
                            }
                            String mainImgTemp = importTxtPath + File.separator + "resources" + File.separator + "goodsdata" + File.separator + dateStr + "_" + shopMaterialImport.getId() + "_" + pageNo + ".txt";
                            File mainImgF = new File(mainImgTemp);
                            if (!mainImgF.exists()) {
                                try {
                                    mainImgF.createNewFile();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            FileWriter fileWritter = null;
                            try {
                                fileWritter = new FileWriter(mainImgF, true);
                                fileWritter.write(mapData.toJSONString());
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } finally {
                                if (fileWritter != null) {
                                    try {
                                        fileWritter.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    } catch (ApiException e) {
                        e.printStackTrace();
                    }
                    pageNo++;// 查询的当前页码
                }
            }
        }
    }

    /**
     * 文件中的商品导入到数据库中
     */
    @Scheduled(cron = "0/20 * 2-5 * * ?")
    public void importGoodsToDB() {
        if(StringUtils.isBlank(importTxtPath)){
            importTxtPath = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
        }
        File txts = new File(importTxtPath + File.separator + "resources" + File.separator + "goodsdata" + File.separator);
        File[] files = txts.listFiles();
        if (files.length > 0) {
            File file = files[0];
            LOGGER.info("正在处理：" + file.getName());
            String txt = "";
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(file));
                String temp;
                while ((temp = br.readLine()) != null) {
                    txt += temp;
                }
                br.close();

                JSONArray mapData = JSONArray.parseArray(txt);

                String fileName = file.getName();
                String[] arr = fileName.split("_");
                Integer id = Integer.valueOf(arr[1]);
                ShopMaterialImport shopMaterialImport = shopMaterialImportService.selectByPrimaryKey(id);

                String tbkCouponAmount = PropertiesFileUtil.getInstance().get("tbk.couponAmount");
                String tbkCouponRate = PropertiesFileUtil.getInstance().get("tbk.couponRate");

                // 导入到数据库
                shopMaterialImportService.importGoodsByMaterial(shopMaterialImport, mapData, new BigDecimal(tbkCouponAmount), new BigDecimal(tbkCouponRate));

                // 更新物料最后更新时间
                shopMaterialImport.setLastImportDate(new Date());
                shopMaterialImportService.updateByPrimaryKey(shopMaterialImport);

                LOGGER.info("成功：" + file.getName());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            file.delete();
        }
    }

    /**
     * 抓取商品详情的图片链接
     */
    @Scheduled(cron = "0 0/10 1-5 * * ?")
    public void getGoodsDetailImgUrl() {


        String tbkHttpType = PropertiesFileUtil.getInstance().get("tbk.http.type");

        ShopGoodsExample example = new ShopGoodsExample();
        ShopGoodsExample.Criteria criteria = example.createCriteria();
        criteria.andDescImgDateLessThan(new Date(System.currentTimeMillis() - 432000000));// 5天：1000 * 60 * 60 * 24 * 5
        criteria.andIsEnabledEqualTo(true);

        List<ShopGoods> list = shopGoodsService.selectByExampleForStartPage(example, 1, 100);
        if(list != null && list.size() > 0){

            // 详情图片的淘宝url
            String imgUrl;
            for(ShopGoods item : list){
                imgUrl = null;

                BrowserVersion b = BrowserVersion.getDefault();
                WebClient wc = new WebClient(b);
                HtmlPage page = null;
                String pageXml = null;//记录请求的html字符串
                try {
                    // htmlunit解析网页，获取详情图片url
                    wc.setUseInsecureSSL(true);
                    wc.setJavaScriptEnabled(true); // 启用JS解释器，默认为true
                    wc.setCssEnabled(false); // 禁用css支持
                    wc.setThrowExceptionOnScriptError(false); // js运行错误时，是否抛出异常
                    wc.setTimeout(100000); // 设置连接超时时间 ，这里是10S。如果为0，则无限期等待
                    page = wc.getPage(tbkHttpType + item.getClickUrl());

                    pageXml = page.asXml();

                    Document doc = Jsoup.parse(pageXml);
                    Elements elScripts = doc.getElementsByTag("script");

                    if(item.getUserType() == null){

                    }else if(item.getUserType() == 0){// 淘宝处理
                        String tmp = null;
                        for (Element e : elScripts) {
                            tmp = e.data().toString();
                            tmp = tmp.replaceAll(" ","").replaceAll("\n", "");
                            if(tmp.indexOf("varg_config") >= 0){
                                tmp = tmp.substring(tmp.indexOf("descUrl")+7);
                                tmp = tmp.substring(1,tmp.indexOf(","));
                                tmp = tmp.substring(tmp.indexOf("'?'") +3, tmp.indexOf("':'"));
                                imgUrl = "http:" + tmp;
                                break;
                            }
                        }
                    }else if(item.getUserType() == 1){//开猫处理
                        String scriptTxt = null;
                        for (Element ele : elScripts) {
                            scriptTxt = ele.data().toString();
                            if(scriptTxt.indexOf("httpsDescUrl") > 0){
                                String[] txts1 = scriptTxt.split("httpsDescUrl");
                                String[] txts2 = txts1[1].split(",");
                                imgUrl = "http:" + txts2[0].replaceAll("\"", "").replaceAll(":","").replaceAll(" ", "");
                                break;
                            }
                        }
                    }
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    wc.closeAllWindows();
                }

                // 更新详情图片url
                if(StringUtils.isNotBlank(imgUrl)){
                    ShopDetailImgUrlExample diu = new ShopDetailImgUrlExample();
                    diu.or().andItemIdEqualTo(item.getItemId());
                    List<ShopDetailImgUrl> dList = shopDetailImgUrlService.selectByExample(diu);
                    if(dList != null && dList.size() > 0){
                        ShopDetailImgUrl dItem = dList.get(0);
                        dItem.setImgUrl(imgUrl);
                        dItem.setModifyDate(new Date());
                        shopDetailImgUrlService.updateByPrimaryKey(dItem);
                    }else{
                        ShopDetailImgUrl shopDetailImgUrl = new ShopDetailImgUrl();
                        shopDetailImgUrl.setCreateDate(new Date());
                        shopDetailImgUrl.setModifyDate(new Date());
                        shopDetailImgUrl.setItemId(item.getItemId());
                        shopDetailImgUrl.setImgUrl(imgUrl);
                        shopDetailImgUrlService.insert(shopDetailImgUrl);
                    }
                }

                // 更新最后抓取详情图片时间
                item.setDescImgDate(new Date());
                shopGoodsService.updateByPrimaryKey(item);
            }
        }
    }

    /**
     * 更新失效券相关商品状态
     */
    @Scheduled(cron = "0 5 1 * * ?")
    public void deleteGoodsByCouponEndTime() {
        // 逻辑删除，修改is_enabled 字段
        int updateNum = shopGoodsService.updateGoodsByCouponEndTime();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LOGGER.info("券已失效的商品共[" + updateNum + "]条, 执行时间:" + format.format(new Date()));
    }
}
