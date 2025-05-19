package com.knotspot.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Erika Shrestha
 * London met id: 23048598
 * Servlet implementation class Faq
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/faq" })
public class FaqController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * forwards request to a faq JSP file
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/Customer/faq.jsp").forward(request,response);
	}
	
	/**
	 * calls the doget method 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
