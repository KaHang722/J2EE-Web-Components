<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register a Product</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div>
<div class="container">
    <h3>Register a Product</h3>
    <c:if test="${not empty errorMessage}">
        <p style="color: red;">${errorMessage}</p>
    </c:if>
    <c:if test="${not empty successMessage}">
        <p style="color: blue;">${successMessage}</p>
    </c:if>
    <form action="RegisterProduct" method="post">
        Product Name: <input type="text" name="productName" required><br>
        Serial No: <input type="text" name="serialNo" required><br>
        Purchase Date: <input type="date" name="purchaseDate" required><br>
        <input type="submit" value="Register">
    </form>
</div>
</div>
</body>
</html>