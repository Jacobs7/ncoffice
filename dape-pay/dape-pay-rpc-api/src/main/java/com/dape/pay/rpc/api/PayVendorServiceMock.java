package com.dape.pay.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.pay.dao.mapper.PayVendorMapper;
import com.dape.pay.dao.model.PayVendor;
import com.dape.pay.dao.model.PayVendorExample;

/**
* 降级实现PayVendorService接口
* Created by shuzheng on 2017/3/29.
*/
public class PayVendorServiceMock extends BaseServiceMock<PayVendorMapper, PayVendor, PayVendorExample> implements PayVendorService {

}
