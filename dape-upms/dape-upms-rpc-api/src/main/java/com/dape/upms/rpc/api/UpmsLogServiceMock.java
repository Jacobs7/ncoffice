package com.dape.upms.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.upms.dao.mapper.UpmsLogMapper;
import com.dape.upms.dao.model.UpmsLog;
import com.dape.upms.dao.model.UpmsLogExample;

/**
* 降级实现UpmsLogService接口
* ncoffice on 2017/3/20.
*/
public class UpmsLogServiceMock extends BaseServiceMock<UpmsLogMapper, UpmsLog, UpmsLogExample> implements UpmsLogService {

}
