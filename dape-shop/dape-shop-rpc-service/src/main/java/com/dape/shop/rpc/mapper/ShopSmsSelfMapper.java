package com.dape.shop.rpc.mapper;

import com.dape.shop.dao.model.ShopSms;
import org.apache.ibatis.annotations.Param;

public interface ShopSmsSelfMapper {

    public Integer updateSmsCodeStatus(@Param("shopSms") ShopSms shopSms);
}
