<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Admin Login</title>
		
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        <link rel="stylesheet" href="../admin/css/bootstrap.css">
        <style>	
            body {
                padding-top: 60px;
                padding-bottom: 40px;
				
            }
			form label {
    			display: inline-block;
			    font-size: 17px;
			    text-align: left;
			    width: 100px;	
			}
			h4{
			
			 color:#CCCCCC
			}
        </style>
        <link rel="stylesheet" href="../admin/css/bootstrap-responsive.css">
        <link rel="stylesheet" href="../admin/css/main.css">
        <script src="../admin/js/modernizr-2.6.1-respond-1.1.0.min.js"></script>
        <script src="../admin/js/jquery-1.8.2.js"></script>
        <script src="../admin/js/jquery.validate.min.js"></script>
        <script type="text/javascript">
        $(document).ready(function(){
        	        		
        });
        </script>
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an outdated browser. <a href="http://browsehappy.com/">Upgrade your browser today</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to better experience this site.</p>
        <![endif]-->      

        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">                    
                    <!--a class="brand" href="#">Admin Panel</a>
					
                    <!--/.nav-collapse -->
					<h4>Admin Panel</h4>
                </div>
            </div>
        </div>
		<div class="index_container">
        <div class="container">

            <!-- Main hero unit for a primary marketing message or call to action -->
            <div class="hero-unit" align="center">
                 <form class="navbar-form" method="post" action="" onSubmit="" id="FrmLogin">
                 			<p id="result" style="display: none;">E-mail and Password is Incorrect  !!</p>
                            <p class="spam2"><label for="emailid">E-mail ID:</label><input class="span2" type="email" placeholder="Email" name="emailid" id="emailid" required="required"></p>
                            <p class="spam2"><label for="password">Password:</label><input class="span2" type="password" placeholder="Password" name="password" id="password" required="required"></p>
                            <button type="submit" class="btn btn-primary" id="signin">Sign in</button>&nbsp;&nbsp;&nbsp;&nbsp;<a href="forgotpassword.jsp">Forgot password?</a>
              	</form>
            </div>

            <!-- Example row of columns -->
			<hr>
	        </div> <!-- /container -->
		</div>
        
        <script>window.jQuery || document.write('<script src="js/jquery-1.8.2js"><\/script>')</script>

        <script src="../admin/js/jquery.validate.min.js" type="text/javascript"></script>
        <script type="text/javascript">
        	$('#signin').click(function(e){
        		$("#FrmLogin").validate();
        		var emailid = $("#emailid").val();
                var password = $("#password").val();
                
                if((emailid!='') &&(password!=''))
                {
                		$.post("../Login",{"emailid":emailid,"password":password},function(data){
        				var result=data.Result;
        				if(result=="False")
        					$("#result").show();
        				if(result=="True")
        					 document.location.href="../admin/home.jsp";
      						},"json");
                }
        			e.preventDefault();
         	});
        	
        </script>

       
    </body>
</html>
