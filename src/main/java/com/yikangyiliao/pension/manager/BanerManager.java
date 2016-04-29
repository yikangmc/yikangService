package com.yikangyiliao.pension.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.BanerDao;
import com.yikangyiliao.pension.entity.Baner;

@Component
public class BanerManager {
	
	@Autowired
	private BanerDao banerDao;
	
	
    /**
     * 
     * @author liushuaic
     * @date 2016-04-25 14:24
     * @desc 查询baner列表
     * 
     * **/
	public List<Baner> getBanerList(){
		return banerDao.getBanerList();
	}
	

}
