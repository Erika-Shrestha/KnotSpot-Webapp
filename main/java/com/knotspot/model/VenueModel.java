package com.knotspot.model;

import java.time.LocalDate;

public class VenueModel {
	
	//attributes of venue
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
	
	/**
	 * a constructors that initialize the venue attributes
	 * @param name name of venue
	 * @param address address of venue
	 * @param city city of venue
	 * @param contactNumber contact number of venue
	 * @param capacity capacity of venue
	 * @param amenities properties of venue
	 * @param type type of venue
	 * @param venuePic selected image of venue
	 * @param status availability status of venue
	 */
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
	
	/**
	 *  a constructors that initialize the venue attributes with venue id
	 * @param venueId id of venue
	 * @param name name of venue
	 * @param address address of venue
	 * @param city city of venue
	 * @param contactNumber contact number of venue
	 * @param capacity capacity of venue
	 * @param amenities properties of venue
	 * @param type type of venue
	 * @param venuePic selected image of venue
	 * @param status availability status of venue
	 */
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

	/**
	 * getter method for venue id of venue attribute
	 * @return id of venue
	 */
	public int getVenueId() {
		return venueId;
	}

	/**
	 * sets the venue id for the venue attribute
	 * @param venueId integer value
	 */
	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}

	/**
	 * getter method for venue name of venue attribute
	 * @return name of venue
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets the venue name for the venue attribute
	 * @param name string value
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter method for venue address of venue attribute
	 * @return address of venue
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * sets the venue address for the venue attribute
	 * @param address string value
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * getter method for venue city of venue attribute
	 * @return city of venue
	 */
	public String getCity() {
		return city;
	}

	/**
	 * sets the venue city for the venue attribute
	 * @param city string value
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * getter method for venue contact number of venue attribute
	 * @return contact number of venue
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * sets the venue contact number for the venue attribute
	 * @param contactNumber string value
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	/**
	 * getter method for venue capacity of venue attribute
	 * @return capacity of venue
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * sets the venue capacity for the venue attribute
	 * @param capacity integer value
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * getter method for venue amenities of venue attribute
	 * @return amenities of venue
	 */
	public String getAmenities() {
		return amenities;
	}

	/**
	 * sets the venue amenities for the venue attribute
	 * @param amenities string value
	 */
	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	/**
	 * getter method for venue type of venue attribute
	 * @return type of venue
	 */
	public String getType() {
		return type;
	}

	/**
	 * sets the venue type for the venue attribute
	 * @param type string value
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * getter method for venue registered date of venue attribute
	 * @return registered date of venue
	 */
	public LocalDate getRegisteredDate() {
		return registeredDate;
	}

	/**
	 * getter method for venue picture of venue attribute
	 * @return picture of venue
	 */
	public String getVenuePic() {
		return venuePic;
	}

	/**
	 * sets the venue picture for the venue attribute
	 * @param venuePic string value 
	 */
	public void setVenuePic(String venuePic) {
		this.venuePic = venuePic;
	}

	/**
	 * getter method for venue availability status of venue attribute
	 * @return status of venue
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * sets the venue availability status for the venue attribute
	 * @param status string value
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
