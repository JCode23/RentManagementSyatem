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

public class UserRegisterController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ServletContext context;
	RequestDispatcher disp;
	
	@Override
	public void init(ServletConfig config ) throws ServletException
	{
		context = config.getServletContext();
	}
	
	@Override 
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		System.out.println("Inside doPost of UserRegisterController !!");
		
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		
		User user = new User();
		user.setUserName(name);
		user.setAddress(address);
		user.setEmail(email);
		user.setPassword(password);
		
		
		UserService userService = new UserServiceImpl();
		boolean isInserted = userService.insertUser(user);
		
		if(isInserted)
		{
			disp = context.getRequestDispatcher("/index.jsp");
		}
		else
		{
			disp = context.getRequestDispatcher("/register.jsp");
		}
		
		disp.forward(req, res);
		
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		doPost(req,res);
	}
	
	
	
}
