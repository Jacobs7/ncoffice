package com.dape.datax.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.datax.dao.mapper.DataxTaskMapper;
import com.dape.datax.dao.model.DataxTask;
import com.dape.datax.dao.model.DataxTaskExample;

/**
* 降级实现DataxTaskService接口
* Created by dape on 2019/3/3.
*/
public class DataxTaskServiceMock extends BaseServiceMock<DataxTaskMapper, DataxTask, DataxTaskExample> implements DataxTaskService {

}
