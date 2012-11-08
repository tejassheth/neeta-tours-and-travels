<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <link rel="icon" href="favicon.ico">
        <title>New Hotel</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" href="css/bootstrap.css">     
        <link rel="stylesheet" href="css/bootstrap-responsive.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/jquery.ui.timepicker.css">
		<link rel="stylesheet" href="css/jquery-ui-1.8.24.custom.css" >
        <script src="js/modernizr-2.6.1-respond-1.1.0.min.js"></script>
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
				margin: 0 0 0 49%;
			}
			
			.hidden-file{
				display:none;	
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
            	<h2 class="heading">Add New Hotel</h2>
               <form class="form-inline label-150" method="post" id="hotelform" action="AddHotelServlet" >
			   	<div class="row">
                    <div class="span5">
                    <p>
						<label for="hotel_name">Hotel Name :</label>
						<input type="text" name="hotel_name" class="span2" required="required" id="hotel_name"/>						
					</p>
                    
                    
                    <p>
						<label for="contact">Contact No. :</label>
						<input type="number" name="contact" class="span2" id="contact" required="required" minlength="10" maxlength="11"/>						
					</p>
                    
                    
					<p>
						<label for="address">Address:</label>
						<textarea class="address required" name="address" id="address" required="required"></textarea>
					</p>
                    
                    </div>
                    <div class="span5">
                    
                    
                    <p>
						<label for="hotel_type">Type of Hotel :</label>
						<select class="span2 required" name="hotel_type" id="hotel_type">
                        	<option value="">--Select Hotel--</option>
                        	<option value="2">2 Star</option>
                            <option value="3">3 Star</option>
                            <option value="4">4 Star</option>
                            <option value="5">5 Star</option>
                        </select>
					</p>
                    
                    <p>
						<label for="hotel_info">Hotel Information:</label>
						<textarea name="hotel_info" class="nic_edit" id="hotel_info"></textarea>
                    </p>
                    </div>
                    <div class="clearfix"></div>
                    <p>
                    	<input  class="btn btn-primary btn-modify" type="submit" name="fun_type" id="Add" value="AddHotel">
                    </p>
                    <p align="center" id="result">
                    ${h_id}
                    </p>
			   </div>
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
			$("#result").fadeOut(4000);
			$( "#time" ).timepicker();
		});
		</script>
        <script src="js/nicEdit.js" type="text/javascript"></script>
        <script type="text/javascript">
        	//<![CDATA[
				bkLib.onDomLoaded(function() { new nicEditor({fullPanel : true}).panelInstance('hotel_info'); });
			//]]>
		</script>
        
        <script src="js/jquery.validate.min.js" type="text/javascript"></script>
        <script src="js/main.js"></script>
        <script text="text/javascript">
        $("#Add").click(function(e){    	
        	
        	//alert($(".nicEdit-main_1").html());
        	$.validator.addMethod("valueNotEqualsaddStation", function(value, element, arg){
			//console.log(arg);
			//console.log(value);
			//alert(arg != value && ($(".nicEdit-main_1").html()!="<br>"));
			return (arg != value && ($(".nicEdit-main_1").html()!="<br>"));
			}, "Value must not equal arg.");
			// configure your validation
			$("#hotelform").validate();   	
        	$hotel_name =$("#hotel_name").val();
        	$hotel_type=$("#hotel_type").val();
        	$contect=$("#contact").val();
        	$addres=$("#address").val();
        	$info=$(".nicEdit-main_1").html();
        	//alert($hotel_name+" "+$hotel_type+" "+$contect+" "+$addres+" "+$info);
        	$.post("../AddHotelServlet",{"fun_type":"add","hotel_name":$hotel_name,"hotel_type":$hotel_type,"contact":$contect,"address":$addres,"info":$info},function(obj){
        		alert(obj.Result) ;
        	},"json");
        	
        	/*$.post("JSONAddHotel",{},function(){
        		
        	})*/;
       });
      
        </script>
        <script src="js/bootstrap.js"></script>        	
        <script src="js/main.js"></script>
    </body>
</html>
