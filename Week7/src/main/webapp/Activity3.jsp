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
String empno = request.getParameter("empno");
String empname = request.getParameter("empname");
String salary = request.getParameter("salary");
String job = request.getParameter("job");


// Connect to the server
Class.forName("com.mysql.jdbc.Driver");
String username="root";
String password="123456";
String url ="jdbc:mysql://localhost:3306/feb24" ;
Connection con = DriverManager.getConnection(url, username, password);
System.out.println("Cpnnection establisjed successfully");

PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO emp VALUES(?,?,?,?)");

preparedStatement.setString(1,empno);
preparedStatement.setString(2,empname);
preparedStatement.setString(3,salary);
preparedStatement.setString(4,job);

preparedStatement.execute();

out.println("Record is inserted successfully");

%>

</body>
</html>