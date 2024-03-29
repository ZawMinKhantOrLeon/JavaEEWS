<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="jakarta.tags.core" prefix="c" %>
 <%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jstl Fmt Number</title>
</head>
<body>
	<%
		String salary = "12900.34567";
		pageContext.setAttribute("salary", salary);
	%>
	
	<fmt:parseNumber var="pharsedValue" value="${salary }"></fmt:parseNumber>
	<p> Net Salary : ${ pharsedValue * 0.9 } </p>
    <p> Original  Salary : ${ salary } </p>
    <p> Format 1 : <fmt:formatNumber value="${pharsedValue }" groupingUsed="true"></fmt:formatNumber> </p>
    <p> Format 2 : <fmt:formatNumber value="${pharsedValue }" maxFractionDigits="2"></fmt:formatNumber> </p>
    <p> Format 3 : <fmt:formatNumber value="${pharsedValue }" minFractionDigits="7"></fmt:formatNumber> </p>
    <p> Format 4 : <fmt:formatNumber value="${pharsedValue }" maxIntegerDigits="3"></fmt:formatNumber> </p>
    <p> Format 5 : <fmt:formatNumber value="${pharsedValue }" minIntegerDigits="8"></fmt:formatNumber> </p>  
    <p> Type Currency 1 : <fmt:formatNumber value="${pharsedValue }" type="currency" /> </p>
    <p> Type Currency 2 : <fmt:formatNumber value="${pharsedValue }" type="currency" currencyCode="JPY"></fmt:formatNumber> </p>
    <p> Type Currency 3 : <fmt:formatNumber value="${pharsedValue }"  type="currency" currencySymbol="UC"></fmt:formatNumber> </p>
   <p> Format Percent : <fmt:formatNumber value="${0.83 }"  type="percent"></fmt:formatNumber> </p>
    <p> Format Pattern : <fmt:formatNumber value="${pharsedValue }"  type="number" pattern="#.###"></fmt:formatNumber> </p>
    
</body>
</html>