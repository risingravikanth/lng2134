<!--Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>
<%@page isELIgnored="false" %>
<title>OG Analysis</title>
<!-- Custom Theme files -->
<link href="${pageContext.request.contextPath}/css/login/style.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<!--Google Fonts-->
<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!--Google Fonts-->
</head>
<body>
<!--header start here-->
	<div class="login">
		 <div class="login-main">
		 		<div class="login-top">
		 			<img src="${pageContext.request.contextPath}/images/login/head-img.png" alt=""/>
		 			<h1>Login <span class="anc-color"> to OG Analysis</span> </h1>
		 			<!-- <h2>Login with</h2>
		 			<ul>
		 				<li><a class="fa" href="#"> </a></li>
		 				<li><a class="tw" href="#"> </a></li>
		 				<li><a class="g" href="#"> </a></li>
		 			</ul>
		 			<h3> or</h3>-->
		 			<form id="loginform" action="/lnganalysis/login?validate=true" method="post">
				 		<input type="text" name="email" placeholder="Email" required="">
				 		<input type="password" name="password" placeholder="Password" required="">
				 		<div class="login-bottom">
					 			 <!--  <div class="login-check">
							 			<label class="checkbox"><input type="checkbox" name="checkbox" checked><i> </i> Remember Me</label>
							 		  </div>
							 		  <div class="login-para">
							 			<p><a href="#"> Forgot Password </a></p>
							 		 </div>
							 			<div class="clear"> </div>-->
						 </div>
				 		<input type="button" id="loginButton" value="Login"/>
				 		<!-- <h4>Don't have an account? <a href="#"> Register now! </a></h4>-->
				 		<div>&nbsp;</div>
				 		<div>
				 			<label style="display:none" id="loginFail">ID and Password don't Match</label>
				 			<label style="display:none" id="noresponse">No Response from Application</label>
				 			<label style="display:none" id="usernotexists">User doesn't Exists</label>
				 		</div>		 			
		 			</form>
		 			
		 		</div>
		 	</div>
  </div>
  <div class="copyright">
		 <p>&copy; 2016 OG Analysis Admin Panel. All rights reserved | Design by  <a href="http://w3layouts.com/" target="_blank">  Profectus Solutions </a></p>
	</div>
<!--header end here-->
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/scripts.js"></script>
    <script src="${pageContext.request.contextPath}/js/ajax.js"></script>
</body>
</html>