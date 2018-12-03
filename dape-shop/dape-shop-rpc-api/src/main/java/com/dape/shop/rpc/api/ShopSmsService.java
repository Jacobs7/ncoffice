package com.dape.shop.rpc.api;

import com.dape.common.base.BaseService;
import com.dape.shop.dao.model.ShopSms;
import com.dape.shop.dao.model.ShopSmsExample;

/**
* ShopSmsService接口
* Created by dape on 2018/12/1.
*/
public interface ShopSmsService extends BaseService<ShopSms, ShopSmsExample> {

    public Integer updateSmsCodeStatus(ShopSms shopSms);
}