package com.yikangyiliao.pension.entity;

import com.yikangyiliao.base.utils.DateUtils;

public class UserModel {
	
	
	// 用户id
	private Long userId;
	//用户名
	private String name;
	//登陆名称
	private String loginName;
	// 用户出生日期
	private String bithYear;
	//用户性别
	private String sex;
	//用户头像
	private String photoUrl;
	//创建时间字符串
	private String createTimeStr;
	//创建时间
	private Long   createTime;
	//用户状态
	private Integer userStatus;
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getBithYear() {
		return bithYear;
	}
	public void setBithYear(String bithYear) {
		this.bithYear = bithYear;
	}
	
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getCreateTimeStr() {
		return createTimeStr;
	}
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		createTimeStr=DateUtils.formateDate(createTime);
		this.createTime = createTime;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

}
