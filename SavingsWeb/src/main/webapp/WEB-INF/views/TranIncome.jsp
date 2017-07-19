<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<title>Income transaction</title>
</head>
<body>
	
	<div class="container">

		<div class="subtitle">
			Transaction Income
			<div>
				<a href="#" class='btn btn-primary'>Add Account</a>
				<a href="#" class='btn btn-primary'>button</a>
			</div>
		</div>
		<div class='detail-container'>

			<form class="form-horizontal">
			  <div class="form-group">
			    <label for="accountName" class="col-sm-2 control-label">Name</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="accountName" name="name" placeholder="Name">
			    </div>
			  </div>
			  

			 <div class="form-group">
			    <label for="description" class="col-sm-2 control-label">description</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="description" name="description" placeholder="description">
			    </div>
			  </div>


			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-success">Create</button>
			    </div>
			  </div>
			</form>
		</div>


		
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
		#interestRate, #currency{ width: 130px; }
		#accountName, #startDate, #endDate{  width: 200px; }
	</style>
</body>
</html>
