package com.ly.easyui.model;


/**
 * 创建时间：2016年1月16日 下午8:53:13  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：Page.java  
 * 类说明：  
 */

public class Page extends BaseEntity {

	private static final long serialVersionUID = -8702982000111967011L;
	
	
	private Integer page = 1;//第几页
	private Integer rows = 15;//页面大小
	private String sort;//排序方式
	private String order;//排序字段
	@SuppressWarnings("unused")
	private Integer startIndex;//分页开始字段
	@SuppressWarnings("unused")
	private Integer endIndex;//分页结束字段
	private String username;//测试用属性
	
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	@Override
	public String toString() {
		return "Page [page=" + page + ", rows=" + rows + ", sort=" + sort
				+ ", order=" + order + "]";
	}
	
	//mysql limit (页数-1)*页面大小
	public Integer getStartIndex() {
		System.out.println("------------*************---------");
		return (getPage() - 1) * getRows();
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	
	//mysql limit 直接等于页面大小
	public Integer getEndIndex() {
		return getRows();
	}
	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}

