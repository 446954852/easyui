package com.ly.easyui.service;

import java.util.List;

import com.ly.easyui.model.Menu;

/**
 * 创建时间：2016年2月19日 下午4:05:39  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：MenuService.java  
 * 类说明：  
 */

public interface MenuService extends BaseService<Menu> {
	public List<Menu> findAllMenus(Menu menu);
}

