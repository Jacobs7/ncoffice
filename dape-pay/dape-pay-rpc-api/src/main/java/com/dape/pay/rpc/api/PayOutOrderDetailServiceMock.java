package com.dape.pay.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.pay.dao.mapper.PayOutOrderDetailMapper;
import com.dape.pay.dao.model.PayOutOrderDetail;
import com.dape.pay.dao.model.PayOutOrderDetailExample;

/**
* 降级实现PayOutOrderDetailService接口
* Created by shuzheng on 2017/3/29.
*/
public class PayOutOrderDetailServiceMock extends BaseServiceMock<PayOutOrderDetailMapper, PayOutOrderDetail, PayOutOrderDetailExample> implements PayOutOrderDetailService {

}
