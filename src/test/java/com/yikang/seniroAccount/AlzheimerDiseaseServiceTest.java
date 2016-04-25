package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class AlzheimerDiseaseServiceTest {
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/12 12:15
	 * @desc 长谷川测试  00-07-01 测试类
	 * **/
	@Test
	public void TesGetTable(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("appId","hello");
			paramData.put("accessTiket",1);
			
			SendRequest.sendPost("00-14-01",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
