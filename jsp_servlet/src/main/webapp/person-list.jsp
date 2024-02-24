<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Person List</title>
</head>
<body>
	<h1> Person Information table : </h1>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Age</th>
			<th>Height</th>
		</tr>
		<c:forEach var="person" items="${PERSON_LIST}">
			<tr>
				<td>${person.name }</td>
				<td>${person.age }</td>
				<td>${person.height }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>