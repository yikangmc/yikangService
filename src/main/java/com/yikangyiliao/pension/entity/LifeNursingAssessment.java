package com.yikangyiliao.pension.entity;

public class LifeNursingAssessment {
    private Long lifeNursingId;

    private Long assessmentId;

    private Long seniorId;

    private Boolean hearingState;

    private Boolean visionState;

    private Boolean layingState;

    private Boolean memoryState;

    private Boolean behaviorState;

    private Boolean communicationState;

    private Boolean socialState;

    private Boolean medicationState;

    private Boolean dietState;

    private Boolean wearingState;

    private Boolean defecationUrination;

    private Boolean movementState;

    private Boolean consciousnessState;

    private Boolean psychologyState;

    private Boolean socialRelations;

    private Boolean affairsHandling;

    private Long createTime;

    private Long updateTime;

    private Long appraisersId;

    private String appraisersName;

    private Boolean isDelete;

    public Long getLifeNursingId() {
        return lifeNursingId;
    }

    public void setLifeNursingId(Long lifeNursingId) {
        this.lifeNursingId = lifeNursingId;
    }

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

    public Boolean getHearingState() {
        return hearingState;
    }

    public void setHearingState(Boolean hearingState) {
        this.hearingState = hearingState;
    }

    public Boolean getVisionState() {
        return visionState;
    }

    public void setVisionState(Boolean visionState) {
        this.visionState = visionState;
    }

    public Boolean getLayingState() {
        return layingState;
    }

    public void setLayingState(Boolean layingState) {
        this.layingState = layingState;
    }

    public Boolean getMemoryState() {
        return memoryState;
    }

    public void setMemoryState(Boolean memoryState) {
        this.memoryState = memoryState;
    }

    public Boolean getBehaviorState() {
        return behaviorState;
    }

    public void setBehaviorState(Boolean behaviorState) {
        this.behaviorState = behaviorState;
    }

    public Boolean getCommunicationState() {
        return communicationState;
    }

    public void setCommunicationState(Boolean communicationState) {
        this.communicationState = communicationState;
    }

    public Boolean getSocialState() {
        return socialState;
    }

    public void setSocialState(Boolean socialState) {
        this.socialState = socialState;
    }

    public Boolean getMedicationState() {
        return medicationState;
    }

    public void setMedicationState(Boolean medicationState) {
        this.medicationState = medicationState;
    }

    public Boolean getDietState() {
        return dietState;
    }

    public void setDietState(Boolean dietState) {
        this.dietState = dietState;
    }

    public Boolean getWearingState() {
        return wearingState;
    }

    public void setWearingState(Boolean wearingState) {
        this.wearingState = wearingState;
    }

    public Boolean getDefecationUrination() {
        return defecationUrination;
    }

    public void setDefecationUrination(Boolean defecationUrination) {
        this.defecationUrination = defecationUrination;
    }

    public Boolean getMovementState() {
        return movementState;
    }

    public void setMovementState(Boolean movementState) {
        this.movementState = movementState;
    }

    public Boolean getConsciousnessState() {
        return consciousnessState;
    }

    public void setConsciousnessState(Boolean consciousnessState) {
        this.consciousnessState = consciousnessState;
    }

    public Boolean getPsychologyState() {
        return psychologyState;
    }

    public void setPsychologyState(Boolean psychologyState) {
        this.psychologyState = psychologyState;
    }

    public Boolean getSocialRelations() {
        return socialRelations;
    }

    public void setSocialRelations(Boolean socialRelations) {
        this.socialRelations = socialRelations;
    }

    public Boolean getAffairsHandling() {
        return affairsHandling;
    }

    public void setAffairsHandling(Boolean affairsHandling) {
        this.affairsHandling = affairsHandling;
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

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}