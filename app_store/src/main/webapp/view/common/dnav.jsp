  <%@ taglib uri="jakarta.tags.core" prefix="c" %>
  
   <c:set var="user" value="${sessionScope.user }" />
   
   <nav class="navbar navbar-expand-lg navbar-light bg-light">
         <div class="container-fluid">
           <a class="navbar-brand" href="item">AppStore</a>
           <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
             <span class="navbar-toggler-icon"></span>
           </button>
           <div class="collapse navbar-collapse" id="navbarSupportedContent">
             <ul class="navbar-nav me-auto mb-2 mb-lg-0">
               <li class="nav-item">
                 <a class="nav-link active" aria-current="page" href="item">Home</a>
               </li>
               <li class="nav-item dropdown">
                 <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Control
                 </a>
                 <ul class="dropdown-menu" aria-labelledby="navbarDropdown">      
		               <li><a class="dropdown-item" href="#">Add Post</a></li>
		               <li><a class="dropdown-item" href="post?mode=POSTLIST">Post List</a></li>
		               <li><a class="dropdown-item" href="#">Add Tag</a></li>
		               <li><a class="dropdown-item" href="#">Tag List</a></li>
		               <li><a class="dropdown-item" href="#">Users</a></li>
                 </ul>
               </li>
               
             </ul>
            
           </div>
         </div>
    </nav>
                      