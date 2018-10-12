package com.dape.cms.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.cms.dao.mapper.CmsTopicMapper;
import com.dape.cms.dao.model.CmsTopic;
import com.dape.cms.dao.model.CmsTopicExample;

/**
* 降级实现CmsTopicService接口
* ncoffice on 2017/4/5.
*/
public class CmsTopicServiceMock extends BaseServiceMock<CmsTopicMapper, CmsTopic, CmsTopicExample> implements CmsTopicService {

}
