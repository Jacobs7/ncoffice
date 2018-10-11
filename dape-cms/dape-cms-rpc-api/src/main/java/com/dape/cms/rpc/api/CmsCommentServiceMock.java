package com.dape.cms.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.cms.dao.mapper.CmsCommentMapper;
import com.dape.cms.dao.model.CmsComment;
import com.dape.cms.dao.model.CmsCommentExample;

/**
* 降级实现CmsCommentService接口
* Created by shuzheng on 2017/4/5.
*/
public class CmsCommentServiceMock extends BaseServiceMock<CmsCommentMapper, CmsComment, CmsCommentExample> implements CmsCommentService {

}
