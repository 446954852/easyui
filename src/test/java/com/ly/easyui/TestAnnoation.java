package com.ly.easyui;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建时间：2016年3月6日 下午3:24:49  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：testAnnoation.java  
 * 类说明：  测试注解
 */

//可作用于类，方法，属性，参数上面
@Target(value={ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)//保留在class文件中 可用注解得到
@Documented//生成文档javadoc
public @interface TestAnnoation {
	
	public String value() default "";
	public String[] name() default "";
	
}

