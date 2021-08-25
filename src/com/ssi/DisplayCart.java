package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DisplayCart")
public class DisplayCart extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// this servlet will show the cart to user
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		HashSet<Integer> set = (HashSet<Integer>) session.getAttribute("cart");
		out.println("<html>");
		out.println("<body>");
		if (set == null) {
			out.println("<h3>Your Cart Is Empty</h3>");
			out.println("<h4><a href=CategoryServlet>Start-Buying</a></h4>");
		} else {
			out.println("<h3>Your Cart : </h3>");
			out.println("<hr>");
			StringJoiner sj = new StringJoiner(",", "(", ")");
			for (Integer item : set) {
				sj.add("" + item);
			}
			String sql = "select * from products where code in " + sj;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data5", "root", "root");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				out.println("<table border=2>");
				int sum=0;
				while (rs.next()) {
					String code = rs.getString("code");
					String name = rs.getString("name");
					String price = rs.getString("price");
					String desc = rs.getString("description");
					String category = rs.getString("category");
					sum=sum+Integer.parseInt(price);
					out.println("<tr>");
					out.println("<td>" + code + "</td>");
					out.println("<td>" + name + "</td>");
					out.println("<td>" + desc + "</td>");
					out.println("<td align=right>" + price + "</td>");
					out.println("<td>" + category + "</td>");
					out.println("</tr>");
				}
				out.println("<tr>");
				out.println("<td></td><td>");
				out.println("<td>Total Rs.</td>");
				out.println("<td>"+sum+"</td>");
				out.println("</tr>");
				out.println("</table>");
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// out.println(sql);
			out.println("<hr>");
			out.println("<a href=buyer-dashboard.jsp>Dashboard</a>");
		}
		out.println("</body>");
		out.println("</html>");

	}

}
