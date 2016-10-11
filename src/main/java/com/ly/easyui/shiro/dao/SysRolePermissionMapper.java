package com.ly.easyui.shiro.dao;

import com.ly.easyui.shiro.model.SysRolePermission;

public interface SysRolePermissionMapper {

    int deleteByPrimaryKey(String id);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);
}