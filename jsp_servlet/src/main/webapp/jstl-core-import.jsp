<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL Core Import</title>
</head>
<body>
	<h1>Import Tag Test</h1>
	
	<c:import url="cookie-data.jsp">
		<c:param name="favNews" value="entertainment"></c:param>
	</c:import>
	
	<c:import url="jstl-core-loop.jsp" var="data" scope="session"></c:import>
	${data }
</body>
</html>