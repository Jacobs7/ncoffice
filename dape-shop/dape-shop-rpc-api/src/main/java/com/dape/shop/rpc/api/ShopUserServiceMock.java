package com.dape.shop.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.shop.dao.mapper.ShopUserMapper;
import com.dape.shop.dao.model.ShopUser;
import com.dape.shop.dao.model.ShopUserExample;

/**
* 降级实现ShopUserService接口
* Created by dape on 2018/11/17.
*/
public class ShopUserServiceMock extends BaseServiceMock<ShopUserMapper, ShopUser, ShopUserExample> implements ShopUserService {

}
