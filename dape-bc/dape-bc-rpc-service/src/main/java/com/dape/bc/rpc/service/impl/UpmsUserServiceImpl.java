package com.dape.bc.rpc.service.impl;

import com.dape.bc.dao.mapper.UpmsUserMapper;
import com.dape.bc.dao.model.UpmsUser;
import com.dape.bc.dao.model.UpmsUserExample;
import com.dape.bc.rpc.api.UpmsUserService;
import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsUserService实现
* Created by dape on 2019/2/10.
*/
@Service
@Transactional
@BaseService
public class UpmsUserServiceImpl extends BaseServiceImpl<UpmsUserMapper, UpmsUser, UpmsUserExample> implements UpmsUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsUserServiceImpl.class);

    @Autowired
    UpmsUserMapper upmsUserMapper;

}