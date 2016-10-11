package com.ly.easyui.converter;

import java.beans.PropertyEditorSupport;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import com.ly.easyui.constants.DateFormat;

/**
 * 创建时间：2016年2月17日 下午6:54:24  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：GlobalDataBinder.java  
 * 类说明：  暂时无用
 */

@Component
public class GlobalDataBinder implements WebBindingInitializer {

	 /** 
     * 智能日期转换，针对四种格式日期： 
     * 1.2014-05-26 
     * 2.1401951570548 
     * 3.2014-05-26 00:00 
     * 4.2014-05-26 00:00:00 
     */  
	private class SmartDateEditor extends PropertyEditorSupport {

		 /** 
         * 根据2014-05-26 00:00:00长度来判断选择哪种转换方式 
         */  
	    @Override  
	    public void setAsText(String text) throws IllegalArgumentException {  
	        if (text == null || text.length() == 0) {  
	            setValue(null);  
	        } else {  
	            try {  
	                if (text.length() == 10) {  
	                    setValue(DateFormat.yyyyMMdd.parse(text));  
	                } else if (text.length() == 19) {  
	                    setValue(DateFormat.yyyyMMddHHmmss.parse(text));  
	                } else {  
	                    throw new IllegalArgumentException("转换日期失败: 日期长度不符合要求!");  
	                }  
	            } catch (Exception ex) {  
	                throw new IllegalArgumentException("转换日期失败: " + ex.getMessage(), ex);  
	             }  
            }  
        }  
	}
	
	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Date.class, new SmartDateEditor());  
	}

}

