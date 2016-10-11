package com.ly.easyui.service;

import java.util.List;


/**
 * 创建时间：2016年1月14日 下午6:19:24  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：BaseService.java  
 * 类说明：  
 */

public interface BaseService<T> {
	
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

