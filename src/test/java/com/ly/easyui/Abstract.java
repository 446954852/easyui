package com.ly.easyui;

/**
 * 创建时间：2016年2月28日 下午3:28:45  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：Abstract.java  
 * 类说明：  
 */

@SuppressWarnings("unused")
public abstract class Abstract extends com.ly.easyui.EqualVO {
	
	private String name;
	
	public static int i = 0;
	
	private void test2(){
	}
	
	abstract void getName2();
	public static void main(String[] args) {
		i++;
	}
	public Abstract(){
		
	}
	protected abstract  void test();
}

