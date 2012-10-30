<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Package Requests</title>
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
			
			.white-block{
				width:80%;
					
			}
        </style>
        

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
            	<h2 class="heading">Requests For Package Booking</h2>
                <div align="center">
                <div class="white-block">
                	<table cellpadding="0" cellspacing="0" class="table-striped">
                    <tr>
                    	<th>Package ID</th>
                        <th>Book By</th>                        
                        <th>Booking Date</th>
                        <th>Journey Date</th>
                        <th>No. of Person</th>
                        <th colspan="2">Action</th>                                                
                    </tr>
                    
                     <c:forEach items="${pkg_book_details}" var="pkg">
      				<form method="post" action="PackageBookingRequestServlet">
                    <tr>
                    	<input type="hidden" name="pb_id" value="${pkg.packagebooking_id}"> 
                    	<td>${pkg.packagebooking_id}</td>
                        <input type="hidden" name="Email_id" value="${pkg.email_id}">
                        <td>${pkg.email_id}</td>
                        <td>${pkg.booking_date}</td>
                        <td>${pkg.journey_date}</td>
                        <td>${pkg.no_of_persons}</td>
                        <input type="hidden" value="${pkg.fare}" name="fare">    
                        <td><button class="btn btn-modify-2 btn-success" name="req_type" value="Accept" onClick="">Accept</button></td>
                        <td><button class="btn btn-modify-2 btn-danger" name="req_type" onClick="" value="Reject">Reject</button></td>                   
                    </tr>
                     </form>
                    </c:forEach>
                    </table>
                </div>
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
