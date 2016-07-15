package com.yikangyiliao.pension.entity;

import java.util.Date;

public class RecommendData {
    private Long recommendDataId;

    private Byte recomendGroup;

    private Long dataId;

    private Date createTime;

    private Date updateTime;

    public Long getRecommendDataId() {
        return recommendDataId;
    }

    public void setRecommendDataId(Long recommendDataId) {
        this.recommendDataId = recommendDataId;
    }

    public Byte getRecomendGroup() {
        return recomendGroup;
    }

    public void setRecomendGroup(Byte recomendGroup) {
        this.recomendGroup = recomendGroup;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}