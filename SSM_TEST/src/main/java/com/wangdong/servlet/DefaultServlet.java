package com.wangdong.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wangdong.pojo.User;
import com.wangdong.service.UserService;


@WebServlet("/index")
public class DefaultServlet extends HttpServlet {
	
	
	private UserService service;
	
	@Override
	public void init() throws ServletException {
		
	}
	

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter p = res.getWriter();
		List<User> users = service.getAllUsers();
		for (User user : users) {
			p.println(user.toString());
		}
	}
}
