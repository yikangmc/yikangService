package com.yikangyiliao.pension.entity;

public class GenerateNumber {
    private Long gnid;

    private String generateTable;

    private Long createTime;

    private Long orderNumber;

    public Long getGnid() {
        return gnid;
    }

    public void setGnid(Long gnid) {
        this.gnid = gnid;
    }

    public String getGenerateTable() {
        return generateTable;
    }

    public void setGenerateTable(String generateTable) {
        this.generateTable = generateTable == null ? null : generateTable.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }
}