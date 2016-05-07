package com.yikangyiliao.pension.entity;

import java.util.Date;

public class ForumPostsAnswer {
    private Long forumPostsAnswerId;

    private Long formPostId;

    private Long createUserId;

    private Long toUserId;

    private String content;

    private Byte answerTo;

    private Date createTime;
    
    //回复创建人
    private String createUserName;
    
    //回复创建人头像
    private String createUserPhotoUrl;
    
    //给谁回复的
    private String toUserName;
    
    //回复人的头像
    private String toUserPhotoUrl;

    public Long getForumPostsAnswerId() {
        return forumPostsAnswerId;
    }

    public void setForumPostsAnswerId(Long forumPostsAnswerId) {
        this.forumPostsAnswerId = forumPostsAnswerId;
    }

    public Long getFormPostId() {
        return formPostId;
    }

    public void setFormPostId(Long formPostId) {
        this.formPostId = formPostId;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Byte getAnswerTo() {
        return answerTo;
    }

    public void setAnswerTo(Byte answerTo) {
        this.answerTo = answerTo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getCreateUserPhotoUrl() {
		return createUserPhotoUrl;
	}

	public void setCreateUserPhotoUrl(String createUserPhotoUrl) {
		this.createUserPhotoUrl = createUserPhotoUrl;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getToUserPhotoUrl() {
		return toUserPhotoUrl;
	}

	public void setToUserPhotoUrl(String toUserPhotoUrl) {
		this.toUserPhotoUrl = toUserPhotoUrl;
	}
}