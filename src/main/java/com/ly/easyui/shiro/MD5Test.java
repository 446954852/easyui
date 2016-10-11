package com.ly.easyui.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 创建时间：2016年6月1日 下午8:32:22  
 * 项目名称：easyui  
 * @author liyong 
 * 文件名称：MD5Test.java  
 * 类说明：  
 */

public class MD5Test {
	public static void main(String[] args) {
		//原始密码
		String password = "123456";
		//盐
		String salt = "uiwueylm";
		//散列次数
		int hashIterations = 1;
		
		Md5Hash md5Hash = new Md5Hash(password, salt, hashIterations);
		
		System.out.println(md5Hash.toString());//a954a76b34901a8be5839775cea7167a
	}
}

