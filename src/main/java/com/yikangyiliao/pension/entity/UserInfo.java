package com.yikangyiliao.pension.entity;

import java.util.Date;

public class UserInfo {
    private Long userInfoId;

    private String userName;

    private Byte userSex;

    private String provenceCode;

    private String cityCode;

    private String districtCode;

    private String address;

    private Long createAt;

    private Long updateAt;

    private Long userId;

    private Long isDelete;

    private String photoUrl;

    private String userIntroduce;

    private Date birthday;
    
    private String pushAlias;
    
    private Long designationId;
    
    private Long reportValidNumber;
    
    private String designationName;
    
    private String bindMobileNumber;

    public Long getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Long userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Byte getUserSex() {
        return userSex;
    }

    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    public String getProvenceCode() {
        return provenceCode;
    }

    public void setProvenceCode(String provenceCode) {
        this.provenceCode = provenceCode == null ? null : provenceCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode == null ? null : districtCode.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Long isDelete) {
        this.isDelete = isDelete;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    public String getUserIntroduce() {
        return userIntroduce;
    }

    public void setUserIntroduce(String userIntroduce) {
        this.userIntroduce = userIntroduce == null ? null : userIntroduce.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

	public String getPushAlias() {
		return pushAlias;
	}

	public void setPushAlias(String pushAlias) {
		this.pushAlias = pushAlias;
	}

	public Long getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getBindMobileNumber() {
		return bindMobileNumber;
	}

	public void setBindMobileNumber(String bindMobileNumber) {
		this.bindMobileNumber = bindMobileNumber;
	}

	public Long getReportValidNumber() {
		return reportValidNumber;
	}

	public void setReportValidNumber(Long reportValidNumber) {
		this.reportValidNumber = reportValidNumber;
	}
}