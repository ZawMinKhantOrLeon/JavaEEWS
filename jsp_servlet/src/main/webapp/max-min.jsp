<%@page import="utils.MinMaxFinder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1>Max-Min Finder</h1>
    <%! 
    
    %>
	<%
		//logic
		int max= MinMaxFinder.max(10,20,40,15);
		out.print("<h1> max = "+max+"<h1>");
		
		int min= MinMaxFinder.min(10,20,40,15);
		out.print("<h1> min = "+min+"<h1>");
	%>
	
	<p>Max of 12.33 , 14.55 ,20.44 ,11.22 =  <%= MinMaxFinder.max(12.33,14.55,20.44,11.22) %>
	<p>Min of apple,orange,banana,kiwi = <%= MinMaxFinder.min("apple", "orange", "banana", "kiwi") %>
</body>
</html>