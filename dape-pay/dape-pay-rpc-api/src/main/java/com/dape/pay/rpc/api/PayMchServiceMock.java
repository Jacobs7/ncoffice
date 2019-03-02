package com.dape.pay.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.pay.dao.mapper.PayMchMapper;
import com.dape.pay.dao.model.PayMch;
import com.dape.pay.dao.model.PayMchExample;

/**
* 降级实现PayMchService接口
* Created by shuzheng on 2017/3/29.
*/
public class PayMchServiceMock extends BaseServiceMock<PayMchMapper, PayMch, PayMchExample> implements PayMchService {

}
