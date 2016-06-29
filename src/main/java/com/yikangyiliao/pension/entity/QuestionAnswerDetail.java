package com.yikangyiliao.pension.entity;

import java.util.Date;

public class QuestionAnswerDetail {
    private Long questionAnswerDetailId;

    private Long questionAnswerId;

    private Date createTime;

    private Date updateTime;

    private Long createUserId;
    
    private String questionAnswerDetailContent;

    private String questionAnswerHtmlContent;

    public Long getQuestionAnswerDetailId() {
        return questionAnswerDetailId;
    }

    public void setQuestionAnswerDetailId(Long questionAnswerDetailId) {
        this.questionAnswerDetailId = questionAnswerDetailId;
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

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

	public String getQuestionAnswerDetailContent() {
		return questionAnswerDetailContent;
	}

	public void setQuestionAnswerDetailContent(String questionAnswerDetailContent) {
		this.questionAnswerDetailContent = questionAnswerDetailContent;
	}

	public String getQuestionAnswerHtmlContent() {
		return questionAnswerHtmlContent;
	}

	public void setQuestionAnswerHtmlContent(String questionAnswerHtmlContent) {
		this.questionAnswerHtmlContent = questionAnswerHtmlContent;
	}
}