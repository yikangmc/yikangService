package com.yikangyiliao.pension.dao;

import java.util.List;

import com.yikangyiliao.pension.entity.Job;

public interface JobDao {
    int deleteByPrimaryKey(Long jobId);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(Long jobId);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);
    
    
    /**
     * @author liushuaic
     * @date 2016-08-19 13:41
     * @desc 获取日常任务
     * */
    List<Job> getUsualJob(Long userId);
    
    /**
     * @author liushuaic
     * @date 2016-08-19 13:52
     * @desc 获取一次执行的任务
     * */
    List<Job> getONCEJob(Long userId);
    
    
}