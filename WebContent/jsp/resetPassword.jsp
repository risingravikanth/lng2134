<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<%@page import="com.lnganalysis.constants.ApplicationConstants"%>
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
			<!-- including header content  -->
			<%@include file="header.jsp"%>
			<!-- main content start Main content-->
			<div id="page-wrapper"><!-- page-wrapper starting -->
				<div class="main-page"><!-- main page starting -->
					<div class="forms"><!-- Forms div starting -->
						<div class=" form-grids row form-grids-right">
						<div class="widget-shadow " data-example-id="basic-forms"> 
							<div class="form-title">
								<h4>&nbsp;</h4>
							</div>
							<div class="form-body">
								<form id="changepwd" class="form-horizontal" action="/lnganalysis/resetpwd" method="post"> 
									<div class="form-group"> 
										<label for="inputEmail3" class="col-sm-2 control-label">Email</label> 
										<div class="col-sm-4"> <input type="text" name="email" class="form-control" id="email" placeholder="Enter Email"> </div>
									 </div> 
									 <div class="form-group"> 
									 	<label for="inputPassword3" class="col-sm-2 control-label">New Password</label>
									 	<div class="col-sm-4"> <input type="password" name="resetpassword" class="form-control" id="resetpassword" placeholder="New Password"> </div>
									 </div>
									 <div class="col-sm-offset-2">&nbsp;<input type="submit" id="submit" value="Reset Password"></div>
									 <%String resetpwd=(String)request.getAttribute(ApplicationConstants.RESET_PWD_RES);
						   		
						   	   			if(null!=resetpwd && (ApplicationConstants.SUCCESS).equalsIgnoreCase(resetpwd)){%>
						   	   			<label  id="resetpwdsuccess" class="col-sm-offset-3 control-label"><b>Password Reset is successful</b></label>	
									  	<%} else if(null!=resetpwd && (ApplicationConstants.EMAIL_REQUIRED).equalsIgnoreCase(resetpwd)){ %>
									  		<label  id="emailrequired" class="col-sm-offset-3 control-label"><b>Enter Email </b></label>	
									  	<%}  else if(null!=resetpwd && (ApplicationConstants.PWD_REQUIRED).equalsIgnoreCase(resetpwd)){ %>
									  	 <label  id="passwordrequired" class="col-sm-offset-3 control-label"><b>Enter Password </b></label>
									  	 <%}else if(null!=resetpwd && (ApplicationConstants.FAIL).equalsIgnoreCase(resetpwd)){ %>
									  		 <label  id="resetpwdfail" class="col-sm-offset-3 control-label"><b>Password Reset is not Successful</b></label>
									  	 <%}else if(null!=resetpwd && (ApplicationConstants.APP_EXCEPTION).equalsIgnoreCase(resetpwd)){ %>
								  		 	<label  id="error" class="col-sm-offset-3 control-label"><b>Error in Application</b></label>
								  		 <%} %>
								 </form> 
							</div>
						</div>
					</div>
					</div><!-- Forms div ending -->
				</div><!-- main page ending -->
			</div><!--page-wrapper ending  -->
			<!-- including footer content  -->
			<%@include file="footer.jsp"%>
			 <script>
    			$("#email").focus(function(){
    					$("#resetpwdsuccess").hide();
    					$("#emailrequired").hide();
    					$("#passwordrequired").hide();
    					$("#resetpwdfail").hide();
    					$("#error").hide();
    					
    			});
	  			$("#resetpassword").focus(function(){
	  				$("#resetpwdsuccess").hide();
					$("#emailrequired").hide();
					$("#passwordrequired").hide();
					$("#resetpwdfail").hide();
					$("#error").hide();
	  			});	  			  	
	  			
    		</script>
	</body>
</html>