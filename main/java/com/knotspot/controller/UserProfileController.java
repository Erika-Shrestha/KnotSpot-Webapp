package com.knotspot.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.knotspot.model.UserModel;
import com.knotspot.service.ProfileService;
import com.knotspot.service.RegisterService;
import com.knotspot.util.ValidationUtil;

/**
 * Servlet implementation class UserProfile
 */

@MultipartConfig
@WebServlet(asyncSupported = true, urlPatterns = { "/profile" })
public class UserProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/Customer/userprofile.jsp").forward(request,response);
	}

	private boolean isValidInputs(HttpServletRequest request, HttpServletResponse response, String firstName, String lastName,  String email, String contact, String gender, String username, Part image)  throws ServletException, IOException {
		boolean isValid = true;
		isValid &= ValidationUtil.checkInputField(request, "firstname", firstName, "First Name");
		isValid &= ValidationUtil.checkInputField(request, "lastname", lastName, "Last Name");
		isValid &= ValidationUtil.checkInputField(request, "email", email, "Email");
		isValid &= ValidationUtil.checkInputField(request, "contact", contact, "Contact Number");
		isValid &= ValidationUtil.checkInputField(request, "gender", gender, "Gender");
		isValid &= ValidationUtil.checkInputField(request, "username", username, "Username");
		System.out.println("Validation passed? " + isValid);
		return isValid;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		updateUsers(request,response);
	}
	
	private void updateUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact_no");
		String gender = request.getParameter("gender");
		String username = request.getParameter("username");
		Part image = request.getPart("profile_image");
		String imageFilePath = image.getSubmittedFileName();
		System.out.println("Selected file name: "+imageFilePath);
		String uploadPath="C:/Users/eerii/eclipse-workspace/KnotSpot/src/main/webapp/resources/"+imageFilePath;
		System.out.println("uploaded file name: "+uploadPath);
		System.out.println("Retrieved data");

		boolean isValid = isValidInputs(request, response, firstName, lastName, email, contact, gender, username, image);
		
		if(isValid) {
			
			HttpSession session = request.getSession(false);
   			if (session == null || session.getAttribute("userModel") == null) {
   			    response.sendRedirect(request.getContextPath() + "/login");
   			    return;
   			}
   			UserModel user = (UserModel) session.getAttribute("userModel");
   			int userId = user.getUserId();
   			
			RegisterService registerService = new RegisterService();
			boolean isDuplicate = false;
			isDuplicate |= ValidationUtil.checkDuplicate(request, "email", email, "email", registerService.getConn(), userId);
   			isDuplicate |= ValidationUtil.checkDuplicate(request, "username", username, "username", registerService.getConn(), userId);
   			isDuplicate |= ValidationUtil.checkDuplicate(request, "contact", contact, "contact_no", registerService.getConn(), userId);
   			System.out.println("Duplication passed? " + isDuplicate);
   			
   			if(isDuplicate) {
   				request.setAttribute("first_name", firstName);
   				request.setAttribute("last_name", lastName);
   				request.setAttribute("email", email);
   				request.setAttribute("contact_no", contact);
   				request.setAttribute("gender", gender);
   				request.setAttribute("username", username);
   				request.getRequestDispatcher("/WEB-INF/pages/Customer/userprofile.jsp").forward(request, response);
   				return;
   			}
   			
   			user.setFirstName(firstName);
   			user.setLastName(lastName);
   			user.setEmail(email);
   			user.setContactNumber(contact);
   			user.setGender(gender);
   			user.setUsername(username);
   			
   			if(imageFilePath!=null &&!imageFilePath.isEmpty()) {
   				try {
   					FileOutputStream fos = new FileOutputStream(uploadPath);
   					InputStream is= image.getInputStream();
   					
   					byte[] data = new byte[is.available()];
   					is.read(data);
   					fos.write(data);
   					fos.close();
   					
   				}
   				catch(Exception e) {
   					e.printStackTrace();
   				}
   				user.setProfilePic(imageFilePath);
   			}
   			
   			//update in database
   			ProfileService profile = new ProfileService();
   			UserModel updatedUser = profile.updateUserDetails(user);
   			session.setAttribute("userModel", updatedUser);
   			request.setAttribute("userModel", updatedUser);
   			response.sendRedirect(request.getContextPath() + "/profile");
		}
		else {
			request.setAttribute("first_name", firstName);
			request.setAttribute("last_name", lastName);
			request.setAttribute("email", email);
			request.setAttribute("contact_no", contact);
			request.setAttribute("gender", gender);
			request.setAttribute("username", username);
			
			request.getRequestDispatcher("/WEB-INF/pages/Customer/userprofile.jsp").forward(request, response);
		}
	
	}

}
