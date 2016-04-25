package com.yikangyiliao.pension.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.SeniorLivingConditionDao;
import com.yikangyiliao.pension.entity.SeniorLivingCondition;

@Component
public class SeniorLivinConditionManager {

	@Autowired
	private SeniorLivingConditionDao seniorLivingConditionDao;
	
	
	/**
	 * @author liushuaic
	 * @date 2015/11/16 18:12
	 * @desc 添加居住信息
	 * */
	public int insertSelective(SeniorLivingCondition record){
		return seniorLivingConditionDao.insertSelective(record);
	}
	
}
