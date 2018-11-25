package com.dape.shop.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.shop.dao.mapper.ShopUserMapper;
import com.dape.shop.dao.model.ShopUser;
import com.dape.shop.dao.model.ShopUserExample;
import com.dape.shop.dao.model.ShopUserOrder;

import java.util.List;
import java.util.Map;

/**
* 降级实现ShopUserService接口
* Created by dape on 2018/11/17.
*/
public class ShopUserServiceMock extends BaseServiceMock<ShopUserMapper, ShopUser, ShopUserExample> implements ShopUserService {

    @Override
    public int listUserOrderCount(Map<String, Object> params) {
        return 0;
    }

    @Override
    public List<ShopUserOrder> listUserOrder(Map<String, Object> params) {
        return null;
    }
}
