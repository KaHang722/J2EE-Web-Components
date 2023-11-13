<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="java.math.BigDecimal" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment 4</title>
</head>
<body>
<form method="post" action="InsertRecords.jsp">
Product No:<input type="text" name="product_no"><br><br>
Product Name:<input type="text" name="product_name"><br><br>
Product Type:<br><br>
<input type="radio" id="homeappliance" name="product_type" value="Home Appliance">
  <label for="homeappliance">Home Appliance</label>
  <input type="radio" id="computerhardware" name="product_type" value="Computer Hardware">
  <label for="computerhardware">Computer Hardware</label>
  <input type="radio" id="gameconsole" name="product_type" value="Game Console">
  <label for="gameconsole">Game Console</label>
  <input type="radio" id="clothing" name="product_type" value="Clothing">
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
<sql:setDataSource
	var="dbCon"
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/as4_kahangchan"
	user="root" password="123456" />

<c:set var="product_no" value="${param.product_no}" />
<c:set var="product_name" value="${param.product_name}" />
<c:set var="product_type" value="${param.product_type}" />
<c:set var="manufacturer" value="${param.manufacturer}" />
<c:set var="price" value="${param.price}" />
<c:set var="weight" value="${param.weight}" />

<c:if test="${not empty param['submit']}">
<c:choose>
	<c:when test="${price >= 100.00 && price <= 900.00}">
	<sql:update dataSource="${dbCon}" var="prodctRec">
                INSERT INTO products VALUES (?, ?, ?, ?, ?, ?);
                
                <sql:param value="${product_no}" />
                <sql:param value="${product_name}" />
                <sql:param value="${product_type}" />
                <sql:param value="${manufacturer}" />
                <sql:param value="${price}" />
                <sql:param value="${weight}" />
    </sql:update>
    <sql:query dataSource="${dbCon}" var="resultSet">
                SELECT * FROM products
            </sql:query>
			<br>
            <table border="1">
                <tr>
                    <th>Product No</th>
                    <th>Product Name</th>
                    <th>Product Type</th>
                    <th>Manufacturer</th>
                    <th>Price</th>
                    <th>Weight</th>
                </tr>
                <c:forEach var="product" items="${resultSet.rows}">
                    <tr>
                        <td>${product.product_no}</td>
                        <td>${product.product_name}</td>
                        <td>${product.product_type}</td>
                        <td>${product.manufacturer}</td>
                        <td>${product.price}</td>
                        <td>${product.weight}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <p>Price must be between $100 and $900.</p>
        </c:otherwise>
    </c:choose>
</c:if>
</body>
</html>