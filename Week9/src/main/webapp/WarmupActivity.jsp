<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" errorPage="error.jsp"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		Age: <input type="text" name="age"><br><br>
		<input type="submit" value="calculate" name="calculate">
	</form>
	<c:if test="${not empty param.age}">
		<c:choose>
			<c:when test="${param.age > 0 && param.age <= 100}">
				<p>Age after 10 years: ${param.age + 10}</p>
			</c:when>
			<c:otherwise>
				<p>Please enter age between 0 and 100</p>
			</c:otherwise>
		</c:choose>
	</c:if>
</body>
</html>