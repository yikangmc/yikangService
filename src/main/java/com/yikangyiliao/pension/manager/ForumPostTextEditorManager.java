package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.ForumPostTxtEditorDao;
import com.yikangyiliao.pension.entity.ForumPostTxtEditor;

@Component
public class ForumPostTextEditorManager {
	
	@Autowired
	private ForumPostTxtEditorDao forumPostTxtEditorDao;
	
	
	/**
	 * @author liushuaic
	 * @date 2016-07-19 16:30
	 * @desc 添加
	 * **/
	public int insertSelective(ForumPostTxtEditor forumPostTxtEditor){
		return forumPostTxtEditorDao.insert(forumPostTxtEditor);
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-07-19 17:33
	 * @desc 修改标记为已经使用
	 * **/
	public int updateForumPostTxtEditorSetIsDeletedById(Long forumPostTxtEditroId){
		return forumPostTxtEditorDao.updateForumPostTxtEditorSetIsDeletedById(forumPostTxtEditroId);
	}
	
	
	 /**
     * @author liushuaic
     * @date 2016-07-19 17:41
     * @desc 修改唯一标记的，所属用户 
     * **/
   
	public  int updateForumPostTxtEditorOwnUserIdEditorTypeByUniqueCode(Long userId,Byte editorType,String uniqueCode){
		Map<String,Object> paramData=new HashMap<String,Object>();
		paramData.put("userId", userId);
		paramData.put("editorType", editorType);
		paramData.put("uniqueCode", uniqueCode);
		return forumPostTxtEditorDao.updateForumPostTxtEditorOwnUserIdEditorTypeByUniqueCode(paramData);
	}
	 /**
     * @author liushuaic
     * @date 2016-07-20 13:34
     * @desc 查询某一个条记录，根据 unqiueCode And IsDelete
     * */
    public ForumPostTxtEditor getForumPostTxtByUniqueCodeAndIsDelete(String uniqueCode,Byte isDelete){
    	Map<String,Object> paramMap=new HashMap<String,Object>();
    	paramMap.put("uniqueCode", uniqueCode);
    	paramMap.put("isDelete", isDelete);
    	return forumPostTxtEditorDao.getForumPostTxtByUniqueCodeAndIsDelete(paramMap);
    }

    
    /**
     * @author liushuaic
     * @date 2016-07-20 17:13
     * */
    public int insertSelective(String uniqueCode){
    	
    	Date createDateTime=Calendar.getInstance().getTime();
    	ForumPostTxtEditor forumPostTxtEditor=new ForumPostTxtEditor();
    	forumPostTxtEditor.setCreateDateTime(createDateTime);
    	forumPostTxtEditor.setUpdateDateTime(createDateTime);
    	forumPostTxtEditor.setEditorType(Byte.valueOf("-2"));
    	forumPostTxtEditor.setOwnUserId(Long.valueOf("-2"));
    	forumPostTxtEditor.setIsDelete(Byte.valueOf("0"));
    	return forumPostTxtEditorDao.insertSelective(forumPostTxtEditor);
    }
    
   /**
    * @author liushuaic
    * @date 2016-07-22 14:04
    * @desc 根据某一个一 唯一码，获取未过期的数据 
    * */
   public ForumPostTxtEditor getForumPostTxtEditorByUniquecode(String uniqueCode){
	   Map<String,Object> paramMap=new HashMap<String,Object>();
	   paramMap.put("uniqueCode", uniqueCode);
	   paramMap.put("isDelete", 0);
	   return forumPostTxtEditorDao.getForumPostTxtByUniqueCodeAndIsDelete(paramMap);
   }
    
   
   
}
