package com.dape.shop.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.shop.dao.mapper.ShopSmsMapper;
import com.dape.shop.dao.model.ShopSms;
import com.dape.shop.dao.model.ShopSmsExample;
import com.dape.shop.rpc.api.ShopSmsService;
import com.dape.shop.rpc.mapper.ShopSmsSelfMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ShopSmsService实现
* Created by dape on 2018/12/1.
*/
@Service
@Transactional
@BaseService
public class ShopSmsServiceImpl extends BaseServiceImpl<ShopSmsMapper, ShopSms, ShopSmsExample> implements ShopSmsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopSmsServiceImpl.class);

    @Autowired
    ShopSmsMapper shopSmsMapper;
    @Autowired
    ShopSmsSelfMapper shopSmsSelfMapper;

    @Override
    public Integer updateSmsCodeStatus(ShopSms shopSms) {
        return shopSmsSelfMapper.updateSmsCodeStatus(shopSms);
    }
}