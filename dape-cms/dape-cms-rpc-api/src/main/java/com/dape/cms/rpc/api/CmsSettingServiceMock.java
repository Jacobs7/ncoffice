package com.dape.cms.rpc.api;

import com.dape.common.base.BaseServiceMock;
import com.dape.cms.dao.mapper.CmsSettingMapper;
import com.dape.cms.dao.model.CmsSetting;
import com.dape.cms.dao.model.CmsSettingExample;

/**
* 降级实现CmsSettingService接口
* ncoffice on 2017/4/5.
*/
public class CmsSettingServiceMock extends BaseServiceMock<CmsSettingMapper, CmsSetting, CmsSettingExample> implements CmsSettingService {

}
