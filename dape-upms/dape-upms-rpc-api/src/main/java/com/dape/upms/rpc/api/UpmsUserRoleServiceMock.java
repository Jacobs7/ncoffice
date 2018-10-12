package com.dape.upms.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.upms.dao.mapper.UpmsUserRoleMapper;
import com.dape.upms.dao.model.UpmsUserRole;
import com.dape.upms.dao.model.UpmsUserRoleExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* 降级实现UpmsUserRoleService接口
* ncoffice on 2017/3/20.
*/
public class UpmsUserRoleServiceMock extends BaseServiceMock<UpmsUserRoleMapper, UpmsUserRole, UpmsUserRoleExample> implements UpmsUserRoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsUserRoleServiceMock.class);

    @Override
    public int role(String[] roleIds, int id) {
        LOGGER.info("UpmsUserRoleServiceMock => role");
        return 0;
    }

}
