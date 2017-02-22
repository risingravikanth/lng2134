<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
	<%@page isELIgnored="false" %>
	<head>
		<title>OG Analysis</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="oganalysis" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<!-- Bootstrap Core CSS -->
		<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel='stylesheet' type='text/css' />
			<!-- Custom CSS -->
		<link href="${pageContext.request.contextPath}/css/layout/style.css" rel='stylesheet' type='text/css' />
		<!-- font CSS -->
		<!-- font-awesome icons -->
		<link href="${pageContext.request.contextPath}/css/font-awesome.css" rel="stylesheet"> 
		
		<!-- //font-awesome icons -->
 		<!-- js-->
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/layout/modernizr.custom.js"></script>
		<!--webfonts-->
		<link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
		<!--//webfonts--> 
		<!--animate-->
		<link href="${pageContext.request.contextPath}/css/layout/animate.css" rel="stylesheet" type="text/css" media="all">
		<script src="${pageContext.request.contextPath}/js/layout/wow.min.js"></script>
		<script>
			 new WOW().init();
		</script>
		<!--//end-animate-->
		<!-- Metis Menu -->
		<script src="${pageContext.request.contextPath}/js/layout/metisMenu.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/layout/custom.js"></script>
		<link href="${pageContext.request.contextPath}/css/layout/custom.css" rel="stylesheet">
		<!--//Metis Menu -->
	</head>
	<body class="cbp-spmenu-push">
		<div class="main-content">
			<!--Start of left-fixed -navigation-->
			<div class=" sidebar" role="navigation">
				<div class="navbar-collapse">
					<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
						<ul class="nav" id="side-menu">
							<li>
								<a href="index.html"><i class="fa fa-home nav_icon"></i>Home</a>
							</li>							
							<li>
								<a href="#"><i class="fa fa-key nav_icon"></i>Change Password </a>								
							</li>
							<li>
								<a href="#"><i class="fa fa-history nav_icon"></i>History </a>								
							</li>
							<li>
								<a href="#"><i class="fa fa-users nav_icon"></i>Administration<span class="fa arrow"></span></a>
								<ul class="nav nav-second-level collapse">
									<li>
										<a href="#">User Management</a>
									</li>
									<li>
										<a href="#">Data Management</a>
									</li>
								</ul>
								<!-- /nav-second-level -->
							</li>
							<li>
								<a href="#"><i class="fa fa-user nav_icon"></i>Profile</a>								
							</li>
							<li>
								<a href="#"><i class="fa fa-sign-out nav_icon"></i>Logout</a>								
							</li>
						</ul>
						<div class="clearfix"> </div>
						<!-- //sidebar-collapse -->
					</nav>
				</div>
			</div>
			<!--End of left-fixed -navigation-->
			<!-- header-starts -->
			<div class="sticky-header header-section ">
				<div class="header-left">
					<!--toggle button start-->
						<button id="showLeftPush"><i class="fa fa-bars"></i></button>
					<!--toggle button end-->
					<!--logo -->
					<div class="logo">
						<a href="index.html">
							<h1>OG Analysis</h1>
							<span>AdminPanel</span>
						</a>
					</div>
					<!--//logo-->
					<!--search-box-->
					<div class="search-box">
						<form class="input">
							<input class="sb-search-input input__field--madoka" placeholder="Search..." type="search" id="input-31" />
							<label class="input__label" for="input-31">
								<svg class="graphic" width="100%" height="100%" viewBox="0 0 404 77" preserveAspectRatio="none">
									<path d="m0,0l404,0l0,77l-404,0l0,-77z"/>
								</svg>
							</label>
						</form>
					</div><!--//end-search-box-->
					<div class="clearfix"> </div>
				</div>
				<div class="header-right">
					<div class="profile_details_left"><!--notifications of menu start -->
					<ul class="nofitications-dropdown">
						<!-- one notification<li class="dropdown head-dpdn"> 
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-envelope"></i><span class="badge">3</span></a>
							<ul class="dropdown-menu">
								<li>
									<div class="notification_header">
										<h3>You have 3 new messages</h3>
									</div>
								</li>
								<li><a href="#">
								   <div class="user_img"><img src="images/1.png" alt=""></div>
								   <div class="notification_desc">
									<p>Lorem ipsum dolor amet</p>
									<p><span>1 hour ago</span></p>
									</div>
								   <div class="clearfix"></div>	
								</a></li>
								<li class="odd"><a href="#">
									<div class="user_img"><img src="images/2.png" alt=""></div>
								   <div class="notification_desc">
									<p>Lorem ipsum dolor amet </p>
									<p><span>1 hour ago</span></p>
									</div>
								  <div class="clearfix"></div>	
								</a></li>
								<li><a href="#">
								   <div class="user_img"><img src="images/3.png" alt=""></div>
								   <div class="notification_desc">
									<p>Lorem ipsum dolor amet </p>
									<p><span>1 hour ago</span></p>
									</div>
								   <div class="clearfix"></div>	
								</a></li>
								<li>
									<div class="notification_bottom">
										<a href="#">See all messages</a>
									</div> 
								</li>
							</ul>
						</li> one notification-->
						<!-- two notification<li class="dropdown head-dpdn">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-bell"></i><span class="badge blue">3</span></a>
							<ul class="dropdown-menu">
								<li>
									<div class="notification_header">
										<h3>You have 3 new notification</h3>
									</div>
								</li>
								<li><a href="#">
									<div class="user_img"><img src="images/2.png" alt=""></div>
								   <div class="notification_desc">
									<p>Lorem ipsum dolor amet</p>
									<p><span>1 hour ago</span></p>
									</div>
								  <div class="clearfix"></div>	
								 </a></li>
								 <li class="odd"><a href="#">
									<div class="user_img"><img src="images/1.png" alt=""></div>
								   <div class="notification_desc">
									<p>Lorem ipsum dolor amet </p>
									<p><span>1 hour ago</span></p>
									</div>
								   <div class="clearfix"></div>	
								 </a></li>
								 <li><a href="#">
									<div class="user_img"><img src="images/3.png" alt=""></div>
								   <div class="notification_desc">
									<p>Lorem ipsum dolor amet </p>
									<p><span>1 hour ago</span></p>
									</div>
								   <div class="clearfix"></div>	
								 </a></li>
								 <li>
									<div class="notification_bottom">
										<a href="#">See all notifications</a>
									</div> 
								</li>
							</ul>
						</li>	two notification-->
						<li class="dropdown head-dpdn"><!--  This is for vertical line before profile on right side top corner -->
							<div>&nbsp;</div>							
						</li>	
					</ul>
					<div class="clearfix"> </div>
				</div>
				<!--notification menu end -->
					<div class="profile_details">		
						<ul>
							<li class="dropdown profile_details_drop">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
									<div class="profile_img">	
										<span class="prfil-img"><img src="${pageContext.request.contextPath}/images/layout/a.png" alt=""> </span> 
										<div class="user-name">
											<p>Wikolia</p>
											<span>Administrator</span>
										</div>
										<i class="fa fa-angle-down lnr"></i>
										<i class="fa fa-angle-up lnr"></i>
										<div class="clearfix"></div>	
									</div>	
								</a>
								<ul class="dropdown-menu drp-mnu">
									<li> <a href="#"><i class="fa fa-cog"></i> Settings</a> </li> 
									<li> <a href="#"><i class="fa fa-user"></i> Profile</a> </li> 
									<li> <a href="#"><i class="fa fa-sign-out"></i> Logout</a> </li>
								</ul>
							</li>
						</ul>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="clearfix"> </div>
			</div>
			<!-- //header-ends -->
			<!-- main content start Main content-->
			<div id="page-wrapper"><!-- page-wrapper starting -->
				<div class="main-page"><!-- main page starting -->
					<div class="forms"><!-- Forms div starting -->
						<div class="row"><!-- row one start -->
							<div class="col-md-1"></div>
							<div class="col-md-10">
								<div class=" form-grids row form-grids-right">
										<div class="widget-shadow " data-example-id="basic-forms"> 										
											<div class="form-body">
												<form class="form-horizontal"> 
													<div class="form-group"> 
														<label for="inputEmail3" class="col-sm-2 control-label">Select</label>
														<div class="col-md-8">
															<div class="input-group">															
																<input id="textId" type="text" class="form-control" placeholder="Upload File" disabled>												
																<input id="uploadfile" type="file" name="fileupload" style="display:none"/><!--style="display:none"-->
																<span class="input-group-btn">
																	<button class="btn btn-default" type="button" onclick="openFileBrowseWindow()"><i class="fa fa-search"></i> Find</button>
																</span>
															</div>
														</div>													
													</div> 												
												
												
													<!-- submit button-->
												
													<div class="form-group">									
														<div class="col-sm-offset-2 col-md-8">										
															<button type="submit" class="btn btn-default">Submit</button> 											
															<span id="loadingimage" style="display:line"><img class="col-sm-offset-3" alt="LngLogo" src="${pageContext.request.contextPath}/images/loading2.gif"/></span>
										
															<!--<input type="submit"/>-->
										
														</div>										
														<!-- 	<div id="loadingimage" style="display:inline" class="col-sm-offset-3 col-sm-4 col-md-3">
																<img alt="LngLogo" src="${pageContext.request.contextPath}/images/loading2.gif"/>
															</div>	-->																								
													</div>
												</form> 
												
											</div>
										</div>
								</div>	
							</div>
							<div class="col-md-1"></div>
						</div><!-- row one end -->
						<div class="row"> <!-- row two starting -->
							<!-- <div class="col-md-2"></div>-->
							<div class="tables"><!-- tables starting -->
							<div class="col-md-12 table-responsive widget-shadow">
								<table class="table">
									<thead>
										<tr>
											<th>S.NO</th>
											<th>Tab(s)</th>
											<th>RECORDS</th>
											<th>TOTALRECORDS</th>
											<!-- <th>Exploration</th>
											<th>Refineries</th>
											<th>LNG</th>
											<th>STORAGE</th>
											<th>PIPELINE</th>
											<th>CRUDEOIL</th>
											<th>NATURAL</th>-->
											<th>COLUMN(S)</th>
									
										</tr>
									</thead>
									<tbody>
											<tr>
												<th scope="row">1</th>
												<td>Lorem ipsum, adasdfsadf,asdfasdf, asdfasdfasdf,asdfasdfadf, asdfasdfadsf,asdfasdfasdfa, 1,2,3,4,5,6</td>
												<td><span class="label label-success">In progress</span></td>
												<td><h5>85% <i class="fa fa-level-up"></i></h5></td>
												<td><h5>85% <i class="fa fa-level-up"></i></h5></td>
												
												
											</tr>
											<tr>
												<th scope="row">2</th>
												<td>Aliquam</td>
												<td><span class="label label-warning">New</span></td>
												<td><h5>35% <i class="fa fa-level-up"></i></h5></td>
												<td><h5>85% <i class="fa fa-level-up"></i></h5></td>
											</tr>
											<tr>
												<th scope="row">3</th>
												<td>Lorem ipsum</td>
												<td><span class="label label-danger">Overdue</span></td>
												<td><h5  class="down">40% <i class="fa fa-level-down"></i></h5></td>
											</tr>
											<tr>
												<th scope="row">4</th>
												<td>Aliquam</td>
												<td><span class="label label-info">Out of stock</span></td>
												<td><h5>100% <i class="fa fa-level-up"></i></h5></td>
											</tr>
											<tr>
												<th scope="row">5</th>
												<td>Lorem ipsum</td>
												<td><span class="label label-success">In progress</span></td>
												<td><h5 class="down">10% <i class="fa fa-level-down"></i></h5></td>
											</tr>
											<tr>
												<th scope="row">6</th>
												<td>Aliquam</td>
												<td><span class="label label-warning">New</span></td>
												<td><h5>38% <i class="fa fa-level-up"></i></h5></td>
											</tr>
									</tbody>
								</table>
							</div>
							</div><!--  tables ending -->
							
							<div class="clearfix"> </div>
						</div><!-- row two ending -->
					</div><!-- Forms div ending -->
				</div><!-- main page ending -->
			</div><!--page-wrapper ending  -->
			<!--footer-->
			<div class="footer">
		   		<p>&copy; 2016 Novus Admin Panel. All Rights Reserved | Design by <a href="https://w3layouts.com/" target="_blank">w3layouts</a></p>
			</div>
        	<!--//footer-->
		</div><!-- main-content div closing -->
		<!-- Classie -->
		<script src="${pageContext.request.contextPath}/js/layout/classie.js"></script>
		<script>
			var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
				showLeftPush = document.getElementById( 'showLeftPush' ),
				body = document.body;
				
			showLeftPush.onclick = function() {
				classie.toggle( this, 'active' );
				classie.toggle( body, 'cbp-spmenu-push-toright' );
				classie.toggle( menuLeft, 'cbp-spmenu-open' );
				disableOther( 'showLeftPush' );
			};
			
			function disableOther( button ) {
				if( button !== 'showLeftPush' ) {
					classie.toggle( showLeftPush, 'disabled' );
				}
			}
		</script>
		<!--scrolling js-->
		<script src="${pageContext.request.contextPath}/js/layout/jquery.nicescroll.js"></script>
		<script src="${pageContext.request.contextPath}/js/layout/scripts.js"></script>
		<!--//scrolling js-->
		<!-- Bootstrap Core JavaScript -->
   		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"> </script>	<!--  Actual existing file is bootstrap.js -->
	</body>
</html>