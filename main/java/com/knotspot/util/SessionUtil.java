package com.knotspot.util;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SessionUtil {
	
	/**
	 * creates a session when login with unique session
	 * @param request incoming response
	 * @param response outgoing response
	 * @param username logged username
	 */
	public static void createSession(HttpServletRequest request, HttpServletResponse response, String username) {
		HttpSession session = request.getSession(true);
		session.setAttribute("username", username);
		System.out.println(session.getAttribute("username"));
	}
	
	/**
	 * redirects to pages through session 
	 * @param request incoming response
	 * @param response outgoing response
	 * @param redirectPath the path to get redirected to 
	 * @return boolean for session is stored or not
	 * @throws IOException Input/Output Exception fot the dopost method
	 */
	public static boolean redirectIfloggedIn(HttpServletRequest request, HttpServletResponse response, String redirectPath) throws IOException {
		HttpSession session = request.getSession(false);
		if(session !=null) {
		String userSession = (String) session.getAttribute("username");
			if(userSession !=null) {
				response.sendRedirect(request.getContextPath() + redirectPath);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * redirects to pages through session when not accessable
	 * @param request incoming response
	 * @param response outgoing response
	 * @param loginPath the path to get login to 
	 * @return boolean for session is stored or not
	 * @throws IOException Input/Output Exception fot the dopost method
	 */
	public static boolean redirectIfNotloggedIn(HttpServletRequest request, HttpServletResponse response, String loginPath) throws IOException {
		HttpSession session = request.getSession(false);
		if(session !=null) {
			String userSession = (String) session.getAttribute("username");
			if(userSession ==null) {
				response.sendRedirect(request.getContextPath()+ loginPath);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * deletes the session id of user when logged out
	 * @param request incoming response
	 * @param response outgoing response
	 */
	public static void invalidateSession(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		session.invalidate();
	}
}
