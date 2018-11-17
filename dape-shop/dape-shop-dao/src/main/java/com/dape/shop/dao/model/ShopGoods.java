package com.dape.shop.dao.model;

import java.io.Serializable;
import java.util.Date;

public class ShopGoods implements Serializable {
    private Long id;

    private Date createDate;

    /**
     * 商品ID
     *
     * @mbg.generated
     */
    private String numIid;

    /**
     * 商品标题
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 商品主图
     *
     * @mbg.generated
     */
    private String pictUrl;

    /**
     * 商品小图列表
     *
     * @mbg.generated
     */
    private String smallImages;

    /**
     * 商品一口价格
     *
     * @mbg.generated
     */
    private String reservePrice;

    /**
     * 商品折扣价格
     *
     * @mbg.generated
     */
    private String zkFinalPrice;

    /**
     * 卖家类型，0表示集市，1表示商城
     *
     * @mbg.generated
     */
    private Integer userType;

    /**
     * 宝贝所在地
     *
     * @mbg.generated
     */
    private String provcity;

    /**
     * 商品地址
     *
     * @mbg.generated
     */
    private String itemUrl;

    /**
     * 卖家昵称
     *
     * @mbg.generated
     */
    private String nick;

    /**
     * 卖家id
     *
     * @mbg.generated
     */
    private Integer sellerId;

    /**
     * 30天销量
     *
     * @mbg.generated
     */
    private Integer volume;

    /**
     * 叶子类目名称
     *
     * @mbg.generated
     */
    private String catLeafName;

    /**
     * boolean类型：是否加入消费者保障
     *
     * @mbg.generated
     */
    private Boolean isPrepay;

    /**
     * 店铺dsr 评分
     *
     * @mbg.generated
     */
    private Integer shopDsr;

    /**
     * 卖家等级
     *
     * @mbg.generated
     */
    private Integer ratesum;

    /**
     * 退款率是否低于行业均值
     *
     * @mbg.generated
     */
    private Boolean iRfdRate;

    /**
     * 好评率是否高于行业均值
     *
     * @mbg.generated
     */
    private Boolean hGoodRate;

    /**
     * 成交转化是否高于行业均值
     *
     * @mbg.generated
     */
    private Boolean hPayRate30;

    /**
     * 是否包邮
     *
     * @mbg.generated
     */
    private Boolean freeShipment;

    /**
     * 商品库类型，支持多库类型输出，以“，”区分，1:营销商品主推库
     *
     * @mbg.generated
     */
    private String materialLibType;

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

    public String getNumIid() {
        return numIid;
    }

