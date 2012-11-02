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
                                    <li><a href="managepackage.jsp">Remove/Edit Package</a></li>									
                                    <li class="divider"></li>
                                </ul>
                            </li>
							
							<li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Manage Customer<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="newcustomer.jsp">New Customer</a></li>
                                    <li><a href="blockcustmoer.jsp">Block Customer</a></li>
                                    <li><a href="unblockcustomer.jsp">Unblock Customer</a></li>
                                    <li class="divider"></li>                                    
                                </ul>
                            </li>
							
							<li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Manage Contents<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="edithome.jsp">Home</a></li>
                                    <li><a href="editaboutus.jsp">About Us</a></li>
                                    <li><a href="editcontactus.jsp">Contact Us</a></li>
									<li><a href="edittermsandcondition.jsp">Terms and Conditions</a></li>
                                    <li class="divider"></li>                                    
                                </ul>
                            </li>
                            
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Hotels<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="addhotel.jsp">New Hotel</a></li>
                                    <li><a href="managehotel.jsp">Remove/Edit Hotel</a></li>                                    
                                    <li class="divider"></li>                                    
                                </ul>
                            </li>
                            
                            <li class="dropdown">
                            	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Admin<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                	<li><a href="PackageBookingRequestServlet">Booking Request</a></li>
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
