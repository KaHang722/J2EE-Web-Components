<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<form method="post">
	<table>
		<tr>
			<td>Product Name</td>
			<td><input type="text" name="pname"></td>
		</tr>
		<tr>
			<td>Quantity</td>
			<td><input type="text" name="qty"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Save" name="Save"></td>
			<td><input type="reset" value="Reset" name="Reset"></td>
		</tr>
		
	</table>
	</form>
	<br><br><br>
	
	<c:if test="${not empty param.errMsg}">
	<c:out value="${param.errMsg}"/>
	</c:if><br><br><br>
	
	<c:if test="${not empty param.susMsg}">
	<c:out value="${param.susMsg}"/>
	</c:if>
	
</div>

</body>
</html>