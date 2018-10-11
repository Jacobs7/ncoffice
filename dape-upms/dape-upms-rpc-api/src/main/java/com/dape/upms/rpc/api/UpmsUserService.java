package com.dape.upms.rpc.api;

import com.dape.common.base.BaseService;
import com.dape.upms.dao.model.UpmsUser;
import com.dape.upms.dao.model.UpmsUserExample;

/**
* UpmsUserService接口
* Created by shuzheng on 2017/3/20.
*/
public interface UpmsUserService extends BaseService<UpmsUser, UpmsUserExample> {

    UpmsUser createUser(UpmsUser upmsUser);

}