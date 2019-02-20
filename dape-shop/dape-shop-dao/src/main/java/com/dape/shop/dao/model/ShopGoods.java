package com.dape.shop.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ShopGoods implements Serializable {
    private Long id;

    private Date createDate;

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
     * 淘客链接
     *
     * @mbg.generated
     */
    private String clickUrl;

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
     * 券链接
     *
     * @mbg.generated
     */
    private String couponClickUrl;

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
    private String couponStartTime;

    /**
     * 优惠券结束时间
     *
     * @mbg.generated
     */
    private String couponEndTime;

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
     * 拼团：剩余库存
     *
     * @mbg.generated
     */
    private Integer stock;

    /**
     * 拼团：已售数量
     *
     * @mbg.generated
     */
    private Integer sellNum;

    /**
     * 拼团：库存数量
     *
     * @mbg.generated
     */
    private Integer totalStock;

    /**
     * 拼团：开始时间
     *
     * @mbg.generated
     */
    private String ostime;

    /**
     * 拼团：结束时间
     *
     * @mbg.generated
     */
    private String oetime;

    /**
     * 拼团：几人团
     *
     * @mbg.generated
     */
    private Integer jddNum;

    /**
     * 拼团：拼成价，单位元
     *
     * @mbg.generated
     */
    private String jddPrice;

    /**
     * 一人价（原价)，单位元
     *
     * @mbg.generated
     */
    private String origPrice;

    /**
     * 佣金比率(%)
     *
     * @mbg.generated
     */
    private String commissionRate;

    /**
     * 商品相关关联词落地页地址
     *
     * @mbg.generated
     */
    private String wordUrl;

    /**
     * 商品相关的关联词
     *
     * @mbg.generated
     */
    private String word;

    /**
     * 天猫营销玩法
     *
     * @mbg.generated
     */
    private String tmallPlayActivityInfo;

    /**
     * 预售数量
     *
     * @mbg.generated
     */
    private Integer uvSumPreSale;

    /**
     * 物料块id(测试中请勿使用)
     *
     * @mbg.generated
     */
    private String xId;

    /**
     * 新人价
     *
     * @mbg.generated
     */
    private String newUserPrice;

    /**
     * 物料id
     *
     * @mbg.generated
     */
    private Long materialId;

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

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
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

    public String getCouponClickUrl() {
        return couponClickUrl;
    }

    public void setCouponClickUrl(String couponClickUrl) {
        this.couponClickUrl = couponClickUrl;
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

    public String getCouponStartTime() {
        return couponStartTime;
    }

    public void setCouponStartTime(String couponStartTime) {
        this.couponStartTime = couponStartTime;
    }

    public String getCouponEndTime() {
        return couponEndTime;
    }

    public void setCouponEndTime(String couponEndTime) {
        this.couponEndTime = couponEndTime;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum(Integer sellNum) {
        this.sellNum = sellNum;
    }

    public Integer getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(Integer totalStock) {
        this.totalStock = totalStock;
    }

    public String getOstime() {
        return ostime;
    }

    public void setOstime(String ostime) {
        this.ostime = ostime;
    }

    public String getOetime() {
        return oetime;
    }

    public void setOetime(String oetime) {
        this.oetime = oetime;
    }

    public Integer getJddNum() {
        return jddNum;
    }

    public void setJddNum(Integer jddNum) {
        this.jddNum = jddNum;
    }

    public String getJddPrice() {
        return jddPrice;
    }

    public void setJddPrice(String jddPrice) {
        this.jddPrice = jddPrice;
    }

    public String getOrigPrice() {
        return origPrice;
    }

    public void setOrigPrice(String origPrice) {
        this.origPrice = origPrice;
    }

    public String getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(String commissionRate) {
        this.commissionRate = commissionRate;
    }

    public String getWordUrl() {
        return wordUrl;
    }

    public void setWordUrl(String wordUrl) {
        this.wordUrl = wordUrl;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTmallPlayActivityInfo() {
        return tmallPlayActivityInfo;
    }

    public void setTmallPlayActivityInfo(String tmallPlayActivityInfo) {
        this.tmallPlayActivityInfo = tmallPlayActivityInfo;
    }

    public Integer getUvSumPreSale() {
        return uvSumPreSale;
    }

    public void setUvSumPreSale(Integer uvSumPreSale) {
        this.uvSumPreSale = uvSumPreSale;
    }

    public String getxId() {
        return xId;
    }

    public void setxId(String xId) {
        this.xId = xId;
    }

    public String getNewUserPrice() {
        return newUserPrice;
    }

    public void setNewUserPrice(String newUserPrice) {
        this.newUserPrice = newUserPrice;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createDate=").append(createDate);
        sb.append(", itemId=").append(itemId);
        sb.append(", title=").append(title);
        sb.append(", shortTitle=").append(shortTitle);
        sb.append(", pictUrl=").append(pictUrl);
        sb.append(", smallImages=").append(smallImages);
        sb.append(", clickUrl=").append(clickUrl);
        sb.append(", zkFinalPrice=").append(zkFinalPrice);
        sb.append(", itemDescription=").append(itemDescription);
        sb.append(", volume=").append(volume);
        sb.append(", couponClickUrl=").append(couponClickUrl);
        sb.append(", couponAmount=").append(couponAmount);
        sb.append(", couponTotalCount=").append(couponTotalCount);
        sb.append(", couponRemainCount=").append(couponRemainCount);
        sb.append(", couponStartFee=").append(couponStartFee);
        sb.append(", couponStartTime=").append(couponStartTime);
        sb.append(", couponEndTime=").append(couponEndTime);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", shopTitle=").append(shopTitle);
        sb.append(", userType=").append(userType);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", levelOneCategoryId=").append(levelOneCategoryId);
        sb.append(", levelOneCategoryName=").append(levelOneCategoryName);
        sb.append(", stock=").append(stock);
        sb.append(", sellNum=").append(sellNum);
        sb.append(", totalStock=").append(totalStock);
        sb.append(", ostime=").append(ostime);
        sb.append(", oetime=").append(oetime);
        sb.append(", jddNum=").append(jddNum);
        sb.append(", jddPrice=").append(jddPrice);
        sb.append(", origPrice=").append(origPrice);
        sb.append(", commissionRate=").append(commissionRate);
        sb.append(", wordUrl=").append(wordUrl);
        sb.append(", word=").append(word);
        sb.append(", tmallPlayActivityInfo=").append(tmallPlayActivityInfo);
        sb.append(", uvSumPreSale=").append(uvSumPreSale);
        sb.append(", xId=").append(xId);
        sb.append(", newUserPrice=").append(newUserPrice);
        sb.append(", materialId=").append(materialId);
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
            && (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getShortTitle() == null ? other.getShortTitle() == null : this.getShortTitle().equals(other.getShortTitle()))
            && (this.getPictUrl() == null ? other.getPictUrl() == null : this.getPictUrl().equals(other.getPictUrl()))
            && (this.getSmallImages() == null ? other.getSmallImages() == null : this.getSmallImages().equals(other.getSmallImages()))
            && (this.getClickUrl() == null ? other.getClickUrl() == null : this.getClickUrl().equals(other.getClickUrl()))
            && (this.getZkFinalPrice() == null ? other.getZkFinalPrice() == null : this.getZkFinalPrice().equals(other.getZkFinalPrice()))
            && (this.getItemDescription() == null ? other.getItemDescription() == null : this.getItemDescription().equals(other.getItemDescription()))
            && (this.getVolume() == null ? other.getVolume() == null : this.getVolume().equals(other.getVolume()))
            && (this.getCouponClickUrl() == null ? other.getCouponClickUrl() == null : this.getCouponClickUrl().equals(other.getCouponClickUrl()))
            && (this.getCouponAmount() == null ? other.getCouponAmount() == null : this.getCouponAmount().equals(other.getCouponAmount()))
            && (this.getCouponTotalCount() == null ? other.getCouponTotalCount() == null : this.getCouponTotalCount().equals(other.getCouponTotalCount()))
            && (this.getCouponRemainCount() == null ? other.getCouponRemainCount() == null : this.getCouponRemainCount().equals(other.getCouponRemainCount()))
            && (this.getCouponStartFee() == null ? other.getCouponStartFee() == null : this.getCouponStartFee().equals(other.getCouponStartFee()))
            && (this.getCouponStartTime() == null ? other.getCouponStartTime() == null : this.getCouponStartTime().equals(other.getCouponStartTime()))
            && (this.getCouponEndTime() == null ? other.getCouponEndTime() == null : this.getCouponEndTime().equals(other.getCouponEndTime()))
            && (this.getSellerId() == null ? other.getSellerId() == null : this.getSellerId().equals(other.getSellerId()))
            && (this.getShopTitle() == null ? other.getShopTitle() == null : this.getShopTitle().equals(other.getShopTitle()))
            && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getCategoryName() == null ? other.getCategoryName() == null : this.getCategoryName().equals(other.getCategoryName()))
            && (this.getLevelOneCategoryId() == null ? other.getLevelOneCategoryId() == null : this.getLevelOneCategoryId().equals(other.getLevelOneCategoryId()))
            && (this.getLevelOneCategoryName() == null ? other.getLevelOneCategoryName() == null : this.getLevelOneCategoryName().equals(other.getLevelOneCategoryName()))
            && (this.getStock() == null ? other.getStock() == null : this.getStock().equals(other.getStock()))
            && (this.getSellNum() == null ? other.getSellNum() == null : this.getSellNum().equals(other.getSellNum()))
            && (this.getTotalStock() == null ? other.getTotalStock() == null : this.getTotalStock().equals(other.getTotalStock()))
            && (this.getOstime() == null ? other.getOstime() == null : this.getOstime().equals(other.getOstime()))
            && (this.getOetime() == null ? other.getOetime() == null : this.getOetime().equals(other.getOetime()))
            && (this.getJddNum() == null ? other.getJddNum() == null : this.getJddNum().equals(other.getJddNum()))
            && (this.getJddPrice() == null ? other.getJddPrice() == null : this.getJddPrice().equals(other.getJddPrice()))
            && (this.getOrigPrice() == null ? other.getOrigPrice() == null : this.getOrigPrice().equals(other.getOrigPrice()))
            && (this.getCommissionRate() == null ? other.getCommissionRate() == null : this.getCommissionRate().equals(other.getCommissionRate()))
            && (this.getWordUrl() == null ? other.getWordUrl() == null : this.getWordUrl().equals(other.getWordUrl()))
            && (this.getWord() == null ? other.getWord() == null : this.getWord().equals(other.getWord()))
            && (this.getTmallPlayActivityInfo() == null ? other.getTmallPlayActivityInfo() == null : this.getTmallPlayActivityInfo().equals(other.getTmallPlayActivityInfo()))
            && (this.getUvSumPreSale() == null ? other.getUvSumPreSale() == null : this.getUvSumPreSale().equals(other.getUvSumPreSale()))
            && (this.getxId() == null ? other.getxId() == null : this.getxId().equals(other.getxId()))
            && (this.getNewUserPrice() == null ? other.getNewUserPrice() == null : this.getNewUserPrice().equals(other.getNewUserPrice()))
            && (this.getMaterialId() == null ? other.getMaterialId() == null : this.getMaterialId().equals(other.getMaterialId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getShortTitle() == null) ? 0 : getShortTitle().hashCode());
        result = prime * result + ((getPictUrl() == null) ? 0 : getPictUrl().hashCode());
        result = prime * result + ((getSmallImages() == null) ? 0 : getSmallImages().hashCode());
        result = prime * result + ((getClickUrl() == null) ? 0 : getClickUrl().hashCode());
        result = prime * result + ((getZkFinalPrice() == null) ? 0 : getZkFinalPrice().hashCode());
        result = prime * result + ((getItemDescription() == null) ? 0 : getItemDescription().hashCode());
        result = prime * result + ((getVolume() == null) ? 0 : getVolume().hashCode());
        result = prime * result + ((getCouponClickUrl() == null) ? 0 : getCouponClickUrl().hashCode());
        result = prime * result + ((getCouponAmount() == null) ? 0 : getCouponAmount().hashCode());
        result = prime * result + ((getCouponTotalCount() == null) ? 0 : getCouponTotalCount().hashCode());
        result = prime * result + ((getCouponRemainCount() == null) ? 0 : getCouponRemainCount().hashCode());
        result = prime * result + ((getCouponStartFee() == null) ? 0 : getCouponStartFee().hashCode());
        result = prime * result + ((getCouponStartTime() == null) ? 0 : getCouponStartTime().hashCode());
        result = prime * result + ((getCouponEndTime() == null) ? 0 : getCouponEndTime().hashCode());
        result = prime * result + ((getSellerId() == null) ? 0 : getSellerId().hashCode());
        result = prime * result + ((getShopTitle() == null) ? 0 : getShopTitle().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getCategoryName() == null) ? 0 : getCategoryName().hashCode());
        result = prime * result + ((getLevelOneCategoryId() == null) ? 0 : getLevelOneCategoryId().hashCode());
        result = prime * result + ((getLevelOneCategoryName() == null) ? 0 : getLevelOneCategoryName().hashCode());
        result = prime * result + ((getStock() == null) ? 0 : getStock().hashCode());
        result = prime * result + ((getSellNum() == null) ? 0 : getSellNum().hashCode());
        result = prime * result + ((getTotalStock() == null) ? 0 : getTotalStock().hashCode());
        result = prime * result + ((getOstime() == null) ? 0 : getOstime().hashCode());
        result = prime * result + ((getOetime() == null) ? 0 : getOetime().hashCode());
        result = prime * result + ((getJddNum() == null) ? 0 : getJddNum().hashCode());
        result = prime * result + ((getJddPrice() == null) ? 0 : getJddPrice().hashCode());
        result = prime * result + ((getOrigPrice() == null) ? 0 : getOrigPrice().hashCode());
        result = prime * result + ((getCommissionRate() == null) ? 0 : getCommissionRate().hashCode());
        result = prime * result + ((getWordUrl() == null) ? 0 : getWordUrl().hashCode());
        result = prime * result + ((getWord() == null) ? 0 : getWord().hashCode());
        result = prime * result + ((getTmallPlayActivityInfo() == null) ? 0 : getTmallPlayActivityInfo().hashCode());
        result = prime * result + ((getUvSumPreSale() == null) ? 0 : getUvSumPreSale().hashCode());
        result = prime * result + ((getxId() == null) ? 0 : getxId().hashCode());
        result = prime * result + ((getNewUserPrice() == null) ? 0 : getNewUserPrice().hashCode());
        result = prime * result + ((getMaterialId() == null) ? 0 : getMaterialId().hashCode());
        return result;
    }
}