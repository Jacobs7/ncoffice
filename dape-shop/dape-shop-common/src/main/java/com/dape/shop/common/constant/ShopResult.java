package com.dape.shop.common.constant;

import com.dape.common.base.BaseResult;

/**
 * cms系统常量枚举类
 * ncoffice on 2017/2/19.
 */
public class ShopResult extends BaseResult {

    public ShopResult(ShopResultConstant shopResultConstant, Object data) {
        super(shopResultConstant.getCode(), shopResultConstant.getMessage(), data);
    }

}
