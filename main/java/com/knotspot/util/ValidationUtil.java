package com.knotspot.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

import com.knotspot.service.CrudService;
import com.knotspot.service.ProfileService;
import com.knotspot.service.RegisterService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class ValidationUtil {
	/*
	 * Regular expression (Regex) for email, phone number, password and username
	 */
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@gmail\\.com$");
	private static final Pattern CONTACT_PATTERN = Pattern.compile("^98\\d{8}$");
	private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
	private static final Pattern USERNAME_PATTERN = Pattern.compile("^(?=.*[a-zA-Z])[a-zA-Z][a-zA-Z0-9_-]{3,19}$");
	private static final Pattern ALPHABETIC_PATTERN = Pattern.compile("^[A-Za-z\\s]+$");
	private static final Pattern ADDRESS_PATTERN = Pattern.compile("^[\\w\\s.,#\\-/]{1,200}$");
	private static final Pattern AMENITIES_PATTERN = Pattern.compile("^[A-Za-z0-9\\s,.-]{1,200}$");

	//to check if the field is null or empty
	public static void isNullorEmpty(String value, String attribute) {
		if(value == null || value.trim().isEmpty()) {
			throw new NullPointerException(attribute + " cannot be empty.");
		}
	}
	
	//to check if the field has alphabetic input
	public static void isAlphabet(String value, String attribute) {
		if(!ALPHABETIC_PATTERN.matcher(value).matches()) {
			throw new NumberFormatException(attribute+" must only have alphabetic character.");
		}
	}
	
	//to check duplicate values
	public static void isDuplicate(String compareValue1, String compareValue2) {
		if(compareValue1.equalsIgnoreCase(compareValue2)) {
			throw new IllegalArgumentException("Duplicate value found: " + compareValue2);
		}
	}
	
	
	//to check if the name field inputs are valid
	public static void isValidName(String name, String attribute) {
		isNullorEmpty(name, attribute);
		isAlphabet(name, attribute);
		if(name.length()<=4){
            throw new IllegalArgumentException(attribute +" is too short");
        }
		else if(name.length()>=100) {
			throw new IllegalArgumentException(attribute +" is too long");
		}
	}
	
	//to check if the email field input is valid
	public static void isValidEmail(String email, String attribute) {
		isNullorEmpty(email, attribute);
		if(!EMAIL_PATTERN.matcher(email).matches()) {
			throw new IllegalArgumentException("Invalid email format for: "+ attribute);
		}
	}
	
	//to check if the contact number field input is valid
	public static void isValidContact(String number, String attribute) {
		isNullorEmpty(number, attribute);
		if(!CONTACT_PATTERN.matcher(number).matches()) {
			throw new NumberFormatException(attribute +" must be of 10 digits and start with 98");
		}
	}
	
	//to check if the gender radio button is checked
	public static void isValidGender(String gender, String attribute) {
		isNullorEmpty(gender, attribute);
		if(!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
			throw new IllegalArgumentException(attribute +" must be either male or female"); 
		}
	}
	
	//to check whether the user age is above 18
	public static void isValidEntryAge(LocalDate dob, String attribute) {
		LocalDate current = LocalDate.now();
		if(Period.between(dob, current).getYears() < 18) {
			throw new IllegalArgumentException(attribute +" must be atleast 18 years old."); 
		}
	}
	
	//to check if the user name field input is valid
	public static void isValidUserName(String username, String attribute) {
		isNullorEmpty(username, attribute);
		if(!USERNAME_PATTERN.matcher(username).matches()) {
			throw new IllegalArgumentException(attribute +" must be in a proper format");  
		}
	}
	
	//to check whether the date is null
	public static void isValidDate(String dob, String attribute) {
		isNullorEmpty(dob, attribute);
	}
	
	
	//to check if two-step confirmation password matches
	public static void doPasswordsMatch(String password, String retypePassword, String attribute, String username) {
		isNullorEmpty(password, attribute);
		isNullorEmpty(retypePassword, attribute);
		if(!PASSWORD_PATTERN.matcher(password).matches()) {
			throw new IllegalArgumentException(attribute +" must be in a proper format.");
		}
		else if(!password.equals(retypePassword)) {
			throw new IllegalArgumentException("password and retype password do not match.");  
		}
		else if(password.equalsIgnoreCase(username)) {
			throw new IllegalArgumentException("Password cannot be similar to username");  
		}
		
	}
	
	//to check if the image file size has proper format and size
	public static void isValidImageExtension(Part imagePart) {
        if (imagePart == null || imagePart.getSubmittedFileName() == null) {
        	throw new IllegalArgumentException("No file uploaded.");
        }
        String fileName = imagePart.getSubmittedFileName().toLowerCase();
        if(!fileName.endsWith(".jpg") && !fileName.endsWith(".jpeg") && !fileName.endsWith(".png")) {
        	throw new IllegalArgumentException("Invalid image format. Only jpg, jpeg, png, are allowed.");
        }
        
    }
	
	//to check if the venue address input is valid
	public static void isValidVenueAddress(String address, String attribute) {
		isNullorEmpty(address, attribute);
		String trimmedAddress = address.trim();
		if (!ADDRESS_PATTERN.matcher(trimmedAddress).matches()) {
	        throw new IllegalArgumentException(attribute + " must contain only letters, numbers, spaces, and the characters.");
	    }
	    if (trimmedAddress.length() < 5) {
	        throw new IllegalArgumentException(attribute + " is too short (minimum 5 characters).");
	    } else if (trimmedAddress.length() > 200) {
	        throw new IllegalArgumentException(attribute + " is too long (maximum 200 characters).");
	    }
	}
	
	//to check if the venue amenities input is valid 
	public static void isValidVenueAmenities(String amenities, String attribute) {
		isNullorEmpty(amenities, attribute);
		String trimmedAmenities = amenities.trim();
		if (!AMENITIES_PATTERN.matcher(trimmedAmenities).matches()) {
	        throw new IllegalArgumentException(attribute + " must contain only letters, numbers, spaces, commas, and hyphens.");
	    }
	    if (trimmedAmenities.length() < 5) {
	        throw new IllegalArgumentException(attribute + " is too short (minimum 5 characters).");
	    } else if (trimmedAmenities.length() > 200) {
	        throw new IllegalArgumentException(attribute + " is too long (maximum 200 characters).");
	    }
	}
	
	//to differentiate methods for each venue fields
	public static void getInputVenueField(String field, String value, String attribute) {
		if(field.equalsIgnoreCase("name")) {
			ValidationUtil.isValidName(value, attribute);
		}
		else if(field.equalsIgnoreCase("contact")) {
			ValidationUtil.isValidContact(value, attribute);		
		}
		else if(field.equalsIgnoreCase("address")) {
			ValidationUtil.isValidVenueAddress(value, attribute);
		}
		else if(field.equalsIgnoreCase("amenities")) {
			ValidationUtil.isValidVenueAmenities(value, attribute);
		}
	}
	
	public static boolean checkInputVenueField(HttpServletRequest request, String field, String value, String attribute) {
		boolean isValid = true;
		try {
			getInputVenueField(field, value, attribute);
		}
		catch(NullPointerException | IndexOutOfBoundsException | IllegalArgumentException e) {
			request.setAttribute(field+"Error", e.getMessage());
			System.out.println(e.getMessage());
			isValid = false;
		}
		return isValid;
	}
	
	//retreive duplicate field for venue details
	public static void getDuplicateVenueField(String field, String value, String attribute,Connection conn, int venueId) throws SQLException {
		  if(field.equalsIgnoreCase("contact")) {
			  CrudService.isDuplicated(value, attribute, conn, venueId);
		  }
	  }
	
	//retreive duplicate field for venue details
		public static void getDuplicateVenueField(String field, String value, String attribute,Connection conn) throws SQLException {
			  if(field.equalsIgnoreCase("contact")) {
				  CrudService.isDuplicated(value, attribute, conn);
			  }
		  }
	
	//check duplicate check for venue
	public static boolean checkDuplicateVenue(HttpServletRequest request, String field, String value, String attribute, Connection conn, int venueId) {
		  boolean isDuplicate = false;
		  try {
			  getDuplicateVenueField(field, value, attribute, conn, venueId);
		  }
		  catch(SQLException e) {
			  request.setAttribute(field+"Duplicate", e.getMessage());
			  System.out.println(e.getMessage());
			  isDuplicate= true;
		  }
		  return isDuplicate;
	  }
	
	//check duplicate check for venue
		public static boolean checkDuplicateVenue(HttpServletRequest request, String field, String value, String attribute, Connection conn) {
			  boolean isDuplicate = false;
			  try {
				  getDuplicateVenueField(field, value, attribute, conn);
			  }
			  catch(SQLException e) {
				  request.setAttribute(field+"Duplicate", e.getMessage());
				  System.out.println(e.getMessage());
				  isDuplicate= true;
			  }
			  return isDuplicate;
		  }
	
	//to differentiate methods for each user fields
		public static void getInputField(String field, String value, String attribute) {
			if(field.equalsIgnoreCase("firstname") || field.equalsIgnoreCase("lastname")) {
				ValidationUtil.isValidName(value, attribute);
			}
			else if(field.equalsIgnoreCase("dob")) {
				ValidationUtil.isValidEntryAge(LocalDate.parse(value), attribute);
			}
			else if(field.equalsIgnoreCase("gender")) {
				ValidationUtil.isValidGender(value, attribute);
			}
			else if(field.equalsIgnoreCase("contact")) {
				ValidationUtil.isValidContact(value, attribute);		
			}
			else if(field.equalsIgnoreCase("email")) {
				ValidationUtil.isValidEmail(value, attribute);
			}
			else if(field.equalsIgnoreCase("username")) {
				ValidationUtil.isValidUserName(value, attribute);
			}
		}
		
		  public static void getDuplicateField(String field, String value, String attribute,Connection conn) throws SQLException {
			  if(field.equalsIgnoreCase("contact")) {
				  RegisterService.isDuplicated(value, attribute, conn);
			  }
			  else if(field.equalsIgnoreCase("email")) {
				  RegisterService.isDuplicated(value, attribute, conn);
			  }
			  else if(field.equalsIgnoreCase("username")) {
				  RegisterService.isDuplicated(value, attribute, conn);
			  }
		  }
		  
		  public static boolean checkDuplicate(HttpServletRequest request, String field, String value, String attribute, Connection conn) {
			  boolean isDuplicate = false;
			  try {
				  getDuplicateField(field, value, attribute, conn);
			  }
			  catch(SQLException e) {
				  request.setAttribute(field+"Duplicate", e.getMessage());
				  System.out.println(e.getMessage());
				  isDuplicate= true;
			  }
			  return isDuplicate;
		  }
		  
		  public static void getDuplicateField(String field, String value, String attribute, Connection conn, int userId) throws SQLException {
		        if (field.equalsIgnoreCase("contact")) {
		            ProfileService.isDuplicated(value, "contact_no", conn, userId);
		        } else if (field.equalsIgnoreCase("email")) {
		        	ProfileService.isDuplicated(value, "email", conn, userId);
		        } else if (field.equalsIgnoreCase("username")) {
		        	ProfileService.isDuplicated(value, "username", conn, userId);
		        }
		    }
		  
		  public static boolean checkDuplicate(HttpServletRequest request, String field, String value, String attribute, Connection conn, int userId) {
		        boolean isDuplicate = false;
		        try {
		            getDuplicateField(field, value, attribute, conn, userId);
		        } catch (SQLException e) {
		            request.setAttribute(field + "Duplicate", e.getMessage());
		            System.out.println(e.getMessage());
		            isDuplicate = true;
		        }
		        return isDuplicate;
		    }
		  
		  
		
			public static boolean checkInputField(HttpServletRequest request, String field, String value, String attribute) {
				boolean isValid = true;
				try {
					getInputField(field, value, attribute);
				}
				catch(NullPointerException | IndexOutOfBoundsException | IllegalArgumentException e) {
					request.setAttribute(field+"Error", e.getMessage());
					System.out.println(e.getMessage());
					isValid = false;
				}
				return isValid;
			}
			
			
				public static boolean checkPasswordField(HttpServletRequest request, String password, String retypePassword, String attribute, String username) {
					boolean isValid = true;
					
					
					try {
						ValidationUtil.doPasswordsMatch(password, retypePassword, attribute, username);
					}
					catch(NullPointerException | IndexOutOfBoundsException | IllegalArgumentException e) {
						request.setAttribute("passwordError", e.getMessage());
						isValid = false;
					}
					return isValid;
				}
				
				public static boolean checkImageField(HttpServletRequest request, String attribute, Part imagePart) {
				    boolean isValid = true;
				    try {
				        ValidationUtil.isValidImageExtension(imagePart);
				    } catch (IllegalArgumentException e) {
				        request.setAttribute(attribute + "Error", e.getMessage());
				        isValid = false;
				    }
				    return isValid;
				}

	

}
