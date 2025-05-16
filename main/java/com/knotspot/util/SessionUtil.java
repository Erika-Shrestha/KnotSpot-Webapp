package com.knotspot.util;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SessionUtil {
	public static void createSession(HttpServletRequest request, HttpServletResponse response, String username) {
		HttpSession session = request.getSession(true);
		session.setAttribute("username", username);
		System.out.println(session.getAttribute("username"));
	}
	
	
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
	
	
	public static void invalidateSession(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		session.invalidate();
	}
}
