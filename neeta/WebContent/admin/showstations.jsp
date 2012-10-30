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
<title>Stations List</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-responsive.css">
<link rel="stylesheet" href="css/main.css">
<style>
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.white-block {
	width: 80%;
}
</style>
<script src="js/handlebars-1.0.rc.1.js"></script>
<script id="result-template" type="text/x-handlebars-template">
{{#each Data}}
<tr>
		<td>{{staionId}}</td>
		<td>{{stationName}}</td>
</tr>
{{/each}}
</script>

<script src="js/modernizr-2.6.1-respond-1.1.0.min.js"></script>
<script src="js/jquery-1.8.2.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$.getJSON("../JSONAllStations", function(obj) {
			var source = $("#result-template").html();
			var template = Handlebars.compile(source);
			//var data={"Data":[{"staionId":"1","stationName":"ahmedabad"},{"staionId":"7","stationName":"Bhavnagar"},{"staionId":"6","stationName":"Jamnagar"},{"staionId":"2","stationName":"Limbdi"},{"staionId":"4","stationName":"mumbai"}]}
			Handlebars.registerHelper('each', function(context, options) {
			var ret="";
				for(var prop in context)
			    {	
					 //ret = ret + options.fn({staionId:prop,value:context[prop]});
			        ret=ret+"<tr><td>"+(parseInt(prop)+1)+"</td><td>"+context[prop].stationName+"</td></tr>";
			    }
				return ret;
			});
			$("#station_table").append(template(obj));
			//console.log(template(obj)); 
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
			<h2 class="heading">Station List</h2>
			<div align="center">
				<div class="white-block">
					<table cellpadding="0" cellspacing="0" id="station_table">
						<tr>
							<th>No</th>
							<th>Station Name</th>
						</tr>
					</table>
				</div>
			</div>
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

</body>
</html>
