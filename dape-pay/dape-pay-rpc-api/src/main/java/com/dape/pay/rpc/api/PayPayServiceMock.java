package com.dape.pay.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.pay.dao.mapper.PayPayMapper;
import com.dape.pay.dao.model.PayPay;
import com.dape.pay.dao.model.PayPayExample;

/**
* 降级实现PayPayService接口
* Created by shuzheng on 2017/3/29.
*/
public class PayPayServiceMock extends BaseServiceMock<PayPayMapper, PayPay, PayPayExample> implements PayPayService {

}
