<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
   <%@ page import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<form action="UpdatingProduct">
		<table>
			<tr>
				<td colspan="3" align="center"><font size="5">Update Product</font></td>
			</tr>
			
				<tr>
					<td>
						<input type="text" value="${param.id}" name="id" /> 
						<input type="text" value="New Product Name" name="name" />
					</td>
					<td><input type="number" value="${row.Quantity}" name="quantity" /></td>
					<td><input type="submit" value="Update"/></td>
				</tr>
			
			<tr>
				<td><a href="index.jsp">Go Home</a></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>