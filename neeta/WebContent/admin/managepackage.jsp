<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <head>
    
        
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Manage Package</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js">
        </script>
        <link rel="stylesheet" href="css/bootstrap.css">
        <style type="text/css">
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
        </style>
        <link rel="stylesheet" href="css/bootstrap-responsive.css">
        <link rel="stylesheet" href="css/main.css">

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
            	<h2 class="heading">Manage Hotel</h2>
                <div class="white-block">
                
                	<table cellpadding="0" cellspacing="0">
                    <tr>
                    	
                    	<th>Package Name</th>
                        <th>Fare</th>
                        <th>Duration</th>
						<th colspan="2">Action</th>                       
                    </tr>
                    
      <c:forEach items="${PackageDetails}" var="PList">
      <form method="post" action="ManagePackageServlet">
        <tr valign="middle" align="center" class="abc">
        
        	
            <td>${PList.name}</td>
            <td>${PList.fare}</td>
            <td>${PList.duration}</td>
            
 	    <input type="hidden"  name="pkg_id"  value="${PList.p_id}">
 	    <input type="hidden"  name="hotel_id"  value="${PList.hotelId}">
	   	         
            <td><button  class="btn btn-modify-2 btn-warning" name="pkg_fun_type" onClick="" value="edit">Edit</button></td>
            <td><button  class="btn btn-modify-2 btn-danger" name="pkg_fun_type" onClick="" id="btndelete" value="delete">Delete</button></td>
                    </tr>
                    </form>
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
        
    </body>
</html>
<script type="text/javascript">
    $("#btndelete").live('click', function(e) 
    {    
        $routeid=$(this).attr("routeid");
        var r=confirm("Are You Sure!")
        if (r==true)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }); 


</script>
