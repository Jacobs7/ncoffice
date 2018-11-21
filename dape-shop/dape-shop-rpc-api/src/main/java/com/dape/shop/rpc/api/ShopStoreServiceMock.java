package com.dape.shop.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.shop.dao.mapper.ShopStoreMapper;
import com.dape.shop.dao.model.ShopStore;
import com.dape.shop.dao.model.ShopStoreExample;

/**
* 降级实现ShopStoreService接口
* Created by dape on 2018/11/21.
*/
public class ShopStoreServiceMock extends BaseServiceMock<ShopStoreMapper, ShopStore, ShopStoreExample> implements ShopStoreService {

    @Override
    public ShopStore findShopStore(String userId) {
        return null;
    }
}
