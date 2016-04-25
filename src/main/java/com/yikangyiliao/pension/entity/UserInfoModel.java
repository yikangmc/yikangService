package com.yikangyiliao.pension.entity;


public class UserInfoModel {

	private Long userId;
	private String userName;

	// 用户职位
	private Integer userPosition;

	private String photoUrl;
	private Long createTime;
	private String createTimeStr;
	
	//是否填写个人信息
	private Integer infoWrite;
	
	//职位审核状态
	private Integer positionAuditStatus;
	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(Integer userPosition) {
		this.userPosition = userPosition;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public Integer getInfoWrite() {
		return infoWrite;
	}

	public void setInfoWrite(Integer infoWrite) {
		this.infoWrite = infoWrite;
	}

	public Integer getPositionAuditStatus() {
		return positionAuditStatus;
	}

	public void setPositionAuditStatus(Integer positionAuditStatus) {
		this.positionAuditStatus = positionAuditStatus;
	}

}



