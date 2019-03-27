package com.dape.bc.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.bc.dao.mapper.BcMenuMapper;
import com.dape.bc.dao.model.BcMenu;
import com.dape.bc.dao.model.BcMenuExample;
import com.dape.bc.rpc.api.BcMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BcMenuService实现
* Created by dape on 2019/3/27.
*/
@Service
@Transactional
@BaseService
public class BcMenuServiceImpl extends BaseServiceImpl<BcMenuMapper, BcMenu, BcMenuExample> implements BcMenuService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BcMenuServiceImpl.class);

    @Autowired
    BcMenuMapper bcMenuMapper;

}