package com.ssi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class KillSession
 */
@WebServlet("/KillSession")
public class KillSession extends HttpServlet {
	   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//to destroy the session
		
		//step-1 (fetch the session)
		HttpSession session=request.getSession();
		//step-2 (invalidate it)
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

}
