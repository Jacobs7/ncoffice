package com.dape.bc.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.bc.dao.mapper.BcPayOrderMapper;
import com.dape.bc.dao.model.BcPayOrder;
import com.dape.bc.dao.model.BcPayOrderExample;
import com.dape.bc.rpc.api.BcPayOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BcPayOrderService实现
* Created by dape on 2019/4/1.
*/
@Service
@Transactional
@BaseService
public class BcPayOrderServiceImpl extends BaseServiceImpl<BcPayOrderMapper, BcPayOrder, BcPayOrderExample> implements BcPayOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BcPayOrderServiceImpl.class);

    @Autowired
    BcPayOrderMapper bcPayOrderMapper;

}