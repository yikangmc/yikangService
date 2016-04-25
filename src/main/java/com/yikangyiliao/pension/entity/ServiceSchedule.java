package com.yikangyiliao.pension.entity;

import java.util.Date;

public class ServiceSchedule {
    private Long serviceScheduleId;

    private Long serviceUserId;

    private Date serviceDate;

    private Long createTime;

    private Long updateTime;

    private Long createUserId;

    private Byte isCanSelected;

    private Integer serviceYear;

    private Integer serviceMonth;

    private Integer servcieDay;
    
    private String serviceDateStr;

    public Long getServiceScheduleId() {
        return serviceScheduleId;
    }

    public void setServiceScheduleId(Long serviceScheduleId) {
        this.serviceScheduleId = serviceScheduleId;
    }

    public Long getServiceUserId() {
        return serviceUserId;
    }

    public void setServiceUserId(Long serviceUserId) {
        this.serviceUserId = serviceUserId;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
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

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Byte getIsCanSelected() {
        return isCanSelected;
    }

    public void setIsCanSelected(Byte isCanSelected) {
        this.isCanSelected = isCanSelected;
    }

    public Integer getServiceYear() {
        return serviceYear;
    }

    public void setServiceYear(Integer serviceYear) {
        this.serviceYear = serviceYear;
    }

    public Integer getServiceMonth() {
        return serviceMonth;
    }

    public void setServiceMonth(Integer serviceMonth) {
        this.serviceMonth = serviceMonth;
    }

    public Integer getServcieDay() {
        return servcieDay;
    }

    public void setServcieDay(Integer servcieDay) {
        this.servcieDay = servcieDay;
    }

	public String getServiceDateStr() {
		return serviceDateStr;
	}

	public void setServiceDateStr(String serviceDateStr) {
		this.serviceDateStr = serviceDateStr;
	}
}