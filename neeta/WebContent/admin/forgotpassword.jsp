<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Forgot Password</title>
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
				margin: 0 0 0 54%;
			}
        </style>
        
        <link rel="stylesheet" href="css/jquery.ui.timepicker.css">
		<link rel="stylesheet" href="css/jquery-ui-1.8.24.custom.css" >
        <script src="js/modernizr-2.6.1-respond-1.1.0.min.js"></script>
        <script src="js/jquery.validate.min.js"></script>
		
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
               <h2 class="heading">Forgot Password</h2>


<form name="forgotpassword" id="forgotpassword" class="form-inline label-150" method="post" action="changeAndForgetPassword" >            
                    <p>
						<label for="city">E-mail Address:</label>
						<input type="email" name="curr_email" class="span2" id="emailid" required="required" >
					</p>
                    
                    <p>
                    	<input class="btn btn-primary btn-modify" type="submit" name="request_type" value="SendRequest">
                    </p>
                    
                    
                    <p><% if(request.getAttribute("result")==null)
                    
                    	out.println("");
                    else
                    	out.println(request.getAttribute("result"));
         
							                    
                    
                    %></p>
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
		<script src="js/main.js"></script>
		<script type="text/javascript">
		$("#forgotpassword").submit(function(){
			$('#forgotpassword').validate();
			
		});
		</script>
        
    </body>
</html>

