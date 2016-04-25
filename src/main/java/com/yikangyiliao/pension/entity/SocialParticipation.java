package com.yikangyiliao.pension.entity;

public class SocialParticipation extends SocialParticipationKey {
    private Long spId;

    private Byte viability;

    private Byte workingAbility;

    private Byte temporalOrientation;

    private Byte personalOrientation;

    private Byte socialIntercourse;

    private Integer totalScore;

    private Long createTime;

    private Long updateTime;

    public Long getSpId() {
        return spId;
    }

    public void setSpId(Long spId) {
        this.spId = spId;
    }

    public Byte getViability() {
        return viability;
    }

    public void setViability(Byte viability) {
        this.viability = viability;
    }

    public Byte getWorkingAbility() {
        return workingAbility;
    }

    public void setWorkingAbility(Byte workingAbility) {
        this.workingAbility = workingAbility;
    }

    public Byte getTemporalOrientation() {
        return temporalOrientation;
    }

    public void setTemporalOrientation(Byte temporalOrientation) {
        this.temporalOrientation = temporalOrientation;
    }

    public Byte getPersonalOrientation() {
        return personalOrientation;
    }

    public void setPersonalOrientation(Byte personalOrientation) {
        this.personalOrientation = personalOrientation;
    }

    public Byte getSocialIntercourse() {
        return socialIntercourse;
    }

    public void setSocialIntercourse(Byte socialIntercourse) {
        this.socialIntercourse = socialIntercourse;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
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
}