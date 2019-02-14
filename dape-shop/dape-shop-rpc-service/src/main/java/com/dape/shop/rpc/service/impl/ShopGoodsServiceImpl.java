package com.dape.shop.rpc.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.common.util.PropertiesFileUtil;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    private static TaobaoClient tobaoClient = null;

    static {
        if(tobaoClient == null){
            // 正式环境
            tobaoClient = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "25632498", "51e06e43ebc6f093579131f6c7fcd568");
        }
    }

    public static void main(String[] args){

        try {
            TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "25632498", "51e06e43ebc6f093579131f6c7fcd568");

//            TbkItemRecommendGetRequest req = new TbkItemRecommendGetRequest();
//            req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url");
//            req.setNumIid(584574208203L);
//            req.setPlatform(2L);
//            req.setCount(40L);
//            TbkItemRecommendGetResponse rsp = client.execute(req);

            TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();
            req.setNumIids("584574208203");
            req.setPlatform(2L);
//            req.setIp("11.22.33.43");
            TbkItemInfoGetResponse rsp = client.execute(req);


            System.out.println("*********************");
            System.out.println(rsp.getBody());
            System.out.println("*********************");
        } catch (ApiException e) {
            e.printStackTrace();
        }
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
    public Map<String, Object> loadCouponGoods(Long pageNum, Long pageSize, Map<String, Object> params) {

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", false);

        TbkDgItemCouponGetRequest req = new TbkDgItemCouponGetRequest();

        req.setAdzoneId(96030450186L);//推广位：要在阿里妈妈后台获取，mm_xxx_xxx_xxx的第三位

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
        }

        // 设置pageNum、pageSize
        req.setPageNo(pageNum);
        req.setPageSize(pageSize);
        try {

            // 调用接口
            TbkDgItemCouponGetResponse rsp = tobaoClient.execute(req);
            String resultJson = rsp.getBody();

            // 返回结果转json
            JSONObject jsonObject = JSON.parseObject(resultJson);
            JSONObject tbkDgItemCouponGetResponse = jsonObject.getJSONObject("tbk_dg_item_coupon_get_response");// 各个接口的结果集字段不一样
            JSONObject errorResponse = jsonObject.getJSONObject("error_response");

            if(errorResponse != null){//返回错误
                String subMsg = errorResponse.getString("sub_msg");
                result.put("msg", subMsg);
            }else if(tbkDgItemCouponGetResponse != null){//查询成功
                Long total_results = tbkDgItemCouponGetResponse.getLong("total_results");
                result.put("total", total_results);
                String request_id = tbkDgItemCouponGetResponse.getString("request_id");
                result.put("requestId", request_id);
                JSONObject results = tbkDgItemCouponGetResponse.getJSONObject("results");
                JSONArray tbkCoupon = results.getJSONArray("tbk_coupon");
                result.put("tbkCoupon", tbkCoupon);
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
}