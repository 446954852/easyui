package com.ly.easyui.service;

import java.util.List;

import com.ly.easyui.exception.UserException;
import com.ly.easyui.model.Page;
import com.ly.easyui.model.User;

/**
 * 创建时间：2016年1月13日 下午9:27:59  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：UserService.java  
 * 类说明：  
 */

public interface UserService extends BaseService<User>{
	//写操作
	public void saveUser(User user) throws UserException;
	public void saveOrUpdateUser(User user);
	public void deleteUser(User user);
	public void deleteUsers(List<User> users) throws UserException;
	public void deleteUsersArr(User[] users) throws UserException;
	public void deleteUserById(Long id);
	public void updateUser(User user) throws UserException;
	public void updateUser(Long id);
		
	//读操作
	public User findUserById(Long id);
	public User findUser(User user);
	public List<User> findAllUsers(User user);
	public List<User> findAllUserResult(User user, Page page);
	public Long findAllUserResultCount(User user);
	
}

