package com.ly.easyui;

import org.apache.ibatis.plugin.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 创建时间：2016年3月6日 下午4:08:56  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：TestMybatisPlugin.java  
 * 类说明：  
 */

@SuppressWarnings("unchecked")
public class TestMybatisPlugin {
	
	static Map<String, Object> map;
	static{
		map = new HashMap<String, Object>();
		map.put("Anything2", "dd");
	}

	
	@Test  
	public void mapPluginShouldInterceptGet() {  
		map = (Map<String, Object>) new AlwaysMapPlugin().plugin(map);
		map.put("Anything2", "cc");
		System.out.println(map.get("Anything2"));
	}
	
	@Test  
	public void shouldNotInterceptToString() {  
		map = (Map<String, Object>) new AlwaysMapPlugin().plugin(map);
		System.out.println(map.toString());
	}  
	
	@Intercepts({@Signature(type = Map.class, args = { Object.class }, method = "get"), @Signature(type = Map.class, args = { Object.class, Object.class }, method = "put"), @Signature(type = HashMap.class, args = {}, method = "toString")})
	public static class AlwaysMapPlugin implements Interceptor {

		@Override
		public Object intercept(Invocation invocation) throws Throwable {
			Object[] args = invocation.getArgs();
			Map<String, Object> target = (Map<String, Object>) invocation.getTarget();
			System.out.println(target.get("Anything2") + "----");
			invocation.proceed();
			System.out.println(target.get("Anything2") + "----");
			return args[0] + "---Always";
		}

		@Override
		public Object plugin(Object target) {
			return Plugin.wrap(target, this);
		}

		@Override
		public void setProperties(Properties arg0) {
		}
		
	}
	

}

