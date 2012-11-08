<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Add Room</title>
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
            
            .btn-modify{
            	margin-left: 57%;
            }
        </style>
        
        <link rel="stylesheet" href="css/jquery.ui.timepicker.css">
		<link rel="stylesheet" href="css/jquery-ui-1.8.24.custom.css" >
        <script src="js/modernizr-2.6.1-respond-1.1.0.min.js"></script>
		
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an outdated browser. <a href="http://browsehappy.com/">Upgrade your browser today</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to better experience this site.</p>
        <![endif]-->

        <!-- This code is taken from http://twitter.github.com/bootstrap/examples/hero.html -->

        <jsp:include page="menu.jsp" flush="true"></jsp:include>

        <div class="container">

            <!-- Main hero unit for a primary marketing message or call to action -->
            <div class="hero-unit" >
               <h2 class="heading">Add Room</h2>
               <form class="form-inline label-150" method="post" id="addroom" action="RoomServlet" onSubmit="">
			   		
                    <p>
						<label for="Hotel">Hotel Name:</label>
						<select class="span2" name="hotel_id" id="hotel_id">
						<option value="0">--Select Hotel--</option>
						<c:forEach var="hlist" items="${hlist}">
						<option value="${ hlist.h_id}">${hlist.hname}</option>
						</c:forEach>
						    </select>
					</p>
                    
                    <p>
						<label for="Room type">Room Type:</label>
						<input type="text" name="room_type" required="required" class="span2" id="room_type" minlength="2" maxlength="50">
					</p>
                    
                    <p>
						<label for="fare">Fare:</label>
						<input type="number" name="fare" class="span2" id="fare" required="required" max="9999" min="50" >
					</p>
                    
                    <p>
                    	<input class="btn btn-primary btn-modify" id="submit" type="submit" name="request_type" value="AddRoom">
                    </p>               
                     <p align="center" id="result">
                    ${message}              
                    </p>
                    
			   </form>
            </div>

            <!-- Example row of columns -->
            

            <hr>

            <footer>
                <p>&copy; Company 2012</p>
            </footer>

        </div> <!-- /container -->

        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/jquery-1.8.2.js"><\/script>')</script>
		<script src="js/jquery.validate.min.js" type="text/javascript"></script>
		<script type="text/javascript">
		$(document).ready(function()
		{
			$("#result").fadeOut(4000);
			$('#submit').click(function(){
				
				$.validator.addMethod("valueNotEqualsaddRoom", function(value, element, arg){
					//console.log(arg != value);  
					return arg != value;
					 }, "Value must not equal arg.");

					 // configure your validation
					 $("#addroom").validate({
					  rules: {
						  hotel_id: { valueNotEqualsaddRoom: "0" }
					  },
					  messages: {
						  hotel_id: {
					    valueNotEqualsaddRoom: "Please select a hotel."
					   }
					  }  
					 });
				
			});	
			
			
			
			
		
		
		});
		
		
		
		
		</script>
		
        <script src="js/bootstrap.js"></script>

        <script src="js/main.js"></script>
        
    </body>
</html>
