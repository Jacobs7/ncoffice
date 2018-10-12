package com.dape.cms.rpc.service.impl;

import com.dape.common.annotation.BaseService;
import com.dape.common.base.BaseServiceImpl;
import com.dape.cms.dao.mapper.CmsSystemMapper;
import com.dape.cms.dao.model.CmsSystem;
import com.dape.cms.dao.model.CmsSystemExample;
import com.dape.cms.rpc.api.CmsSystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CmsSystemService实现
* ncoffice on 2017/4/5.
*/
@Service
@Transactional
@BaseService
public class CmsSystemServiceImpl extends BaseServiceImpl<CmsSystemMapper, CmsSystem, CmsSystemExample> implements CmsSystemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsSystemServiceImpl.class);

    @Autowired
    CmsSystemMapper cmsSystemMapper;

}