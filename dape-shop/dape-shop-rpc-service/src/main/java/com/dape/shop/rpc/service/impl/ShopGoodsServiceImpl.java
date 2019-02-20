package com.dape.shop.rpc.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.shop.dao.mapper.ShopGoodsMapper;
import com.dape.shop.dao.model.ShopGoods;
import com.dape.shop.dao.model.ShopGoodsExample;
import com.dape.shop.rpc.api.ShopGoodsService;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.*;
import com.taobao.api.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* ShopGoodsService实现
* Created by dape on 2018/11/17.
*/
@Service
@Transactional
@BaseService
public class ShopGoodsServiceImpl extends BaseServiceImpl<ShopGoodsMapper, ShopGoods, ShopGoodsExample> implements ShopGoodsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopGoodsServiceImpl.class);

    @Autowired
    ShopGoodsMapper shopGoodsMapper;

    private final static Long ADZONE_ID = 96030450186L;

    private static TaobaoClient tobaoClient = null;

    static {
        if(tobaoClient == null){
            // 正式环境
            tobaoClient = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "25632498", "51e06e43ebc6f093579131f6c7fcd568");
        }
    }

    public static void main(String[] args){

        try {

            // mm_323040055_331400082_96030450186
            TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "25632498", "51e06e43ebc6f093579131f6c7fcd568");


//            TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
//            req.setUserId("123");
//            req.setText("雨伞男女全自动开收大号双人三折折叠加固晴雨两用学生加大号定制");
//            req.setUrl("https://uland.taobao.com/coupon/edetail?e=kU1HVf9BxHYNfLV8niU3RwXoB%2BDaBK5LQS0Flu%2FfbSp4QsdWMikAalrisGmre1Id522H2TxuqpIJs1xX5zzxBxtTvtpwq94UTSvQvC0XMdUyi8r%2FB5H5eHl3bPxl2zv9iHBrMsahiyvIxzSW1FdMgZbV2%2BrO1tknA8r4sORx2%2FLKhCDdY44lU3cfn8oOafsLFF6O9STo8Qg7mmMWJDI59WUFFgz3RBVH&&app_pvid=59590_11.23.60.3_70141_1550392042601&ptl=floorId:2836;app_pvid:59590_11.23.60.3_70141_1550392042601;tpp_pvid:100_11.139.177.84_32849_6991550392042606598&xId=bUVQ5IkDtYIGtzLLfTUHpVSCSRka4jpY7dTgJw9Do2djpvkpc9WBxkjFhCDoRWPVtLLVZM6qHRRzmilUY1b3cN&union_lens=lensId:0b173c03_0c11_168fa9124ab_05f7");
//            req.setExt("{aaa:1}");

//            req.setNumIids("584574208203");
            TbkDgOptimusMaterialRequest req = new TbkDgOptimusMaterialRequest();
            req.setPageSize(20L);
            req.setAdzoneId(ADZONE_ID);
            req.setPageNo(1L);

            TbkDgOptimusMaterialResponse rsp = client.execute(req);


            System.out.println("*********************");
            System.out.println(rsp.getBody());
            System.out.println("*********************");
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * 导入数据到粉淘数据库
     * 淘宝客物料下行-导购:taobao.tbk.dg.optimus.material
     * @param totalPage:查询的总页数
     * @param pageSize:每页的总条数
     */
    @Override
    public Integer exportTbkDgOptimusMaterial(int totalPage, Long pageSize, String url, String appKey, String secret, Long adzoneId, String[] materialIds){

        int saveNum = 0;//记录保存到数据的总条数

        ShopGoods goods = null;
        BigDecimal couponA = new BigDecimal("20");//券额大于19的保存到数据库
        BigDecimal floatA = new BigDecimal("0.3");//券点折扣价的30%的保存到数据库

        TaobaoClient client = new DefaultTaobaoClient(url, appKey, secret);
        TbkDgOptimusMaterialRequest req = null;
        query:for(int i = 0; i < totalPage; i++){
            material:for(String item : materialIds){
                Long materialId = null;
                try{
                    materialId = Long.valueOf(item);
                }catch (Exception e){
                    break material;
                }
                req = new TbkDgOptimusMaterialRequest();
                req.setPageSize(pageSize);
                req.setAdzoneId(adzoneId);
                req.setPageNo(Long.valueOf(i));
                req.setMaterialId(materialId);

                try {
                    TbkDgOptimusMaterialResponse rsp = client.execute(req);
                    String resultJson = rsp.getBody();

                    // 返回结果转json
                    JSONObject jsonObject = JSON.parseObject(resultJson);
                    JSONObject tbkDgOptimusMaterialResponse = jsonObject.getJSONObject("tbk_dg_optimus_material_response");// 各个接口的结果集字段不一样
                    JSONObject errorResponse = jsonObject.getJSONObject("error_response");

                    if(errorResponse != null){//返回错误
                        String subMsg = errorResponse.getString("sub_msg");
                        continue material;
                    }else if(tbkDgOptimusMaterialResponse != null){//查询成功
                        String requestId = tbkDgOptimusMaterialResponse.getString("request_id");
                        JSONObject resultList = tbkDgOptimusMaterialResponse.getJSONObject("result_list");
                        JSONArray mapData = resultList.getJSONArray("map_data");
                        if(mapData == null || mapData.size() <= 0){
                            break;
                        }
                        save:for(int j = 0; j < mapData.size(); j++){
                            JSONObject data = mapData.getJSONObject(j);

                            String zkFinalPriceStr = data.getString("zk_final_price");//折扣价(未摔扣减券额)
                            String couponAmountStr = data.getString("coupon_amount");//折扣价(未摔扣减券额)
                            BigDecimal zkFinalPrice = new BigDecimal(zkFinalPriceStr);
                            BigDecimal couponAmount = new BigDecimal(couponAmountStr);

                            if(couponAmount.divide(zkFinalPrice, 2, BigDecimal.ROUND_HALF_DOWN).compareTo(floatA) == -1){
                                continue save;
                            }else if(couponAmount.compareTo(couponA) == -1){
                                continue save;
                            }

                            goods = new ShopGoods();
                            goods.setCreateDate(new Date());//导入时间
                            goods.setItemId(data.getString("item_id"));//商品id
                            goods.setTitle(data.getString("title"));//标题
                            goods.setShortTitle(data.getString("short_title"));//商品短标题
                            goods.setPictUrl(data.getString("pict_url"));//主图
                            JSONObject smallImagesObj = data.getJSONObject("small_images");//小图数组
                            String small_images = "";
                            if(smallImagesObj != null){
                                JSONArray smalls = smallImagesObj.getJSONArray("string");
                                if(smalls != null && smalls.size() > 0){
                                    for(int m = 0; m < smalls.size(); m++){
                                        small_images += smalls.getString(m);
                                        if(m < smalls.size()){
                                            small_images += ",";
                                        }
                                    }
                                    goods.setSmallImages(small_images);
                                }
                            }
                            goods.setZkFinalPrice(zkFinalPrice);//折扣价(未摔扣减券额)
                            goods.setUserType(data.getInteger("user_type"));//卖家类型，0表示集市，1表示商城
                            goods.setClickUrl(data.getString("click_url"));//淘客链接
                            goods.setShopTitle(data.getString("shop_title"));//卖家昵称
                            goods.setSellerId(data.getString("seller_id"));//卖家id
                            goods.setItemDescription(data.getString("item_description"));//推荐理由
                            goods.setVolume(data.getInteger("volume"));//30天销量
                            goods.setCouponClickUrl(data.getString("coupon_click_url"));//券链接
                            goods.setCouponAmount(couponAmount);//券额
                            goods.setCouponTotalCount(data.getInteger("coupon_total_count"));//券总量
                            goods.setCouponRemainCount(data.getInteger("coupon_remain_count"));//优惠券剩余量
                            goods.setCouponStartFee(data.getString("coupon_start_fee"));//券起用门槛,满X元可用
                            goods.setCouponStartTime(data.getString("coupon_start_time"));//优惠券开始时间
                            goods.setCouponEndTime(data.getString("coupon_end_time"));//优惠券结束时间
                            goods.setSellerId(data.getString("seller_id"));//卖家id
                            goods.setShopTitle(data.getString("shop_title"));//店铺名称
                            goods.setUserType(data.getInteger("user_type"));//卖家类型，0表示集市，1表示商城
                            goods.setCategoryId(data.getString("category_id"));//叶子类目id
                            goods.setCategoryName(data.getString("category_name"));//叶子类目名称
                            goods.setLevelOneCategoryId(data.getString("level_one_category_id"));//一级类目ID
                            goods.setLevelOneCategoryName(data.getString("level_one_category_name"));//一级类目名称
                            goods.setLevelOneCategoryName(data.getString("level_one_category_name"));//一级类目名称
                            goods.setStock(data.getInteger("stock"));//拼团：剩余库存
                            goods.setSellNum(data.getInteger("sell_num"));//拼团：已售数量
                            goods.setTotalStock(data.getInteger("total_stock"));//拼团：库存数量
                            goods.setOstime(data.getString("ostime"));//拼团：开始时间
                            goods.setOetime(data.getString("oetime"));//拼团：结束时间
                            goods.setJddNum(data.getInteger("jdd_num"));//拼团：几人团
                            goods.setJddPrice(data.getString("jdd_price"));//拼团：拼成价，单位元
                            goods.setOrigPrice(data.getString("orig_price"));//一人价（原价)，单位元
                            goods.setCommissionRate(data.getString("commission_rate"));//一人价（原价)，单位元
                            JSONObject wordListObj = data.getJSONObject("word_list");
                            if(wordListObj != null){
//                                goods.setWordUrl(data.getString("word_url"));//商品相关关联词落地页地址
//                                goods.setWord(data.getString("关联词"));//商品相关的关联词
                                goods.setWordUrl("关联url");//商品相关关联词落地页地址
                                goods.setWord("关联词");//商品相关的关联词
                            }
                            goods.setTmallPlayActivityInfo(data.getString("tmall_play_activity_info"));//天猫营销玩法
                            goods.setUvSumPreSale(data.getInteger("uv_sum_pre_sale"));//预售数量
                            goods.setxId(data.getString("x_id"));//物料块id(测试中请勿使用)
                            goods.setNewUserPrice(data.getString("new_user_price"));//新人价

                            int result = shopGoodsMapper.insert(goods);
                            saveNum += result;
                            System.out.println("导入条数：" + saveNum);
                        }
                    }

                } catch (ApiException e) {
                    e.printStackTrace();
                    break;
                }
            }

        }
        return saveNum;
    }

    @Override
    public Map<String, Object> loadGoods(Long pageNum, Long pageSize, Map<String, Object> params) {

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", false);

        // 商品接口参数对象，设置参数
        TbkItemGetRequest req = new TbkItemGetRequest();
        req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");

        if(params != null) {
            if (params.containsKey("q")) {//查询词，例：女装
                req.setQ(params.get("q").toString());
            }
            if (params.containsKey("cat")) {//例：16,18(后台类目ID，用,分割，最大10个，该ID可以通过taobao.itemcats.get接口获取到)
                req.setCat(params.get("cat").toString());
            }
            if (params.containsKey("itemloc")) {//杭州(所在地)
                req.setItemloc(params.get("itemloc").toString());
            }
            if (params.containsKey("sort")) {//tk_rate_des(排序_des（降序），排序_asc（升序），销量（total_sales），淘客佣金比率（tk_rate）， 累计推广量（tk_total_sales），总支出佣金（tk_total_commi）)
                req.setSort(params.get("sort").toString());
            }
            if (params.containsKey("is_tmall")) {//是否商城商品
                req.setIsTmall(Boolean.valueOf(params.get("is_tmall").toString()));
            }
            if (params.containsKey("is_overseas")) {//是否海外商品
                req.setIsOverseas(Boolean.valueOf(params.get("is_overseas").toString()));
            }
            if (params.containsKey("platform")) {//链接形式：1：PC，2：无线，默认：１
                req.setPlatform(Long.valueOf(params.get("platform").toString()));
            }
        }

        // 设置pageNum、pageSize
        req.setPageNo(pageNum);
        req.setPageSize(pageSize);

        try {

            // 调用接口
            TbkItemGetResponse rsp = tobaoClient.execute(req);
            String resultJson = rsp.getBody();

            // 返回结果转json
            JSONObject jsonObject = JSON.parseObject(resultJson);
            JSONObject tbkItemGetResponse = jsonObject.getJSONObject("tbk_item_get_response");// 各个接口的结果集字段不一样
            JSONObject errorResponse = jsonObject.getJSONObject("error_response");

            if(errorResponse != null){//返回错误
                String subMsg = errorResponse.getString("sub_msg");
                result.put("msg", subMsg);
            }else if(tbkItemGetResponse != null){//查询成功
                Long total_results = tbkItemGetResponse.getLong("total_results");
                result.put("total", total_results);
                String request_id = tbkItemGetResponse.getString("request_id");
                result.put("requestId", request_id);
                JSONObject results = tbkItemGetResponse.getJSONObject("results");
                JSONArray n_tbk_item = results.getJSONArray("n_tbk_item");
                result.put("nTbkItem", n_tbk_item);
                result.put("success", true);
            }

        } catch (ApiException e) {
            e.printStackTrace();
            result.put("msg", "调用接口异常");
        }
        return result;
    }

    @Override
    public Map<String, Object> loadCouponGoodsBySeach(Long pageNum, Long pageSize, Map<String, Object> params) {

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", false);

        TbkDgMaterialOptionalRequest req = new TbkDgMaterialOptionalRequest();

        req.setAdzoneId(ADZONE_ID);//推广位：要在阿里妈妈后台获取，mm_xxx_xxx_xxx的第三位

        if(params != null) {
            if (params.containsKey("q")) {//查询词，例：女装
                req.setQ(params.get("q").toString());
            }
            if (params.containsKey("cat")) {//16,18	后台类目ID，用,分割，最大10个，该ID可以通过taobao.itemcats.get接口获取到
                req.setCat(params.get("cat").toString());
            }
            if (params.containsKey("platform")) {//链接形式：1：PC，2：无线，默认：１
                req.setPlatform(Long.valueOf(params.get("platform").toString()));
            }
            if (params.containsKey("has_coupon")) {//是否有优惠券
                req.setHasCoupon(Boolean.valueOf(params.get("has_coupon").toString()));
            }
            if (params.containsKey("need_free_shipment")) {//是否包邮
                req.setNeedFreeShipment(Boolean.valueOf(params.get("need_free_shipment").toString()));
            }
            if (params.containsKey("need_prepay")) {//是否加入消费者保障
                req.setNeedPrepay(Boolean.valueOf(params.get("need_prepay").toString()));
            }
            if (params.containsKey("ip")) {//客户端IP
                req.setIp(params.get("ip").toString());
            }
            if (params.containsKey("itemloc")) {//所在地，例：杭州
                req.setItemloc(params.get("itemloc").toString());
            }
            if (params.containsKey("sort")) {//排序
                req.setSort(params.get("sort").toString());//排序_des（降序），排序_asc（升序），销量（total_sales），淘客佣金比率（tk_rate）， 累计推广量（tk_total_sales），总支出佣金（tk_total_commi），价格（price）
            }
            if (params.containsKey("material_id")) {//官方的物料Id，详细物料id见：https://tbk.bbs.taobao.com/detail.html?appId=45301&postId=8576096)，不传时默认为2836
                req.setMaterialId(Long.valueOf(params.get("material_id").toString()));
            }
        }

        // 设置pageNum、pageSize
        req.setPageNo(pageNum);
        req.setPageSize(pageSize);
        try {

            // 调用接口
            TbkDgMaterialOptionalResponse rsp = tobaoClient.execute(req);
            String resultJson = rsp.getBody();

            // 返回结果转json
            JSONObject jsonObject = JSON.parseObject(resultJson);
            JSONObject tbkDgMaterialOptionalResponse = jsonObject.getJSONObject("tbk_dg_material_optional_response");// 各个接口的结果集字段不一样
            JSONObject errorResponse = jsonObject.getJSONObject("error_response");

            if(errorResponse != null){//返回错误
                String subMsg = errorResponse.getString("sub_msg");
                result.put("msg", subMsg);
            }else if(tbkDgMaterialOptionalResponse != null){//查询成功
                Long total_results = tbkDgMaterialOptionalResponse.getLong("total_results");
                result.put("total", total_results);
                String request_id = tbkDgMaterialOptionalResponse.getString("request_id");
                result.put("requestId", request_id);
                JSONObject results = tbkDgMaterialOptionalResponse.getJSONObject("result_list");
                JSONArray mapData = results.getJSONArray("map_data");
                result.put("mapData", mapData);
                result.put("success", true);
            }

        } catch (ApiException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Map<String, Object> loadCouponGoods(Long pageNum, Long pageSize, Map<String, Object> params) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", false);

        TbkDgOptimusMaterialRequest req = new TbkDgOptimusMaterialRequest();

        req.setAdzoneId(ADZONE_ID);//推广位：要在阿里妈妈后台获取，mm_xxx_xxx_xxx的第三位

        if(params != null) {
            if (params.containsKey("item_id")) {//链接形式：1：PC，2：无线，默认：１
                req.setItemId(Long.valueOf(params.get("item_id").toString()));
            }
            if (params.containsKey("content_source")) {//是否包邮
                req.setContentSource(params.get("content_source").toString());
            }
            if (params.containsKey("content_id")) {//是否加入消费者保障
                req.setContentId(Long.valueOf(params.get("content_id").toString()));
            }
            if (params.containsKey("device_type")) {//客户端IP
                req.setDeviceType(params.get("device_type").toString());
            }
            if (params.containsKey("device_encrypt")) {//设备号加密类型：MD5
                req.setDeviceEncrypt(params.get("device_encrypt").toString());
            }
            if (params.containsKey("device_value")) {//设备号加密后的值
                req.setDeviceValue(params.get("device_value").toString());
            }
            if (params.containsKey("material_id")) {//官方的物料Id，详细物料id见：https://tbk.bbs.taobao.com/detail.html?appId=45301&postId=8576096)，不传时默认为2836
                req.setMaterialId(Long.valueOf(params.get("material_id").toString()));
            }
        }

        // 设置pageNum、pageSize
        req.setPageNo(pageNum);
        req.setPageSize(pageSize);
        try {

            // 调用接口
            TbkDgOptimusMaterialResponse rsp = tobaoClient.execute(req);
            String resultJson = rsp.getBody();

            // 返回结果转json
            JSONObject jsonObject = JSON.parseObject(resultJson);
            JSONObject tbkDgOptimusMaterialResponse = jsonObject.getJSONObject("tbk_dg_optimus_material_response");// 各个接口的结果集字段不一样
            JSONObject errorResponse = jsonObject.getJSONObject("error_response");

            if(errorResponse != null){//返回错误
                String subMsg = errorResponse.getString("sub_msg");
                result.put("msg", subMsg);
            }else if(tbkDgOptimusMaterialResponse != null){//查询成功
                Long total_results = tbkDgOptimusMaterialResponse.getLong("total_results");
                result.put("total", total_results);
                String request_id = tbkDgOptimusMaterialResponse.getString("request_id");
                result.put("requestId", request_id);
                JSONObject results = tbkDgOptimusMaterialResponse.getJSONObject("result_list");
                JSONArray mapData = results.getJSONArray("map_data");
                result.put("mapData", mapData);
                result.put("success", true);
            }

        } catch (ApiException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Map<String, Object> findGoods(Long numIids, Map<String, Object> params) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", false);

        // 设置参数
        TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();
        req.setNumIids(numIids.toString());
        if(params != null) {
            if (params.containsKey("ip")) {//查询词，例：女装
                req.setIp(params.get("ip").toString());
            }
            if (params.containsKey("platform")) {//链接形式：1：PC，2：无线，默认：１
                req.setPlatform(Long.valueOf(params.get("platform").toString()));
            }
        }

        try {
            // 调用接口
            TbkItemInfoGetResponse rsp = tobaoClient.execute(req);
            String resultJson = rsp.getBody();

            // 返回结果转json
            JSONObject jsonObject = JSON.parseObject(resultJson);
            JSONObject tbkItemInfoGetResponse = jsonObject.getJSONObject("tbk_item_info_get_response");// 各个接口的结果集字段不一样
            JSONObject errorResponse = jsonObject.getJSONObject("error_response");

            if(errorResponse != null){//返回错误
                String subMsg = errorResponse.getString("sub_msg");
                result.put("msg", subMsg);
            }else if(tbkItemInfoGetResponse != null){//查询成功
                String request_id = tbkItemInfoGetResponse.getString("request_id");
                result.put("requestId", request_id);
                JSONObject results = tbkItemInfoGetResponse.getJSONObject("results");
                JSONArray nTbkItem = results.getJSONArray("n_tbk_item");
                result.put("nTbkItem", nTbkItem);
                result.put("success", true);
            }

        } catch (ApiException e) {
            e.printStackTrace();
        }

        return  result;
    }

    @Override
    public Map<String, Object> getTKL(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", false);

        TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
        if(params == null) {
            result.put("msg","参数不能空");
            return result;
        }
        if (params.containsKey("url")) {//口令跳转目标页
            req.setUrl(params.get("url").toString());
        }else{
            result.put("msg","链接不能为空");
            return result;
        }
        if (params.containsKey("text")) {//口令弹框内容
            req.setText(params.get("text").toString());
        }else{
            result.put("msg","口令内容不能为空");
            return result;
        }
        if (params.containsKey("user_id")) {//生成口令的淘宝用户ID
            req.setUserId(params.get("user_id").toString());
        }
        if (params.containsKey("logo")) {//口令弹框logoURL
            req.setLogo(params.get("logo").toString());
        }
        if (params.containsKey("ext")) {//扩展字段JSON格式
            req.setExt(params.get("ext").toString());
        }

        try {

            TbkTpwdCreateResponse rsp = tobaoClient.execute(req);
            String resultJson = rsp.getBody();

            // 返回结果转json
            JSONObject jsonObject = JSON.parseObject(resultJson);
            JSONObject tbkTpwdCreateResponse = jsonObject.getJSONObject("tbk_tpwd_create_response");// 各个接口的结果集字段不一样
            JSONObject errorResponse = jsonObject.getJSONObject("error_response");

            if(errorResponse != null){//返回错误
                String subMsg = errorResponse.getString("sub_msg");
                result.put("msg", subMsg);
            }else if(tbkTpwdCreateResponse != null){//查询成功
                String request_id = tbkTpwdCreateResponse.getString("request_id");
                result.put("requestId", request_id);
                JSONObject data = tbkTpwdCreateResponse.getJSONObject("data");
                String model = data.getString("model");
                result.put("model", model);
                result.put("success", true);
            }

        } catch (ApiException e) {
            e.printStackTrace();
        }

        return  result;
    }
}