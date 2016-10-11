package com.ly.easyui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ly.easyui.constants.DateFormat;
import com.ly.easyui.dao.UserMapper;
import com.ly.easyui.exception.UserException;
import com.ly.easyui.model.Page;
import com.ly.easyui.model.User;

/**
 * 创建时间：2015年12月20日 下午2:43:46  
 * 项目名称：springmvc  
 * @author liyong 
 * 文件名称：TestDB.java  
 * 类说明：  通过数据库连接 测试spring的替换属性占位符(@Value注解的SpEl表达式也可以使用$占位符)
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestDB {
	
	@Resource
	private DataSource dataSource;
	
	@Resource
	private UserMapper userMapper;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${c3p0.pool.size.max}")
	private int max;
	
	@Test
	public void testDBPlaceholder() throws SQLException {
		//ComboPooledDataSource
		System.out.println("test" + max);
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from user u");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			System.out.println(rs.getObject(2));
		}
		System.out.println(url);
	}
	
	@Test
	@Transactional(readOnly = false, rollbackFor = RuntimeException.class)
	public void testRollback() throws UserException {
		User user = new User();
		user.setUsername("9999");
//		userMapper.saveUser(user);
		int i = 0;
		if(i == 0) {
			throw new UserException("注册失败&成功");
		}
	}
	
	@Test
	public void findAllUsers() throws Exception{
		System.out.println(userMapper);
		List<User> users = userMapper.findAllUsers(null);
		System.out.println(users);
		System.out.println(new ObjectMapper().writeValueAsString(users));
	}
	
	@Test
	public void findAllUserResult() throws ParseException{
		User u = new User();
//		u.setUsername("admin");
		u.setCreateDateTimeStart(DateFormat.yyyyMMddHHmmss.parse("2015-12-28 01:25:47"));
		Page page = new Page();
		page.setPage(1);
		page.setRows(5);
		page.setOrder("desc");
		page.setSort("userid");
//		List<User> users = userMapper.findAllUserResult(u, page);
		List<User> users = new ArrayList<>(9);
		for (User user : users) {
			System.out.println(user);
		}
		System.out.println(users.size());
		System.out.println(users);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}

}

