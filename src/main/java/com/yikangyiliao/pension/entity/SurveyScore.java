package com.yikangyiliao.pension.entity;

public class SurveyScore {
    private Long sureyScoreId;

    private Long senorId;

    private Integer total;

    private Long assessorUserId;

    private String conclusion;

    private Long conclusionUserId;

    private Byte dataSource;

    private Long surveyTableId;

    private Long assessmentId;

    private String assessmentNumber;

    private Byte isDelete;

    public Long getSureyScoreId() {
        return sureyScoreId;
    }

    public void setSureyScoreId(Long sureyScoreId) {
        this.sureyScoreId = sureyScoreId;
    }

    public Long getSenorId() {
        return senorId;
    }

    public void setSenorId(Long senorId) {
        this.senorId = senorId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Long getAssessorUserId() {
        return assessorUserId;
    }

    public void setAssessorUserId(Long assessorUserId) {
        this.assessorUserId = assessorUserId;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion == null ? null : conclusion.trim();
    }

    public Long getConclusionUserId() {
        return conclusionUserId;
    }

    public void setConclusionUserId(Long conclusionUserId) {
        this.conclusionUserId = conclusionUserId;
    }

    public Byte getDataSource() {
        return dataSource;
    }

    public void setDataSource(Byte dataSource) {
        this.dataSource = dataSource;
    }

    public Long getSurveyTableId() {
        return surveyTableId;
    }

    public void setSurveyTableId(Long surveyTableId) {
        this.surveyTableId = surveyTableId;
    }

    public Long getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
    }

    public String getAssessmentNumber() {
        return assessmentNumber;
    }

    public void setAssessmentNumber(String assessmentNumber) {
        this.assessmentNumber = assessmentNumber;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}