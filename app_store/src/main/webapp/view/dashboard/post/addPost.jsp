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
	  	 				<div class="col-12 col-md-6 mx-auto">
	  	 				<h3 class="text-center">Create Post</h3>
	  	 					<form action="post?mode=CREATE" class="mt-5" method="POST" enctype="multipart/form-data">
	  	 						<input type="text" class="form-control" hidden name="mode" value="CREATE">
							  <div class="mb-3 mt-5">
								    <label for="title" class="form-label">Title</label>
								    <input type="text" class="form-control" id="title" name="title" >								   
								  </div>
								  <div class="mb-3">
								    <label for="description" class="form-label">Description</label>
								    <textarea type="text" name="description" class="form-control" id="description"> </textarea>
								  </div>
								   <div class="mb-3">
								    <label for="min_req" class="form-label">Min Req</label>
								   <input type="text" class="form-control" id="min_req" name="min_req" >	
								  </div>
								   <div class="mb-3">
								    <label for="image" class="form-label">Image</label>
								   <input type="file" class="form-control" id="image" name="image" >	
								  </div>
								 <div class="mb-3">
								    <label for="release_date" class="form-label">Release Date</label>
								      <input type="date" class="form-control" id="release_date" name="release_date" >	
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