package com.dape.shop.rpc.mapper;

import com.dape.shop.dao.model.ShopUserOrder;

import java.util.List;
import java.util.Map;

public interface ShopUserOrderMapper {

    public int listUserOrderCount(Map<String, Object> params);
    public List<ShopUserOrder> listUserOrder(Map<String, Object> params);
}
