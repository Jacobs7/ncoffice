package com.dape.pay.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.pay.dao.mapper.PayOutOrderMapper;
import com.dape.pay.dao.model.PayOutOrder;
import com.dape.pay.dao.model.PayOutOrderExample;
import com.dape.pay.rpc.api.PayOutOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* PayOutOrderService实现
* Created by shuzheng on 2017/3/29.
*/
@Service
@Transactional
@BaseService
public class PayOutOrderServiceImpl extends BaseServiceImpl<PayOutOrderMapper, PayOutOrder, PayOutOrderExample> implements PayOutOrderService {

    private static final Logger log = LoggerFactory.getLogger(PayOutOrderServiceImpl.class);

    @Autowired
    PayOutOrderMapper payOutOrderMapper;

}