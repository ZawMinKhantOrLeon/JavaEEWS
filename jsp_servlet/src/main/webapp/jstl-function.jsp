<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="jakarta.tags.core" prefix="c" %>
  <%@ taglib uri="jakarta.tags.functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jstl Functions Jsp</title>
</head>
<body>
	
	<c:set var="testStr" value="I Like Reading with MgMg"></c:set>
	<c:set var="dateArray" value="${ fn:split('2002-10-6','-') }"></c:set>
	<c:set var="spaceStr" value="          test              "></c:set>
	<c:set var="xmlString" value="<hello> BoBo </hello>" > </c:set>
	
	<p> apple -> upperCase : ${ fn:toUpperCase("apple") } </p>
	<p> Apple -> loweCase : ${ fn:toLowerCase("apple") } </p>
	<p>MgMg Contains ? ${ fn:contains(testStr,"mgmg") }</p>
	<p>MgMg Contains ? ${ fn:containsIgnoreCase(testStr,"mgmg") }</p>
	<p>MgMg startsWith ? ${ fn:startsWith(testStr,"I") }</p>
	<p>MgMg endsWith ? ${ fn:endsWith(testStr,"Mg") }</p>
	<p> testStr has ${fn:length(testStr) } length </p>
	<p> Index Of R ? ${ fn:indexOf(testStr,"R") }</p>
	<p>subString : ${ fn:substring(testStr,0,6) }</p>
	<p>subStringAfter : ${ fn:substringAfter(testStr,"Reading") }</p>
	<p>subStringBefore : ${ fn:substringBefore(testStr,"Reading") }</p>
	<p>Replace : ${ fn:replace(testStr,"MgMg","ZawMinKhant") }</p>
	<p> year: ${ dateArray[0] } </p>
	<p> month: ${ dateArray[1] } </p>
	<p> day: ${ dateArray[2] } </p>
	<p> Join Date : ${fn:join(dateArray,"-") } </p>
	<p> Trim : ${fn:trim(spaceStr) }</p>
	<p> Escape Xml : ${ fn:escapeXml(xmlString)  } </p>
</body>
</html>