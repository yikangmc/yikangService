package com.yikangyiliao.pension.entity;

import java.util.ArrayList;
import java.util.List;

public class UserServiceInfo {
    private Long userServiceInfoId;

    private Long userId;

    private Long jobCategory;

    private Long userPostion;
    
    private Long userPosition;

    private Long provenceCode;

    private Long cityCode;

    private Long districtCode;

    private String addressDetail;

    private String photoUrl;

    private Long createTime;

    private Long updateTime;

    private Byte isDelete;

    private String userServiceName;
    
    private String userName;

    private Double longitude;

    private Double latitude;

    private String mapPositionAddress;

    private String hospital;

    private String offices;
    
    private Office officeObj;

    private String adept;
    
    // 职位审核状态
    private Byte positionAuditStatus;
    
    //邀请路径
    private String invitationUrl;
    
    //患者数量
    private Integer  nums;
    
    //用户信息填写状态
    private Integer infoWrite;
    
    //邀请码
    private String invitationCode;
    
    //擅长列表
    private List<Adept> adepts=new ArrayList<Adept>();
    
    //新修改的职位
    private Integer newUserPosition;

    public Long getUserServiceInfoId() {
        return userServiceInfoId;
    }

    public void setUserServiceInfoId(Long userServiceInfoId) {
        this.userServiceInfoId = userServiceInfoId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(Long jobCategory) {
        this.jobCategory = jobCategory;
    }

    public Long getUserPostion() {
        return userPostion;
    }

    public void setUserPostion(Long userPostion) {
        this.userPostion = userPostion;
    }

    public Long getProvenceCode() {
        return provenceCode;
    }

    public void setProvenceCode(Long provenceCode) {
        this.provenceCode = provenceCode;
    }

    public Long getCityCode() {
        return cityCode;
    }

    public void setCityCode(Long cityCode) {
        this.cityCode = cityCode;
    }

    public Long getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(Long districtCode) {
        this.districtCode = districtCode;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail == null ? null : addressDetail.trim();
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getUserServiceName() {
        return userServiceName;
    }

    public void setUserServiceName(String userServiceName) {
        this.userServiceName = userServiceName == null ? null : userServiceName.trim();
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getMapPositionAddress() {
        return mapPositionAddress;
    }

    public void setMapPositionAddress(String mapPositionAddress) {
        this.mapPositionAddress = mapPositionAddress == null ? null : mapPositionAddress.trim();
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital == null ? null : hospital.trim();
    }

    public String getOffices() {
        return offices;
    }

    public void setOffices(String offices) {
        this.offices = offices == null ? null : offices.trim();
    }

    public String getAdept() {
        return adept;
    }

    public void setAdept(String adept) {
        this.adept = adept == null ? null : adept.trim();
    }

	public Byte getPositionAuditStatus() {
		return positionAuditStatus;
	}

	public void setPositionAuditStatus(Byte positionAuditStatus) {
		this.positionAuditStatus = positionAuditStatus;
	}

	public String getInvitationUrl() {
		return invitationUrl;
	}

	public void setInvitationUrl(String invitationUrl) {
		this.invitationUrl = invitationUrl;
	}

	public Integer getNums() {
		return nums;
	}

	public void setNums(Integer nums) {
		this.nums = nums;
	}

	public Integer getInfoWrite() {
		return infoWrite;
	}

	public void setInfoWrite(Integer infoWrite) {
		this.infoWrite = infoWrite;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public List<Adept> getAdepts() {
		return adepts;
	}

	public void setAdepts(List<Adept> adepts) {
		this.adepts = adepts;
	}

	public Long getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(Long userPosition) {
		this.userPosition = userPosition;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getNewUserPosition() {
		return newUserPosition;
	}

	public void setNewUserPosition(Integer newUserPosition) {
		this.newUserPosition = newUserPosition;
	}

	public Office getOfficeObj() {
		return officeObj;
	}

	public void setOfficeObj(Office officeObj) {
		this.officeObj = officeObj;
	}
}