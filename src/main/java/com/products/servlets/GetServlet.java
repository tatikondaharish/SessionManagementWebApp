package com.products.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String response = "Welcome to Page";
		String name = req.getParameter("user");
		resp.getWriter().println(response+" "+name);
	}
}
