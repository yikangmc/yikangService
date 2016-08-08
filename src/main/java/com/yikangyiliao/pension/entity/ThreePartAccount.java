package com.yikangyiliao.pension.entity;

import java.util.Date;

public class ThreePartAccount {
    private Long threePartAccountId;

    private String userName;

    private String gender;

    private String accountId;

    private Long userId;

    private Date createTime;

    private Date updateTime;

    private Byte userSource;

    private String threePartAccountInfo;

    public Long getThreePartAccountId() {
        return threePartAccountId;
    }

    public void setThreePartAccountId(Long threePartAccountId) {
        this.threePartAccountId = threePartAccountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Byte getUserSource() {
        return userSource;
    }

    public void setUserSource(Byte userSource) {
        this.userSource = userSource;
    }

    public String getThreePartAccountInfo() {
        return threePartAccountInfo;
    }

    public void setThreePartAccountInfo(String threePartAccountInfo) {
        this.threePartAccountInfo = threePartAccountInfo == null ? null : threePartAccountInfo.trim();
    }
}