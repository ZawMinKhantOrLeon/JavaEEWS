<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Declaration</title>
</head>
<body>
	<h1> Circle Area, Volume</h1>
	<%!
		double pi =3.142;
		double area (double r){
			
			return pi * Math.pow(r,2);
		}
		
		double volume (double r){
			return 4/3* pi * Math.pow(r,3);
		}
	
	%>
	
	<p>Pi value : <%= pi %> </p>
	<p>Circle Area : <%= area(5.0) %> </p>
	<p>Circle Volume : <%= volume(5.0) %> </p>
</body>
</html>