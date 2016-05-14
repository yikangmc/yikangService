package com.yikangyiliao.pension.entity;

import java.util.Date;

public class QuestionTaglibMap {
    private Long questionTaglibMapsId;

    private Long taglibsId;

    private Long questionsId;

    private Date createTime;

    private Date updateTime;

    public Long getQuestionTaglibMapsId() {
        return questionTaglibMapsId;
    }

    public void setQuestionTaglibMapsId(Long questionTaglibMapsId) {
        this.questionTaglibMapsId = questionTaglibMapsId;
    }

    public Long getTaglibsId() {
        return taglibsId;
    }

    public void setTaglibsId(Long taglibsId) {
        this.taglibsId = taglibsId;
    }

    public Long getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(Long questionsId) {
        this.questionsId = questionsId;
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