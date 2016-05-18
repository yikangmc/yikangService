package com.yikangyiliao.pension.entity;

import java.util.Date;

public class ActivetyTaglibMap {
    private Long activetyTaglibMapId;

    private Long activetyId;

    private Long tagLibId;

    private Date createTime;

    private Date updateTime;

    public Long getActivetyTaglibMapId() {
        return activetyTaglibMapId;
    }

    public void setActivetyTaglibMapId(Long activetyTaglibMapId) {
        this.activetyTaglibMapId = activetyTaglibMapId;
    }

    public Long getActivetyId() {
        return activetyId;
    }

    public void setActivetyId(Long activetyId) {
        this.activetyId = activetyId;
    }

    public Long getTagLibId() {
        return tagLibId;
    }

    public void setTagLibId(Long tagLibId) {
        this.tagLibId = tagLibId;
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