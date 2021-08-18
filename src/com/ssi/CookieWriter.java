package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieWriter")
public class CookieWriter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//here we wish to send the cookie along with response.
		PrintWriter out=response.getWriter();
		
		//three steps to write cookie
		//step-1 (create a cookie object)
		Cookie ck1=new Cookie("author","manoj");
		Cookie ck2=new Cookie("company","ssi");
		//step-2 (set the maximum age of the cookie)
		ck1.setMaxAge(60*60*24*7);
		ck2.setMaxAge(60*60*24*7);
		//step-3 (write it to response object)
		response.addCookie(ck1);
		response.addCookie(ck2);

		out.println("hello user...");//we are sending response to client.
		out.close();
		
	
	
	}

}
