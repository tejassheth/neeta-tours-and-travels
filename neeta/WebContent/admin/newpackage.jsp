<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>New Package</title>
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
			
			.btn-modify-1{				
				margin: 2% 0 0 51%;
			}
			
        </style>
        <link rel="stylesheet" href="css/bootstrap-responsive.css">
        

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
            <div class="hero-unit">
            	<h2 class="heading">Add New Package</h2>
                <form method="post" name="newpackage" id="newpackage" action="AddPackageServlet" class="form-inline label-150">
                    <div class="span5">
                        <p>                	
                            <label for="package_name">Package Name :</label>
                            <input type="text" class="span2" name="package_name" id="package_name">
                        </p>
                        
                        <p>
                        	<label for="duration">Duration :</label>
                            <input type="text" name="duration" id="duration" class="span2">
                        </p>
                        
                       	<div id="daygroup">
                            <input type="hidden" name="theValue" value="0" id="theValue" />                            
                            <p id="myDiv1">
	                            <label for="day1">Day 1:</label>
                                <input type="text" class="span2" name="day1" id="day1">
                            </p>                            
                        </div>            
                        
                        <p>                        	
                            <button class="btn btn-primary" name="addday" id="addday" onClick="return addInputBox();">Add Day</button>
                            <button class="btn btn-danger" name="removeday" id="removeday" onClick="return removeInputBox();">Remove Day</button>
                        </p>
                                 
						 <p>
							<label for="package_info">Package Information:</label>
							<textarea name="package_info" class="nic_edit" id="package_info"></textarea>                        
						</p>
                                                                        
                    </div>
                    <div class="span5">
                    	
                        <p>
                        	<label for="fare">Fare :</label>
                            <input type="text" name="fare" id="fare" class="span2">
                        </p>
                        
                        <p>
                            <label for="hotel">Hotel :</label>
                            <select id="hotel" name="hotel" class="span2">
                                <option>--Select Hotel--</option>
                                <c:forEach items="${hotelinfo}" var="hi">
                                    <option value="${hi.h_id}">${hi.hname}</option>                                
                                </c:forEach>
                            </select>
                        </p>
                        
                        
                        <div id="imagegroup"> 
                        	<input type="hidden" value="0" id="theValue1" />
                            <input id="img_path" name="img_path" class="hidden-file" type="file" >                            
                            <p id="imageblock1">                                
                            	<label for="image1">Select Image 1:</label>
                                <input id="image1" name="image1" class="span2" type="text" onclick="$('input[id=img_path]').click();" readonly>
                                <input type="button" class="btn btn-primary" id="imagebutton1" onclick="$('input[id=img_path]').click();" value="Browse">	
                            </p>
                        </div>
                        
                        <p>
                        	<button class="btn btn-primary" name="addimage" id="addimage" onClick="return addImage();">Add Image</button>
                            <button class="btn btn-danger" name="removeimage" id="removeimage" onClick="return removeImage();">Remove Image</button>
                        </p>
                                                
                       <p>
							<label for="incl_excl">Inclusion Exclusion:</label>
							<textarea name="incl_excl" class="nic_edit" id="incl_excl"></textarea>                        
						</p>
                                                                        
                    </div>
                <div class="clearfix"></div>
                	<input type="submit" name="submit" class="btn btn-primary btn-modify-1" value="Add Package">
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
        
        <script src="js/nicEdit.js" type="text/javascript"></script>
        <script type="text/javascript">
        	//<![CDATA[
				bkLib.onDomLoaded(function() { new nicEditor({fullPanel : true}).panelInstance('package_info'); });
				bkLib.onDomLoaded(function() { new nicEditor({fullPanel : true}).panelInstance('incl_excl'); });				
			//]]>
		</script>
        
        <script type="text/javascript">
        $()
        {
        	$("#theValue1").val(0);
        }
			function addInputBox()
			{			
				var ni = document.getElementById('daygroup');				
				var numi = document.getElementById('theValue');				
				var num = (document.getElementById('theValue').value -1)+ 2;								
				numi.value = num;
				num++;
				var newdiv = document.createElement('p');				
				var divIdName = "myDiv"+num ;				
				newdiv.setAttribute('id',divIdName);							
				newdiv.innerHTML = "<label for=day"+num+">Day "+num+":</label> <input type=\"text\" id=day"+num+" name=day"+num+" class=\"span2\" /> ";				
				ni.appendChild(newdiv);	
				return false;		
			}
			
			function removeInputBox()
			{
				var ni = document.getElementById('daygroup');				
				var numi = document.getElementById('theValue');				
				var num = (document.getElementById('theValue').value -1)+ 2;				
				if((num-2)==-1)
					return false;				
				numi.value = num-2;								
				var divIdName = "myDiv"+num ;
				var olddiv = document.getElementById(divIdName);
				ni.removeChild(olddiv);
				return false;
			}
			
			function addImage()
			{
				
				var ni = document.getElementById('imagegroup');				
				var numi = document.getElementById('theValue1');		
				var num = (document.getElementById('theValue1').value -1)+ 2;				
				numi.value = num;
				num++;			
				var newdiv = document.createElement('p');				
				var divIdName = "imageblock"+num ;				
				newdiv.setAttribute('id',divIdName);
				newdiv.innerHTML = "<label for=\"image"+num+"\">Select Image "+num+" :</label> <input id=\"image"+num+"\" name=\"image"+num+"\" class=\"span2\" type=\"text\" onclick=\"$('input[id=img_path]').click();\" readonly> <input type=\"button\" class=\"btn btn-primary\" id=\"imagebutton"+num+"\" onclick=\"$('input[id=img_path]').click();\" value=\"Browse\">";			
				
				ni.appendChild(newdiv);
				return false;
			}
			
			function removeImage()
			{
				var ni = document.getElementById('imagegroup');				
				var numi = document.getElementById('theValue1');		
				var num = (document.getElementById('theValue1').value -1)+ 2;
				if((num-2)==-1)
					return false;
				numi.value = num-2;								
				var divIdName = "imageblock"+num ;
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
        	
        <script src="js/main.js"></script>
        
    </body>
</html>
