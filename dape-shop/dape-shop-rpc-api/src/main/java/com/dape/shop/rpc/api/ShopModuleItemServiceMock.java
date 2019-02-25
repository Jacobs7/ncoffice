package com.dape.shop.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.shop.dao.mapper.ShopModuleItemMapper;
import com.dape.shop.dao.model.ShopModuleItem;
import com.dape.shop.dao.model.ShopModuleItemExample;

/**
* 降级实现ShopModuleItemService接口
* Created by dape on 2019/2/25.
*/
public class ShopModuleItemServiceMock extends BaseServiceMock<ShopModuleItemMapper, ShopModuleItem, ShopModuleItemExample> implements ShopModuleItemService {

}
