package com.dape.bc.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.bc.dao.mapper.BcMenuMapper;
import com.dape.bc.dao.model.BcMenu;
import com.dape.bc.dao.model.BcMenuExample;

/**
* 降级实现BcMenuService接口
* Created by dape on 2019/3/27.
*/
public class BcMenuServiceMock extends BaseServiceMock<BcMenuMapper, BcMenu, BcMenuExample> implements BcMenuService {

}
