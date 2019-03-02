package com.dape.pay.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.pay.dao.mapper.PayTypeMapper;
import com.dape.pay.dao.model.PayType;
import com.dape.pay.dao.model.PayTypeExample;

/**
* 降级实现PayTypeService接口
* Created by shuzheng on 2017/3/29.
*/
public class PayTypeServiceMock extends BaseServiceMock<PayTypeMapper, PayType, PayTypeExample> implements PayTypeService {

}
