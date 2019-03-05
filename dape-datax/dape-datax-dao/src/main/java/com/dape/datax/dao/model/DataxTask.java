package com.dape.datax.dao.model;

import java.io.Serializable;
import java.util.Date;

public class DataxTask implements Serializable {
    private Integer id;

    private String name;

    private String createUser;

    private Date createTime;

    private String fromDataUrl;

    private String toDataUrl;

    private Integer fromTypeId;

    private Integer toTypeId;

    private String fromUsername;

    private String toUsername;

    private String fromPwd;

    private String toPwd;

    private String fromProt;

    private String toPort;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFromDataUrl() {
        return fromDataUrl;
    }

    public void setFromDataUrl(String fromDataUrl) {
        this.fromDataUrl = fromDataUrl;
    }

    public String getToDataUrl() {
        return toDataUrl;
    }

    public void setToDataUrl(String toDataUrl) {
        this.toDataUrl = toDataUrl;
    }

    public Integer getFromTypeId() {
        return fromTypeId;
    }

    public void setFromTypeId(Integer fromTypeId) {
        this.fromTypeId = fromTypeId;
    }

    public Integer getToTypeId() {
        return toTypeId;
    }

    public void setToTypeId(Integer toTypeId) {
        this.toTypeId = toTypeId;
    }

    public String getFromUsername() {
        return fromUsername;
    }

    public void setFromUsername(String fromUsername) {
        this.fromUsername = fromUsername;
    }

    public String getToUsername() {
        return toUsername;
    }

    public void setToUsername(String toUsername) {
        this.toUsername = toUsername;
    }

    public String getFromPwd() {
        return fromPwd;
    }

    public void setFromPwd(String fromPwd) {
        this.fromPwd = fromPwd;
    }

    public String getToPwd() {
        return toPwd;
    }

    public void setToPwd(String toPwd) {
        this.toPwd = toPwd;
    }

    public String getFromProt() {
        return fromProt;
    }

    public void setFromProt(String fromProt) {
        this.fromProt = fromProt;
    }

    public String getToPort() {
        return toPort;
    }

    public void setToPort(String toPort) {
        this.toPort = toPort;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", createUser=").append(createUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", fromDataUrl=").append(fromDataUrl);
        sb.append(", toDataUrl=").append(toDataUrl);
        sb.append(", fromTypeId=").append(fromTypeId);
        sb.append(", toTypeId=").append(toTypeId);
        sb.append(", fromUsername=").append(fromUsername);
        sb.append(", toUsername=").append(toUsername);
        sb.append(", fromPwd=").append(fromPwd);
        sb.append(", toPwd=").append(toPwd);
        sb.append(", fromProt=").append(fromProt);
        sb.append(", toPort=").append(toPort);
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
        DataxTask other = (DataxTask) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getFromDataUrl() == null ? other.getFromDataUrl() == null : this.getFromDataUrl().equals(other.getFromDataUrl()))
            && (this.getToDataUrl() == null ? other.getToDataUrl() == null : this.getToDataUrl().equals(other.getToDataUrl()))
            && (this.getFromTypeId() == null ? other.getFromTypeId() == null : this.getFromTypeId().equals(other.getFromTypeId()))
            && (this.getToTypeId() == null ? other.getToTypeId() == null : this.getToTypeId().equals(other.getToTypeId()))
            && (this.getFromUsername() == null ? other.getFromUsername() == null : this.getFromUsername().equals(other.getFromUsername()))
            && (this.getToUsername() == null ? other.getToUsername() == null : this.getToUsername().equals(other.getToUsername()))
            && (this.getFromPwd() == null ? other.getFromPwd() == null : this.getFromPwd().equals(other.getFromPwd()))
            && (this.getToPwd() == null ? other.getToPwd() == null : this.getToPwd().equals(other.getToPwd()))
            && (this.getFromProt() == null ? other.getFromProt() == null : this.getFromProt().equals(other.getFromProt()))
            && (this.getToPort() == null ? other.getToPort() == null : this.getToPort().equals(other.getToPort()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getFromDataUrl() == null) ? 0 : getFromDataUrl().hashCode());
        result = prime * result + ((getToDataUrl() == null) ? 0 : getToDataUrl().hashCode());
        result = prime * result + ((getFromTypeId() == null) ? 0 : getFromTypeId().hashCode());
        result = prime * result + ((getToTypeId() == null) ? 0 : getToTypeId().hashCode());
        result = prime * result + ((getFromUsername() == null) ? 0 : getFromUsername().hashCode());
        result = prime * result + ((getToUsername() == null) ? 0 : getToUsername().hashCode());
        result = prime * result + ((getFromPwd() == null) ? 0 : getFromPwd().hashCode());
        result = prime * result + ((getToPwd() == null) ? 0 : getToPwd().hashCode());
        result = prime * result + ((getFromProt() == null) ? 0 : getFromProt().hashCode());
        result = prime * result + ((getToPort() == null) ? 0 : getToPort().hashCode());
        return result;
    }
}