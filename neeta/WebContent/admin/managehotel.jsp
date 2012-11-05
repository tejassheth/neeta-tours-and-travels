<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <head>
    
        
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Manage Hotel</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js">
        </script>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-responsive.css">
        <link rel="stylesheet" href="css/main.css">
        
        <style type="text/css">
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
        </style>
        
        <script src="js/modernizr-2.6.1-respond-1.1.0.min.js"></script>
        
        <script type="text/javascript">
        
        
        
      
        
        
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
            	<h2 class="heading">Manage Hotel</h2>
                <div class="white-block">
                
                	<table cellpadding="0" cellspacing="0">
                    <tr>
                    	
                    	<th>Hotel ID</th>
                        <th>Hotel Name</th>
                        <th>Hotel Type</th>
                        
                        <th>Contact Details</th>
                        <th colspan="2">Action</th>
                    </tr>
                    
      <c:forEach items="${Hotel_List}" var="List">
      <form method="post" action="AddHotelServlet">
        <tr valign="middle" align="center" class="abc">
        
        	
            <td>${List.h_id}</td>
            <td>${List.hname}</td>
            <td>${List.type} Star</td>
            
            <td>${List.contact_det}</td>
             
            
 				<input type="hidden"  name="h_id"  value="${List.h_id}" >         
            <td><button  class="btn btn-modify-2 btn-warning" name="fun_type" onClick="" value="edit">Edit</button></td>
            <td><button  class="btn btn-modify-2 btn-danger" name="fun_type" onClick="" value="delete">Delete</button></td>
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
function delete(){
	var result=confirm('Are you sure u want to delete');
	if(result==true)
	return true;
	else
	return false;
}


</script>
