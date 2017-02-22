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
		<meta name="keywords" content="ognalaysis" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<link href="${pageContext.request.contextPath}/css/jquery-ui.css" rel="stylesheet">
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
			<!-- including header content  -->
			<%@include file="header.jsp"%>
			<!-- main content start Main content-->
			<!--page-wrapper ending  -->
			<div id="page-wrapper">
			<div class="main-page">
				<div class="elements  row">
					<div class="col-md-offset-4 col-md-4 profile widget-shadow">
						<h4 class="title3">Profile</h4>
						<div class="profile-top">
							<img src="${pageContext.request.contextPath}/images/layout/${sessionScope.user.userImage}.png" alt="">
							<h4>${sessionScope.user.userName}</h4>
							<h5>${sessionScope.user.role}</h5>
						</div>
						<div class="profile-text">
							<div class="profile-row">
								<div class="profile-left">
									<i class="fa fa-envelope profile-icon"></i>
								</div>
								<div class="profile-right">
									<h4>${sessionScope.user.email}</h4>
									<p>Email</p>
								</div> 
								<div class="clearfix"> </div>	
							</div>
							<div class="profile-row row-middle">
								<div class="profile-left">
									<i class="fa fa-user profile-icon"></i>
								</div>
								<div class="profile-right">
									<h4>${sessionScope.user.firstName}</h4>
									<p>First Name</p>
								</div> 
								<div class="clearfix"> </div>	
							</div>
							<div class="profile-row">
								<div class="profile-left">
									<i class="fa fa-user profile-icon"></i>
								</div>
								<div class="profile-right">
									<h4>${sessionScope.user.lastName}</h4>
									<p>Last Name</p>
								</div> 
								<div class="clearfix"> </div>	
							</div>								
							<div class="profile-row row-middle">
								<div class="profile-left">
									<i class="fa fa-mobile profile-icon"></i>
								</div>
								<div class="profile-right">
									<h4>${sessionScope.user.mobile}</h4>
									<p>Contact Number</p>
								</div> 
								<div class="clearfix"> </div>	
							</div>
							<div class="profile-row">
								<div class="profile-left">
									<i class="fa fa-map-marker profile-icon"></i>
								</div>
								<div class="profile-right">
									<h4>${sessionScope.user.address}</h4>
									<p>Address</p>
								</div> 
								<div class="clearfix"> </div>	
							</div>
						</div>
					</div>
				
					<div class="clearfix"> </div>	
				</div>
			
			</div>
		</div>
			<!-- including footer content  -->
			<%@include file="footer.jsp"%>
			 
	</body>
</html>