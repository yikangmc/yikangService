package com.yikangyiliao.pension.entity;

public class MentalIndexes extends MentalIndexesKey {
    private Long mentalId;

    private Byte cognitiveFunction;

    private Byte attackBehavior;

    private Byte depressiveSymptoms;

    private Integer totalScore;

    private Long createTime;

    private Long updateTime;

    public Long getMentalId() {
        return mentalId;
    }

    public void setMentalId(Long mentalId) {
        this.mentalId = mentalId;
    }

    public Byte getCognitiveFunction() {
        return cognitiveFunction;
    }

    public void setCognitiveFunction(Byte cognitiveFunction) {
        this.cognitiveFunction = cognitiveFunction;
    }

    public Byte getAttackBehavior() {
        return attackBehavior;
    }

    public void setAttackBehavior(Byte attackBehavior) {
        this.attackBehavior = attackBehavior;
    }

    public Byte getDepressiveSymptoms() {
        return depressiveSymptoms;
    }

    public void setDepressiveSymptoms(Byte depressiveSymptoms) {
        this.depressiveSymptoms = depressiveSymptoms;
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