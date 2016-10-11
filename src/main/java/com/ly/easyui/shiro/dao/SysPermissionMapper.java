package com.ly.easyui.shiro.dao;

import java.util.List;

import com.ly.easyui.shiro.model.SysPermission;

public interface SysPermissionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
    
    List<SysPermission> findMenuListByUserId(String userid);
    
    List<SysPermission> findPermissionListByUserId(String userid);
}