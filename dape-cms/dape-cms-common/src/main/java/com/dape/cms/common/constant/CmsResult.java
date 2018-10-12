package com.dape.cms.common.constant;

import com.dape.common.base.BaseResult;

/**
 * cms系统常量枚举类
 * ncoffice on 2017/2/19.
 */
public class CmsResult extends BaseResult {

    public CmsResult(CmsResultConstant cmsResultConstant, Object data) {
        super(cmsResultConstant.getCode(), cmsResultConstant.getMessage(), data);
    }

}
