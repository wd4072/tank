package com.wangdong.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wangdong.service.UserService;

@WebServlet("/user/user_list")
public class UsersServlet extends HttpServlet {
	private UserService service;
	@Override
	public void init() throws ServletException {
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		service = ac.getBean("userServiceImpl",UserService.class);		
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("users", service.getAllUsers());
		req.setCharacterEncoding("utf-8");
		req.getRequestDispatcher("/user/user_list.jsp").forward(req, resp);
	}
}
