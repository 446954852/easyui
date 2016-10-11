package com.ly.easyui.dto;

import com.ly.easyui.model.BaseEntity;

/**
 * 创建时间：2016年1月13日 下午9:28:44  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：Json.java  
 * 类说明：  用于前后台json数据交换
 */

public class Json extends BaseEntity {

	private static final long serialVersionUID = -548448336471476708L;
	
	private boolean success = false;
	private String msg = "";
	private Object obj;
	

	@Override
	public Integer getId() {
		return null;
	}

	@Override
	public void setId(Integer id) {
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}

