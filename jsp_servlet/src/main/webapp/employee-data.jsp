<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Data Jsp</title>
</head>
<body>
	<h1> Employee Information</h1>
	<p> FirtName : <%= request.getParameter("firstname") %> </p>
	<p> LastName : <%= request.getParameter("lastname") %> </p>
	<p> Email : <%= request.getParameter("email") %> </p>
	<p> Password : <%= request.getParameter("password").length() > 8 ? "Nice":"Too Short" %> </p>
	<p> Role : <%= request.getParameter("role") %> </p>
	<p> Gender : <%= request.getParameter("gender") %> </p>
	<h3>Hobby List</h3>
	<ul>  <%
	
	String[] hobbies=request.getParameterValues("hobby");
	for(final String hobby:hobbies){
		out.print("<li>"+hobby+"</li>");
	}
	%> </ul>
	<p> Description : <%= request.getParameter("description") %> </p>
</body>
</html>