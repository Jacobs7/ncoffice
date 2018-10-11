package com.dape.upms.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.upms.dao.mapper.UpmsSystemMapper;
import com.dape.upms.dao.model.UpmsSystem;
import com.dape.upms.dao.model.UpmsSystemExample;

/**
* 降级实现UpmsSystemService接口
* Created by shuzheng on 2017/3/20.
*/
public class UpmsSystemServiceMock extends BaseServiceMock<UpmsSystemMapper, UpmsSystem, UpmsSystemExample> implements UpmsSystemService {

    @Override
    public UpmsSystem selectUpmsSystemByName(String name) {
        return null;
    }

}
