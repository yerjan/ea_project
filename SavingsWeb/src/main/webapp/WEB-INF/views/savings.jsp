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
				<a
					href="<spring:url value="/savings/open?accountId=${savings.id}"/>"
					class='btn btn-primary'>Open</a> <a
					href="<spring:url value="/savings/close?accountId=${savings.id}"/>"
					class='btn btn-primary'>Close</a>

			</div>
		</div>
		<div class='detail-container'>
			<fieldset>
				<div class='form-group'>
					<label class='col-sm-4 control-label'>Account id:</label>
					<div>${savings.id}</div>
				</div>
				<div class='form-group'>
					<label class='col-sm-4 control-label'>Name:</label>
					<div>${savings.name}</div>
				</div>
				<div class='form-group'>
					<label class='col-sm-4 control-label'>Start Date:</label>
					<div>${savings.startDate}</div>
				</div>
				<div class='form-group'>
					<label class='col-sm-4 control-label'>End Date:</label>
					<div>${savings.endDate}</div>
				</div>
				<div class='form-group'>
					<label class='col-sm-4 control-label'>Principal:</label>
					<div>${balance.principal}</div>
				</div>
				<div class='form-group'>
					<label class='col-sm-4 control-label'>Interest:</label>
					<div>${balance.interest}</div>
				</div>
				<div class='form-group'>
					<label class='col-sm-4 control-label'>Status:</label>
					<div>${savings.status}</div>
				</div>
			</fieldset>
		</div>

		<div class="subtitle">
			Transactions
			<div>
				<a
					href="<spring:url value="/savings/income?accountId=${savings.id}"/>"
					class='btn btn-primary'>Income</a> <a
					href="<spring:url value="/savings/withdraw?accountId=${savings.id}"/>"
					class='btn btn-primary'>Withdraw</a>
			</div>

		</div>
		<h2></h2>

		<table class="table">
			<thead>
				<tr>
					<th>Tran ID</th>
					<th>Amount</th>
					<th>Currency</th>
					<th>Description</th>
					<th>Type</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="#{transactions}" var="tran">
					<tr>
						<td>${tran.id}</td>
						<td>${tran.currency}</td>
						<td>${tran.amount}</td>
						<td>${tran.description}</td>
						<td>${tran.type}</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>

	<style type="text/css">
.subtitle {
	margin-top: 20px;
	font-size: 28px;
	border-left: 4px solid orange;
	padding-left: 5px;
}

.subtitle a {
	margin-left: 10px;
	float: right;
}

.subtitle div {
	float: right;
}

.detail-container {
	padding: 20px;
	margin-top: 10px;
	background-color: #eee;
}

fieldset>.form-group {
	width: 600px;
	font-size: 18px;
}

fieldset .form-group>div {
	color: #000066;
	font-weight: bold;
}
</style>
</body>
</html>
