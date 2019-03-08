package com.dape.datax.dao.model;

import java.io.Serializable;

public class DataxApplySource implements Serializable {
    private Integer id;

    /**
     * 源IP
     *
     * @mbg.generated
     */
    private String linkIp;

    /**
     * 源用户
     *
     * @mbg.generated
     */
    private String dbUser;

    /**
     * 源密码
     *
     * @mbg.generated
     */
    private String dbPwd;

    /**
     * 源端口
     *
     * @mbg.generated
     */
    private String dbPort;

    /**
     * 源类型
     *
     * @mbg.generated
     */
    private Integer typeId;

    /**
     * 源所属任务
     *
     * @mbg.generated
     */
    private Integer taskId;

    /**
     * 控制数据流向 为空 抽取数据库 else 导入数据库  
     *
     * @mbg.generated
     */
    private Integer parentId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkIp() {
        return linkIp;
    }

    public void setLinkIp(String linkIp) {
        this.linkIp = linkIp;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPwd() {
        return dbPwd;
    }

    public void setDbPwd(String dbPwd) {
        this.dbPwd = dbPwd;
    }

    public String getDbPort() {
        return dbPort;
    }

    public void setDbPort(String dbPort) {
        this.dbPort = dbPort;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", linkIp=").append(linkIp);
        sb.append(", dbUser=").append(dbUser);
        sb.append(", dbPwd=").append(dbPwd);
        sb.append(", dbPort=").append(dbPort);
        sb.append(", typeId=").append(typeId);
        sb.append(", taskId=").append(taskId);
        sb.append(", parentId=").append(parentId);
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
        DataxApplySource other = (DataxApplySource) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLinkIp() == null ? other.getLinkIp() == null : this.getLinkIp().equals(other.getLinkIp()))
            && (this.getDbUser() == null ? other.getDbUser() == null : this.getDbUser().equals(other.getDbUser()))
            && (this.getDbPwd() == null ? other.getDbPwd() == null : this.getDbPwd().equals(other.getDbPwd()))
            && (this.getDbPort() == null ? other.getDbPort() == null : this.getDbPort().equals(other.getDbPort()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLinkIp() == null) ? 0 : getLinkIp().hashCode());
        result = prime * result + ((getDbUser() == null) ? 0 : getDbUser().hashCode());
        result = prime * result + ((getDbPwd() == null) ? 0 : getDbPwd().hashCode());
        result = prime * result + ((getDbPort() == null) ? 0 : getDbPort().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        return result;
    }
}