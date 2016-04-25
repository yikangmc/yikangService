package com.yikangyiliao.pension.entity;

public class SurveyScoreDetail {
    private Long surveyScoreDetailId;

    private Long surveyId;

    private Long questionId;

    private Float score;

    private Long answerId;

    private Byte isDelete;

    private Long surveyScoreId;

    public Long getSurveyScoreDetailId() {
        return surveyScoreDetailId;
    }

    public void setSurveyScoreDetailId(Long surveyScoreDetailId) {
        this.surveyScoreDetailId = surveyScoreDetailId;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Long getSurveyScoreId() {
        return surveyScoreId;
    }

    public void setSurveyScoreId(Long surveyScoreId) {
        this.surveyScoreId = surveyScoreId;
    }
}