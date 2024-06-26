<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL Core Loop Jsp</title>
</head>
<body>
	<%
	
		List<String> fruitList = Arrays.asList("mango","banana","orange","kiwi","strawberry");
	    pageContext.setAttribute("FRUIT_LIST", fruitList);
	    
	
	%>
	
	<ul>
	<c:forTokens items="Myanmar,Japan,Korea,Thailand,Us" delims="," var="country">
		<li>${country }</li>
	</c:forTokens>
	</ul>
	<ol>
		<c:forEach var="fruit" items="${FRUIT_LIST}" begin="1" end="3" step="2">
			<li>${fruit}</li>
	     </c:forEach>
	</ol>
</body>
</html>