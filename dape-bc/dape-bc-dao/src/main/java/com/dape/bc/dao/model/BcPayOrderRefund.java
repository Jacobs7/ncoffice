package com.dape.bc.dao.model;

import java.io.Serializable;
import java.util.Date;

public class BcPayOrderRefund implements Serializable {
    private Long id;

    private Date createDate;

    /**
     * 是否启用
     *
     * @mbg.generated
     */
    private Boolean isEnabled;

    /**
     * 商户订单号
     *
     * @mbg.generated
     */
    private String outTradeNo;

    /**
     * 支付宝交易号
     *
     * @mbg.generated
     */
    private String tradeNo;

    /**
     * 退款金额
     *
     * @mbg.generated
     */
    private String refundAmount;

    /**
     * 退款原因
     *
     * @mbg.generated
     */
    private String refundReason;

    /**
     * 多次退同一笔款时的唯一标识
     *
     * @mbg.generated
     */
    private String requestNo;

    /**
     * 退款结果，0：处理中，1：退款成功，2：退款失败
     *
     * @mbg.generated
     */
    private Integer refundResult;

    /**
     * 退款请求唯一标识
     *
     * @mbg.generated
     */
    private String outRequestNo;

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

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public Integer getRefundResult() {
        return refundResult;
    }

    public void setRefundResult(Integer refundResult) {
        this.refundResult = refundResult;
    }

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
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
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", refundAmount=").append(refundAmount);
        sb.append(", refundReason=").append(refundReason);
        sb.append(", requestNo=").append(requestNo);
        sb.append(", refundResult=").append(refundResult);
        sb.append(", outRequestNo=").append(outRequestNo);
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
        BcPayOrderRefund other = (BcPayOrderRefund) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getIsEnabled() == null ? other.getIsEnabled() == null : this.getIsEnabled().equals(other.getIsEnabled()))
            && (this.getOutTradeNo() == null ? other.getOutTradeNo() == null : this.getOutTradeNo().equals(other.getOutTradeNo()))
            && (this.getTradeNo() == null ? other.getTradeNo() == null : this.getTradeNo().equals(other.getTradeNo()))
            && (this.getRefundAmount() == null ? other.getRefundAmount() == null : this.getRefundAmount().equals(other.getRefundAmount()))
            && (this.getRefundReason() == null ? other.getRefundReason() == null : this.getRefundReason().equals(other.getRefundReason()))
            && (this.getRequestNo() == null ? other.getRequestNo() == null : this.getRequestNo().equals(other.getRequestNo()))
            && (this.getRefundResult() == null ? other.getRefundResult() == null : this.getRefundResult().equals(other.getRefundResult()))
            && (this.getOutRequestNo() == null ? other.getOutRequestNo() == null : this.getOutRequestNo().equals(other.getOutRequestNo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getIsEnabled() == null) ? 0 : getIsEnabled().hashCode());
        result = prime * result + ((getOutTradeNo() == null) ? 0 : getOutTradeNo().hashCode());
        result = prime * result + ((getTradeNo() == null) ? 0 : getTradeNo().hashCode());
        result = prime * result + ((getRefundAmount() == null) ? 0 : getRefundAmount().hashCode());
        result = prime * result + ((getRefundReason() == null) ? 0 : getRefundReason().hashCode());
        result = prime * result + ((getRequestNo() == null) ? 0 : getRequestNo().hashCode());
        result = prime * result + ((getRefundResult() == null) ? 0 : getRefundResult().hashCode());
        result = prime * result + ((getOutRequestNo() == null) ? 0 : getOutRequestNo().hashCode());
        return result;
    }
}