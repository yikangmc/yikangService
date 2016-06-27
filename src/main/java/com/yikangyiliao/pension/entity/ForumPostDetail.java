package com.yikangyiliao.pension.entity;

import java.util.Date;

public class ForumPostDetail {
    private Long forumPostDetailId;

    private Long forumPostId;
    
    private String forumPostDetailContent;

    private String forumPostHtmlDetailContent;
    
    private Date createTime;

    private Date updateTime;

    public Long getForumPostDetailId() {
        return forumPostDetailId;
    }

    public void setForumPostDetailId(Long forumPostDetailId) {
        this.forumPostDetailId = forumPostDetailId;
    }

    public Long getForumPostId() {
        return forumPostId;
    }

    public void setForumPostId(Long forumPostId) {
        this.forumPostId = forumPostId;
    }

	public String getForumPostDetailContent() {
		return forumPostDetailContent;
	}

	public void setForumPostDetailContent(String forumPostDetailContent) {
		this.forumPostDetailContent = forumPostDetailContent;
	}

	public String getForumPostHtmlDetailContent() {
		return forumPostHtmlDetailContent;
	}

	public void setForumPostHtmlDetailContent(String forumPostHtmlDetailContent) {
		this.forumPostHtmlDetailContent = forumPostHtmlDetailContent;
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