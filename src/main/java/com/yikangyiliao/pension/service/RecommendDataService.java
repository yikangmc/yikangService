package com.yikangyiliao.pension.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.Taglib;
import com.yikangyiliao.pension.entity.UserServiceInfo;
import com.yikangyiliao.pension.manager.RecommendDataManager;

@Service("recommendDataService")
public class RecommendDataService {
	@Autowired
	private RecommendDataManager recommendDataManager;
	
	/**
	 * 查询推荐人的相关信息
	 * @param paramMap
	 * @return
	 */
	public ResponseMessage<List<UserServiceInfo>> queryRecommedUserInfo(Map<String,Object> paramMap){
		ResponseMessage<List<UserServiceInfo>> info = new ResponseMessage<List<UserServiceInfo>>();
		List<UserServiceInfo> userInfos = recommendDataManager.queryRecommendUserInfo();
		info.setData(userInfos);
		return info;
	}
	
	/**
	 * 查询热门标签
	 * @param paramMap
	 * @return
	 */
	public ResponseMessage<List<Taglib>> queryRecommendTaglibsInfo(Map<String,Object> paramMap){
		ResponseMessage<List<Taglib>> taglibs = new ResponseMessage<List<Taglib>>();
		List<Taglib> taglibsInfo = recommendDataManager.queryRecommendTaglibsInfo();
		taglibs.setData(taglibsInfo);
		return taglibs;
	}
}
