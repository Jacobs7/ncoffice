package com.dape.bc.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.bc.dao.mapper.BcModuleItemMapper;
import com.dape.bc.dao.model.BcModuleItem;
import com.dape.bc.dao.model.BcModuleItemExample;

/**
* 降级实现BcModuleItemService接口
* Created by dape on 2019/3/27.
*/
public class BcModuleItemServiceMock extends BaseServiceMock<BcModuleItemMapper, BcModuleItem, BcModuleItemExample> implements BcModuleItemService {

}
