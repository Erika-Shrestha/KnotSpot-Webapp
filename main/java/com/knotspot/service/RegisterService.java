package com.knotspot.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.knotspot.config.DbConfig;
import com.knotspot.model.UserModel;
import com.knotspot.util.PasswordUtil;

public class RegisterService {
private Connection conn;
	
	public RegisterService() {
		try {
			conn = DbConfig.getDbConnection();
		}catch(SQLException | ClassNotFoundException e){
			System.out.println("DB connection failed :" +e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Connection getConn() {
	    return conn;
	}
	
	public UserModel addUsers(UserModel users) {
		if(conn == null) {
			System.out.println("DB connection failed");
		}
		
		try {
			String hashedPassword = PasswordUtil.hashPassword(users.getPassword());
            users.setPassword(hashedPassword);
            
			PreparedStatement ps = conn.prepareStatement("INSERT INTO users(first_name, middle_name, last_name, age, gender, address, contact_no, email, username, password, profile_image, registered_date, role_id, task_id) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, users.getFirstName());
			ps.setString(2, users.getMiddleName());
			ps.setString(3, users.getLastName());
			ps.setInt(4, users.getAge());
			ps.setString(5, users.getGender());
			ps.setString(6, users.getAddress());
			ps.setString(7, users.getContactNumber());
			ps.setString(8, users.getEmail());
			ps.setString(9, users.getUsername());
			ps.setString(10,hashedPassword);
			ps.setString(11, users.getProfilePic());
			ps.setDate(12, java.sql.Date.valueOf(LocalDate.now()));
			ps.setString(13, users.getRole());
			ps.setString(14, "T1");
			
			int i = ps.executeUpdate();
			
			if(i>0) {
				System.out.println("Success");
				
			}
			else {
				System.out.println("not inserted");
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	
	public static boolean isDuplicated(String field, String attribute, Connection conn) throws SQLException{
		PreparedStatement ps = conn.prepareStatement("SELECT user_id FROM users WHERE "+attribute +" = ?");
		ps.setString(1, field);
		ResultSet i = ps.executeQuery();
		if(i.next()) {
			throw new SQLException(attribute+" is already taken");
		}
		return false;
	}
	

}
