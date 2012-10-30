<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Manage Bus</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        <link rel="stylesheet" href="css/bootstrap.css">
        <style>
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
        </style>
        <link rel="stylesheet" href="css/bootstrap-responsive.css">
        <link rel="stylesheet" href="css/main.css">

        <script src="js/modernizr-2.6.1-respond-1.1.0.min.js"></script>
        <script src="js/jquery-1.8.2.js" ></script>
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
            	<h2 class="heading">Manage Bus</h2>
                <div class="white-block">
                	<table cellpadding="0" cellspacing="0">
                    <tr>
                    	<th>Bus No.</th>
                        <th>Route</th>
                        <th>Seating Fare</th>
                        <th>Sleeping Fare</th>
                        <th colspan="2">Action</th>
            
                    </tr>
                    <c:forEach items="${buslist}" var="bl">
                        <tr>
                            <td>${bl.bus_no}</td>
                            <td>${bl.route}</td>
                            <td>${bl.seating}</td>
                            <td>${bl.sleeper}</td>      
                            <form action="FetchModifyBusData" method="post">
                            <input type="hidden" name="busid" value="${bl.bus_id}">                      
                            <td><button class="btn btn-modify-2 btn-warning" name="btnedit${bl.bus_id}" id="edit${bl.bus_id}" >Edit</button></td>
                            <td><button class="btn btn-modify-2 btn-danger" name="btndel${bl.bus_id}" id="delete" busid="${bl.bus_id}" >Delete</button></td>
                            </form>
                        </tr>
                    </c:forEach>
                    </table>
                </div> 
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
        <script type="text/javascript">
        $(function(){
        	$("#delete").live("click",function(e)
        	{
        		$busid=$(this).attr("busid");
        		var r=confirm("Are You Sure!")
    			if (r==true)
    				{
        		$.post("../JSONDeleteBus",{"busid":$busid},function(obj){
        			 if(obj.Result=="True"){
 						alert("Route is Delete");
 						 location.reload();				
 						loadRoute();
 				    }
        		},"json");
    				}
        		else
					alert("Route is Not Delete");
        		e.preventDefault();
        	});
        });
        </script>
    </body>
</html>
