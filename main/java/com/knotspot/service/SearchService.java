package com.knotspot.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.knotspot.config.DbConfig;
import com.knotspot.model.VenueModel;

public class SearchService {
	
private Connection conn;
	
	public SearchService() {
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
	
	public List<VenueModel> selectVenueByNameOrCity(String searchValue){
		
		List<VenueModel> venues = new ArrayList<>();
		if(conn == null) {
			System.out.println("DB connection failed");
		}
		
		String searchSql = "SELECT name, address, city, contact_no, capacity, amenities, type, registered_date, venue_picture, status FROM venues WHERE name LIKE ? OR city LIKE ?";
		
		try(PreparedStatement ps = conn.prepareStatement(searchSql)) {
			
			ps.setString(1, "%"+searchValue+"%");
			ps.setString(2, "%"+searchValue+"%");
			
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
				VenueModel venue = new VenueModel(name, address, city, contact, capacity, amenities, type, image, status);
				venues.add(venue);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return venues;
	}
}
