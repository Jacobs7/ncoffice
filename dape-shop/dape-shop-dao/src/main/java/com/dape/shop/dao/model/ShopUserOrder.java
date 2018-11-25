package com.dape.shop.dao.model;

import java.io.Serializable;
import java.util.Date;

public class ShopUserOrder implements Serializable {

    private Long id;
    private Date createDate;
    private String openId;
    private String weiNickName;
    private String headUrl;
    private String mobile;
    private Integer orderCount;
    private Integer orderGet;

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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getOrderGet() {
        return orderGet;
    }

    public void setOrderGet(Integer orderGet) {
        this.orderGet = orderGet;
    }

}
