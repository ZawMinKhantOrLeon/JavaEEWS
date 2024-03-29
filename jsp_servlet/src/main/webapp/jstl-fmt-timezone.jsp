<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="jakarta.tags.core" prefix="c" %>
 <%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jstl fmt timezone</title>
</head>
<body>
	
	<fmt:setTimeZone value="Asia/Singapore"/>
	<c:set var="today" value="<%= new Date() %>"> </c:set>
	<p> Date 1 : <fmt:formatDate value="${today }" type="both" dateStyle="short" timeStyle="long" /> </p>
	
	<h3> UK Country TimeZone</h3>
	
	<fmt:timeZone value="Europe/London">
		<p> Date 1 : <fmt:formatDate value="${today}" type="both" dateStyle="short" timeStyle="long" /> </p>
		<p> Date 2 : <fmt:formatDate value="${today}" type="both" dateStyle="short" timeStyle="long" /> </p>
		<p> Date 3 : <fmt:formatDate value="${today}" type="both" dateStyle="short" timeStyle="long" /> </p>
	</fmt:timeZone>
	
	<h3> America New York TimeZone</h3>
	<fmt:timeZone value="America/New_York">
		<p> Date 4 : <fmt:formatDate value="${today}" type="both" dateStyle="short" timeStyle="long" /> </p>
		<p> Date 5 : <fmt:formatDate value="${today}" type="both" dateStyle="short" timeStyle="long" /> </p>
		<p> Date 6 : <fmt:formatDate value="${today}" type="both" dateStyle="short" timeStyle="long" /> </p>
	</fmt:timeZone>
</body>
</html>