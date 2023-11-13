<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment 4</title>
</head>
<body>
<form method="post" action="DeleteRecords.jsp">
Enter Product No:<input type="text" name="enterproductno"><br><br>
<input type="submit" name="submit" value="Delete the Product"><br><br>
</form>
<sql:setDataSource 
var="dbCon" 
driver="com.mysql.jdbc.Driver" 
url="jdbc:mysql://localhost:3306/as4_kahangchan" 
user="root" password="123456" />
    <c:if test="${not empty param.submit}">
        <sql:update dataSource="${dbCon}" var="result">
            DELETE FROM products WHERE product_no = ?
            <sql:param value="${param.enterproductno}" />
        </sql:update>
        <c:if test="${result >= 1}">
            Delete successfully
        </c:if>
    </c:if>
    <sql:query dataSource="${dbCon}" var="result2">
        SELECT * FROM products
    </sql:query>
    <table border="1">
        <tr>
            <th>Product No</th>
            <th>Product Name</th>
            <th>Product Type</th>
            <th>Manufacturer</th>
            <th>Price</th>
            <th>Weight</th>
        </tr>
        <c:forEach var="product" items="${result2.rows}">
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
</body>
</html>