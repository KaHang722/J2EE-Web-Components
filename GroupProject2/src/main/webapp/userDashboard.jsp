<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Dashboard</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
 <div>
    <h1>Welcome <%= ((model.Users) session.getAttribute("user")).getUserName() %>!</h1>
 </div>
 <h2>User Dashboard</h2>   
    <%@ include file="registerProduct.jsp" %>
    <br>
    <a href="DisplayRegisteredProduct">View Registered Products</a>
    <br>
    <a href="DisplayClaim_C">View Claims</a>
    <br><br>
    <a href="logout.jsp">Logout</a>
</div>
</body>
</html>