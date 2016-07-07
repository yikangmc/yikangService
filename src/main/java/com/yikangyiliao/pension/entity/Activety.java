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

    private Integer personNumber;

    private Byte checkStatus;

    private Long createUserId;

    private String mapPsitionAddress;

    private String detailAddress;

    private Date startTime;

    private Date endTime;

    private Date entryStartTime;

    private Date entryEndTime;

    private Byte activetyMode;

    private String recommendPicUrl;
    
    private List<UserInfo> followUsers;

    private String createUsername;
    
    private String photoUrl;
    
    private Integer userPosition;
    
    //活动已经参与人员数量
    private Integer partakeNums=0;
    
    //活动状态 1 开始报名 2 报名结束 3 活动开始 4 活动结束
    private Integer activetyStatus;
    
    //是否已经参加活动 0 参加 ，1 已经参加
    private Integer isPartake;
    
    private List<ActivetyComment> activtyComments;
    
    
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

    public Integer getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(Integer personNumber) {
        this.personNumber = personNumber;
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

    public Date getEntryStartTime() {
        return entryStartTime;
    }

    public void setEntryStartTime(Date entryStartTime) {
        this.entryStartTime = entryStartTime;
    }

    public Date getEntryEndTime() {
        return entryEndTime;
    }

    public void setEntryEndTime(Date entryEndTime) {
        this.entryEndTime = entryEndTime;
    }

    public Byte getActivetyMode() {
        return activetyMode;
    }

    public void setActivetyMode(Byte activetyMode) {
        this.activetyMode = activetyMode;
    }

    public String getRecommendPicUrl() {
        return recommendPicUrl;
    }

    public void setRecommendPicUrl(String recommendPicUrl) {
        this.recommendPicUrl = recommendPicUrl == null ? null : recommendPicUrl.trim();
    }

	public List<UserInfo> getFollowUsers() {
		return followUsers;
	}

	public void setFollowUsers(List<UserInfo> followUsers) {
		this.followUsers = followUsers;
	}

	public String getCreateUsername() {
		return createUsername;
	}

	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Integer getPartakeNums() {
		return partakeNums;
	}

	public void setPartakeNums(Integer partakeNums) {
		this.partakeNums = partakeNums;
	}

	public Integer getActivetyStatus() {
		return activetyStatus;
	}

	public void setActivetyStatus(Integer activetyStatus) {
		this.activetyStatus = activetyStatus;
	}

	public Integer getIsPartake() {
		return isPartake;
	}

	public void setIsPartake(Integer isPartake) {
		this.isPartake = isPartake;
	}

	public Integer getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(Integer userPosition) {
		this.userPosition = userPosition;
	}

	public List<ActivetyComment> getActivtyComments() {
		return activtyComments;
	}

	public void setActivtyComments(List<ActivetyComment> activtyComments) {
		this.activtyComments = activtyComments;
	}
}