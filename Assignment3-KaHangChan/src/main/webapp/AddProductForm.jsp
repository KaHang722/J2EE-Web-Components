<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment 3</title>
</head>
<body>
<form method="post">
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
String productno = request.getParameter("productno");
String productname = request.getParameter("productname");
String producttype = request.getParameter("producttype");
String manufacturer = request.getParameter("manufacturer");
String price = request.getParameter("price");
String weight = request.getParameter("weight");

if (request.getParameter("submit") != null) {
out.println("<h2>The following information is received:</h2>");
out.println("<p>Product No is: " + productno + "</p>");
out.println("<p>Product Name is: " + productname + "</p>");
out.println("<p>Product Type is: " + producttype + "</p>");
out.println("<p>Manufacturer is: " + manufacturer + "</p>");
out.println("<p>Price is: " + price + "</p>");
out.println("<p>Weight is: " + weight + "</p>");
}
%>

</body>
</html>