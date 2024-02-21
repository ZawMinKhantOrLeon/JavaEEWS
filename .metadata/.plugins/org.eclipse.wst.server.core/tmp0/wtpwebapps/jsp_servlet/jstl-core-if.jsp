<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jstl Core If</title>
</head>
<body>
	<c:set var="price" value="499.5"></c:set>
	
	<p>Normal Price: ${price} </p>
	
	<c:if test="${price ge 300.0 }" var="getTrueOrFalseOutPut"> 
		<p> Discount ? ${getTrueOrFalseOutPut } </p>
		<p>Discount Price : ${price * 0.9 } </p>
	</c:if>
</body>
</html>