    public void setNumIid(String numIid) {
        this.numIid = numIid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPictUrl() {
        return pictUrl;
    }

    public void setPictUrl(String pictUrl) {
        this.pictUrl = pictUrl;
    }

    public String getSmallImages() {
        return smallImages;
    }

    public void setSmallImages(String smallImages) {
        this.smallImages = smallImages;
    }

    public String getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(String reservePrice) {
        this.reservePrice = reservePrice;
    }

    public String getZkFinalPrice() {
        return zkFinalPrice;
    }

    public void setZkFinalPrice(String zkFinalPrice) {
        this.zkFinalPrice = zkFinalPrice;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getProvcity() {
        return provcity;
    }

    public void setProvcity(String provcity) {
        this.provcity = provcity;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getCatLeafName() {
        return catLeafName;
    }

    public void setCatLeafName(String catLeafName) {
        this.catLeafName = catLeafName;
    }

    public Boolean getIsPrepay() {
        return isPrepay;
    }

    public void setIsPrepay(Boolean isPrepay) {
        this.isPrepay = isPrepay;
    }

    public Integer getShopDsr() {
        return shopDsr;
    }

    public void setShopDsr(Integer shopDsr) {
        this.shopDsr = shopDsr;
    }

    public Integer getRatesum() {
        return ratesum;
    }

    public void setRatesum(Integer ratesum) {
        this.ratesum = ratesum;
    }

    public Boolean getiRfdRate() {
        return iRfdRate;
    }

    public void setiRfdRate(Boolean iRfdRate) {
        this.iRfdRate = iRfdRate;
    }

    public Boolean gethGoodRate() {
        return hGoodRate;
    }

    public void sethGoodRate(Boolean hGoodRate) {
        this.hGoodRate = hGoodRate;
    }

    public Boolean gethPayRate30() {
        return hPayRate30;
    }

    public void sethPayRate30(Boolean hPayRate30) {
        this.hPayRate30 = hPayRate30;
    }

    public Boolean getFreeShipment() {
        return freeShipment;
    }

    public void setFreeShipment(Boolean freeShipment) {
        this.freeShipment = freeShipment;
    }

    public String getMaterialLibType() {
        return materialLibType;
    }

    public void setMaterialLibType(String materialLibType) {
        this.materialLibType = materialLibType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createDate=").append(createDate);
        sb.append(", numIid=").append(numIid);
        sb.append(", title=").append(title);
        sb.append(", pictUrl=").append(pictUrl);
        sb.append(", smallImages=").append(smallImages);
        sb.append(", reservePrice=").append(reservePrice);
        sb.append(", zkFinalPrice=").append(zkFinalPrice);
        sb.append(", userType=").append(userType);
        sb.append(", provcity=").append(provcity);
        sb.append(", itemUrl=").append(itemUrl);
        sb.append(", nick=").append(nick);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", volume=").append(volume);
        sb.append(", catLeafName=").append(catLeafName);
        sb.append(", isPrepay=").append(isPrepay);
        sb.append(", shopDsr=").append(shopDsr);
        sb.append(", ratesum=").append(ratesum);
        sb.append(", iRfdRate=").append(iRfdRate);
        sb.append(", hGoodRate=").append(hGoodRate);
        sb.append(", hPayRate30=").append(hPayRate30);
        sb.append(", freeShipment=").append(freeShipment);
        sb.append(", materialLibType=").append(materialLibType);
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
        ShopGoods other = (ShopGoods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getNumIid() == null ? other.getNumIid() == null : this.getNumIid().equals(other.getNumIid()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getPictUrl() == null ? other.getPictUrl() == null : this.getPictUrl().equals(other.getPictUrl()))
            && (this.getSmallImages() == null ? other.getSmallImages() == null : this.getSmallImages().equals(other.getSmallImages()))
            && (this.getReservePrice() == null ? other.getReservePrice() == null : this.getReservePrice().equals(other.getReservePrice()))
            && (this.getZkFinalPrice() == null ? other.getZkFinalPrice() == null : this.getZkFinalPrice().equals(other.getZkFinalPrice()))
            && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
            && (this.getProvcity() == null ? other.getProvcity() == null : this.getProvcity().equals(other.getProvcity()))
            && (this.getItemUrl() == null ? other.getItemUrl() == null : this.getItemUrl().equals(other.getItemUrl()))
            && (this.getNick() == null ? other.getNick() == null : this.getNick().equals(other.getNick()))
            && (this.getSellerId() == null ? other.getSellerId() == null : this.getSellerId().equals(other.getSellerId()))
            && (this.getVolume() == null ? other.getVolume() == null : this.getVolume().equals(other.getVolume()))
            && (this.getCatLeafName() == null ? other.getCatLeafName() == null : this.getCatLeafName().equals(other.getCatLeafName()))
            && (this.getIsPrepay() == null ? other.getIsPrepay() == null : this.getIsPrepay().equals(other.getIsPrepay()))
            && (this.getShopDsr() == null ? other.getShopDsr() == null : this.getShopDsr().equals(other.getShopDsr()))
            && (this.getRatesum() == null ? other.getRatesum() == null : this.getRatesum().equals(other.getRatesum()))
            && (this.getiRfdRate() == null ? other.getiRfdRate() == null : this.getiRfdRate().equals(other.getiRfdRate()))
            && (this.gethGoodRate() == null ? other.gethGoodRate() == null : this.gethGoodRate().equals(other.gethGoodRate()))
            && (this.gethPayRate30() == null ? other.gethPayRate30() == null : this.gethPayRate30().equals(other.gethPayRate30()))
            && (this.getFreeShipment() == null ? other.getFreeShipment() == null : this.getFreeShipment().equals(other.getFreeShipment()))
            && (this.getMaterialLibType() == null ? other.getMaterialLibType() == null : this.getMaterialLibType().equals(other.getMaterialLibType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getNumIid() == null) ? 0 : getNumIid().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getPictUrl() == null) ? 0 : getPictUrl().hashCode());
        result = prime * result + ((getSmallImages() == null) ? 0 : getSmallImages().hashCode());
        result = prime * result + ((getReservePrice() == null) ? 0 : getReservePrice().hashCode());
        result = prime * result + ((getZkFinalPrice() == null) ? 0 : getZkFinalPrice().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getProvcity() == null) ? 0 : getProvcity().hashCode());
        result = prime * result + ((getItemUrl() == null) ? 0 : getItemUrl().hashCode());
        result = prime * result + ((getNick() == null) ? 0 : getNick().hashCode());
        result = prime * result + ((getSellerId() == null) ? 0 : getSellerId().hashCode());
        result = prime * result + ((getVolume() == null) ? 0 : getVolume().hashCode());
        result = prime * result + ((getCatLeafName() == null) ? 0 : getCatLeafName().hashCode());
        result = prime * result + ((getIsPrepay() == null) ? 0 : getIsPrepay().hashCode());
        result = prime * result + ((getShopDsr() == null) ? 0 : getShopDsr().hashCode());
        result = prime * result + ((getRatesum() == null) ? 0 : getRatesum().hashCode());
        result = prime * result + ((getiRfdRate() == null) ? 0 : getiRfdRate().hashCode());
        result = prime * result + ((gethGoodRate() == null) ? 0 : gethGoodRate().hashCode());
        result = prime * result + ((gethPayRate30() == null) ? 0 : gethPayRate30().hashCode());
        result = prime * result + ((getFreeShipment() == null) ? 0 : getFreeShipment().hashCode());
        result = prime * result + ((getMaterialLibType() == null) ? 0 : getMaterialLibType().hashCode());
        return result;
    }
}