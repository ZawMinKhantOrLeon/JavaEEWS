<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jstl Catch</title>
</head>
<body>

	<c:catch var="ex">
		 <%= 100/0 %>
	</c:catch>
	
	<p> exception : ${ex.message } </p>
</body>
</html>