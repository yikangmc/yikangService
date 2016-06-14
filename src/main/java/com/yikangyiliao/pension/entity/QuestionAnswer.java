package com.yikangyiliao.pension.entity;

public class QuestionAnswer {
    private Long questionAnswerId;

    private Long createUserId;

    private Byte dataSource;

    private String content;

    private Long questionId;

    private Integer starNum;

    private Byte isRecommend;
    
    private Integer isStar=0;

    private String userName;
    
    private String photoUrl;
    
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
}