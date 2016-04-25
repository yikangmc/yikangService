package com.yikangyiliao.pension.entity;

public class UserConfigration {
    private Long userConfigrationsId;

    private Long userId;

    private Byte systemAlert;

    private Byte dynamicAlert;

    public Long getUserConfigrationsId() {
        return userConfigrationsId;
    }

    public void setUserConfigrationsId(Long userConfigrationsId) {
        this.userConfigrationsId = userConfigrationsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getSystemAlert() {
        return systemAlert;
    }

    public void setSystemAlert(Byte systemAlert) {
        this.systemAlert = systemAlert;
    }

    public Byte getDynamicAlert() {
        return dynamicAlert;
    }

    public void setDynamicAlert(Byte dynamicAlert) {
        this.dynamicAlert = dynamicAlert;
    }
}