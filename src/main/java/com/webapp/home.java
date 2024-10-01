package com.webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class home extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session =req.getSession();
		String email =(String) session.getAttribute("email");
		
		if(email!=null) {
			req.getRequestDispatcher("home.html").forward(req, res);
		}
		else {
			req.getRequestDispatcher("login.html").forward(req, res);
		}
	}

}
