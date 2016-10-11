package com.ly.easyui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ly.easyui.model.User;

/**
 * 创建时间：2016年5月18日 下午8:44:25  
 * @author liyong 
 * 文件名称：ViewController.java  
 * 类说明：  测试发布rest服务 主要看springmvc.xml中的ContentNegotiatingViewResolver配置
 * 
 * @RestController相当于@Controller+@ResponseBody
 * 
 */

//@RestController
@Controller
@RequestMapping("/view")
public class ViewController {

	@RequestMapping(value = "get/{id}")
	@ResponseBody
	public User get(@PathVariable Long id){
		User user = new User(id, "u", "p", "order");
		return user;
	}
}

