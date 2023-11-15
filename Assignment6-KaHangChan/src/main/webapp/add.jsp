<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container mt-4">
	<h2>Add a New Friend</h2>
	<form action="Add" method="post">
		<table>
			<tr>
				<td>FriendName:</td>
				<td><input type="text" name="name">
			</tr>
			<tr>
				<td>Email Address:</td>
				<td><input type="text" name="address">
			</tr>
			<tr>
				<td>Age:</td>
				<td><input type="text" name="age">
			</tr>
			<tr>
				<td>Favourite Color:</td>
				<td><input type="text" name="color">
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
	</div>
	<% String errorMessage = (String) request.getAttribute("errorMessage");
	if (errorMessage != null && !errorMessage.isEmpty()) { %>
	<div class="container mt-4">
		<div class="alert alert-danger">
			<%= errorMessage %>
		</div>
	</div>
	<% } %>
</body>
</html>