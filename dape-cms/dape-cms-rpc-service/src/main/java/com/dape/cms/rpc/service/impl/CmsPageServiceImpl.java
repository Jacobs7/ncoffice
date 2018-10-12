package com.dape.cms.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.cms.dao.mapper.CmsPageMapper;
import com.dape.cms.dao.model.CmsPage;
import com.dape.cms.dao.model.CmsPageExample;
import com.dape.cms.rpc.api.CmsPageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CmsPageService实现
* ncoffice on 2017/4/5.
*/
@Service
@Transactional
@BaseService
public class CmsPageServiceImpl extends BaseServiceImpl<CmsPageMapper, CmsPage, CmsPageExample> implements CmsPageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsPageServiceImpl.class);

    @Autowired
    CmsPageMapper cmsPageMapper;

}