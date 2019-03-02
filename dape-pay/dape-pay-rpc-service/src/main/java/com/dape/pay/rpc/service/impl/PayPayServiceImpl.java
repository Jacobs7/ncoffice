package com.dape.pay.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.pay.dao.mapper.PayPayMapper;
import com.dape.pay.dao.model.PayPay;
import com.dape.pay.dao.model.PayPayExample;
import com.dape.pay.rpc.api.PayPayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* PayPayService实现
* Created by shuzheng on 2017/3/29.
*/
@Service
@Transactional
@BaseService
public class PayPayServiceImpl extends BaseServiceImpl<PayPayMapper, PayPay, PayPayExample> implements PayPayService {

    private static final Logger log = LoggerFactory.getLogger(PayPayServiceImpl.class);

    @Autowired
    PayPayMapper payPayMapper;

}