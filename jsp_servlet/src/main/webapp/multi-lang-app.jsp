<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="jakarta.tags.core" prefix="c" %>
     <%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
     
  <c:set var="localeParam" value="${ (not empty param.locale) ? param.locale : pageContext.request.locale}"></c:set>
  <fmt:setLocale value="${localeParam}" />
  <fmt:setBundle basename="i18n_resource.Language"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li><fmt:message key="home" /></li>
		<li> <fmt:message key="services" /> </li>
		<li> <fmt:message key="aboutus" /> </li>
		<li> <fmt:message key="contactus" /></li>
		<li> <fmt:message key="register" /> </li>
	</ul>
	<p> <fmt:message key="content" /></p>
	
	<a href="multi-lang-app.jsp?locale=en_US">English(US)</a>
	<a href="multi-lang-app.jsp?locale=fr_FR">French</a>
	<a href="multi-lang-app.jsp?locale=de_DE">German</a>
	<a href="multi-lang-app.jsp?locale=es_ES">Spain</a>
</body>
</html>