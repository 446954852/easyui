package com.ly.easyui.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建时间：2016年2月19日 下午2:07:34  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：Menu.java  
 * 类说明：  系统菜单(36:18)
 */

public class Menu extends BaseEntity {
	
	private static final long serialVersionUID = -6521862727431799677L;
	private Integer id;
	private Integer pid;
	private String text;
	private String url;
	private String iconCls;
	private BigDecimal seq;
	private Map<String, Object> attributes = new HashMap<String, Object>();
	private List<Menu> children = new ArrayList<Menu>();
	private String state;//"state":"open" || null,正常   "closed",文件夹  
	
	public Menu(){
		super();
	}
	
	public Menu(Integer id){
		this.id = id;
	}
	
	public Menu(Integer id, String text){
		this.id = id;
		this.text = text;
	}
	
	public Menu(Integer id, Integer pid, String text){
		this.id = id;
		this.pid = pid;
		this.text = text;
	}
	public Menu(Integer id, Integer pid, String text, String url, String iconCls, BigDecimal seq){
		this.id = id;
		this.pid = pid;
		this.text = text;
		this.url = url;
		this.iconCls = iconCls;
		this.seq = seq;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
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

	public BigDecimal getSeq() {
		return seq;
	}

	public void setSeq(BigDecimal seq) {
		this.seq = seq;
	}


	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", pid=" + pid + ", text=" + text
				+ ", children=" + children + "]";
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	
}

