package com.yikangyiliao.pension.entity;

import java.util.Date;

public class QuestionAnswersComment {
    private Long questionAnswersCommentId;

    private Long questionAnswerId;

    private Long createUserId;

    private Long toUserId;

    private String content;

    private Byte answerTo;

    private Date createTime;
    
    private String toUserName;
    
    private String designationName;
   
    private String photol;
    
    private String userName;
    
    private String userPosition;

    public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getPhotol() {
		return photol;
	}

	public void setPhotol(String photol) {
		this.photol = photol;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public Long getQuestionAnswersCommentId() {
        return questionAnswersCommentId;
    }

    public void setQuestionAnswersCommentId(Long questionAnswersCommentId) {
        this.questionAnswersCommentId = questionAnswersCommentId;
    }

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

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Byte getAnswerTo() {
        return answerTo;
    }

    public void setAnswerTo(Byte answerTo) {
        this.answerTo = answerTo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}