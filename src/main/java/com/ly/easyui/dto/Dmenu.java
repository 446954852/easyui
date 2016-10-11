package com.ly.easyui.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建时间：2016年2月19日 下午3:06:44  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：Dmenu.java  
 * 类说明：  Menu数据转换类
 */

public class Dmenu implements Serializable {

	private static final long serialVersionUID = -8878862575609203627L;
	
	private Integer pid;
	private String pname;
	private Map<String, Object> attributes = new HashMap<String, Object>();
	private Integer id;
	private String text;
	private String url;
	private String iconCls;
	private BigDecimal seq;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public BigDecimal getSeq() {
		return seq;
	}
	public void setSeq(BigDecimal seq) {
		this.seq = seq;
	}
	
	

}

