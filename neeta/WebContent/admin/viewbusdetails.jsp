<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Bus Booking List</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/bootstrap-responsive.css">
<link rel="stylesheet" href="css/datepicker.css">
<link rel="stylesheet" href="css/jquery-ui-1.8.24.custom.css">
<style>
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.btn-modify {
	margin: 10px 0 0 62%;
}
.btn-primary{
	width: 100px;
}
</style>


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
			<h2 class="heading">View Bus Details</h2>
			<div>
				<form class="form-inline label-150" method="post" name="busform" action="FetchBusBookingDetail" id="busform">
					<p align="center">
					<div class="span3"></div>
					<div class="span2">
						<select class="span2 required" name="busno" id="package" required="required">
							<option value="">--Select Bus--</option>
							<c:forEach items="${BusList}" var="bus">
								<option value="${bus.bus_id}">${bus.bus_no}</option>
							</c:forEach>
						</select>
					</div>
					<div class="span4">
						<input class="span2" type="text" id="date" name="date" readonly="readonly" required="required">												 
						<button class="btn btn-primary" type="submit" value="Show" id="show" name="show">Show</button>
					</div>
					<div class="clearfix"></div>
										
				</form>
			</div>

			<c:if test="${load==true}">
			<div class="white-block">                
                <table cellpadding="0" cellspacing="0">
                    <tr>                  	
                    	<th>Passenger Name</th>
						<th>Email Id</th>
						<th>Passenger Contact no</th>
						<th>Status</th>
						<th>Booked Date</th>
						<th>Journey Date</th>
						<th>Fare</th>
						<th>Transaction Id</th>						                       
                    </tr>
                    
                    
                    <c:forEach var="BookDetails" items="${BookingDetails}">
						<tr>
							<td>${BookDetails.passenger_name}</td>
							<td>${BookDetails.emailid}</td>
							<td>${BookDetails.passenger_contactno}</td>
							<td>${BookDetails.status}</td>
							<td>${BookDetails.booked_date}</td>
							<td>${BookDetails.journey_date}</td>
							<td>${BookDetails.total_fare}</td>
							<td>${BookDetails.transaction_id}</td>
							
						</tr>
					</c:forEach>      
       			</table>
  			</div>
  			</c:if>
  		</div>
  	</div>

	<!-- Example row of columns -->


	<hr>

	<footer>
		<p>&copy; Company 2012</p>
	</footer>

	</div>
	<!-- /container -->



</body>

<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/modernizr-2.6.1-respond-1.1.0.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
<script src="js/main.js"></script>
<script src="js/jquery-ui-1.8.24.custom.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#date').datepicker({
			dateFormat : 'yy-mm-dd'
		});
	});
</script>
<script type="text/javascript">
			$('#show').click(function(){
				$("#busform").validate();
			});
		</script>
</html>


