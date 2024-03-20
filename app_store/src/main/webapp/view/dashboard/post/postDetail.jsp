<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <c:import url="../../common/header.jsp"></c:import>
</head>
<body>
		
		
	  <div class="container-fluid">
	  	 <div class="row">
	  	 	<div class="col-12">
	  	 		 <c:import url="../../common/nav.jsp"></c:import>
	  	 		
	  	 		<div class="container">
	  	 			<div class="row p-5">
	  	 				<div class="col-12 col-md-6">
	  	 					<img alt="" class="w-100" src="<%= request.getContextPath() %>/resource/image/${post.image}">
	  	 				</div>
	  	 				<div class="col-12 col-md-6">
	  	 					<h4>${post.title}</h4>
	  	 					<p>${post.description}</p>
	  	 				</div>
	  	 			</div>
	  	 		</div>
	  	 	</div>
	  	 </div>
	  	 
	  </div>


   <c:import url="../../common/footer.jsp"></c:import>
</body>
</html>