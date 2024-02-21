<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cookie Data</title>
</head>
<body>
	<%
	String favNews = request.getParameter("favNews");
	Cookie cookie = new Cookie("jsp_servlet.favNews",favNews);
	cookie.setMaxAge(60);
	
	response.addCookie(cookie);
	
	
	%>
	<h1> Your FavNews Are Set Into Cookies</h1>
	<a href="cookie-home.jsp">Cookie Home</a>
</body>
</html>