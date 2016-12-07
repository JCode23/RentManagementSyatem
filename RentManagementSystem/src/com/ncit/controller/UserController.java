package com.ncit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncit.entity.User;
import com.ncit.model.UserService;
import com.ncit.model.impl.UserServiceImpl;

public class UserController extends HttpServlet {

	/**
	 * Skeleton of servlet
	 */
	private static final long serialVersionUID = 1L;
	ServletContext context;
	RequestDispatcher disp;

	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("Inside doPost of UserController !!");

		String userName = req.getParameter("user");
		String password = req.getParameter("pass");

		System.out.println("Username: " + userName);
		System.out.println("Password: " + password);

		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);

		UserService userService = new UserServiceImpl();

		boolean isValid = userService.isUserValid(user);

		if (isValid) {
			disp = context.getRequestDispatcher("/home.jsp");
		} else {
			disp = context.getRequestDispatcher("/index.jsp");
			
			String msg = "Username/Password mismatch";
			req.setAttribute("message", msg);
		}

		disp.forward(req, res);

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

}
