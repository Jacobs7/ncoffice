package com.dape.shop.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.shop.dao.mapper.UpmsUserMapper;
import com.dape.shop.dao.model.UpmsUser;
import com.dape.shop.dao.model.UpmsUserExample;

/**
* 降级实现UpmsUserService接口
* Created by dape on 2019/2/10.
*/
public class UpmsUserServiceMock extends BaseServiceMock<UpmsUserMapper, UpmsUser, UpmsUserExample> implements UpmsUserService {

}
