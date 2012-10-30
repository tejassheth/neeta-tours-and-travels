<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Edit Route</title>
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
				margin-left:40px;	
			}
			
			.p-mod{
				border-bottom:solid 1px #0099FF;	
			}
			
			.p-mod-1{
				margin-top:10px;	
			}
        </style>
       
       	<link rel="stylesheet" href="css/jquery.ui.timepicker.css">
		<link rel="stylesheet" href="css/jquery-ui-1.8.24.custom.css" >
        <script src="js/modernizr-2.6.1-respond-1.1.0.min.js"></script>
	<script src="js/jquery-1.8.2.js"></script>
<script type="text/javascript">
	function loadStation($s) {
		$.getJSON("../JSONAllStations", function(obj) {
			//alert(obj.Result);
			$s.empty();
			$s.append(new Option("--Select Station--",	0));
			$routeid=$s.attr("sid");;
			for ( var propertyName in obj.Data) {
				if(obj.Data[propertyName].staionId==$routeid)
				$s.append("<option value ='"+obj.Data[propertyName].staionId+"' selected>"+obj.Data[propertyName].stationName+"</option>");
				else
				{
					$s.append("<option value ='"+obj.Data[propertyName].staionId+"'>"+obj.Data[propertyName].stationName+"</option>");
				}
			}
		});
	
		}
	$(document).ready(function() {
		
		loadStation($("#sourcecity"));
		loadStation($("#destinationcity"));
		
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
            	<h2 class="heading">Edit Route</h2>
            	<form method="post" name="newpackage" id="newpackage" action="ModifyRoute" class="form-inline label-150">
            	<input type="hidden" name="routeid" value="${Route.routeId}">
                    <div class="span5">
                        <p>                	
                            <label for="sourcecity">Source City :</label>
                            <select type="text" class="span3" name="sourcecity" sid="${requestScope.Route.sourceId}" id="sourcecity">
                            	
                            </select>
                        </p>
                        
                        
                                                                        
                    </div>
                    <div class="span5">
                    	<p>                	
                            <label for="destinationcity">destination City :</label>
                            <select type="text" class="span3" sid="${requestScope.Route.destinationId}"name="destinationcity" id="destinationcity">
                            	                            </select>
                        </p>                                            
                    </div>
                <div class="clearfix"></div>
                <div class="span10">
                	<h3>Intermediate Station</h3>
                    <div class="white-block div-mod">
                        <p class="p-mod">
                            <label class="label-mod">Station</label>
                            <label class="label-mod">Time</label>
                            <label class="label-mod">Distance</label>
                            <label class="label-mod">Seating Fare</label>
                            <label class="label-mod">Sleeping Fare</label>
                        </p>
                        <div class="hidden-file">   <!-- This is only for template of thos p copy this content to jquery code below -->
                                
                                <select class="span2" name="station">
                                    <option>--Select City--</option>
                                    <option value="5">Anand</option>
                                    <optionvalue="6">vadodara</option>                                
                                </select>
                                <input type="text" class="span2">
                                <input type="text" class="span2">
                                <input type="text" class="span2">
                                <input type="text" class="span2">
                     	</div>
                     	<c:set var="counter" value="1" />
                     	
                     	
                        <div id="stationgroup">
                        	<c:forEach items="${Route_Map}" var="route_MapList" varStatus="index">                            
                            <p id="pstation1">
                                <input type="hidden" value="${counter}" id="theValue" name="theValue" />
                                <select class="span2" name="station${counter}" sid="${route_MapList.station_id}" id="station${counter}">
                                                                   
                                </select>
                                <input type="text" name="time${counter}" id="time1" class="span2" value="${route_MapList.duration}">
                                <input type="text" name="distance${counter}" id="distance1" class="span2" value="${route_MapList.distance}">
                                <input type="text" name="seatingfare${counter}" id="seatingfare1" class="span2" value="${route_MapList.seating_fare}">
                                <input type="text" name="sleepingfare${counter}" id="sleepingfare1" class="span2" value="${route_MapList.sleeping_fare}">
                                <script text="text/javascript">
                                loadStation($("#station"+${counter}));	
                                </script>
                                
                            </p>
                            <c:set var="counter" value="${counter+1}" />
                            </c:forEach>
                     	</div>
                     	
                      	<div class="heading"></div>
                        <p class="p-mod-1">                        	
                            <button class="btn btn-primary" name="addday" id="addday" onClick="return addInputBox();">Add Station</button>
                            <button class="btn btn-danger" name="removeday" id="removeday" onClick="return removeInputBox();">Remove Station</button>
                        </p>                        
					</div>  
                </div>
                	<input type="submit" name="submit" class="btn btn-primary btn-modify-1" value="Editt Route">
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
				//var num = (document.getElementById('theValue').value -1)+ 2;				
				numi.value = num;
				num++;			
				var newdiv = document.createElement('p');				
				var divIdName = "myDiv"+num ;				
				newdiv.setAttribute('id',divIdName);
				var content = "<select class=\"span2\" name=\"station"+num+"\" id=\"station"+num+"\">  </select> <input type=\"text\" id=\"time"+num+"\" name=\"time"+num+"\" class=\"span2\"> <input type=\"text\" id=\"distance"+num+"\" name=\"distance"+num+"\" class=\"span2\"> <input type=\"text\" class=\"span2\" id=\"seatingfare"+num+"\" name=\"seatingfare"+num+"\"> <input type=\"text\" class=\"span2\" id=\"sleepingfare"+num+"\" name=\"sleepingfare"+num+"\"> ";							
				newdiv.innerHTML = content;				
				ni.appendChild(newdiv);	
				$("#time"+num+"").timepicker();
				loadStation($("#station"+num+""));
				return false;		
			}
			
			function removeInputBox()
			{
				var ni = document.getElementById('stationgroup');				
				var numi = document.getElementById('theValue');				
				var num = (document.getElementById('theValue').value -1)+ 2;				
				//console.log(num);
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
		<script type="text/javascript">
		$(document).ready(function() 
		{
			$( "#time1" ).timepicker();
		});
		</script>        

        <script src="js/main.js"></script>
        
    </body>
</html>