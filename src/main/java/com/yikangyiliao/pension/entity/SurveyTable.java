package com.yikangyiliao.pension.entity;


public class SurveyTable {
    private Long surveyTableId;

    private String tableName;

    private Integer tableType;

    private Byte isDelete;

    private Long createTime;

    private Long updateTime;

    private String sureveyTalbeNumber;
    

    public Long getSurveyTableId() {
        return surveyTableId;
    }

    public void setSurveyTableId(Long surveyTableId) {
        this.surveyTableId = surveyTableId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public Integer getTableType() {
        return tableType;
    }

    public void setTableType(Integer tableType) {
        this.tableType = tableType;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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

    public String getSureveyTalbeNumber() {
        return sureveyTalbeNumber;
    }

    public void setSureveyTalbeNumber(String sureveyTalbeNumber) {
        this.sureveyTalbeNumber = sureveyTalbeNumber == null ? null : sureveyTalbeNumber.trim();
    }
}