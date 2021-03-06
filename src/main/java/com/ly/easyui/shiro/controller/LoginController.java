package com.ly.easyui.shiro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ly.easyui.exception.CustomException;
import com.ly.easyui.shiro.service.SysService;


/**
 * 
 * <p>Title: LoginController</p>
 * <p>Description: 登陆和退出</p>
 * @date	2015-3-22下午4:43:26
 * @version 1.0
 */
@Controller
public class LoginController {
	
	@Autowired
	private SysService sysService;
//	
//	/**
//	 * <p>Description:用户登陆提交方法 </p>
//	 * @param randomcode 输入的验证码
//	 * @param usercode 用户账号
//	 * @param password 用户密码 
//	 */
//	@RequestMapping("/login")
//	public String login(HttpSession session, String randomcode,String usercode,String password)throws Exception{
//		
//		//校验验证码，防止恶性攻击
//		//从session获取正确验证码
//		String validateCode = (String) session.getAttribute("validateCode");
//		
//		//输入的验证和session中的验证进行对比 
//		if(!randomcode.equals(validateCode)){
//			//抛出异常
//			throw new CustomException("验证码输入错误");
//		}
//		
//		//调用service校验用户账号和密码的正确性
//		ActiveUser activeUser = sysService.authenticat(usercode, password);
//		
//		//如果service校验通过，将用户身份记录到session
//		session.setAttribute("activeUser", activeUser);
//		//返回首页
////		return "index";//这种地址栏还是login不雅观
//		return "redirect:index";//这种地址栏变成index
////		return "redirect:/index.html";
//	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpSession session)throws Exception {
		//如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		//根据shiro返回的异常类路径判断，抛出指定异常信息
		if(exceptionClassName!=null){
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				//最终会抛给异常处理器
				throw new CustomException("账号不存在");
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				throw new CustomException("用户名/密码错误");
			} else if("randomCodeError".equals(exceptionClassName)){
				throw new CustomException("验证码错误 ");
			}else {
				throw new Exception();//最终在异常处理器生成未知错误
			}
		}
		//此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
		//登陆失败还到login页面		
		//重定向到欢迎或者登陆页面
//		StringBuffer requestURL = request.getRequestURL();
//		return "redirect:login.jsp";
		return "login";
	}
	
	
	/*	交给shiro的loginout过滤器处理 会自动清除session 并且默认跳转的路径是"/"
	//用户退出
	@RequestMapping("/logout")
	public String logout(HttpSession session)throws Exception{
		//session失效
		session.invalidate();
		//重定向到欢迎或者登陆页面
		return "redirect:login.jsp";
		
	}
	*/

}
