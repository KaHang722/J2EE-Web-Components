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
<body>
<sql:setDataSource
	var="dbCon"
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/july12_kahangchan"
	user="root" password="123456" />
	
<sql:query dataSource="${dbCon}" var="result">
            SELECT * FROM product WHERE ProductId=?;
            <sql:param value="${param.id}" />
	</sql:query>	
	<div align="center">
    <form action="updatedb.jsp" method="post">
    
		<table border="0" width="40%">
			<caption>Update Product</caption>
			<tr>
				<th>Product Name</th>
				<th>Quantity</th>
			</tr>
			<c:forEach var="row" items="${result.rows}">
				<tr>
					<td>
						<input type="hidden" value="${param.id}" name="id" /> 
						<input type="text" value="${row.ProductName}" name="pname" />
					</td>
					<td><input type="number" value="${row.Quantity}" name="qty" /></td>
					<td><input type="submit" value="Update"/></td>
				</tr>
			</c:forEach>
		</table>	
		<a href="index.jsp">Go Home</a>
	</form>
</div>
</body>
</html>