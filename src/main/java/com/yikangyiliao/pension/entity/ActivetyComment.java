package com.yikangyiliao.pension.entity;

import java.util.Date;

public class ActivetyComment {
    private Long activetyCommentId;

    private Long createUserId;

    private Long activetyId;

    private Date createTime;

    private Date updateTime;

    private String content;
    
    private String photoUrl;
    
    private String userName;

    public Long getActivetyCommentId() {
        return activetyCommentId;
    }

    public void setActivetyCommentId(Long activetyCommentId) {
        this.activetyCommentId = activetyCommentId;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getActivetyId() {
        return activetyId;
    }

    public void setActivetyId(Long activetyId) {
        this.activetyId = activetyId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}