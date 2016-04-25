package com.yikangyiliao.base.cache;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;



@Component
public class RedisExample{
	
	@Autowired
	private RedisTemplate<String, String> template;
	
//	@Resource(name="redisTemplate")
//	private ListOperations<String, String> listOps;
	
	
	public void save(String key,String value){
		template.opsForList().leftPush(key, value);
	}

	
	public String get(String key){
		return template.opsForValue().get(key);
	}
}
