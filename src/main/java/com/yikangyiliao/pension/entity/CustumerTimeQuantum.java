package com.yikangyiliao.pension.entity;

import java.util.Date;

public class CustumerTimeQuantum {
    private Long custumerTimeQuantumId;

    private String startTime;

    private String endTime;

    private Date createTime;

    private Date updateTime;

    private Long createUserId;

    private String ownerTimeQuantumId;

    private Byte isDelete;

    public Long getCustumerTimeQuantumId() {
        return custumerTimeQuantumId;
    }

    public void setCustumerTimeQuantumId(Long custumerTimeQuantumId) {
        this.custumerTimeQuantumId = custumerTimeQuantumId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
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

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getOwnerTimeQuantumId() {
        return ownerTimeQuantumId;
    }

    public void setOwnerTimeQuantumId(String ownerTimeQuantumId) {
        this.ownerTimeQuantumId = ownerTimeQuantumId == null ? null : ownerTimeQuantumId.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}