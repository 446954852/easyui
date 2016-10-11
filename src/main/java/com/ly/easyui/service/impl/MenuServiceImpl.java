package com.ly.easyui.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ly.easyui.dao.MenuMapper;
import com.ly.easyui.model.Menu;
import com.ly.easyui.service.MenuService;

/**
 * 创建时间：2016年2月19日 下午4:07:10  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：MenuServiceImpl.java  
 * 类说明：  
 */

@Service("menuService")
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {

	@Resource
	private MenuMapper menuMapper;
	
	/*
	 * 查询所有菜单
	 */
	@Override
	public List<Menu> findAllMenus(Menu menu) {
		List<Menu> allMenus = null;
		if(menu.getId() == null){
			allMenus = menuMapper.findAllMenus();
			allMenus = new ArrayList<Menu>();
			allMenus.add(menuMapper.findTopMenu());
		}else{
			allMenus = menuMapper.findMenuById(menu.getId());
		}
//		try {
//			System.out.println(new ObjectMapper().writeValueAsString(buildTree(allMenus)));
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
		return buildTree(allMenus);
	}

	private List<Menu> buildTree(List<Menu> allMenus) {

		Map<Integer, Menu> map = new HashMap<Integer, Menu>();
		
		for (Menu menu : allMenus) {
			map.put(menu.getId(), menu);
		}
		Map<String, Object> attributes = null;
			
		List<Menu> results = new ArrayList<Menu>();
		List<Menu> children = null;
		for (Menu menu : allMenus) {
			Menu m = map.get(menu.getPid());
			
//			menu.setState("closed");
			attributes = new HashMap<String, Object>();
			attributes.put("url", menu.getUrl());
			menu.setAttributes(attributes);
			if(m == null){
				//根节点 首页 1 null
				List<Menu> childrenByPid = menuMapper.findMenuByPid(menu.getId());
				if(childrenByPid != null && childrenByPid.size() > 0) {
					menu.setState("closed");
				}
				results.add(menu);
			}else{
//				m.setState("closed");
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
		
		for (Menu menu : results) {
			if(menu.getChildren() != null && menu.getChildren().size() > 0){
//				menu.setState("closed");
			}else{
//				menu.setState("open");
				
			}
		}
		
		return results;
	}

}

