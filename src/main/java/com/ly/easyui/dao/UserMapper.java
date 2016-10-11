package com.ly.easyui.dao;

import com.ly.easyui.model.Page;
import com.ly.easyui.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 创建时间：2016年1月14日 上午12:53:31  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：UserMapper.java  
 * 类说明：  不需要@Repository Spring容器中已经配置了MapperScannerConfigurer
 * 		  MapperScannerConfigurer 自动扫描 将Mapper接口生成代理注入到Spring
 */

//@Repository("userMapper")
public interface UserMapper extends BaseDao<User>{
	//写操作
	public void saveUser(User user);
	public void saveOrUpdateUser(User user);
	public void deleteUser(User user);
	public void deleteUsers(List<User> users);
	public void deleteUserById(Long id);
	public void updateUser(User user);
	public void updateUser(Long id);
		
	//读操作
	public User findUserById(Long id);
	public User findUser(User user);
	public List<User> findAllUsers(@Param("user")User user);
	public List<User> findAllUserResult(@Param("user")User user, @Param("page")Page page);
	public Long findAllUserResultCount(@Param("user")User user);
	
}

