<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Page</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
<h1>Ka Hang's Friends</h1>
<p>
<% String table = (String) request.getAttribute("table");; // Read the table value here %>

<%= table %>
</p>
<br /> <br /> <a href="add.jsp"> Add a new Friend </a>
<a href='index.jsp'>Go Home</a><br/>
</div>
</body>
</html>