package com.yikangyiliao.pension.manager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.AreaDao;
import com.yikangyiliao.pension.entity.Area;


/**
 * @author liushuaic
 * @date 2015/08/27 14:42
 * */
@Component
public class AreaManager {
	
	@Autowired
	private AreaDao areaDao;
	
	public int insertSelective(Area area){
		return areaDao.insertSelective(area);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/27 15:52
	 * @desc 查询城市列表
	 * */
	public Map<String,Object> getAreaCityDistrict(){
		return areaDao.getAreaCityDistrict();
	}

}
