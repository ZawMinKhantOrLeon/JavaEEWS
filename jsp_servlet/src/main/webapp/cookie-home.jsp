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
</body>
</html>