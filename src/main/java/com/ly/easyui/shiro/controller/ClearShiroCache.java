package com.ly.easyui.shiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ly.easyui.shiro.CustomRealm;


/**
 * 
 * <p>Title: ClearShiroCache</p>
 * <p>Description: 手动调用controller清除shiro的缓存</p>
 * @version 1.0
 */
@Controller
public class ClearShiroCache {
	
	@Autowired
	private CustomRealm customRealm;
	
	@RequestMapping("/clearShiroCache")
	public String clearShiroCache(){
		//清除缓存 比如修改权限时 (PS:将来正常开发要在service调用customRealm.clearCached())
		customRealm.clearCached();
		return "success";
	}

}
