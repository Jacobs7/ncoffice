package com.dape.shop.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.shop.dao.mapper.ShopStoreMapper;
import com.dape.shop.dao.model.ShopStore;
import com.dape.shop.dao.model.ShopStoreExample;
import com.dape.shop.rpc.api.ShopStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ShopStoreService实现
* Created by dape on 2018/11/21.
*/
@Service
@Transactional
@BaseService
public class ShopStoreServiceImpl extends BaseServiceImpl<ShopStoreMapper, ShopStore, ShopStoreExample> implements ShopStoreService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopStoreServiceImpl.class);

    @Autowired
    ShopStoreMapper shopStoreMapper;

    @Override
    public ShopStore findShopStore(String userId) {

        ShopStore shopStore = new ShopStore();
        shopStore.setUserId(12312L);
        shopStore.setShopTitle("小宝的店铺");
        shopStore.setShopType("B"); // 店铺类型，B：天猫，C：淘宝
        shopStore.setSellerNick("小宝"); // 卖家昵称
        shopStore.setPictUrl("http://www.taobao.com/fjjf"); // 店标图片
        shopStore.setShopUrl("http://www.taobao.com/fjjf"); // 店铺地址

        return shopStore;
    }
}