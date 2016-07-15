package com.yikangyiliao.pension.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserServiceInfo {
	private Integer followCount;
	
    private Long userServiceInfoId;

    private Long userId;

    private Long jobCategory;

    private Byte userPosition;

    private Long provenceCode=0l;

    private Long cityCode=0l;

    private Long districtCode=0l;

    private String addressDetail;

    private String photoUrl;

    private Long createTime=0l;

    private Long updateTime=0l;

    private Byte isDelete;

    private String userServiceName;
    
    private String userName;

    private String userSex;
    
    private Date birthday;
    
    private Double longitude;

    private Double latitude;

    private String mapPositionAddress;

    private String hospital;

    private Integer offices;
    
    private Office officeObj;

    private String adept;
    
    private Long adeptId;
    
    private String adeptName;
    
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
    
    //组织机构名称
    private String oraganizationName;

    //用户介绍
    private String userIntroduce;

    //工作领域
    private Byte workRealm;

    //用户证书
    private String userCertificate;

//    用户文章列表
    private List<FormPosts> formPosts;
    
    
    private String designationName;
    
    
    private int followUserNumber;
    
    private int forumPostsTznumber;
    
    private int watchTaglibNumber;
    
    private int isFollow;
    
    public Integer getFollowCount() {
		return followCount;
	}

	public void setFollowCount(Integer followCount) {
		this.followCount = followCount;
	}

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

    public Integer getOffices() {
        return offices;
    }

    public void setOffices(Integer offices) {
        this.offices = offices;
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

	public String getOraganizationName() {
		return oraganizationName;
	}

	public void setOraganizationName(String oraganizationName) {
		this.oraganizationName = oraganizationName;
	}

	public String getUserIntroduce() {
		return userIntroduce;
	}

	public void setUserIntroduce(String userIntroduce) {
		this.userIntroduce = userIntroduce;
	}

	public Byte getWorkRealm() {
		return workRealm;
	}

	public void setWorkRealm(Byte workRealm) {
		this.workRealm = workRealm;
	}

	public String getUserCertificate() {
		return userCertificate;
	}

	public void setUserCertificate(String userCertificate) {
		this.userCertificate = userCertificate;
	}

	public List<FormPosts> getFormPosts() {
		return formPosts;
	}

	public void setFormPosts(List<FormPosts> formPosts) {
		this.formPosts = formPosts;
	}

	public Byte getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(Byte userPosition) {
		this.userPosition = userPosition;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public int getFollowUserNumber() {
		return followUserNumber;
	}

	public void setFollowUserNumber(int followUserNumber) {
		this.followUserNumber = followUserNumber;
	}

	public int getForumPostsTznumber() {
		return forumPostsTznumber;
	}

	public void setForumPostsTznumber(int forumPostsTznumber) {
		this.forumPostsTznumber = forumPostsTznumber;
	}

	public int getWatchTaglibNumber() {
		return watchTaglibNumber;
	}

	public void setWatchTaglibNumber(int watchTaglibNumber) {
		this.watchTaglibNumber = watchTaglibNumber;
	}

	public int getIsFollow() {
		return isFollow;
	}

	public void setIsFollow(int isFollow) {
		this.isFollow = isFollow;
	}

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

	

}