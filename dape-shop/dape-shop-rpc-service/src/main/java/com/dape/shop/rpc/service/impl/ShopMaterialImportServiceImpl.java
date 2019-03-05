package com.dape.shop.rpc.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.shop.dao.mapper.ShopGoodsMapper;
import com.dape.shop.dao.mapper.ShopMaterialImportMapper;
import com.dape.shop.dao.model.ShopGoods;
import com.dape.shop.dao.model.ShopGoodsExample;
import com.dape.shop.dao.model.ShopMaterialImport;
import com.dape.shop.dao.model.ShopMaterialImportExample;
import com.dape.shop.rpc.api.ShopMaterialImportService;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgOptimusMaterialRequest;
import com.taobao.api.response.TbkDgOptimusMaterialResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* ShopMaterialImportService实现
* Created by dape on 2019/3/5.
*/
@Service
@Transactional
@BaseService
public class ShopMaterialImportServiceImpl extends BaseServiceImpl<ShopMaterialImportMapper, ShopMaterialImport, ShopMaterialImportExample> implements ShopMaterialImportService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopMaterialImportServiceImpl.class);

    @Autowired
    ShopMaterialImportMapper shopMaterialImportMapper;

    @Autowired
    ShopGoodsMapper shopGoodsMapper;

    @Override
    public Integer[] importGoodsByMaterial(ShopMaterialImport shopMaterialImport, JSONArray mapData, BigDecimal tbkCouponAmount, BigDecimal tbkCouponRate) {
        int addNum = 0;// 新增条数
        int editNum = 0;// 编辑条数
        int failAddNum = 0;// 新增失败条数
        int failEditNum = 0;// 修改失败条数
        int filterNum = 0;// 过滤条数

        Pattern pattern = Pattern.compile("[0-9]*");// 验证数字正则

        for(int i = 0; i < mapData.size(); i++){

            JSONObject data = mapData.getJSONObject(i);

            String zkFinalPriceStr = data.getString("zk_final_price");//折扣价(未摔扣减券额)
            String couponAmountStr = data.getString("coupon_amount");//券额
            BigDecimal zkFinalPrice = new BigDecimal(zkFinalPriceStr);
            BigDecimal couponAmount = new BigDecimal("0");
            if(StringUtils.isNotBlank(couponAmountStr)){
                couponAmount = new BigDecimal(couponAmountStr);
            }
            if(couponAmount.divide(zkFinalPrice, 2, BigDecimal.ROUND_HALF_DOWN).compareTo(tbkCouponRate) == -1 && couponAmount.compareTo(tbkCouponAmount) == -1){
                filterNum++;
                continue;
            }
            String commissionRateStr = data.getString("commission_rate");//佣金率
            BigDecimal commissionRate = new BigDecimal("0");
            if(StringUtils.isNotBlank(commissionRateStr)){
                commissionRate = new BigDecimal(commissionRateStr);
            }

            BigDecimal commission = zkFinalPrice.subtract(couponAmount).multiply(commissionRate).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_DOWN);

            String itemId = data.getString("item_id");
            ShopGoodsExample sgE = new ShopGoodsExample();
            sgE.or().andItemIdEqualTo(itemId);
            long count = shopGoodsMapper.countByExample(sgE);

            if(count <= 0){// 不存在新增
                ShopGoods goods = new ShopGoods();
                goods.setCreateDate(new Date());//导入时间
                goods.setModifyDate(new Date());
                goods.setIsEnabled(true);
                goods.setItemId(itemId);//商品id
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
                        goods.setSmallImages(small_images);//图片列表
                    }
                }

                goods.setZkFinalPrice(zkFinalPrice);//折扣价(未摔扣减券额)
                goods.setClickUrl(data.getString("click_url"));//淘客链接
                goods.setItemDescription(data.getString("item_description"));//推荐理由
                goods.setVolume(data.getInteger("volume"));//30天销量
                goods.setCouponShareUrl(data.getString("coupon_share_url"));//券链接
                goods.setCouponAmount(couponAmount);//券额
                goods.setCouponTotalCount(data.getInteger("coupon_total_count"));//券总量
                goods.setCouponRemainCount(data.getInteger("coupon_remain_count"));//优惠券剩余量
                goods.setCouponStartFee(data.getString("coupon_start_fee"));//券起用门槛,满X元可用
                String couponStartTime = data.getString("coupon_start_time");
                Long dateMillis = null;
                Matcher isNum = pattern.matcher(couponStartTime);
                if(isNum.matches()){
                    dateMillis = Long.valueOf(couponStartTime);
                    goods.setCouponStartTime(new Date(dateMillis));//优惠券开始时间
                }
                String couponEndTime = data.getString("coupon_end_time");
                isNum = pattern.matcher(couponEndTime);
                if(isNum.matches()){
                    dateMillis = Long.valueOf(couponEndTime);
                    goods.setCouponEndTime(new Date(dateMillis));//优惠券结束时间
                }
                goods.setSellerId(data.getString("seller_id"));//卖家id
                goods.setShopTitle(data.getString("shop_title"));//店铺名称
                goods.setUserType(data.getInteger("user_type"));//卖家类型，0表示集市，1表示商城
                goods.setCategoryId(data.getString("category_id"));//叶子类目id
                goods.setCategoryName(data.getString("category_name"));//叶子类目名称
                goods.setLevelOneCategoryId(data.getString("level_one_category_id"));//一级类目ID
                goods.setLevelOneCategoryName(data.getString("level_one_category_name"));//一级类目名称
                goods.setStock(data.getInteger("stock"));//拼团：剩余库存
                goods.setSellNum(data.getInteger("sell_num"));//拼团：已售数量
                goods.setTotalStock(data.getInteger("total_stock"));//拼团：库存数量
                goods.setOstime(data.getString("ostime"));//拼团：开始时间
                goods.setOetime(data.getString("oetime"));//拼团：结束时间
                goods.setJddNum(data.getInteger("jdd_num"));//拼团：几人团
                goods.setJddPrice(data.getString("jdd_price"));//拼团：拼成价，单位元
                goods.setOrigPrice(data.getString("orig_price"));//一人价（原价)，单位元
                goods.setCommissionRate(data.getString("commission_rate"));//佣金率
