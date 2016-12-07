package com.ncit.model.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ncit.dbconnection.DatabaseConnection;
import com.ncit.dbconnection.DatabaseConnectionImpl;
import com.ncit.entity.User;
import com.ncit.model.UserService;

public class UserServiceImpl implements UserService {

	DatabaseConnection dbConnection = new DatabaseConnectionImpl();

	@Override
	public boolean isUserValid(User user) {

		// Create a statement
		Statement stmt = dbConnection.doConnection();

		// Execute SQL query
		String query = "SELECT * from users where user_name = '" + user.getUserName() + "' and password = '"
				+ user.getPassword() + "'";

		try {
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		/*
		 * if(user.getUserName().equals("Ram") &&
		 * user.getPassword().equals("ram123")) { return true; }
		 */

		return false;
	}

	@Override
	public List<User> getAllUsers() {
		// Create a statement
		Statement stmt = dbConnection.doConnection();

		String sql = "SELECT * from users";

		List<User> userList = new ArrayList<User>();

		try {
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("user_name"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));

				userList.add(user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList;
	}

	@Override
	public boolean insertUser(User user) {

		String sql = "INSERT into users (user_name, address, password, email) VALUES ('" + user.getUserName() + "','"
				+ user.getAddress() + "','" + user.getPassword() + "','" + user.getEmail() + "')";

		Statement stmt = dbConnection.doConnection();

		try {
			stmt.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUserById(int id) {
		Statement stmt = dbConnection.doConnection();

		String sql = "SELECT * from users where id = '" + id + "'";

		User user = new User();

		try {
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("user_name"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean updateUser(User user) {

		Statement stmt = dbConnection.doConnection();

		String sql = "UPDATE  users set user_name = '" + user.getUserName() + "', address = '" + user.getAddress()
				+ "', email = '" + user.getEmail() + "', password = '" + user.getPassword() + "' where id = '"
				+ user.getId() + "'";

		try {
			stmt.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(User user) {

		Statement stmt = dbConnection.doConnection();

		String sql = "DELETE FROM users where id = '" + user.getId() + "'";

		try {
			stmt.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}