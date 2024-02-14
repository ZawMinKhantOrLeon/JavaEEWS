<%@page import="java.time.DayOfWeek"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scriptlet</title>
</head>
<body>
	
		<%
			
		LocalDateTime dateTime=LocalDateTime.now();
		DayOfWeek dOfW=  dateTime.getDayOfWeek();
		
		
		String message ="";
		switch(dOfW){
			
		case MONDAY:
			message= " Hello happy monday";
			break;
		case TUESDAY:
			message= " Hello happy tuesday";
			break;
		case WEDNESDAY:
			message= " Hello happy wednesdy";
			break;
		case THURSDAY:
			message= " Hello happy thursday";
			break;
		case FRIDAY:
			message= " Hello happy friday";
			break;
		case SATURDAY:
			message= " Hello happy saturday";
			break;
		case SUNDAY:
			message= " Hello happy sunday";
			break;
			
		default: 
			message="Invalid Date";
			break;
		}
		
		out.print("<h1>"+ message +"</h1>");
		
		int hour = dateTime.getHour();
		String message2 ="";
		if(hour >= 21){
			message2="Good Night";
		}
		else if (hour >= 16 ){
			message2 = "Good Evening";
		}
		else if(hour >=12 ){
			message2="Good afternoon";
		}
		else{
			message2="good morning";
		}
		
		out.print("<h1>"+ message2 + "</h1>");
		
		%>

</body>
</html>