package com.yikangyiliao.pension.entity;

import java.util.Date;

public class ForumPostsImage {
    private Long forumPostsImagesId;

    private String imageUrl;

    private Date createTime;

    private Long forumPostsId;

    public Long getForumPostsImagesId() {
        return forumPostsImagesId;
    }

    public void setForumPostsImagesId(Long forumPostsImagesId) {
        this.forumPostsImagesId = forumPostsImagesId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
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
}