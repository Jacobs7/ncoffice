package com.dape.bc.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.bc.dao.mapper.BcModuleMapper;
import com.dape.bc.dao.model.BcModule;
import com.dape.bc.dao.model.BcModuleExample;
import com.dape.bc.rpc.api.BcModuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BcModuleService实现
* Created by dape on 2019/3/27.
*/
@Service
@Transactional
@BaseService
public class BcModuleServiceImpl extends BaseServiceImpl<BcModuleMapper, BcModule, BcModuleExample> implements BcModuleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BcModuleServiceImpl.class);

    @Autowired
    BcModuleMapper bcModuleMapper;

}