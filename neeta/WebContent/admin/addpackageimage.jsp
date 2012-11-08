<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Add Package Image</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/main.css">
        <style>
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
            .btn-modify
            {
		margin: 10px 0 0 62%;	
            }
        </style>
        <link rel="stylesheet" href="css/bootstrap-responsive.css">
        
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
               <h2 class="heading">Add Package Image</h2>
               <form class="form-inline label-150" method="post" action="AddPackageImages" id="imageform" enctype="multipart/form-data">
			   		
                    <p>
                        <label for="state">Package :</label>
			<select class="span2 required" name="package" id="package">
                            <option value="">--Select Package--</option>
                            <c:forEach items="${plist}" var="pl">
                                <option value="${pl.p_id}">${pl.name}</option>                                
                            </c:forEach>
			</select>
                    </p>
                    
                     <div id="imagegroup"> 
                        	<input type="hidden" value="0" name="theValue1" id="theValue1" />
                            
                            <p id="imageblock1"> 
                            	
                                <input id="imgpath_1" name="imgpath_1" class="hidden-file" type="file" >                               
                            	<label for="image_1">Select Image 1:</label>
                                <input id="image_1" name="image_1" class="span2" type="text" required="required" onclick="callfile(id)" readonly>
                                <input type="button" class="btn btn-primary" id="imagebutton_1" onclick="callfile(id)" value="Browse">	
                            </p>
                            
                        </div>
                    
                    <p>
                    
                    <p>
                        	<button class="btn btn-primary btn-modify-1" name="addimage" id="addimage" onClick="return addImage();">Add Image</button>
                            <button class="btn btn-danger" name="removeimage" id="removeimage" onClick="return removeImage();">Remove Image</button>
                        </p>
                    	<input class="btn btn-primary btn-modify" type="submit" id="upload" name="submit" value="upload Images">
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
		
        <script src="js/bootstrap.js"></script>
        
        <script type="text/javascript">
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
				newdiv.innerHTML = "<input id=\"imgpath_"+num+"\" name=\"imgpath_"+num+"\" class=\"hidden-file\" type=\"file\" > <label for=\"image_"+num+"\">Select Image "+num+" :</label> <input id=\"image_"+num+"\" name=\"image_"+num+"\" class=\"span2\" type=\"text\" required=\"required\" onclick=\"callfile(id)\" readonly> <input type=\"button\" class=\"btn btn-primary\" id=\"imagebutton_"+num+"\" onclick=\"callfile(id)\" value=\"Browse\">";			
				
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
			
			function callfile(id)
			{
				//var amount = parseInt(/amount-(\d+)/.exec(id)[1], 10);
				//var direction = /direction-([^\s]+)/.exec(id)[1];
				var id2=parseInt( id.split('_')[1] );
				//alert(id2);
				var id1="input[id=imgpath_"+id2+"]";
				$(id1).click();
			}
			
			
        </script>
        
        <script type="text/javascript">
			$('input[id^=imgpath]').live("change",function() 
			{
				var filepath = $(this).parent().find("input[type='text']");
				filepath.val($(this).val());
				//console.log($(this).attr("id"));				
			});
			$()
			{
				$("#theValue1").val(0);
			}
			$('#upload').click(function(){
				$("#imageform").validate();
				
				
				
			});
		</script>
		<script src="js/jquery.validate.min.js" type="text/javascript"></script>
        <script src="js/main.js"></script>
        
    </body>
</html>
