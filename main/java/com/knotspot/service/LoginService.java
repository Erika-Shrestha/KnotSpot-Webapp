package com.knotspot.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.knotspot.config.DbConfig;
import com.knotspot.model.UserModel;
import com.knotspot.util.PasswordUtil;

public class LoginService {
private Connection conn;	//Declare a variable to store the sql connection imported from config class
	
	
	/**
	 * A constructor to handle database connection 
	 * checks whether database is successfully connected 
	 */
	public LoginService() {
		try {
			conn = DbConfig.getDbConnection();
		}catch(SQLException | ClassNotFoundException e){
			System.out.println("DB connection failed :" +e.getMessage());
			e.printStackTrace();
		}
	}
	
	public UserModel retreiveUsers(UserModel users) {
		if(conn == null) {
			System.out.println("DB connection failed");
		}
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT u.user_id, u.first_name, u.last_name, u.password, u.role_id, u.profile_image, u.contact_no, u.email, u.gender, r.user_role FROM users u JOIN userrole r ON u.role_id = r.role_id WHERE username = ?");
			
			ps.setString(1, users.getUsername());

			
			ResultSet i = ps.executeQuery();
			
			if(i.next()) {
				int storedUserId = i.getInt("u.user_id");
				String storedFirstName = i.getString("u.first_name");
				String storedLastName = i.getString("u.last_name");
				String storedPassword = i.getString("u.password");
				String storedRole = i.getString("u.role_id");
				String storedprofileImagePath = i.getString("u.profile_image");
				String storedContactNumber = i.getString("u.contact_no");
				String storedEmail = i.getString("u.email");
				String storedGender = i.getString("u.gender");
				String storedRoleName = i.getString("r.user_role");
				
				if(PasswordUtil.checkPassword(users.getPassword(), storedPassword)) {
					System.out.println("Logged in succesfully");
					users.setUserId(storedUserId);
					users.setFirstName(storedFirstName);
					users.setLastName(storedLastName);
					users.setRole(storedRole);
					users.setProfilePic(storedprofileImagePath);
					users.setContactNumber(storedContactNumber);
					users.setEmail(storedEmail);
					users.setGender(storedGender);
					users.setRoleName(storedRoleName);
					
					return users;
				}
				else {
					System.out.println("Incorrect password");
					return null;
				}
			}
			else {
				System.out.println("User not found");
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
		
	}
}
