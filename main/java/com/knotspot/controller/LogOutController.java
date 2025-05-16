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
 * Servlet implementation class LogOutController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/logout" })
public class LogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Logout POST request received");
		String formAction = request.getParameter("logout");
		System.out.println("Form action: " + formAction);
		if("logout".equals(formAction)) {
			handleLogout(request, response);
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
	}
	
	private void handleLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
		if(session !=null) {
			session.invalidate();
			CookieUtil.clearCookie(response, "role_id");
			System.out.println("User session has been successfully logged out");
		}
	}
}
