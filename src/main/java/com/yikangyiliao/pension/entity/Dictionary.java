package com.yikangyiliao.pension.entity;

public class Dictionary {
    private Long dictionaryId;

    private String dicName;

    private String dicGroup;

    private String dicCode;

    private Byte dicOrder;

    private Long createTime;

    private Long updateTime;

    public Long getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(Long dictionaryId) {
        this.dictionaryId = dictionaryId;
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName == null ? null : dicName.trim();
    }

    public String getDicGroup() {
        return dicGroup;
    }

    public void setDicGroup(String dicGroup) {
        this.dicGroup = dicGroup == null ? null : dicGroup.trim();
    }

    public String getDicCode() {
        return dicCode;
    }

    public void setDicCode(String dicCode) {
        this.dicCode = dicCode == null ? null : dicCode.trim();
    }

    public Byte getDicOrder() {
        return dicOrder;
    }

    public void setDicOrder(Byte dicOrder) {
        this.dicOrder = dicOrder;
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
}