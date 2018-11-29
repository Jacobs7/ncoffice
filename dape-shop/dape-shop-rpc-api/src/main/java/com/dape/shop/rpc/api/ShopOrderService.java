package com.dape.shop.rpc.api;

import com.dape.common.base.BaseService;
import com.dape.shop.dao.model.ShopOrder;
import com.dape.shop.dao.model.ShopOrderExample;
import com.dape.shop.dao.model.ShopUser;

import java.util.List;

/**
* ShopOrderService接口
* Created by dape on 2018/11/17.
*/
public interface ShopOrderService extends BaseService<ShopOrder, ShopOrderExample> {

    public List<ShopOrder> selectTuiGuangOrder(Integer pageNum, Integer pageSize, ShopUser shopUser);
    public int getUserMoney(ShopOrder shopOrder);
}