package com.knotspot.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.knotspot.config.DbConfig;
import com.knotspot.model.VenueModel;

public class SortService {

	//variable for connection
	private Connection conn;
	
	/**
	 * a constructor to check if the connection is made
	 */
	public SortService() {
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
	 * a list of venues object sorted by either ascend or descend order
	 * @param sortOrder values to be sorted
	 * @return a list of sorted venues
	 */
	public List<VenueModel> sortVenues(String sortOrder){
		
		List<VenueModel> venues = new ArrayList<>();
		if(conn == null) {
			System.out.println("DB connection failed");
		}
		
		if (!"ASC".equalsIgnoreCase(sortOrder) && !"DESC".equalsIgnoreCase(sortOrder)) {
	        sortOrder = "ASC";
	    }
		
		String sortSql = "SELECT venue_id, name, address, city, contact_no, capacity, amenities, type, registered_date, venue_picture, status FROM venues ORDER BY name"+" "+ sortOrder;
		
		try(PreparedStatement ps = conn.prepareStatement(sortSql)) {
			
			ResultSet i = ps.executeQuery();
			
			while(i.next()) {
				int venueId = i.getInt("venue_id");
				String name= i.getString("name");
				String address= i.getString("address");
				String city= i.getString("city");
				String contact= i.getString("contact_no");
				int capacity= i.getInt("capacity");
				String amenities= i.getString("amenities");
				String type= i.getString("type");
				String image = i.getString("venue_picture");
				String status = i.getString("status");
				VenueModel venue = new VenueModel(name, address, city, contact, capacity, amenities, type, image, status);
				venue.setVenueId(venueId);
				venues.add(venue);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return venues;
	}
}
