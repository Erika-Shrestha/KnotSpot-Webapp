package com.knotspot.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Erika Shrestha
 * london met id: 23048598
 * Servlet implementation class CalendarController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/task" })
public class CalendarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * forwards the request to calendar JSP file after selecting the section either list or notify
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String section = request.getParameter("section");
        if (section == null || section.equals("list")) {
            request.setAttribute("activeSection", "list");
        } else if (section.equals("notify")) {
            request.setAttribute("activeSection", "notify");
        } else {
            request.setAttribute("activeSection", "list"); 
        }
    	request.getRequestDispatcher("/WEB-INF/pages/Admin/calendar.jsp").forward(request,response);
	}

	/**
	 * calls the doget method
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
