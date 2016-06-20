package com.yikangyiliao.pension.dao;

import java.util.List;
import com.yikangyiliao.pension.entity.ActivetyComment;

public interface ActivetyCommentDao {
    int deleteByPrimaryKey(Long activetyCommentId);

    int insert(ActivetyComment record);

    int insertSelective(ActivetyComment record);

    ActivetyComment selectByPrimaryKey(Long activetyCommentId);

    int updateByPrimaryKeySelective(ActivetyComment record);

    int updateByPrimaryKey(ActivetyComment record);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-18 18:31
     * @desc 获取评论列表
     * */
    List<ActivetyComment> getActivetyCommentByActivetyId(Long activetyId);
}