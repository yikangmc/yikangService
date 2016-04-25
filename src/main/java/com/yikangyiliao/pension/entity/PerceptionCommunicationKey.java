package com.yikangyiliao.pension.entity;

public class PerceptionCommunicationKey {
    private String perceptionCommunicationId;

    private Long assessmentId;

    public String getPerceptionCommunicationId() {
        return perceptionCommunicationId;
    }

    public void setPerceptionCommunicationId(String perceptionCommunicationId) {
        this.perceptionCommunicationId = perceptionCommunicationId == null ? null : perceptionCommunicationId.trim();
    }

    public Long getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
    }
}