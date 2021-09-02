<%@ page import="java.sql.Connection,java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager, java.sql.ResultSet" %>
<%!
	int computeDiscount(int price){
		if(price>=500){
			return price*20/100;
		}else{
			return price*10/100;
		}
}
%>
<%
	String s=request.getParameter("t1");
	String sql="SELECT * FROM products WHERE code=?";
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data5","root","root");
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1, Integer.parseInt(s));
	ResultSet rs=ps.executeQuery();
	rs.next();
	String code=rs.getString(1);
	String name=rs.getString(2);
	String desc=rs.getString(3);
	int price=rs.getInt(4);
	String catg=rs.getString(5);
	con.close();
%>
<%@ include file="info.jsp" %>
<html>
	<body>
		<h3>Product-Details</h3>
		<hr>
		<table border="2">
			<tr>
				<td>Code</td>
				<td><%=code%></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><%=name%></td>
			</tr>
			<tr>
				<td>Desc</td>
				<td><%=desc%></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><%=price%></td>
			</tr>
			<tr>
				<td>Disc</td>
				<td><%=computeDiscount(price)%></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><%=catg%></td>
			</tr>
		</table>
		<hr>
		<a href="search.jsp">search-more</a><br>
		<a href="buyer-dashboard.jsp">buyer-dashboard</a>
		
	</body>
</html>















