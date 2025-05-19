package com.knotspot.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.knotspot.model.UserModel;
import com.knotspot.model.VenueModel;
import com.knotspot.service.CrudService;
import com.knotspot.service.RegisterService;

/**
 * Erika Shrestha
 * London met id: 23048598
 * Servlet implementation class Dashboard
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/dashboard" })
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * creates a crudservice, registerservice object
	 * sets the attribute as listvenue and listvenuecount
	 * counts the average capacity of all venues
	 * stores relevant data for registergraph, admin and customers in a list
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CrudService crudService = new CrudService();
		List<VenueModel> listVenue = crudService.selectAllVenues();
		request.setAttribute("listVenue", listVenue);
		request.setAttribute("listVenueCount", listVenue.size());;
		
		int sumCapacity=0;
	    int count = 0;
	    for (VenueModel venue : listVenue) {
	        sumCapacity += venue.getCapacity();
	        count++;
	    }
	    int averageCapacity = 0;
	    if (count > 0) {
	        averageCapacity = sumCapacity / count;
	    }
	    request.setAttribute("averageCapacity", averageCapacity);
		
		RegisterService registerService = new RegisterService();
		List<UserModel> listCustomer = registerService.selectCustomers();
		request.setAttribute("listCustomer", listCustomer);
		request.setAttribute("listCustomerCount", listCustomer.size());;
	
		List<UserModel> listAdmin = registerService.selectAdmins();
		request.setAttribute("listAdmin", listAdmin);
		request.setAttribute("listAdminCount", listAdmin.size());;
		
		List<Object[]> registrationGraph = registerService.getDailyRegistration();
		request.setAttribute("registrationGraph", registrationGraph);
		
		request.getRequestDispatcher("/WEB-INF/pages/Admin/dashboard.jsp").forward(request,response);
	
	}
	
	/**
	 * calls the doget method
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
