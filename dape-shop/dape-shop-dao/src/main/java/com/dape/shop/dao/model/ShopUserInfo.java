package com.dape.shop.dao.model;

import java.io.Serializable;

public class ShopUserInfo implements Serializable {
    private Long id;

    private Long shopUserId;

    /**
     * 性别：0：男，1：女
     *
     * @mbg.generated
     */
    private Boolean sex;

    /**
     * 手机
     *
     * @mbg.generated
     */
    private String mobile;

    /**
     * 地址
     *
     * @mbg.generated
     */
    private String address;

    /**
     * 支付宝帐号
     *
     * @mbg.generated
     */
    private String zfbAccount;

    /**
     * 支付宝姓名
     *
     * @mbg.generated
     */
    private String zfbName;

    /**
     * 提现支付方式，1：微信，2：支付宝
     *
     * @mbg.generated
     */
    private Integer payType;

    /**
     * 支付帐号
     *
     * @mbg.generated
     */
    private String payAccount;

    /**
     * 支付姓名
     *
     * @mbg.generated
     */
    private String payName;

    /**
     * 平台，B：天猫，C：淘宝
     *
     * @mbg.generated
     */
    private String company;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopUserId() {
        return shopUserId;
    }

    public void setShopUserId(Long shopUserId) {
        this.shopUserId = shopUserId;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZfbAccount() {
        return zfbAccount;
    }

    public void setZfbAccount(String zfbAccount) {
        this.zfbAccount = zfbAccount;
    }

    public String getZfbName() {
        return zfbName;
    }

    public void setZfbName(String zfbName) {
        this.zfbName = zfbName;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shopUserId=").append(shopUserId);
        sb.append(", sex=").append(sex);
        sb.append(", mobile=").append(mobile);
        sb.append(", address=").append(address);
        sb.append(", zfbAccount=").append(zfbAccount);
        sb.append(", zfbName=").append(zfbName);
        sb.append(", payType=").append(payType);
        sb.append(", payAccount=").append(payAccount);
        sb.append(", payName=").append(payName);
        sb.append(", company=").append(company);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ShopUserInfo other = (ShopUserInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getShopUserId() == null ? other.getShopUserId() == null : this.getShopUserId().equals(other.getShopUserId()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getZfbAccount() == null ? other.getZfbAccount() == null : this.getZfbAccount().equals(other.getZfbAccount()))
            && (this.getZfbName() == null ? other.getZfbName() == null : this.getZfbName().equals(other.getZfbName()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getPayAccount() == null ? other.getPayAccount() == null : this.getPayAccount().equals(other.getPayAccount()))
            && (this.getPayName() == null ? other.getPayName() == null : this.getPayName().equals(other.getPayName()))
            && (this.getCompany() == null ? other.getCompany() == null : this.getCompany().equals(other.getCompany()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getShopUserId() == null) ? 0 : getShopUserId().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getZfbAccount() == null) ? 0 : getZfbAccount().hashCode());
        result = prime * result + ((getZfbName() == null) ? 0 : getZfbName().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getPayAccount() == null) ? 0 : getPayAccount().hashCode());
        result = prime * result + ((getPayName() == null) ? 0 : getPayName().hashCode());
        result = prime * result + ((getCompany() == null) ? 0 : getCompany().hashCode());
        return result;
    }
}