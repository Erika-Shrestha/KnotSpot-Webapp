package com.knotspot.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.knotspot.model.VenueModel;
import com.knotspot.service.CrudService;

/**
 * Erika Shrestha
 * London met id: 23048598
 * Servlet implementation class Home
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/home" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/**
	 * creates crudservice object 
	 * stores all venue data in a listvenue 
	 * sets listvenue in an attribute
	 * forwards request to the home jsp file
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CrudService crudService = new CrudService();
		List<VenueModel> listVenue = crudService.selectAllVenues();
		request.setAttribute("listVenue", listVenue);
		request.getRequestDispatcher("/WEB-INF/pages/Customer/home.jsp").forward(request,response);
	}
	
	/**
	 * calls the doget method 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
