package com.dape.datax.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.datax.dao.mapper.DataxTaskMapper;
import com.dape.datax.dao.model.DataxTask;
import com.dape.datax.dao.model.DataxTaskExample;
import com.dape.datax.rpc.api.DataxTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* DataxTaskService实现
* Created by dape on 2019/3/9.
*/
@Service
@Transactional
@BaseService
public class DataxTaskServiceImpl extends BaseServiceImpl<DataxTaskMapper, DataxTask, DataxTaskExample> implements DataxTaskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataxTaskServiceImpl.class);

    @Autowired
    DataxTaskMapper dataxTaskMapper;

}