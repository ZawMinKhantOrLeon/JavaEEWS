<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Login Jsp</title>
</head>
<body>
	<h1> Login Here</h1>
	<form action="session-data.jsp" method="post">
	 <p> <input type="text" name="name" placeholder="Enter Your Name"> </p> 
	 <p> <input type="text" name="password" placeholder="Enter Your password"> </p> 
	 <input type="submit" value="login"></input>
	</form>

</body>
</html>