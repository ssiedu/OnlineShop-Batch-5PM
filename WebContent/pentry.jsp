<html>
<body>
	<h3>Online Shopping</h3>
	<h3>Product-Entry-Form</h3>
	<hr>
		<form action="SaveProduct" method="get">
		<table border="1">
			<tr>
			<td>Code</td><td><input type="text" name="code"/></td>
			</tr>
			<tr>
			<td>Name</td><td><input type="text" name="name"/></td>
			</tr>
			<tr>
			<td>Desc</td><td><input type="text" name="desc"/></td>
			</tr>
			<tr>
			<td>Price</td><td><input type="text" name="price"/></td>
			</tr>
			<tr>
			<td>Category</td><td><select name="category">
								 <option>automobiles</option>
								 <option>books</option>
								 <option>computer</option>
								 <option>electronics</option>
								 <option>others</option>
								 </select>
						     </td>
			</tr>
			<tr>
			<td><input type="submit" value="Save"/></td>
			<td><input type="reset" value="Reset"/></td>
			</tr> 
		</table>
		</form>
	<hr>
	<a href="owner-dashboard.jsp">Owner-Dashboard</a>
</body>
</html>