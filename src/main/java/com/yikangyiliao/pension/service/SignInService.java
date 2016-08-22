package com.yikangyiliao.pension.service;

import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.SignIn;
import com.yikangyiliao.pension.manager.SignInManager;

import cn.jpush.api.report.UsersResult.User;

@Service(value="signinService")
public class SignInService {
	
	@Autowired
	private SignInManager signInManager;
	
	
	/**
	 * 增加签到积分
	 * @return
	 */
	@RequestMapping
	@ResponseBody
	public ResponseMessage<SignIn> insertSignIn(Map<String, Object> paramDate){
		ResponseMessage<SignIn> responseMessage = new ResponseMessage<SignIn>();
		SignIn signIn = new SignIn();
		signIn.setCreateUserId(Long.valueOf(paramDate.get("userId").toString()));
		signInManager.insertSignDao(signIn);
		return responseMessage;
	}
	
	public static void main(String[] args) {
		int score = new Random().nextInt(5)+5;
		System.err.println(score);
	}

}
