package com.yikangyiliao.pension.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service(value="test" )
public class TestService {

	
	public Map<String,Object>  test(Map<String,Object> param){
		System.out.println("sayHello!");
		Map<String,Object> rtnData=new HashMap<String, Object>();
		rtnData.put("status","000000");
		rtnData.put("message","操作成功！");
		Map<String,Object> user=new HashMap<String, Object>();
		user.put("userId", 1);
		user.put("userName", "hello");
		rtnData.put("data",user);
		return rtnData;
		
	}
}
