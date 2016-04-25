package com.yikangyiliao.pension.common.utils.map.model;



/**
 * @author liushuaic
 * @date 2015/10/15 19:12
 * @desc 反查询 code 对象
 * 
 * */
public class GeoCode{
	
	private String formatted_address;
	
	private String province;
	
	private String city;
	
	private String citycode;
	
	private String district;
	
	private String[] township;
	
	private String[] street;
	
	private String[] number;
	
	private String adcode;
	
	private String location;
	
	private String level;
	
	private Neighborhood neighborhood;
	
	private Building building;

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String[] getTownship() {
		return township;
	}

	public void setTownship(String[] township) {
		this.township = township;
	}

	public String[] getStreet() {
		return street;
	}

	public void setStreet(String[] street) {
		this.street = street;
	}

	public String[] getNumber() {
		return number;
	}

	public void setNumber(String[] number) {
		this.number = number;
	}

	public String getAdcode() {
		return adcode;
	}

	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Neighborhood getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(Neighborhood neighborhood) {
		this.neighborhood = neighborhood;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}
	
	
}
