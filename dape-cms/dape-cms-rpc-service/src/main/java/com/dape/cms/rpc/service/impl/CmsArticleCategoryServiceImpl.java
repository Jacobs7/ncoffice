package com.dape.cms.rpc.service.impl;

import com.dape.cms.dao.mapper.CmsArticleCategoryMapper;
import com.dape.cms.dao.model.CmsArticleCategory;
import com.dape.cms.dao.model.CmsArticleCategoryExample;
import com.dape.cms.rpc.api.CmsArticleCategoryService;
import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CmsArticleCategoryService实现
* ncoffice on 2017/4/5.
*/
@Service
@Transactional
@BaseService
public class CmsArticleCategoryServiceImpl extends BaseServiceImpl<CmsArticleCategoryMapper, CmsArticleCategory, CmsArticleCategoryExample> implements CmsArticleCategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsArticleCategoryServiceImpl.class);

    @Autowired
    CmsArticleCategoryMapper cmsArticleCategoryMapper;

}