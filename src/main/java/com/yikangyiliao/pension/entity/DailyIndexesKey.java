package com.yikangyiliao.pension.entity;

public class DailyIndexesKey {
    private String dailyIndexesId;

    private Long assessmentId;

    public String getDailyIndexesId() {
        return dailyIndexesId;
    }

    public void setDailyIndexesId(String dailyIndexesId) {
        this.dailyIndexesId = dailyIndexesId == null ? null : dailyIndexesId.trim();
    }

    public Long getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
    }
}