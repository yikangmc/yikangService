package com.yikangyiliao.pension.entity;

public class CommonProblemKey {
    private String commonProblemId;

    private Long assessmentId;

    public String getCommonProblemId() {
        return commonProblemId;
    }

    public void setCommonProblemId(String commonProblemId) {
        this.commonProblemId = commonProblemId == null ? null : commonProblemId.trim();
    }

    public Long getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
    }
}