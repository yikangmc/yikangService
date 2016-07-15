package com.yikangyiliao.pension.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.RecommendDataDao;
import com.yikangyiliao.pension.entity.Taglib;
import com.yikangyiliao.pension.entity.UserServiceInfo;

@Component
public class RecommendDataManager {
	@Autowired
	private RecommendDataDao recommendDataDao;
	
	/**
	 * 查询被推荐人的信息
	 * @return
	 */
	public List<UserServiceInfo> queryRecommendUserInfo(){
		return recommendDataDao.queryRecommendUserInfo();
	}
	
	/**
     * 查询热门标签
     * @return
     */
    public List<Taglib> queryRecommendTaglibsInfo(){
    	return recommendDataDao.queryRecommendTaglibsInfo();
    }
}
