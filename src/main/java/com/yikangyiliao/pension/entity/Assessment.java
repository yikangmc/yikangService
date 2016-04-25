package com.yikangyiliao.pension.entity;

public class Assessment {
    private Long assessmentId;

    private Long seniorId;

    private String assessmentNumber;

    private String assessmentName;

    private Boolean onlineAssess;

    private Boolean dailyState;

    private Boolean mentalityState;

    private Boolean perceptionConmunication;

    private Boolean socialParticipation;

    private Boolean commonProblem;

    private Boolean fallRisk;

    private Boolean dementia;

    private Boolean lifeNursings;

    private Boolean pathologicalSigns;

    private Boolean ppAssessment;

    private Boolean depression;

    private Long createTime;

    private Long updateTime;

    private Long appraisersId;

    private String appraisersName;

    private Byte isDelete;

    public Long getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
    }

    public Long getSeniorId() {
        return seniorId;
    }

    public void setSeniorId(Long seniorId) {
        this.seniorId = seniorId;
    }

    public String getAssessmentNumber() {
        return assessmentNumber;
    }

    public void setAssessmentNumber(String assessmentNumber) {
        this.assessmentNumber = assessmentNumber == null ? null : assessmentNumber.trim();
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName == null ? null : assessmentName.trim();
    }

    public Boolean getOnlineAssess() {
        return onlineAssess;
    }

    public void setOnlineAssess(Boolean onlineAssess) {
        this.onlineAssess = onlineAssess;
    }

    public Boolean getDailyState() {
        return dailyState;
    }

    public void setDailyState(Boolean dailyState) {
        this.dailyState = dailyState;
    }

    public Boolean getMentalityState() {
        return mentalityState;
    }

    public void setMentalityState(Boolean mentalityState) {
        this.mentalityState = mentalityState;
    }

    public Boolean getPerceptionConmunication() {
        return perceptionConmunication;
    }

    public void setPerceptionConmunication(Boolean perceptionConmunication) {
        this.perceptionConmunication = perceptionConmunication;
    }

    public Boolean getSocialParticipation() {
        return socialParticipation;
    }

    public void setSocialParticipation(Boolean socialParticipation) {
        this.socialParticipation = socialParticipation;
    }

    public Boolean getCommonProblem() {
        return commonProblem;
    }

    public void setCommonProblem(Boolean commonProblem) {
        this.commonProblem = commonProblem;
    }

    public Boolean getFallRisk() {
        return fallRisk;
    }

    public void setFallRisk(Boolean fallRisk) {
        this.fallRisk = fallRisk;
    }

    public Boolean getDementia() {
        return dementia;
    }

    public void setDementia(Boolean dementia) {
        this.dementia = dementia;
    }

    public Boolean getLifeNursings() {
        return lifeNursings;
    }

    public void setLifeNursings(Boolean lifeNursings) {
        this.lifeNursings = lifeNursings;
    }

    public Boolean getPathologicalSigns() {
        return pathologicalSigns;
    }

    public void setPathologicalSigns(Boolean pathologicalSigns) {
        this.pathologicalSigns = pathologicalSigns;
    }

    public Boolean getPpAssessment() {
        return ppAssessment;
    }

    public void setPpAssessment(Boolean ppAssessment) {
        this.ppAssessment = ppAssessment;
    }

    public Boolean getDepression() {
        return depression;
    }

    public void setDepression(Boolean depression) {
        this.depression = depression;
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

    public Long getAppraisersId() {
        return appraisersId;
    }

    public void setAppraisersId(Long appraisersId) {
        this.appraisersId = appraisersId;
    }

    public String getAppraisersName() {
        return appraisersName;
    }

    public void setAppraisersName(String appraisersName) {
        this.appraisersName = appraisersName == null ? null : appraisersName.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}