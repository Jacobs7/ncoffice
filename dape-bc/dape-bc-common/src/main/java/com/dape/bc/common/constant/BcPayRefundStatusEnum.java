package com.dape.bc.common.constant;

public enum BcPayRefundStatusEnum {
    /**
     * 未退款
     */
    NO(0, "未退款"),
    /**
     * 全部退款
     */
    REFUND_ALL(1, "全部退款"),
    /**
     * 支付成功
     */
    REFUND_PART(2, "部分退款");


    public Integer code;

    public String message;

    BcPayRefundStatusEnum(Integer code, String message) {
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
        BcPayRefundStatusEnum[] businessModeEnums = values();
        for (BcPayRefundStatusEnum businessModeEnum : businessModeEnums) {
            if (businessModeEnum.getCode().intValue() == code.intValue()) {
                return businessModeEnum.getMessage();
            }
        }
        return null;
    }
}
