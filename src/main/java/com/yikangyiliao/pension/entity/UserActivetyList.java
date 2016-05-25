package com.yikangyiliao.pension.entity;

import java.util.Date;

public class UserActivetyList {
    private Long userActivetyListId;

    private Long userId;

    private Long activetyId;

    private Byte payStatus;

    private Byte auditStatus;

    private Date createTime;

    private Date updateTime;

    public Long getUserActivetyListId() {
        return userActivetyListId;
    }

    public void setUserActivetyListId(Long userActivetyListId) {
        this.userActivetyListId = userActivetyListId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getActivetyId() {
        return activetyId;
    }

    public void setActivetyId(Long activetyId) {
        this.activetyId = activetyId;
    }

    public Byte getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    public Byte getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}