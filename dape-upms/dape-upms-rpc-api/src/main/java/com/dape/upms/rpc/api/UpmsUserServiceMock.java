package com.dape.upms.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.upms.dao.mapper.UpmsUserMapper;
import com.dape.upms.dao.model.UpmsUser;
import com.dape.upms.dao.model.UpmsUserExample;

/**
* 降级实现UpmsUserService接口
* ncoffice on 2017/3/20.
*/
public class UpmsUserServiceMock extends BaseServiceMock<UpmsUserMapper, UpmsUser, UpmsUserExample> implements UpmsUserService {

    @Override
    public UpmsUser createUser(UpmsUser upmsUser) {
        return null;
    }

}
