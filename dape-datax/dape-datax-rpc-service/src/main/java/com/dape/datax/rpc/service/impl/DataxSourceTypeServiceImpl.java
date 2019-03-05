package com.dape.datax.rpc.service.impl;

import com.dape.common.annotation.BaseService;

import com.dape.common.base.BaseServiceImpl;
import com.dape.datax.dao.mapper.DataxSourceTypeMapper;
import com.dape.datax.dao.model.DataxSourceType;
import com.dape.datax.dao.model.DataxSourceTypeExample;
import com.dape.datax.rpc.api.DataxSourceTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* DataxSourceTypeService实现
* Created by dape on 2019/3/4.
*/
@Service
@Transactional
@BaseService
public class DataxSourceTypeServiceImpl extends BaseServiceImpl<DataxSourceTypeMapper, DataxSourceType, DataxSourceTypeExample> implements DataxSourceTypeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataxSourceTypeServiceImpl.class);

    @Autowired
    DataxSourceTypeMapper dataxSourceTypeMapper;

}