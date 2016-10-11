package com.ly.easyui.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/welcome")
public class WelcomeController {
	
	//系统首页
	@RequestMapping("/first")
	public String first(Model model) {
		return "/first";
	}
	
	//欢迎页面
	public String welcome(Model model) {
		return "/welcome";
	}
	
	//首页
	@RequestMapping("/index")
	public String index(Model model){
		return "index";
	}
}	
