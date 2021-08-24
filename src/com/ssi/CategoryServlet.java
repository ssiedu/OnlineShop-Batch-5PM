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

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//fetching userid from session
		HttpSession session=request.getSession();
		String email=(String) session.getAttribute("userid");
		if(email==null) {//there is no member userid in session (auth not done)
			response.sendRedirect("index.jsp");
		}
		
		String ch="";
		String time="";
		//here we are reading a cookie whose name is choice.
		
		//step-1 (fetch all cookies)
		Cookie ck[]=request.getCookies();
		
		//step-2 (search for desired one)
		if(ck!=null)
		for(Cookie c:ck) {
			String name=c.getName();
			if(name.equals("choice")) {
				ch=c.getValue();

			}else if(name.equals("lastvisit")) {
				time=c.getValue();
			}
		}
		
		
		
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data5","root","root");
			String sql="select distinct category from products order by category";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			out.println("<html>");
			out.println("<body>");
			out.println("<h3>Welcome "+email+"</h3>");
			out.println("<h4>Your Last Visit Time : "+time+"</h4>");
			out.println("<h4><marquee>attractive offers on "+ch+" products</marquee></h4>");
			out.println("<h3>Product-Categories</h3>");
			out.println("<hr>");
			while(rs.next()) {
				String s=rs.getString(1);
				out.println("<a href=ProductListServlet?cat="+s+">");
				out.println(s);
				out.println("</a>");
				out.println("<br>");
			}
			out.println("<hr>");
			out.println("<a href=buyer-dashboard.jsp>Buyer-Dashboard</a>");
			out.println("</body>");
			out.println("<html>");
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
