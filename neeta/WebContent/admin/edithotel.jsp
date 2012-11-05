<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <link rel="icon" href="favicon.ico">
        <title>Edit Hotel</title>
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
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/jquery-1.8.2.js"><\/script>')</script>		
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
            	<h2 class="heading">Edit Hotel</h2>
               <form class="form-inline label-150" method="post" action="AddHotelServlet"  >
			   	<div class="row">
                    <div class="span5">
                    <c:forEach items="${update}" var="upd">
					<p>
						<input type="hidden" name="h_id" value="${upd.h_id}">
						<label for="hotel_id">Hotel ID :</label>
						<label>${upd.h_id}</label>
			
					</p>
                    <p>

						<label for="hotel_name">Hotel Name :</label>
						<input type="text" name="Hotel_name" class="span2" required="required" value="${upd.hname}"/>						
					</p>


                    
                    
                    <p>
						<label for="contact">Contact No. :</label>
						<input type="number" name="contact" class="span2" required="required" id="contact" value="${upd.contact_det}" />						
					</p>
                    
                    <p>
						<label for="address">Address:</label>
						<textarea class="address" name="address" required="required" id="address" >${upd.address}</textarea>
					</p>
					
                    </div>
                    <div class="span5">
                    
                    <p>
						<label for="hotel_type">Type of Hotel :</label>						
						<select class="span2" name="type" id="type">                        	
                            <option value="2">2 Star</option>
                            <option value="3">3 Star</option>
                            <option value="4">4 Star</option>
                            <option value="5">5 Star</option>
                        </select>
                        <script type="text/javascript">
                        	$("#type").val(${upd.type});
                        </script>
                        
					</p>
                    
                    <p>
						<label for="information">Information:</label></br>
						<textarea class="nic_edit" name="hotel_info" id="hotel_info" required="required" >${upd.info}</textarea>
					</p>                  
                    
                   
					</c:forEach>
                    </div>
                    <div class="clearfix"></div>
                    <p>
                    	<input class="btn btn-primary btn-modify" type="submit" name="fun_type" value="Update">
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

        
		<script src="js/jquery-ui-1.8.24.custom.min.js"></script>
		<script src="js/jquery-ui-timepicker-addon.js"></script>        
		<script type="text/javascript">
		$(document).ready(function() 
		{
			$( "#time" ).timepicker();
		});
		</script>
        <script src="js/nicEdit.js" type="text/javascript"></script>
        <script type="text/javascript">
        	//<![CDATA[
				bkLib.onDomLoaded(function() { new nicEditor({fullPanel : true}).panelInstance('hotel_info'); });
			//]]>
		</script>
        <script type="text/javascript">
			$('input[id=img_path]').change(function() 
			{
		   		alert($(this).val());
				$("#fake_path").val($(this).val());
				
			});
		</script>
        <script src="js/bootstrap.js"></script>

        <script src="js/main.js"></script>
        
    </body>
</html>
