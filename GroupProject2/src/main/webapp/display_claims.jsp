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
<% String table = (String) request.getAttribute("table"); %>
        <%= table %>
<a href="dashboard_admin.jsp">Back to Admin Dashboard</a>
</div>
</body>
</html>