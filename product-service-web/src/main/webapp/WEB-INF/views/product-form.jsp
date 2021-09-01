
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>


<html>


<head>

<title>Save Product</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-product-style.css" />

</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Simplilearn, e-commerce application</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Product</h3>
		
		<form:form action="saveProduct" modelAttribute="product" method="post">
		
			<table>
				<tbody>
					<tr>
						<td><label>Name : </label></td>
						<td><form:input path="name"/></td>
					</tr>
					<tr>
						<td><label>Price : </label></td>
						<td><form:input path="price"/></td>
					</tr>
					
					<tr>
						<td><label> </label></td>
						<td><input type="submit" value="Save" class="save"></td>
					</tr>
				</tbody>
			</table>
			
		</form:form>
		
		<div style="clear; both;"></div>
	
		<p>
			<a href="${pageContext.request.contextPath}/products/list">Back to list</a>
		</p>

	</div>
</body>
</html>