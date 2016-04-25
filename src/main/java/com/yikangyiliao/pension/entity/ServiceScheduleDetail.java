package com.yikangyiliao.pension.entity;

public class ServiceScheduleDetail {
    private Long serviceScheduleDetailId;

    private Long serviceScheduleId;

    private Long timeQuantumId;

    private Long createTime;

    private Long updateTime;

    private Long createUserId;

    public Long getServiceScheduleDetailId() {
        return serviceScheduleDetailId;
    }

    public void setServiceScheduleDetailId(Long serviceScheduleDetailId) {
        this.serviceScheduleDetailId = serviceScheduleDetailId;
    }

    public Long getServiceScheduleId() {
        return serviceScheduleId;
    }

    public void setServiceScheduleId(Long serviceScheduleId) {
        this.serviceScheduleId = serviceScheduleId;
    }

    public Long getTimeQuantumId() {
        return timeQuantumId;
    }

    public void setTimeQuantumId(Long timeQuantumId) {
        this.timeQuantumId = timeQuantumId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }
}