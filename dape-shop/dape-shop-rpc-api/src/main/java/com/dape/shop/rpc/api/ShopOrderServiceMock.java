package com.dape.shop.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.shop.dao.mapper.ShopOrderMapper;
import com.dape.shop.dao.model.ShopOrder;
import com.dape.shop.dao.model.ShopOrderExample;

/**
* 降级实现ShopOrderService接口
* Created by dape on 2018/11/17.
*/
public class ShopOrderServiceMock extends BaseServiceMock<ShopOrderMapper, ShopOrder, ShopOrderExample> implements ShopOrderService {

}
