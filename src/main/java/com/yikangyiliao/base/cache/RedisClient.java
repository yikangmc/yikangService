package com.yikangyiliao.base.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisClient{
	
	@Autowired
	private RedisTemplate<String, Object> template;
	
//	@Resource(name="redisTemplate")
	private ListOperations<String, String> listOps;
	
	
	public void save(String key,Object value){
		template.opsForList().leftPush(key, value);
	}

	
	public Object get(String key){
		return template.opsForList().leftPop(key);
	}
	
}
