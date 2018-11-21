package com.dape.shop.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.common.util.PropertiesFileUtil;
import com.dape.shop.dao.mapper.ShopGoodsMapper;
import com.dape.shop.dao.model.ShopGoods;
import com.dape.shop.dao.model.ShopGoodsExample;
import com.dape.shop.rpc.api.ShopGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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


    @Override
    public List<ShopGoods> loadGoods(int pageNum, int pageSize, ShopGoods shopGoods) {
        System.out.println("pageNum: " + pageNum + " ,pageSize: " + pageSize);

        List<ShopGoods> goods = new ArrayList<ShopGoods>();
        ShopGoods item = null;

        Random random =new Random();
        for(int i = 1;i <= 10; i++){
            item = new ShopGoods();
            item.setId(1L + i);
            item.setPictUrl("/upload/pro"+ (i%5+1)+".jpg");
            item.setTitle("洋河蓝色瓶装经典Q7浓香型白酒500ml52度高端纯粮食白酒2瓶装包邮");
            item.setReservePrice("99.84");
            item.setZkFinalPrice("88.00"); // 折扣价
            item.setVolume(187); // 30销量
            item.setCouponInfo(String.valueOf(random.nextInt(100))); // 优惠券面额
            item.setCouponTotalCount(999); // 优惠券总量
            item.setCouponRemainCount(758); // 优惠券剩余量

            goods.add(item);
        }

        return goods;
    }

    @Override
    public ShopGoods findGoods(String numIids, int platform, String ip) {
        ShopGoods shopGoods = new ShopGoods();
        shopGoods.setNumIid("123"); // 商品id
        shopGoods.setTitle("俞兆林卫衣 男2017春新款运动休闲印花大码潮人卫衣卫裤加厚外套套装男");
        shopGoods.setPictUrl("/upload/zhutu01.jpg"); // 主图
        shopGoods.setSmallImages("/upload/zhutu02.jpg,/upload/zhutu03.jpg,/upload/zhutu04.jpg,/upload/zhutu05.jpg,"); // 小图列表
        shopGoods.setReservePrice("185.25"); // 一口价
        shopGoods.setZkFinalPrice("88.00"); // 折扣价
        shopGoods.setUserType(1); // 卖家类型，0：集市，1：商城
        shopGoods.setProvcity("江苏南京"); // 商品所在地
        shopGoods.setItemUrl("https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7408093.7.4.vcbZx2&id=541168065917"); // 商品链接
        shopGoods.setNick("小宝的商铺"); // 卖家昵称
        shopGoods.setSellerId(193827192); // 卖家id
        shopGoods.setVolume(187); // 30销量
        shopGoods.setCatLeafName("男装"); // 叶子类目名称
        shopGoods.setIsPrepay(true); // 是否加入消费者保障
        shopGoods.setShopDsr(55); // 商铺评分
        shopGoods.setRatesum(21); // 卖家等级
        shopGoods.setiRfdRate(false); // 退款率是否低于行业均值
        shopGoods.sethGoodRate(true); // 好评率是否高于行业均值
        shopGoods.sethPayRate30(true); // 成交转化是否高于行业均值
        shopGoods.setFreeShipment(true); // 是否包邮
        shopGoods.setMaterialLibType(""); // 商品库类型，支持多库类型输出，以“，”区分，1:营销商品主推库
        shopGoods.setTkRate("20.00"); // 收入比例，举例，取值为20.00，表示比例20.00%
        shopGoods.setZkFinalPriceWap("55.99"); // 无线折扣价，即宝贝在无线上的实际售卖价格
        shopGoods.setShopTitle(""); //
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            shopGoods.setEventStartTime(format.parse("2018-11-15")); // 招商活动开始时间；如果该宝贝取自普通选品组，则取值为1970-01-01 00:00:00
            shopGoods.setEventEndTime(format.parse("2018-12-15")); // 招行活动的结束时间；如果该宝贝取自普通的选品组，则取值为1970-01-01 00:00:00
        } catch (ParseException e) {
            e.printStackTrace();
        }
        shopGoods.setType(1); // 宝贝类型：1 普通商品； 2 鹊桥高佣金商品；3 定向招商商品；4 营销计划商品;
        shopGoods.setStatus(1); // 宝贝状态，0失效，1有效；注：失效可能是宝贝已经下线或者是被处罚不能在进行推广
        shopGoods.setCategory(11); // 后台一级类目
        shopGoods.setCouponClickUrl("http://www.taobao.com/fjjffj"); // 商品优惠券推广链接
        try {
            shopGoods.setCouponStartTime(format.parse("2018-11-15")); // coupon_start_time
            shopGoods.setCouponEndTime(format.parse("2018-12-15")); // 优惠券结束时间
        } catch (ParseException e) {
            e.printStackTrace();
        }
        shopGoods.setCouponInfo("15"); // 优惠券面额
        shopGoods.setCouponTotalCount(999); // 优惠券总量
        shopGoods.setCouponRemainCount(758); // 优惠券剩余量

        // taobao.tbk.coupon.get 推广券查询接口,
        // me:带券ID与商品ID的加密串
        // item_id:商品ID
        // activity_id:券ID

        return shopGoods;
    }
}