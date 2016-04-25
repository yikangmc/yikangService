package com.yikangyiliao.pension.entity;

public class OrderNumber {
    private Long orderNumberId;

    private String groupType;

    private Long createTime;

    public Long getOrderNumberId() {
        return orderNumberId;
    }

    public void setOrderNumberId(Long orderNumberId) {
        this.orderNumberId = orderNumberId;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType == null ? null : groupType.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}