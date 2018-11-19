package com.dape.shop.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.shop.dao.mapper.ShopMenuMapper;
import com.dape.shop.dao.model.ShopMenu;
import com.dape.shop.dao.model.ShopMenuExample;
import com.dape.shop.rpc.api.ShopMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ShopMenuService实现
* Created by dape on 2018/11/19.
*/
@Service
@Transactional
@BaseService
public class ShopMenuServiceImpl extends BaseServiceImpl<ShopMenuMapper, ShopMenu, ShopMenuExample> implements ShopMenuService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopMenuServiceImpl.class);

    @Autowired
    ShopMenuMapper shopMenuMapper;

}