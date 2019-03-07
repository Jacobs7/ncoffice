package com.dape.datax.dao.model;

import java.io.Serializable;

public class DataxSourceType implements Serializable {
    private Integer id;

    /**
     * 源对应连接字符串
     *
     * @mbg.generated
     */
    private String driverStr;

    /**
     * 源名称
     *
     * @mbg.generated
     */
    private String driverName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDriverStr() {
        return driverStr;
    }

    public void setDriverStr(String driverStr) {
        this.driverStr = driverStr;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", driverStr=").append(driverStr);
        sb.append(", driverName=").append(driverName);
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
        DataxSourceType other = (DataxSourceType) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDriverStr() == null ? other.getDriverStr() == null : this.getDriverStr().equals(other.getDriverStr()))
            && (this.getDriverName() == null ? other.getDriverName() == null : this.getDriverName().equals(other.getDriverName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDriverStr() == null) ? 0 : getDriverStr().hashCode());
        result = prime * result + ((getDriverName() == null) ? 0 : getDriverName().hashCode());
        return result;
    }
}