//                                JSONObject wordListObj = data.getJSONObject("word_list");
//                                if(wordListObj != null){
//                                goods.setWordUrl(data.getString("word_url"));//商品相关关联词落地页地址
//                                goods.setWord(data.getString("关联词"));//商品相关的关联词
//                                    goods.setWordUrl("关联url");//商品相关关联词落地页地址
//                                    goods.setWord("关联词");//商品相关的关联词
//                                }
                goods.setTmallPlayActivityInfo(data.getString("tmall_play_activity_info"));//天猫营销玩法
                goods.setUvSumPreSale(data.getInteger("uv_sum_pre_sale"));//预售数量
                goods.setxId(data.getString("x_id"));//物料块id(测试中请勿使用)
                goods.setNewUserPrice(data.getString("new_user_price"));//新人价
                goods.setMaterialId(shopMaterialImport.getMaterialId());
                goods.setCommission(commission);
                goods.setCouponInfo(data.getString("coupon_info"));// 券信息，满多少减多少
                goods.setNick(data.getString("nick"));
                try{
                    Class.forName("com.dape.shop.dao.model.ShopGoods").getMethod("set"+shopMaterialImport.getFieldName(),new Class[]{Integer.class}).invoke(goods, shopMaterialImport.getChildType());

                    int addFlag = 0;
                    synchronized (shopGoodsMapper) {
                        addFlag = shopGoodsMapper.insert(goods);
                    }
                    if(addFlag > 0){
                        addNum += 1;
                    }else{
                        failAddNum++;
                    }

                } catch (IllegalAccessException e) {
                    failAddNum++;
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    failAddNum++;
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    failAddNum++;
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    failAddNum++;
                    e.printStackTrace();
                } catch (DuplicateKeyException e){
                    failAddNum++;
                    e.printStackTrace();
                }
            }else{// 存在修改
                List<ShopGoods> goodsList = shopGoodsMapper.selectByExample(sgE);
                ShopGoods goods = goodsList.get(0);
                goods.setModifyDate(new Date());
                goods.setIsEnabled(true);
                goods.setTitle(data.getString("title"));//标题
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
                        goods.setSmallImages(small_images);//图片列表
                    }
                }

                goods.setZkFinalPrice(zkFinalPrice);//折扣价(未摔扣减券额)
                goods.setClickUrl(data.getString("click_url"));//淘客链接
                goods.setVolume(data.getInteger("volume"));//30天销量
                goods.setCouponShareUrl(data.getString("coupon_share_url"));//券链接
                goods.setCouponAmount(couponAmount);//券额
                goods.setCouponTotalCount(data.getInteger("coupon_total_count"));//券总量
                goods.setCouponRemainCount(data.getInteger("coupon_remain_count"));//优惠券剩余量
                String couponEndTime = data.getString("coupon_end_time");
                Long dateMillis = null;
                Matcher isNum = pattern.matcher(couponEndTime);
                if(isNum.matches()){
                    dateMillis = Long.valueOf(couponEndTime);
                    goods.setCouponEndTime(new Date(dateMillis));//优惠券结束时间
                }
                goods.setStock(data.getInteger("stock"));//拼团：剩余库存
                goods.setSellNum(data.getInteger("sell_num"));//拼团：已售数量
                goods.setTotalStock(data.getInteger("total_stock"));//拼团：库存数量
                goods.setOstime(data.getString("ostime"));//拼团：开始时间
                goods.setOetime(data.getString("oetime"));//拼团：结束时间
                goods.setJddNum(data.getInteger("jdd_num"));//拼团：几人团
                goods.setJddPrice(data.getString("jdd_price"));//拼团：拼成价，单位元
                goods.setCommissionRate(data.getString("commission_rate"));//佣金率
                goods.setxId(data.getString("x_id"));//物料块id(测试中请勿使用)
                goods.setNewUserPrice(data.getString("new_user_price"));//新人价
                goods.setMaterialId(shopMaterialImport.getMaterialId());
                goods.setCommission(commission);
                goods.setCouponInfo(data.getString("coupon_info"));// 券信息，满多少减多少
                try{
                    Class.forName("com.dape.shop.dao.model.ShopGoods").getMethod("set"+shopMaterialImport.getFieldName(),new Class[]{Integer.class}).invoke(goods, shopMaterialImport.getChildType());
                    int editFlag = shopGoodsMapper.updateByPrimaryKey(goods);
                    if(editFlag > 0){
                        editNum += 1;
                    }else{
                        failEditNum++;
                    }
                } catch (IllegalAccessException e) {
                    failEditNum++;
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    failEditNum++;
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    failEditNum++;
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    failEditNum++;
                    e.printStackTrace();
                }
            }
        }
//        int addNum = 0;// 新增条数
//        int editNum = 0;// 编辑条数
//        int failAddNum = 0;// 新增失败条数
//        int failEditNum = 0;// 修改失败条数
//        int filterNum = 0;// 过滤条数
        return new Integer[]{addNum, failAddNum, editNum, failEditNum, filterNum};
    }
}