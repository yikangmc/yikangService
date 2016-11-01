package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.ReportInformation;

public interface ReportInformationDao {

	int deleteByPrimaryKey(Long reportId);

	int insert(ReportInformation record);

	int insertSelective(ReportInformation record);

	ReportInformation selectByPrimaryKey(Long reportId);

	int updateByPrimaryKeySelective(ReportInformation record);

	int updateByPrimaryKey(ReportInformation record);



}
