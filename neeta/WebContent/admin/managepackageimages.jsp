<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Package Images</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
		
        <link rel="stylesheet" href="css/bootstrap.css">
        <style type="text/css">
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
            
        </style>
        <link rel="stylesheet" href="css/bootstrap-responsive.css">
        <link rel="stylesheet" href="css/main.css">
        
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
               <h2 class="heading">Package Images</h2><br>
               <form class="form-inline label-150" method="post" id="manageimage" action="ManagePackageImage" onSubmit="" name="form1">
                    <p align="center">
                        <div class="span3"></div>
                        <div class="span2"><select class="span2 required" name="package" id="package">
                            <option value="">--Select Package--</option>
                            <c:forEach items="${plist}" var="pl">
                                <option value="${pl.p_id}" <c:if test="${pid==pl.p_id}">selected="true"</c:if>>${pl.name}</option>                                
                            </c:forEach>
						</select></div>
											
                        
                        <div class="span2"><input class="btn btn-primary" type="submit" id="submit" name="submit" value="Show Images"></div>
                    	<div class="clearfix"></div>
                    </p>
                    
               	</form>
               <c:if test="${load==false}">
                   <c:set var="i" value="1"></c:set>
                   <br><br>
                   <form class="form-inline label-150" method="post" id="manageimage" action="" onSubmit="" name="form2">                    
                       <c:set var="totimg" value="0"></c:set>
                       <c:forEach items="${requestScope.imgList}" var="img">
                            <div class="block">
                                <img src="${path}/<c:out value="${img}"></c:out>" >
                                <label class="checkbox">
                                    <input type="checkbox" id="check${totimg}"  name="${img}_<c:out value="${pid}"></c:out>">Delete this image.
                                </label>                        
                                <c:set var="i" value="${i+1}"></c:set>
                            </div>
                            <c:if test="${i==4}">
                                <div class="clearfix"></div>
                                <c:set var="i" value="1"></c:set>
                            </c:if>
                       		<c:set var="totimg" value="${totimg+1}"></c:set>
                        </c:forEach> 
                                           
                    <div class="clearfix"></div>
                    <input type="hidden" name="totimage" id="totimage" value="${totimg}"> 
                    <input class="btn btn-primary" type="submit" id="submit1" name="submit" value="Delete">
                    </form>
               </c:if>
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
        
        <script src="js/jquery.validate.min.js" type="text/javascript"></script>
        <script type="text/javascript">
        	$('#submit1').click(function(e){
        		//alert("123");
        		var tot=$("#totimage").val();
        		var i=0;
        		var flag=0;
        		for(i=0;i<tot;i++)
        		{
        			//alert("123");
        			if(($("#check"+i).is(':checked'))==true)
        			{
        				flag=1;	
        				break;
        			}
        			console.log(flag);
        		}
        		if(flag==0)
        		{
        			alert("Please Select Image To Delete");
        				e.preventDefault();
        				
        		}
        	});
        	
        	$('#submit').click(function(e){
        		$("#manageimage").validate();
        	});
        	
        </script>

        <script src="js/main.js"></script>
        
    </body>
</html>
