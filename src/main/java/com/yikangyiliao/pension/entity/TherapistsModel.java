package com.yikangyiliao.pension.entity;

import java.util.List;

/**
 * @author liushuaic
 * @date 2016-03-14
 * 
 * */
public class TherapistsModel extends UserInfoModel{
	
	private Integer jobCategroy;
	private List<AdeptModel> adepts;
	private String hospital;

	private Integer cityCode;
	private Integer districtCode;
	private String addressDetail;
	public Integer getJobCategroy() {
		return jobCategroy;
	}
	public void setJobCategroy(Integer jobCategroy) {
		this.jobCategroy = jobCategroy;
	}
	public List<AdeptModel> getAdepts() {
		return adepts;
	}
	public void setAdepts(List<AdeptModel> adepts) {
		this.adepts = adepts;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public Integer getCityCode() {
		return cityCode;
	}
	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}
	public Integer getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(Integer districtCode) {
		this.districtCode = districtCode;
	}
 

}
