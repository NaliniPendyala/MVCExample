<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Info</title>
</head>
<body>
<c:choose>
<c:when test='${ua!=null && ua.role=="user"}'>

Name:  ${ua.name}
Username:  ${ua.username}
<%String s= request.getServletContext().getContextPath(); %>
<a href='<%=s%>/logout'><input type=button value="Logout"></a>
</c:when>
<c:otherwise><c:redirect url="login.jsp"></c:redirect>
</c:otherwise>
</c:choose>
</body>
</html>