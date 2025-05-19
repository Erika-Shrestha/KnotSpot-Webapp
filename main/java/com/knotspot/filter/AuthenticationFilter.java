package com.knotspot.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.knotspot.util.CookieUtil;
import com.knotspot.util.SessionUtil;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter(asyncSupported = true, urlPatterns = "/*")
public class AuthenticationFilter implements Filter {
    
	//all variables that store the url pattern
	private static final String login = "/login";
	private static final String logout = "/logout";
	private static final String dashboard = "/dashboard";
	private static final String home = "/home";
	private static final String product = "/product";
	private static final String blog = "/blog";
	private static final String aboutUs = "/aboutUs";
	private static final String contactUs = "/contactUs";
	private static final String faq = "/faq";
	private static final String management = "/management";
	private static final String profile = "/profile";
	private static final String analytics = "/analytic";
	private static final String task = "/task";
	private static final String setting = "/setting";
	
	/**
	 * this method provides a central hub for accessing all the url according to the roles stored by cookie
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse res = (HttpServletResponse) response;
	    
	    String url = req.getRequestURI();
	    System.out.println("Requested URL: " + url);
	    
	    avoidBackArrow(res);
	    
	   	    if (url.contains(login)|| url.contains("/WEB-INF/") ||
	        url.endsWith(".css") || url.endsWith(".js") || url.endsWith(".jpg") || url.endsWith(".png") || 
	        url.endsWith(".mp4") || url.contains("/resources/") ||
	        url.contains("/css/") || url.contains("/javascript/")) {
	        chain.doFilter(request, response);
	        return;
	    }
	   	    
	   	 if (url.endsWith(logout)) {
	   	    chain.doFilter(request, response);
	   	    return;
	   	}
	   	    
	   	 boolean notLoggedIn = SessionUtil.redirectIfNotloggedIn(req, res, login);
		    if (notLoggedIn) {
		        System.out.println("Session missing or user not logged in.");
		        return;
		    }

		    String userRole = CookieUtil.getCookie(req, "role") != null
		            ? CookieUtil.getCookie(req, "role").getValue()
		            : null;

		    if (userRole == null) {
		        System.out.println("User role cookie missing.");
		        res.sendRedirect(req.getContextPath() + login);
		        return;
		    }
		    

		    if ("RL1".equalsIgnoreCase(userRole)) {
		        if (url.endsWith(login)) {
		            res.sendRedirect(req.getContextPath() + dashboard);
		        } else if (url.endsWith(dashboard) || url.contains(management) || url.endsWith(setting)
		                || url.endsWith(profile) || url.endsWith(analytics) || url.endsWith(task) || url.endsWith("/")) {
		        	chain.doFilter(request, response);
		        } else {
		            res.sendRedirect(req.getContextPath() + dashboard);
		        }
		    } else if ("RL2".equalsIgnoreCase(userRole)) {
		        if (url.endsWith(login)) {
		            res.sendRedirect(req.getContextPath() + home);
		        } else if (url.endsWith(home) || url.endsWith(aboutUs) || url.endsWith(product)
		                || url.endsWith(blog) || url.endsWith(contactUs) || url.endsWith(faq)
		                || url.endsWith(profile) || url.endsWith("/")) {
		        	chain.doFilter(request, response);
		        } else {
		            res.sendRedirect(req.getContextPath() + home);
		        }
		    } else {
		        res.sendRedirect(req.getContextPath() + login);
		    }
		    
		
	}
	
	/**
	 * a helper method for caching controls in the website
	 * @param res
	 */
	private void avoidBackArrow(HttpServletResponse res) {
	    res.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
	    res.setHeader("Pragma", "no-cache");
	    res.setDateHeader("Expires", 0);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
