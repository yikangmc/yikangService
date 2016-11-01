package com.yikang.seniroAccount;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class ReportInformationServiceTest {

	/**
	 * 添加举报信息
	 */
	@Test
	public void addReportInformationTest() {
		try {
			Map<String, Object> paramData = new HashMap<String, Object>();
			paramData.put("reportGroup", 2);
			paramData.put("contentGroup", 2);
			paramData.put("dataId", 70);
			paramData.put("userId", 17);
			paramData.put("reportUserId", 99);
			SendRequest.sendPost(
					"00-47-01?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",
					paramData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void addReportInformationTest1() {
		try {
			Map<String, Object> paramData = new HashMap<String, Object>();
			paramData.put("reportGroup", 2);
			paramData.put("contentGroup", 1);
			paramData.put("dataId", 541);
			paramData.put("userId", 18);
			paramData.put("reportUserId", 105);
			SendRequest.sendPost(
					"00-47-01?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",
					paramData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
