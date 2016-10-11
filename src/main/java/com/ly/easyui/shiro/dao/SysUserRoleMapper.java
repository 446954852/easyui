package com.ly.easyui.shiro.dao;

import com.ly.easyui.shiro.model.SysUserRole;

public interface SysUserRoleMapper {

    int deleteByPrimaryKey(String id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
}