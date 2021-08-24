package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VerifyUser
 */
@WebServlet("/VerifyUser")
public class VerifyUser extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//writing visit time using cookies to client's disk
		java.util.Date dt=new java.util.Date();
		String visit=dt.toString();
		visit=visit.replace(' ', '-');
		//System.out.println(visit);
		Cookie ck=new Cookie("lastvisit",visit);
		ck.setMaxAge(60*60*24*30);
		response.addCookie(ck);
		
		
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String usertype=request.getParameter("usertype");
		
		if(usertype.equals("buyer")) {
			String sql="SELECT * FROM userinfo WHERE email=? AND password=?";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data5","root","root");
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, email);
				ps.setString(2, password);
				ResultSet rs=ps.executeQuery();
				boolean b=rs.next();
				if(b) {
					
					//here we are storing user's email into his session, so that it will be available for whole app.
					HttpSession session=request.getSession();
					session.setAttribute("userid", email);
					
					
					response.sendRedirect("buyer-dashboard.jsp");
				}else {
					out.println("Invalid Buyer Details");
				}
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(usertype.equals("owner")) {
			if(email.equals("admin@gmail.com") && password.equals("indore")) {
				response.sendRedirect("owner-dashboard.jsp");
			}else {
				out.println("Invalid Owner Details");
			}
		}
	}

}
