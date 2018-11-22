package com.dape.shop.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.shop.dao.mapper.ShopOrderFlowMapper;
import com.dape.shop.dao.model.ShopOrderFlow;
import com.dape.shop.dao.model.ShopOrderFlowExample;
import com.dape.shop.rpc.api.ShopOrderFlowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ShopOrderFlowService实现
* Created by dape on 2018/11/22.
*/
@Service
@Transactional
@BaseService
public class ShopOrderFlowServiceImpl extends BaseServiceImpl<ShopOrderFlowMapper, ShopOrderFlow, ShopOrderFlowExample> implements ShopOrderFlowService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopOrderFlowServiceImpl.class);

    @Autowired
    ShopOrderFlowMapper shopOrderFlowMapper;

}