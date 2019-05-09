package com.wangdong.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wangdong.pojo.User;
import com.wangdong.service.UserService;
import com.wangdong.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserAddServlet
 */
@WebServlet("/UserAdd")
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service;
       
	@Override
	public void init() throws ServletException {
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    	service = ac.getBean("userServiceImpl",UserService.class);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		double account=Double.parseDouble(request.getParameter("account"));
		
		User user = new User();
		user.setName(name);
		user.setAccount(account);		
		
		service.addUser(user);
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		request.setAttribute("msg", "添加用户成功！");
		request.getRequestDispatcher("/user/user_add_success.jsp").forward(request, response);
	}

}
