<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<h1>Search for Products</h1>
<form action="display_registered_products" method="GET">
    <input type="text" name="searchProductName" placeholder="Enter product name">
    <input type="submit" value="Search">
</form>
<% String table = (String) request.getAttribute("table"); %>
        <%= table %>
<a href="dashboard_admin.jsp">Back to Admin Dashboard</a>
</div>
</body>
</html>