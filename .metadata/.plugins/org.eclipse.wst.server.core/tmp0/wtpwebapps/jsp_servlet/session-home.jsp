<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Home</title>
</head>
<body>
	<%
		String user= (String) session.getAttribute("name");
	    if(user != null){
	    	out.print("<h1> You already login </h1>");
	    	out.print("<h1> Your credential : "+user +"</h1>");
	    	out.print("<h1> Session Id :  : "+session.getId() +"</h1>");
	    	out.print("<h1> Session Creation Time :  : "+new Date(session.getCreationTime())+"</h1>");
	    	out.print("<h1> Expire Time :  : "+session.getMaxInactiveInterval() +"</h1>");
	    }else{
	    	out.print("<h1> Your credentials are not found in session");
	    	out.print("<p> please login again </p>");
	    	out.print("<a href='session-login.jsp'> Login </a>");
	    }
	%>
</body>
</html>