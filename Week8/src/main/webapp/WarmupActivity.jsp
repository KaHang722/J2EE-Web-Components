<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

//Connect to the server
Class.forName("com.mysql.jdbc.Driver");
String username="root";
String password="123456";
String url ="jdbc:mysql://localhost:3306/feb24" ;
Connection con = DriverManager.getConnection(url, username, password);
System.out.println("Connection establisjed successfully");

Statement statement= con.createStatement();
String query = "Select * from emp";
ResultSet resultSet = statement.executeQuery(query);

%>

<table border="1">
<tr>
<th>Emp Number</th>
<th>Emp Name</th>
<th>Salary</th>
<th>Job</th>
</tr>

<%
while(resultSet.next()){
	%>
	<tr>
	<td><%= resultSet.getString(1) %></td>
	<td><%=resultSet.getString(2) %></td>
	<td><%=resultSet.getString(3) %></td>
	<td><%=resultSet.getString(4) %></td>
	</tr>
<% } %>
</body>
</html>