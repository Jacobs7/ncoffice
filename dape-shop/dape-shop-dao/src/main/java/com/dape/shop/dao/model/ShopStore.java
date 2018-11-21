package com.dape.shop.dao.model;

import java.io.Serializable;
import java.util.Date;

public class ShopStore implements Serializable {
    private Long id;

    private Date createDate;

    /**
     * 卖家ID
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     * 店铺名称
     *
     * @mbg.generated
     */
    private String shopTitle;

    /**
     * 店铺类型，B：天猫，C：淘宝
     *
     * @mbg.generated
     */
    private String shopType;

    /**
     * 卖家昵称
     *
     * @mbg.generated
     */
    private String sellerNick;

    /**
     * 店标图片
     *
     * @mbg.generated
     */
    private String pictUrl;

    /**
     * 店铺地址
     *
     * @mbg.generated
     */
    private String shopUrl;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getShopTitle() {
        return shopTitle;
    }

    public void setShopTitle(String shopTitle) {
        this.shopTitle = shopTitle;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public String getSellerNick() {
        return sellerNick;
    }

    public void setSellerNick(String sellerNick) {
        this.sellerNick = sellerNick;
    }

    public String getPictUrl() {
        return pictUrl;
    }

    public void setPictUrl(String pictUrl) {
        this.pictUrl = pictUrl;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createDate=").append(createDate);
        sb.append(", userId=").append(userId);
        sb.append(", shopTitle=").append(shopTitle);
        sb.append(", shopType=").append(shopType);
        sb.append(", sellerNick=").append(sellerNick);
        sb.append(", pictUrl=").append(pictUrl);
        sb.append(", shopUrl=").append(shopUrl);
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
        ShopStore other = (ShopStore) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getShopTitle() == null ? other.getShopTitle() == null : this.getShopTitle().equals(other.getShopTitle()))
            && (this.getShopType() == null ? other.getShopType() == null : this.getShopType().equals(other.getShopType()))
            && (this.getSellerNick() == null ? other.getSellerNick() == null : this.getSellerNick().equals(other.getSellerNick()))
            && (this.getPictUrl() == null ? other.getPictUrl() == null : this.getPictUrl().equals(other.getPictUrl()))
            && (this.getShopUrl() == null ? other.getShopUrl() == null : this.getShopUrl().equals(other.getShopUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getShopTitle() == null) ? 0 : getShopTitle().hashCode());
        result = prime * result + ((getShopType() == null) ? 0 : getShopType().hashCode());
        result = prime * result + ((getSellerNick() == null) ? 0 : getSellerNick().hashCode());
        result = prime * result + ((getPictUrl() == null) ? 0 : getPictUrl().hashCode());
        result = prime * result + ((getShopUrl() == null) ? 0 : getShopUrl().hashCode());
        return result;
    }
}