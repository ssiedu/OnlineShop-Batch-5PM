package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category=request.getParameter("cat");
		PrintWriter out=response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data5","root","root");
			String sql="select code,name from products where category=?";	
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, category);
			ResultSet rs=ps.executeQuery();
			out.println("<html>");
			out.println("<body>");
			out.println("<h3>Product-List</h3>");
			out.println("<hr>");
			while(rs.next()) {
				String id=rs.getString(1);
				String s=rs.getString(2);
				out.println("<a href=ProductDetailServlet?code="+id+">");
				out.println(s);
				out.println("</a>");
				out.println("<br>");
			}
			out.println("<hr>");
			out.println("</body>");
			out.println("<html>");
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		out.close();
	
	}

}
