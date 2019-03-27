package com.dape.bc.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.bc.dao.mapper.BcSmsMapper;
import com.dape.bc.dao.model.BcSms;
import com.dape.bc.dao.model.BcSmsExample;
import com.dape.bc.rpc.api.BcSmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BcSmsService实现
* Created by dape on 2019/3/27.
*/
@Service
@Transactional
@BaseService
public class BcSmsServiceImpl extends BaseServiceImpl<BcSmsMapper, BcSms, BcSmsExample> implements BcSmsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BcSmsServiceImpl.class);

    @Autowired
    BcSmsMapper bcSmsMapper;

}