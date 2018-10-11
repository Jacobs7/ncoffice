package com.dape.upms.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.upms.dao.mapper.UpmsRoleMapper;
import com.dape.upms.dao.model.UpmsRole;
import com.dape.upms.dao.model.UpmsRoleExample;
import com.dape.upms.rpc.api.UpmsRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsRoleService实现
* Created by shuzheng on 2017/3/20.
*/
@Service
@Transactional
@BaseService
public class UpmsRoleServiceImpl extends BaseServiceImpl<UpmsRoleMapper, UpmsRole, UpmsRoleExample> implements UpmsRoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsRoleServiceImpl.class);

    @Autowired
    UpmsRoleMapper upmsRoleMapper;

}