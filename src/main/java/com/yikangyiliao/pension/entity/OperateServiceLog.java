package com.yikangyiliao.pension.entity;

public class OperateServiceLog {
    private Long operateServiceLogId;

    private String tableName;

    private Byte operateType;

    private Long createTime;

    private Long updateTime;

    private Long createUserId;

    private String opreateContent;

    public Long getOperateServiceLogId() {
        return operateServiceLogId;
    }

    public void setOperateServiceLogId(Long operateServiceLogId) {
        this.operateServiceLogId = operateServiceLogId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public Byte getOperateType() {
        return operateType;
    }

    public void setOperateType(Byte operateType) {
        this.operateType = operateType;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getOpreateContent() {
        return opreateContent;
    }

    public void setOpreateContent(String opreateContent) {
        this.opreateContent = opreateContent == null ? null : opreateContent.trim();
    }
}