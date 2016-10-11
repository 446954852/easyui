package com.ly.easyui.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ly.easyui.model.Menu;
import com.ly.easyui.service.MenuService;

/**
 * 创建时间：2016年2月19日 下午2:39:38  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：MenuController.java  
 * 类说明：  菜单控制器
 */

@Controller
@RequestMapping("/menuController")
public class MenuController extends ABaseController<Menu>{
	
	@Resource
	private MenuService menuService;
	
	@RequestMapping("/findAllMenus")
	@ResponseBody
	public List<Menu> findAllMenus(Menu menu) {
		return menuService.findAllMenus(menu);
	}
	
}

