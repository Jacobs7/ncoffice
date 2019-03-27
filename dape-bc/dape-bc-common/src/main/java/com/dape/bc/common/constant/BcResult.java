package com.dape.bc.common.constant;

import com.dape.common.base.BaseResult;

public class BcResult extends BaseResult {
    public BcResult(BcResultConstant dataxResultConstant, Object data) {
        super(dataxResultConstant.getCode(), dataxResultConstant.getMessage(), data);
    }
}
