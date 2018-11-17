package com.dape.shop.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.shop.dao.mapper.ShopUserInfoMapper;
import com.dape.shop.dao.model.ShopUserInfo;
import com.dape.shop.dao.model.ShopUserInfoExample;

/**
* 降级实现ShopUserInfoService接口
* Created by dape on 2018/11/17.
*/
public class ShopUserInfoServiceMock extends BaseServiceMock<ShopUserInfoMapper, ShopUserInfo, ShopUserInfoExample> implements ShopUserInfoService {

}
