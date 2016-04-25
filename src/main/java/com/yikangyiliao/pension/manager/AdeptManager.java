package com.yikangyiliao.pension.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.AdeptDao;
import com.yikangyiliao.pension.entity.Adept;

@Component
public class AdeptManager {

	@Autowired
	private AdeptDao adeptDao;
	
	
	
	public List<Adept> getAdeptsForDoctor(){
		return null;
	}
	
	
	
    /**
     * @author liushuaic
     * @date 2016-03-16 17:32
     * @desc 获取擅长列表
     * ***/
	public List<Adept> getAdeptsByType(Long type){
		return adeptDao.getAdeptsByType(type);
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-03-24 15:08
	 * @desc 获取我的擅长列表
	 * */
	public List<Adept> getAdeptsByTypeAndUserId(Long type,Long userId){
		Map<String,Object> paramData=new HashMap<String,Object>();
		paramData.put("type", type);
		paramData.put("userId", userId);
		return adeptDao.getAdeptsByTypeAndUserId(paramData);
	}
	
	
}
