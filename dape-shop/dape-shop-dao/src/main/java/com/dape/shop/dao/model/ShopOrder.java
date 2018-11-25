package com.dape.shop.dao.model;

import java.io.Serializable;
import java.util.Date;

public class ShopOrder implements Serializable {
    private Long id;

    /**
     * 订单时间
     *
     * @mbg.generated
     */
    private Date createDate;

    /**
     * 订单号
     *
     * @mbg.generated
     */
    private String orderId;

    /**
     * 商品号
     *
     * @mbg.generated
     */
    private String googsId;

    /**
     * 卖家id
     *
     * @mbg.generated
     */
    private Long sellerId;

    /**
     * 商城用户id
     *
     * @mbg.generated
     */
    private Long shopUserId;

    /**
     * 1:已生成订单，2:已收货订单，3:已返佣订单
     *
     * @mbg.generated
     */
    private Integer status;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoogsId() {
        return googsId;
    }

    public void setGoogsId(String googsId) {
        this.googsId = googsId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getShopUserId() {
        return shopUserId;
    }

    public void setShopUserId(Long shopUserId) {
        this.shopUserId = shopUserId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createDate=").append(createDate);
        sb.append(", orderId=").append(orderId);
        sb.append(", googsId=").append(googsId);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", shopUserId=").append(shopUserId);
        sb.append(", status=").append(status);
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
        ShopOrder other = (ShopOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getGoogsId() == null ? other.getGoogsId() == null : this.getGoogsId().equals(other.getGoogsId()))
            && (this.getSellerId() == null ? other.getSellerId() == null : this.getSellerId().equals(other.getSellerId()))
            && (this.getShopUserId() == null ? other.getShopUserId() == null : this.getShopUserId().equals(other.getShopUserId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getGoogsId() == null) ? 0 : getGoogsId().hashCode());
        result = prime * result + ((getSellerId() == null) ? 0 : getSellerId().hashCode());
        result = prime * result + ((getShopUserId() == null) ? 0 : getShopUserId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}