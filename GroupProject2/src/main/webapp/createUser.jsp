<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<h2>User Register</h2>
	<c:if test="${not empty errorMessage}">
        <p style="color: red;">${errorMessage}</p>
    </c:if>
    <c:if test="${not empty validationErrors}">
            <p style="color: red;">${validationErrors}</p>
        </c:if>
    <form action="CreateUser" method="post">
        Username: <input type="text" name="userName"><br>
        Password: <input type="password" name="password"><br>
        Cellphone:<input type="text" name="cellphone"><br>
        Email:<input type="email" name="email"><br>
        Name:<input type="text" name="name"><br>
        Address:<input type="text" name="address"><br>
        <input type="submit" value="Register">
    </form>
</div>
</body>
</html>