package com.knotspot.model;

import java.time.LocalDate;

public class UserModel {
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



	public UserModel() {
		
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public LocalDate getRegisteredDate() {
		return registeredDate;
	}
	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}



	public String getRoleName() {
		return roleName;
	}



	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	



}
