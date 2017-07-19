<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<spring:url value="/resource/bootstrap-3.3.7-dist/css/bootstrap.min.css"  htmlEscape="true" />">
<title>Customer List</title>
</head>
<body>

	
	<div class="container">
		<h1>Customer List</h1>
		<div>

		<table class="table">
			<thead>
				<tr>
					<th>Customer ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Status</th>
					<th>Credit Score</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="#{customers}" var="customer">
					<tr>
						<th>1</th> 
						<td><a href="<spring:url value="/customers/${customer.id}"/>">${customer.firstName} ${customer.lastName}</a> </td>
						<td>${customer.email}</td>
						<td>${customer.status}</td>
						<td>${customer.creditScore}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</div>
</body>
</html>
