package com.yikangyiliao.base.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.yikangyiliao.base.encryption.AES;
import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.error.ExceptionInfo;

/**
 * 
 * @author liushuaic
 * @date 2015/08/04 20:10
 * @desc accessTiket 校验
 * **/
public class AccessTiketCheckout {

	private static final String secretKey = "yi99kang88yi99ka";

	private static Logger logger = Logger.getLogger(AccessTiketCheckout.class);

	/**
	 * @author liushuaic
	 * @throws Exception
	 * @date 2015/08/04 20:21 1.加密方式校验， 2.格式校验 3.accessTiket loginTime 校验
	 *       4.accessTiket ip 校验 5.accessTiket 访问 间隔校验 6.accessTiket 访问 次数校验
	 * 
	 *       TODO email 邮件通知
	 *       
	 * **/
	public static Boolean checkAccessTiketLayout(String accessTiket, HttpServletRequest hsr) throws Exception {
		try {
			String accessTik = AES.Decrypt(accessTiket, secretKey);

			if (accessTik.contains("UD") && accessTik.contains("￥LDT")
					&& accessTik.contains("￥MC")) {

				int udIndex = accessTik.indexOf("UD");
				int ldtIndex = accessTik.indexOf("￥LDT");
				int mcIndex = accessTik.indexOf("￥MC");

				if (ldtIndex > udIndex && mcIndex > ldtIndex) {
					return true;
				} else {
					logger.error("ip为：" + NetworkUtil.getIpAddress(hsr)
							+ "-->输入格式accessTiket 错误数据，内容为：" + accessTiket
							+ " 这货，已经到了测试 参数 顺序这层，注意了。");
					throw new ExceptionInfo(
							ExceptionConstants.parameterException.accessTiketException.errorCode,
							ExceptionConstants.parameterException.accessTiketException.errorMessage);
				}

			} else {
				logger.error("ip为：" + NetworkUtil.getIpAddress(hsr)
						+ "-->输入格式accessTiket 错误数据，内容为：" + accessTiket);
				throw new ExceptionInfo(
						ExceptionConstants.parameterException.accessTiketException.errorCode,
						ExceptionConstants.parameterException.accessTiketException.errorMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ip为：" + NetworkUtil.getIpAddress(hsr)
					+ "-->输入格式accessTiket 错误数据，内容为：" + accessTiket);
			throw new ExceptionInfo(
					ExceptionConstants.parameterException.accessTiketException.errorCode,
					ExceptionConstants.parameterException.accessTiketException.errorMessage);

		}
		
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/08/17 16:57
	 * @desc 获取accessTiket LDT
	 * */
	public static String getAccessTiketLDT(String accessTiket,HttpServletRequest hsr) throws Exception{
		if(checkAccessTiketLayout(accessTiket,hsr)){
			String accessTik = AES.Decrypt(accessTiket, secretKey);
			String[] strs=accessTik.split("￥LDT");
			strs=strs[1].split("￥MC");
			
			return strs[0];
		};
		return "";
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/17 16:57
	 * @desc 获取accessTiket LDT
	 * */
	public static String getAccessTiketLDT(String accessTiket) throws Exception{
			String accessTik = AES.Decrypt(accessTiket, secretKey);
			String[] strs=accessTik.split("￥LDT");
			strs=strs[1].split("￥MC");
			return strs[0];
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/08/17 16:57
	 * get MC
	 * */
	public static String getAccessTiketMC(String accessTiket,HttpServletRequest hsr) throws Exception{
		if(checkAccessTiketLayout(accessTiket,hsr)){
			String accessTik = AES.Decrypt(accessTiket, secretKey);
			String[] strs=accessTik.split("￥MC");
			
			return strs[1];
		};
		return "";
	}
	
	public static String getAccessTiketMC(String accessTiket) throws Exception{
			String accessTik = AES.Decrypt(accessTiket, secretKey);
			String[] strs=accessTik.split("￥MC");
			return strs[1];
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/08/17 16:57
	 * 获取UD
	 * */
	public static String getAccessTiketUD(String accessTiket,HttpServletRequest hsr) throws Exception{
		if(checkAccessTiketLayout(accessTiket,hsr)){
			String accessTik = AES.Decrypt(accessTiket, secretKey);
			String[] strs=accessTik.split("￥LDT");
			
			return strs[0];
		};
		return "";
	}
	
	public static String getAccessTiketUD(String accessTiket) throws Exception{
			String accessTik = AES.Decrypt(accessTiket, secretKey);
			String[] strs=accessTik.split("￥LDT");
			return strs[0].substring(2);
	}

	/**
	 * @author liushuaic
	 * @date 2015/08/17 16:57
	 * @desc 获取accessTiket
	 * */
	public static String generateAccessTicket(String loginId, Long loginDateTime,
			String machineCode) throws Exception {
		return AES.Encrypt("UD" + loginId + "￥LDT" + loginDateTime + "￥MC"+machineCode,
				secretKey);
	}
	public static void main(String[] args) {
		try {
			System.out.println(AES.Decrypt("ae7433528cdd54dc76e922c1d612c82dfcfc343a64e68012c34c1b74c4cd73dd5e4c7afd323d91954ba85f0a1bf9bb45","yi99kang88yi99ka"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
