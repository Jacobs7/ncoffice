package com.dape.pay.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.pay.dao.mapper.PayVestMapper;
import com.dape.pay.dao.model.PayVest;
import com.dape.pay.dao.model.PayVestExample;

/**
* 降级实现PayVestService接口
* Created by shuzheng on 2017/3/29.
*/
public class PayVestServiceMock extends BaseServiceMock<PayVestMapper, PayVest, PayVestExample> implements PayVestService {

}
