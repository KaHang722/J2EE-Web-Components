<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
public String printDate(){
Date dNow = new Date( );
SimpleDateFormat dateft = new SimpleDateFormat ("y/M/d");
return dateft.format(dNow);
}
%>
<%=printDate() %>
</body>
</html>