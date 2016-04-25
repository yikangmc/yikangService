package com.yikangyiliao.pension.entity;

public class DailyIndexes extends DailyIndexesKey {
    private Long dailyId;

    private Long seniorId;

    private Integer eat;

    private Integer bath;

    private Integer facialDecency;

    private Integer dressing;

    private Integer urinateControl;

    private Integer defecateControl;

    private Integer toileting;

    private Integer bedToChair;

    private Integer flatWalking;

    private Integer upanddownStairs;

    private Integer totalScore;

    private Long createTime;

    private Long updateTime;

    public Long getDailyId() {
        return dailyId;
    }

    public void setDailyId(Long dailyId) {
        this.dailyId = dailyId;
    }

    public Long getSeniorId() {
        return seniorId;
    }

    public void setSeniorId(Long seniorId) {
        this.seniorId = seniorId;
    }

    public Integer getEat() {
        return eat;
    }

    public void setEat(Integer eat) {
        this.eat = eat;
    }

    public Integer getBath() {
        return bath;
    }

    public void setBath(Integer bath) {
        this.bath = bath;
    }

    public Integer getFacialDecency() {
        return facialDecency;
    }

    public void setFacialDecency(Integer facialDecency) {
        this.facialDecency = facialDecency;
    }

    public Integer getDressing() {
        return dressing;
    }

    public void setDressing(Integer dressing) {
        this.dressing = dressing;
    }

    public Integer getUrinateControl() {
        return urinateControl;
    }

    public void setUrinateControl(Integer urinateControl) {
        this.urinateControl = urinateControl;
    }

    public Integer getDefecateControl() {
        return defecateControl;
    }

    public void setDefecateControl(Integer defecateControl) {
        this.defecateControl = defecateControl;
    }

    public Integer getToileting() {
        return toileting;
    }

    public void setToileting(Integer toileting) {
        this.toileting = toileting;
    }

    public Integer getBedToChair() {
        return bedToChair;
    }

    public void setBedToChair(Integer bedToChair) {
        this.bedToChair = bedToChair;
    }

    public Integer getFlatWalking() {
        return flatWalking;
    }

    public void setFlatWalking(Integer flatWalking) {
        this.flatWalking = flatWalking;
    }

    public Integer getUpanddownStairs() {
        return upanddownStairs;
    }

    public void setUpanddownStairs(Integer upanddownStairs) {
        this.upanddownStairs = upanddownStairs;
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