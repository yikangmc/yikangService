package com.yikangyiliao.pension.entity;

import java.util.Date;

public class Message {
    private Long messagesId;

    private String title;

    private String content;

    private Long fromUserId;

    private Long toUserId;

    private Date createTime;

    private Long createTimeMillisecond;

    private Date updateTime;

    private Byte isRead;

    private Byte messageGroup;

    private Byte contentGroup;
    
    private String userName;
    
    private String photoUrl;
    
    private Integer userPosition;

    public Long getMessagesId() {
        return messagesId;
    }

    public void setMessagesId(Long messagesId) {
        this.messagesId = messagesId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateTimeMillisecond() {
        return createTimeMillisecond;
    }

    public void setCreateTimeMillisecond(Long createTimeMillisecond) {
        this.createTimeMillisecond = createTimeMillisecond;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getIsRead() {
        return isRead;
    }

    public void setIsRead(Byte isRead) {
        this.isRead = isRead;
    }

    public Byte getMessageGroup() {
        return messageGroup;
    }

    public void setMessageGroup(Byte messageGroup) {
        this.messageGroup = messageGroup;
    }

    public Byte getContentGroup() {
        return contentGroup;
    }

    public void setContentGroup(Byte contentGroup) {
        this.contentGroup = contentGroup;
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

	public Integer getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(Integer userPosition) {
		this.userPosition = userPosition;
	}
}