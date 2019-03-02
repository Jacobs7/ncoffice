package com.dape.pay.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.pay.dao.mapper.PayInOrderDetailMapper;
import com.dape.pay.dao.model.PayInOrderDetail;
import com.dape.pay.dao.model.PayInOrderDetailExample;

/**
* 降级实现PayInOrderDetailService接口
* Created by shuzheng on 2017/3/29.
*/
public class PayInOrderDetailServiceMock extends BaseServiceMock<PayInOrderDetailMapper, PayInOrderDetail, PayInOrderDetailExample> implements PayInOrderDetailService {

}
