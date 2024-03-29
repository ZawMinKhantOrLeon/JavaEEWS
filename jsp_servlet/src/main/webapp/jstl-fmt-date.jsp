<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="jakarta.tags.core" prefix="c" %>
 <%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jstl fmt date</title>
</head>
<body>
	
	<fmt:parseDate var="dateTime" value="2024-01-22 14:22:16" pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
	<c:set var="today" value="<%= new Date() %>"></c:set>
	<p>parseDate : ${dateTime}</p>
	
	<p>Date : <fmt:formatDate value="${dateTime }" type="date" /></p>
	<p>Time : <fmt:formatDate value="${dateTime }" type="time" /></p>
	<p>Time : <fmt:formatDate value="${dateTime }" type="both" /></p>
	<p>DateTime LongStyle : <fmt:formatDate value="${dateTime }" type="both" dateStyle="long" timeStyle="long" /></p>
	<p>DateTime MediumStyle : <fmt:formatDate value="${dateTime }" type="both" dateStyle="medium" timeStyle="medium" /></p>
	<p>DateTime ShortStyle : <fmt:formatDate value="${dateTime }" type="both" dateStyle="short" timeStyle="short" /></p>
	<p>Today Date LongStyle : <fmt:formatDate value="${today }" type="both" dateStyle="short" timeStyle="long" /> </p>
	<p>Today Date Tokyo TimeZone LongStyle : <fmt:formatDate value="${today }" type="both" dateStyle="short" timeStyle="long" timeZone="Asia/Tokyo" /> </p>
	

</body>
</html>