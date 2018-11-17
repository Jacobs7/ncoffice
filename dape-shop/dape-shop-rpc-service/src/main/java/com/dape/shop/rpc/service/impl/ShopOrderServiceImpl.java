package com.dape.shop.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.shop.dao.mapper.ShopOrderMapper;
import com.dape.shop.dao.model.ShopOrder;
import com.dape.shop.dao.model.ShopOrderExample;
import com.dape.shop.rpc.api.ShopOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ShopOrderService实现
* Created by dape on 2018/11/17.
*/
@Service
@Transactional
@BaseService
public class ShopOrderServiceImpl extends BaseServiceImpl<ShopOrderMapper, ShopOrder, ShopOrderExample> implements ShopOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopOrderServiceImpl.class);

    @Autowired
    ShopOrderMapper shopOrderMapper;

}