package com.dape.bc.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.bc.dao.mapper.BcModuleItemMapper;
import com.dape.bc.dao.model.BcModuleItem;
import com.dape.bc.dao.model.BcModuleItemExample;
import com.dape.bc.rpc.api.BcModuleItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BcModuleItemService实现
* Created by dape on 2019/3/27.
*/
@Service
@Transactional
@BaseService
public class BcModuleItemServiceImpl extends BaseServiceImpl<BcModuleItemMapper, BcModuleItem, BcModuleItemExample> implements BcModuleItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BcModuleItemServiceImpl.class);

    @Autowired
    BcModuleItemMapper bcModuleItemMapper;

}