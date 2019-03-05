package com.dape.datax.common.constant;

import com.dape.common.base.BaseResult;

public class DataxResult  extends BaseResult {
    public DataxResult(DataxResultConstant dataxResultConstant, Object data) {
        super(dataxResultConstant.getCode(), dataxResultConstant.getMessage(), data);
    }
}
