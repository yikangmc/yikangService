package com.yikangyiliao.pension.entity;

import java.util.Date;

public class QuestionAnswerImage {
    private Long questionAnswerImageId;

    private Long questionAnswerId;

    private String imageUrl;

    private Date createTime;

    private Date updateTime;

    public Long getQuestionAnswerImageId() {
        return questionAnswerImageId;
    }

    public void setQuestionAnswerImageId(Long questionAnswerImageId) {
        this.questionAnswerImageId = questionAnswerImageId;
    }

    public Long getQuestionAnswerId() {
        return questionAnswerId;
    }

    public void setQuestionAnswerId(Long questionAnswerId) {
        this.questionAnswerId = questionAnswerId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
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