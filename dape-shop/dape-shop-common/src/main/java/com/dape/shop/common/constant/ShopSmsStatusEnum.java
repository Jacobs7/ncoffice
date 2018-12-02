package com.dape.shop.common.constant;

public enum ShopSmsStatusEnum {
    /**
     * 处理中
     */
    UNUSED(1, "未使用"),

    /**
     * 充值
     */
    ISUSED(2, "已使用");


    public Integer code;

    public String message;

    ShopSmsStatusEnum(Integer code, String message) {
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
        ShopSmsStatusEnum[] businessModeEnums = values();
        for (ShopSmsStatusEnum businessModeEnum : businessModeEnums) {
            if (businessModeEnum.getCode().intValue() == code.intValue()) {
                return businessModeEnum.getMessage();
            }
        }
        return null;
    }
}
