package com.yikangyiliao.pension.entity;

import java.util.Date;
import java.util.List;

public class Taglib {
    private Long taglibId;

    private String tagName;

    private String tagPic;

    private Long parentId;

    private Byte orders;

    private String isDelete;

    private Date createTime;

    private Date updateTime;

    private Long createUserId;

    private Byte isRecommend;

    private Integer followNumber;

    private Integer fornumPostsNumber;

    private Integer answerNumber;
    
    private Integer isStore;

    private List<Taglib> childs;
    
    //活动列表
    private List<FormPosts> formPosts;
    
    //是否已经关注 0未关注，1已经关注
    private Integer isFollow=0;
    
    public Long getTaglibId() {
        return taglibId;
    }

    public void setTaglibId(Long taglibId) {
        this.taglibId = taglibId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    public String getTagPic() {
        return tagPic;
    }

    public void setTagPic(String tagPic) {
        this.tagPic = tagPic == null ? null : tagPic.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Byte getOrders() {
        return orders;
    }

    public void setOrders(Byte orders) {
        this.orders = orders;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }


    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Byte getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Byte isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Integer getFollowNumber() {
        return followNumber;
    }

    public void setFollowNumber(Integer followNumber) {
        this.followNumber = followNumber;
    }

    public Integer getFornumPostsNumber() {
        return fornumPostsNumber;
    }

    public void setFornumPostsNumber(Integer fornumPostsNumber) {
        this.fornumPostsNumber = fornumPostsNumber;
    }

    public Integer getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(Integer answerNumber) {
        this.answerNumber = answerNumber;
    }

	public List<Taglib> getChilds() {
		return childs;
	}

	public void setChilds(List<Taglib> childs) {
		this.childs = childs;
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

	public List<FormPosts> getFormPosts() {
		return formPosts;
	}

	public void setFormPosts(List<FormPosts> formPosts) {
		this.formPosts = formPosts;
	}

	public Integer getIsFollow() {
		return isFollow;
	}

	public void setIsFollow(Integer isFollow) {
		this.isFollow = isFollow;
	}

	public Integer getIsStore() {
		return isStore;
	}

	public void setIsStore(Integer isStore) {
		this.isStore = isStore;
	}
}