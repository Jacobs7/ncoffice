package com.dape.shop.rpc.mapper;

import com.dape.shop.dao.model.ShopOrder;
import com.dape.shop.dao.model.ShopUser;
import com.dape.shop.dao.model.ShopUserOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ShopUserOrderMapper {

    public int listUserOrderCount(Map<String, Object> params);
    public List<ShopUserOrder> listUserOrder(Map<String, Object> params);
    public List<ShopOrder> selectTuiGuangOrder(@Param("start") Integer start, @Param("limit") Integer limit, @Param("shopUser") ShopUser shopUser, @Param("shopOrder") ShopOrder shopOrder);
    public Integer getUserMoney(@Param("shopOrder") ShopOrder shopOrder);
}
