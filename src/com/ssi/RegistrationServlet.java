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


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private Connection con;
	private PreparedStatement ps;
	
	//while loading
	public void init() {
		String sql="INSERT INTO userinfo VALUES(?,?,?,?,?)";
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
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String mobile=request.getParameter("mobile");
		
		out.println("<html>");
		out.println("<body>");
		out.println("<hr>");
		try {
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, address);
			ps.setString(5, mobile);
			ps.executeUpdate();
			out.println("<h3>Registered Successfully</h3>");
			out.println("<h4><a href=index.jsp>Login</a></h4>");
		}catch(Exception e) {
			e.printStackTrace();
			out.println("<h3>Registration Failed</h3>");
			out.println("<h4><a href=registration.jsp>Re-Try</a></h4>");
			out.println("<h4><a href=index.jsp>Home</a></h4>");
		}
		out.println("<hr>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

}
