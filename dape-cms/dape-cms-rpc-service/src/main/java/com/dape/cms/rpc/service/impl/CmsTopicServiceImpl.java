package com.dape.cms.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.cms.dao.mapper.CmsTopicMapper;
import com.dape.cms.dao.model.CmsTopic;
import com.dape.cms.dao.model.CmsTopicExample;
import com.dape.cms.rpc.api.CmsTopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CmsTopicService实现
* Created by shuzheng on 2017/4/5.
*/
@Service
@Transactional
@BaseService
public class CmsTopicServiceImpl extends BaseServiceImpl<CmsTopicMapper, CmsTopic, CmsTopicExample> implements CmsTopicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsTopicServiceImpl.class);

    @Autowired
    CmsTopicMapper cmsTopicMapper;

}