<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cookie Home</title>
</head>
<body>
	<%
		String favNews= "economic";
	    Cookie[] cookies = request.getCookies();
	    
	   	if(cookies != null){
	   	 for(final Cookie cookie:cookies){
		    	if(cookie.getName().equals("jsp_servlet.favNews")){
		    		favNews= cookie.getValue();
		    		break;
		    	}
		    }
	   	}
	%>
	
	<h1> Featured News For <%= favNews %> </h1>
	<p>Hot News For <%= favNews %>  is bla bla </p>
	<p>Hot News For <%= favNews %>  is bla bla </p>
	<p>Hot News For <%= favNews %>  is bla bla </p>
	<p>Hot News For <%= favNews %>  is bla bla </p>
	<p>Hot News For <%= favNews %>  is bla bla </p>
	<p>Hot News For <%= favNews %>  is bla bla </p>
	
	<a href="cookie-form.jsp">Cookie Form</a>
	
	
	
</body>
</html>