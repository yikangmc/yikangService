package com.yikangyiliao.pension.responseDataModel;

import java.util.List;

import com.yikangyiliao.pension.entity.UserModel;

/**
 * @author liushuaic
 * @date 2016-03-21 10:30
 * @desc 我邀请的用户数据列表
 * 
 * **/
public class MyInvationUserModel {

	
	/**
	 * @author liushuaic
	 * @date 2016-03-21 10:33
	 * @desc 获取我邀请的患者的总数
	 * **/
	private Integer nums;
	
	/**
	 * 注册用户的数量
	 * */
	private Integer regiestUserNums;
	
	/**
	 * 服务中用户的数量
	 * **/
	private Integer serviceingUserNums;
	
	/**
	 * 服务完成的用户数量
	 * **/
	private Integer servicedUerNums;
	
	
	/**
	 * 邀请的用户列表
	 * **/
	private List<UserModel> invitionUsers;


	public Integer getNums() {
		return nums;
	}


	public void setNums(Integer nums) {
		this.nums = nums;
	}


	public Integer getRegiestUserNums() {
		return regiestUserNums;
	}


	public void setRegiestUserNums(Integer regiestUserNums) {
		this.regiestUserNums = regiestUserNums;
	}


	public Integer getServiceingUserNums() {
		return serviceingUserNums;
	}


	public void setServiceingUserNums(Integer serviceingUserNums) {
		this.serviceingUserNums = serviceingUserNums;
	}


	public Integer getServicedUerNums() {
		return servicedUerNums;
	}


	public void setServicedUerNums(Integer servicedUerNums) {
		this.servicedUerNums = servicedUerNums;
	}


	public List<UserModel> getInvitionUsers() {
		return invitionUsers;
	}


	public void setInvitionUsers(List<UserModel> invitionUsers) {
		this.invitionUsers = invitionUsers;
	}


	 
	
	
}
