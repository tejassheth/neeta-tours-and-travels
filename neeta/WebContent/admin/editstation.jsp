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
<title>Edit Station</title>
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
<script src="js/jquery.validate.min.js"></script>
<script src="js/jquery-1.8.2.js"></script>
<script type="text/javascript">
	function loadStation() {
		$.getJSON("../JSONAllStations", function(obj) {
			//alert(obj.Result);
			$('#station').empty();
			$("#station").append(new Option("--Select Station--",	0));
			for ( var propertyName in obj.Data) {
				$("#station").append(
						new Option(obj.Data[propertyName].stationName,
								obj.Data[propertyName].staionId));
			}
		});
	}
	$(document).ready(function() {
		loadStation();
		//var obj = ({"Data":{"Alabama":"01","Alaska":"02","Arizona":"03","Arkansas":"04","California":"05","Colorado":"06","Connecticutt":"07","Delaware":"08","Florida":"09","Georgia":"10","Hawaii":"11","Idaho":"12","Illinois":"13","Indiana":"14","Iowa":"15","Kansas":"16","Kentucky":"17","Louisiana":"18","Maine":"19","Massachusetts":"20","Michigan":"21"}});
		$("#Frm").submit(function(e) {
			//$('#Frm').validate();
			var station_name = $("#station :selected").text();
			var station_id = $("#station").val();
			var new_station_name = $("#station_name").val();
			//alert(station_name+ " "+station_id+" "+new_station_name);
			if(new_station_name!='')
			{
			$.post("../JSONEditStation", {
					"station_name" : station_name,
					"station_id": station_id,
					"new_station_name" : new_station_name
			}, function(data) {
				var result = data.Result;
				if (result == "False") {
					$("#result").html("Not Updated  !! Try Again");
				}
				if (result == "True") {
					$("#result").html("Updated  Succesfully");
					$("#station_name").val('');
					e.preventDefault();
				}
				$("#result").show();
				$("#stationname").val("");
				loadStation();
				}, "json");
				e.preventDefault();
			}
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
			<h2 class="heading">Edit Station</h2>
			<form class="form-inline label-150" method="post" action="#" id="Frm" onSubmit="">
				<p id="result" align="center"></p>
				<p>
					<label for="state">Select Station :</label> <select class="span2"
						name="station" id="station">
					</select>
				</p>
				<p>
					<label for="city">Enter Station Name:</label> 
					<input type="text" name="stationname" class="span2" id="station_name" required="required">
				</p>
				<p>
					<input class="btn btn-primary btn-modify" type="submit" id="submit" name="submit" value="Edit Station">
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
	<script src="js/bootstrap.js"></script>        	
        <script src="js/main.js"></script>
	<script src="js/jquery.validate.min.js" type="text/javascript"></script>
        <script type="text/javascript">
        	$('#submit').click(function(){
        		$("#Frm").validate();
        	});
        </script>
	
</body>
</html>
