package com.dape.shop.dao.model;

import java.io.Serializable;
import java.util.Date;

public class ShopMaterialImport implements Serializable {
    private Integer id;

    private Date createDate;

    /**
     * 是否启用
     *
     * @mbg.generated
     */
    private Boolean isEnabled;

    /**
     * 分类名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 本地类目
     *
     * @mbg.generated
     */
    private Integer childType;

    /**
     * 物料id
     *
     * @mbg.generated
     */
    private String materialId;

    /**
     * 类目过滤条件
     *
     * @mbg.generated
     */
    private String filterCat;

    private String remark;

    /**
     * 排序
     *
     * @mbg.generated
     */
    private Integer sort;

    /**
     * 对应数据库字段
     *
     * @mbg.generated
     */
    private String fieldName;

    /**
     * 最后执行时间
     *
     * @mbg.generated
     */
    private Date lastImportDate;

    /**
     * 执行结果
     *
     * @mbg.generated
     */
    private String lastImportResult;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getChildType() {
        return childType;
    }

    public void setChildType(Integer childType) {
        this.childType = childType;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getFilterCat() {
        return filterCat;
    }

    public void setFilterCat(String filterCat) {
        this.filterCat = filterCat;
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

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Date getLastImportDate() {
        return lastImportDate;
    }

    public void setLastImportDate(Date lastImportDate) {
        this.lastImportDate = lastImportDate;
    }

    public String getLastImportResult() {
        return lastImportResult;
    }

    public void setLastImportResult(String lastImportResult) {
        this.lastImportResult = lastImportResult;
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
        sb.append(", childType=").append(childType);
        sb.append(", materialId=").append(materialId);
        sb.append(", filterCat=").append(filterCat);
        sb.append(", remark=").append(remark);
        sb.append(", sort=").append(sort);
        sb.append(", fieldName=").append(fieldName);
        sb.append(", lastImportDate=").append(lastImportDate);
        sb.append(", lastImportResult=").append(lastImportResult);
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
        ShopMaterialImport other = (ShopMaterialImport) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getIsEnabled() == null ? other.getIsEnabled() == null : this.getIsEnabled().equals(other.getIsEnabled()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getChildType() == null ? other.getChildType() == null : this.getChildType().equals(other.getChildType()))
            && (this.getMaterialId() == null ? other.getMaterialId() == null : this.getMaterialId().equals(other.getMaterialId()))
            && (this.getFilterCat() == null ? other.getFilterCat() == null : this.getFilterCat().equals(other.getFilterCat()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getFieldName() == null ? other.getFieldName() == null : this.getFieldName().equals(other.getFieldName()))
            && (this.getLastImportDate() == null ? other.getLastImportDate() == null : this.getLastImportDate().equals(other.getLastImportDate()))
            && (this.getLastImportResult() == null ? other.getLastImportResult() == null : this.getLastImportResult().equals(other.getLastImportResult()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getIsEnabled() == null) ? 0 : getIsEnabled().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getChildType() == null) ? 0 : getChildType().hashCode());
        result = prime * result + ((getMaterialId() == null) ? 0 : getMaterialId().hashCode());
        result = prime * result + ((getFilterCat() == null) ? 0 : getFilterCat().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getFieldName() == null) ? 0 : getFieldName().hashCode());
        result = prime * result + ((getLastImportDate() == null) ? 0 : getLastImportDate().hashCode());
        result = prime * result + ((getLastImportResult() == null) ? 0 : getLastImportResult().hashCode());
        return result;
    }
}