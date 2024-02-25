<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">
    <head>
      <c:import url="../common/header.jsp"></c:import>
    </head>
    <body>
        
      
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
    
                    <!--navstart-->
                 		<c:import url="../common/nav.jsp"></c:import>
                 	<!--navend-->
                      <!--main content start-->
                      
                      <div class="container-md my-3">
                      
                      <h1 class="text-center">Item Detail</h1>
                      <c:if test="${ not empty ok and not ok  }">
                
		               		<div class="alert alert-danger" role="alert">
									   Deleting Item is Fail
							</div>
		               </c:if>
                        <div class="row ">
                        
                  
                          		  <div class="col-md-8  mx-auto mt-3">
                                <div class="card" >
                                    <img src="${item.image }" class="card-img-top" style="height:36rem;" alt="...">
                                    <div class="card-body text-center">
                                      <h3 class="card-title">Name : ${item.name }</h3>
                                      <p class="card-text">Category : ${item.category }</p>
                                      <p class="card-text">Price :$${item.price }</p>
                                      <p class="card-text">Quantity : ${item.quantity }</p>
                                      <p class="card-text">SubTotal : ${item.subTotal }</p>
                                      <p class="card-text">Date : ${item.issuedDate }</p>
                                      <p class="card-text">Essential : ${item.essential ? "yes": "no" }</p>
                                      <h5 class="card-text">Description </h5>
                                      <p class="card-text"> ${item.description }</p>
                                      
                                      <c:url var="updateLink" value="item">
                                      		<c:param name="mode" value="LOAD"></c:param>
                                      		<c:param name="itemId" value="${item.id }"></c:param>
                                      </c:url>
                                      <c:url var="deleteLink" value="item">
                                      		<c:param name="mode" value="DELETE"></c:param>
                                      		<c:param name="itemId" value="${item.id }"></c:param>
                                      </c:url>
                                      <a href="${updateLink }" class="btn btn-secondary">Edit</a>
                                      <a href="${deleteLink }" class="btn btn-danger">Delete</a>
                                    </div>
                                  </div>
                                  
                            </div>
                          
                           
                        </div>
                      </div>
                      <!--main content end-->
                </div>
            </div>
        </div>
     
     <c:import url="../common/footer.jsp"></c:import>
    </body>
    </html>