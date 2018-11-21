package com.dape.shop.rpc.api;

import com.dape.common.base.BaseService;
import com.dape.shop.dao.model.ShopStore;
import com.dape.shop.dao.model.ShopStoreExample;

/**
* ShopStoreService接口
* Created by dape on 2018/11/21.
*/
public interface ShopStoreService extends BaseService<ShopStore, ShopStoreExample> {

    public ShopStore findShopStore(String userId);
}