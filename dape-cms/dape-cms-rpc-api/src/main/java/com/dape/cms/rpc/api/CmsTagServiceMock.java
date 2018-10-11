package com.dape.cms.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.cms.dao.mapper.CmsTagMapper;
import com.dape.cms.dao.model.CmsTag;
import com.dape.cms.dao.model.CmsTagExample;

/**
* 降级实现CmsTagService接口
* Created by shuzheng on 2017/4/5.
*/
public class CmsTagServiceMock extends BaseServiceMock<CmsTagMapper, CmsTag, CmsTagExample> implements CmsTagService {

}
