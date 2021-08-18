package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieReader
 */
@WebServlet("/CookieReader")
public class CookieReader extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//here we are reading value of a cookie whose name is author.
		
		//step-1 (fetch all cookies)
		Cookie ck[]=request.getCookies();
		//step-2 (search the desired one)
		
		String s1="",s2="";
		for(Cookie c:ck) {
			String name=c.getName();
			if(name.equals("author")) {
				s1=c.getValue();
			}else if(name.equals("company")) {
				s2=c.getValue();
			}
		}
		/*
		for(int i=0; i<ck.length; i++) {
			String name=ck[i].getName();
			if(name.equals("author")) {
				s1=ck[i].getValue();
			}else if(name.equals("company")) {
				s2=ck[i].getValue();
			}
		}
		*/
		PrintWriter out=response.getWriter();
		out.println("Welcome "+s1+" from "+s2);
		out.close();
		
		
		
		
		
		
	}

}
