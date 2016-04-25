package com.yikangyiliao.pension.entity;

public class UserDeviceTab {
    private Long userDeviceTabId;

    private Long userId;

    private Long deviceId;

    private Long createTime;

    private Long updateTime;

    public Long getUserDeviceTabId() {
        return userDeviceTabId;
    }

    public void setUserDeviceTabId(Long userDeviceTabId) {
        this.userDeviceTabId = userDeviceTabId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
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
}