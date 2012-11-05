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
<title>Routes</title>
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
form {
	margin: 0;
}
.btn-padd-2{
	padding: 2px 20px 2px 20px;
}
</style>
<script src="js/modernizr-2.6.1-respond-1.1.0.min.js"></script>
<script src="js/jquery-1.8.2.js"></script>
<script src="js/handlebars-1.0.rc.1.js"></script>
<link href="css/loadover.css" rel="stylesheet" type="text/css">
<script src="js/loadover.js"></script>

<script id="route-template" type="text/x-handlebars-template">
{{#each Data}}
<div class="accordion-group">
	<div class="accordion-heading routeid">
		<span>Route-{{routeId}}  {{source}} To  {{desti}}</span> 
		<a  href="#" id="routeList" class="showhide pull-right" routeid="{{routeId}}" isclicked="false">Show/Hide</a>
	</div>
</div>
{{/each}}
</script>
<!-- <script id="routeList-template" type="text/x-handlebars-template">
<div class="accordion-inner" style="display:none;">
		<table>
				<tr>
						<th>Station No.</th>
						<th>Name</th>
						<th>Seating Fare</th>
						<th>Sleeping Fare</th>
						<th>Distance</th>
						<th>Duration</th>
				</tr>
			{{#each Data}}
				<tr>
						<td>{{routeId}}</td>
						<td>{{station}}</td>
						<td>{{seatingFare}}</td>
						<td>{{sleepingFare}}</td>
						<td>{{distance}}</td>
						<td>{{duration}}</td>
				</tr>
			{{/each}}									
		</table>
		<div class="pull-right">
			<button class="btn btn-modify-2 btn-warning" name="btnedit" id="btnedit">Edit</button></a>
			<button class="btn btn-modify-2 btn-danger" name="btndel" >Delete</button></a>
		</div>
</div>
</script>
 -->
<script type="text/javascript">
$()
{
	$("#theValue1").val(0);
}
function loadRoute()
{
	//$(".accordion-inner").remove();
	$.getJSON("../JSONAllRoutes", function(obj) {
		
		var source = $("#route-template").html();
				var template = Handlebars.compile(source);
				Handlebars.registerHelper('each', function(obj, options) {
				var ret="";
					for(var prop in obj)
				    {	ret=ret+"<div class='accordion-group'><div class='accordion-heading routeid'>";
					        //ret=ret+"<tr><td>"+(parseInt(prop)+1)+"</td><td>"+context[prop].stationName+"</td></tr>";
					        ret=ret+"<span class=\"class1\">Route-"+(parseInt(prop)+1)+"  " +obj[prop].source+ " To "+obj[prop].desti+"</span>";
					        ret=ret+"<a  href='#' id='routeList'  class='showhide pull-right' routeid='"+obj[prop].routeId+"' isclicked='false'>Show/Hide</a></div></div>";
					 }
					return ret;
					});
				var html = template(obj);
				//console.log(html);
				$("#accordion2").append(html);
				//$("#mydiv").loadOverStop();
				
		
	});
}

	$(document).ready(function() {
		//$('#mydiv').loadOverStart();
		//var context = {	"Data" : [ {"source" : "ahmedabad","routeId" : 1,"desti" : "mumbai"}, {	"source" : "baroda","routeId" : 3,"desti" : "Bhavnagar"	}, {"source" : "Jamnagar","routeId" : 4,"desti" : "surat"} ],"Result" : "True"}
			loadRoute();
			});
		$("#btndelete").live('click', function(e) {
			$routeid=$(this).attr("routeid");
			var r=confirm("Are You Sure!")
			if (r==true)
			  {
			$.post("JSONDeleteRoute",{"routeid":$routeid},function(obj){
				    if(obj.Result=="True"){
						alert("Route is Delete");
						 location.reload();				
						loadRoute();
				    }
					
			},"json");
		  }
		e.preventDefault();	
		});
		
		$("#routeList").live('click', function() {
			html="";
			var routeId = $(this).attr("routeid");
			var th=$(this);
			if ($(th).attr("isclicked") == "false") {
				//var JSONData = {"Data" : [ {"seatingFare" : 100,"mapId" : 1,"duration" : "00:00:00","distance" : 0,	"station" : "ahmedabad","sleepingFare" : 200,"routeId" : 1	}, {"seatingFare" : 200,"mapId" : 7,"duration" : "04:00:00","distance" : 200,"station" : "baroda","sleepingFare" : 300,	"routeId" : 1}, {"seatingFare" : 800,"mapId" : 8,"duration" : "04:00:00","distance" : 300,"station" : "surat","sleepingFare" : 300,"routeId" : 1}, {	"seatingFare" : 600,"mapId" : 6,"duration" : "05:00:00","distance" : 400,"station" : "mumbai",	"sleepingFare" : 700,"routeId" : 1	} ],"Result" : "True"}
				$.getJSON("../JSONRouteData", {
					"routeId" : routeId
				}, function(obj) {
					/*var src = $("#routeList-template").html();
					var temp = Handlebars.compile(src);
					Handlebars.registerHelper('each',function(obj, options) {
						var ret="";
						for(var prop in obj)
					    {	     //ret=ret+"<tr><td>"+(parseInt(prop)+1)+"</td><td>"+obj[prop].stationName+"</td></tr>";
						        ret=ret+"<tr><td>"+(parseInt(prop)+1)+"</td><td>"+obj[prop].station+"</td><td>"+obj[prop].seatingFare+"</td><td>"+obj[prop].sleepingFare+"</td><td>"+obj[prop].distance+"</td><td>"+obj[prop].duration+"</td></tr>";
						 }
						
						return ret;
						});
						var htm = temp(obj);
						$(th).parent().parent().append(htm);
						$(th).parent().next().slideToggle(800);*/
						
						var ret="<div class='accordion-inner' style='display:none;'><table><tr><th>Station No.</th><th>Name</th><th>Seating Fare</th><th>Sleeping Fare</th><th>Distance</th><th>Duration</th></tr>";
						$i=1;
							$.each(obj.Data, function(i,item){
								ret=ret+"<tr>";
								ret=ret+"<td>"+$i+"</td>";
								ret=ret+"<td>"+item.station+"</td>";
								ret=ret+"<td>"+item.seatingFare+"</td>";								
								ret=ret+"<td>"+item.sleepingFare+"</td>";
								ret=ret+"<td>"+item.distance+"</td>";
								ret=ret+"<td>"+item.duration+"</td>";
								ret=ret+"</tr>";
								$i++;	
							});							
							ret=ret+"</table><div class='pull-right margin-bottom-20'>";
							ret=ret+"<form action='FetchRoute' method='post'><input type='hidden' value='"+routeId+"' name='route_id'> <input type='submit' class='btn btn-modify-2 btn-warning btn-padd-2' name='btnedit' id='btnedit' value='Edit'>  ";
							ret=ret+" <button class='btn btn-modify-2 btn-danger' name='btndel' id='btndelete' routeid='"+routeId+"' >Delete</button></form>";
						ret=ret+"</div></div>";
						$(th).parent().parent().append(ret);
						$(th).parent().next().slideToggle(600);
						$(th).attr("isclicked","true");
						
					//console.log(htm);
			});
				
				
			}
			else
				$(th).parent().next().slideToggle(600);
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

		<!-- M	ain hero unit for a primary marketing message or call to action -->
		<div class="hero-unit">
			<h2 class="heading">All Route</h2>
			<div class="white-block">

				<!-- Actual Content Here -->
				<div id="mydiv">
				<div class="accordion" id="accordion2">
					</div>
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
