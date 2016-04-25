package com.yikangyiliao.pension.entity;

public class pathologicalSign {
    private Long pathologicalId;

    private Long assessmentId;

    private Long seniorId;

    private Boolean respiratorySystem;

    private Boolean circulatorySystem;

    private Boolean digestiveSystem;

    private Boolean urinarySystem;

    private Boolean endocrineSystem;

    private Boolean nervousSystem;

    private Boolean skeletalSystem;

    private Boolean otherSystem;

    private Long createTime;

    private Long updateTime;

    private Long appraisersId;

    private String appraisersName;

    private Boolean isDelete;

    public Long getPathologicalId() {
        return pathologicalId;
    }

    public void setPathologicalId(Long pathologicalId) {
        this.pathologicalId = pathologicalId;
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

    public Boolean getRespiratorySystem() {
        return respiratorySystem;
    }

    public void setRespiratorySystem(Boolean respiratorySystem) {
        this.respiratorySystem = respiratorySystem;
    }

    public Boolean getCirculatorySystem() {
        return circulatorySystem;
    }

    public void setCirculatorySystem(Boolean circulatorySystem) {
        this.circulatorySystem = circulatorySystem;
    }

    public Boolean getDigestiveSystem() {
        return digestiveSystem;
    }

    public void setDigestiveSystem(Boolean digestiveSystem) {
        this.digestiveSystem = digestiveSystem;
    }

    public Boolean getUrinarySystem() {
        return urinarySystem;
    }

    public void setUrinarySystem(Boolean urinarySystem) {
        this.urinarySystem = urinarySystem;
    }

    public Boolean getEndocrineSystem() {
        return endocrineSystem;
    }

    public void setEndocrineSystem(Boolean endocrineSystem) {
        this.endocrineSystem = endocrineSystem;
    }

    public Boolean getNervousSystem() {
        return nervousSystem;
    }

    public void setNervousSystem(Boolean nervousSystem) {
        this.nervousSystem = nervousSystem;
    }

    public Boolean getSkeletalSystem() {
        return skeletalSystem;
    }

    public void setSkeletalSystem(Boolean skeletalSystem) {
        this.skeletalSystem = skeletalSystem;
    }

    public Boolean getOtherSystem() {
        return otherSystem;
    }

    public void setOtherSystem(Boolean otherSystem) {
        this.otherSystem = otherSystem;
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