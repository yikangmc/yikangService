package com.yikangyiliao.pension.entity;

import java.util.Date;

public class FormPostsStarList {
    private Long forumPostsStarListId;

    private Long createUserId;

    private Date createTime;

    private Long forumPostsId;
    
    private String createUserName;
    
    /**
     * 下面添加展示数据， 不能对，映射实体做初始化
     * **/
    private String userName;
    
    private String photoUrl="";
    
    
    public Long getForumPostsStarListId() {
        return forumPostsStarListId;
    }

    public void setForumPostsStarListId(Long forumPostsStarListId) {
        this.forumPostsStarListId = forumPostsStarListId;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getForumPostsId() {
        return forumPostsId;
    }

    public void setForumPostsId(Long forumPostsId) {
        this.forumPostsId = forumPostsId;
    }

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
}