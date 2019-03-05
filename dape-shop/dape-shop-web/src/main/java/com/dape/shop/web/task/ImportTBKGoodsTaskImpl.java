package com.dape.shop.web.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dape.common.util.PropertiesFileUtil;
import com.dape.shop.dao.model.ShopGoods;
import com.dape.shop.dao.model.ShopGoodsExample;
import com.dape.shop.dao.model.ShopMaterialImport;
import com.dape.shop.dao.model.ShopMaterialImportExample;
import com.dape.shop.rpc.api.ShopGoodsService;
import com.dape.shop.rpc.api.ShopMaterialImportService;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgOptimusMaterialRequest;
import com.taobao.api.response.TbkDgOptimusMaterialResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

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

    @Scheduled(cron = "0 36 16 * * ?")
    public void importGoods() {
        // 导入相关
        String tbkApiUrl = PropertiesFileUtil.getInstance().get("tbk.api.url");
        String tbkAppKey = PropertiesFileUtil.getInstance().get("tbk.appKey");
        String tbkSecret = PropertiesFileUtil.getInstance().get("tbk.secret");
        String tbkAdzoneId = PropertiesFileUtil.getInstance().get("tbk.adzoneId");
        String tbkCouponAmount = PropertiesFileUtil.getInstance().get("tbk.couponAmount");
        String tbkCouponRate = PropertiesFileUtil.getInstance().get("tbk.couponRate");
        String pageSize = PropertiesFileUtil.getInstance().get("tbk.pageSize");

        Long tbkAdzoneIdL = Long.valueOf(tbkAdzoneId);
        Long pageSizeL = Long.valueOf(pageSize);

        // 查询需要导入的类目
        ShopMaterialImportExample smiE = new ShopMaterialImportExample();
        smiE.or().andIsEnabledEqualTo(true);
        List<ShopMaterialImport> shopMaterialImports = shopMaterialImportService.selectByExample(smiE);

        // 淘宝客client
        TaobaoClient client = new DefaultTaobaoClient(tbkApiUrl, tbkAppKey, tbkSecret);
        TbkDgOptimusMaterialRequest req = null;

        if(shopMaterialImports != null && shopMaterialImports.size() > 0){
            for(ShopMaterialImport shopMaterialImport : shopMaterialImports){

                int addNum = 0;// 新增条数
                int editNum = 0;// 编辑条数
                int failAddNum = 0;// 新增失败条数
                int failEditNum = 0;// 修改失败条数
                int requestNum = 0;// 请求次数
                int queryNum = 0;// 查询到的总条数
                int filterNum = 0;// 过滤条数


                String materialIdStr = shopMaterialImport.getMaterialId();

                if(StringUtils.isBlank(materialIdStr)){
                    shopMaterialImport.setLastImportDate(new Date());
                    shopMaterialImport.setLastImportResult("物料为空");
                    shopMaterialImportService.updateByPrimaryKey(shopMaterialImport);
                    continue;
                }
                Long materialId = null;
                try{
                    materialId = Long.valueOf(materialIdStr);
                }catch (Exception e){
                    shopMaterialImport.setLastImportDate(new Date());
                    shopMaterialImport.setLastImportResult(materialIdStr + ":不是数字|");
                    shopMaterialImportService.updateByPrimaryKey(shopMaterialImport);
                    continue;
                }

                if(shopMaterialImport.getChildType() == null){
                    shopMaterialImport.setLastImportDate(new Date());
                    shopMaterialImport.setLastImportResult("child_type为空");
                    shopMaterialImportService.updateByPrimaryKey(shopMaterialImport);
                    continue;
                }

                Long pageNo = 1L;
                importLoop:while(true) {
                    System.out.println("当前页:" + pageNo + ", materialId" + materialIdStr);
                    req = new TbkDgOptimusMaterialRequest();
                    req.setPageSize(pageSizeL);
                    req.setAdzoneId(tbkAdzoneIdL);
                    req.setPageNo(pageNo);
                    req.setMaterialId(materialId);
                    pageNo++;// 查询的当前页码

                    try {
                        TbkDgOptimusMaterialResponse rsp = client.execute(req);
                        String resultJson = rsp.getBody();
                        requestNum++;// 记录请求的总次数

                        // 返回结果转json
                        JSONObject jsonObject = JSON.parseObject(resultJson);
                        JSONObject tbkDgOptimusMaterialResponse = jsonObject.getJSONObject("tbk_dg_optimus_material_response");// 各个接口的结果集字段不一样
                        JSONObject errorResponse = jsonObject.getJSONObject("error_response");

                        if(errorResponse != null){//返回错误
                            String subMsg = errorResponse.getString("sub_msg");
                            if(subMsg.equals("无结果")){// 无结果跳出当前循环
                                break importLoop;
                            }
                        }else if(tbkDgOptimusMaterialResponse != null) {//查询成功
                            String requestId = tbkDgOptimusMaterialResponse.getString("request_id");
                            JSONObject resultList = tbkDgOptimusMaterialResponse.getJSONObject("result_list");
                            JSONArray mapData = resultList.getJSONArray("map_data");
                            if(mapData == null || mapData.size() <= 0){// 无结果跳出当前循环
                                break importLoop;
                            }
                            queryNum += mapData.size();// 记录查询到的总条数
                            Integer[] result = shopMaterialImportService.importGoodsByMaterial(shopMaterialImport, mapData, new BigDecimal(tbkCouponAmount), new BigDecimal(tbkCouponRate));
                            addNum += result[0];
                            failAddNum += result[1];
                            editNum += result[2];
                            failEditNum += result[3];
                            filterNum += result[4];
                        }
                    } catch (ApiException e) {
                        e.printStackTrace();
                    }

                }

                // 记录执行结果
                shopMaterialImport.setLastImportDate(new Date());
                shopMaterialImport.setLastImportResult("[新增:"+addNum+",失败:"+failAddNum+"],[编辑:"+editNum+",失败:"+failEditNum+"],[请求:"+requestNum+",总数:"+queryNum+",过滤:"+filterNum+"]");
                shopMaterialImportService.updateByPrimaryKey(shopMaterialImport);
            }
        }
    }

    @Scheduled(cron = "0 0 15 * * ?")
    public void deleteGoodsByCouponEndTime() {
        // 逻辑删除，修改is_enabled 字段
        int updateNum = shopGoodsService.updateGoodsByCouponEndTime();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LOGGER.info("券已失效的商品共[" + updateNum + "]条, 执行时间:" + format.format(new Date()));
    }
}
