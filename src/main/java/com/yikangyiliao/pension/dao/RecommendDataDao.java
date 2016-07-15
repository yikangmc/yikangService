package com.yikangyiliao.pension.dao;

import java.util.List;

import com.yikangyiliao.pension.entity.RecommendData;
import com.yikangyiliao.pension.entity.Taglib;
import com.yikangyiliao.pension.entity.UserServiceInfo;

public interface RecommendDataDao{
    int deleteByPrimaryKey(Long recommendDataId);

    int insert(RecommendData record);

    int insertSelective(RecommendData record);

    RecommendData selectByPrimaryKey(Long recommendDataId);

    int updateByPrimaryKeySelective(RecommendData record);

    int updateByPrimaryKey(RecommendData record);
    
    /**
     * 根据推荐用户的id查询被推荐人的信息
     * @param userId
     * @return
     */
    public List<UserServiceInfo> queryRecommendUserInfo();
    
    /**
     * 查询推荐的标签信息
     * @return
     */
    public List<Taglib> queryRecommendTaglibsInfo();
}