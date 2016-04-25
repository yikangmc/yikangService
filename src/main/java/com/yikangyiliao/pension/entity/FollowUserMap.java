package com.yikangyiliao.pension.entity;

import java.util.Date;

public class FollowUserMap {
    private Long followUserMapsId;

    private Long createUserId;

    private Long followUserId;

    private Date createTime;

    private Date updateTime;

    public Long getFollowUserMapsId() {
        return followUserMapsId;
    }

    public void setFollowUserMapsId(Long followUserMapsId) {
        this.followUserMapsId = followUserMapsId;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getFollowUserId() {
        return followUserId;
    }

    public void setFollowUserId(Long followUserId) {
        this.followUserId = followUserId;
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