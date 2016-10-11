package com.ly.easyui.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 创建时间：2016年4月27日 下午11:46:12  
 * 项目名称：easyui1.3.4  
 * @author liyong 
 * 文件名称：FileController.java  
 * 类说明：  文件上传下载导入导出
 */

@Controller
@RequestMapping("/fileController")
public class FileController extends ABaseController<Object> {

	/**
	 * IO方式下载
	 */
	@RequestMapping("/downloadFileIO")
	public void downloadFileIO(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.reset();
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		response.setHeader("Content-Disposition", "attachment;filename=aa.txt");
		response.setContentType("application/octet-stream; charset=utf-8");  
		bos.write(FileUtils.readFileToByteArray(new File("F:/test.txt")));
		bos.flush();
		bos.close();
	}
	
	/**
	 * springmvc的ResponseEntity方式下载
	 */
	@RequestMapping(value="/downloadFileRespEntity")
	public ResponseEntity<byte[]> downloadFileRespEntity(HttpServletResponse response) throws IOException{
		byte [] body = FileUtils.readFileToByteArray(new File("F:/rxsq.xls"));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=aa.xls");
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		ResponseEntity<byte[]> resp = new ResponseEntity<byte[]>(body, headers, HttpStatus.OK);
		return resp;
	}
	
	/**
	 * 前台onclick事件 以form表单形式submit	
	 */
	@RequestMapping("/downloadFileRespEntityOnClick")
	public ResponseEntity<byte[]> downloadFileRespEntityOnClick(HttpSession session) throws IOException{
		ServletContext servletContext = session.getServletContext();
		String realPath = servletContext.getRealPath("/");
		System.out.println(realPath);
		InputStream in = servletContext.getResourceAsStream("/WEB-INF/files/abc.txt");
		byte[] body = new byte[in.available()];
		in.read(body);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=aa.txt");
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		HttpStatus statusCode = HttpStatus.OK;
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
		return response;
	}
	
	
}

