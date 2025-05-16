package com.knotspot.model;

import java.time.LocalDate;

public class VenueModel {
	
	private int venueId;
	private String name;
	private String address;
	private String city;
	private String contactNumber;
	private int capacity;
	private String amenities;
	private String type;
	private LocalDate registeredDate;
	private String venuePic;
	private String status;
	
	public VenueModel(String name, String address, String city, String contactNumber, int capacity,
			String amenities, String type, String venuePic, String status) {

		this.name = name;
		this.address = address;
		this.city = city;
		this.contactNumber = contactNumber;
		this.capacity = capacity;
		this.amenities = amenities;
		this.type = type;
		this.registeredDate = LocalDate.now();
		this.venuePic = venuePic;
		this.status = status;
	}
	
	public VenueModel(int venueId, String name, String address, String city, String contactNumber, int capacity,
			String amenities, String type, LocalDate registeredDate, String venuePic, String status) {
		
		this.venueId = venueId;
		this.name = name;
		this.address = address;
		this.city = city;
		this.contactNumber = contactNumber;
		this.capacity = capacity;
		this.amenities = amenities;
		this.type = type;
		this.registeredDate = LocalDate.now();
		this.venuePic = venuePic;
		this.status = status;
	}


	public int getVenueId() {
		return venueId;
	}

	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public LocalDate getRegisteredDate() {
		return registeredDate;
	}

	public String getVenuePic() {
		return venuePic;
	}

	public void setVenuePic(String venuePic) {
		this.venuePic = venuePic;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
