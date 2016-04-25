package com.yikangyiliao.pension.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yikangyiliao.pension.entity.Assessment;

public interface AssessmentDao {
    int deleteByPrimaryKey(Long assessmentId);

    int insert(Assessment record);

    int insertSelective(Assessment record);

    Assessment selectByPrimaryKey(Long assessmentId);

    int updateByPrimaryKeySelective(Assessment record);

    int updateByPrimaryKey(Assessment record);
    
    
    /**
     * @author liushuaic
     * @date 2015/08/13 12:37 
     * 获取某一个患者的所有的病例夹
     * */
    List<Assessment> getAssessmentBySeniorId(@Param("seniorId") Long seniorId);
}