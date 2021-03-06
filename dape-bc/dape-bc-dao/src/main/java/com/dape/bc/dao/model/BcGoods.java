package com.dape.bc.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BcGoods implements Serializable {
    private Long id;

    private Date createDate;

    private Date modifyDate;

    private Boolean isEnabled;

    /**
     * 商品ID
     *
     * @mbg.generated
     */
    private String itemId;

    /**
     * 商品标题
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 商品短标题
     *
     * @mbg.generated
     */
    private String shortTitle;

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
     * 折扣价
     *
     * @mbg.generated
     */
    private BigDecimal zkFinalPrice;

    /**
     * 推荐理由
     *
     * @mbg.generated
     */
    private String itemDescription;

    /**
     * 30天销量
     *
     * @mbg.generated
     */
    private Integer volume;

    /**
     * 券额
     *
     * @mbg.generated
     */
    private BigDecimal couponAmount;

    /**
     * 券总量
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

    /**
     * 券起用门槛,满X元可用
     *
     * @mbg.generated
     */
    private String couponStartFee;

    /**
     * 优惠券开始时间
     *
     * @mbg.generated
     */
    private Date couponStartTime;

    /**
     * 优惠券结束时间
     *
     * @mbg.generated
     */
    private Date couponEndTime;

    /**
     * 优惠券信息-优惠券满减信息
     *
     * @mbg.generated
     */
    private String couponInfo;

    /**
     * 卖家id
     *
     * @mbg.generated
     */
    private String sellerId;

    /**
     * 店铺名称
     *
     * @mbg.generated
     */
    private String shopTitle;

    /**
     * 店铺信息-卖家昵称
     *
     * @mbg.generated
     */
    private String nick;

    /**
     * 卖家类型，0表示集市，1表示商城
     *
     * @mbg.generated
     */
    private Integer userType;

    /**
     * 叶子类目id
     *
     * @mbg.generated
     */
    private String categoryId;

    /**
     * 叶子类目名称
     *
     * @mbg.generated
     */
    private String categoryName;

    /**
     * 一级类目ID
     *
     * @mbg.generated
     */
    private String levelOneCategoryId;

    /**
     * 一级类目名称
     *
     * @mbg.generated
     */
    private String levelOneCategoryName;

    /**
     * 商品详情图片地址
     *
     * @mbg.generated
     */
    private String descImgs;

    /**
     * 好券直播类别
     *
     * @mbg.generated
     */
    private Integer hqzbType;

    /**
     * 大额券类别
     *
     * @mbg.generated
     */
    private Integer deqType;

    /**
     * 高佣榜类别
     *
     * @mbg.generated
     */
    private Integer gybType;

    /**
     * 品牌券类别
     *
     * @mbg.generated
     */
    private Integer ppqType;

    /**
     * 母婴主题类别
     *
     * @mbg.generated
     */
    private Integer myztType;

    /**
     * 是否聚划算，0否，1是
     *
     * @mbg.generated
     */
    private Integer jhsType;

    /**
     * 是否有好货，0否，1是
     *
     * @mbg.generated
     */
    private Integer yhhType;

    /**
     * 是否潮流范，0否，1是
     *
     * @mbg.generated
     */
    private Integer clfType;

    /**
     * 是否特惠，0否，1是
     *
     * @mbg.generated
     */
    private Integer thType;

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

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
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

    public BigDecimal getZkFinalPrice() {
        return zkFinalPrice;
    }

    public void setZkFinalPrice(BigDecimal zkFinalPrice) {
        this.zkFinalPrice = zkFinalPrice;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
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

    public String getCouponStartFee() {
        return couponStartFee;
    }

    public void setCouponStartFee(String couponStartFee) {
        this.couponStartFee = couponStartFee;
    }

    public Date getCouponStartTime() {
        return couponStartTime;
    }

    public void setCouponStartTime(Date couponStartTime) {
        this.couponStartTime = couponStartTime;
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

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getShopTitle() {
        return shopTitle;
    }

    public void setShopTitle(String shopTitle) {
        this.shopTitle = shopTitle;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getLevelOneCategoryId() {
        return levelOneCategoryId;
    }

    public void setLevelOneCategoryId(String levelOneCategoryId) {
        this.levelOneCategoryId = levelOneCategoryId;
    }

    public String getLevelOneCategoryName() {
        return levelOneCategoryName;
    }

    public void setLevelOneCategoryName(String levelOneCategoryName) {
        this.levelOneCategoryName = levelOneCategoryName;
    }

    public String getDescImgs() {
        return descImgs;
    }

    public void setDescImgs(String descImgs) {
        this.descImgs = descImgs;
    }

    public Integer getHqzbType() {
        return hqzbType;
    }

    public void setHqzbType(Integer hqzbType) {
        this.hqzbType = hqzbType;
    }

    public Integer getDeqType() {
        return deqType;
    }

    public void setDeqType(Integer deqType) {
        this.deqType = deqType;
    }

    public Integer getGybType() {
        return gybType;
    }

    public void setGybType(Integer gybType) {
        this.gybType = gybType;
    }

    public Integer getPpqType() {
        return ppqType;
    }

    public void setPpqType(Integer ppqType) {
        this.ppqType = ppqType;
    }

    public Integer getMyztType() {
        return myztType;
    }

    public void setMyztType(Integer myztType) {
        this.myztType = myztType;
    }

    public Integer getJhsType() {
        return jhsType;
    }

    public void setJhsType(Integer jhsType) {
        this.jhsType = jhsType;
    }

    public Integer getYhhType() {
        return yhhType;
    }

    public void setYhhType(Integer yhhType) {
        this.yhhType = yhhType;
    }

    public Integer getClfType() {
        return clfType;
    }

    public void setClfType(Integer clfType) {
        this.clfType = clfType;
    }

    public Integer getThType() {
        return thType;
    }

    public void setThType(Integer thType) {
        this.thType = thType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", isEnabled=").append(isEnabled);
        sb.append(", itemId=").append(itemId);
        sb.append(", title=").append(title);
        sb.append(", shortTitle=").append(shortTitle);
        sb.append(", pictUrl=").append(pictUrl);
        sb.append(", smallImages=").append(smallImages);
        sb.append(", zkFinalPrice=").append(zkFinalPrice);
        sb.append(", itemDescription=").append(itemDescription);
        sb.append(", volume=").append(volume);
        sb.append(", couponAmount=").append(couponAmount);
        sb.append(", couponTotalCount=").append(couponTotalCount);
        sb.append(", couponRemainCount=").append(couponRemainCount);
        sb.append(", couponStartFee=").append(couponStartFee);
        sb.append(", couponStartTime=").append(couponStartTime);
        sb.append(", couponEndTime=").append(couponEndTime);
        sb.append(", couponInfo=").append(couponInfo);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", shopTitle=").append(shopTitle);
        sb.append(", nick=").append(nick);
        sb.append(", userType=").append(userType);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", levelOneCategoryId=").append(levelOneCategoryId);
        sb.append(", levelOneCategoryName=").append(levelOneCategoryName);
        sb.append(", descImgs=").append(descImgs);
        sb.append(", hqzbType=").append(hqzbType);
        sb.append(", deqType=").append(deqType);
        sb.append(", gybType=").append(gybType);
        sb.append(", ppqType=").append(ppqType);
        sb.append(", myztType=").append(myztType);
        sb.append(", jhsType=").append(jhsType);
        sb.append(", yhhType=").append(yhhType);
        sb.append(", clfType=").append(clfType);
        sb.append(", thType=").append(thType);
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
        BcGoods other = (BcGoods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getModifyDate() == null ? other.getModifyDate() == null : this.getModifyDate().equals(other.getModifyDate()))
            && (this.getIsEnabled() == null ? other.getIsEnabled() == null : this.getIsEnabled().equals(other.getIsEnabled()))
            && (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getShortTitle() == null ? other.getShortTitle() == null : this.getShortTitle().equals(other.getShortTitle()))
            && (this.getPictUrl() == null ? other.getPictUrl() == null : this.getPictUrl().equals(other.getPictUrl()))
            && (this.getSmallImages() == null ? other.getSmallImages() == null : this.getSmallImages().equals(other.getSmallImages()))
            && (this.getZkFinalPrice() == null ? other.getZkFinalPrice() == null : this.getZkFinalPrice().equals(other.getZkFinalPrice()))
            && (this.getItemDescription() == null ? other.getItemDescription() == null : this.getItemDescription().equals(other.getItemDescription()))
            && (this.getVolume() == null ? other.getVolume() == null : this.getVolume().equals(other.getVolume()))
            && (this.getCouponAmount() == null ? other.getCouponAmount() == null : this.getCouponAmount().equals(other.getCouponAmount()))
            && (this.getCouponTotalCount() == null ? other.getCouponTotalCount() == null : this.getCouponTotalCount().equals(other.getCouponTotalCount()))
            && (this.getCouponRemainCount() == null ? other.getCouponRemainCount() == null : this.getCouponRemainCount().equals(other.getCouponRemainCount()))
            && (this.getCouponStartFee() == null ? other.getCouponStartFee() == null : this.getCouponStartFee().equals(other.getCouponStartFee()))
            && (this.getCouponStartTime() == null ? other.getCouponStartTime() == null : this.getCouponStartTime().equals(other.getCouponStartTime()))
            && (this.getCouponEndTime() == null ? other.getCouponEndTime() == null : this.getCouponEndTime().equals(other.getCouponEndTime()))
            && (this.getCouponInfo() == null ? other.getCouponInfo() == null : this.getCouponInfo().equals(other.getCouponInfo()))
            && (this.getSellerId() == null ? other.getSellerId() == null : this.getSellerId().equals(other.getSellerId()))
            && (this.getShopTitle() == null ? other.getShopTitle() == null : this.getShopTitle().equals(other.getShopTitle()))
            && (this.getNick() == null ? other.getNick() == null : this.getNick().equals(other.getNick()))
            && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getCategoryName() == null ? other.getCategoryName() == null : this.getCategoryName().equals(other.getCategoryName()))
            && (this.getLevelOneCategoryId() == null ? other.getLevelOneCategoryId() == null : this.getLevelOneCategoryId().equals(other.getLevelOneCategoryId()))
            && (this.getLevelOneCategoryName() == null ? other.getLevelOneCategoryName() == null : this.getLevelOneCategoryName().equals(other.getLevelOneCategoryName()))
            && (this.getDescImgs() == null ? other.getDescImgs() == null : this.getDescImgs().equals(other.getDescImgs()))
            && (this.getHqzbType() == null ? other.getHqzbType() == null : this.getHqzbType().equals(other.getHqzbType()))
            && (this.getDeqType() == null ? other.getDeqType() == null : this.getDeqType().equals(other.getDeqType()))
            && (this.getGybType() == null ? other.getGybType() == null : this.getGybType().equals(other.getGybType()))
            && (this.getPpqType() == null ? other.getPpqType() == null : this.getPpqType().equals(other.getPpqType()))
            && (this.getMyztType() == null ? other.getMyztType() == null : this.getMyztType().equals(other.getMyztType()))
            && (this.getJhsType() == null ? other.getJhsType() == null : this.getJhsType().equals(other.getJhsType()))
            && (this.getYhhType() == null ? other.getYhhType() == null : this.getYhhType().equals(other.getYhhType()))
            && (this.getClfType() == null ? other.getClfType() == null : this.getClfType().equals(other.getClfType()))
            && (this.getThType() == null ? other.getThType() == null : this.getThType().equals(other.getThType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getModifyDate() == null) ? 0 : getModifyDate().hashCode());
        result = prime * result + ((getIsEnabled() == null) ? 0 : getIsEnabled().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getShortTitle() == null) ? 0 : getShortTitle().hashCode());
        result = prime * result + ((getPictUrl() == null) ? 0 : getPictUrl().hashCode());
        result = prime * result + ((getSmallImages() == null) ? 0 : getSmallImages().hashCode());
        result = prime * result + ((getZkFinalPrice() == null) ? 0 : getZkFinalPrice().hashCode());
        result = prime * result + ((getItemDescription() == null) ? 0 : getItemDescription().hashCode());
        result = prime * result + ((getVolume() == null) ? 0 : getVolume().hashCode());
        result = prime * result + ((getCouponAmount() == null) ? 0 : getCouponAmount().hashCode());
        result = prime * result + ((getCouponTotalCount() == null) ? 0 : getCouponTotalCount().hashCode());
        result = prime * result + ((getCouponRemainCount() == null) ? 0 : getCouponRemainCount().hashCode());
        result = prime * result + ((getCouponStartFee() == null) ? 0 : getCouponStartFee().hashCode());
        result = prime * result + ((getCouponStartTime() == null) ? 0 : getCouponStartTime().hashCode());
        result = prime * result + ((getCouponEndTime() == null) ? 0 : getCouponEndTime().hashCode());
        result = prime * result + ((getCouponInfo() == null) ? 0 : getCouponInfo().hashCode());
        result = prime * result + ((getSellerId() == null) ? 0 : getSellerId().hashCode());
        result = prime * result + ((getShopTitle() == null) ? 0 : getShopTitle().hashCode());
        result = prime * result + ((getNick() == null) ? 0 : getNick().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getCategoryName() == null) ? 0 : getCategoryName().hashCode());
        result = prime * result + ((getLevelOneCategoryId() == null) ? 0 : getLevelOneCategoryId().hashCode());
        result = prime * result + ((getLevelOneCategoryName() == null) ? 0 : getLevelOneCategoryName().hashCode());
        result = prime * result + ((getDescImgs() == null) ? 0 : getDescImgs().hashCode());
        result = prime * result + ((getHqzbType() == null) ? 0 : getHqzbType().hashCode());
        result = prime * result + ((getDeqType() == null) ? 0 : getDeqType().hashCode());
        result = prime * result + ((getGybType() == null) ? 0 : getGybType().hashCode());
        result = prime * result + ((getPpqType() == null) ? 0 : getPpqType().hashCode());
        result = prime * result + ((getMyztType() == null) ? 0 : getMyztType().hashCode());
        result = prime * result + ((getJhsType() == null) ? 0 : getJhsType().hashCode());
        result = prime * result + ((getYhhType() == null) ? 0 : getYhhType().hashCode());
        result = prime * result + ((getClfType() == null) ? 0 : getClfType().hashCode());
        result = prime * result + ((getThType() == null) ? 0 : getThType().hashCode());
        return result;
    }
}