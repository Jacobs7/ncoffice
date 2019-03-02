package com.dape.pay.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.pay.dao.mapper.PayInOrderDetailMapper;
import com.dape.pay.dao.model.PayInOrderDetail;
import com.dape.pay.dao.model.PayInOrderDetailExample;
import com.dape.pay.rpc.api.PayInOrderDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* PayInOrderDetailService实现
* Created by shuzheng on 2017/3/29.
*/
@Service
@Transactional
@BaseService
public class PayInOrderDetailServiceImpl extends BaseServiceImpl<PayInOrderDetailMapper, PayInOrderDetail, PayInOrderDetailExample> implements PayInOrderDetailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayInOrderDetailServiceImpl.class);

    @Autowired
    PayInOrderDetailMapper payInOrderDetailMapper;

}