package com.yikangyiliao.pension.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * @author liushuaic
 * @date 2015/07/25 13:27
 * 检查service
 * 
 * */
@Service(value="check")
public class CheckService {

	
	public Map<String,Object> saveCheckInfo(Map<String,Object> map){
		
		Map<String,Object> rtnMap=new HashMap<String, Object>();
		rtnMap.put("status","000000");
		rtnMap.put("message", "数据添加成功！");
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rtnMap;
		
	}
}
