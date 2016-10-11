package com.ly.easyui.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ly.easyui.shiro.model.ActiveUser;


@Controller
public class IndexController {
	
	//首页
	@RequestMapping("/index")
	public String index(Model model){
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		model.addAttribute("activeUser", activeUser);
		return "index";
	}
}	
