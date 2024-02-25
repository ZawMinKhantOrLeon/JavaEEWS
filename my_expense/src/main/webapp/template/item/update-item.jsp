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
                <c:if test="${ not empty ok and not ok  }">
                
               		<div class="alert alert-danger" role="alert">
							   Updating Item is Fail
					</div>
                </c:if>
                
                 <h5 class="card-title">Update Item form</h5>
                 <form class="mx-auto" action="item" method="POST">
                 	
                 	<input type="hidden" name="mode" value="UPDATE" />
                 	<input type="hidden" name="itemId" value="${item.id }" />
                 	
                     <div class=" mb-3">
                       <label for="name" class="form-label">Name</label>
                       <input type="text" name="name" class="form-control" id="name" required="required" value="${item.id }" >                       
                     </div>
                     <div class=" mb-3">
                       <label for="category" class="form-label">Category</label>
                       <input type="text" name="category" class="form-control" id="category" required="required" value="${item.category }">
                     </div>
                     <div class=" mb-3">
                       <label for="price" class="form-label">Price</label>
                       <input type="text" name="price" class="form-control" id="price" required="required" value="${item.price }">
                     </div>
                     <div class=" mb-3">
                       <label for="quantity" class="form-label">Quantity</label>
                       <input type="number" name="quantity" class="form-control" id="quantity" required="required" value="${item.quantity }">
                     </div>
                     <div class=" mb-3">
                       <label for="image" class="form-label">Image</label>
                       <input type="text" name="image" class="form-control" id="image" required="required" value="${item.image }">
                     </div>
                     <div class=" mb-3">
                       <label for="description" class="form-label">Description</label>
                       <textarea  name="description" rows="5" class="form-control" id="description" required="required" >${item.description }</textarea>
                     </div>
                     <div class="mb-3 form-check">
                       <input type="checkbox" class="form-check-input" id="essential" checked="${item.essential ? true:false }" name="essential" value="true" required="required">
                       <label class="form-check-label" for="essential">Essential ?</label>
                     </div>
                     <button type="submit" class="btn btn-primary float-end">Update</button>
                   </form>
                </div>
               </div>
        </div>
       
    </div>
     <c:import url="../common/footer.jsp"></c:import>
</body>
</html>