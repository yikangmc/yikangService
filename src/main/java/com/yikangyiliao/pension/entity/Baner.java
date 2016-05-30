package com.yikangyiliao.pension.entity;

import java.util.Date;

public class Baner {
    private Long banerId;

    private String title;

    private String content;

    private Byte orders;

    private String actionUrl;

    private Date createTime;

    private Date upateTime;

    private String isDelete;

    private Long createUserId;

    private Byte groups;
    
    private String banerPic;

    public Long getBanerId() {
        return banerId;
    }

    public void setBanerId(Long banerId) {
        this.banerId = banerId;
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

    public Byte getOrders() {
        return orders;
    }

    public void setOrders(Byte orders) {
        this.orders = orders;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl == null ? null : actionUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpateTime() {
        return upateTime;
    }

    public void setUpateTime(Date upateTime) {
        this.upateTime = upateTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
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

	public String getBanerPic() {
		return banerPic;
	}

	public void setBanerPic(String banerPic) {
		this.banerPic = banerPic;
	}
}