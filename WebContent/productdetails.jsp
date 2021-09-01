<%
	String s=request.getParameter("t1");
	String sql="SELECT * FROM products WHERE code=?";
	Class.forName("com.mysql.jdbc.Driver");
	java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/data5","root","root");
	java.sql.PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1, Integer.parseInt(s));
	java.sql.ResultSet rs=ps.executeQuery();
	rs.next();
	String code=rs.getString(1);
	String name=rs.getString(2);
	String desc=rs.getString(3);
	String price=rs.getString(4);
	String catg=rs.getString(5);
	con.close();
%>
<html>
	<body>
		<h3>Product-Details</h3>
		<hr>
		<table border="2">
			<tr>
				<td>Code</td>
				<td><%out.print(code);%></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><%out.print(name);%></td>
			</tr>
			<tr>
				<td>Desc</td>
				<td><%out.println(desc);%></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><%out.println(price);%></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><%out.println(catg);%></td>
			</tr>
		</table>
		<hr>
		<a href="search.jsp">search-more</a><br>
		<a href="buyer-dashboard.jsp">buyer-dashboard</a>
		
	</body>
</html>















