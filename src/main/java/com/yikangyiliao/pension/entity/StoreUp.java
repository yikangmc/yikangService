package com.yikangyiliao.pension.entity;

public class StoreUp {
    private Long storeUpsId;

    private Long forumPostId;

    private Long createUserId;

    private Byte group;

    public Long getStoreUpsId() {
        return storeUpsId;
    }

    public void setStoreUpsId(Long storeUpsId) {
        this.storeUpsId = storeUpsId;
    }

    public Long getForumPostId() {
        return forumPostId;
    }

    public void setForumPostId(Long forumPostId) {
        this.forumPostId = forumPostId;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Byte getGroup() {
        return group;
    }

    public void setGroup(Byte group) {
        this.group = group;
    }
}