package com.yikangyiliao.pension.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question {
    private Long questionId;

    private String title;

    private String content;

    private Long createUserId;

    private Date createTime;

    private Byte isDelete;
    
    private Integer star;

    private Date updateTime;
    
    //用户名称
    private String userName;
    //头像地址
    private String photoUrl;
    
    //回复数量
    private Integer answerNum;
    
    //标签列表
    private List<Taglib> taglibs;
    
    //问题列表
    private List<QuestionAnswer> questionAnswers= new ArrayList<QuestionAnswer>();
    
    //问题图片列表
    private List<QuestionImage> questionImages= new ArrayList<QuestionImage>();

    
    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

	public Integer getAnswerNum() {
		return answerNum;
	}

	public void setAnswerNum(Integer answerNum) {
		this.answerNum = answerNum;
	}

	public List<Taglib> getTaglibs() {
		return taglibs;
	}

	public void setTaglibs(List<Taglib> taglibs) {
		this.taglibs = taglibs;
	}

	public List<QuestionAnswer> getQuestionAnswers() {
		return questionAnswers;
	}

	//TODO 修改设计回复数量方式
	public void setQuestionAnswers(List<QuestionAnswer> questionAnswers) {
		this.answerNum=questionAnswers.size();
		this.questionAnswers = questionAnswers;
	}

	public List<QuestionImage> getQuestionImages() {
		return questionImages;
	}

	public void setQuestionImages(List<QuestionImage> questionImages) {
		this.questionImages = questionImages;
	}
}