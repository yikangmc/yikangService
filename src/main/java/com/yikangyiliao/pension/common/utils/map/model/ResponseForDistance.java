package com.yikangyiliao.pension.common.utils.map.model;


/**
 * @author liushuaic
 * @date 2015/10/15 15:50
 * 距离查询后的响应内容
 * 
 * ***/
public class ResponseForDistance {

	private String status;
	
	private String info;
	
	private Distance[] results;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Distance[] getResults() {
		return results;
	}

	public void setResults(Distance[] results) {
		this.results = results;
	}
	
	
	
}

class Distance{
	private int origin_id;
	private int dest_id;
	private long distance;
	private long duration;
	private String info;
	
	
	
	public int getOrigin_id() {
		return origin_id;
	}
	public void setOrigin_id(int origin_id) {
		this.origin_id = origin_id;
	}
	public int getDest_id() {
		return dest_id;
	}
	public void setDest_id(int dest_id) {
		this.dest_id = dest_id;
	}
	public long getDistance() {
		return distance;
	}
	public void setDistance(long distance) {
		this.distance = distance;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
