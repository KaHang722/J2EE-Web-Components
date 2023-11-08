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
<c:if test="${ empty param.pname or empty param.qty}">
		<c:redirect url="index.jsp">
			<c:param name="errMsg" value="Please enter Product Name and Quantity" />
		</c:redirect>
	</c:if>

	<sql:setDataSource
	var="dbCon"
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/july12_kahangchan"
	user="root" password="123456" />


	<sql:update dataSource="${dbCon}" var="result">
            UPDATE product SET ProductName = ?, Quantity=?
            WHERE ProductId='${param.id}'
            <sql:param value="${param.pname}" />
		<sql:param value="${param.qty}" />
	</sql:update>
	
	
	<c:if test="${result>=1}">
			
		<c:redirect url="index.jsp">
			<c:param name="susMsg"
				value="Congratulations !! Data updated successfully." />
		</c:redirect>
	</c:if>
</body>
</html>