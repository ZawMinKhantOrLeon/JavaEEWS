<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/custom-tag.tld" prefix="custom" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom Tag</title>
</head>
<body>

  <h1> <custom:print> This is content one</custom:print></h1>
  <h1> <custom:print> This is content two</custom:print></h1>
  <h1> <custom:print> This is content three</custom:print></h1>
  <h1> <custom:print> This is content four</custom:print></h1>
  
 <h1> LocalDate : <custom:datetime type="date"/> </h1>
 <h1> LocalTime : <custom:datetime type="time"/> </h1>
 <h1> LocalDateTime : <custom:datetime type="datetime"/> </h1>
 <h1> Invalid : <custom:datetime type="abc"/> </h1>
 <h1> Blank : <custom:datetime type=""/> </h1>

 
</body>
</html>