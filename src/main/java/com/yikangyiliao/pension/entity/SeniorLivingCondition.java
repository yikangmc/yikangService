package com.yikangyiliao.pension.entity;

public class SeniorLivingCondition {
    private Long slcId;

    private Long seniorId;

    private String city;

    private String district;

    private String residentialQuarter;

    private Integer unit;

    private Integer floor;

    private Byte roomOrientation;

    private Boolean outWindow;

    private Byte liveWith;

    private Double longitude;

    private Double latitude;

    public Long getSlcId() {
        return slcId;
    }

    public void setSlcId(Long slcId) {
        this.slcId = slcId;
    }

    public Long getSeniorId() {
        return seniorId;
    }

    public void setSeniorId(Long seniorId) {
        this.seniorId = seniorId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getResidentialQuarter() {
        return residentialQuarter;
    }

    public void setResidentialQuarter(String residentialQuarter) {
        this.residentialQuarter = residentialQuarter == null ? null : residentialQuarter.trim();
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Byte getRoomOrientation() {
        return roomOrientation;
    }

    public void setRoomOrientation(Byte roomOrientation) {
        this.roomOrientation = roomOrientation;
    }

    public Boolean getOutWindow() {
        return outWindow;
    }

    public void setOutWindow(Boolean outWindow) {
        this.outWindow = outWindow;
    }

    public Byte getLiveWith() {
        return liveWith;
    }

    public void setLiveWith(Byte liveWith) {
        this.liveWith = liveWith;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}