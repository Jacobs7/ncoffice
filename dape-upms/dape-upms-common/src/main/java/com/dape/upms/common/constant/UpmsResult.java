package com.dape.upms.common.constant;

import com.dape.common.base.BaseResult;

/**
 * upms系统常量枚举类
 * ncoffice on 2017/2/18.
 */
public class UpmsResult extends BaseResult {

    public UpmsResult(UpmsResultConstant upmsResultConstant, Object data) {
        super(upmsResultConstant.getCode(), upmsResultConstant.getMessage(), data);
    }

}
