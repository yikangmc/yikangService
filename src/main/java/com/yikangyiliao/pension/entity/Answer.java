package com.yikangyiliao.pension.entity;

public class Answer {
    private Long answerId;

    private String answerText;

    private Integer answerVal;

    private Long createTime;

    private Long updateTime;

    private Long createUserId;

    private Byte answersDataSource;

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText == null ? null : answerText.trim();
    }

    public Integer getAnswerVal() {
        return answerVal;
    }

    public void setAnswerVal(Integer answerVal) {
        this.answerVal = answerVal;
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

    public Byte getAnswersDataSource() {
        return answersDataSource;
    }

    public void setAnswersDataSource(Byte answersDataSource) {
        this.answersDataSource = answersDataSource;
    }
}