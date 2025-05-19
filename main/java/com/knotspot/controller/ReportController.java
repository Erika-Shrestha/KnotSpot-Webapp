package com.knotspot.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.knotspot.service.RegisterService;

/**
 * Erika Shrestha
 * London met id: 23048598
 * Servlet implementation class ReportController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/analytic" })
public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * creates an object of registerservice
	 * stores the daily registration data in a list of object
	 * sets the list in a request attribute
	 * forwards the request to report jsp file
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RegisterService registerService = new RegisterService();
		List<Object[]> registrationGraph = registerService.getDailyRegistration();
		request.setAttribute("registrationGraph", registrationGraph);
		request.getRequestDispatcher("/WEB-INF/pages/Admin/report.jsp").forward(request,response);
	}
	
	/**
	 * calls the doget method
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
