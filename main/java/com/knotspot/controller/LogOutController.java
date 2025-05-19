package com.knotspot.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.knotspot.util.CookieUtil;

/**
 * Erika Shrestha
 * London met id: 23048598
 * Servlet implementation class LogOutController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/logout" })
public class LogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * request the logout value from the jsp file
	 * checks if logout matches with the action
	 * redirects to login page if equal
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String formAction = request.getParameter("logout");
		if("logout".equals(formAction)) {
			handleLogout(request, response);
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
	}
	
	/**
	 * checks if a session exists by setting as false to avoid creating new one
	 * if session is not empty then the session/cookie is ended
	 * @param request http request for the dopost method
	 * @param response http response for the dopost method
	 * @throws IOException Input/Output Exception fot the dopost method
	 */
	private void handleLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
		if(session !=null) {
			session.invalidate();
			CookieUtil.clearCookie(response, "role_id");
			System.out.println("User session has been successfully logged out");
		}
	}
}
