<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Users</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<h1>Search for Users</h1>
<form action="display_users" method="GET">
    <input type="text" name="searchUserName" placeholder="Enter username">
    <input type="submit" value="Search">
</form>
    <p>
        <% String table = (String) request.getAttribute("table"); %>
        <%= table %>
    </p>
<a href="dashboard_admin.jsp">Back to Admin Dashboard</a>
</div>
</body>
</html>
