<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jstl Core When</title>
</head>
<body>
	<c:set var="mark" value="90"></c:set>
	
	<c:choose >
		<c:when test="${mark ge 80 }">
			<p>Your Grade is A</p>
		</c:when>
		<c:when test="${mark ge 60 }">
			<p>Your Grade is B</p>
		</c:when>
		<c:when test="${mark ge 40 }">
			<p>Your Grade is C</p>
		</c:when>
		<c:when test="${mark ge 20 }">
			<p>Your Grade is D</p>
		</c:when>
		<c:when test="${mark ge 0 }">
			<p>Your Grade is E</p>
		</c:when>
		<c:otherwise>
			<p>Your Mark is invalid : negative mark </p>
		</c:otherwise>
	</c:choose>
</body>
</html>