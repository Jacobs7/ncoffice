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

    /**
     * 收入比例，举例，取值为20.00，表示比例20.00%
     *
     * @mbg.generated
     */
    private String tkRate;

    /**
     * 无线折扣价，即宝贝在无线上的实际售卖价格。
     *
     * @mbg.generated
     */
    private String zkFinalPriceWap;

    private String shopTitle;

    /**
     * 招商活动开始时间；如果该宝贝取自普通选品组，则取值为1970-01-01 00:00:00；
     *
     * @mbg.generated
     */
    private Date eventStartTime;

    /**
     * 招行活动的结束时间；如果该宝贝取自普通的选品组，则取值为1970-01-01 00:00:00
     *
     * @mbg.generated
     */
    private Date eventEndTime;

    /**
     * 宝贝类型：1 普通商品； 2 鹊桥高佣金商品；3 定向招商商品；4 营销计划商品;
     *
     * @mbg.generated
     */
    private Integer type;

    /**
     * 宝贝状态，0失效，1有效；注：失效可能是宝贝已经下线或者是被处罚不能在进行推广
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * 后台一级类目
     *
     * @mbg.generated
     */
    private Integer category;

    /**
     * 商品优惠券推广链接
     *
     * @mbg.generated
     */
    private String couponClickUrl;

    /**
     * 优惠券结束时间
     *
     * @mbg.generated
     */
    private Date couponEndTime;

    /**
     * 优惠券面额
     *
     * @mbg.generated
     */
    private String couponInfo;

    /**
     * 优惠券开始时间
     *
     * @mbg.generated
     */
    private Date couponStartTime;

    /**
     * 优惠券总量
     *
     * @mbg.generated
     */
    private Integer couponTotalCount;

    /**
     * 优惠券剩余量
     *
     * @mbg.generated
     */
    private Integer couponRemainCount;

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

    public String getTkRate() {
        return tkRate;
    }

    public void setTkRate(String tkRate) {
        this.tkRate = tkRate;
    }

    public String getZkFinalPriceWap() {
        return zkFinalPriceWap;
    }

    public void setZkFinalPriceWap(String zkFinalPriceWap) {
        this.zkFinalPriceWap = zkFinalPriceWap;
    }

    public String getShopTitle() {
        return shopTitle;
    }

    public void setShopTitle(String shopTitle) {
        this.shopTitle = shopTitle;
    }

    public Date getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(Date eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public Date getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(Date eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getCouponClickUrl() {
        return couponClickUrl;
    }

    public void setCouponClickUrl(String couponClickUrl) {
        this.couponClickUrl = couponClickUrl;
    }

    public Date getCouponEndTime() {
        return couponEndTime;
    }

    public void setCouponEndTime(Date couponEndTime) {
        this.couponEndTime = couponEndTime;
    }

    public String getCouponInfo() {
        return couponInfo;
    }

    public void setCouponInfo(String couponInfo) {
        this.couponInfo = couponInfo;
    }

    public Date getCouponStartTime() {
        return couponStartTime;
    }

    public void setCouponStartTime(Date couponStartTime) {
        this.couponStartTime = couponStartTime;
    }

    public Integer getCouponTotalCount() {
        return couponTotalCount;
    }

    public void setCouponTotalCount(Integer couponTotalCount) {
        this.couponTotalCount = couponTotalCount;
    }

    public Integer getCouponRemainCount() {
        return couponRemainCount;
    }

    public void setCouponRemainCount(Integer couponRemainCount) {
        this.couponRemainCount = couponRemainCount;
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
        sb.append(", tkRate=").append(tkRate);
        sb.append(", zkFinalPriceWap=").append(zkFinalPriceWap);
        sb.append(", shopTitle=").append(shopTitle);
        sb.append(", eventStartTime=").append(eventStartTime);
        sb.append(", eventEndTime=").append(eventEndTime);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", category=").append(category);
        sb.append(", couponClickUrl=").append(couponClickUrl);
        sb.append(", couponEndTime=").append(couponEndTime);
        sb.append(", couponInfo=").append(couponInfo);
        sb.append(", couponStartTime=").append(couponStartTime);
        sb.append(", couponTotalCount=").append(couponTotalCount);
        sb.append(", couponRemainCount=").append(couponRemainCount);
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
            && (this.getMaterialLibType() == null ? other.getMaterialLibType() == null : this.getMaterialLibType().equals(other.getMaterialLibType()))
            && (this.getTkRate() == null ? other.getTkRate() == null : this.getTkRate().equals(other.getTkRate()))
            && (this.getZkFinalPriceWap() == null ? other.getZkFinalPriceWap() == null : this.getZkFinalPriceWap().equals(other.getZkFinalPriceWap()))
            && (this.getShopTitle() == null ? other.getShopTitle() == null : this.getShopTitle().equals(other.getShopTitle()))
            && (this.getEventStartTime() == null ? other.getEventStartTime() == null : this.getEventStartTime().equals(other.getEventStartTime()))
            && (this.getEventEndTime() == null ? other.getEventEndTime() == null : this.getEventEndTime().equals(other.getEventEndTime()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
            && (this.getCouponClickUrl() == null ? other.getCouponClickUrl() == null : this.getCouponClickUrl().equals(other.getCouponClickUrl()))
            && (this.getCouponEndTime() == null ? other.getCouponEndTime() == null : this.getCouponEndTime().equals(other.getCouponEndTime()))
            && (this.getCouponInfo() == null ? other.getCouponInfo() == null : this.getCouponInfo().equals(other.getCouponInfo()))
            && (this.getCouponStartTime() == null ? other.getCouponStartTime() == null : this.getCouponStartTime().equals(other.getCouponStartTime()))
            && (this.getCouponTotalCount() == null ? other.getCouponTotalCount() == null : this.getCouponTotalCount().equals(other.getCouponTotalCount()))
            && (this.getCouponRemainCount() == null ? other.getCouponRemainCount() == null : this.getCouponRemainCount().equals(other.getCouponRemainCount()));
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
        result = prime * result + ((getTkRate() == null) ? 0 : getTkRate().hashCode());
        result = prime * result + ((getZkFinalPriceWap() == null) ? 0 : getZkFinalPriceWap().hashCode());
        result = prime * result + ((getShopTitle() == null) ? 0 : getShopTitle().hashCode());
        result = prime * result + ((getEventStartTime() == null) ? 0 : getEventStartTime().hashCode());
        result = prime * result + ((getEventEndTime() == null) ? 0 : getEventEndTime().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getCouponClickUrl() == null) ? 0 : getCouponClickUrl().hashCode());
        result = prime * result + ((getCouponEndTime() == null) ? 0 : getCouponEndTime().hashCode());
        result = prime * result + ((getCouponInfo() == null) ? 0 : getCouponInfo().hashCode());
        result = prime * result + ((getCouponStartTime() == null) ? 0 : getCouponStartTime().hashCode());
        result = prime * result + ((getCouponTotalCount() == null) ? 0 : getCouponTotalCount().hashCode());
        result = prime * result + ((getCouponRemainCount() == null) ? 0 : getCouponRemainCount().hashCode());
        return result;
    }
}