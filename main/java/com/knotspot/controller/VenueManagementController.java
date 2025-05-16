package com.knotspot.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.knotspot.model.VenueModel;
import com.knotspot.service.CrudService;
import com.knotspot.util.ValidationUtil;

/**
 * Servlet implementation class VenueManagementController
 */
@MultipartConfig
@WebServlet(asyncSupported = true, urlPatterns = { "/management" })
public class VenueManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("Form action value: " + action);
		
		if(action==null) {
			allVenues(request, response);
		}
		else {
			switch (action) {
	        case "create":
	            createNewVenue(request, response);
	            break;

	        case "delete":
	            removeVenue(request, response);
	            break;

	        case "update":
	            updateVenue(request, response);
	            break;
	            
	        case "edit":
	            venueById(request, response);
	            break;
	            
	        default:
	            allVenues(request, response);
	            break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	private boolean isValidInputs(HttpServletRequest request, HttpServletResponse response, String venueName, String venueAddress, String contactNumber, String amenities, Part venueImage)  throws ServletException, IOException {
		boolean isValid = true;
		
		isValid &= ValidationUtil.checkInputVenueField(request, "name", venueName, "Venue Name");
	    isValid &= ValidationUtil.checkInputVenueField(request, "address", venueAddress, "Venue Address");
	    isValid &= ValidationUtil.checkInputVenueField(request, "contact", contactNumber, "Contact Number");
	    isValid &= ValidationUtil.checkInputVenueField(request, "amenities", amenities, "Amenities");
	    
		
		return isValid;
	}
	
	private void createNewVenue(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String venueName = request.getParameter("venue_name");
		String venueAddress = request.getParameter("address");
		String venueCity = request.getParameter("city");
		String contactNumber = request.getParameter("contact");
		int venueCapacity = Integer.parseInt(request.getParameter("capacity"));
		String amenities = request.getParameter("amenities");
		String venueType = request.getParameter("venue_type");
		String status = request.getParameter("status");
		Part venueImage = request.getPart("venue_image");
		String imageFilePath = venueImage.getSubmittedFileName();
		System.out.println("Selected file name: "+imageFilePath);
		String uploadPath="C:/Users/eerii/eclipse-workspace/KnotSpot/src/main/webapp/resources/"+imageFilePath;
		System.out.println("uploaded file name: "+uploadPath);
		System.out.println("Retrieved data");
		
		try {
			FileOutputStream fos = new FileOutputStream(uploadPath);
			InputStream is= venueImage.getInputStream();
			
			byte[] data = new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		boolean isValid = isValidInputs(request, response, venueName, venueAddress, contactNumber, amenities, venueImage);
		System.out.print(isValid);
		
		if(isValid) {
			VenueModel venue = new VenueModel(venueName, venueAddress, venueCity, contactNumber, venueCapacity, amenities, venueType, imageFilePath, status);
			CrudService crudService = new CrudService();
			boolean isDuplicate = false;
	   		
			isDuplicate |= ValidationUtil.checkDuplicateVenue(request, "contact", contactNumber, "contact_no", crudService.getConn());
			System.out.print("Duplicate value: "+isDuplicate);
			if(isDuplicate){
				List<VenueModel> listVenue = crudService.selectAllVenues();
				request.setAttribute("listVenue", listVenue);
				
   				request.setAttribute("venueName", venueName);
   				request.setAttribute("capacity", venueCapacity);
   				request.setAttribute("contact", contactNumber);
   				request.setAttribute("amenities", amenities);
   				request.setAttribute("city", venueCity);
   				request.setAttribute("type", venueType);
   				request.setAttribute("address", venueAddress);
   				request.setAttribute("status", status);
   				request.setAttribute("showCreateModal", true);
   				
   				request.getRequestDispatcher("/WEB-INF/pages/Admin/venuemanagement.jsp").forward(request, response);
				return;
			}
			VenueModel createdVenue = crudService.addVenue(venue);
			if (createdVenue != null) {
				response.sendRedirect(request.getContextPath() + "/management");
					
			}
		}
		else {
			CrudService crudService = new CrudService();
			List<VenueModel> listVenue = crudService.selectAllVenues();
			request.setAttribute("listVenue", listVenue);
			
			request.setAttribute("venueName", venueName);
			request.setAttribute("capacity", venueCapacity);
			request.setAttribute("contact", contactNumber);
			request.setAttribute("amenities", amenities);
			request.setAttribute("city", venueCity);
			request.setAttribute("type", venueType);
			request.setAttribute("address", venueAddress);
			request.setAttribute("status", status);
			request.setAttribute("showCreateModal", true);
			
			request.getRequestDispatcher("/WEB-INF/pages/Admin/venuemanagement.jsp").forward(request, response);
		}
	
		
	}
	
	private void updateVenue(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//fetch all data
		String venueIdString = request.getParameter("venue_id");
		System.out.println("Raw venueIdString: '" + venueIdString + "'");
		int venueId = Integer.parseInt(venueIdString);
		System.out.print("updated venue id :" +venueId);
		String venueName = request.getParameter("venue_name");
		String venueAddress = request.getParameter("address");
		String venueCity = request.getParameter("city");
		String contactNumber = request.getParameter("contact");
		int venueCapacity = Integer.parseInt(request.getParameter("capacity"));
		String amenities = request.getParameter("amenities");
		String venueType = request.getParameter("venue_type");
		String status = request.getParameter("status");
		Part venueImage = request.getPart("venue_image");
		String imageFilePath = venueImage.getSubmittedFileName();
		System.out.println("Selected file name: "+imageFilePath);
		String uploadPath="C:/Users/eerii/eclipse-workspace/KnotSpot/src/main/webapp/resources/"+imageFilePath;
		System.out.println("uploaded file name: "+uploadPath);
		
		boolean isValid = isValidInputs(request, response, venueName, venueAddress, contactNumber, amenities, venueImage);
		System.out.print("Validation value: "+isValid);
		if(isValid) {
			
			CrudService crudService = new CrudService();
			boolean isDuplicate = false;
	   		
			isDuplicate |= ValidationUtil.checkDuplicateVenue(request, "contact", contactNumber, "contact_no", crudService.getConn(), venueId);
			System.out.print(isDuplicate);
			if(isDuplicate){
				List<VenueModel> listVenue = crudService.selectAllVenues();
				request.setAttribute("listVenue", listVenue);
				
				VenueModel selectedVenue = new VenueModel(venueName, venueAddress, venueCity, contactNumber, venueCapacity, amenities, venueType, imageFilePath, status);
	            selectedVenue.setVenueId(venueId);
	            request.setAttribute("selectedVenue", selectedVenue);
   				request.setAttribute("showEditModal", true);
   				
   				request.getRequestDispatcher("/WEB-INF/pages/Admin/venuemanagement.jsp").forward(request, response);
				return;
			}
			
			VenueModel updateVenue = new VenueModel(venueName, venueAddress, venueCity, contactNumber, venueCapacity, amenities, venueType, imageFilePath, status);
			updateVenue.setVenueId(venueId);
		
			if(imageFilePath!=null &&!imageFilePath.isEmpty()) {
				try {
					FileOutputStream fos = new FileOutputStream(uploadPath);
					InputStream is= venueImage.getInputStream();
					
					byte[] data = new byte[is.available()];
					is.read(data);
					fos.write(data);
					fos.close();
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				updateVenue.setVenuePic(imageFilePath);
			}

			crudService.updateVenue(updateVenue);
			response.sendRedirect(request.getContextPath() + "/management");	
		}
		else {
			CrudService crudService = new CrudService();
			List<VenueModel> listVenue = crudService.selectAllVenues();
			request.setAttribute("listVenue", listVenue);
			
			VenueModel selectedVenue = new VenueModel(venueName, venueAddress, venueCity, contactNumber, venueCapacity, amenities, venueType, imageFilePath, status);
            selectedVenue.setVenueId(venueId);
            request.setAttribute("selectedVenue", selectedVenue);
			
			request.getRequestDispatcher("/WEB-INF/pages/Admin/venuemanagement.jsp").forward(request, response);
		}
	}
	
	private void removeVenue(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String venueIdString = request.getParameter("venue_id");
		if(venueIdString !=null && !venueIdString.isEmpty()) {
			int venueId = Integer.parseInt(venueIdString);
			CrudService crudService = new CrudService();
			crudService.deleteVenue(venueId);
		}
		allVenues(request, response);
		
	}
	
	private void allVenues(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		CrudService crudService = new CrudService();
		List<VenueModel> listVenue = crudService.selectAllVenues();
		request.setAttribute("listVenue", listVenue);
		request.getRequestDispatcher("/WEB-INF/pages/Admin/venuemanagement.jsp").forward(request, response);
	}
	
	private void venueById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String venueIdString = request.getParameter("venue_id");
		int venueId = Integer.parseInt(venueIdString);
		CrudService crudService = new CrudService();
		VenueModel venue = crudService.selectVenueById(venueId);
	    request.setAttribute("selectedVenue", venue);
	    List<VenueModel> listVenue = crudService.selectAllVenues();
	    request.setAttribute("listVenue", listVenue);
		request.getRequestDispatcher("/WEB-INF/pages/Admin/venuemanagement.jsp").forward(request, response);
	}

}
