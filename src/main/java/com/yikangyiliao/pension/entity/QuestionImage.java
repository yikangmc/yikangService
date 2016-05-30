package com.yikangyiliao.pension.entity;

import java.util.Date;

public class QuestionImage {
    private Long questionImageId;

    private String imageUrl;

    private Date createTime;

    private Long questionId;

    public Long getQuestionImageId() {
        return questionImageId;
    }

    public void setQuestionImageId(Long questionImageId) {
        this.questionImageId = questionImageId;
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

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}