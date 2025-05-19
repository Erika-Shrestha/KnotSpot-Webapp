package com.knotspot.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.knotspot.config.DbConfig;
import com.knotspot.model.UserModel;
import com.knotspot.model.VenueModel;
import com.knotspot.util.PasswordUtil;

public class RegisterService {
	
	//variable for connection
	private Connection conn;
	
	/**
	 * a constructor to check if the connection is made
	 */
	public RegisterService() {
		try {
			conn = DbConfig.getDbConnection();
		}catch(SQLException | ClassNotFoundException e){
			System.out.println("DB connection failed :" +e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * a getconnection 
	 * @return the database connection
	 */
	public Connection getConn() {
	    return conn;
	}
	
	/**
	 * query to add the user to the database and object
	 * @param users object for usermodel
	 * @return object users for which is added
	 */
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
	
	/**
	 * Check duplicates
	 * @param field the field for which duplciate is checked
	 * @param attribute to display the named message
	 * @param conn to show the connection of database
	 * @return boolean if the input is duplciate or not
	 * @throws SQLException handles request process
	 */
	public static boolean isDuplicated(String field, String attribute, Connection conn) throws SQLException{
		PreparedStatement ps = conn.prepareStatement("SELECT user_id FROM users WHERE "+attribute +" = ?");
		ps.setString(1, field);
		ResultSet i = ps.executeQuery();
		if(i.next()) {
			throw new SQLException(attribute+" is already taken");
		}
		return false;
	}
	
	/**
	 * selects the customers according to their roles
	 * @return a list of customers only
	 */
	public List<UserModel> selectCustomers() {
		List<UserModel> users = new ArrayList<>();
		String isCustomerSql = "SELECT first_name, last_name, email, profile_image FROM users WHERE role_id = 'RL2' ORDER BY registered_date DESC";
		try {
			PreparedStatement ps = conn.prepareStatement(isCustomerSql);
			ResultSet i = ps.executeQuery();
			
			while(i.next()) {
				String firstName= i.getString("first_name");
				String lastName= i.getString("last_name");
				String email= i.getString("email");
				String profilePic= i.getString("profile_image");
				UserModel user = new UserModel();

	            user.setFirstName(firstName);
	            user.setLastName(lastName);
	            user.setEmail(email);
	            user.setProfilePic(profilePic);

	            users.add(user);

			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	/**
	 * selects the admins according to their roles
	 * @return a list of admins only
	 */
	public List<UserModel> selectAdmins() {
		List<UserModel> users = new ArrayList<>();
		String isCustomerSql = "SELECT first_name, last_name, email, profile_image FROM users WHERE role_id = 'RL1' ORDER BY registered_date ASC";
		try {
			PreparedStatement ps = conn.prepareStatement(isCustomerSql);
			ResultSet i = ps.executeQuery();
			
			while(i.next()) {
				String firstName= i.getString("first_name");
				String lastName= i.getString("last_name");
				String email= i.getString("email");
				String profilePic= i.getString("profile_image");
				UserModel user = new UserModel();

	            user.setFirstName(firstName);
	            user.setLastName(lastName);
	            user.setEmail(email);
	            user.setProfilePic(profilePic);

	            users.add(user);

			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	/**
	 * selects the users according to their registration date
	 * @return a list of user objects with their registered date 
	 */
	public List<Object[]> getDailyRegistration(){
		List<Object[]> lineGraph = new ArrayList<>();
	    String registerGraphSql = "SELECT DATE_FORMAT(registered_date, '%b %d') AS reg_date, COUNT(*) AS user_count FROM users WHERE role_id = 'RL2' GROUP BY DATE(registered_date) ORDER BY reg_date ASC";
	    try {
	        PreparedStatement ps = conn.prepareStatement(registerGraphSql);
	        ResultSet i = ps.executeQuery();
	        while (i.next()) {
	            Object[] row = new Object[2];
	            row[0] = i.getString("reg_date"); 
	            row[1] = i.getInt("user_count"); 
	            lineGraph.add(row);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return lineGraph;

	}

}
