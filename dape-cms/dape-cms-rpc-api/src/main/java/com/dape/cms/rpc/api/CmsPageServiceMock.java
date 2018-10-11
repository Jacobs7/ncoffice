package com.dape.cms.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.cms.dao.mapper.CmsPageMapper;
import com.dape.cms.dao.model.CmsPage;
import com.dape.cms.dao.model.CmsPageExample;

/**
* 降级实现CmsPageService接口
* Created by shuzheng on 2017/4/5.
*/
public class CmsPageServiceMock extends BaseServiceMock<CmsPageMapper, CmsPage, CmsPageExample> implements CmsPageService {

}
