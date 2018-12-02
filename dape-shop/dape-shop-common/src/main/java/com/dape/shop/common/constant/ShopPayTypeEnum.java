package com.dape.shop.common.constant;

public enum ShopPayTypeEnum {
    /**
     * 微信
     */
    UNUSED(1, "微信"),

    /**
     * 支付宝
     */
    ISUSED(2, "支付宝");


    public Integer code;

    public String message;

    ShopPayTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String getMessage(Integer code) {
        ShopPayTypeEnum[] businessModeEnums = values();
        for (ShopPayTypeEnum businessModeEnum : businessModeEnums) {
            if (businessModeEnum.getCode().intValue() == code.intValue()) {
                return businessModeEnum.getMessage();
            }
        }
        return null;
    }
}
