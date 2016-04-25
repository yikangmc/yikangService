package com.yikangyiliao.pension.common.utils.map.model;

import java.util.List;

/**
 * @author liushuaic
 * @date 2015/10/15 16:34
 * @desc 反查地理编码
 * 
 * 设计成泛型
 * 
 * */


public class GeoCodeModel {
	
	//状态码
	private String status;

	//数量
	private int count;
	
	//信息
	private String info;
	
	
	private String infocode;
	
	
	//查询出的codes 集合
	private List<GeoCode> geocodes;
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<GeoCode> getGeocodes() {
		return geocodes;
	}

	public void setGeocodes(List<GeoCode> geocodes) {
		this.geocodes = geocodes;
	}

	public String getInfocode() {
		return infocode;
	}

	public void setInfocode(String infocode) {
		this.infocode = infocode;
	}
	
}





class Neighborhood{
	
	private String[] name;
	
	private String[] type;

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	public String[] getType() {
		return type;
	}

	public void setType(String[] type) {
		this.type = type;
	}
	
	
	
}


class Building{
	
	private String[] name;
	
	private String[] type;

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	public String[] getType() {
		return type;
	}

	public void setType(String[] type) {
		this.type = type;
	}
	
}
