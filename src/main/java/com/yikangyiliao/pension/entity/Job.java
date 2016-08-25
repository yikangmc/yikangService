package com.yikangyiliao.pension.entity;

import java.util.Date; 

public class Job {
    private Long jobId;

    private String jobTitle;

    private Date createDatetime;

    private Date updateDatetime;

    private String jobContent;

    private Long createUserId;

    private Integer score;

    private Byte jobType;

    private Byte ofUserPosition;

    private Byte isAutoDistribution;

    private String jobUniqueCode;
    
    private int jobState;

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle == null ? null : jobTitle.trim();
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getJobContent() {
        return jobContent;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent == null ? null : jobContent.trim();
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Byte getJobType() {
        return jobType;
    }

    public void setJobType(Byte jobType) {
        this.jobType = jobType;
    }

    public Byte getOfUserPosition() {
        return ofUserPosition;
    }

    public void setOfUserPosition(Byte ofUserPosition) {
        this.ofUserPosition = ofUserPosition;
    }

    public Byte getIsAutoDistribution() {
        return isAutoDistribution;
    }

    public void setIsAutoDistribution(Byte isAutoDistribution) {
        this.isAutoDistribution = isAutoDistribution;
    }

    public String getJobUniqueCode() {
        return jobUniqueCode;
    }

    public void setJobUniqueCode(String jobUniqueCode) {
        this.jobUniqueCode = jobUniqueCode == null ? null : jobUniqueCode.trim();
    }

	public int getJobState() {
		return jobState;
	}

	public void setJobState(int jobState) {
		this.jobState = jobState;
	}
}