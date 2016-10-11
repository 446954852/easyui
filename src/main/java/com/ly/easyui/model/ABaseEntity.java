package com.ly.easyui.model;

import java.io.Serializable;

/**
 * 创建时间：2016年1月13日 下午9:31:07  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：BaseEntity.java  
 * 类说明： 抽象基类 用户所有业务实体类的继承 id为Integer类型
 */

public abstract class ABaseEntity implements Serializable {

	
	private static final long serialVersionUID = -3518459398203257218L;

	public abstract Integer getId();

	public abstract void setId(Integer id);
	
	

}

