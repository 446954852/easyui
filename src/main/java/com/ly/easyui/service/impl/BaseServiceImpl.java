package com.ly.easyui.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.ly.easyui.dao.BaseDao;
import com.ly.easyui.service.BaseService;

/**
 * 创建时间：2016年1月14日 下午6:23:49  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：BaseServiceImpl.java  
 * 类说明：  
 */

public abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	private BaseDao<T> dao;
	
	@SuppressWarnings("unused")
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public BaseServiceImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz =  (Class<T>)type.getActualTypeArguments()[0];
	}

	public BaseDao<T> getDao() {
		return dao;
	}

	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}
	
	//写操作
	public void saveEntity(T t) {
		dao.saveEntity(t);
	}
	
	public void saveOrUpdateEntity(T t) {
		dao.saveOrUpdateEntity(t);
	}
	
	public void deleteEntity(T t) {
		dao.deleteEntity(t);
	}
	
	public void deleteEntityById(Long id) {
		dao.deleteEntityById(id);
	}
	
	public void updateEntity(T t) {
		dao.updateEntity(t);
	}
	
	public void updateEntity(Long id) {
		dao.updateEntity(id);
	}
	
	//读操作
	public T findEntityById(Long id) {
		return dao.findEntityById(id);
	}
	
	public T findEntity(T t) {
		return dao.findEntity(t);
	}
	
	public List<T> findEntities(T t) {
		return dao.findEntities(t);
	}

	
}

