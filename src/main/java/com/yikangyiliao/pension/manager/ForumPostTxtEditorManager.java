package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.ForumPostTxtEditorDao;
import com.yikangyiliao.pension.entity.ForumPostTxtEditor;


@Component
public class ForumPostTxtEditorManager {

	@Autowired
	private ForumPostTxtEditorDao forumPostTxtEditorDao;
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-06-20 19:19
	 * @desc 获取唯一的编辑码
	 * */
	public ForumPostTxtEditor selectByUniqueCode(String uniqueCode){
		return forumPostTxtEditorDao.selectByUniqueCode(uniqueCode);
	}
	
	public int insertSelective(String uniqueCode,Long userId){
		Date currentDate=Calendar.getInstance().getTime();
		ForumPostTxtEditor record=new ForumPostTxtEditor();
		record.setCreateDateTime(currentDate);
		record.setIsDelete(Byte.valueOf("0"));
		record.setUniqueCode(uniqueCode);
		record.setUpdateDateTime(currentDate);
		record.setOwnUserId(userId);
		return forumPostTxtEditorDao.insertSelective(record);
	}
}
