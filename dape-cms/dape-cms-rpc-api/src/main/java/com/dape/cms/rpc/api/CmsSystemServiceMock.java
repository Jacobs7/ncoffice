package com.dape.cms.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.cms.dao.mapper.CmsSystemMapper;
import com.dape.cms.dao.model.CmsSystem;
import com.dape.cms.dao.model.CmsSystemExample;

/**
* 降级实现CmsSystemService接口
* Created by shuzheng on 2017/4/5.
*/
public class CmsSystemServiceMock extends BaseServiceMock<CmsSystemMapper, CmsSystem, CmsSystemExample> implements CmsSystemService {

}
