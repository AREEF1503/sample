package com.webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieTwo extends HttpServlet{
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Cookie[] cookies =req.getCookies();
		for(Cookie cookie : cookies) {
			res.getWriter().print(cookie.getValue());	}
	}
	

}

