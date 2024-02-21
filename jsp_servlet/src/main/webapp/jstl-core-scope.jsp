<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jstl Core Scope</title>
</head>
<body>
	<c:set var="var1" value="10000" scope="page"></c:set>
	<c:set var="var2" value="20000" scope="session"></c:set>
	<c:set var="var3" value="30000" scope="application"></c:set>
	<c:set var="var4" value="40000" scope="request"></c:set>
	
	<p>Defined Variable var1 page Scope: ${var1 }</p>
	<p>Defined Variable var2 session Scope: ${var2 }</p>
	<p>Defined Variable var3 application Scope: ${var3}</p>
	<p>Defined Variable var4 request Scope ${var4 }</p>
	
	<jsp:forward page="scope-test1.jsp"></jsp:forward>
	
	<c:remove var="var2" scope="session"/>
	
</body>
</html>