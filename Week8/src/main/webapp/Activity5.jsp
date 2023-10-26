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
<form method="post">

Emp Job:<input type="text" name="Job"><br><br>
<input type="submit" value="submit">
</form>
<br><br>
<sql:setDataSource
	var="dbCon"
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/nov3_kahangchan"
	user="root" password="123456" />
<c:if test="${param.Job!=null}">
	<sql:update dataSource="${dbCon}" var="count">
		DELETE FROM emp WHERE Job = ?
	<sql:param value="${param.Job}" />
	</sql:update>
</c:if>
<br><br><br>
<c:if test="${count>0}">
	<label>Number of records Deleted Successfully!| ${count}</label>
</c:if>
<sql:query dataSource="${dbCon}" var="result">
	select * from emp;
</sql:query>
<table border="1">
	<tr>
		<th>Emp Number</th>
		<th>Emp Name</th>
		<th>Job</th>
		<th>Salary</th>
	</tr>
	<c:forEach var="col" items="${result.rows}">
	<tr>
		<td><c:out value="${col.Empno}"></c:out></td>
		<td><c:out value="${col.Ename}"></c:out></td>
		<td><c:out value="${col.Job}"></c:out></td>
		<td><c:out value="${col.Salary}"></c:out></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>