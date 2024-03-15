<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <c:import url="./common/header.jsp"></c:import>
</head>
<body>
	
   <div class="container-fluid">
   	 <div class="row">
   	 	<div class="col-12">
   	 		<c:import url="./common/nav.jsp"></c:import>
   	 		
   	 		<div class="container-md">
   	 			<div class="row">
   	 				<div class="col-12 col-md-8">
   	 					<c:forEach var="post" items="${posts}">
   	 						<div class="card m-5">
   	 							<div class="card-img">
   	 								<img alt="image" class="img-fluid" src="${post.image}">
   	 							</div>
   	 							<div class="card-body text-center">
   	 								<h4 class="card-title">${ post.title }</h4>
   	 								
   	 								<p class="card-text">${post.description }</p>
   	 							
   	 							</div>
   	 							 <button href="#" class="btn btn-info">View</button>
   	 						</div>
   	 					</c:forEach>
   	 				</div>
   	 			</div>

   	 		</div>
   	 	</div>
   	 </div>
   </div>
   
   	

   <c:import url="./common/footer.jsp"></c:import>
</body>
</html>