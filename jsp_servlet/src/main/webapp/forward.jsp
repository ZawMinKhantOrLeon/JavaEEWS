<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forward Jsp</title>
</head>
<body>
	<jsp:forward page="session-data.jsp">
		<jsp:param value="zawminkhant" name="name"/>
		<jsp:param value="apple" name="password"/>
	</jsp:forward>
</body>
</html>