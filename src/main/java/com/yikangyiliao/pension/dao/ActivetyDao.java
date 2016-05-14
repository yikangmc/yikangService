package com.yikangyiliao.pension.dao;

import java.util.List;

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
    List<Activety> getActivetys();
    
    /**
     * @author liushuaic
     * @date 2016-05-13 16:06
     * */
    Activety getActivetysDetailById(Long activetyId);
}