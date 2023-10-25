<%-- JSP Directives --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- This is JSP comment --%>
<%! int fontSize; %>
<%! int day = 3; %>

<p>Today's date: <%=(new java.util.Date()).toString() %> </p>

<% if (day == 1 | day == 7) { %>
<p> Today is weekend</p>
<% } else { %>
<p> Today is not weekend</p>
<% } %>


<%for ( fontSize= 1; fontSize<= 3; fontSize++){ %>
<font color = "green" size = "<%= fontSize%>">
JSP Tutorial
</font><br/>
<%}%>

</body>
</html>