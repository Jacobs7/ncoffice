package com.dape.pay.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.pay.dao.mapper.PayTypeMapper;
import com.dape.pay.dao.model.PayType;
import com.dape.pay.dao.model.PayTypeExample;
import com.dape.pay.rpc.api.PayTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* PayTypeService实现
* Created by shuzheng on 2017/3/29.
*/
@Service
@Transactional
@BaseService
public class PayTypeServiceImpl extends BaseServiceImpl<PayTypeMapper, PayType, PayTypeExample> implements PayTypeService {

    private static final Logger log = LoggerFactory.getLogger(PayTypeServiceImpl.class);

    @Autowired
    PayTypeMapper payTypeMapper;

}