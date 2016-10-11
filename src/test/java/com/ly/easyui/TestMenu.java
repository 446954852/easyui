package com.ly.easyui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ly.easyui.dao.MenuMapper;
import com.ly.easyui.dao.UserMapper;
import com.ly.easyui.model.Menu;

/**
 * 创建时间：2015年12月20日 下午2:43:46  
 * 项目名称：springmvc  
 * @author liyong 
 * 文件名称：TestDB.java  
 * 类说明：  通过数据库连接 测试spring的替换属性占位符(@Value注解的SpEl表达式也可以使用$占位符)
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestMenu {
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private MenuMapper menuMapper;
	
	@Test
	public void findAllMenus() throws Exception{
		List<Menu> allMenus = menuMapper.findAllMenus();
		System.out.println(allMenus);
	}
	
	@Test
	public void buildTree() throws JsonProcessingException {
		List<Menu> allMenus = new ArrayList<Menu>();
		Menu m1 = new Menu(1, null , "m1");
		Menu m2 = new Menu(2, 1 , "m2");
		Menu m3 = new Menu(3, 2 , "m3");
		Menu m4 = new Menu(4, 2 , "m4");
		Menu m5 = new Menu(5, 2 , "m5");
		Menu m6 = new Menu(6, 2 , "m6");
		allMenus.add(m1);
		allMenus.add(m2);
		allMenus.add(m3);
		allMenus.add(m4);
		allMenus.add(m5);
		allMenus.add(m6);
		Map<Integer, Menu> map = new HashMap<Integer, Menu>();
		
		for (Menu menu : allMenus) {
			map.put(menu.getId(), menu);
		}
		
		List<Menu> results = new ArrayList<Menu>();
		List<Menu> children = null;
		for (Menu menu : allMenus) {
			Menu m = map.get(menu.getPid());
			if(m == null){
				//根节点 首页 1 null
				results.add(m);
			}else{
				//系统管理  2 1
				
				List<Menu> child = m.getChildren();
				if(child == null || child.size() == 0){
					children = new ArrayList<Menu>();
					children.add(menu);
					m.setChildren(children);
				}else{
					child.add(menu);
					m.setChildren(children);
				}
			}
		}
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(results);
		System.out.println(json);
		
	}
	
}
