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
		<div class='controller'>
			Controller
			<button class='btn btn-primary'>Add Account</button>
			<button class='btn btn-primary'>button</button>
			<button class='btn btn-primary'>Create Account</button>
			<button class='btn btn-primary'>Create Account</button>
		</div>
		<h2>Customer Info</h2>
		<div class='detail-container'>
			<fieldset>
				<div class='form-group'><label class='col-sm-4 control-label'>Name:</label> <div>${customer.firstName} ${customer.lastName} </div></div>
				<div class='form-group'><label class='col-sm-4 control-label'>Email:</label> <div>${customer.email}</div></div>
				<div class='form-group'><label class='col-sm-4 control-label'>Status:</label> <div>${customer.status}</div></div>
				<div class='form-group'><label class='col-sm-4 control-label'>Credit Score:</label> <div>${customer.creditScore}</div></div>
			</fieldset>
		</div>

		<h2>Accounts</h2>

		<table class="table">
			<thead>
				<tr>
					<th>Account ID</th>
					<th>Name</th>
					<th>Type</th>
					<th>Status</th>
					<th>Starting Date</th>
					<th>Ending Date</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</th> 
					<td><a href="view2.html">Future Saving</a> </td>
					<td>Saving</td>
					<td>Active</td>
					<td>2017-02-04</td>
					<td>2017-02-04</td>
				</tr>
				<tr>
					<td>1</th> 
					<td><a href="view2.html">Dream</a> </td>
					<td>Saving</td>
					<td>Active</td>
					<td>2017-02-04</td>
					<td>2017-02-04</td>
				</tr>
				<tr>
					<td>1</th> 
					<td><a href="view2.html">Salary</a> </td>
					<td>Saving</td>
					<td>Active</td>
					<td>2017-02-04</td>
					<td>2017-02-04</td>
				</tr>
			</tbody>
		</table>
	</div>

	<style type="text/css">
		h1, h2{
			border-left: 4px solid orange;
			padding-left: 5px;
		}
		.controller{
			padding: 10px;
			padding-left: 20px;
			background-color: #ccc;
			overflow: hidden;
			line-height: 35px;
			font-size: 24px;
		}
		.controller button{ margin-left: 10px; float: right; }

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
