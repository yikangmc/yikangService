package com.yikangyiliao.pension.entity;

public class SeniorAccount {
    private Long seniorId;

    private String name;

    private Byte sex;

    private Long birthday;

    private Integer birthYear;

    private String cardNumber;

    private Byte cardType;

    private String socialSecurity;

    private Boolean race;

    private Byte faith;

    private Byte livingConditions;

    private Byte paymentType;

    private Byte incomeSources;

    private String phoneNo;

    private String profession;

    private Long createTime;

    private Long updateTime;

    private Long createUserId;

    public Long getSeniorId() {
        return seniorId;
    }

    public void setSeniorId(Long seniorId) {
        this.seniorId = seniorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    public Byte getCardType() {
        return cardType;
    }

    public void setCardType(Byte cardType) {
        this.cardType = cardType;
    }

    public String getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(String socialSecurity) {
        this.socialSecurity = socialSecurity == null ? null : socialSecurity.trim();
    }

    public Boolean getRace() {
        return race;
    }

    public void setRace(Boolean race) {
        this.race = race;
    }

    public Byte getFaith() {
        return faith;
    }

    public void setFaith(Byte faith) {
        this.faith = faith;
    }

    public Byte getLivingConditions() {
        return livingConditions;
    }

    public void setLivingConditions(Byte livingConditions) {
        this.livingConditions = livingConditions;
    }

    public Byte getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Byte paymentType) {
        this.paymentType = paymentType;
    }

    public Byte getIncomeSources() {
        return incomeSources;
    }

    public void setIncomeSources(Byte incomeSources) {
        this.incomeSources = incomeSources;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
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
}