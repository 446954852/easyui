package com.ly.easyui.util;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ly.easyui.constants.DateFormat;

/**
 * 创建时间：2016年1月19日 上午1:54:02  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：CustomDateSerializer.java  
 * 类说明：  java Date对象经过Jackson库转换成JSON日期格式化自定义类(后台---前台)
 */

public class CustomDateSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date date, JsonGenerator jsonGenerator,SerializerProvider serializerProvider)
				throws IOException,JsonProcessingException {
         jsonGenerator.writeString(DateFormat.yyyyMMdd.format(date));
	}


}

