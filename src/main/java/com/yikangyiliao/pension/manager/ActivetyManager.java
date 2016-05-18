package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.ActivetyDao;
import com.yikangyiliao.pension.dao.ActivetyTaglibMapDao;
import com.yikangyiliao.pension.entity.Activety;
import com.yikangyiliao.pension.entity.ActivetyTaglibMap;

@Component
public class ActivetyManager {
	
	@Autowired
	private ActivetyDao activetyDao;
	
	@Autowired
	private ActivetyTaglibMapDao activetyTaglibMapDao;
	
	
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
			String title,String content,Date startTime,Date endTime,Date entryStartTime,Date entryEndTime,
			Double lng,Double lat,Integer personNumber,Double cost,
			Long[] taglibIds,String mapPositionAddress,
			String detailAddress,String districtCode,Long createUserId,Byte activeyMode,
			String recommendPicUrl){
		
		Date currentDate=Calendar.getInstance().getTime();
		
		Activety activety=new Activety();
		
		// 活动审核状态
		activety.setCheckStatus(Byte.valueOf("0"));
		activety.setTitle(title);
		activety.setContent(content);
		//费用
		activety.setCost(cost);
		activety.setDetailAddress(detailAddress);
		activety.setMapPsitionAddress(mapPositionAddress);
		activety.setUpdateTime(currentDate);
		activety.setCreateTime(currentDate);
		activety.setPersonNumber(personNumber);
		activety.setStartTime(startTime);
		activety.setEndTime(endTime);
		activety.setCreateUserId(createUserId);
		activety.setEntryStartTime(entryStartTime);
		activety.setEntryEndTime(entryEndTime);
		activety.setActivetyMode(activeyMode);
		//活动图片
		activety.setRecommendPicUrl(recommendPicUrl);
		
		activetyDao.insertSelective(activety);
		for(Long taglibId:taglibIds){
			ActivetyTaglibMap activetyTaglibMap=new ActivetyTaglibMap();
			activetyTaglibMap.setActivetyId(activety.getActivetyId());;
			activetyTaglibMap.setTagLibId(taglibId);
			activetyTaglibMap.setCreateTime(currentDate);
			activetyTaglibMap.setUpdateTime(currentDate);
			activetyTaglibMapDao.insertSelective(activetyTaglibMap);
		}
		
		
		return 1;
	}

}
