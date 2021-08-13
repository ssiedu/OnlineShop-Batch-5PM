package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SaveProduct")
public class SaveProduct extends HttpServlet {
	private Connection con;
	private PreparedStatement ps;
	
	//while loading
	public void init() {
		String sql="INSERT INTO products VALUES(?,?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data5","root","root");
			ps=con.prepareStatement(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//while unloading
	public void destroy() {
		try {
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		//reads the request (userid,password,gender,hobbies,city,photo)
		String code=request.getParameter("code");
		String name=request.getParameter("name");
		String desc=request.getParameter("desc");
		String price=request.getParameter("price");
		String category=request.getParameter("category");
		
		out.println("<html>");
		out.println("<body>");
		out.println("<hr>");
		try {
			ps.setInt(1, Integer.parseInt(code));
			ps.setString(2, name);
			ps.setString(3, desc);
			ps.setInt(4, Integer.parseInt(price));
			ps.setString(5, category);
			ps.executeUpdate();
			out.println("<h3>Stored Successfully</h3>");
			
		}catch(Exception e) {
			e.printStackTrace();
			out.println("<h3>Problem In Save</h3>");
		}
		out.println("<h4><a href=pentry.jsp>Add-More</a></h4>");
		out.println("<h4><a href=owner-dashboard.jsp>Owner-Dashboard</a></h4>");
		out.println("<hr>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

}
