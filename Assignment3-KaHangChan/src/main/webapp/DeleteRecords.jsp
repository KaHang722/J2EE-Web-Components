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
<form method="post" action="DeleteRecords.jsp">
Enter Product No:<input type="text" name="enterproductno"><br><br>
<input type="submit" name="submit" value="Delete the Product"><br><br>
</form>

<%

//Connect to the server
String enterproductno = request.getParameter("enterproductno");

Class.forName("com.mysql.jdbc.Driver");
String username="root";
String password="123456";
String url ="jdbc:mysql://localhost:3306/as3-kahangchan" ;
Connection con = DriverManager.getConnection(url, username, password);
System.out.println("Connection established successfully");

if (request.getParameter("submit") != null) {
	String query = "DELETE FROM products WHERE product_no = ?";
	PreparedStatement preparedStatement = con.prepareStatement(query);
	preparedStatement.setString(1, enterproductno);
	preparedStatement.executeUpdate();
	out.println("Delete successfully");
}

String query2 = "Select * from products";
Statement statement= con.createStatement();
ResultSet resultSet = statement.executeQuery(query2);

%>

<table border="1">
<tr>
<th>Product No</th>
<th>Product Name</th>
<th>Product Name</th>
<th>Manufacturer</th>
<th>Price</th>
<th>Weight</th>
</tr>

<%
while(resultSet.next()){
	%>
	<tr>
	<td><%= resultSet.getString(1) %></td>
	<td><%=resultSet.getString(2) %></td>
	<td><%=resultSet.getString(3) %></td>
	<td><%=resultSet.getString(4) %></td>
	<td><%=resultSet.getString(5) %></td>
	<td><%=resultSet.getString(6) %></td>
	</tr>
<% } %>
</body>
</html>