package com.product_project;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class product_servlet extends GenericServlet{
	@Override
	public void service(ServletRequest req,ServletResponse res) {
		int id=Integer.parseInt(req.getParameter("pid"));
		String brand=req.getParameter("pbrand");
		double price=Double.parseDouble(req.getParameter("pprice"));
		double discount=Double.parseDouble(req.getParameter("discount"));
		
	}

}
