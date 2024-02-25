<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
         <c:import url="../common/header.jsp"></c:import>
</head>
<body>
      <!--navstart-->
   		<c:import url="../common/nav.jsp"></c:import>
   	  <!--navend-->
    <div class="container-md my-3 ">
        <div class="col-md-8 mx-auto">
            <div class="card" >
                <div class="card-body">
                <!-- Alert if ok creation -->
                <c:if test="${ not empty ok  }">
                
               		<c:choose>
               			 <c:when test="${ ok }">
               			 	<div class="alert alert-success" role="alert">
							   Successfully created Item
							</div>
         				</c:when>
               			 <c:otherwise>
               			 	<div class="alert alert-danger" role="alert">
							   Item Creation Fail
							</div>
               			 </c:otherwise>
               		</c:choose>
                </c:if>
                
                 <h5 class="card-title">Add Item form</h5>
                 <form class="mx-auto" action="item" method="POST">
                 	
                 	<input type="hidden" name="mode" value="CREATE" />
                     <div class=" mb-3">
                       <label for="name" class="form-label">Name</label>
                       <input type="text" name="name" class="form-control" id="name" required="required" >                       
                     </div>
                     <div class=" mb-3">
                       <label for="category" class="form-label">Category</label>
                       <input type="text" name="category" class="form-control" id="category" required="required">
                     </div>
                     <div class=" mb-3">
                       <label for="price" class="form-label">Price</label>
                       <input type="text" name="price" class="form-control" id="price" required="required">
                     </div>
                     <div class=" mb-3">
                       <label for="quantity" class="form-label">Quantity</label>
                       <input type="number" name="quantity" class="form-control" id="quantity" required="required">
                     </div>
                     <div class=" mb-3">
                       <label for="image" class="form-label">Image</label>
                       <input type="text" name="image" class="form-control" id="image" required="required">
                     </div>
                     <div class=" mb-3">
                       <label for="description" class="form-label">Description</label>
                       <textarea  name="description" rows="5" class="form-control" id="description" required="required" ></textarea>
                     </div>
                     <div class="mb-3 form-check">
                       <input type="checkbox" class="form-check-input" id="essential" name="essential" value="true" >
                       <label class="form-check-label" for="essential">Essential ?</label>
                     </div>
                     <button type="submit" class="btn btn-primary float-end">Create</button>
                   </form>
                </div>
               </div>
        </div>
       
    </div>
     <c:import url="../common/footer.jsp"></c:import>
</body>
</html>