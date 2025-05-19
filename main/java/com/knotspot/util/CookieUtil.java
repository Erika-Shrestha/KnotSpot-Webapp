package com.knotspot.util;

import java.util.Arrays;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieUtil {
	
	/**
	 * a method to add cookies 
	 * @param response http response
	 * @param name for which the venue will be identified
	 * @param value the value stored for in a cookie with a name
	 * @param maxAge the lifeline of a cookie
	 */
	public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

  /**
   * to get the stored cookie 
   * @param request http request
   * @param name for which the venue will be identified
   * @return filters the stream to only include cookies that match the given name
   */
    public static Cookie getCookie(HttpServletRequest request, String name) {
        if (request.getCookies() != null) {
            return Arrays.stream(request.getCookies())
                    .filter(cookie -> name.equals(cookie.getName()))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * clears the stored cookies
     * @param response outgoing response
     * @param name for which the venue will be identified
     */
    public static void clearCookie(HttpServletResponse response, String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setMaxAge(0);
        cookie.setPath("/"); 
        response.addCookie(cookie);
    }
}
