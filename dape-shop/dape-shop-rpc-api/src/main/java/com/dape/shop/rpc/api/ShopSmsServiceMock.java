package com.dape.shop.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.shop.dao.mapper.ShopSmsMapper;
import com.dape.shop.dao.model.ShopSms;
import com.dape.shop.dao.model.ShopSmsExample;

/**
* 降级实现ShopSmsService接口
* Created by dape on 2018/12/1.
*/
public class ShopSmsServiceMock extends BaseServiceMock<ShopSmsMapper, ShopSms, ShopSmsExample> implements ShopSmsService {

    @Override
    public Integer updateSmsCodeStatus(ShopSms shopSms) {
        return null;
    }
}
