package com.dape.shop.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dape.common.base.BaseController;
import com.dape.common.util.QRCodeUtil;
import com.dape.shop.dao.model.*;
import com.dape.shop.rpc.api.*;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.zxing.BarcodeFormat;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgOptimusMaterialRequest;
import com.taobao.api.response.TbkDgOptimusMaterialResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 首页控制器
 * ncoffice on 2018/11/20.
 */
@Controller
@RequestMapping("goods")
public class GoodsController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private ShopGoodsService shopGoodsService;
    @Autowired
    private ShopStoreService shopStoreService;
    @Autowired
    public ShopUserService shopUserService;
    @Autowired
    public ShopDetailImgUrlService shopDetailImgUrlService;
    @Autowired
    public ShopModuleService shopModuleService;
    @Autowired
    public ShopModuleItemService shopModuleItemService;

    /**
     * 淘宝客各模块
     * @param response
     * @return
     */
    @RequestMapping(value = "/coupon", method = RequestMethod.GET)
    public String coupon(Long i, Integer p, String m, Model model, HttpServletResponse response) {
        if(i != null){
            model.addAttribute("p", p);
            model.addAttribute("m", m);
            ShopModuleExample me = new ShopModuleExample();
            me.or().andIdEqualTo(i);
            List<ShopModule> modules = shopModuleService.selectByExample(me);
            if(modules != null && modules.size() == 1){
                model.addAttribute("module", modules.get(0));

                ShopModuleItemExample e = new ShopModuleItemExample();
                e.or().andModuleIdEqualTo(i);
                List<ShopModuleItem> items = shopModuleItemService.selectByExample(e);
                model.addAttribute("items", items);
                return thymeleaf("/coupon");
            }
        }

        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 淘宝客各模块
     * @param request
     * @return
     */
    @RequestMapping(value = "/jhs", method = RequestMethod.GET)
    public String jhs(Integer p, String m, Model model, HttpServletRequest request) {
            model.addAttribute("p", p);
            model.addAttribute("m", m);
            return thymeleaf("/jhs");
    }

    /**
     * 加载商品列表, ajax请求
     * @param pageNum 第几页
     * @param pageSize 每页多少条
     * @param request 查询条件
     * @return
     */
    @RequestMapping(value = "/loadCouponGoods", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> loadCouponGoods(Long pageNum, Long pageSize, HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();

        String q = request.getParameter("q");
        if(StringUtils.isNotBlank(q)){
            params.put("q", q);
        }
        String cat = request.getParameter("cat");
        if(StringUtils.isNotBlank(cat)){
            params.put("cat", cat);
        }
        String platform = request.getParameter("platform");
        if(StringUtils.isNotBlank(platform)){
            params.put("platform", platform);
        }
        String has_coupon = request.getParameter("has_coupon");
        if(StringUtils.isNotBlank(has_coupon)){
            params.put("has_coupon", has_coupon);
        }
        String sort = request.getParameter("sort");
        if(StringUtils.isNotBlank(sort)){
            params.put("sort", sort);
        }
        String need_free_shipment = request.getParameter("need_free_shipment");
        if(StringUtils.isNotBlank(need_free_shipment)){
            params.put("need_free_shipment", need_free_shipment);
        }
        String need_prepay = request.getParameter("need_prepay");
        if(StringUtils.isNotBlank(need_prepay)){
            params.put("need_prepay", need_prepay);
        }
        String itemloc = request.getParameter("itemloc");
        if(StringUtils.isNotBlank(itemloc)){
            params.put("itemloc", itemloc);
        }
        String material_id = request.getParameter("material_id");
        if(StringUtils.isNotBlank(material_id)){
            params.put("material_id", material_id);
        }
//        String ip = request.getParameter("ip");
//        if(StringUtils.isNotBlank(ip)){
//            params.put("ip", ip);
//        }
        return shopGoodsService.loadCouponGoods(pageNum, pageSize, params);
    }

    /**
     * 加载商品列表, ajax请求
     * @param pageNum 第几页
     * @param pageSize 每页多少条
     * @param request 查询条件
     * @return
     */
    @RequestMapping(value = "/loadSearchGoods", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> loadSearchGoods(Long pageNum, Long pageSize, HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();

        Map<String, Object> m = null;

        String q = request.getParameter("q");
        if(StringUtils.isNotBlank(q)){
            params.put("q", q);
        }else{
            m = new HashMap<String, Object>();
            m.put("success", false);
            return m;
        }
        String cat = request.getParameter("cat");
        if(StringUtils.isNotBlank(cat)){
            params.put("cat", cat);
        }
        String platform = request.getParameter("platform");
        if(StringUtils.isNotBlank(platform)){
            params.put("platform", platform);
        }
        String has_coupon = request.getParameter("has_coupon");
        if(StringUtils.isNotBlank(has_coupon)){
            params.put("has_coupon", has_coupon);
        }
        String need_free_shipment = request.getParameter("need_free_shipment");
        if(StringUtils.isNotBlank(need_free_shipment)){
            params.put("need_free_shipment", need_free_shipment);
        }
        String need_prepay = request.getParameter("need_prepay");
        if(StringUtils.isNotBlank(need_prepay)){
            params.put("need_prepay", need_prepay);
        }
        String itemloc = request.getParameter("itemloc");
        if(StringUtils.isNotBlank(itemloc)){
            params.put("itemloc", itemloc);
        }
        String sort = request.getParameter("sort");
        if(StringUtils.isBlank(sort)){
            sort = "tk_total_sales_des";
        }
        params.put("sort", sort);

        String material_id = request.getParameter("material_id");
        if(StringUtils.isNotBlank(material_id)){
            params.put("material_id", material_id);
        }
//        if(StringUtils.isNotBlank(ip)){
//            params.put("ip", ip);
//        }

        if(StringUtils.isNotBlank(q)){
            for(ShopMenu shopMenu : IndexController.menus){
                if(shopMenu.getName().equals(q.trim())){
//                    params.put("material_id", shopMenu.getMaterialId());//添加物料id,排序无效
                    m = shopGoodsService.loadCouponGoodsBySeach(pageNum, pageSize, params);
                    return m;
                }
            }
            if (q.length() <= 20) {// 查询leng大于20时，equals判断
                m = shopGoodsService.loadCouponGoodsBySeach(pageNum, pageSize, params);
                return m;
            }
            JSONArray mapList = new JSONArray();
            JSONObject jsonObject = null;
            String title = null;
            pageSize = 100L;
            params = new HashMap<String, Object>();
            params.put("q", q);
            params.put("platform", platform);
            for(int i = 0; i < 10; i++) {
                long queryCount = pageNum * pageSize;
                System.out.println("pageNum:" + pageNum + ", pageSize:" + pageSize + ", queryCount:" + queryCount);
                m = shopGoodsService.loadCouponGoodsBySeach(pageNum, pageSize, params);
                m.put("pageNum", pageNum);
                pageNum = pageNum + 1;
                if ((boolean) m.get("success")) {
                    Long total = -1L;
                    if(m.get("total") != null && StringUtils.isNotBlank(m.get("total").toString())){
                        total = (Long)m.get("total");
                    }
                    JSONArray mapData = (JSONArray) m.get("mapData");
                    for (int j = 0; j < mapData.size(); j++) {
                        jsonObject = mapData.getJSONObject(j);
                        title = jsonObject.getString("title");
                        if (StringUtils.isNotBlank(title)) {
                            if (title.trim().equals(q.trim())) {
                                mapList.add(jsonObject);
                            }
                        }
                    }
                    if (mapList.size() >= 20) {
                        break;
                    }
                    if(total > 0 && queryCount > total){
                        m.put("flag", true);// 标记已没有符合的记录
                        return m;
                    }
                }else{
                    break;
                }
            }
            m.put("mapData", mapList);
        }
        return m;
    }

    /**
     * 商品详情
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/goodsDetail", method = RequestMethod.POST)
    public String goodsDetail(Long item_id, String tkl, Integer userid, Model model, HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();

        String platform = request.getParameter("platform");
        if(StringUtils.isNotBlank(platform)){
            params.put("platform", platform);
        }

        // 商品
        Map<String, Object> goodsDetail = shopGoodsService.findGoods(item_id, params);
        if(Boolean.valueOf(goodsDetail.get("success").toString())){
            model.addAttribute("goodsDetail", goodsDetail.get("nTbkItem"));
        }else{
            model.addAttribute("goodsDetail", "");
        }

        // 佣金率
        String commission_rate = request.getParameter("commission_rate");
        if(StringUtils.isNotBlank(commission_rate)){
            model.addAttribute("commission_rate", commission_rate);
        }else{
            model.addAttribute("commission_rate", 0);
        }
        // 券额
        String coupon_amount = request.getParameter("coupon_amount");
        if(StringUtils.isNotBlank(coupon_amount)){
            model.addAttribute("coupon_amount", coupon_amount);
        }else{
            model.addAttribute("coupon_amount", "0");
        }
        // 券链接
        String coupon_share_url = request.getParameter("coupon_share_url");
        if(StringUtils.isNotBlank(coupon_share_url)){
            model.addAttribute("coupon_share_url", coupon_share_url);
        }else {
            model.addAttribute("coupon_share_url", "");
        }
        // 淘客链接
        String click_url = request.getParameter("click_url");
        if(StringUtils.isNotBlank(click_url)){
            model.addAttribute("click_url", click_url);
        }else {
            model.addAttribute("click_url", "");
        }
        // 推荐理由
        String item_description = request.getParameter("item_description");
        if(StringUtils.isNotBlank(item_description)){
            model.addAttribute("item_description", item_description);
        }else {
            model.addAttribute("item_description", "");
        }

        // 分享方案  推荐理由、口令需要后续添加
//        String copyTxt = shopGoods.getTitle() + "\n----------\n券后￥"+shopGoods.getZkFinalPrice()+"【优惠券"+shopGoods.getCouponInfo()+"元】\n原价￥"+shopGoods.getReservePrice() + (shopTxt==null?"":"【"+shopTxt+"】")+"\n----------\n推荐理由：大包装，全家一起泡，可以使用100次的艾草泡脚包，独立包装，吸湿暖足，排毒养颜，缓解疲劳，改善失眠，舒缓护理，家庭养生必备佳品，天然量多，效果好。\n----------\n￥joxNbkGCkNZ￥复制这条信息，打开手机淘宝即可领券";
//        model.addAttribute("copyTxt", copyTxt);
        model.addAttribute("platform", platform);

        model.addAttribute("tkl", StringUtils.isNotBlank(tkl) ? tkl : "");

        model.addAttribute("item_id", item_id);

        return thymeleaf("/goodsInfo");
    }

    /**
     * 推荐页的商品详情
     * @param i 淘宝商品id
     * @param p 1:PC，2:无线
     * @param u 用户id
     * @param t 淘口令
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/toTGGD", method = RequestMethod.GET)
    public String toGoodsDetailTG(String i, String p, Integer u, String t, Model model, HttpServletRequest request) {

        model.addAttribute("itemId", i);
        model.addAttribute("platform", p);
        model.addAttribute("userid", u);
        model.addAttribute("tkl", t);

        return thymeleaf("/goodsDetailTG");
    }

    /**
     * 商品详情图片(推荐商品详情页)
     * @param itemId 淘宝商品id
     * @param request
     * @return
     */
    @RequestMapping(value = "/goodsDetailTG", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> goodsDetailTG(String itemId, Long platform, HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("success", false);

        Map<String, Object> itemInfo = shopGoodsService.tbkItemInfoGet(itemId, platform,null);
        boolean flag = (boolean)itemInfo.get("success");

        // 调用淘宝接口，获取主图列表
        List<String> pics = new ArrayList<String>();
        if(flag){
            JSONArray nTbkItem = (JSONArray)itemInfo.get("nTbkItem");
            if(nTbkItem != null && nTbkItem.size() > 0){
                JSONObject info = nTbkItem.getJSONObject(0);
                pics.add(info.getString("pict_url"));
                JSONObject smallImages = info.getJSONObject("small_images");
                if(smallImages != null){
                    JSONArray smalls = smallImages.getJSONArray("string");
                    if(smalls != null && smalls.size() > 0) {
                        for (int m = 0; m < smalls.size(); m++) {
                            pics.add(smalls.getString(m));
                        }
                    }
                }
            }
        }

        List<String> detailPics = new ArrayList<String>();

        ShopDetailImgUrlExample example = new ShopDetailImgUrlExample();
        example.or().andItemIdEqualTo(itemId);
        List<ShopDetailImgUrl> list = shopDetailImgUrlService.selectByExample(example);
        if(list != null && list.size() > 0){
            String imgUrl = list.get(0).getImgUrl();
            detailPics = getDetailImgs(imgUrl);
        }

        params.put("pics", pics);
        params.put("detailPics", detailPics);
        params.put("success", true);
        return params;
    }

    /**
     * 商品详情图片
     * @param itemId 淘宝商品id
     * @param userType 0:淘宝，1:天猫
     * @param clickUrl 淘宝客商品链接
     * @param request
     * @return
     */
    @RequestMapping(value = "/goodsTBTP", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> goodsTBTP(String itemId, Integer userType, String clickUrl, HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("success", false);

        if(StringUtils.isBlank(itemId)){
            return params;
        }

        // 详情图片的淘宝url
        String imgUrl = null;

        ShopDetailImgUrlExample example = new ShopDetailImgUrlExample();
        example.or().andItemIdEqualTo(itemId);
        List<ShopDetailImgUrl> list = shopDetailImgUrlService.selectByExample(example);

        if(list != null && list.size() > 0){
            imgUrl = list.get(0).getImgUrl();
        }else{

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
                page = wc.getPage(clickUrl);

                pageXml = page.asXml();

                Document doc = Jsoup.parse(pageXml);
                Elements elScripts = doc.getElementsByTag("script");

                if(userType == 0){// 淘宝处理
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
                }else if(userType == 1){//开猫处理
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

            // 抓取的详情图片url添加到数据库
            if(StringUtils.isNotBlank(imgUrl)){
                ShopDetailImgUrl shopDetailImgUrl = new ShopDetailImgUrl();
                shopDetailImgUrl.setCreateDate(new Date());
                shopDetailImgUrl.setModifyDate(new Date());
                shopDetailImgUrl.setItemId(itemId);
                shopDetailImgUrl.setImgUrl(imgUrl);
                shopDetailImgUrlService.insert(shopDetailImgUrl);
            }
        }

        // 获取详情图片数据
        if(StringUtils.isBlank(imgUrl)){
            return params;
        }

        // 记录详情图片url
        List<String> imgsArr = getDetailImgs(imgUrl);

        if(imgsArr.size() > 0){
            params.put("imgsArr", imgsArr);
            params.put("success", true);
        }
        return params;
    }

    /**
     * 请求详情图片的地址
     * @param imgUrl
     * @return
     */
    public List<String> getDetailImgs(String imgUrl){

        List<String> imgsArr = new ArrayList<String>();

        String respStr = null;
        HttpGet httpGet = null;
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        try {
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
            httpClient = HttpClients.createDefault();
            httpGet = new HttpGet(imgUrl);
            httpGet.setConfig(requestConfig);
            httpResponse = httpClient.execute(httpGet);

            int status_code = httpResponse.getStatusLine().getStatusCode();

            if(status_code == HttpStatus.SC_OK){
                HttpEntity entity = httpResponse.getEntity();
                if(entity != null){
                    respStr = EntityUtils.toString(entity, "UTF-8");
                }
                EntityUtils.consume(entity);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(httpGet != null){httpGet.releaseConnection();}
            if(httpResponse != null){try { httpResponse.close();} catch(IOException e) { e.printStackTrace();}}
            if(httpClient != null){try {httpClient.close();} catch(IOException e) {e.printStackTrace();}}
        }
        // 获取详情图片src属性
        Document doc = Jsoup.parse(respStr);
        Elements imgs = doc.getElementsByTag("img");
        for(Element img : imgs){
            imgsArr.add(img.attr("src"));
        }

        return imgsArr;
    }

    /**
     * 商品评价(未实现，抓取评价抓取困难)
     * @param pjUrl 评价url
     * @param request
     * @return
     */
    @RequestMapping(value = "/goodsTBPJ", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> goodsTBPJ(String pjUrl, HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("success", false);

        List<String> imgsArr = new ArrayList<String>();
        // 获取详情图片地址
        try {

            // 天猫抓取详情图片
            Document doc = Jsoup.connect(pjUrl).ignoreContentType(true).get();
            System.out.println(doc.data().toString());
            params.put("TBPJ",doc.data().toString());
            params.put("success", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return params;
    }

    /**
     * 获取淘口令
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/goodsTPwd", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> goodsTPwd(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> params = new HashMap<String, Object>();

        String url = request.getParameter("url");
        if(StringUtils.isNotBlank(url)){
            params.put("url", url);
        }
        String text = request.getParameter("text");
        if(StringUtils.isNotBlank(text)){
            params.put("text", text);
        }
        String user_id = request.getParameter("user_id");
        if(StringUtils.isNotBlank(user_id)){
            params.put("user_id", user_id);
        }
        String logo = request.getParameter("logo");
        if(StringUtils.isNotBlank(logo)){
            params.put("logo", logo);
        }
        Object o = request.getSession().getAttribute("upmsuser");
        UpmsUser upmsUser = null;
        if(o != null){
            upmsUser = (UpmsUser)o;
            upmsUser = shopUserService.selectUpmsUserByUsername(upmsUser.getUsername());
        }
        if(upmsUser != null){
//            params.put("ext", "{'user':'123aaa'}");
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            params.put("ext", "{\"outer_trade_code\":\""+"NO_"+upmsUser.getUserId()+"_" +format.format(new Date())+"\"}");
        }
        Map<String, Object> m = shopGoodsService.getTKL(params);
        if(upmsUser != null){
            m.put("isLogin", true);
        }else{
            m.put("isLogin", false);
        }
        return m;
    }

    /**
     * 转向查询页,get请求
     * @param request 查询条件
     * @param model
     * @return
     */
    @RequestMapping(value = "/toSearch", method = RequestMethod.POST)
    public String toSearch(HttpServletRequest request, Model model) {

        String q = request.getParameter("q");
        if(StringUtils.isNotBlank(q)){
            model.addAttribute("q", q);
        }
        String platform = request.getParameter("platform");
        if(StringUtils.isNotBlank(platform)){
            model.addAttribute("platform", platform);
        }

        return thymeleaf("/search");
    }

    /**
     * 生成推广
     * @param shopGood
     * @param shopType
     * @param model
     * @param request
     * @param response
     */
    @RequestMapping(value = "/haibao", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> haibao(ShopGoods shopGood, Boolean freeShipment, String tkl, String shopType, Integer platform, Model model, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", false);

        tkl = tkl.replaceAll("￥", "");

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String date = format.format(new Date());

        Object o = request.getSession().getAttribute("upmsuser");
        Integer userId = 0;
        UpmsUser upmsuser = null;
        if(o != null){
            upmsuser = (UpmsUser)o;
            userId = upmsuser.getUserId();
        }

        // 项目根路径，绝对路径
        String proPath = request.getSession().getServletContext().getRealPath("");

        String ip = "www.16office.com";
//        String ip = "192.168.0.105";//内网IP(测试用)，上线要改为域名
        int port = request.getLocalPort();
        // 商品推广二维码
        String qrCode = "http://" + ip + ":" + port + "/goods/toTGGD?i="+shopGood.getItemId()+"&p=" + platform + "&u=" + userId + "&t=" + tkl;

        // 分享图片名称
        String haibaoKey = "goods_" + date + "_" + userId + "_" + shopGood.getItemId() + "_" + tkl;

        // 生成的分享图片
        String targetImg = "/resources/images/tuiguang/"+haibaoKey+".jpg";

        long start = System.currentTimeMillis();
        String targetTemp = proPath + targetImg;
        File temp = new File(targetTemp);
        if(!temp.exists()){

            try {
                // 商品主图保存到本地
                String mainImgTemp = proPath + "/resources/images/"+haibaoKey+".tmp";
                File mainImgF = new File(mainImgTemp);
                if(!mainImgF.exists()){
                    mainImgF.createNewFile();
                }

                // 请求商品主图并写入临时商品文件
                HttpGet httpGet = null;
                CloseableHttpClient httpClient = null;
                CloseableHttpResponse httpResponse = null;
                FileOutputStream outMainImg = null;
                try {
                    RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
                    httpClient = HttpClients.createDefault();
                    httpGet = new HttpGet(shopGood.getPictUrl());
                    httpGet.setConfig(requestConfig);
                    httpResponse = httpClient.execute(httpGet);
                    InputStream in = httpResponse.getEntity().getContent();

                    outMainImg = new FileOutputStream(mainImgF);
                    byte[] buffer = new byte[2048];
                    int len = 0;
                    while((len=in.read(buffer)) != -1 ){
                        outMainImg.write(buffer, 0, len);
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(outMainImg != null){try { outMainImg.close();} catch(IOException e) { e.printStackTrace();}}
                    if(httpGet != null){httpGet.releaseConnection();}
                    if(httpResponse != null){try { httpResponse.close();} catch(IOException e) { e.printStackTrace();}}
                    if(httpClient != null){try {httpClient.close();} catch(IOException e) {e.printStackTrace();}}
                }

                String title = shopGood.getTitle();// 标题
                BigDecimal yjPrice = shopGood.getZkFinalPrice();// 原价
                String volume = shopGood.getVolume().toString();// 30天销量
                BigDecimal quan = shopGood.getCouponAmount();
                BigDecimal zkPrice = yjPrice;// 折扣价
                try{
                    zkPrice = zkPrice.subtract(quan);
                }catch (Exception e){

                }

                int width = 640;
                int height = 986;
                BufferedImage imageNew = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics2D g = imageNew.createGraphics();

                // 填充背景色：白色
                Color color = Color.white;
                g.setColor(color);
                g.fillRect(0,0, width, height);

                // 商品主图
                BufferedImage mainImgBuf = ImageIO.read(mainImgF);
                int mainW = mainImgBuf.getWidth();
                int mainH = mainImgBuf.getHeight();
                int tempW = 640;
                int tempH = mainH * tempW / mainW;
                if(tempH > 640){
                    tempH = 640;
                    tempW = mainW * tempH / mainH;
                }
                g.drawImage(mainImgBuf, 0, 0, tempW, tempH, null);
                mainImgF.delete();

                // 店铺类型
                if(shopType != null){
                    if(shopType.equals("1")){ // 天猫
                        String tianmaoTmp = proPath + "/resources/images/base/icon_tianmao.png";
                        BufferedImage tianmaoIcon = ImageIO.read(new File(tianmaoTmp));
                        g.drawImage(tianmaoIcon, 20, tempH + 25, 40, 40, null);
                    }else if(shopType.equals("0")){ // 淘宝
                        String tiaobaoTmp = proPath + "/resources/images/base/icon_taobao.png";
                        BufferedImage tiaobaoTmpIcon = ImageIO.read(new File(tiaobaoTmp));
                        g.drawImage(tiaobaoTmpIcon, 20, tempH + 25, 40, 40, null);
                    }
                }else{// 没有店铺类型时的默认图标
                    String morenTmp = proPath + "/resources/images/base/icon_moren.png";
                    BufferedImage morenTmpIcon = ImageIO.read(new File(morenTmp));
                    g.drawImage(morenTmpIcon, 20, tempH + 25, 40, 40, null);
                }

                // 二维码
                BufferedImage qrCodeImg = QRCodeUtil.encodeToBufferedImage(qrCode, BarcodeFormat.QR_CODE,190,190);
                if(qrCodeImg != null){
                    g.drawImage(qrCodeImg,null, 440,tempH + 10);
                }

                // 长按识别二维码，免费领券
                Font font = new Font("黑体 常规", Font.PLAIN, 24);
                color = Color.black;
                g.setColor(color);
                g.setFont(font);
                g.drawString("长按识别二维码", 450,tempH +205);
                color = new Color(251, 67, 62);
                g.setColor(color);
                g.drawString("免费领券", 485,tempH +240);

                // 标题
                font = new Font("黑体 常规", Font.PLAIN, 26);
                g.setFont(font);
                color = new Color(55,55,55);
                g.setColor(color);
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int line = 0;
                int lenW = 0;
                int charNum = 0;
                FontMetrics fm = g.getFontMetrics(font);
                for(int i = 0; i < title.length(); i++){
                    lenW = fm.charWidth(title.charAt(i)) + lenW;
                    if(line == 0){ // 首行缩进
                        if(lenW >= 364){
                            g.drawString(title.substring(charNum, i), 76,tempH + 60);
                            charNum = i;
                            lenW = 0;
                            line++;
                        }
                    }else{
                        if(lenW >= 416){
                            g.drawString(title.substring(charNum, i), 20,(tempH + 60) + (40 * line));
                            charNum = i;
                            lenW = 0;
                            line++;
                        }
                    }
                }
                if(title.substring(charNum).length() > 0){ // 最后一行不够整行宽度时，for循环不打印最后一行
                    g.drawString(title.substring(charNum), 20,(tempH + 60) + (40 * line));
                }
                // 折扣价
                color = new Color(255, 68, 0);
                g.setColor(color);
                font = new Font("黑体 常规", Font.PLAIN, 25);
                g.setFont(font);
                g.drawString("券后", 20,(tempH + 60) + (35 * line) + 60);
                font = new Font("黑体 常规", Font.PLAIN, 30);
                g.setFont(font);
                String zkPriceStr = "¥ "+zkPrice;
                g.drawString(zkPriceStr, 80,(tempH + 60) + (35 * line) + 63);

                // 是否包邮
                if(freeShipment){
                    fm = g.getFontMetrics(font);
                    int baoyouW = fm.stringWidth(zkPriceStr);
                    g.fillRect(80 + baoyouW + 20, (tempH + 60) + (35 * line) + 40,46, 26);
                    font = new Font("黑体 常规", Font.BOLD, 18);
                    g.setFont(font);
                    color = Color.white;
                    g.setColor(color);
                    g.drawString("包邮", 80 + baoyouW + 20 + 4,(tempH + 60) + (35 * line) + 59);
                }

                // 原价
                color = new Color(95, 95, 95);
                g.setColor(color);
                font = new Font("黑体 常规", Font.PLAIN, 22);
                g.setFont(font);
                g.drawString("原价", 20,(tempH + 60) + (35 * line) + 105);
                String yjPriceStr = "¥ "+yjPrice;
                g.drawString(yjPriceStr, 75,(tempH + 60) + (35 * line) + 107);
                // 原价删除线
                fm = g.getFontMetrics(font);
                int delLineW = fm.stringWidth(yjPriceStr);
                g.drawLine(74,(tempH + 60) + (35 * line) + 100, 74 + delLineW,(tempH + 60) + (35 * line) + 100);
                g.drawLine(75,(tempH + 60) + (35 * line) + 100, 75 + delLineW,(tempH + 60) + (35 * line) + 100);

                // 券宽度
                int quanW = fm.stringWidth(quan.toString());
                // 月销量
                font = new Font("黑体 常规", Font.PLAIN, 20);
                g.setFont(font);
                g.drawString("月销" + volume + "件", 75 + delLineW + quanW + 90,(tempH + 60) + (35 * line) + 105);

                // 券
                color = new Color(255, 68, 0);
                g.setColor(color);
                g.fillRoundRect(75 + delLineW + 10, (tempH + 60) + (35 * line) + 85, 30,26, 5, 5);
                g.drawRoundRect(75 + delLineW + 36,(tempH + 60) + (35 * line) + 85,quanW + 36,25,5,5);
                font = new Font("黑体 常规", Font.BOLD, 18);
                g.setFont(font);
                color = Color.white;
                g.setColor(color);
                g.drawString("券", 75 + delLineW + 16,(tempH + 60) + (35 * line) + 105);
                font = new Font("黑体 常规", Font.PLAIN, 18);
                g.setFont(font);
                color = new Color(255, 68, 0);
                g.setColor(color);
                g.drawString("元", 75 + delLineW + 48 + quanW,(tempH + 60) + (35 * line) + 103);
                g.drawString(quan.toString(), 75 + delLineW + 48,(tempH + 60) + (35 * line) + 105);

                // 底部
                color = new Color(255, 207, 207);
                g.setColor(color);
                g.fillRect(0, height - 60, width,60);
                color = new Color(155, 55, 55);
                g.setColor(color);
//                font = new Font("楷体 常规", Font.BOLD + Font.ITALIC, 30);
                font = new Font("叶根友毛笔行书2.0版 常规", Font.BOLD, 30);
                g.setFont(font);
                String dbTxt = "粉丝福利优惠券，别的地方看不到哦";
                fm = g.getFontMetrics(font);
                int dbW = fm.stringWidth(dbTxt);
                g.drawString(dbTxt, (width - dbW ) / 2,height - 20);
                File outputfile = new File(targetTemp);
                outputfile.createNewFile();
                ImageIO.write(imageNew,"jpg", outputfile);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("生成海报共耗时：[" + (System.currentTimeMillis() - start) + "]毫秒");
        result.put("url", targetImg);
        result.put("success", true);
        return result;
    }

    /**
     * 大额券
     * @param request
     * @return
     */
    @RequestMapping(value = "/deq", method = RequestMethod.GET)
    public String deq(Model model, HttpServletRequest request) {
        String q = request.getParameter("q");
        if(StringUtils.isNotBlank(q)){
            model.addAttribute("q", q);
        }else{
            model.addAttribute("q", "");
        }
        String platform = request.getParameter("platform");
        if(StringUtils.isNotBlank(platform)){
            model.addAttribute("platform", platform);
        }else{
            model.addAttribute("platform", "");
        }
        String material_id = request.getParameter("material_id");
        if(StringUtils.isNotBlank(material_id)){
            model.addAttribute("material_id", material_id);
        }else{
            model.addAttribute("material_id", "");
        }
        String sort = request.getParameter("sort");
        if(StringUtils.isNotBlank(sort)){
            model.addAttribute("sort", sort);
        }else{
            model.addAttribute("sort", "");
        }
        String has_coupon = request.getParameter("has_coupon");
        if(StringUtils.isNotBlank(has_coupon)){
            model.addAttribute("has_coupon", has_coupon);
        }else{
            model.addAttribute("has_coupon", "");
        }
        String menuName = request.getParameter("menuName");
        if(StringUtils.isNotBlank(menuName)){
            model.addAttribute("menuName", menuName);
        }else{
            model.addAttribute("menuName", "");
        }
        return thymeleaf("/a-deq");
    }

    /**
     * 淘抢购
     * @param request
     * @return
     */
    @RequestMapping(value = "/tqg", method = RequestMethod.GET)
    public String tqg(Model model, HttpServletRequest request) {
        String sort = request.getParameter("sort");
        if(StringUtils.isNotBlank(sort)){
            model.addAttribute("sort", sort);
        }else{
            model.addAttribute("sort", "");
        }
        return thymeleaf("/tqg");
    }

    /**
     * 淘抢购商品查询
     * @param pageNum
     * @param pageSize
     * @param sort
     * @param request
     * @return
     */
    @RequestMapping(value = "/loadTQGGoods", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> loadTQGGoods(Long pageNum, Long pageSize, String sort, HttpServletRequest request) {
        Map<String, Object> m = shopGoodsService.tbkJuTqgGet(pageNum, pageSize);
        return m;
    }


    // *******************************************************************************************************************************

    /**
     * 获取内网ip
     */
    public static String getLocalIp() {
        String localip = null;// 本地IP，如果没有配置外网IP则返回它
        String netip = null;// 外网IP
        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            boolean finded = false;// 是否找到外网IP
            while (netInterfaces.hasMoreElements() && !finded) {
                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> address = ni.getInetAddresses();
                while (address.hasMoreElements()) {
                    ip = address.nextElement();
                    if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
                        netip = ip.getHostAddress();
                        System.out.println("外网IP：" + netip);
                        finded = true;
                        break;
                    } else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 内网IP
                        localip = ip.getHostAddress();
                        System.out.println("内网IP：" + localip);
                    }

                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        if (netip != null && !"".equals(netip)) {
            return netip;
        } else {
            return localip;
        }
    }

    // 加载数据库商品 start *******************************************************************************************************
    @Autowired
    private ShopMenuService shopMenuService;

    public static List<ShopMenu> menus = new ArrayList<ShopMenu>();
    public static List<ShopModule> modules = new ArrayList<ShopModule>();

    /**
     * 转向数据库商品-首页
     * @param model
     * @param sId
     * @param type
     * @param request
     * @return
     */
    @RequestMapping(value = "localGoods", method = RequestMethod.GET)
    public String localGoods(Model model, Long sId, Integer type, HttpServletRequest request) {

        /** 后面要放到缓存中 start */
        if(menus.size() <= 0){
            // 查询导航栏列表: 首页、男装、女装等
            ShopMenuExample shopMenuE = new ShopMenuExample();
            shopMenuE.or().andIsEnabledEqualTo(true);
            shopMenuE.setOrderByClause("sort ASC");
            menus = shopMenuService.selectByExample(shopMenuE);
        }
        int size = 7;
        if(menus.size() < size){
            size = menus.size();
        }
        model.addAttribute("menus", menus);
        model.addAttribute("menusSize", size);
        model.addAttribute("sId", sId == null ? 1L : sId);
        model.addAttribute("type", type == null ? 1 : type);

        // 查询模块列表: 淘抢购、聚划算、拼多多、京东等
        if(modules.size() <= 0){
            ShopModuleExample shopModuleE = new ShopModuleExample();
            shopModuleE.or().andIsEnabledEqualTo(true);
            shopModuleE.setOrderByClause("sort ASC");
            modules = shopModuleService.selectByExample(shopModuleE);
        }
        model.addAttribute("modules", modules);
        /** 后面要放到缓存中 end */

        String platform = request.getParameter("platform");
        if(StringUtils.isNotBlank(platform)){
            model.addAttribute("platform", platform);
        }else{
            model.addAttribute("platform", 2);
        }

        return thymeleaf("/local_index");
    }

    /**
     * 加载数据库商品, ajax请求
     * @param pageNum 第几页
     * @param pageSize 每页多少条
     * @return
     */
    @RequestMapping(value = "/loadLocalGoods", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> loadLocalGoods(Integer pageNum, Integer pageSize, Integer type, String field, String sort, String des, String title) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("success", false);

        ShopGoodsExample example = new ShopGoodsExample();
        ShopGoodsExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(title)){
            criteria.andTitleLike(title);
        }
        if(StringUtils.isNotBlank(field)){
            if(field.equals("hqzb")){
                if(type == null || type == 1){
                    criteria.andHqzbTypeGreaterThan(0);
                }else{
                    criteria.andHqzbTypeEqualTo(type);
                }
            }else if(field.equals("deq")){
                if(type == null || type == 1){
                    criteria.andDeqTypeGreaterThan(0);
                }else{
                    criteria.andDeqTypeEqualTo(type);
                }
            }else if(field.equals("gyb")){
                if(type == null || type == 1){
                    criteria.andGybTypeGreaterThan(0);
                }else{
                    criteria.andGybTypeEqualTo(type);
                }
            }else if(field.equals("ppq")){
                if(type == null || type == 1){
                    criteria.andPpqTypeGreaterThan(0);
                }else{
                    criteria.andPpqTypeEqualTo(type);
                }
            }else if(field.equals("myzt")){
                if(type == null || type == 1){
                    criteria.andMyztTypeGreaterThan(0);
                }else{
                    criteria.andMyztTypeEqualTo(type);
                }
            }else if(field.equals("jhs")){
                if(type == null || type == 1){
                    criteria.andJhsTypeGreaterThan(0);
                }else{
                    criteria.andJhsTypeEqualTo(type);
                }
            }else if(field.equals("yhh")){
                if(type == null || type == 1){
                    criteria.andYhhTypeGreaterThan(0);
                }else{
                    criteria.andYhhTypeEqualTo(type);
                }
            }else if(field.equals("clf")){
                if(type == null || type == 1){
                    criteria.andClfTypeGreaterThan(0);
                }else{
                    criteria.andClfTypeEqualTo(type);
                }
            }else if(field.equals("th")){
                if(type == null || type == 1){
                    criteria.andThTypeGreaterThan(0);
                }else{
                    criteria.andThTypeEqualTo(type);
                }
            }
        }
        if(StringUtils.isNotBlank(sort)){
            String order = "";
            if(sort.equals("volume")){
                order = "volume ";
            }else if(sort.equals("price")){
                order = "zk_final_price ";
            }else{
                order = "modify_date ";
            }
            if(StringUtils.isNotBlank(des) && des.equals("asc")){
                order += "asc";
            }else{
                order += "desc";
            }
            example.setOrderByClause(order);
        }else{
            example.setOrderByClause("modify_date asc");
        }

        List<ShopGoods> goods = shopGoodsService.selectByExampleForStartPage(example, pageNum, pageSize);
        params.put("data", goods);
        params.put("success", true);
        return params;
    }

    /**
     * 商品详情
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/localGoodsDetail", method = RequestMethod.GET)
    public String localCoupon(String itemId, String platform, Model model, HttpServletRequest request) {

        // 商品
        ShopGoodsExample example = new ShopGoodsExample();
        example.or().andItemIdEqualTo(itemId);
        ShopGoods goods = shopGoodsService.selectFirstByExample(example);
        model.addAttribute("goods", goods);

        Object o = request.getSession().getAttribute("upmsuser");
        Integer userId = 0;
        UpmsUser upmsuser = null;
        if(o != null){
            upmsuser = (UpmsUser)o;
            userId = upmsuser.getUserId();
        }
        model.addAttribute("userId", userId);
        model.addAttribute("platform", platform);

        return thymeleaf("/local_goodsInfo");
    }

    /**
     * 子模块，好券直播、大额券等
     * @param model
     * @param response
     * @return
     */
    @RequestMapping(value = "/localCoupon", method = RequestMethod.GET)
    public String localCoupon(Long i, Integer p, String t, Model model, HttpServletResponse response) {

        if(i != null){
            model.addAttribute("p", p);// platform
            model.addAttribute("t", t);// platform
            ShopModuleExample me = new ShopModuleExample();
            me.or().andIdEqualTo(i);
            List<ShopModule> modules = shopModuleService.selectByExample(me);
            if(modules != null && modules.size() == 1){
                model.addAttribute("module", modules.get(0));

                ShopModuleItemExample e = new ShopModuleItemExample();
                e.or().andModuleIdEqualTo(i);
                List<ShopModuleItem> items = shopModuleItemService.selectByExample(e);
                model.addAttribute("items", items);
                return thymeleaf("/local_coupon");
            }
        }

        try {
            response.sendRedirect("/goods/localGoods");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    // 加载数据库商品 end *******************************************************************************************************

}
