<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment 4</title>
</head>
<body>
 <form method="get" action="FormattedDisplay.jsp">
        Search Product Name: <input type="text" name="searchPName"/>
        <input type="submit" value="Search">
    </form>

    <sql:setDataSource 
    var="dbCon" 
    driver="com.mysql.jdbc.Driver" 
    url="jdbc:mysql://localhost:3306/as4_kahangchan" 
    user="root" 
    password="123456" />

    <sql:query dataSource="${dbCon}" var="result">
        SELECT * FROM products
        <c:if test="${not empty param.searchPName}">
            WHERE product_name LIKE '%${param.searchPName}%'
        </c:if>
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

        <c:forEach var="product" items="${result.rows}">
            <tr>
                <td>${product.product_no}</td>
                <td>${product.product_name}</td>
                <td>${product.product_type}</td>
                <td>${product.manufacturer}</td>
                <td>
                    <fmt:formatNumber value="${product.price}" type="currency" currencyCode="GBP" maxFractionDigits="1" />
                </td>
                <td>${product.weight}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>