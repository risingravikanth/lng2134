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
								<form id="changepwd" class="form-horizontal" action="/lnganalysis/updatepwd" method="post"> 
									<div class="form-group"> 
										<label for="inputEmail3" class="col-sm-2 control-label">Current Password</label> 
										<div class="col-sm-9"> <input type="password" name="currentPassword" class="form-control" id="currentPassword" placeholder="Current Password"> </div>
									 </div> 
									 <div class="form-group"> 
									 	<label for="inputPassword3" class="col-sm-2 control-label">New Password</label>
									 	<div class="col-sm-9"> <input type="password" name="newPassword" class="form-control" id="newPassword" placeholder="New Password"> </div>
									 </div>
									  <div class="form-group"> 
									  	<label for="inputPassword3" class="col-sm-2 control-label">Re-enter Password</label>
									 	<div class="col-sm-9"> <input type="password" name="reenterNewPassword" class="form-control" id="reenterNewPassword" placeholder="Re-enter Password"> </div>
									  </div> 
									  <div class="col-sm-offset-2">&nbsp;<input  type="submit" id="submit" value="Submit"></div>
									    <div class="form-group"> 
									   <%String pwdRes=(String)request.getAttribute(ApplicationConstants.CHNG_PWD_RESPONSE);
						   		
						   	   			if(null!=pwdRes && (ApplicationConstants.CURR_PWD_NOT_MATCH).equalsIgnoreCase(pwdRes)){%>									
									  		<label for="inputPassword3" id="currentpwdnotmatch" class="col-sm-offset-3 control-label"><b>Current Password is incorrect</b></label>	
									  	<%}else if(null!=pwdRes && (ApplicationConstants.PWDS_NOT_MATCH).equalsIgnoreCase(pwdRes)){ %>
									  		<label for="inputPassword3" id="pwdsnotmatch" class="col-sm-offset-3 control-label"><b>Current Password and Re-Enter Password doesn't Match</b></label>
									  	<%}else if(null!=pwdRes && (ApplicationConstants.CURR_PWD_REQUIRED).equalsIgnoreCase(pwdRes)){ %>
									  		<label for="inputPassword3" id="currentpwdrequired" class="col-sm-offset-3 control-label"><b>Current Password is Required</b></label>
									  	<%}else if(null!=pwdRes && (ApplicationConstants.NEW_PWD_REQUIRED).equalsIgnoreCase(pwdRes)){%>	
									  		<label for="inputPassword3" id="newpwdrequired" class="col-sm-offset-3 control-label"><b>New Password is Required</b></label>
									  	<%}else if(null!=pwdRes && (ApplicationConstants.REENTER_PWD_REQUIRED).equalsIgnoreCase(pwdRes)){%>
									  		<label for="inputPassword3" id="reenterpwdrequired" class="col-sm-offset-3 control-label"><b>Re-enter Password is Required</b></label>
									  	<%}else if(null!=pwdRes && (ApplicationConstants.APP_EXCEPTION).equalsIgnoreCase(pwdRes)){%>
								  			<label for="inputPassword3" id="error" class="col-sm-offset-3 control-label"><b>Error in Application</b></label>
								  		<%}%>								 	
									  </div>
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
    			$("#currentPassword").focus(function(){
    					$("#currentpwdnotmatch").hide();
    					$("#pwdsnotmatch").hide();
    					$("#currentpwdrequired").hide();
    					$("#newpwdrequired").hide();
    					$("#reenterpwdrequired").hide();
    					$("#error").hide();
    			});
	  			$("#newPassword").focus(function(){
	  				$("#currentpwdnotmatch").hide();
					$("#pwdsnotmatch").hide();
					$("#currentpwdrequired").hide();
					$("#newpwdrequired").hide();
					$("#reenterpwdrequired").hide();
					$("#error").hide();
	  			});
	  			$("#reenterNewPassword").focus(function(){
	  				$("#currentpwdnotmatch").hide();
					$("#pwdsnotmatch").hide();
					$("#currentpwdrequired").hide();
					$("#newpwdrequired").hide();
					$("#reenterpwdrequired").hide();
					$("#error").hide();
	  			});
	  			  			
    		</script>
	</body>
</html>