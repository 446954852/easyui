package com.ly.easyui.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ly.easyui.util.CustomDateDeSerializer;
import com.ly.easyui.util.CustomDateSerializer;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 创建时间：2016年1月13日 下午9:42:45  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：User.java  
 * 类说明：  	通过下面两种方式都可以自定义JackSon序列化Json字符串日期问题
 * 			@JsonSerialize(using = CustomDateSerializer.class)
			@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
			
			
			@JsonDeserialize 前台json格式日期字符串反序列化到后台date
			
			
			默认前台日期字符串和后台Date交互使用springmvc.xml配置文件的默认格式yyyy-MM-dd HH:mm:ss(jackson序列化与反序列化)
			
			<mvc:annotation-driven conversion-service="conversionService">
				<!-- 处理responseBody 里面日期类型 -->  
		        <mvc:message-converters>  
		            <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">  
		                <property name="objectMapper">  
		                    <bean class="com.fasterxml.jackson.databind.ObjectMapper">  
		                        <property name="dateFormat">  
		                            <bean class="java.text.SimpleDateFormat">  
		                                <constructor-arg type="java.lang.String" value="yyyy-MM-dd HH:mm:ss" />  
		                            </bean>  
		                        </property>  
		                    </bean>  
		                </property>  
		            </bean>  
		        </mvc:message-converters>  
			</mvc:annotation-driven>
 */


//http://www.tuicool.com/articles/aYfaqa
@XmlRootElement(name="user")
//@XStreamAlias("user")
public class User extends BaseEntity {
	
	private static final long serialVersionUID = 6775344473251113619L;
	
//	@XStreamAsAttribute
//	@XStreamAlias("id")
	private Long userId;
//	@XStreamAsAttribute
//	@XStreamAlias("username")
	private String username;
//	@XStreamAsAttribute
//	@XStreamAlias("password")
	private String password;
	
	private Date createDateTime;
	private Date createDateTimeStart;
	private Date createDateTimeEnd;
	private Date modifyDateTime;
	private Date modifyDateTimeStart;
	private Date modifyDateTimeEnd;
//	@XStreamAsAttribute
//	@XStreamAlias("order")
	private String order;//测试用属性
	
	public User(){
		
	}
	
	public User(Long userId, String username, String password, String order) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.order = order;
	}
	
	@XmlElement(name="uid")
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@XmlElement
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@JsonSerialize(using = CustomDateSerializer.class)
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getCreateDateTime() {
		return createDateTime;
	}
	
	@JsonDeserialize(using = CustomDateDeSerializer.class)
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	public Date getCreateDateTimeStart() {
		return createDateTimeStart;
	}
	public void setCreateDateTimeStart(Date createDateTimeStart) {
		this.createDateTimeStart = createDateTimeStart;
	}
	public Date getCreateDateTimeEnd() {
		return createDateTimeEnd;
	}
	public void setCreateDateTimeEnd(Date createDateTimeEnd) {
		this.createDateTimeEnd = createDateTimeEnd;
	}
	
	//可以自动义配置@JsonSerialize覆盖springmvc配置
//	@JsonSerialize(using = CustomDateSerializer.class)
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getModifyDateTime() {
		return modifyDateTime;
	}
	
//	@JsonDeserialize(using = CustomDateDeSerializer.class)
	public void setModifyDateTime(Date modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}
	
	public Date getModifyDateTimeStart() {
		return modifyDateTimeStart;
	}
	public void setModifyDateTimeStart(Date modifyDateTimeStart) {
		this.modifyDateTimeStart = modifyDateTimeStart;
	}
	public Date getModifyDateTimeEnd() {
		return modifyDateTimeEnd;
	}
	public void setModifyDateTimeEnd(Date modifyDateTimeEnd) {
		this.modifyDateTimeEnd = modifyDateTimeEnd;
	}
	
	@XmlElement
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username
				+ ", password=" + password + ", createDateTime="
				+ createDateTime + ", createDateTimeStart="
				+ createDateTimeStart + ", createDateTimeEnd="
				+ createDateTimeEnd + ", modifyDateTime=" + modifyDateTime
				+ ", modifyDateTimeStart=" + modifyDateTimeStart
				+ ", modifyDateTimeEnd=" + modifyDateTimeEnd + "]";
	}
	
	@XmlElement
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	

	
}


