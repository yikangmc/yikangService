package com.yikangyiliao.pension.entity;

import java.util.Date;

public class StoreUp {
	private Long storeUpsId;

	private Long forumPostId;

	private Long createUserId;

	private Byte groups;

	private Date createTime;

	private Date updateTime;
	
	private FormPosts formPosts;

	public Long getStoreUpsId() {
		return storeUpsId;
	}

	public void setStoreUpsId(Long storeUpsId) {
		this.storeUpsId = storeUpsId;
	}

	public Long getForumPostId() {
		return forumPostId;
	}

	public void setForumPostId(Long forumPostId) {
		this.forumPostId = forumPostId;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Byte getGroups() {
		return groups;
	}

	public void setGroups(Byte groups) {
		this.groups = groups;
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

	public FormPosts getFormPosts() {
		return formPosts;
	}

	public void setFormPosts(FormPosts formPosts) {
		this.formPosts = formPosts;
	}
}