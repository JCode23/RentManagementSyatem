package com.ncit.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnectionImpl implements DatabaseConnection {

	@Override
	public Statement doConnection() {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbase_rms","root","phpcode");
			System.out.println("Connected to Mysql Database");
			
			statement = connection.createStatement();
			return statement;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statement;
	}

}
