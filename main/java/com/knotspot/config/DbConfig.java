package com.knotspot.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
	private static final String DB_NAME = "knotspot";
	private static final String url = "jdbc:mysql://localhost:3306/"+ DB_NAME;
	//by-default the username and password is root and empty
	private static final String username = "root";
	private static final String password = "";
	
	public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
		//step 1:register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");	
		//step 2: establish connection
		return DriverManager.getConnection(url, username, password);
	}
}
