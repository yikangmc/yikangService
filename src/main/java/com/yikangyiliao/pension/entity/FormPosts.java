package com.yikangyiliao.pension.entity;

import java.util.Date;
import java.util.List;

public class FormPosts {
	
	private String userName;
	
	private String photoUrl;
	
    private Long forumPostId;

    private String title;

    private String content;

    private Byte reportComplaintsStatus;

    private Byte isEssence;

    private Date createTime;

    private Date updateTime;

    private int stars;

    private int shareNum;

    private Long createUserId;

    private String shareUrl;

    private String recommendPicUrl;
    
    private int answersNums;
    
    private int isStar;

    //标签列表
    private List<Taglib> taglibs;
    
    //文章支持列表
    private List<FormPostsStarList> formPostsStarLists;
    
    //回复列表
    private List<ForumPostsAnswer> forumPostsAnswers;
    
    //文章上传的列表
    private List<ForumPostsImage> forumPostsImage;
    
    
    
    public Long getForumPostId() {
        return forumPostId;
    }

    public void setForumPostId(Long forumPostId) {
        this.forumPostId = forumPostId;
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

    public Byte getReportComplaintsStatus() {
        return reportComplaintsStatus;
    }

    public void setReportComplaintsStatus(Byte reportComplaintsStatus) {
        this.reportComplaintsStatus = reportComplaintsStatus;
    }


    public Byte getIsEssence() {
        return isEssence;
    }

    public void setIsEssence(Byte isEssence) {
        this.isEssence = isEssence;
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

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Integer getShareNum() {
        return shareNum;
    }

    public void setShareNum(Integer shareNum) {
        this.shareNum = shareNum;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl == null ? null : shareUrl.trim();
    }

    public String getRecommendPicUrl() {
        return recommendPicUrl;
    }

    public void setRecommendPicUrl(String recommendPicUrl) {
        this.recommendPicUrl = recommendPicUrl == null ? null : recommendPicUrl.trim();
    }

	public List<Taglib> getTaglibs() {
		return taglibs;
	}

	public void setTaglibs(List<Taglib> taglibs) {
		this.taglibs = taglibs;
	}

	

	public List<FormPostsStarList> getFormPostsStarLists() {
		return formPostsStarLists;
	}

	public void setFormPostsStarLists(List<FormPostsStarList> formPostsStarLists) {
		this.formPostsStarLists = formPostsStarLists;
	}

	public List<ForumPostsAnswer> getForumPostsAnswers() {
		return forumPostsAnswers;
	}

	public void setForumPostsAnswers(List<ForumPostsAnswer> forumPostsAnswers) {
		this.forumPostsAnswers = forumPostsAnswers;
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

	public int getIsStar() {
		return isStar;
	}

	public void setIsStar(int isStar) {
		this.isStar = isStar;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public void setShareNum(int shareNum) {
		this.shareNum = shareNum;
	}

	public void setAnswersNums(int answersNums) {
		this.answersNums = answersNums;
	}

	public int getAnswersNums() {
		return answersNums;
	}

	public List<ForumPostsImage> getForumPostsImage() {
		return forumPostsImage;
	}

	public void setForumPostsImage(List<ForumPostsImage> forumPostsImage) {
		this.forumPostsImage = forumPostsImage;
	}

}