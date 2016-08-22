package com.yikangyiliao.pension.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.IntegralDao;

/**
 * @author liushuaic
 * @date 2016-08-19 16:54
 * @desc 积分管理类
 */
@Component
public class IntegralManager {

	@Autowired
	private IntegralDao integralDao;

	/**
	 * @author liushuaic
	 * @date 2016-08-19 16:47
	 * @desc 获取我所有的积分
	 */
	public Long getMytotalScore(Long userId) {
		return integralDao.getMytotalScore(userId);
	}

	/**
	 * @author liushuaic
	 * @date 2016-08-19 16:48
	 * @desc 获取的扣除的积分
	 */
	public Long getDeductScore(Long userId) {
		return integralDao.getDeductScore(userId);
	}

	/**
	 * @author liushuaic
	 * @date 2016-08-20 14:41
	 * @desc 获取某一个积分的领取状态
	 */
	public Integer getIntegralJobstateByIntegralId(Long integralId) {
		return integralDao.getIntegralJobstateByIntegralId(integralId);
	}
	
	/**
     * @author liushuaic
     * @date 2016-08-20 16:47
     * @desc 修改积分的领取状态
     * */
    public Integer udpateIntegralJobStateIsRecived(Long integralId){
    	return integralDao.udpateIntegralJobStateIsRecived(integralId);
    }

}
