package com.ly.easyui.util;

import org.springframework.beans.propertyeditors.PropertiesEditor;

/**
 * 创建时间：2016年1月19日 下午9:17:57  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：DoubleEditor.java  
 * 类说明：界面小数类型转换到后台Double自定义类 (前台---后台)
 */

public class DoubleEditor extends PropertiesEditor {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text == null || text.equals("")) {    
			text = "0";    
        }    
        setValue(Double.parseDouble(text));    
	}

	@Override
	public String getAsText() {
		return getValue().toString();  
	}

	

	
}

