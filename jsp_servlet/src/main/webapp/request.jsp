<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request Obj</title>
</head>
<body>
	<h1> Request Object Information </h1>
	<p>User-Agent : <%= request.getHeader("User-Agent") %> </p>
	<p>Host : <%= request.getHeader("Host") %> </p>
	<p>Connection : <%= request.getHeader("Connection") %> </p>
	<p>Accept : <%= request.getHeader("Accept") %> </p>
	<p>Accept-Encoding : <%= request.getHeader("Accept-Encoding") %> </p>
	<p>Accept-Language : <%= request.getHeader("Accept-Language") %> </p>
	<ol>
		<%
			Enumeration<String> names= request.getHeaderNames();
	        while(names.hasMoreElements()){
	        	out.print("<li>"+names.nextElement()+"</li>");
	        }
		%>
	</ol>
</body>
</html>