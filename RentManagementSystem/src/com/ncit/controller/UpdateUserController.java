package com.ncit.controller;

import java.io.IOException;
import java.util.List;

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

public class UpdateUserController extends HttpServlet{


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
		
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		
		User user = new User();
		user.setUserName(name);
		user.setAddress(address);
		user.setEmail(email);
		user.setId(userId);
		

		UserService userService = new UserServiceImpl();
		boolean isValid = userService.updateUser(user);
		
		if(isValid)
		{
			List<User> userList = userService.getAllUsers();
			
			disp = context.getRequestDispatcher("/view_users.jsp");
			req.setAttribute("allUserList", userList);
		}
		else{
			User user1 = userService.getUserById(userId);
			
			disp = context.getRequestDispatcher("/edit_user.jsp");
			req.setAttribute("User",user1);
		}
		disp.forward(req, res);

		

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
