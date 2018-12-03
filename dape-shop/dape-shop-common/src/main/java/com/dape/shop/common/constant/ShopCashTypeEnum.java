package com.dape.shop.common.constant;

public enum ShopCashTypeEnum {
    /**
     * 提现
     */
    TIXIAN(1, "提现"),

    /**
     * 充值
     */
    CHONGZHI(2, "充值"),

    /**
     * 佣金
     */
    YONGJIN(3, "佣金"),

    /**
     * 积分兑换
     */
    DUIHUAN(4, "积分兑换");


    public Integer code;

    public String message;

    ShopCashTypeEnum(Integer code, String message) {
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
        ShopCashTypeEnum[] businessModeEnums = values();
        for (ShopCashTypeEnum businessModeEnum : businessModeEnums) {
            if (businessModeEnum.getCode().intValue() == code.intValue()) {
                return businessModeEnum.getMessage();
            }
        }
        return null;
    }
}
