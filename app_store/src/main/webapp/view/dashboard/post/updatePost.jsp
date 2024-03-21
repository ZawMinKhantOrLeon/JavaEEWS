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
	  	 		 <c:import url="../../common/dnav.jsp"></c:import>
	  	 		
	  	 		<div class="container-md">
	  	 			<div class="row">
	  	 				<div class="col-12 col-md-6 mx-auto mt-5">
	  	 				 <c:if test="${ not empty ok  }">
          
			               		<c:choose>
			               			 <c:when test="${ ok }">
			               			 	<div class="alert alert-success" role="alert">
										   Successfully created Post
										</div>
			         				</c:when>
			               			 <c:otherwise>
			               			 	<div class="alert alert-danger" role="alert">
										   Post Creation Fail
										</div>
			               			 </c:otherwise>
			               		</c:choose>
			                </c:if>
	  	 				<h3 class="text-center">Update Post</h3>
	  	 					<form action="post" class="mt-5" method="POST" enctype="multipart/form-data">
	  	 						<input type="hidden" name="mode" value="UPDATE" />
	  	 						<input type="" name="postId" value="${post.id}" />
							  <div class="mb-3 mt-5">
								    <label for="title" class="form-label">Title</label>
								    <input type="text" class="form-control" id="title" value="${post.title }" name="title" required >								   
								  </div>
								  <div class="mb-3">
								    <label for="description" class="form-label">Description</label>
								    <textarea type="text" name="description" class="form-control" id="description" required> value="${post.description }"</textarea>
								  </div>
								   <div class="mb-3">
								    <label for="min_req" class="form-label">Min Req</label>
								   <input type="text" class="form-control" value="${post.min_req }" id="min_req" name="min_req" required >	
								  </div>
								   <div class="mb-3">
								    <label for="image" class="form-label">Image</label>
								   <input type="file" class="form-control" id="image" name="image" required>	
								  </div>
									  
									  <c:forEach var="tag" items="${tags}">
										  <div class="form-check form-check-inline p-4">
											  <input class="form-check-input" name="tag[]" type="checkbox" id="inlineCheckbox1" value="${tag.id}">
											  <label class="form-check-label" for="inlineCheckbox1" >${tag.name}</label>
										  </div>
									  </c:forEach>
									
								  <div class="mb-3">
								    <label for="app_link" class="form-label">App Link</label>
								   <input type="text" class="form-control" id="app_link" value="${post.app_link}" name="app_link" required >	
								  </div>
								 <div class="mb-3">
								    <label for="release_date" class="form-label">Release Date</label>
								      <input type="date" class="form-control" id="release_date" name="release_date" required>	
								  </div>
								  <button type="submit" class="btn btn-primary ">Create</button>
							</form>
	  	 				</div>
	  	 			</div>
	  	 		</div>
	  	 	</div>
	  	 </div>
	  	 
	  </div>


   <c:import url="../../common/footer.jsp"></c:import>
</body>
</html>