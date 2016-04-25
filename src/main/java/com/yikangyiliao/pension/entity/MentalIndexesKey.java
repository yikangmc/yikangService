package com.yikangyiliao.pension.entity;

public class MentalIndexesKey {
    private String mentalIndexesId;

    private Long assessmentId;

    public String getMentalIndexesId() {
        return mentalIndexesId;
    }

    public void setMentalIndexesId(String mentalIndexesId) {
        this.mentalIndexesId = mentalIndexesId == null ? null : mentalIndexesId.trim();
    }

    public Long getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
    }
}