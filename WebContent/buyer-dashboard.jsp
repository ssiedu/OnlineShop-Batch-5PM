<%
	
	int n=session.getMaxInactiveInterval();
	String email=(String)session.getAttribute("userid");
	if(email==null){
		response.sendRedirect("index.jsp");
	}
%>
<%@include file="info.jsp" %>
<html>
<body>
	<h3>Welcome <%=email%></h3>
	<hr>
	<pre>
		<a href="CategoryServlet">Explore-Store</a>
		<a href="search.jsp">Search Product</a>
		<a href="DisplayCart">View-Cart</a>
		<a href="KillSession">Logout</a>
		</pre>
	<hr>
</body>
</html>