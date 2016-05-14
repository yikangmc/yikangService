package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.ActivetyDao;
import com.yikangyiliao.pension.entity.Activety;

@Component
public class ActivetyManager {
	
	@Autowired
	private ActivetyDao activetyDao;
	
	
    /**
     * @author liushuaic
     * @date 2016-05-13 10:19
     * @desc 获取所有活动
     * **/
	public List<Activety> getActivetys(){
		return activetyDao.getActivetys();
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-05-13 16:08
	 * @desc 获取活动详情
	 * **/
	public Activety getActivetysDetailById(Long activetyId){
		return activetyDao.getActivetysDetailById(activetyId);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-13 18:15
	 * @desc 添加活动
	 * **/
	public int insertActivety(
			String title,String content,Date startTime,Date endTime,
			Double lng,Double lat,Integer personNumber,Double cost,
			Long[] taglibIds,
			String detailAddress){
		
		Date currentDate=Calendar.getInstance().getTime();
		
		Activety activety=new Activety();
		
		activety.setCheckStatus(Byte.valueOf("0"));
		activety.setTitle(title);
		activety.setContent(content);
		activety.setCost(cost);
		activety.setDetailAddress(detailAddress);
		activety.setUpdateTime(currentDate);
		activety.setCreateTime(currentDate);
		activety.setPersonNumber("0");
		activety.setStartTime(startTime);
		activety.setEndTime(endTime);
		
		activetyDao.insertSelective(activety);
		return 0;
	}

}
