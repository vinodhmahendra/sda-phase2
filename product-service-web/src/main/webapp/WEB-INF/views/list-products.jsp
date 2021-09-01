<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
	<title>List Products</title>
	
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Simplilearn, e-commerce application</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
		<input type="button" value="Add Product"
			onclick="window.location.href='showFormForAdd'; return false;" class="add-button"/>
		
		
		<table>
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Product Added Date </th>
				<th>Action</th>
			</tr>
			
			<c:forEach var="tempProduct" items="${products}">
			
			<c:url var="updateLink" value="/products/showFormForUpdate">
				<c:param name="productId" value="${tempProduct.id}"></c:param>
			</c:url>
			
			<c:url var="deleteLink" value="/products/delete">
				<c:param name="productId" value="${tempProduct.id}"></c:param>
			</c:url>
			<tr>
				<td>${tempProduct.name}</td>
				<td>${tempProduct.price}</td>
				<td>${tempProduct.dateAdded}</td>
				
				<td>
					<a href="${updateLink}">update</a> |
					
					<a href="${deleteLink}" onclick="if (!confirm('Are you sure you want to delete this product?')) return false">delete</a>
				</td>
			</tr>
				
			</c:forEach>
		</table>
		
		</div>
	</div>

</body>
</html>