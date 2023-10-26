<%@ page language="java" contentType="text/html;
charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"
prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Week 8 - Activity 3</title>
</head>
<meta http-equiv="Content-Type" content="text/html;
charset=ISO-8859-1">
<body>

<sql:setDataSource
var="dbCon"
driver="com.mysql.cj.jdbc.Driver"
url="jdbc:mysql://localhost:3306/nov3_kahangchan"
user="root" password="123456" />

<sql:update dataSource="${dbCon}" var="empRec">
insert into emp values ('101','jsh','tester','220');
</sql:update>

<sql:query dataSource="${dbCon}" var="result">
select * from emp;
</sql:query>

<table border="1">
<c:forEach var="col" items="${result.rows}">
<tr>
<td><c:out value="${col.Empno}"></c:out></td>
</tr>
</c:forEach>
</table>
</body>
</html>