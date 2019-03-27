package com.dape.bc.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.bc.dao.mapper.BcGoodsMapper;
import com.dape.bc.dao.model.BcGoods;
import com.dape.bc.dao.model.BcGoodsExample;
import com.dape.bc.rpc.api.BcGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BcGoodsService实现
* Created by dape on 2019/3/27.
*/
@Service
@Transactional
@BaseService
public class BcGoodsServiceImpl extends BaseServiceImpl<BcGoodsMapper, BcGoods, BcGoodsExample> implements BcGoodsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BcGoodsServiceImpl.class);

    @Autowired
    BcGoodsMapper bcGoodsMapper;

}