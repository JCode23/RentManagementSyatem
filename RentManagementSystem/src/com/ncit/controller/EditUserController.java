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

public class EditUserController extends HttpServlet {

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

		System.out.println("Inside doPost of EditUserController !!");
		
		String id = req.getParameter("id");
	
		int userId = Integer.parseInt(id);
		
		UserService userService = new UserServiceImpl();
		User user = userService.getUserById(userId);
		
		disp = context.getRequestDispatcher("/edit_user.jsp");
		req.setAttribute("User",user);
		disp.forward(req, res);
		

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

}
