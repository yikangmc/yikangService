package com.yikangyiliao.pension.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.yikangyiliao.pension.dao.JobDao;
import com.yikangyiliao.pension.entity.Job;

@Component
public class JobManager {
	
	
	@Autowired
	private JobDao jobDao;

	
	  
    /**
     * @author liushuaic
     * @date 2016-08-19 13:41
     * @desc 获取日常任务
     * */
   public List<Job> getUsualJob(Long userId){
	   return jobDao.getUsualJob(userId);
   }
   
   
   /**
    * @author liushuaic
    * @date 2016-08-19 13:52
    * @desc 获取一次执行的任务
    * */
  public List<Job> getONCEJob(Long userId){
	  return jobDao.getONCEJob(userId);
   }

  
  
  
  
  
  
  
	
}
