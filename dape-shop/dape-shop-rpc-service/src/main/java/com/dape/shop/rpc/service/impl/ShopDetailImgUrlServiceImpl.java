package com.dape.shop.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.shop.dao.mapper.ShopDetailImgUrlMapper;
import com.dape.shop.dao.model.ShopDetailImgUrl;
import com.dape.shop.dao.model.ShopDetailImgUrlExample;
import com.dape.shop.rpc.api.ShopDetailImgUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ShopDetailImgUrlService实现
* Created by dape on 2019/2/23.
*/
@Service
@Transactional
@BaseService
public class ShopDetailImgUrlServiceImpl extends BaseServiceImpl<ShopDetailImgUrlMapper, ShopDetailImgUrl, ShopDetailImgUrlExample> implements ShopDetailImgUrlService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopDetailImgUrlServiceImpl.class);

    @Autowired
    ShopDetailImgUrlMapper shopDetailImgUrlMapper;

}