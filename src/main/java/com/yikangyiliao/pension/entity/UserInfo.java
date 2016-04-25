package com.yikangyiliao.pension.entity;

public class UserInfo {
    private Long userInfoId;

    private String userName;

    private Byte userSex;

    private String provenceCode;

    private String cityCode;

    private String districtCode;

    private String address;

    private Long createAt;

    private Long updateAt;

    private Long userId;

    private Long isDelete;

    private String userInfosCol;

    public Long getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Long userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Byte getUserSex() {
        return userSex;
    }

    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    public String getProvenceCode() {
        return provenceCode;
    }

    public void setProvenceCode(String provenceCode) {
        this.provenceCode = provenceCode == null ? null : provenceCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode == null ? null : districtCode.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Long isDelete) {
        this.isDelete = isDelete;
    }

    public String getUserInfosCol() {
        return userInfosCol;
    }

    public void setUserInfosCol(String userInfosCol) {
        this.userInfosCol = userInfosCol == null ? null : userInfosCol.trim();
    }
}