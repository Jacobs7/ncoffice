package com.dape.pay.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.pay.dao.mapper.PayOutOrderMapper;
import com.dape.pay.dao.model.PayOutOrder;
import com.dape.pay.dao.model.PayOutOrderExample;

/**
* 降级实现PayOutOrderService接口
* Created by shuzheng on 2017/3/29.
*/
public class PayOutOrderServiceMock extends BaseServiceMock<PayOutOrderMapper, PayOutOrder, PayOutOrderExample> implements PayOutOrderService {

}
