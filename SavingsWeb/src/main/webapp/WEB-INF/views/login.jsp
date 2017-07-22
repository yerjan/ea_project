<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet"	href="<spring:url value="/resource/bootstrap-3.3.7-dist/css/bootstrap.min.css"  htmlEscape="true" />">
<title>Customer List</title>
</head>
<body>
	
	<div class="container">
		<div class='login-container'>
			<div class='login-title'>
				Login
			</div>
			<c:if test="${not empty error}">
					<div class="alert alert-danger">
						<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br />
					</div>
				</c:if>
			<form class="form-horizontal" action="<spring:url value="/postLogin"></spring:url>" method="post">
			  <sec:csrfInput />
			  <div class="form-group">
			    <div>
			      <input type="text" class="form-control" id="username" name='userName' placeholder="Username">
			    </div>
			  </div>
			  <div class="form-group">
			    <div>
			      <input type="password" class="form-control" id="password" name='password'  placeholder="Password">
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <div class="checkbox">
			        <label>
			          <input type="checkbox"> Remember me
			        </label>
			      </div>
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default">Sign in</button>
			    </div>
			  </div>
			</form>
		</div>
	</div>

	<style type="text/css">
		.container{
			width: 100%;
			height: 100%;
			background-repeat: no-repeat;
			background-image: url("<spring:url value="/resource/images/piggy.png"  htmlEscape="true" />");
			position: relative;
		}

		.login-container{
			position: absolute;
			top: 200px;
			left: 200px;
			width: 300px;
			height: 500px;
			padding: 50px;
			background-color: rgba(255, 255, 255, 0.5);

			border-radius: 10px;
		}

		.login-title{
			font-size: 30px;
			text-align: center;
			margin-bottom: 30px;
		}
	</style>
</body>
</html>
