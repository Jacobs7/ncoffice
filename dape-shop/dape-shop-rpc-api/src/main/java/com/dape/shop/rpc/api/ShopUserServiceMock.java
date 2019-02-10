package com.dape.shop.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.shop.dao.mapper.ShopUserMapper;
import com.dape.shop.dao.model.ShopUser;
import com.dape.shop.dao.model.ShopUserExample;
import com.dape.shop.dao.model.ShopUserOrder;
import com.dape.shop.dao.model.UpmsUser;

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

    @Override
    public UpmsUser selectUpmsUserByUsername(String username) {
        return null;
    }

    @Override
    public UpmsUser selectUpmsUserByOpenid(String openid) {
        return null;
    }

    @Override
    public UpmsUser createUser(UpmsUser upmsUser) {
        return null;
    }

    @Override
    public int countUpmsUser(String username) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(UpmsUser upmsUser) {
        return 0;
    }
}
