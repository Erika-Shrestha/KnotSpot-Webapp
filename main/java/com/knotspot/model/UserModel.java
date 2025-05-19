package com.knotspot.model;

import java.time.LocalDate;

public class UserModel {
	
	//attributes of user 
	private int userId;
	private String firstName;
	private String middleName;
	private String lastName;
	private int age;
	private String gender;
	private String address;
	private String contactNumber;
	private String email;
	private String username;
	private String password;
	private LocalDate registeredDate;
	private String role;
	private String profilePic;
	private String roleName;
	
	/**
	 * a constructors that initialize the user attributes
	 * @param firstName first name of user
	 * @param middleName middle name of user
	 * @param lastName last name of user
	 * @param age age of user
	 * @param gender gender of user
	 * @param address address of user
	 * @param contactNumber contact number of user
	 * @param email email address of user
	 * @param username username of user
	 * @param password password of user
	 * @param role role of user either admin or customer
	 * @param profilePic selected image of user
	 */
	public UserModel(String firstName, String middleName, String lastName, int age, String gender, String address,
			String contactNumber, String email, String username, String password, String role, String profilePic) {

		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.contactNumber = contactNumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.registeredDate = LocalDate.now();
		this.role = role;
		this.profilePic = profilePic;
	}


	/**
	 * a no parameter constructor
	 */
	public UserModel() {
		
	}

	/**
	 * getter method for user id
	 * @return user id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * sets the user id for user attribute
	 * @param userId integer value
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * getter method for user first name
	 * @return user first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * sets the user first name for user attribute
	 * @param firstName String value
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * getter method for user middle name
	 * @return user middle name
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * sets the user middle name for user attribute
	 * @param middleName string value
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * getter method for user last name
	 * @return user last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * sets the user last name for user attribute
	 * @param lastName string value
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * getter method for user age
	 * @return user age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * sets the user age for user attribute
	 * @param age integer value
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * getter method for user gender
	 * @return user gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * sets the user gender for user attribute
	 * @param gender string value
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * getter method for user address
	 * @return user address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * sets the user address for user attribute
	 * @param address string value
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * getter method for user contact number
	 * @return user contact number
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * sets the user contact number for user attribute
	 * @param contactNumber string value
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * getter method for user email
	 * @return user email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * sets the user email for user attribute
	 * @param email string value
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * getter method for username
	 * @return user username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * sets the user username for user attribute
	 * @param username string value
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * getter method for user password
	 * @return user password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * sets the user password for user attribute
	 * @param password string value
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * getter method for user registered date
	 * @return user registered date
	 */
	public LocalDate getRegisteredDate() {
		return registeredDate;
	}
	
	/**
	 * getter method for user role
	 * @return user role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * sets the user role for user attribute
	 * @param role string value
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * getter method for user picture
	 * @return user picture
	 */
	public String getProfilePic() {
		return profilePic;
	}
	
	/**
	 * sets the user profile picture for user attribute
	 * @param profilePic string value
	 */
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	/**
	 * getter method for user role name
	 * @return user role name
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * sets the user role name for user attribute
	 * @param roleName string value
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	



}
