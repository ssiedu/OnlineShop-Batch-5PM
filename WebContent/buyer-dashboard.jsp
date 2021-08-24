<%
	int n=session.getMaxInactiveInterval();
	String email=(String)session.getAttribute("userid");
	if(email==null){
		response.sendRedirect("index.jsp");
	}
%>
<html>
<body>
	<h3>Welcome <%=email%></h3>
	<%=n%>
	<hr>
	<pre>
		<a href="CategoryServlet">Explore-Store</a>
		<a href="KillSession">Logout</a>
		</pre>
	<hr>
</body>
</html>