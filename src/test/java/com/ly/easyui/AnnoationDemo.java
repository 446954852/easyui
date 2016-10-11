package com.ly.easyui;

import java.lang.reflect.Method;

/**
 * 创建时间：2016年3月6日 下午3:34:01  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：AnnoationDemo.java  
 * 类说明：  测试注解@TestAnnoation的使用
 */

public class AnnoationDemo {

	@TestAnnoation(value = "lyvalue", name = {"lyname1" , "lyname2"})
	public String sayHello(String name){
		return "通过注解得到" + name;
	}
	
	public static void main(String[] args) throws Exception {
		Class<AnnoationDemo> clazz = AnnoationDemo.class;
		AnnoationDemo obj = clazz.newInstance();
		Method m = clazz.getDeclaredMethod("sayHello", String.class);
		TestAnnoation annotation = m.getAnnotation(TestAnnoation.class);
		String value = annotation.value();
		String[] name = annotation.name();
		System.out.println(value);
		System.out.println(name);
		Object invoke = m.invoke(obj, value);
		System.out.println(invoke);
	}
	
}

