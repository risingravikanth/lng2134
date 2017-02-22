<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<%@page import="com.lnganalysis.constants.ApplicationConstants"%>
<html>
	<head>
		<title>OG Analysis</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="oganalyis" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<!-- Bootstrap Core CSS -->
		<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel='stylesheet' type='text/css' />
			<!-- Custom CSS -->
		<link href="${pageContext.request.contextPath}/css/login/style.css" rel='stylesheet' type='text/css' />
		<!-- font CSS -->
		<!-- font-awesome icons -->
		<link href="${pageContext.request.contextPath}/css/font-awesome.css" rel="stylesheet"> 
		
		<!-- //font-awesome icons -->
 		<!-- js-->
 		<script src="${pageContext.request.contextPath}/js/constants.js"></script>
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
		<style>
		#modalDialog {
   					width: 400px;
    				height: 50px;
    				position: absolute;
    				top: 40%;
    				left: 50%;
    				margin-top: -25px;
    				margin-left: -200px;
    				padding: 20px;
		}
		.modalSubmitButton{
			background-color: rgba(97, 100, 193, 0.85);
   			color: #fff;
    		padding: .5em 1.5em;
    		border: none;
    		outline: none;
    		border-radius: inherit;
		}
		</style>
	</head> 
<body>
	<div class="main-content">
			<%@page isELIgnored="false" %>
		
		<!-- main content start-->
		<div id="page-wrapper">
			<div class="main-page login-page ">
				<h3 class="title1">SignIn Page</h3>
				<div class="widget-shadow">
					<div class="login-top">
						<h4>Welcome  to OG Analysis Admin!</h4>
					</div>
					<div class="login-body">
						<form id="loginform" action="/lnganalysis/login" method="post">
							
							<input type="text" class="user" name="email" id="email" placeholder="Enter your email" value="${requestScope.enteredEmail}" autocomplete="off">
							<input type="password" class="lock" name="password" id="password" placeholder="Password">
							<!-- <input type="submit" name="Sign In" value="Sign In"/>-->
							<input type="submit" name="Sign In" id="signInButton" value="Sign In"/>
							<div class="forgot-grid">								
								<div class="forgot">
									<a href="#" id="forgotPwd">Forgot password?</a>									
								</div>
								<div class="clearfix"> </div>
							</div>
						</form>
						<div>							
							<label style="display:none" class="col-md-offset-4" id="forgotpwdMsg"></label>							
							<!-- <label style="display:none" class="col-md-offset-5" id="passwordrequired">Enter Your Password</label> -->
						   <% String loginRes=(String)request.getAttribute(ApplicationConstants.LOGIN_RES);						   		
						   	   if(null!=loginRes && (ApplicationConstants.LOGIN_FAIL).equalsIgnoreCase(loginRes)){%>
				 			<label style="display:inline" class="col-md-offset-4" id="loginFail">ID and Password don't Match</label>
				 			<%}else if(null!=loginRes && (ApplicationConstants.USER_NOT_EXISTS).equalsIgnoreCase(loginRes)){ %>
				 				<label style="display:inline" class="col-md-offset-5" id="usernotexists">User doesn't Exists</label>
				 			<%}else if(null!=loginRes && (ApplicationConstants.APP_EXCEPTION).equalsIgnoreCase(loginRes)){  %>	
				 			<label style="display:inline" class="col-md-offset-4" id="error">Error in Application</label>
				 			<%}else if(null!=loginRes && (ApplicationConstants.EMAIL_REQUIRED).equalsIgnoreCase(loginRes)){ %>
				 				<label style="display:inline" class="col-md-offset-5" id="emailrequired">Enter Your Email</label>
				 			<%}else if(null!=loginRes && (ApplicationConstants.PWD_REQUIRED).equalsIgnoreCase(loginRes)){ %>
				 				<label style="display:inline" class="col-md-offset-4" id="passwordrequired">Enter Your Password</label>
				 			<%}else if(null!=loginRes && (ApplicationConstants.SESSION_EXPIRED).equalsIgnoreCase(loginRes)){ %>
				 			 <label style="display:inline" class="col-md-offset-4" id="sessionexpired">Session Expired.Login Again</label>
				 			<%} %> 
				 		</div>	
					</div>
				</div>
				
				<div class="login-page-bottom">					
					<div >&nbsp;</div>
					<div>&nbsp;</div>
				</div>
			</div>
			<!-- Modal Starting -->
				<!-- Button trigger modal -->
					<!-- <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  							Launch demo modal
					</button>-->

					<!-- Modal -->
						<div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  							<div id="modalDialog" class="modal-dialog" role="document">
    							<div class="modal-content">
      								<div class="modal-header">
        								<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        								<h4 class="modal-title" id="myModalLabel"><b>Forgot Password</b></h4>
      								</div>
      								<div class="modal-body col-md-12">
        								<input type="text" style="width:100%" name="email" id="forgotpwdemail" placeholder="Enter your email">
      								</div>
      								<div class="modal-footer">
        								<!-- <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>-->
        								<div class="col-md-6"><label style="display:none" id="emailforpwdreset">Enter Your Email</label></div>        								
        								<button id="forgotpwdsubmit" type="button" class="btn btn-default">Submit</button>
      								</div>
    							</div>
  							</div>
						</div>
			<!-- Modal Ending -->
		</div>
		
		<!--footer-->
		<div class="footer">
		   <p>&copy; 2016 OG Admin Panel. All Rights Reserved | Design by <a href="https://w3layouts.com/" target="_blank">Profectus Solutions</a></p>
		</div>
        <!--//footer-->
	</div>
	<!-- Classie -->
		<!-- <script src="${pageContext.request.contextPath}/js/classie.js"></script>-->
		
		<script src="${pageContext.request.contextPath}/js/layout/jquery.nicescroll.js"></script>
		<script src="${pageContext.request.contextPath}/js/layout/scripts.js"></script>
		<!--//scrolling js-->
		<!-- Bootstrap Core JavaScript -->
   		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"> </script>
   		<!-- application related js files -->
   			<script src="${pageContext.request.contextPath}/js/scripts.js"></script>
    		<script src="${pageContext.request.contextPath}/js/ajax.js"></script>
    		
    	<!-- application related js files -->
    	<script>
    	 $("#email").focus(function(){
    	    	$("#passwordrequired").hide();
    			$("#emailrequired").hide();
    			$("#loginFail").hide();
    			$("#usernotexists").hide();
    			$("#error").hide();
    			$("#emailforPwdreset").hide();
    			$("#forgotpwdsuccess").hide();
    			$("#forgotpwdfail").hide();
    			$("#sessionexpired").hide();
    			
    	    });
    	    $("#password").focus(function(){
    	    	$("#passwordrequired").hide();
    			$("#emailrequired").hide();
    			$("#loginFail").hide();
    			$("#usernotexists").hide();
    			$("#error").hide();
    			$("#emailforPwdreset").hide();
    			$("#forgotpwdsuccess").hide();
    			$("#forgotpwdfail").hide();
    			$("#sessionexpired").hide();
    	    });
    	    $("#forgotpwdemail").focus(function(){
    	    	
    			$("#emailforpwdreset").hide();
    			
    	    });
    	    
    	    $("#forgotPwd").click(function()
    	    	    {
    	    	$("#emailforpwdreset").hide();
    	    	$("#passwordrequired").hide();
    			$("#emailrequired").hide();
    			$("#loginFail").hide();
    			$("#usernotexists").hide();
    			$("#error").hide();
    			$("#sessionexpired").hide();
    			$("#emailforPwdreset").hide();
    			$("#forgotpwdsuccess").hide();
    			$("#forgotpwdfail").hide();
    	    	$("#forgotpwdemail").val(''); //Assign blank to the input text

    	    	//modal script start 
    	    	$('#myModal').modal({
    	  			keyboard: false,
    	  			backdrop: 'static',
    			});
    	    });
    	</script>   	
</body>
</html>