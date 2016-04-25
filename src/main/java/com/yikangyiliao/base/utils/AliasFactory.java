package com.yikangyiliao.base.utils;

import com.yikangyiliao.pension.entity.User;
import com.yikangyiliao.pension.entity.UserInfo;


/**
 * @author liushuaic
 * @date 2015/09/7 11:59
 * @desc 生成 alias
 * 用于在信息推送时生成的别名
 * 
 *加redis 缓存后，把alias 存入到redis 中，每次生成后，存入redis中，
 *如果redis 中存在就不在生成 
 *1.redis down 机问题
 *
 *
 *
 * 
 * ***/
public class AliasFactory {

	
	private static String aliasPrefix="message_info_";
	
	/**
	 * @author liushuaic
	 * @date 2015/09/07 12:17
	 * @desc 生成别名
	 * 规则 cityCode_districtCode_serInfoId
	 * 
	 * 
	 * */
	public static String generateAliasByUser(UserInfo userInfo){
		
		String city_code=userInfo.getCityCode();
		String district_code=userInfo.getDistrictCode();
		Long userInfoId=userInfo.getUserInfoId();
		String splitStr="_";
		StringBuffer sb=new StringBuffer(city_code);
		sb.append(splitStr);
		sb.append(district_code);
		sb.append(splitStr);
		sb.append(userInfoId);
		return sb.toString();
		
	}
	
	
	/**
	 * 根据用户生成别名
	 * */
	public static String generateAliasByUser(User user){
		
		return  aliasPrefix+user.getUserId();
		
	}
	
	
	/**
	 * 根据用户id生成别名
	 * */
	public static String generateAliasByUser(String userId){
		
		return  aliasPrefix+userId;
		
	}
	
}
