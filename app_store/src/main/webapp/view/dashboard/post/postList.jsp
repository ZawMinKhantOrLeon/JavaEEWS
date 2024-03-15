<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.0.js"
	type="text/javascript"></script>
<c:import url="../../common/header.jsp" />
<link
	href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.min.css"
	rel="stylesheet">
<link
	href="https://cdn.datatables.net/1.13.7/css/dataTables.bootstrap5.min.css"
	rel="stylesheet">
<script
	src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"
	type="text/javascript"></script>
</head>
<body>
	<c:import url="../../common/dnav.jsp" />

	<div class="container mt-5">
		<table id="example" class="table table-striped" style="width: 100%">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Description</th>
					<th>Image</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="post" items="${posts}">
					<tr>
						<td>${post.id }</td>
						<td>${post.title }</td>
						<td>${post.description }</td>
						<td>${post.image }</td>
						<td>
						  <button class="btn btn-primary" >Update</button>
						  <button class="btn btn-danger">Danger</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			
		</table>
	</div>

	<script type="text/javascript">
		new DataTable('#example');
	</script>
	<c:import url="../../common/footer.jsp" />
</body>
</html>