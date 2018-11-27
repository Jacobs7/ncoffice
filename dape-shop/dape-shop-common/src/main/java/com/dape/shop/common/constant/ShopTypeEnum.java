package com.dape.shop.common.constant;

public enum ShopTypeEnum {
    /**
     * 天猫
     */
    TIANMAO("B", "天猫"),

    /**
     * 淘宝
     */
    TAOBAO("C", "淘宝");


    public String code;

    public String message;

    ShopTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public static String getMessage(String value) {
        ShopTypeEnum[] businessModeEnums = values();
        for (ShopTypeEnum businessModeEnum : businessModeEnums) {
            if (businessModeEnum.getCode().equals(value)) {
                return businessModeEnum.getMessage();
            }
        }
        return null;
    }
}
