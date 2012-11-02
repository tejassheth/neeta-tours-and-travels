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
               <script src='scripts/gen_validatorv5.js' type='text/javascript'></script>
<script src='scripts/sfm_moveable_popup.js' type='text/javascript'></script>

<style type='text/css'>
.error_strings
{
    font-family:Verdana;
    font-size:10px;
    color:#660000;
}
.sfm_float_error_box
{
    position:absolute;
    z-index:999;
    cursor:default;
    font-family:Verdana;
    font-size:10px;
    color:#660000;
    background-color:#ffff66;
    border-style:solid;
    border-width:1px;
    border-color:#660000;
}
.sfm_float_box_td
{
    padding:3px;
    cursor:default;
    font-family:Verdana;
    font-size:10px;
    color:#660000;
    background-color:#ffff66;
}
.sfm_close_box
{
    font-family:Verdana;
    font-size:10px;
    font-weight:bold;
    color:#ffffff;
    background-color:#660000;
    border-width:0px;
    text-align:center;
}
.sfm_cr_box
{
    font-family:Verdana;
    font-size:10px;
    color:#888888;
    border-style:solid;
    border-width:0px;
    border-color:#660000;
}
.sfm_cr_box a
{
    color:#888888;
}
</style>
<div id='forgotpassword_errorloc' class='error_strings' style=''></div>
<form name="forgotpassword" class="form-inline label-150" method="post" action="changeAndForgetPassword" onSubmit="">            
                    <p>
						<label for="city">E-mail Address:</label>
						<input type="text" name="curr_email" class="span2" id="emailid" >
					</p>
                    
                    <p>
                    	<input class="btn btn-primary btn-modify" type="submit" name="request_type" value="SendRequest">
                    </p>
                    
                    
                    <p><% if(request.getAttribute("result")==null)
                    
                    	out.println("");
                    else
                    	out.println(request.getAttribute("result"));
                    
							                    
                    
                    %></p>
			   </form><div class='sfm_cr_box' style='padding:3px; width:350px'>Powered by Simfatic Forms (<a style='text-decoration:none;' href='http://www.simfatic.com/forms/benefits.php'>HTML form maker</a>), evaluation version. <a href='http://www.simfatic.com/forms/order.php'>The registered version</a> does not add this box.</div>
<script type='text/javascript'>
// <![CDATA[
var forgotpasswordValidator = new Validator("forgotpassword");

forgotpasswordValidator.EnableOnPageErrorDisplay();
forgotpasswordValidator.SetMessageDisplayPos("right");

forgotpasswordValidator.EnableMsgsTogether();
forgotpasswordValidator.addValidation("curr_email","req","Please fill in curr_email");
forgotpasswordValidator.addValidation("curr_email","email","The input for curr_email should be a valid email value");

// ]]>
</script>


            </div>

            <!-- Example row of columns -->
            

            <hr>

            <footer>
                <p>&copy; Company 2012</p>
            </footer>

        </div> <!-- /container -->

        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/jquery-1.8.2.js"><\/script>')</script>
		
        <script src="js/bootstrap.js"></script>

        <script src="js/main.js"></script>
        
    </body>
</html>
