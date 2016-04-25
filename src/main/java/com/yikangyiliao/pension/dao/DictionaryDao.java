package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.Dictionary;

public interface DictionaryDao {
    int deleteByPrimaryKey(Long dictionaryId);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Long dictionaryId);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
}