<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>	
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
						<div class="row"><!-- row one start -->
							<div class="col-md-1"></div>
							<div class="col-md-10">
								<div class=" form-grids row form-grids-right">
										<div class="widget-shadow " data-example-id="basic-forms"> 										
											<div class="form-body">
												<form id="formId" class="form-horizontal" action="fileupload" method="post" enctype="multipart/form-data"> 
													<div class="form-group"> 
														<label for="inputEmail3" class="col-sm-2 control-label">Select</label>
														<div class="col-md-8">
															<div class="input-group">															
																<input id="textId" type="text" class="form-control" placeholder="Upload File" disabled>												
																<input id="uploadfile" type="file" name="fileupload" style="display:none"/><!--style="display:none"-->
																<span class="input-group-btn">
																	<button class="btn btn-default" type="button" onclick="openFileBrowseWindow()"><i class="fa fa-search"></i>Find</button>
																</span>
															</div>
														</div>													
													</div> 												
												
												
													<!-- submit button-->
												
													<div class="form-group">									
														<div class="col-sm-offset-2 col-md-8">										
															<button id="fileuploadsubmit" type="button" class="btn btn-default">Submit</button> 											
															<span id="loadingimage" style="display:none"><img class="col-sm-offset-3" alt="LngLogo" src="${pageContext.request.contextPath}/images/loading2.gif"/></span>
										
															<!--<input type="submit"/>-->
										
														</div>										
														<!-- 	<div id="loadingimage" style="display:inline" class="col-sm-offset-3 col-sm-4 col-md-3">
																<img alt="LngLogo" src="${pageContext.request.contextPath}/images/loading2.gif"/>
															</div>	-->																								
													</div>
													 <div class="form-group" id="successMsg" style="display:none"> 
									  					<label for="inputPassword3" class="col-sm-offset-3 control-label"><b>Data Upload has been Successful</b></label>									 	
									 				 </div>
									 				 <div class="form-group" id="appNotRespond" style="display:none"> 
									  					<label for="inputPassword3" class="col-sm-offset-3 control-label"><b>No Response from Application</b></label>									 	
									 				 </div>
									 				 <div class="form-group" id="incorrectDataMsg" style="display:none"> 
									  					<label for="inputPassword3" class="col-sm-offset-3 control-label"><b>Data Upload has been failed due to InCorrect Data</b></label>									 	
									 				 </div>
									 				 <div class="form-group" id="invalidDataMsg" style="display:none"> 
									  					<label for="inputPassword3" class="col-sm-offset-3 control-label"><b>Data Upload has been failed due to InValid Data</b></label>									 	
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
								<table id="errorTable" class="table" style="display:none">
									<thead>
										<tr>
											<th>S.NO</th>
											<th>Tab(s)</th>
											<th>RECORDS</th>
											<th>TOTAL_RECORDS</th>
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
									<tbody id="errorTableBody">
											<!-- <tr>
												<th scope="row">1</th>
												<td>Lorem ipsum, adasdfsadf,asdfasdf, asdfasdfasdf,asdfasdfadf, asdfasdfadsf,asdfasdfasdfa, 1,2,3,4,5,6</td>
												<td><span class="label label-success">In progress</span></td>
												<td><h5>85% <i class="fa fa-level-up"></i></h5></td>
												<td><h5>85% <i class="fa fa-level-up"></i></h5></td>																								
											</tr>-->
											
									</tbody>
								</table>
							</div>
							</div><!--  tables ending -->
							
							<div class="clearfix"> </div>
						</div><!-- row two ending -->
					</div><!-- Forms div ending -->
				</div><!-- main page ending -->
			</div><!--page-wrapper ending  -->
			<!-- including footer content  -->
			<%@include file="footer.jsp"%>
	</body>
</html>