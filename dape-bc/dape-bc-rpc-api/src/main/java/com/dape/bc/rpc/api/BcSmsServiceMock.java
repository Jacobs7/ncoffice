package com.dape.bc.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.bc.dao.mapper.BcSmsMapper;
import com.dape.bc.dao.model.BcSms;
import com.dape.bc.dao.model.BcSmsExample;

/**
* 降级实现BcSmsService接口
* Created by dape on 2019/3/27.
*/
public class BcSmsServiceMock extends BaseServiceMock<BcSmsMapper, BcSms, BcSmsExample> implements BcSmsService {

}
