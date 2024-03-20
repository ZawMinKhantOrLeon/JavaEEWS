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
   	 					
   	 					   <c:url var="detailLinks" value="post">
                          	<c:param name="mode" value="DETAIL"></c:param>
                          	<c:param name="postId" value="${post.id }"></c:param>
                          </c:url>
                          
   	 						<div class="card m-5">
   	 							<div class="card-img">
   	 								<img alt="image" class="img-fluid" src=" <%= request.getContextPath() %>/resource/image/${post.image}">
   	 							</div>
   	 							<div class="card-body text-center">
   	 								<h4 class="card-title">${ post.title }</h4>
   	 								
   	 								<h6 class="card-text">${post.description }</h6>
   	 								
   	 							
   	 							</div>
   	 							 <a href="${detailLinks }" class="btn btn-secondary">View</a>
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