package com.yikangyiliao.pension.entity;

public class SocialParticipationKey {
    private String socialParticipationId;

    private Long assessmentId;

    public String getSocialParticipationId() {
        return socialParticipationId;
    }

    public void setSocialParticipationId(String socialParticipationId) {
        this.socialParticipationId = socialParticipationId == null ? null : socialParticipationId.trim();
    }

    public Long getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
    }
}