<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jstl Core Var</title>
</head>
<body>
	<c:set var="salary"  value="300000000000"/>
	<c:set var="age"  value="21"/>
	<c:set var="withoutXML"  value="Hello JSTL"/>
	<c:set var="withXML"  value="<hello>Hello JSTL </hello>"/>
	
	<p>salary : ${salary }</p>
	<p>age: <c:out value="${age }" /> </p>
	
	<h3> Expression </h3>
	<p>withoutXML : ${withoutXML } </p>
	<p>xml : ${withXML } </p>
	<p> name : ${name} </p>
	
	<h3> With Out </h3>
	<p>withoutXML : <c:out value="${withoutXML }" /> </p>
	<p>xml : <c:out value="${withXML }" escapeXml="true" /> </p>
	<p> name : <c:out value="${name }" default="zawminkhant"></c:out>
</body>
</html>