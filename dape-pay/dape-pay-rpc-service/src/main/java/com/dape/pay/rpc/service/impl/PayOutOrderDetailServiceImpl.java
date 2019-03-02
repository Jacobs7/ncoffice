package com.dape.pay.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.pay.dao.mapper.PayOutOrderDetailMapper;
import com.dape.pay.dao.model.PayOutOrderDetail;
import com.dape.pay.dao.model.PayOutOrderDetailExample;
import com.dape.pay.rpc.api.PayOutOrderDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* PayOutOrderDetailService实现
* Created by shuzheng on 2017/3/29.
*/
@Service
@Transactional
@BaseService
public class PayOutOrderDetailServiceImpl extends BaseServiceImpl<PayOutOrderDetailMapper, PayOutOrderDetail, PayOutOrderDetailExample> implements PayOutOrderDetailService {

    private static final Logger log = LoggerFactory.getLogger(PayOutOrderDetailServiceImpl.class);

    @Autowired
    PayOutOrderDetailMapper payOutOrderDetailMapper;

}