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
	
	/**
	 * establish database connection and driver
	 * @return the connection with url, username and password for the specific database "knotspot"
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
		//register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");	
		//establish connection
		return DriverManager.getConnection(url, username, password);
	}
}
