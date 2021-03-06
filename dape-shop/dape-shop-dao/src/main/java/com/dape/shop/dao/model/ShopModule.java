package com.dape.shop.dao.model;

import java.io.Serializable;
import java.util.Date;

public class ShopModule implements Serializable {
    private Long id;

    private Date createDate;

    private Boolean isEnabled;

    /**
     * 版块名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 拼音缩写
     *
     * @mbg.generated
     */
    private String pyShort;

    /**
     * 版块链接
     *
     * @mbg.generated
     */
    private String url;

    /**
     * 图标
     *
     * @mbg.generated
     */
    private String icon;

    /**
     * 链接图片
     *
     * @mbg.generated
     */
    private String img;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * 排序
     *
     * @mbg.generated
     */
    private Integer sort;

    /**
     * json扩展
     *
     * @mbg.generated
     */
    private String json;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPyShort() {
        return pyShort;
    }

    public void setPyShort(String pyShort) {
        this.pyShort = pyShort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
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
        sb.append(", name=").append(name);
        sb.append(", pyShort=").append(pyShort);
        sb.append(", url=").append(url);
        sb.append(", icon=").append(icon);
        sb.append(", img=").append(img);
        sb.append(", remark=").append(remark);
        sb.append(", sort=").append(sort);
        sb.append(", json=").append(json);
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
        ShopModule other = (ShopModule) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getIsEnabled() == null ? other.getIsEnabled() == null : this.getIsEnabled().equals(other.getIsEnabled()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPyShort() == null ? other.getPyShort() == null : this.getPyShort().equals(other.getPyShort()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getJson() == null ? other.getJson() == null : this.getJson().equals(other.getJson()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getIsEnabled() == null) ? 0 : getIsEnabled().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPyShort() == null) ? 0 : getPyShort().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getJson() == null) ? 0 : getJson().hashCode());
        return result;
    }
}