package com.dape.shop.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.shop.dao.mapper.ShopModuleMapper;
import com.dape.shop.dao.model.ShopModule;
import com.dape.shop.dao.model.ShopModuleExample;

/**
* 降级实现ShopModuleService接口
* Created by dape on 2018/11/19.
*/
public class ShopModuleServiceMock extends BaseServiceMock<ShopModuleMapper, ShopModule, ShopModuleExample> implements ShopModuleService {

}
