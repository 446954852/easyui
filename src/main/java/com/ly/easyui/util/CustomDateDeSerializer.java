package com.ly.easyui.util;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.ly.easyui.constants.DateFormat;

/**
 * 创建时间：2016年1月19日 上午1:54:02  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：CustomDateSerializer.java  
 * 类说明：  js对象中日期字符串转换为java Date对象日期格式化自定义类(前台---后台)
 */

public class CustomDateDeSerializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		Date date = null;    
        try {
			date = DateFormat.yyyyMMdd.parse(jp.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}    
        return date;    
	}

	


}

