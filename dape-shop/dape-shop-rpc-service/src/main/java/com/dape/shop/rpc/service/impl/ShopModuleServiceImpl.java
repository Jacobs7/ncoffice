package com.dape.shop.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.shop.dao.mapper.ShopModuleMapper;
import com.dape.shop.dao.model.ShopModule;
import com.dape.shop.dao.model.ShopModuleExample;
import com.dape.shop.rpc.api.ShopModuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ShopModuleService实现
* Created by dape on 2018/11/19.
*/
@Service
@Transactional
@BaseService
public class ShopModuleServiceImpl extends BaseServiceImpl<ShopModuleMapper, ShopModule, ShopModuleExample> implements ShopModuleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopModuleServiceImpl.class);

    @Autowired
    ShopModuleMapper shopModuleMapper;

}