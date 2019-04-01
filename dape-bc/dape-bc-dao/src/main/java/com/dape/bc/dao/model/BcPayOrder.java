package com.dape.bc.dao.model;

import java.io.Serializable;
import java.util.Date;

public class BcPayOrder implements Serializable {
    private Long id;

    private Date createDate;

    /**
     * 是否启用
     *
     * @mbg.generated
     */
    private Boolean isEnabled;

    /**
     * 商户网站订单号
     *
     * @mbg.generated
     */
    private String outTradeNo;

    /**
     * 付款金额
     *
     * @mbg.generated
     */
    private String totalAmount;

    /**
     * 订单名称
     *
     * @mbg.generated
     */
    private String subject;

    /**
     * 描述
     *
     * @mbg.generated
     */
    private String body;

    /**
     * 支付宝交易号
     *
     * @mbg.generated
     */
    private String tradeNo;

    /**
     * 支付结果，0：处理中，1：支付成功，2：支付失败
     *
     * @mbg.generated
     */
    private Integer payResult;

    /**
     * 1:全部退款,2:部分退款
     *
     * @mbg.generated
     */
    private Integer refundResult;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Integer getPayResult() {
        return payResult;
    }

    public void setPayResult(Integer payResult) {
        this.payResult = payResult;
    }

    public Integer getRefundResult() {
        return refundResult;
    }

    public void setRefundResult(Integer refundResult) {
        this.refundResult = refundResult;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createDate=").append(createDate);
        sb.append(", isEnabled=").append(isEnabled);
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", subject=").append(subject);
        sb.append(", body=").append(body);
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", payResult=").append(payResult);
        sb.append(", refundResult=").append(refundResult);
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
        BcPayOrder other = (BcPayOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getIsEnabled() == null ? other.getIsEnabled() == null : this.getIsEnabled().equals(other.getIsEnabled()))
            && (this.getOutTradeNo() == null ? other.getOutTradeNo() == null : this.getOutTradeNo().equals(other.getOutTradeNo()))
            && (this.getTotalAmount() == null ? other.getTotalAmount() == null : this.getTotalAmount().equals(other.getTotalAmount()))
            && (this.getSubject() == null ? other.getSubject() == null : this.getSubject().equals(other.getSubject()))
            && (this.getBody() == null ? other.getBody() == null : this.getBody().equals(other.getBody()))
            && (this.getTradeNo() == null ? other.getTradeNo() == null : this.getTradeNo().equals(other.getTradeNo()))
            && (this.getPayResult() == null ? other.getPayResult() == null : this.getPayResult().equals(other.getPayResult()))
            && (this.getRefundResult() == null ? other.getRefundResult() == null : this.getRefundResult().equals(other.getRefundResult()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getIsEnabled() == null) ? 0 : getIsEnabled().hashCode());
        result = prime * result + ((getOutTradeNo() == null) ? 0 : getOutTradeNo().hashCode());
        result = prime * result + ((getTotalAmount() == null) ? 0 : getTotalAmount().hashCode());
        result = prime * result + ((getSubject() == null) ? 0 : getSubject().hashCode());
        result = prime * result + ((getBody() == null) ? 0 : getBody().hashCode());
        result = prime * result + ((getTradeNo() == null) ? 0 : getTradeNo().hashCode());
        result = prime * result + ((getPayResult() == null) ? 0 : getPayResult().hashCode());
        result = prime * result + ((getRefundResult() == null) ? 0 : getRefundResult().hashCode());
        return result;
    }
}