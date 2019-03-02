package com.dape.pay.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.pay.dao.mapper.PayInOrderMapper;
import com.dape.pay.dao.model.PayInOrder;
import com.dape.pay.dao.model.PayInOrderExample;

/**
* 降级实现PayInOrderService接口
* Created by shuzheng on 2017/3/29.
*/
public class PayInOrderServiceMock extends BaseServiceMock<PayInOrderMapper, PayInOrder, PayInOrderExample> implements PayInOrderService {

}
