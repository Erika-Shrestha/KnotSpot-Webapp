package com.knotspot.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.knotspot.config.DbConfig;
import com.knotspot.model.UserModel;

public class ProfileService {

		//variable for connection
	    private Connection conn;
	    
	    /**
		 * a constructor to check if the connection is made
		 */
	    public ProfileService() {
	        try {
	            conn = DbConfig.getDbConnection();
	        } catch (SQLException | ClassNotFoundException e) {
	            System.out.println("DB connection failed :" + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    
	    /**
	     * to sql query to update the existing user details
	     * @param user object for usermodel
	     * @return updating user object
	     */
	    public UserModel updateUserDetails(UserModel user) {
	        String updateSql = "UPDATE users SET first_name = ?, last_name = ?, username = ?, email = ?, contact_no = ?, gender = ?, profile_image = ? WHERE user_id = ?";
	        String selectSql = "SELECT u.first_name, u.last_name, u.username, u.email, u.contact_no, u.gender, u.role_id, u.profile_image, r.user_role FROM users u JOIN userrole r ON u.role_id = r.role_id WHERE u.user_id = ?";
	        
	        
	        try (PreparedStatement ps = conn.prepareStatement(updateSql)) {
	        	ps.setString(1, user.getFirstName()); 
	            ps.setString(2, user.getLastName());
	            ps.setString(3, user.getUsername()); 
	            ps.setString(4, user.getEmail());
	            ps.setString(5, user.getContactNumber());
	            ps.setString(6, user.getGender());
	            ps.setString(7, user.getProfilePic());
	            ps.setInt(8, user.getUserId());

	            int updateDetail = ps.executeUpdate();

	            if(updateDetail >0) {
	            	
	            	try (PreparedStatement selectPs = conn.prepareStatement(selectSql)){
	            		
	            		selectPs.setInt(1, user.getUserId());
	            		ResultSet i = selectPs.executeQuery();
	            		
	            		if(i.next()) {
	            			user.setFirstName(i.getString("u.first_name"));
	                        user.setLastName(i.getString("u.last_name"));
	                        user.setUsername(i.getString("u.username"));
	                        user.setEmail(i.getString("u.email"));
	                        user.setContactNumber(i.getString("u.contact_no"));
	                        user.setGender(i.getString("u.gender"));
	                        user.setRole(i.getString("u.role_id"));
	                        user.setProfilePic(i.getString("u.profile_image"));
	                        user.setRoleName(i.getString("r.user_role"));
	            		}
	            	}
	            	return user;
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();

	        }
			return user;

	    }
	    
	  /**
	   * Check duplicates excluding the current user
	   * @param field the field for which duplciate is checked
	   * @param attribute to display the named message
	   * @param conn to show the connection of database
	   * @param userId user id for which the duplciate is excluded
	   * @return boolean if the input is duplciate or not
	   * @throws SQLException handles request process
	   */
	    public static boolean isDuplicated(String field, String attribute, Connection conn, int userId) throws SQLException {
	        String query = "SELECT user_id FROM users WHERE " + attribute + " = ? AND user_id != ?";
	        try (PreparedStatement ps = conn.prepareStatement(query)) {
	            ps.setString(1, field);
	            ps.setInt(2, userId);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                throw new SQLException(attribute + " is already taken");
	            }
	            return false;
	        }
	    }
}
