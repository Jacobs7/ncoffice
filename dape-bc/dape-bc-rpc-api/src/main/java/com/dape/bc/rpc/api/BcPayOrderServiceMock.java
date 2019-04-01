package com.dape.bc.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.bc.dao.mapper.BcPayOrderMapper;
import com.dape.bc.dao.model.BcPayOrder;
import com.dape.bc.dao.model.BcPayOrderExample;

/**
* 降级实现BcPayOrderService接口
* Created by dape on 2019/4/1.
*/
public class BcPayOrderServiceMock extends BaseServiceMock<BcPayOrderMapper, BcPayOrder, BcPayOrderExample> implements BcPayOrderService {

}
