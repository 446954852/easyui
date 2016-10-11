package com.ly.easyui.exception;

/**
 * 创建时间：2016年1月14日 下午11:57:53  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：BaseException.java  
 * 类说明：  
 */

public class BaseException extends Exception {

	private static final long serialVersionUID = 140884257379006316L;
	
	public BaseException(){
		super();
	}
	
	public BaseException(Exception e){
		super(e);
	}

	public BaseException(String msg){
		super(msg);
	}
	
	public BaseException(String msg, Exception e){
		super(msg, e);
	}
	
	public BaseException(String code, String msg, Exception e){
		super(msg, e);
	}
	
	
}

