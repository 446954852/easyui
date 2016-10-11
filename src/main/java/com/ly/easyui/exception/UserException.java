package com.ly.easyui.exception;


/**
 * 创建时间：2016年1月15日 上午12:07:22  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：UserException.java  
 * 类说明：  用户相关异常类 随便写的测试 呵呵
 */

public class UserException extends BaseException {

	private static final long serialVersionUID = 5688076693207266716L;

	public UserException(String msg, Exception e) {
		super(msg, e);
	}

	public UserException(String msg) {
		super(msg);
	}
	
	
}

