package com.dape.pay.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.pay.dao.mapper.PayVendorMapper;
import com.dape.pay.dao.model.PayVendor;
import com.dape.pay.dao.model.PayVendorExample;
import com.dape.pay.rpc.api.PayVendorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* PayVendorService实现
* Created by shuzheng on 2017/3/29.
*/
@Service
@Transactional
@BaseService
public class PayVendorServiceImpl extends BaseServiceImpl<PayVendorMapper, PayVendor, PayVendorExample> implements PayVendorService {

    private static final Logger log = LoggerFactory.getLogger(PayVendorServiceImpl.class);

    @Autowired
    PayVendorMapper payVendorMapper;

}