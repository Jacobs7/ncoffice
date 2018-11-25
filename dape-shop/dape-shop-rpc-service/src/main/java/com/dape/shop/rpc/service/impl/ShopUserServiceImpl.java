package com.dape.shop.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.shop.dao.mapper.ShopUserMapper;
import com.dape.shop.dao.model.ShopUser;
import com.dape.shop.dao.model.ShopUserExample;
import com.dape.shop.dao.model.ShopUserOrder;
import com.dape.shop.rpc.api.ShopUserService;
import com.dape.shop.rpc.mapper.ShopUserOrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
* ShopUserService实现
* Created by dape on 2018/11/17.
*/
@Service
@Transactional
@BaseService
public class ShopUserServiceImpl extends BaseServiceImpl<ShopUserMapper, ShopUser, ShopUserExample> implements ShopUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopUserServiceImpl.class);

    @Autowired
    ShopUserMapper shopUserMapper;
    @Autowired
    ShopUserOrderMapper shopUserOrderMapper;

    @Override
    public int listUserOrderCount(Map<String, Object> params) {
        return shopUserOrderMapper.listUserOrderCount(params);
    }

    @Override
    public List<ShopUserOrder> listUserOrder(Map<String, Object> params) {
        return shopUserOrderMapper.listUserOrder(params);
    }
}