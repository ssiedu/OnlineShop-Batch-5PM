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

/**
 * Servlet implementation class ProductDetailServlet
 */
@WebServlet("/ProductDetailServlet")
public class ProductDetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		PrintWriter out = response.getWriter();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data5", "root", "root");
			String sql = "select * from products where code=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(code));
			ResultSet rs = ps.executeQuery();
			rs.next();
			String pcode=rs.getString(1);
			String name=rs.getString(2);
			String desc=rs.getString(3);
			String price=rs.getString(4);
			String category=rs.getString(5);
			out.println("<html>");
			out.println("<body>");
			out.println("<h3>Product-Details</h3>");
			out.println("<hr>");
			out.println("<table border=2>");
			out.println("<tr>");
			out.println("<td>Code</td>");
			out.println("<td>"+pcode+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Name</td>");
			out.println("<td>"+name+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Desc</td>");
			out.println("<td>"+desc+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Price</td>");
			out.println("<td>"+price+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>Catg</td>");
			out.println("<td>"+category+"</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("<hr>");
			out.println("</body>");
			out.println("<html>");
			out.println("<a href=CartManager?code="+pcode+">Add-To-Cart</a><br>");
			out.println("<a href=CategoryServlet>Category-Page</a><br>");
			out.println("<a href=buyer-dashboard.jsp>Buyer-Dashboard</a>");
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		out.close();

	}

}
