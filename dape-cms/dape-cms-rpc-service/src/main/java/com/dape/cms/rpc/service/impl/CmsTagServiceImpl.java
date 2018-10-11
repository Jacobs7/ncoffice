package com.dape.cms.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.cms.dao.mapper.CmsTagMapper;
import com.dape.cms.dao.model.CmsTag;
import com.dape.cms.dao.model.CmsTagExample;
import com.dape.cms.rpc.api.CmsTagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CmsTagService实现
* Created by shuzheng on 2017/4/5.
*/
@Service
@Transactional
@BaseService
public class CmsTagServiceImpl extends BaseServiceImpl<CmsTagMapper, CmsTag, CmsTagExample> implements CmsTagService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsTagServiceImpl.class);

    @Autowired
    CmsTagMapper cmsTagMapper;

}