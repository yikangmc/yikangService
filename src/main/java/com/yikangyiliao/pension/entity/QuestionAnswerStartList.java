package com.yikangyiliao.pension.entity;

import java.util.Date;

public class QuestionAnswerStartList {
    private Long questionAnswerStartListId;

    private Long createUserId;

    private Long questionAnswerId;

    private Date createTime;

    private Date updateTime;

    public Long getQuestionAnswerStartListId() {
        return questionAnswerStartListId;
    }

    public void setQuestionAnswerStartListId(Long questionAnswerStartListId) {
        this.questionAnswerStartListId = questionAnswerStartListId;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getQuestionAnswerId() {
        return questionAnswerId;
    }

    public void setQuestionAnswerId(Long questionAnswerId) {
        this.questionAnswerId = questionAnswerId;
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