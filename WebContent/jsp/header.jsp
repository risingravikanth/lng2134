			<!--Start of left-fixed -navigation-->
			<%@page import="com.lnganalysis.constants.ApplicationConstants"%>
			<%@page import="com.lnganalysis.entities.domain.User" %>
			<%@page isELIgnored="false" %>
			<%
				User user=null;				
			 	if(null==session.getAttribute("user") || ("null").equals(session.getAttribute("user")))
	 			{				 		
			 		
		 			RequestDispatcher rd=request.getRequestDispatcher("/logout");// jsp/login.jsp	
		 			request.setAttribute(ApplicationConstants.LOGIN_RES,ApplicationConstants.SESSION_EXPIRED);
		 			rd.forward(request,response);
		 			
	 			}
			 	else if(null!=session.getAttribute("user"))
			 	{
			 		user=(User)session.getAttribute("user");
			 					 		
			 	}			 	
			%>
			<div class="sidebar" role="navigation">
				<div class="navbar-collapse">
					<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
						<ul class="nav" id="side-menu">
							<li>
								<a href="${pageContext.request.contextPath}/view?page=home"><i class="fa fa-home nav_icon"></i>Home</a>
							</li>							
							<li>
								<a href="${pageContext.request.contextPath}/view?page=changepwd"><i class="fa fa-key nav_icon"></i>Change Password </a>								
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/view?page=history"><i class="fa fa-history nav_icon"></i>History </a>								
							</li>
							<%if(null!=user && ("Y").equalsIgnoreCase(user.getAdmin())){ %>
							<li>
								<a href="#"><i class="fa fa-users nav_icon"></i>Administration<span class="fa arrow"></span></a>
								<ul class="nav nav-second-level collapse">
									<li>
										<a href="${pageContext.request.contextPath}/view?page=usermngmt">User Management</a>
									</li>
									<li>
										<a href="${pageContext.request.contextPath}/view?page=datamngmt">Data Management</a>																							
									</li>
									<li>
										<a href="${pageContext.request.contextPath}/view?page=terminalmngmt">Terminal Management</a>																							
									</li>
									<li>
										<a href="${pageContext.request.contextPath}/view?page=resetpwd">Reset Password</a>
									</li>
									<li>
										<a href="${pageContext.request.contextPath}/view?page=useraudit">User Tracking</a>
									</li>
									<li>
										<a href="${pageContext.request.contextPath}/view?page=reports">Reports</a>
									</li>
								</ul>
								<!-- /nav-second-level -->
							</li>
							<%} %>
							<li>
								<a href="${pageContext.request.contextPath}/view?page=profile"><i class="fa fa-user nav_icon"></i>Profile</a>								
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out nav_icon"></i>Logout</a>								
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
						<li class="dropdown head-dpdn">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-newspaper-o"></i></a>
							<ul class="dropdown-menu">
								<li>
									<div class="notification_header">
										<h3 class="center-text">Record Count of Each Tab</h3>
									</div>
								</li>
								<li>
									<div class="col-md-6"><b>Exploration:</b></div><div><p id="explorationCount">${sessionScope.explorationCount}</p></div>
									<div class="col-md-6"><b>Refineries:</b></div><div><p id="refineriesCount">${sessionScope.refineryCount}</p></div>
									<div class="col-md-6"><b>CrudeOil:</b></div><div><p id="crudeOilCount">${sessionScope.crudeoilCount}</p></div>
									<div class="col-md-6"><b>NaturalGas:</b></div><div><p id="naturalGasCount">${sessionScope.naturalGasCount}</p></div>
									<div class="col-md-6"><b>Lng:</b></div><div><p id="lngCount">${sessionScope.lngCount}</p></div>
									<div class="col-md-6"><b>Storage:</b></div><div><p id="storageCount">${sessionScope.storageCount}</p></div>
									<div class="col-md-6"><b>PipeLine:</b></div><div><p id="pipeLineCount">${sessionScope.pipelineCount}</p></div>									
								  <div class="clearfix"></div>	
								 </li>
								<!--  <li class="odd"><a href="#">
									<div class="user_img">Refineries</div>
								   <div class="notification_desc">
									<p>20 </p>
									<p><span>1 hour ago</span></p>
									</div>
								   <div class="clearfix"></div>	
								 </a></li>
								 <li><a href="#">
									<div class="user_img">CrudeOil</div>
								   <div class="notification_desc">
									<p>40</p>
									<p><span>1 hour ago</span></p>
									</div>
								   <div class="clearfix"></div>	
								 </a></li>-->
								 <li>
									<div class="notification_bottom">
										<button id="tabCount" type="button" class="btn btn-default" style="background-color: rgba(97, 100, 193, 0.85);color:#fff;border:none;outline:none">Refresh</button>
									</div> 
								</li>
							</ul>
						</li>
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
									 <%if(null!=user && (null==user.getUserImage() || ("null").equalsIgnoreCase(user.getUserImage()) || ("").equalsIgnoreCase(user.getUserImage()))){ %>	
										 <span class="prfil-img"><img src="${pageContext.request.contextPath}/images/layout/blank1.png" alt=""> </span>
									<%}else{ %>
										<span class="prfil-img"><img src="${pageContext.request.contextPath}/images/layout/${sessionScope.user.userImage}.png" alt=""> </span>
									<%} %>		
										<div class="user-name">
											<p>${sessionScope.user.email}</p><!-- Displaying User Name -->
											<span>${sessionScope.user.role}</span>
										</div>
										<i class="fa fa-angle-down lnr"></i>
										<i class="fa fa-angle-up lnr"></i>
										<div class="clearfix"></div>	
									</div>	
								</a>
								<ul class="dropdown-menu drp-mnu col-md-8" >
									<!-- <li> <a href="#"><i class="fa fa-cog"></i> Settings</a> </li>--> 
									<li> <a href="${pageContext.request.contextPath}/view?page=profile"><i class="fa fa-user"></i> Profile</a> </li> 
									<li> <a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out"></i> Logout</a> </li>
								</ul>
							</li>
						</ul>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="clearfix"> </div>
			</div>
			<!-- //header-ends -->
			
			