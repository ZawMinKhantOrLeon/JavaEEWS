<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expression</title>
</head>
<body>
	<h1> Expression Test </h1>
    <p> 30+40 = <%= 30+40 %></p>
    <p> 20 > 15 = <%= 20 > 15 %> </p>
    <p>  upper case : <%= new String("I am converted to uppercase").toUpperCase() %> </p>
    <p> Sqrt 625 : <%= Math.sqrt(625.0) %>
</body>
</html>