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
										   Successfully Update Tag
										</div>
			         				</c:when>
			               			 <c:otherwise>
			               			 	<div class="alert alert-danger" role="alert">
										   Tag Update Fail
										</div>
			               			 </c:otherwise>
			               		</c:choose>
			                </c:if>
	  	 				<h3 class="text-center">Update Tag</h3>
	  	 					<form action="tag" class="mt-5" method="POST" >
	  	 						<input type="hidden" name="mode" value="UPDATE" />
	  	 						<input type="hidden" name="tagId" value="${tag.id }">
							  <div class="mb-3 mt-5">
								    <label for="tag" class="form-label">Tag Name</label>
								    <input type="text" class="form-control" id="tag" name="name" value="${tag.name }" required >								   
								  </div>
 
								  <button type="submit" class="btn btn-primary float-end ">Update</button>
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