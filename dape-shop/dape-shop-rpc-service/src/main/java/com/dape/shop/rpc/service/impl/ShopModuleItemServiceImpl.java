package com.dape.shop.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.shop.dao.mapper.ShopModuleItemMapper;
import com.dape.shop.dao.model.ShopModuleItem;
import com.dape.shop.dao.model.ShopModuleItemExample;
import com.dape.shop.rpc.api.ShopModuleItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ShopModuleItemService实现
* Created by dape on 2019/2/25.
*/
@Service
@Transactional
@BaseService
public class ShopModuleItemServiceImpl extends BaseServiceImpl<ShopModuleItemMapper, ShopModuleItem, ShopModuleItemExample> implements ShopModuleItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopModuleItemServiceImpl.class);

    @Autowired
    ShopModuleItemMapper shopModuleItemMapper;

}