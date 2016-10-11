package com.ly.easyui.controller;

import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.ly.easyui.constants.DateFormat;
import com.ly.easyui.util.DoubleEditor;

/**
 * 创建时间：2016年1月13日 下午11:02:36  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：BaseController.java  
 * 类说明：  基类, 所有控制类都继承它
 */

public abstract class ABaseController<T> {
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
	    // dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(DateFormat.yyyyMMddHHmmss, true));
	    binder.registerCustomEditor(double.class, new DoubleEditor());
	    // binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}
}

