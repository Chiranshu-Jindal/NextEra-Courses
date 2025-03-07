package com.course.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static final String url = "jdbc:mysql://localhost:3306/nextera_courses";
	private static final String user = "root";
	private static final String password = "Admin@123";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, user, password);

	}

}
