package com.ly.easyui.shiro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.easyui.exception.CustomException;
import com.ly.easyui.shiro.dao.SysPermissionMapper;
import com.ly.easyui.shiro.dao.SysUserMapper;
import com.ly.easyui.shiro.model.ActiveUser;
import com.ly.easyui.shiro.model.SysPermission;
import com.ly.easyui.shiro.model.SysUser;
import com.ly.easyui.shiro.service.SysService;
import com.ly.easyui.util.MD5;


/**
 * 
 * <p>Title: SysServiceImpl</p>
 * <p>Description:认证和授权的服务接口 </p>
 * @date	2015-3-23上午11:31:43
 * @version 1.0
 */

@Service("sysService")
public class SysServiceImpl implements SysService {
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysPermissionMapper sysPermissionMapper;

	@Override
	public ActiveUser authenticat(String userCode, String password) throws Exception {
		//根据用户账号查询数据库
		SysUser sysUser = this.findSysUserByUserCode(userCode);
		
		if(sysUser == null){
			throw new CustomException("用户账号不存在");
		}
		
		String password_db = sysUser.getPassword();
		String password_input_md5 = new MD5().getMD5ofStr(password);
		if(!password_input_md5.equalsIgnoreCase(password_db)){
			throw new CustomException("用户名或密码 错误");
		}
		//得到用户id
		String userid = sysUser.getId();
		//根据用户id查询菜单 
		List<SysPermission> menus =this.findMenuListByUserId(userid);
		
		//根据用户id查询权限url
		List<SysPermission> permissions = this.findPermissionListByUserId(userid);
		
		//认证通过，返回用户身份信息
		ActiveUser activeUser = new ActiveUser();
		activeUser.setUserid(sysUser.getId());
		activeUser.setUsercode(userCode);
		activeUser.setUsername(sysUser.getUsername());//用户名称
		
		//放入权限范围的菜单和url
		activeUser.setMenus(menus);
		activeUser.setPermissions(permissions);
		
		return activeUser;
	}
	
	//根据用户账号查询用户信息
	public SysUser findSysUserByUserCode(String userCode)throws Exception{
		return sysUserMapper.selectByUserCode(userCode);
	}

	@Override
	public List<SysPermission> findMenuListByUserId(String userid) {
		return sysPermissionMapper.findMenuListByUserId(userid);
	}

	@Override
	public List<SysPermission> findPermissionListByUserId(String userid) {
		return sysPermissionMapper.findPermissionListByUserId(userid);
	}

}
