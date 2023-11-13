<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> <%@
taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>JSTL fmt:formatNumber
Tag</title> </head>
<body>
<h3>Number Format:</h3>
<c:set var = "balance" value = "120000.2309" />
<p>Formatted Number: <fmt:formatNumber value = "${balance}"
type = "currency"/></p>
</body>
</html>
