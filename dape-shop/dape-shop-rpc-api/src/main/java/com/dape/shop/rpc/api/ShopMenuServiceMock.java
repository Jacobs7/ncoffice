package com.dape.shop.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.shop.dao.mapper.ShopMenuMapper;
import com.dape.shop.dao.model.ShopMenu;
import com.dape.shop.dao.model.ShopMenuExample;

/**
* 降级实现ShopMenuService接口
* Created by dape on 2018/11/19.
*/
public class ShopMenuServiceMock extends BaseServiceMock<ShopMenuMapper, ShopMenu, ShopMenuExample> implements ShopMenuService {

}
