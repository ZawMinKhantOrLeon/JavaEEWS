<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Setting </title>
</head>
<body>
	<h1>Java Settings ......</h1>
	
	<fmt:bundle basename="resource.Settings">
		<p><fmt:message key="theme"></fmt:message></p>
		<p><fmt:message key="app-version"></fmt:message></p>
		<p><fmt:message key="java-version"></fmt:message></p>
		<p><fmt:message key="packing"></fmt:message></p>
		<p><fmt:message key="type"></fmt:message></p>
	</fmt:bundle>
</body>
</html>