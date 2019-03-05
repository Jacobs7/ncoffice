package com.dape.datax.dao.model;

import java.io.Serializable;

public class DataxSourceType implements Serializable {
    private Integer id;

    private String tname;

    private String str;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tname=").append(tname);
        sb.append(", str=").append(str);
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
            && (this.getTname() == null ? other.getTname() == null : this.getTname().equals(other.getTname()))
            && (this.getStr() == null ? other.getStr() == null : this.getStr().equals(other.getStr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTname() == null) ? 0 : getTname().hashCode());
        result = prime * result + ((getStr() == null) ? 0 : getStr().hashCode());
        return result;
    }
}