<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<title>Income transaction</title>
</head>
<body>

	<div class="subtitle">Income transaction</div>

	<div class="detail-container">
		<section class="container">
			<form:form modelAttribute="newTransaction" class="form-horizontal">
				<fieldset>
					<legend>Make income</legend>

					<form:errors path="*" cssClass="alert alert-danger" element="div" />

					<div class="form-group">
						<label class="control-label col-lg-2" for="account">Account</label>
						<div class="col-lg-10">
							<form:input id="account" path="savings.id" type="text"
								class="form:input-large" />
							<form:errors path="savings.id" cssClass="text-danger" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-lg-2" for="amount">Amount</label>
						<div class="col-lg-10">
							<form:input id="amount" path="amount" type="text"
								class="form:input-large" />
							<form:errors path="amount" cssClass="text-danger" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-lg-2" for="description">Description</label>
						<div class="col-lg-10">
							<form:input id="description" path="description" type="text"
								class="form:input-large" />
							<form:errors path="description" cssClass="text-danger" />
						</div>
					</div>


					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<input type="submit" id="btnAdd" class="btn btn-primary"
								value="Process" />
						</div>
					</div>



				</fieldset>
			</form:form>
		</section>
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
