package com.yikangyiliao.pension.entity;


public class DocotorModel  extends UserInfoModel {

	// 兼职全职
	private Integer jobCategroy;
	private String hospital;
	private String offices;
	private Office office;

	public Integer getJobCategroy() {
		return jobCategroy;
	}

	public void setJobCategroy(Integer jobCategroy) {
		this.jobCategroy = jobCategroy;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getOffices() {
		return offices;
	}

	public void setOffices(String offices) {
		this.offices = offices;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

}