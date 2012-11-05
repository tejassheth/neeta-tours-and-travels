<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>New Route</title>
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
			
			.label-150 label{
				width:150px;
				margin: 0 0 0 0;
			}
			
			.btn-modify-1{				
				margin: 2% 0 0 86%;
			}
			
			.label-mod{
				width:170px !important;
				font-size:16px;
				font-weight:600;
				text-align:center;
			}
			
			.div-mod{
				margin-top: 10px;
				margin-left:0px;	
			}
			
			.p-mod{
				border-bottom:solid 1px #0099FF;
				margin-top: 5px;	
			}
			
			.p-mod-1{
				margin-top:10px;	
			}
			.white-block{
				padding: 0px;
			}
			
			.span10{
				width: 1020px;
				margin-left: 0px;
			}
			
			.botton-8{
				margin-bottom: 8px;
			}
        </style>
       
       	<link rel="stylesheet" href="css/jquery.ui.timepicker.css">
		<link rel="stylesheet" href="css/jquery-ui-1.8.24.custom.css" >
        <script src="js/modernizr-2.6.1-respond-1.1.0.min.js"></script>
	<script src="js/jquery-1.8.2.js"></script>
<script type="text/javascript">
$()
{
	$("#theValue1").val(0);
}
	function loadStation($s) {
		$.getJSON("../JSONAllStations", function(obj) {
			//alert(obj.Result);
			$s.empty();
			$s.append(new Option("--Select Station--",	0));
			for ( var propertyName in obj.Data) {
				$s.append(
						new Option(obj.Data[propertyName].stationName,
								obj.Data[propertyName].staionId));
			}
		});
	}
	$(document).ready(function() {
		
		loadStation($("#sourcecity"));
		loadStation($("#destinationcity"));
		loadStation($("#station1"));
		loadStation($("#station2"));
		//var obj = ({"Data":{"Alabama":"01","Alaska":"02","Arizona":"03","Arkansas":"04","California":"05","Colorado":"06","Connecticutt":"07","Delaware":"08","Florida":"09","Georgia":"10","Hawaii":"11","Idaho":"12","Illinois":"13","Indiana":"14","Iowa":"15","Kansas":"16","Kentucky":"17","Louisiana":"18","Maine":"19","Massachusetts":"20","Michigan":"21"}});
		
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
            	<h2 class="heading">Add New Route</h2>
            	<form method="post" name="newroute" id="newpackage" action="AddNewRoute" class="form-inline label-150">
                    <div class="span5">
                        <p>                	
                            <label for="sourcecity">Source City :</label>
                            <select type="text" class="span3" name="sourcecity" id="sourcecity">
                            	
                            </select>
                        </p>
                        
                        
                                                                        
                    </div>
                    <div class="span5">
                    	<p>                	
                            <label for="destinationcity">destination City :</label>
                            <select type="text" class="span3" name="destinationcity" id="destinationcity">
                           	</select>
                        </p>                                            
                    </div>
                <div class="clearfix"></div>
                <div class="span10">
                	<h3>Intermediate Station</h3>
                    <div class="white-block div-mod">
                        <p class="padding-top-5"></p>
                        <p>
                            <div class="span2"><label class="label-mod">Station</label></div>
                            <div class="span2"><label class="label-mod">Time</label></div>
                            <div class="span2"><label class="label-mod">Distance</label></div>
                            <div class="span2"><label class="label-mod">Seating Fare</label></div>
                            <div class="span2"><label class="label-mod">Sleeping Fare</label></div>
                        </p>
                        
                          <div class="clearfix"></div>
                          <p  class="p-mod"></p>
                          <div id="stationgroup">                            
                            <p id="pstation1">
                                <input type="hidden" value="1" id="theValue" name="theValue" />
                                <div class="span2">
                                <select class="span2" name="station1" id="station1">
                                                                   
                                </select></div>
                                <div class="span2"><input type="text" name="time1" id="time1" class="span2" readonly="readonly" required="required"></div>
                                <div class="span2"><input type="number" name="distance1" id="distance1" class="span2" required="required" min="0"></div>
                                <div class="span2"><input type="number" name="seatingfare1" id="seatingfare1" class="span2" required="required"></div>
                                <div class="span2"><input type="number" name="sleepingfare1" id="sleepingfare1" class="span2" required="required"></div>
                            </p>
                            <div class="clearfix"></div>
                            <p id="pstation2">                                
                                <div class="span2">
                                <select class="span2" name="station2" id="station2">
                                                                   
                                </select></div>
                                <div class="span2"><input type="text" name="time2" id="time2" class="span2" readonly="readonly" required="required"></div>
                                <div class="span2"><input type="number" name="distance2" id="distance2" class="span2" required="required"></div>
                                <div class="span2"><input type="number" name="seatingfare2" id="seatingfare2" class="span2" required="required"></div>
                                <div class="span2"><input type="number" name="sleepingfare2" id="sleepingfare2" class="span2" required="required"></div>
                            </p>
                            <div class="clearfix"></div>
                            <p class="botton-8"></p>
                     	</div>
                      	<div class="p-mod"></div>
                        <p class="p-mod-1">                        	
                            <button class="btn btn-primary margin-bottom-10 margin-left-10" name="addday" id="addday" onClick="return addInputBox();">Add Station</button>
                            <button class="btn btn-danger margin-bottom-10 margin-left-10" name="removeday" id="removeday" onClick="return removeInputBox();">Remove Station</button>
                        </p>                        
					</div>  
                </div>
                	<input type="submit" name="submit" class="btn btn-primary btn-modify-1" value="Add Route" id="add">
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

        <script src="js/bootstrap.js"></script>
        
         <script type="text/javascript">
			function addInputBox()
			{			
				var ni = document.getElementById('stationgroup');				
				var numi = document.getElementById('theValue');				
				var num = (document.getElementById('theValue').value -1)+ 2;				
				numi.value = num;
				num++;			
				var newdiv = document.createElement('p');				
				var divIdName = "myDiv"+num ;				
				newdiv.setAttribute('id',divIdName);
				var content = " <div class=\"span2\"> <select class=\"span2\" name=\"station"+num+"\" id=\"station"+num+"\">  </select> </div>";
				content=content+" <div class=\"span2\"> <input type=\"text\" id=\"time"+num+"\" name=\"time"+num+"\" class=\"span2\" readonly='readonly' required=\"required\"> </div>"; 
				content=content+" <div class=\"span2\"> <input type=\"number\" id=\"distance"+num+"\" name=\"distance"+num+"\" class=\"span2\" required=\"required\"> </div>";
				content=content+" <div class=\"span2\"> <input type=\"number\" class=\"span2\" id=\"seatingfare"+num+"\" name=\"seatingfare"+num+"\" required=\"required\"> </div>";
				content=content+" <div class=\"span2\"> <input type=\"number\" class=\"span2\" id=\"sleepingfare"+num+"\" name=\"sleepingfare"+num+"\" required=\"required\"> </div>";							
				content=content+" <div class=\"clearfix\"></div> ";
				newdiv.innerHTML = content;				
				ni.appendChild(newdiv);	
				$("#time"+num).timepicker();
				loadStation($("#station"+num+""));
				return false;		
			}
			
			function removeInputBox()
			{
				var ni = document.getElementById('stationgroup');				
				var numi = document.getElementById('theValue');				
				var num = (document.getElementById('theValue').value -1)+ 2;				
				if((num-2)==0)
					return false;				
				numi.value = num-2;								
				var divIdName = "myDiv"+num ;
				var olddiv = document.getElementById(divIdName);
				ni.removeChild(olddiv);
				return false;
			}
			
			
		</script>	
        
        <script type="text/javascript">
			$('input[id=img_path]').change(function() 
			{
		   		$('#fake_path').val($(this).val());
				
			});
		</script>
		
        <script src="js/jquery-ui-1.8.24.custom.min.js"></script>
		<script src="js/jquery-ui-timepicker-addon.js"></script>
		<script src="js/jquery.validate.min.js" type="text/javascript"></script>        
		<script type="text/javascript">
		$(document).ready(function() 
		{
			$( "#time1" ).timepicker();
			$( "#time2" ).timepicker();
			$('#add').click(function(){
				$("#newpackage").validate();
				});
		});
		</script>        

        <script src="js/main.js"></script>
        
    </body>
</html>
