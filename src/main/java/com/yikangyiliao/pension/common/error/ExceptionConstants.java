package com.yikangyiliao.pension.common.error;


/**
 * 
 * @author liushuaic
 * @date 2015/07/30 15:10
 * @desc 异常静态类
 * 
 * **/
public class ExceptionConstants {
	

	public enum responseSuccess{
		responseSuccess("000000","操作成功！");
		
		public String code;
		public String message;
		private responseSuccess(String code,String message){
			this.code=code;
			this.message=message;
		}
	}
	
	/**
	 * 参数异常枚举类
	 * @author liushuaic
	 * @date	2015/07/30 15:18
	 * 
	 * 00 开头
	 * */
	public enum parameterException{
		parameterException("000001","参数类型异常！"),
		accessTiketException("000002","accessTiket校验异常！");
		public String errorCode;
		public String errorMessage;
		private parameterException(String errorCode,String errorMessage){
			this.errorCode=errorCode;
			this.errorMessage=errorMessage;
		}
	}
	/**
	 * 01开关
	 * */
	public enum systemException{
		systemException("999999","系统异常！");
		public String errorCode;
		public String errorMessage;
		private systemException(String errorCode,String errorMessage){
			this.errorCode=errorCode;
			this.errorMessage=errorMessage;
		}
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/08/27 19:16
	 * @desc 业务异常枚举类
	 * 02开头
	 * */
	public enum operationException{
		userDuplicateException("020001","用户重复！");
		public String errorCode;
		public String errorMessage;
		private operationException(String errorCode,String errorMessage){
			this.errorCode=errorCode;
			this.errorMessage=errorMessage;
		}
	}
	/**
	 * @desc 登陆异常
	 * 03
	 * **/
	public enum loginException{
		userNameOrPasswordException("030001","用户名或密码错误！");
		public String errorCode;
		public String errorMessage;
		private loginException(String errorCode,String errorMessage){
			this.errorCode=errorCode;
			this.errorMessage=errorMessage;
		}
	}
	
	
	
	/**
	 * @desc 定单异常
	 * 04
	 * */
	public enum orderException{
		
		serviceUserHasBeenSelected("040001","服务人员已经被选择！");
		
		public String errorCode;
		public String errorMessage;
		private orderException(String errorCode,String errorMessage){
			this.errorCode=errorCode;
			this.errorMessage=errorMessage;
		}
	}
	
	
	/**
	 * 服务人员相关异常
	 * 04
	 * */
	public enum servicerException{
		
		servicerNoBady("050001","没有服务人员！");
		
		
		public String errorCode;
		public String errorMessage;
		
		
		private servicerException(String errorCode,String errorMessage){
			this.errorCode=errorCode;
			this.errorMessage=errorMessage;
		}
		
	}
	
	
	/**
	 * 用户异常
	 * 05
	 * */
	public enum userException{
		
		
		userNotAtSystem("050001","未注册用户！");
		
		public String errorCode;
		public String errorMessage;
		
		
		private userException(String errorCode,String errorMessage){
			this.errorCode=errorCode;
			this.errorMessage=errorMessage;
		}
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-06-04 17:32
	 * @desc 活动异常
	 * 06
	 * */
	public enum activetyException{
		
		/**活动已经结束*/
		activetyIsEnd("060001","活动报名已经结束 或者 活动已经结束"),
		/**
		 * 活动已经参与
		 * */
		isPartake("060002","已经参与过活动");
		
		public String errorCode;
		public String errorMessage;
		private activetyException(String errorCode,String errorMessage){
			this.errorCode=errorCode;
			this.errorMessage=errorMessage;
		}
		
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-06-08 10:26
	 * @desc 获取我关注的用户
	 * */
	public enum followException{
		
		isFollowed("070001","已经关注"),
		
		followSuccess("000000","关注成功！");
		public String errorCode;
		public String errorMessage;
		private followException(String errorCode,String errorMessage){
			this.errorCode=errorCode;
			this.errorMessage=errorMessage;
		}
	}
	
}
