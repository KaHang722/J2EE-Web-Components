<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment 4</title>
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

<c:if test="${not empty param.submit}">
    <h2>The following information is received:</h2>
    <p>Product No is: ${param.productno}</p>
    <p>Product Name is: ${param.productname}</p>
    <p>Product Type is: ${param.producttype}</p>
    <p>Manufacturer is: ${param.manufacturer}</p>
    <p>Price is: ${param.price}</p>
    <p>Weight is: ${param.weight}</p>
</c:if>

</body>
</html>