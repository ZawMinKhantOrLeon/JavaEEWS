<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Data </title>
</head>
<body>
	<%
		String username= request.getParameter("name");
		String password = request.getParameter("password");
		session.setAttribute("name", username+":"+password);
		session.setMaxInactiveInterval(60);
		
		out.print("<h1>Your credentail are store in session</h1>");
		out.print("<a href='session-home.jsp'> Home </a>");
	
	%>
</body>
</html>