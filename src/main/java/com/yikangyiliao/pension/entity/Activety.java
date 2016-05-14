package com.yikangyiliao.pension.entity;

import java.util.Date;
import java.util.List;

public class Activety {
    private Long activetyId;

    private String title;

    private String content;

    private Double cost;

    private Date createTime;

    private Date updateTime;

    private String personNumber;

    private Byte checkStatus;

    private Long createUserId;

    private String createUsername;
    
    private String mapPsitionAddress;

    private String detailAddress;

    private Date startTime;

    private Date endTime;

    private List<UserInfo> followUsers;
    
    public Long getActivetyId() {
        return activetyId;
    }

    public void setActivetyId(Long activetyId) {
        this.activetyId = activetyId;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
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

    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber == null ? null : personNumber.trim();
    }

    public Byte getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Byte checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getMapPsitionAddress() {
        return mapPsitionAddress;
    }

    public void setMapPsitionAddress(String mapPsitionAddress) {
        this.mapPsitionAddress = mapPsitionAddress == null ? null : mapPsitionAddress.trim();
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress == null ? null : detailAddress.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

	public String getCreateUsername() {
		return createUsername;
	}

	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}

	public List<UserInfo> getFollowUsers() {
		return followUsers;
	}

	public void setFollowUsers(List<UserInfo> followUsers) {
		this.followUsers = followUsers;
	}
}