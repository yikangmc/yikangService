package com.yikangyiliao.pension.dao;

import java.util.Map;

import com.yikangyiliao.pension.entity.UserTaglibMap;

public interface UserTaglibMapDao {
    int deleteByPrimaryKey(Long userTaglibMapsId);

    int insert(UserTaglibMap record);

    int insertSelective(UserTaglibMap record);

    UserTaglibMap selectByPrimaryKey(Long userTaglibMapsId);

    int updateByPrimaryKeySelective(UserTaglibMap record);

    int updateByPrimaryKey(UserTaglibMap record);
    
    
    /**
     * @author liushuaic
     * @date 2016-06-06 21:19
     * @desc 删除我关注的标签
     * @param userId
     * @param taglibId
     * */
    int deleteUserTaglibMapByUserIdTaglibId(Map<String,Object> paramMap);
    
    /**
     * @author liushuaic
     * @date 2016-06-06 21:20
     * @desc 查询我关注的某一个标签
     * @param userId
     * @param taglibId
     * **/
    UserTaglibMap selectUserTaglibMapByUserIdTaglibId(Map<String,Object> paramMap);
}