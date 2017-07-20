<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<spring:url value="/resource/bootstrap-3.3.7-dist/css/bootstrap.min.css"  htmlEscape="true" />">
<title>Savings create</title>
</head>
<body>

	<div class="container">

		<div class="subtitle">Create New Account</div>
		<div class='detail-container'>


			<section class="container">
				<form:form modelAttribute="newTransaction" class="form-horizontal">
					<fieldset>
						<legend>Make income</legend>

						<form:errors path="*" cssClass="alert alert-danger" element="div" />

						<div class="form-group">
							<label for="accountName" class="col-sm-2 control-label">Name</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="accountName"
									name="name" placeholder="Name">
							</div>
						</div>
						<div class="form-group">
							<label for="currency" class="col-sm-2 control-label">Currency</label>
							<div class="col-sm-10">

								<select id="currency" class="form-control" name="currency">
									<option>USD</option>
									<option>MNT</option>
									<option>BitCoin</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="interestRate" class="col-sm-2 control-label">Interest
								Rate</label>
							<div class="col-sm-10">
								<select id="currency" class="form-control" name="currency">
									<option>2% annual</option>
									<option>5% annual</option>
									<option>9% annual</option>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label for="startDate" class="col-sm-2 control-label">Start
								Date</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="startDate"
									name="startDate" placeholder="MM/DD/YYYY">
							</div>
						</div>
						<div class="form-group">
							<label for="endDate" class="col-sm-2 control-label">Interest
								Rate</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="endDate"
									name="endDate" placeholder="MM/DD/YYYY">
							</div>
						</div>


						<div class="form-group">
							<div class="col-lg-offset-2 col-lg-10">
								<input type="submit" id="btnAdd" class="btn btn-primary"
									value="Save" />
							</div>
						</div>



					</fieldset>
				</form:form>
			</section>

		</div>



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

#interestRate, #currency {
	width: 130px;
}

#accountName, #startDate, #endDate {
	width: 200px;
}
</style>
</body>
</html>
