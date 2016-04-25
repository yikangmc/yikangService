package com.yikangyiliao.pension.entity;

public class AdeptModel {
	
	private Long adeptId;
	private String adeptName;
	
	private String cityCode;
	private String districtCode;
	private String addressDetail;

	public Long getAdeptId() {
		return adeptId;
	}

	public void setAdeptId(Long adeptId) {
		this.adeptId = adeptId;
	}

	public String getAdeptName() {
		return adeptName;
	}

	public void setAdeptName(String adeptName) {
		this.adeptName = adeptName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

}
