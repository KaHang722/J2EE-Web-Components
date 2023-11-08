<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#header,#main,#footer{
width:400px;
height:200px;
}
#header{background-color:red}
#main{background-color:yellow}
#footer{background-color:blue}
</style>
</head>
<body>
<div id='header'> Section 1</div>
<div id='main'> <%@include file="Time.jsp" %></div>
<div id='footer'> Section 2</div>
</body>
</html>