<link rel="icon" href="img/favicon.ico">
	<div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="home.jsp">Admin Panel</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">                            
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Buses<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="newbus.jsp">New Bus</a></li>
                                    <li><a href="GetAllBus">Remove/Edit Bus</a></li>
                                    <li class="divider"></li>                                    
                                </ul>
                            </li>
							<li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Routes<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="newroute.jsp">New Route</a></li>
                                    <li><a href="manageroute.jsp">Remove/Edit Route</a></li>
                                    <li class="divider"></li>                                    
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Station<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="addstation.jsp">New Station</a></li>
                                    <li><a href="editstation.jsp">Edit Station</a></li>
                                    <li><a href="removestation.jsp">Remove Station</a></li>
                                    <li><a href="showstations.jsp">Station List</a></li>
                                    <li class="divider"></li>                                    
                                </ul>
                            </li>                                                
                            
                            
							<li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Packages<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="AddPackageServlet">New Package</a></li>
                                    <li><a href="ManagePackageServlet">Remove/Edit Package</a></li>
                                    <li><a href="AddPackageImages">Add Package Image</a></li>
                                    <li><a href="ManagePackageImage">Manage Package Images</a></li>									
                                    <li class="divider"></li>
                                </ul>
                            </li>
							
							<li class="dropdown">
                                <a href="FetchBusBookingDetail" class="dropdown-toggle" data-toggle="dropdown">Report<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="FetchBusBookingDetail">Booking List</a></li>
                                    <li class="divider"></li>                                    
                                </ul>
                            </li>
							
							<li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Manage Contents<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="PageContentServlet?id=1">Home</a></li>
                                    <li><a href="PageContentServlet?id=2">About Us</a></li>
                                    <li><a href="PageContentServlet?id=3">Contact Us</a></li>
									<li><a href="PageContentServlet?id=4">Terms and Conditions</a></li>
                                    <li class="divider"></li>                                    
                                </ul>
                            </li>
                            
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Hotels<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="addhotel.jsp">New Hotel</a></li>
                                    <li><a href="AddHotelServlet">Remove/Edit Hotel</a></li>
                                    <li><a href="RoomServlet">Add Hotel Rooms</a></li>                                    
                                    <li class="divider"></li>                                    
                                </ul>
                            </li>
                            
                            <li class="dropdown">
                            	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Admin<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                	<li><a href="PackageBookingRequestServlet">Booking Request</a></li>
                                	<li><a href="PackagePaidStatusServlet">Booking Payment Status</a></li>
                                    <li><a href="changepassword.jsp">Change Password</a></li>
                                    <li><a href="../LogOut">LogOut</a></li>                                    
                                    <li class="divider"></li>                                    
                                </ul>
                            </li>
                        </ul>
                        
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>
        <noscript>
	<h3>This site requires javascripts to be enabled on your browser. Kindly enable javascript to use the side. </h3>
	<style type="text/css">
		.container{
		display:none;
		}
	</style>
</noscript>
