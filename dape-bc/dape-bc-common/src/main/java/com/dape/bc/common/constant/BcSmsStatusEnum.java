package com.dape.bc.common.constant;

public enum BcSmsStatusEnum {
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

    BcSmsStatusEnum(Integer code, String message) {
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
        BcSmsStatusEnum[] businessModeEnums = values();
        for (BcSmsStatusEnum businessModeEnum : businessModeEnums) {
            if (businessModeEnum.getCode().intValue() == code.intValue()) {
                return businessModeEnum.getMessage();
            }
        }
        return null;
    }
}
