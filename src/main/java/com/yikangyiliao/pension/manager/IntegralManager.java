package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.IntegralDao;
import com.yikangyiliao.pension.dao.JobDao;
import com.yikangyiliao.pension.entity.Integral;
import com.yikangyiliao.pension.entity.Job;

/**
 * @author liushuaic
 * @date 2016-08-19 16:54
 * @desc 积分管理类
 */
@Component
public class IntegralManager {

	@Autowired
	private IntegralDao integralDao;
	
	@Autowired
	private JobDao jobDao;

	/**
	 * @author liushuaic
	 * @date 2016-08-19 16:47
	 * @desc 获取我所有的积分
	 */
	public Long getMytotalScore(Long userId) {
		return integralDao.getMytotalScore(userId);
	}

	/**
	 * @author liushuaic
	 * @date 2016-08-19 16:48
	 * @desc 获取的扣除的积分
	 */
	public Long getDeductScore(Long userId) {
		return integralDao.getDeductScore(userId);
	}

	/**
	 * @author liushuaic
	 * @date 2016-08-20 14:41
	 * @desc 获取某一个积分的领取状态
	 */
	public Integer getIntegralJobstateByIntegralId(Long integralId) {
		return integralDao.getIntegralJobstateByIntegralId(integralId);
	}
	
	/**
     * @author liushuaic
     * @date 2016-08-20 16:47
     * @desc 修改积分的领取状态
     * */
    public Integer udpateIntegralJobStateIsRecived(Long integralId){
    	return integralDao.udpateIntegralJobStateIsRecived(integralId);
    }
    
    /**
     * @author liushuaic
     * @date 2016-08-22 16:21
     * @desc 添加积分记录
     * @param jobsId 任务id
     * @param Byte jobState 0:未完成 1：已完成，带领取 2：已领取 
     * @param Long ownerUserId  用户id
     * @param Integer score 分数
     * @param Byte integralType 0:兑换积分 1:加积分 
     * @param Byte jobGroup 1:一次性任任务 2：日常任务
     * */
    public Integer insertIntegral(Long jobsId,Byte jobState,Long ownerUserId,Integer score,Byte integralType,Byte jobGroup){
    	
    	Date currentDate=Calendar.getInstance().getTime();
    	
    	Integral integral=new Integral();
    	integral.setJobsId(jobsId);
    	integral.setJobState(jobState);
    	integral.setOwnerUserId(ownerUserId);
    	integral.setScore(score);
    	integral.setIntegralType(integralType);
    	integral.setJobGroup(jobGroup);
    	integral.setCreateDatetime(currentDate);
    	integral.setUpdateDatetime(currentDate);
    	return integralDao.insertSelective(integral);
    }
    
    
    /**
     * @author liushuaic
     * @date 2016-08-22 16:39
     * @desc 添加积分信息  加积分
     * @param jobUniqueCode  任务唯一编号 
     * @param ownerUserId  用户id
     * 
     * @return if return 0 已经做了一次性任务
     *         if return >0  添加成功
     * */
    public Integer insertIntegralAddScoreIsONCEJob(String jobUniqueCode,Long ownerUserId){
    	Map<String,Object> paramMap=new HashMap<String,Object>();
    	paramMap.put("jobUniqueCode", jobUniqueCode);
    	paramMap.put("userId", ownerUserId);
        List<Integral>	integrals=integralDao.getIntegralByJobUniqueCodeAndUserId(paramMap);
    	if(null == integrals  || integrals.size()==0){
        	Job job=jobDao.selectJobByJobUniqueCode(jobUniqueCode);
        	Date currentDate=Calendar.getInstance().getTime();
        	Byte isAutoDistribution=job.getIsAutoDistribution();
        	Integral integral=new Integral();
        	integral.setJobsId(job.getJobId());
        	Byte jobState=new Byte("1");
        	if(null != isAutoDistribution){
        		if(isAutoDistribution.equals(new Byte("0"))){
        			integral.setJobState(jobState);
        		}else if(isAutoDistribution.equals(new Byte("1"))){
        			jobState=new Byte("2");
        			integral.setJobState(jobState);
        		}
        	}else{
        		integral.setJobState(jobState);
        	}
        	integral.setOwnerUserId(ownerUserId);
        	integral.setJobGroup(new Byte("1"));
        	integral.setScore(job.getScore());
        	integral.setIntegralType(new Byte("1"));
        	integral.setCreateDatetime(currentDate);
        	integral.setUpdateDatetime(currentDate);
        	return integralDao.insertSelective(integral);
    	}
    	return 0;
    	
    }
    
    /**
     * @author liushuaic
     * @date 2016-08-22 18:53
     * @desc 添加日常任务积分
     * @param jobUniqueCode  任务唯一编号 
     * @param jobSate 0:未完成 1：已完成，带领取 2：已领取 
     * @param ownerUserId  用户id
     * */
    public Integer insertIntegralAddScoreIsUsualJob(String jobUniqueCode,Byte jobState,Long ownerUserId){
    	Job job=jobDao.selectJobByJobUniqueCode(jobUniqueCode);
    	Date currentDate=Calendar.getInstance().getTime();
    	
    	Integral integral=new Integral();
    	integral.setJobsId(job.getJobId());
    	integral.setJobState(jobState);
    	integral.setOwnerUserId(ownerUserId);
    	integral.setJobGroup(new Byte("2"));
    	integral.setScore(job.getScore());
    	integral.setIntegralType(new Byte("1"));
    	integral.setCreateDatetime(currentDate);
    	integral.setUpdateDatetime(currentDate);
    	return integralDao.insertSelective(integral);
    }
    
    
}
