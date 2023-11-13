<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="java.math.BigDecimal" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment 3</title>
</head>
<body>
<form method="post" action="InsertRecords.jsp">
Product No:<input type="text" name="productno"><br><br>
Product Name:<input type="text" name="productname"><br><br>
Product Type:<br><br>
<input type="radio" id="homeappliance" name="producttype" value="Home Appliance">
  <label for="homeappliance">Home Appliance</label>
  <input type="radio" id="computerhardware" name="producttype" value="Computer Hardware">
  <label for="computerhardware">Computer Hardware</label>
  <input type="radio" id="gameconsole" name="producttype" value="Game Console">
  <label for="gameconsole">Game Console</label>
  <input type="radio" id="clothing" name="producttype" value="Clothing">
  <label for="clothing">Clothing</label><br><br>
Manufacturer:<select name="manufacturer">
			<option value="LG">LG</option>
			<option value="Samsung">Samsung</option>
			<option value="Sony">Sony</option>
		  	</select><br><br>
Price:<input type="text" name="price"><br><br>
Weight:<input type="text" name="weight"><br><br>
<input type="submit" name="submit" value="Add Product">
</form>
<%
Class.forName("com.mysql.jdbc.Driver");
String username="root";
String password="123456";
String url ="jdbc:mysql://localhost:3306/as3-kahangchan" ;
Connection con = DriverManager.getConnection(url, username, password);
System.out.println("Connection establisjed successfully");

if (request.getParameter("submit") != null) {
String productno = request.getParameter("productno");
String productname = request.getParameter("productname");
String producttype = request.getParameter("producttype");
String manufacturer = request.getParameter("manufacturer");
BigDecimal  price = new BigDecimal(request.getParameter("price"));
BigDecimal  weight = new BigDecimal(request.getParameter("weight"));
if (price.compareTo(new BigDecimal("100")) >= 0 && price.compareTo(new BigDecimal("900")) <= 0) {
    try {
        PreparedStatement stmt = con.prepareStatement("INSERT INTO products VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setString(1, productno);
        stmt.setString(2, productname);
        stmt.setString(3, producttype);
        stmt.setString(4, manufacturer);
        stmt.setBigDecimal(5, price);
        stmt.setBigDecimal(6, weight);
        stmt.executeUpdate();
        
        out.println("Record is inserted successfully");
        
        String query = "Select * from products";
        Statement statement= con.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        
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
</table>
<%} catch (SQLException e) {
        e.printStackTrace();
    }
} else {
    out.println("<p>Price must be between $100 and $900.</p>");
	}
}
%>
</body>
</html>