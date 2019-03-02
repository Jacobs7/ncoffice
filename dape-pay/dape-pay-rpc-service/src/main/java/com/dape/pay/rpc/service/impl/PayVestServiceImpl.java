package com.dape.pay.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.pay.dao.mapper.PayVestMapper;
import com.dape.pay.dao.model.PayVest;
import com.dape.pay.dao.model.PayVestExample;
import com.dape.pay.rpc.api.PayVestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* PayVestService实现
* Created by shuzheng on 2017/3/29.
*/
@Service
@Transactional
@BaseService
public class PayVestServiceImpl extends BaseServiceImpl<PayVestMapper, PayVest, PayVestExample> implements PayVestService {

    private static final Logger log = LoggerFactory.getLogger(PayVestServiceImpl.class);

    @Autowired
    PayVestMapper payVestMapper;

}