package com.dape.bc.common.constant;

public enum BcPayStatusEnum {
    /**
     * 处理中
     */
    PROCESSING(0, "处理中"),
    /**
     * 支付成功
     */
    SUCCESS(1, "支付成功"),

    /**
     * 支付失败
     */
    FAIL(2, "支付失败");


    public Integer code;

    public String message;

    BcPayStatusEnum(Integer code, String message) {
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
        BcPayStatusEnum[] businessModeEnums = values();
        for (BcPayStatusEnum businessModeEnum : businessModeEnums) {
            if (businessModeEnum.getCode().intValue() == code.intValue()) {
                return businessModeEnum.getMessage();
            }
        }
        return null;
    }
}
