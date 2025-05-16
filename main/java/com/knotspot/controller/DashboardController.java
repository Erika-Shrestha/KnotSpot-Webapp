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
 * Servlet implementation class Dashboard
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/dashboard" })
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	CrudService crudService = new CrudService();
	List<VenueModel> listVenue = crudService.selectAllVenues();
	request.setAttribute("listVenue", listVenue);
	request.getRequestDispatcher("/WEB-INF/pages/Admin/dashboard.jsp").forward(request,response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
