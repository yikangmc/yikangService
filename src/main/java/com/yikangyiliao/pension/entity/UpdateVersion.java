package com.yikangyiliao.pension.entity;

import java.util.Date;

public class UpdateVersion {
    private Long updateVersionId;

    private String updateVersion;

    private String downloadLink;

    private Byte isNewVersion;

    private Long createUserId;

    private Date createTime;

    private Date updateTime;

    private Byte mobilePhoneType;

    private Byte forcedToUpdate;

    private String updateInfo;

    private Integer updateNumbers;

    public Long getUpdateVersionId() {
        return updateVersionId;
    }

    public void setUpdateVersionId(Long updateVersionId) {
        this.updateVersionId = updateVersionId;
    }

    public String getUpdateVersion() {
        return updateVersion;
    }

    public void setUpdateVersion(String updateVersion) {
        this.updateVersion = updateVersion == null ? null : updateVersion.trim();
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink == null ? null : downloadLink.trim();
    }

    public Byte getIsNewVersion() {
        return isNewVersion;
    }

    public void setIsNewVersion(Byte isNewVersion) {
        this.isNewVersion = isNewVersion;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
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

    public Byte getMobilePhoneType() {
        return mobilePhoneType;
    }

    public void setMobilePhoneType(Byte mobilePhoneType) {
        this.mobilePhoneType = mobilePhoneType;
    }

    public Byte getForcedToUpdate() {
        return forcedToUpdate;
    }

    public void setForcedToUpdate(Byte forcedToUpdate) {
        this.forcedToUpdate = forcedToUpdate;
    }

    public String getUpdateInfo() {
        return updateInfo;
    }

    public void setUpdateInfo(String updateInfo) {
        this.updateInfo = updateInfo == null ? null : updateInfo.trim();
    }

    public Integer getUpdateNumbers() {
        return updateNumbers;
    }

    public void setUpdateNumbers(Integer updateNumbers) {
        this.updateNumbers = updateNumbers;
    }
}