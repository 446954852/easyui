package com.ly.easyui.shiro.dao;

import com.ly.easyui.shiro.model.SysUser;

public interface SysUserMapper {

    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String id);
    
    SysUser selectByUserCode(String userCode);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}