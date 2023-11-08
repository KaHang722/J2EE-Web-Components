<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<sql:update dataSource="${dbCon}" var="count">
            DELETE FROM product
            WHERE ProductId='${param.id}'
    </sql:update>


	<c:if test="${count>=1}">
		<font size="5" color='green'> Congratulations ! Data deleted
			successfully.</font>

		<c:redirect url="index.jsp">
			<c:param name="susMsg"
				value="Congratulations !! Data deleted successfully." />
		</c:redirect>
	</c:if>
</body>
</html>