package com.yikangyiliao.pension.entity;

public class PerceptionCommunication extends PerceptionCommunicationKey {
    private Long pcId;

    private Byte consciousness;

    private Byte vision;

    private Byte hearing;

    private Byte communication;

    private Long createTime;

    private Long updateTime;

    public Long getPcId() {
        return pcId;
    }

    public void setPcId(Long pcId) {
        this.pcId = pcId;
    }

    public Byte getConsciousness() {
        return consciousness;
    }

    public void setConsciousness(Byte consciousness) {
        this.consciousness = consciousness;
    }

    public Byte getVision() {
        return vision;
    }

    public void setVision(Byte vision) {
        this.vision = vision;
    }

    public Byte getHearing() {
        return hearing;
    }

    public void setHearing(Byte hearing) {
        this.hearing = hearing;
    }

    public Byte getCommunication() {
        return communication;
    }

    public void setCommunication(Byte communication) {
        this.communication = communication;
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