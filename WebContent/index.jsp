<%
	//session.setMaxInactiveInterval(6000);
%>
<html>
<body>
	<h3>Online Shopping</h3>
	<hr>
		<form action="VerifyUser">
			<pre>
			Email		<input type="text" name="email"/>
			Password 	<input type="password" name="password"/>
			Usertype	<select name="usertype"><option>buyer</option><option>owner</option></select>
			RememberMe	<input type="checkbox" name="save" value="yes"/>
					<input type="submit" value="Login"/>
			</pre>
		</form>
	<hr>
		<a href="registration.jsp">New-User-Registration</a><br>
	<hr>
</body>
</html>