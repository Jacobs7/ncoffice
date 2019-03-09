package com.dape.datax.rpc.service.impl;


import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.datax.dao.mapper.DataxApplySourceMapper;
import com.dape.datax.dao.model.DataxApplySource;
import com.dape.datax.dao.model.DataxApplySourceExample;
import com.dape.datax.rpc.api.DataxApplySourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
* DataxApplySourceService实现
* Created by dape on 2019/3/9.
*/
@Service
@Transactional
@BaseService
public class DataxApplySourceServiceImpl extends BaseServiceImpl<DataxApplySourceMapper, DataxApplySource, DataxApplySourceExample> implements DataxApplySourceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataxApplySourceServiceImpl.class);

    /**
     *
     */
    @Autowired
    DataxApplySourceMapper dataxApplySourceMapper;

}