package com.yikangyiliao.pension.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.LocationDao;
import com.yikangyiliao.pension.entity.Location;

@Component
public class LocationManager {

	@Autowired
	private LocationDao locationDao;
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/19 10:52
	 * @desc 查询某一个城市
	 * **/
	public Location selectByPrimaryKey(Long locationId){
		return locationDao.selectByPrimaryKey(locationId);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/19 12:03
	 * 获取市，根据县编码
	 * 
	 * */
	public Location getCityByDistrictCode(String administrativeCode){
		return locationDao.getCityByDistrictCode(administrativeCode);
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/19 12:03
	 * 获取省，根据市编码
	 * 
	 * **/
	public Location getProvenceByCityCode(String administrativeCode){
		return locationDao.getProvenceByCityCode(administrativeCode);
	}
	
	
	
	/**
	 *@author liushuaic
	 *@date 2015/10/19 15:26
	 *获取城市，by adminstrativeCode
	 * **/
	public Location getLocationByAdministrativeCode(String administrativeCode){
		return locationDao.getLocationByAdministrativeCode(administrativeCode);
	}
	
}
