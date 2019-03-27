package com.dape.bc.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.bc.dao.mapper.BcModuleMapper;
import com.dape.bc.dao.model.BcModule;
import com.dape.bc.dao.model.BcModuleExample;

/**
* 降级实现BcModuleService接口
* Created by dape on 2019/3/27.
*/
public class BcModuleServiceMock extends BaseServiceMock<BcModuleMapper, BcModule, BcModuleExample> implements BcModuleService {

}
