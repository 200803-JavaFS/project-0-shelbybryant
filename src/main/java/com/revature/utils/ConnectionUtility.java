package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {

	public static Connection getConnection() throws SQLException {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:postgresql://javatraining.cyq0oy2vijrb.us-east-2.rds.amazonaws.com:5432/project0";
		String username = "postgres";
		String password = "password";
		
		return DriverManager.getConnection(url, username, password);
	}
	
	//just a test
//	public static void main(String[] args) {
//		try(Connection conn = ConnectionUtility.getConnection()) {
//			System.out.println("connection successful");
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
	
	
	
	
}
