package com.ly.easyui.controller;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ly.easyui.dto.Json;
import com.ly.easyui.exception.UserException;
import com.ly.easyui.model.Page;
import com.ly.easyui.model.User;
import com.ly.easyui.service.UserService;

/**
 * 创建时间：2016年1月13日 下午11:04:52  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：UserController.java  
 * 类说明：  
 */

@Controller
@RequestMapping("/user")
public class UserController extends ABaseController<User> {
	

	@Resource
	private UserService userService;
	
	@RequestMapping(params="login")
	@ResponseBody
	public Json login(User user, HttpSession session, HttpServletRequest request){
		Json json = new Json();
		User u = userService.findUser(user);
		if(u != null){
			json.setSuccess(true);
			json.setMsg("登录成功!");
			json.setObj(u);
		}else{
			json.setMsg("账号或密码错误!");
		}
		return json;
	}
	
	
	@RequestMapping("/register")
	@ResponseBody
	public Json register(User user, HttpServletResponse response) throws UserException {
		Json json = new Json();
		userService.saveUser(user);
		json.setSuccess(true);
		json.setMsg("注册成功!");
		return json;
	}
	
	/**
	 * 
	 * @param page 分页参数
	 * @param user 实体参数   --   @ModelAttribute---userListSearch对应前台Form表单ID
	 * getAllUsers(Page page, @ModelAttribute(ID)User user)
	 * getAllUsers(Page page, User user,@RequestParam(value="username",required=false)String username)
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> queryUsers(Page page, User user,@RequestParam(value="username",required=false)String username) {
		System.out.println(page);
		System.out.println(user);
		Map<String, Object> map = new HashMap<String, Object>();
		List<User> users = new ArrayList<User>();
		users = userService.findAllUserResult(user, page);
		Long count = userService.findAllUserResultCount(user);
//		for (User user2 : users) {
//			user2.setCreateDateTime(null);
//			user2.setModifyDateTime(null);
//		}
		map.put("rows", users);
		map.put("total", count);
		return map;
	}
	
	@RequestMapping("/list")
	@RequiresPermissions("user:list")
	public String toUserList(Page page, User user,@RequestParam(value="username",required=false)String username) {
		System.out.println(page);
		return "userList";
	}
//	
//	@RequestMapping("/queryItems")
//	public ModelAndView queryItems(HttpServletRequest request) throws Exception {
//		
//		System.out.println(request.getParameter("id"));
//	
//		//调用service查询商品列表
//		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
//
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("itemsList", itemsList);
//		// 指定逻辑视图名
//		modelAndView.setViewName("itemsList");
//
//		return modelAndView;
//	}
//	
	@RequestMapping("/add")
	@ResponseBody
	public Json add(User user){
		Json json = new Json();
		try {
			userService.saveUser(user);
			json.setSuccess(true);
			json.setMsg(MessageFormat.format("添加[{0}]成功！", user.getUsername()));
		} catch (Exception e) {
			json.setMsg(MessageFormat.format("添加[{0}]失败！数据库中已存在此用户", user.getUsername()));
		}
		return json;
	}
	
	@RequestMapping(value="/edit")
	@ResponseBody
	public Json edit(User user){
		Json json = new Json();
		try {
			userService.updateUser(user);
			json.setSuccess(true);
			json.setMsg(MessageFormat.format("编辑[{0}]成功！", user.getUsername()));
		} catch (Exception e) {
			json.setMsg(MessageFormat.format("编辑[{0}]失败！数据库中已存在此用户", user.getUsername()));
		}
		return json;
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.POST}, consumes = "application/json")
	@ResponseBody
	public Json delete(@RequestBody List<User> users) throws UserException {
		Json json = new Json();
		userService.deleteUsers(users);
		json.setSuccess(true);
		json.setMsg("刪除成功");
		return json;
	}
	
	@RequestMapping(value = "/deleteArr", method = {RequestMethod.POST}, consumes = "application/json")
	@ResponseBody
	public Json deleteArr(@RequestBody User[] users) throws UserException {
		Json json = new Json();
		userService.deleteUsersArr(users);
		json.setSuccess(true);
		json.setMsg("刪除成功");
		return json;
	}
	
}

