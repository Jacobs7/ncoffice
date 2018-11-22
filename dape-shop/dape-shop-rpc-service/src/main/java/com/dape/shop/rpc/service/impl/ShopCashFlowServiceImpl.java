package com.dape.shop.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.shop.dao.mapper.ShopCashFlowMapper;
import com.dape.shop.dao.model.ShopCashFlow;
import com.dape.shop.dao.model.ShopCashFlowExample;
import com.dape.shop.rpc.api.ShopCashFlowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ShopCashFlowService实现
* Created by dape on 2018/11/22.
*/
@Service
@Transactional
@BaseService
public class ShopCashFlowServiceImpl extends BaseServiceImpl<ShopCashFlowMapper, ShopCashFlow, ShopCashFlowExample> implements ShopCashFlowService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopCashFlowServiceImpl.class);

    @Autowired
    ShopCashFlowMapper shopCashFlowMapper;

}