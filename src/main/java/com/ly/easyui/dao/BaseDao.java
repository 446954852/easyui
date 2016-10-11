package com.ly.easyui.dao;

import java.util.List;

/**
 * 创建时间：2016年1月13日 下午9:47:01  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：BaseDao.java  
 * 类说明：  
 */

public interface BaseDao<T>{

	//写操作
	public void saveEntity(T t);
	public void saveOrUpdateEntity(T t);
	public void deleteEntity(T t);
	public void deleteEntityById(Long id);
	public void updateEntity(T t);
	public void updateEntity(Long id);
	
	//读操作
	public T findEntityById(Long id);
	public T findEntity(T t);
	public List<T> findEntities(T t);
	
	
	
	
}

