package com.dape.bc.rpc.api;

import com.dape.bc.dao.mapper.UpmsUserMapper;
import com.dape.bc.dao.model.UpmsUser;
import com.dape.bc.dao.model.UpmsUserExample;
import com.dape.common.base.BaseServiceMock;

/**
* 降级实现UpmsUserService接口
* Created by dape on 2019/2/10.
*/
public class UpmsUserServiceMock extends BaseServiceMock<UpmsUserMapper, UpmsUser, UpmsUserExample> implements UpmsUserService {

}
