package com.dape.shop.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.shop.dao.mapper.ShopUserInfoMapper;
import com.dape.shop.dao.model.ShopUserInfo;
import com.dape.shop.dao.model.ShopUserInfoExample;
import com.dape.shop.rpc.api.ShopUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ShopUserInfoService实现
* Created by dape on 2018/11/17.
*/
@Service
@Transactional
@BaseService
public class ShopUserInfoServiceImpl extends BaseServiceImpl<ShopUserInfoMapper, ShopUserInfo, ShopUserInfoExample> implements ShopUserInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopUserInfoServiceImpl.class);

    @Autowired
    ShopUserInfoMapper shopUserInfoMapper;

}