<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
 
 <jsp:include page="header.jsp">
 	<jsp:param value="zawminkhant" name="name"/>
 </jsp:include>
  <!-- Content -->
  <h1>This is Body Content</h1>
   <p> This is Bla Bla </p>
   <p> This is Bla Bla </p>
   <p> This is Bla Bla </p>
   <p> This is Bla Bla </p>
   <p> This is Bla Bla </p>
   <p> This is Bla Bla </p>
   <p> This is Bla Bla </p>
   <p> This is Bla Bla </p>
   
  <jsp:include page="footer.jsp"></jsp:include>
  
</body>
</html>