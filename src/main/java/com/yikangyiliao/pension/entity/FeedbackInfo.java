package com.yikangyiliao.pension.entity;

import java.util.Date;

public class FeedbackInfo {
    private Long feedbackInfoId;

    private String content;

    private String image;

    private Long createUserId;

    private String connectMethod;

    private Date createTime;

    private Date updateTime;

    private Date processTime;

    private Long processUserId;

    private Byte processStatus;

    public Long getFeedbackInfoId() {
        return feedbackInfoId;
    }

    public void setFeedbackInfoId(Long feedbackInfoId) {
        this.feedbackInfoId = feedbackInfoId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getConnectMethod() {
        return connectMethod;
    }

    public void setConnectMethod(String connectMethod) {
        this.connectMethod = connectMethod == null ? null : connectMethod.trim();
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

    public Date getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Date processTime) {
        this.processTime = processTime;
    }

    public Long getProcessUserId() {
        return processUserId;
    }

    public void setProcessUserId(Long processUserId) {
        this.processUserId = processUserId;
    }

    public Byte getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(Byte processStatus) {
        this.processStatus = processStatus;
    }
}