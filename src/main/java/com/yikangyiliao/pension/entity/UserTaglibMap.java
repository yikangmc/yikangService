package com.yikangyiliao.pension.entity;

import java.util.Date;

public class UserTaglibMap {
    private Long userTaglibMapsId;

    private Long createUserId;

    private Long taglibId;

    private Date createTime;

    private Date updateTime;

    public Long getUserTaglibMapsId() {
        return userTaglibMapsId;
    }

    public void setUserTaglibMapsId(Long userTaglibMapsId) {
        this.userTaglibMapsId = userTaglibMapsId;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getTaglibId() {
        return taglibId;
    }

    public void setTaglibId(Long taglibId) {
        this.taglibId = taglibId;
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