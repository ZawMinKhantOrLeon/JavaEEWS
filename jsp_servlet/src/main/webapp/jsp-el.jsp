<%@page import="model.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jsp El</title>
</head>
<body>
	
	<%
		Person MgMg = new Person("mgmg","21",5.5);
	    pageContext.setAttribute("mgmg", MgMg);
	    
		
	%>
	<p> Name : ${mgmg.name } </p>
	<p> age : ${mgmg.age } </p>
	<p> height : ${mgmg.height } </p>
	<p> 40+50 = ${40+50} </p>
	<p> 30 lt 20 = ${ 30 lt 20  ? "yes" : "no"} </p>
	<p> 30 gt 20 = ${ 30 gt 20  ? "yes" : "no"} </p>
	<p> 30 le 20 = ${ 30 le 20  ? "yes" : "no"} </p>
	<p> 30 ge 20 = ${ 30 ge 20  ? "yes" : "no"} </p>
	<p> 30 == 20 = ${ 30 eq 20  ? "yes" : "no"} </p>
	<%-- <p> 30 != 20 = ${ 30 ne 20  ? "yes" : "no"} </p> --%>
	
	<p> 10 > 5 && 11 < 8  = ${ (10 gt 5) and (11 lt 8) ? "yes" : "no"} </p>
	<p> 12 > 15 || 13 < 20  = ${ (10 gt 5) or (11 lt 8) ? "yes" : "no"} </p>
	<p> 100 > 60 = ${ not (100 gt 60)} </p>
 <!-- 	<p>10+20 <%-- <%= 10+20 %> --%> </p>
	<p> 10 > 5 ? <%-- <%= 10 > 5 ? "yes" : "no" %> --%> </p>
	
--> 

</body>
</html>