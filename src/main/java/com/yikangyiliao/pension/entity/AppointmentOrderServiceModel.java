package com.yikangyiliao.pension.entity;

import com.yikangyiliao.base.utils.DateUtils;

public class AppointmentOrderServiceModel {
	
	
    private Long appointmentOrderId;

    private String phoneNumber="";

    private String myPhoneNumber="";

    private Long appointmentDateTime;

    private Long timeQuanturmId;

    private String startTime="";

    private String endTime="";

    private Integer orderStatus;

    private String cityCode="";

    private String districtCode="";

    private Double longitude;

    private Double latitude;

    private String detailAddress="";

    private String mapPostionAddress="";

    private String orderNumber="";

    private Byte dataSource;

    private Byte dataGroup;

    private Long createTime;
    
    private String createTimeStr="";

    private String linkUserName="";

    private String address="";

    private Long seniorId;

    private Long createUserId;
    
    private String  remarks="";
    
    private String appointmentDate;
    
    private Long   serviceItemId;
    
    private String serviceTitle;
    
    private String servicePrice;
    
    private String loginName;
    
    private Long userId;
    

    public Long getAppointmentOrderId() {
        return appointmentOrderId;
    }

    public void setAppointmentOrderId(Long appointmentOrderId) {
        this.appointmentOrderId = appointmentOrderId;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getMyPhoneNumber() {
        return myPhoneNumber;
    }

    public void setMyPhoneNumber(String myPhoneNumber) {
        this.myPhoneNumber = myPhoneNumber == null ? null : myPhoneNumber.trim();
    }


    public Long getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(Long appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public Long getTimeQuanturmId() {
        return timeQuanturmId;
    }

    public void setTimeQuanturmId(Long timeQuanturmId) {
        this.timeQuanturmId = timeQuanturmId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
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

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress == null ? null : detailAddress.trim();
    }

    public String getMapPostionAddress() {
        return mapPostionAddress;
    }

    public void setMapPostionAddress(String mapPostionAddress) {
        this.mapPostionAddress = mapPostionAddress == null ? null : mapPostionAddress.trim();
    }


    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public Byte getDataSource() {
        return dataSource;
    }

    public void setDataSource(Byte dataSource) {
        this.dataSource = dataSource;
    }

    public Byte getDataGroup() {
        return dataGroup;
    }

    public void setDataGroup(Byte dataGroup) {
        this.dataGroup = dataGroup;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
    	this.setCreateTimeStr(DateUtils.formateDate(createTime));
        this.createTime = createTime;
    }

    public String getLinkUserName() {
        return linkUserName;
    }

    public void setLinkUserName(String linkUserName) {
        this.linkUserName = linkUserName == null ? null : linkUserName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getSeniorId() {
        return seniorId;
    }

    public void setSeniorId(Long seniorId) {
        this.seniorId = seniorId;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getServiceTitle() {
		return serviceTitle;
	}

	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}

	public String getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(String servicePrice) {
		this.servicePrice = servicePrice;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getServiceItemId() {
		return serviceItemId;
	}

	public void setServiceItemId(Long serviceItemId) {
		this.serviceItemId = serviceItemId;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
}