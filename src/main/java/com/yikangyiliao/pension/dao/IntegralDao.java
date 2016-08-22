package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.Integral;

public interface IntegralDao {
    int deleteByPrimaryKey(Long integralId);

    int insert(Integral record);

    int insertSelective(Integral record);

    Integral selectByPrimaryKey(Long integralId);

    int updateByPrimaryKeySelective(Integral record);

    int updateByPrimaryKey(Integral record);

    
    /**
     * @author liushuaic
     * @date 2016-08-19 16:47
     * @desc 获取我所有的积分
     * */
    Long getMytotalScore(Long userId);
     
    /**
     * @author liushuaic
     * @date 2016-08-19 16:48
     * @desc 获取的扣除的积分
     * */
    Long getDeductScore(Long userId);
    
    
    /**
     * @author liushuaic
     * @date 2016-08-20 14:30
     * @desc 获取某一个积分的领取状态
     * */
    Integer getIntegralJobstateByIntegralId(Long integralId);
    
    /**
     * 
     * @author liushuaic
     * @date 2016-08-20 16:47
     * @desc 修改积分的领取状态
     * 
     * */
    Integer udpateIntegralJobStateIsRecived(Long integralId);
}