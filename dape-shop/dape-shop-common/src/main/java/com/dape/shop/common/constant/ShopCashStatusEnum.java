package com.dape.shop.common.constant;

public enum ShopCashStatusEnum {
    /**
     * 处理中
     */
    CHULIZHONG(1, "处理中"),

    /**
     * 充值
     */
    CHONGGONG(2, "成功");


    public Integer code;

    public String message;

    ShopCashStatusEnum(Integer code, String message) {
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
        ShopCashStatusEnum[] businessModeEnums = values();
        for (ShopCashStatusEnum businessModeEnum : businessModeEnums) {
            if (businessModeEnum.getCode().intValue() == code.intValue()) {
                return businessModeEnum.getMessage();
            }
        }
        return null;
    }
}
