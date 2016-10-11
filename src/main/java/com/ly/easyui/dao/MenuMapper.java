package com.ly.easyui.dao;

import java.util.List;

import com.ly.easyui.model.Menu;

/**
 * 创建时间：2016年2月19日 下午2:42:25  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：MenuDao.java  
 * 类说明：  
 */

public interface MenuMapper extends BaseDao<Menu> {
	public List<Menu> findAllMenus();
	public Menu findTopMenu();
	public List<Menu> findMenuById(Integer id);
	public List<Menu> findMenuByPid(Integer pid);
}

