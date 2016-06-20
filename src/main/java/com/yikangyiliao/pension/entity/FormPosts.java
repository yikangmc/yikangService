package com.yikangyiliao.pension.entity;

import java.util.ArrayList;
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

    private Integer stars;

    private Integer shareNum;

    private Long createUserId;

    private String shareUrl;

    private String recommendPicUrl;
    
    private Byte forumPostGroup;
    
    private String forumPostsUuid;
    
    // 下面为展示使用
    private Integer answersNums;
    
    private Integer isStar;
    
    private Integer isStore;

    //标签列表
    private List<Taglib> taglibs=new ArrayList<Taglib>();
    
    //文章支持列表
    private List<FormPostsStarList> formPostsStarLists=new ArrayList<FormPostsStarList>();
    
    //回复列表
    private List<ForumPostsAnswer> forumPostsAnswers=new ArrayList<ForumPostsAnswer>();
    
    //文章上传的列表
    private List<ForumPostsImage> forumPostsImage=new ArrayList<ForumPostsImage>();
    
    
    
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

	//TODO 后面要修改为查询
	public void setForumPostsAnswers(List<ForumPostsAnswer> forumPostsAnswers) {
		this.answersNums=forumPostsAnswers.size();
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


	public List<ForumPostsImage> getForumPostsImage() {
		return forumPostsImage;
	}

	public void setForumPostsImage(List<ForumPostsImage> forumPostsImage) {
		this.forumPostsImage = forumPostsImage;
	}

	public Integer getIsStar() {
		return isStar;
	}

	public void setIsStar(Integer isStar) {
		this.isStar = isStar;
	}

	public void setAnswersNums(Integer answersNums) {
		this.answersNums = answersNums;
	}

	public Integer getAnswersNums() {
		return answersNums;
	}

	public Integer getIsStore() {
		return isStore;
	}

	public void setIsStore(Integer isStore) {
		this.isStore = isStore;
	}

	public Byte getForumPostGroup() {
		return forumPostGroup;
	}

	public void setForumPostGroup(Byte forumPostGroup) {
		this.forumPostGroup = forumPostGroup;
	}

	public String getForumPostsUuid() {
		return forumPostsUuid;
	}

	public void setForumPostsUuid(String forumPostsUuid) {
		this.forumPostsUuid = forumPostsUuid;
	}

}