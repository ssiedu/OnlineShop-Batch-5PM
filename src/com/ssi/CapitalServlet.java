package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CapitalServlet
 */
@WebServlet("/CapitalServlet")
public class CapitalServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String s=request.getParameter("state");
		if(s.equalsIgnoreCase("MP")) {
			out.println("Bhopal");
		}else if(s.equalsIgnoreCase("MH")){
			out.println("Mumbai");
		}else {
			out.println("Jaipur");
		}
		
		
		
	}

}
