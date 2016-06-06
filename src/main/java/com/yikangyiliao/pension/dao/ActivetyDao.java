package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.Activety;

public interface ActivetyDao {
    int deleteByPrimaryKey(Long activetyId);

    int insert(Activety record);

    int insertSelective(Activety record);

    Activety selectByPrimaryKey(Long activetyId);

    int updateByPrimaryKeySelective(Activety record);

    int updateByPrimaryKey(Activety record);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-13 10:19
     * @desc 获取所有活动
     * **/
    List<Activety> getActivetys(Long userId);
    
    /**
     * @author liushuaic
     * @date 2016-05-13 16:06
     * @desc 查询某一个活动的详情
     * 
     * @param activetyId
     * @param userId
     * */
    Activety getActivetysDetailById(Map<String,Object> paramMap);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-23 10:51
     * @desc 获取某一个用户所有发布的活动
     * 
     * **/
    List<Activety> selectActivetyByUserId(Long userId);
    
    
    /**
     * @author liushuaic
     * @date 2016-06-04 17:17
     * @desc 获取某一个用户的参与的某一个活动的信息
     * **/
    Activety getActivetyByUserIdAndActivetyId(Map<String,Object> paramMap);
}