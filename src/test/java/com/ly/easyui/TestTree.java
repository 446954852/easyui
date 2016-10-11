package com.ly.easyui;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ly.easyui.model.Menu;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建时间：2016年2月20日 下午12:58:17  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：TestTree.java  
 * 类说明：  
 */

public class TestTree {
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
				results.add(menu);
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
	
	
	@Test
	public void testSubList(){
		List<Menu> allMenus = new ArrayList<Menu>();
		Menu m1 = new Menu(1, null , "m1");
		Menu m2 = new Menu(2, 1 , "m2");
		Menu m3 = new Menu(3, 2 , "m3");
		allMenus.add(m1);
		allMenus.add(m2);
		allMenus.add(m3);
		System.out.println(allMenus.subList(0, 1));
	}
	
	@Test
	public void testJackJson() throws JsonProcessingException{
		Menu m = new Menu(1, null , "m1");
		m.setState(null);
		ObjectMapper mapper = new ObjectMapper();
		String ss = mapper.writeValueAsString(m);
		System.out.println(ss);
	}
}

