package com.ly.easyui.converter;

import java.text.ParseException;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ly.easyui.constants.DateFormat;

/**
 * 创建时间：2016年2月13日 上午10:57:04  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：StringToDateConverter.java  
 * 类说明：  
 */

@Component
public class StringToDateConverter implements Converter<String, Date> {
	
	public StringToDateConverter(){
		super();
		System.out.println("StringToDateConverter初始化成功...");
	}

	@Override
	public Date convert(String arg0) {
		if(arg0 == null || "".equals(arg0.trim())) return null;
		try {
			return DateFormat.yyyyMMddHHmmss.parse(arg0);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}

