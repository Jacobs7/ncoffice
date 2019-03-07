package com.dape.datax.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.datax.dao.mapper.DataxSourceTypeMapper;
import com.dape.datax.dao.model.DataxSourceType;
import com.dape.datax.dao.model.DataxSourceTypeExample;

/**
* 降级实现DataxSourceTypeService接口
* Created by dape on 2019/3/3.
*/
public class DataxSourceTypeServiceMock extends BaseServiceMock<

        DataxSourceTypeMapper, DataxSourceType, DataxSourceTypeExample> implements DataxSourceTypeService {

}
