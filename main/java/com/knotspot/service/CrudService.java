package com.knotspot.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.knotspot.config.DbConfig;
import com.knotspot.model.VenueModel;

public class CrudService {

	private Connection conn;
	
	public CrudService() {
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
	
	//add query for venue table
	public VenueModel addVenue(VenueModel venues) {
		if(conn == null) {
			System.out.println("DB connection failed");
		}
		
		try {
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO venues(name, address, city, contact_no, capacity, amenities, type, registered_date, venue_picture, status) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, venues.getName());
			ps.setString(2, venues.getAddress());
			ps.setString(3, venues.getCity());
			ps.setString(4, venues.getContactNumber());
			ps.setInt(5, venues.getCapacity());
			ps.setString(6, venues.getAmenities());
			ps.setString(7, venues.getType());
			ps.setDate(8, java.sql.Date.valueOf(LocalDate.now()));
			ps.setString(9, venues.getVenuePic());
			ps.setString(10, venues.getStatus());
			
			int i = ps.executeUpdate();
						
				if(i>0) {
					System.out.println("Success");
					return venues;
					
				}
				else {
					System.out.println("not inserted");
					return null;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	//update query for venue table
	public boolean deleteVenue(int venueId) {
		if(conn == null) {
			System.out.println("DB connection failed");
		}
		
		try {
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM venues WHERE venue_id = ?");
			ps.setInt(1, venueId);
			
			int i = ps.executeUpdate();
			
			if(i>0) {
				System.out.println("Success");
				return true;
				
			}
			else {
				System.out.println("not inserted");
				return false;
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	//query to update venue table
	public VenueModel updateVenue(VenueModel venues) {
		if(conn == null) {
			System.out.println("DB connection failed");
		}
		
		String updateSql = "UPDATE venues SET name = ?, address = ?, city = ?, contact_no = ?, capacity = ?, amenities = ?, type = ?, venue_picture = ?, status = ? WHERE venue_id = ?";
		String selectSql = "SELECT name, address, city, contact_no, capacity, amenities, type, venue_picture, status FROM venues WHERE venue_id = ?";
		
		try (PreparedStatement updatePs = conn.prepareStatement(updateSql)){
			
			updatePs.setString(1, venues.getName());
			updatePs.setString(2, venues.getAddress());
			updatePs.setString(3, venues.getCity());
			updatePs.setString(4, venues.getContactNumber());
			updatePs.setInt(5, venues.getCapacity());
			updatePs.setString(6, venues.getAmenities());
			updatePs.setString(7, venues.getType());
			updatePs.setString(8, venues.getVenuePic());
			updatePs.setString(9, venues.getStatus());
			updatePs.setInt(10, venues.getVenueId());
			
			int updateDetail = updatePs.executeUpdate();
			
			if(updateDetail > 0) {
				
				try (PreparedStatement selectPs = conn.prepareStatement(selectSql)){
					
					selectPs.setInt(1, venues.getVenueId());
	        		ResultSet i = selectPs.executeQuery();
	        		
	        		if(i.next()) {
	        			venues.setName(i.getString("name"));
	    				venues.setAddress(i.getString("address"));
	    				venues.setCity(i.getString("city"));
	    				venues.setContactNumber(i.getString("contact_no"));
	    				venues.setCapacity(i.getInt("capacity"));
	    				venues.setAmenities(i.getString("amenities"));
	    				venues.setType(i.getString("type"));
	    				venues.setVenuePic(i.getString("venue_picture"));
	    				venues.setStatus(i.getString("status"));
	        		}
				}
				return venues;
                
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return venues;
	
	}
	
	
	public List<VenueModel> selectAllVenues() {
		List<VenueModel> venues = new ArrayList<>();
		if(conn == null) {
			System.out.println("DB connection failed");
		}
		
		try {
			
			PreparedStatement ps = conn.prepareStatement("SELECT venue_id, name, address, city, contact_no, capacity, amenities, type, registered_date, venue_picture, status FROM venues");
			
			ResultSet i = ps.executeQuery();
			
			while(i.next()) {
				int id= i.getInt("venue_id");
				String name= i.getString("name");
				String address= i.getString("address");
				String city= i.getString("city");
				String contact= i.getString("contact_no");
				int capacity= i.getInt("capacity");
				String amenities= i.getString("amenities");
				String type= i.getString("type");
				LocalDate registeredDate = i.getDate("registered_date").toLocalDate();
				String image = i.getString("venue_picture");
				String status = i.getString("status");
				VenueModel venue = new VenueModel(id, name, address, city, contact, capacity, amenities, type, registeredDate, image, status);
				venues.add(venue);
				System.out.println("Fetched Venue: " + i.getString("name"));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Fetched venues: " + venues.size());
		return venues;
	}
	
	public VenueModel selectVenueById(int venueId) {
		if(conn == null) {
			System.out.println("DB connection failed");
		}
		
		VenueModel venue = null;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement("SELECT name, address, city, contact_no, capacity, amenities, type, venue_picture, status FROM venues WHERE venue_id = ?");
			ps.setInt(1, venueId);
			
			ResultSet i = ps.executeQuery();
			
			while(i.next()) {
				String name= i.getString("name");
				String address= i.getString("address");
				String city= i.getString("city");
				String contact= i.getString("contact_no");
				int capacity= i.getInt("capacity");
				String amenities= i.getString("amenities");
				String type= i.getString("type");
				String image = i.getString("venue_picture");
				String status = i.getString("status");
				venue = new VenueModel(name, address, city, contact, capacity, amenities, type, image, status);
				venue.setVenueId(venueId);
				System.out.println("Fetched Venue: " + venueId);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return venue;
	}
	
	//Check duplicates
	public static boolean isDuplicated(String field, String attribute, Connection conn) throws SQLException{
		PreparedStatement ps = conn.prepareStatement("SELECT venue_id FROM venues WHERE "+attribute +" = ?");
		ps.setString(1, field);
		ResultSet i = ps.executeQuery();
		if(i.next()) {
			throw new SQLException(attribute+" is already taken");
		}
		return false;
	}
	
	//Check duplicates excluding the current venue
    public static boolean isDuplicated(String field, String attribute, Connection conn, int venueId) throws SQLException {
        String query = "SELECT venue_id FROM venues WHERE " + attribute + " = ? AND venue_id != ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, field);
            ps.setInt(2, venueId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                throw new SQLException(attribute + " is already taken");
            }
            return false;
        }
    }
	
	
}
