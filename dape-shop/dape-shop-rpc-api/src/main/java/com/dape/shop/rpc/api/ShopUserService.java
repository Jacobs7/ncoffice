package com.dape.shop.rpc.api;

import com.dape.common.base.BaseService;
import com.dape.shop.dao.model.ShopUser;
import com.dape.shop.dao.model.ShopUserExample;
import com.dape.shop.dao.model.ShopUserOrder;
import com.dape.shop.dao.model.UpmsUser;

import java.util.List;
import java.util.Map;

/**
* ShopUserService接口
* Created by dape on 2018/11/17.
*/
public interface ShopUserService extends BaseService<ShopUser, ShopUserExample> {

    public int listUserOrderCount(Map<String, Object> params);
    public List<ShopUserOrder> listUserOrder(Map<String, Object> params);

    UpmsUser selectUpmsUserByUsername(String username);

    UpmsUser selectUpmsUserByOpenid(String openid);

    UpmsUser createUser(UpmsUser upmsUser);

    int countUpmsUser(String username);

    int updateByPrimaryKey(UpmsUser upmsUser);
}