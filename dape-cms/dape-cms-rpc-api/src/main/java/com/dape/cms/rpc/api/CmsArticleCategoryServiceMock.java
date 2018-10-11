package com.dape.cms.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.cms.dao.mapper.CmsArticleCategoryMapper;
import com.dape.cms.dao.model.CmsArticleCategory;
import com.dape.cms.dao.model.CmsArticleCategoryExample;

/**
* 降级实现CmsArticleCategoryService接口
* Created by shuzheng on 2017/4/5.
*/
public class CmsArticleCategoryServiceMock extends BaseServiceMock<CmsArticleCategoryMapper, CmsArticleCategory, CmsArticleCategoryExample> implements CmsArticleCategoryService {

}
