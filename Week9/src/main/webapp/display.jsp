<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
	function confirmGo(m, u) {
		if (confirm(m)) {
			window.location = u;
		}
	}
</script>
<body>
<div align="center">
<sql:setDataSource
	var="dbCon"
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/july12_kahangchan"
	user="root" password="123456" />
<sql:query dataSource="${dbCon}" var="result">
	SELECT * FROM product;
</sql:query>
<form>
      <table border="1" width="40%">
				<caption>Product List</caption>
				<tr>
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Quantity</th>
					<th colspan="2">Action</th>
				</tr>
				<c:forEach var="row" items="${result.rows}">
					<tr>
						<td><c:out value="${row.ProductId}" /></td>
						<td><c:out value="${row.ProductName}" /></td>
						<td><c:out value="${row.Quantity}" /></td>
						<td><a href="update.jsp?id=<c:out value="${row.ProductId}"/>">Update</a></td>
						<td><a
							href="javascript:confirmGo('Sure to delete this record?','deletedb.jsp?id=<c:out value="${row.ProductId}"/>')">Delete</a>
						</td>	
					</tr>
				</c:forEach>
			</table>
</form>
</div>
</body>
</html>