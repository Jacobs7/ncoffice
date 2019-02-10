package com.dape.shop.dao.model;

import java.io.Serializable;
import java.util.Date;

public class ShopUser implements Serializable {
    private Long id;

    /**
     * 关注时间
     *
     * @mbg.generated
     */
    private Date createDate;

    /**
     * upms_user的user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * 微信昵称
     *
     * @mbg.generated
     */
    private String weiNickName;

    /**
     * 头像
     *
     * @mbg.generated
     */
    private String headUrl;

    /**
     * 邀请码
     *
     * @mbg.generated
     */
    private String rCode;

    /**
     * 推荐人邀请码
     *
     * @mbg.generated
     */
    private String sCode;

    /**
     * 累计提现，单位：分
     *
     * @mbg.generated
     */
    private Integer outCash;

    /**
     * 余额，单位：分
     *
     * @mbg.generated
     */
    private Integer money;

    /**
     * 1:普通返佣，2:特权返佣
     *
     * @mbg.generated
     */
    private Short rank;

    /**
     * 积分
     *
     * @mbg.generated
     */
    private Integer integral;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getWeiNickName() {
        return weiNickName;
    }

    public void setWeiNickName(String weiNickName) {
        this.weiNickName = weiNickName;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getrCode() {
        return rCode;
    }

    public void setrCode(String rCode) {
        this.rCode = rCode;
    }

    public String getsCode() {
        return sCode;
    }

    public void setsCode(String sCode) {
        this.sCode = sCode;
    }

    public Integer getOutCash() {
        return outCash;
    }

    public void setOutCash(Integer outCash) {
        this.outCash = outCash;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Short getRank() {
        return rank;
    }

    public void setRank(Short rank) {
        this.rank = rank;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
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
        sb.append(", weiNickName=").append(weiNickName);
        sb.append(", headUrl=").append(headUrl);
        sb.append(", rCode=").append(rCode);
        sb.append(", sCode=").append(sCode);
        sb.append(", outCash=").append(outCash);
        sb.append(", money=").append(money);
        sb.append(", rank=").append(rank);
        sb.append(", integral=").append(integral);
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
        ShopUser other = (ShopUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getWeiNickName() == null ? other.getWeiNickName() == null : this.getWeiNickName().equals(other.getWeiNickName()))
            && (this.getHeadUrl() == null ? other.getHeadUrl() == null : this.getHeadUrl().equals(other.getHeadUrl()))
            && (this.getrCode() == null ? other.getrCode() == null : this.getrCode().equals(other.getrCode()))
            && (this.getsCode() == null ? other.getsCode() == null : this.getsCode().equals(other.getsCode()))
            && (this.getOutCash() == null ? other.getOutCash() == null : this.getOutCash().equals(other.getOutCash()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getRank() == null ? other.getRank() == null : this.getRank().equals(other.getRank()))
            && (this.getIntegral() == null ? other.getIntegral() == null : this.getIntegral().equals(other.getIntegral()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getWeiNickName() == null) ? 0 : getWeiNickName().hashCode());
        result = prime * result + ((getHeadUrl() == null) ? 0 : getHeadUrl().hashCode());
        result = prime * result + ((getrCode() == null) ? 0 : getrCode().hashCode());
        result = prime * result + ((getsCode() == null) ? 0 : getsCode().hashCode());
        result = prime * result + ((getOutCash() == null) ? 0 : getOutCash().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getRank() == null) ? 0 : getRank().hashCode());
        result = prime * result + ((getIntegral() == null) ? 0 : getIntegral().hashCode());
        return result;
    }
}