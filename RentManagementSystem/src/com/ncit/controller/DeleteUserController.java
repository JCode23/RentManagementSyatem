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

public class DeleteUserController extends HttpServlet {

	/**
	 * 
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

		System.out.println("Inside DeleteUserController !!");

		String id = req.getParameter("id");

		int userId = Integer.parseInt(id);

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String address = req.getParameter("address");

		User user = new User();
		user.setId(userId);
		user.setUserName(name);
		user.setEmail(email);
		user.setAddress(address);

		UserService userService = new UserServiceImpl();
		boolean isDeleted = userService.deleteUser(user);

		if (isDeleted) {
			List<User> userList = userService.getAllUsers();

			disp = context.getRequestDispatcher("/view_users.jsp");
			req.setAttribute("allUserList", userList);
		}
		disp.forward(req, res);
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
