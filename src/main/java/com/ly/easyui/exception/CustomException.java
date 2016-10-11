package com.ly.easyui.exception;

/**
 * 
 * <p>Title: CustomException</p>
 * <p>Description: 系统自定义的异常类型，实际开发中可能要定义多种异常类型</p>
 * @date	2015-3-22下午2:50:30
 * @version 1.0
 */
public class CustomException extends BaseException {
	
	private static final long serialVersionUID = -7533354215756064238L;
	//异常信息
	private String message;
	
	public CustomException(String message){
		super(message);
		this.message = message;
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
