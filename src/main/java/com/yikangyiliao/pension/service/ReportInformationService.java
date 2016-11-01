package com.yikangyiliao.pension.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.ReportInformation;
import com.yikangyiliao.pension.manager.ReportInformationManager;

@Service(value = "reportInfomationService")
public class ReportInformationService {

	@Autowired
	private ReportInformationManager reportInformationManager;

	/**
	 * 添加举报信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public ResponseMessage<ReportInformation> addReportInformation(Map<String, Object> paramData) {
		ResponseMessage<ReportInformation> res = new ResponseMessage<ReportInformation>();
		if (paramData.containsKey("reportGroup") && paramData.containsKey("contentGroup")
				&& paramData.containsKey("dataId") && paramData.containsKey("userId")
				&& paramData.containsKey("reportUserId")) {
			byte reportGroup = Byte.valueOf(paramData.get("reportGroup").toString());
			byte contentGroup = Byte.valueOf(paramData.get("contentGroup").toString());
			long dataId = Long.valueOf(paramData.get("dataId").toString());
			long userId = Long.valueOf(paramData.get("userId").toString());
			long reportUserId = Long.valueOf(paramData.get("reportUserId").toString());
			ReportInformation reportInformation = reportInformationManager.addReportInformation(reportGroup,
					contentGroup, dataId, userId, reportUserId);
			// 不知道是不是这样写
			// res.setData(reportInformation);
		} else {
			res.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			res.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return res;
	}
}
