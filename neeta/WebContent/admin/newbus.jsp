<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>New Bus</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/main.css">
        <style>
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
			
			.label-150 label{
				width:150px;
				margin: 0 0 0 0;
			}
			
			.btn-modify{
				margin: 0 0 0 48%;
			}
        </style>
        <link rel="stylesheet" href="css/bootstrap-responsive.css">        
        <link rel="stylesheet" href="css/jquery.ui.timepicker.css">
		<link rel="stylesheet" href="css/jquery-ui-1.8.24.custom.css" >
        <script src="js/modernizr-2.6.1-respond-1.1.0.min.js"></script>
		<script src="js/jquery-1.8.2.js"></script>
		<script text="text/javascript">
		function loadStation($s) {
			$.getJSON("../JSONAllRoutes", function(obj) {
				//alert(obj.Result);
				$s.empty();
				$s.append(new Option("--Select Station--",	0));
				for ( var propertyName in obj.Data) {
					$s.append(
							new Option(obj.Data[propertyName].source +" To "+obj.Data[propertyName].desti ,
									obj.Data[propertyName].routeId));
				}
			});
		}
		$(document).ready(function(){
			loadStation($("#route"));
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
               <h2 class="heading">New Bus</h2>
               <form class="form-inline label-150" method="post" action="AddNewBus" onSubmit="">
			   	<div class="row">
                    <div class="span5">
                    <p>
                    	<label for="busno">Bus No. :</label>
                        <input type="text" name="busno" id="busno" class="span2">
                    </p>	
					<p>
						<label for="time">Departure Time:</label>
						<input type="text" name="time" class="span2" id="time" readonly >
					</p>
                    </div>
                    <div class="span5">
                    	<p>
                    	<label for="name">Route:</label>
                        <select class="span2" name="route" id="route">
                      
                        </select>
                    	</p>
                        <p>
                        	<label for="seating">Seating Seats:</label>
                        	<input type="text" class="span2" name="seating" placeholder="No. of seating seats">
                        </p>
                        <p>
                        	<label for="sleeper">Sleeper Seats:</label>
                        	<input type="text" class="span2" name="sleeper" placeholder="No. of sleeper seats">
                        </p>
                    </div>
                </div>
                <div class="clearfix"></div>                    
                    <p>
                    	<input class="btn btn-primary btn-modify" type="submit" name="submit" value="Add Bus">
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
		<script src="js/jquery-ui-1.8.24.custom.min.js"></script>
		<script src="js/jquery-ui-timepicker-addon.js"></script>        
		<script type="text/javascript">
		$(document).ready(function() 
		{
			$( "#time" ).timepicker();
		});
		</script>
        <script src="js/bootstrap.js"></script>

        <script src="js/main.js"></script>
        
    </body>
</html>
