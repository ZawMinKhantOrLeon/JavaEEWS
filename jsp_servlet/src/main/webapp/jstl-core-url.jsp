<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dynamic Url</title>
</head>
<body>
	<c:set var="name" value="zawminkhant"></c:set>
	<c:set var="password" value="apple"></c:set>
	
	<c:url var="dynamicLink" value="session-data.jsp">
		<c:param name="name" value="${name }"></c:param>
		<c:param name="password" value="${password }"></c:param>
	</c:url>
	
	<a href="${dynamicLink }">Dynamic Link</a>
	
</body>
</html>