package com.dape.cms.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.cms.dao.mapper.CmsCategoryMapper;
import com.dape.cms.dao.model.CmsCategory;
import com.dape.cms.dao.model.CmsCategoryExample;

/**
* 降级实现CmsCategoryService接口
* Created by shuzheng on 2017/4/5.
*/
public class CmsCategoryServiceMock extends BaseServiceMock<CmsCategoryMapper, CmsCategory, CmsCategoryExample> implements CmsCategoryService {

}
