<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<spring:url value="/resource/bootstrap-3.3.7-dist/css/bootstrap.min.css"  htmlEscape="true" />">
<title>Savings Detail</title>
</head>
<body>
	
	<div class="container">

		<div class="subtitle">
			Savings Information
			<div>
				<a href="#" class='btn btn-primary'>Add Account</a>
				<a href="#" class='btn btn-primary'>button</a>
			</div>
		</div>
		<div class='detail-container'>
			<fieldset>
				<div class='form-group'><label class='col-sm-4 control-label'>Name:</label> <div>${customer.firstName} ${customer.lastName} </div></div>
				<div class='form-group'><label class='col-sm-4 control-label'>Email:</label> <div>${customer.email}</div></div>
				<div class='form-group'><label class='col-sm-4 control-label'>Status:</label> <div>${customer.status}</div></div>
				<div class='form-group'><label class='col-sm-4 control-label'>Credit Score:</label> <div>${customer.creditScore}</div></div>
			</fieldset>
		</div>

		<div class="subtitle">
			Saving Accounts
			<div>
				<a href="#" class='btn btn-primary'>Add New Account</a>
			</div>
		</div>
		<h2></h2>

		<table class="table">
			<thead>
				<tr>
					<th>Account ID</th>
					<th>Name</th>
					<th>Currency</th>
					<th>Status</th>
					<th>Interest Rate</th>
					<th>Starting Date</th>
					<th>Ending Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="#{savings}" var="saving">
					<tr>
						<td>${saving.id}</td> 
						<td><a href="view2.html">${saving.name}</a> </td>
						<td>${saving.currency}</td>
						<td>${saving.status}</td>
						<td>${saving.interestRate}</td>
						<td>${saving.startDate}</td>
						<td>${saving.endDate}</td>

					</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>
	
	<style type="text/css">
		.subtitle{
			margin-top: 20px;
			font-size: 28px;
			border-left: 4px solid orange;
			padding-left: 5px;
		}
		.subtitle a{ margin-left: 10px; float: right;}
		.subtitle div{float: right;}


		.detail-container{
			padding: 20px;
			margin-top: 10px;
			background-color: #eee;
		}

		fieldset > .form-group{
			width: 600px;
			font-size: 18px;
		}

		fieldset .form-group > div{
			color: #000066;
			font-weight: bold;
		}

	</style>
</body>
</html>
