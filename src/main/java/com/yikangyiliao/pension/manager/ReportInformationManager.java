package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.ReportInformationDao;
import com.yikangyiliao.pension.entity.ReportInformation;

@Component
public class ReportInformationManager {
	@Autowired
	private ReportInformationDao reportInformationDao;

	private Logger logger = LoggerFactory.getLogger(ReportInformationManager.class);

	/**
	 * 添加举报信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public ReportInformation addReportInformation(byte reportGroup, byte contentGroup, long dataId, long userId,
			long reportUserId) {
		logger.info("添加举报信息：类型为" + reportGroup + "数据来源id:" + dataId + "发布者：" + reportUserId);
		Date currentDate =  Calendar.getInstance().getTime();
		ReportInformation reportInformation = new ReportInformation();

		reportInformation.setReportTimeMillisecond(currentDate.getTime());
		reportInformation.setReportTime(currentDate);
		reportInformation.setUpdateTime(currentDate);

		// 这五个是需要传的参数
		reportInformation.setReportGroup(reportGroup);
		reportInformation.setContentGroup(contentGroup);
		reportInformation.setDataId(dataId);
		reportInformation.setUserId(userId);
		reportInformation.setReportUserId(reportUserId);

		reportInformationDao.insertSelective(reportInformation);
		return reportInformation;
	}

}
