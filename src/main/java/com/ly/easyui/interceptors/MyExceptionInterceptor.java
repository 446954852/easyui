package com.ly.easyui.interceptors;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.ly.easyui.exception.BaseException;

/**
 * 创建时间：2016年1月15日 上午12:15:16  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：ExceptionInterceptor.java  
 * 类说明：  无需注册到</mvc:interceptors> 只要抛出异常会自动拦截
 */

@ControllerAdvice
public class MyExceptionInterceptor implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3) {
		response.setCharacterEncoding("UTF-8"); 
//		response.setStatus(500);
		PrintWriter writer = null;
		ModelAndView mv = new ModelAndView();
		try {
			writer = response.getWriter();
			if(arg3 instanceof BaseException) {
				writer.write(arg3.getMessage());
			}
			else if(arg3 instanceof AuthorizationException){
				mv.setViewName("refuse");
				return mv;
			}
			else{
				writer.write("系统发生未知错误！");
			}
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

