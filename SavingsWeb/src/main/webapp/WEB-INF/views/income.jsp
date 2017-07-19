<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Income</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Valued Users</h1>
				<p>Add a new one
				<p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form modelAttribute="newTransaction" class="form-horizontal">
			<fieldset>
				<legend>Make income</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div" />

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
</body>
</html>
