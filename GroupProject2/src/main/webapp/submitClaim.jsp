<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
 <h2>Submit Claim</h2>
 	<c:if test="${not empty errorMessage}">
        <p class="text-danger">${errorMessage}</p>
    </c:if>
    <c:if test="${not empty registrationIdError}">
            <p class="text-danger">${registrationIdError}</p>
    </c:if>
    <c:if test="${not empty descriptionError}">
            <p class="text-danger">${descriptionError}</p>
    </c:if>
    <form action="SubmitClaim" method="post">
        Registration ID: <input type="number" name="registrationId" required><br>
        Description: <input type="text" name="description" required><br>
        <input type="submit" value="Submit Claim">
    </form>
</div>
</body>
</html>