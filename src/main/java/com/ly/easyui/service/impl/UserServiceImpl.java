package com.ly.easyui.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ly.easyui.dao.BaseDao;
import com.ly.easyui.dao.UserMapper;
import com.ly.easyui.exception.UserException;
import com.ly.easyui.model.Page;
import com.ly.easyui.model.User;
import com.ly.easyui.service.UserService;

/**
 * @since：2016年1月14日 下午6:45:10  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：UserServiceImpl.java  
 * 类说明：  
 */

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
	@Resource(name="userMapper")
	public void setDao(BaseDao<User> dao) {
		super.setDao(dao);
	}
	
	@Resource
	private UserMapper userMapper;

	@Override
	public void saveUser(User user) throws UserException {
		userMapper.saveUser(user);
//		int i = 0;
		//System.out.println(2 / i);
		
//		if(i == 0) {
//			throw new UserException("注册失败&成功");
//		}
		
	}

	@Override
	public void saveOrUpdateUser(User user) {
		userMapper.saveOrUpdateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		userMapper.saveOrUpdateUser(user);
	}

	@Override
	public void deleteUserById(Long id) {
		userMapper.deleteUserById(id);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	@Override
	public void updateUser(Long id) {
		userMapper.updateUser(id);
	}

	@Override
	public User findUserById(Long id) {
		return userMapper.findUserById(id);
	}

	@Override
	public User findUser(User user) {
		return userMapper.findUser(user);
	}

	@Override
	public List<User> findAllUsers(User user) {
		return userMapper.findAllUsers(user);
	}

	@Override
	public List<User> findAllUserResult(User user, Page page) {
		return userMapper.findAllUserResult(user, page);
	}
	
	/**
	 * 得到总数
	 */
	public Long findAllUserResultCount(User user){
		return userMapper.findAllUserResultCount(user);
	}

	@Override
	public void deleteUsers(List<User> users) throws UserException {
		userMapper.deleteUsers(users);
	}
	
	@Override
	public void deleteUsersArr(User[] users) throws UserException {
		System.out.println("deleteUsersArr");
	}

}

