package com.dape.cms.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.cms.dao.mapper.CmsMenuMapper;
import com.dape.cms.dao.model.CmsMenu;
import com.dape.cms.dao.model.CmsMenuExample;

/**
* 降级实现CmsMenuService接口
* ncoffice on 2017/4/5.
*/
public class CmsMenuServiceMock extends BaseServiceMock<CmsMenuMapper, CmsMenu, CmsMenuExample> implements CmsMenuService {

}
