<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<h2>User Login</h2>
	<c:if test="${not empty errorMessage}">
        <p class="text-danger">${errorMessage}</p>
    </c:if>
    <form action="UserLogin" method="post">
        Username: <input type="text" name="username"><br>
        Password: <input type="password" name="password"><br>
        <input type="submit" value="Login">
    </form>
    <br>
    <a href="createUser.jsp">Create New User</a>
    <br><br>
    <a href="index.jsp">Back to Home</a>
</div>
</body>
</html>