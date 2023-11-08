<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post">
   <input type="hidden" name="submitted" value="true">
   <table>
    <c:if test="${param.submitted && empty param.userName}">
     <tr><td></td>
     <td colspan="2"><font color="red">
      Please enter your Name
     </font></td></tr>
    </c:if>
    <tr>
     <td>Name:</td>
     <td>
      <input type="text" name="userName"
       value="<c:out value="${param.userName}" />">
     </td>
    </tr>
    <tr>
     <td>
      <input type="submit" value="submit"> 
     </td>
     <td><c:out value="${param.userName}" /></td>
    </tr>
   </table>
</form>
</body>
</html>