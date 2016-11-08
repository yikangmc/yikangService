package com.yikangyiliao.pension.entity;

import java.util.Date;

public class ForumPostTxtEditor {
    private Long forumPostTxtEditorId;

    private String uniqueCode;

    private Long ownUserId;

    private Date createDateTime;

    private Date updateDateTime;

    private Byte isDelete;

    private Byte editorType;

    private Long dataId;

    public Long getForumPostTxtEditorId() {
        return forumPostTxtEditorId;
    }

    public void setForumPostTxtEditorId(Long forumPostTxtEditorId) {
        this.forumPostTxtEditorId = forumPostTxtEditorId;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode == null ? null : uniqueCode.trim();
    }

    public Long getOwnUserId() {
        return ownUserId;
    }

    public void setOwnUserId(Long ownUserId) {
        this.ownUserId = ownUserId;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Byte getEditorType() {
        return editorType;
    }

    public void setEditorType(Byte editorType) {
        this.editorType = editorType;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }
}