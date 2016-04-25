package com.yikangyiliao.pension.common.utils;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yikangyiliao.base.utils.DateUtils;
import com.yikangyiliao.pension.dao.GenerateNumberDao;
import com.yikangyiliao.pension.entity.GenerateNumber;



/**
 * @author liushuaic
 * @date 2015/07/31 19:46
 * @desc 生成编号
 * */
@Repository
public class GenreateNumberUtils {
	

	@Autowired
	private GenerateNumberDao generateNumberDao;
	
	/**
	 * @author liushuaic
	 * @date 2015/07/31 19:50
	 * @desc 生成检查袋编号
	 * @param accountString  患者名称
	 * @param scaleName		 评估人名称
	 * ***/
	public String generateAssessmentNumber(String accountString,String scaleName){
		Integer maxNumber=generateNumberDao.selectMaxOrderNumberByGenerateTable("assessments");
		
		if(null == maxNumber){
			maxNumber=0;
		}
		maxNumber=maxNumber+1;
		Long currentDateTime=Calendar.getInstance().getTime().getTime();
		GenerateNumber generateNumber=new GenerateNumber(); 
		
		generateNumber.setCreateTime(currentDateTime);
		generateNumber.setGenerateTable("assessments");
		generateNumber.setOrderNumber(maxNumber.longValue());
		
		generateNumberDao.insert(generateNumber);
		return  accountString+"-"+scaleName+"-"+maxNumber;
	}
	
	public String generateAppointmentOrderNumber(){
		
		Integer maxNumber=generateNumberDao.selectMaxOrderNumberByGenerateTable("appointmentOrders");
		
		if(null == maxNumber){
			maxNumber=0;
		}
		maxNumber=maxNumber+1;
		Long currentDateTime=Calendar.getInstance().getTime().getTime();
		GenerateNumber generateNumber=new GenerateNumber(); 
		
		generateNumber.setCreateTime(currentDateTime);
		generateNumber.setGenerateTable("assessments");
		generateNumber.setOrderNumber(maxNumber.longValue());
		
		generateNumberDao.insert(generateNumber);
		
		
		return  "-"+DateUtils.getFormateCurrenteDateStr()+"-"+maxNumber;
		
	}
	
	
}
