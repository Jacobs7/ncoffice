package com.dape.bc.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.bc.dao.mapper.BcPayOrderRefundMapper;
import com.dape.bc.dao.model.BcPayOrderRefund;
import com.dape.bc.dao.model.BcPayOrderRefundExample;
import com.dape.bc.rpc.api.BcPayOrderRefundService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BcPayOrderRefundService实现
* Created by dape on 2019/4/1.
*/
@Service
@Transactional
@BaseService
public class BcPayOrderRefundServiceImpl extends BaseServiceImpl<BcPayOrderRefundMapper, BcPayOrderRefund, BcPayOrderRefundExample> implements BcPayOrderRefundService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BcPayOrderRefundServiceImpl.class);

    @Autowired
    BcPayOrderRefundMapper bcPayOrderRefundMapper;

}