package com.yikangyiliao.pension.entity;

import java.util.Date;

public class QuestionAnswer {
    private Long questionAnswerId;

    private Long createUserId;

    private Byte dataSource;

    private String content;

    private Long questionId;

    private Integer starNum;

    private Byte isRecommend;
    
    private Date createTime;

    private Date updateTime;
    
    // under 是展示用
    
    private Integer isStar=0;

    private String userName;
    
    private String photoUrl;
    
    private Integer userPosition;
    
    private Question question;
    
    private String detailContent;
    
    private String htmlDetailContent;
    
    /**
     * TODO 答案分享未设计
     * **/
    private String shareUrl="";
    
    public Long getQuestionAnswerId() {
        return questionAnswerId;
    }

    public void setQuestionAnswerId(Long questionAnswerId) {
        this.questionAnswerId = questionAnswerId;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Byte getDataSource() {
        return dataSource;
    }

    public void setDataSource(Byte dataSource) {
        this.dataSource = dataSource;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Integer getStarNum() {
        return starNum;
    }

    public void setStarNum(Integer starNum) {
        this.starNum = starNum;
    }

    public Byte getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Byte isRecommend) {
        this.isRecommend = isRecommend;
    }

	public Integer getIsStar() {
		return isStar;
	}

	public void setIsStar(Integer isStar) {
		this.isStar = isStar;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getDetailContent() {
		return detailContent;
	}

	public void setDetailContent(String detailContent) {
		this.detailContent = detailContent;
	}

	public String getHtmlDetailContent() {
		return htmlDetailContent;
	}

	public void setHtmlDetailContent(String htmlDetailContent) {
		this.htmlDetailContent = htmlDetailContent;
	}

	public Integer getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(Integer userPosition) {
		this.userPosition = userPosition;
	}

	public String getShareUrl() {
		return shareUrl;
	}

	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}

}