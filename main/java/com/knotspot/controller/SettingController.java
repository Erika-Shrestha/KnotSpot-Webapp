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
 * Servlet implementation class SettingController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/setting" })
public class SettingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * parse the cookie maximum age into integer
	 * converts the max age to seconds from days
	 * forwards the request to setting jsp file
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer maxAge = (Integer) getServletContext().getAttribute("cookieMaxAge");
		// default selection is 1 day
		int days = 1; 
	    
	    // convert seconds to days
	    if (maxAge != null) {
	        days = maxAge / (24 * 60 * 60); 
	    }

	    request.setAttribute("selectedCookieLife", days);
		request.getRequestDispatcher("/WEB-INF/pages/Admin/setting.jsp").forward(request,response);
	}
	
	/**
	 * the cookielife value is retreived
	 * if the cookie life is not null, the days are converted to seconds
	 * the getservletcontext is globally used
	 * sets the attribute of maxage ad cookiemaxage
	 * redirects to setting page if cookielife is empty
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cookieLife = request.getParameter("cookieLife");
        if (cookieLife != null) {
            try {
                int days = Integer.parseInt(cookieLife);
                int maxAge = days * 24 * 60 * 60;
                getServletContext().setAttribute("cookieMaxAge", maxAge);
            } catch (NumberFormatException e) {
                getServletContext().setAttribute("cookieMaxAge", 15 * 60);
            }
        }
        response.sendRedirect(request.getContextPath() + "/setting");
	}

}
