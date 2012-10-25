<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>New Bus</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">

<link rel="stylesheet" href="css/bootstrap.css">
<style>
body {
	padding-top: 60px;
	padding-bottom: 40px;
}
</style>
<link rel="stylesheet" href="css/bootstrap-responsive.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/jquery.ui.timepicker.css">
<link rel="stylesheet" href="css/jquery-ui-1.8.24.custom.css">
<script src="js/modernizr-2.6.1-respond-1.1.0.min.js"></script>
<script src="js/jquery-1.8.2.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$.getJSON("JSONAllState", function(obj) {
					//alert(obj.Result);
					for ( var propertyName in obj.Data) {
						$("#dest_State").append(
								new Option(obj.Data[propertyName].sName,
										obj.Data[propertyName].id));
						$("#source_State").append(
								new Option(obj.Data[propertyName].sName,
										obj.Data[propertyName].id));
					}
				});
				$("#dest_State").change(function () {
					var stateId = $("#dest_State").val();
					$('#dest_City').empty();
					$("#dest_City").append(new Option("--Select Route--",	0));
					$.post("JSONAllCity",{stateId:stateId}, function(obj) {
						//alert(obj.Result);
						for ( var propertyName in obj.Data) {
							$("#dest_City").append(
											new Option(obj.Data[propertyName].cName,
											obj.Data[propertyName].cityId));
												
						}
					},"json");
				});
				$("#source_State").change(function () {
					var stateId = $("#source_State").val();
					$('#source_City').empty();
					$("#source_City").append(new Option("--Select Route--",	0));
					$.post("JSONAllCity",{stateId:stateId}, function(obj) {
						//alert(obj.Result);
						for ( var propertyName in obj.Data) {
							$("#source_City").append(
											new Option(obj.Data[propertyName].cName,
											obj.Data[propertyName].cityId));
												
						}
					},"json");
				});
			        
			});
</script>
</head>
<body>
	<!--[if lt IE 7]>
            <p class="chromeframe">You are using an outdated browser. <a href="http://browsehappy.com/">Upgrade your browser today</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to better experience this site.</p>
        <![endif]-->

	<!-- This code is taken from http://twitter.github.com/bootstrap/examples/hero.html -->

	<jsp:include page="menu.jsp" flush="true"></jsp:include>

	<div class="container">

		<!-- Main hero unit for a primary marketing message or call to action -->
		<div class="hero-unit">
			<form class="form-inline label-150" method="post" action=""
				onSubmit="">
				<p>
					<label for="source_loc">Source :</label> <select class="span2"
						name="source_State" id="source_State">
						<option value="0">--Select State--</option>
						</select> 
						<select	class="span2" name="source_City" id="source_City">
						<option value="0">--Source City--</option>
					</select>
				</p>
				<p>
					<label for="destination_loc">Destination :</label> <select
						class="span2" name="destination_State" id="dest_State">
						<option value="0">--Select State--</option>
						</select> 
						<select	class="span2" name="destination_City" id="dest_City">
						<option value="0">--Destination City--</option>
						</select>
				</p>
				<p>
					<label for="time">Departure Time:</label> <input type="text"
						name="time" class="span2" id="time" readonly>
				</p>
				<p>
					<label for="">Route:</label> <select class="span2" name="route"
						id="route">
						<option value="0">--Select Route--</option>
						<option value="">Ahmedabad-Vadodara</option>
						<option value="">Rajkot-Surat</option>
					</select>
				</p>
				<p>
					<input class="btn btn-primary btn-modify" type="submit"
						name="submit" value="Add Bus">
				</p>
			</form>
		</div>

		<!-- Example row of columns -->


		<hr>

		<footer>
			<p>&copy; Company 2012</p>
		</footer>

	</div>
	<!-- /container -->

	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="js/jquery-1.8.2.js"><\/script>')
	</script>
	<script src="js/jquery-ui-1.8.24.custom.min.js"></script>
	<script src="js/jquery-ui-timepicker-addon.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#time").timepicker();
		});
	</script>
	<script src="js/bootstrap.js"></script>

	<script src="js/main.js"></script>

</body>
</html>
