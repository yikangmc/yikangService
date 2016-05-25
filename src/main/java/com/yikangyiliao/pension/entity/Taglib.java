package com.yikangyiliao.pension.entity;

import java.util.List;

public class Taglib {
    private Long taglibId;

    private String tagName;

    private String tagPic;

    private Long parentId;

    private Byte orders;

    private String isDelete;

    private String createTime;

    private String updateTime;

    private Long createUserId;

    private Byte isRecommend;

    private Integer followNumber;

    private Integer fornumPostsNumber;

    private Integer answerNumber;

    private List<Taglib> childs;
    
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
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
}