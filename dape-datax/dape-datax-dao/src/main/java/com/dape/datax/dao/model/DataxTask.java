package com.dape.datax.dao.model;

import java.io.Serializable;

public class DataxTask implements Serializable {
    private Integer id;

    /**
     * 任务名称
     *
     * @mbg.generated
     */
    private String tname;

    /**
     * 创建用户
     *
     * @mbg.generated
     */
    private String createUser;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private String createTime;

    /**
     * 文件名称
     *
     * @mbg.generated
     */
    private String taskFileName;

    /**
     * 频率
     *
     * @mbg.generated
     */
    private String tfrequency;

    /**
     * job 文件路径
     *
     * @mbg.generated
     */
    private String filePath;

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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTaskFileName() {
        return taskFileName;
    }

    public void setTaskFileName(String taskFileName) {
        this.taskFileName = taskFileName;
    }

    public String getTfrequency() {
        return tfrequency;
    }

    public void setTfrequency(String tfrequency) {
        this.tfrequency = tfrequency;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tname=").append(tname);
        sb.append(", createUser=").append(createUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", taskFileName=").append(taskFileName);
        sb.append(", tfrequency=").append(tfrequency);
        sb.append(", filePath=").append(filePath);
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
            && (this.getTname() == null ? other.getTname() == null : this.getTname().equals(other.getTname()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getTaskFileName() == null ? other.getTaskFileName() == null : this.getTaskFileName().equals(other.getTaskFileName()))
            && (this.getTfrequency() == null ? other.getTfrequency() == null : this.getTfrequency().equals(other.getTfrequency()))
            && (this.getFilePath() == null ? other.getFilePath() == null : this.getFilePath().equals(other.getFilePath()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTname() == null) ? 0 : getTname().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getTaskFileName() == null) ? 0 : getTaskFileName().hashCode());
        result = prime * result + ((getTfrequency() == null) ? 0 : getTfrequency().hashCode());
        result = prime * result + ((getFilePath() == null) ? 0 : getFilePath().hashCode());
        return result;
    }
}