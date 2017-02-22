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
		<link href="${pageContext.request.contextPath}/css/datatable.css" rel='stylesheet' type='text/css' />
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
						<div class="row"><!-- row one starting -->
								<div class="form-two widget-shadow">
									<div class="form-title">
										<h4><button id="addSource" type="button" class="btn btn-default">Add Source</button></h4>
									</div>
									<div class="col-md-offset-4">
										<div class="form-body" data-example-id="simple-form-inline">
											<form class="form-inline" id="dataForm"  method="post"> 																		
														 
											  	<div class="form-group">
											  		<div class="col-sm-4">
											  			<label for="selector1" class="col-sm-2 control-label">Select DropDown</label>
											  		</div>
											  															
													<div class="col-sm-8">
														<select name="sourceList" id="sourceList" class="form-control1">
															<option>Exploration</option>
															<option>Refinery</option>
															<option>Storage</option>
															<option>CrudeOil</option>
															<option>NaturalGas</option>
															<option>Lng</option>
															<option>Pipeline</option>
															<option>Countries</option>
															<option>Region</option>
															<option>Status</option>
															<option>Type</option>												
														</select>
													</div>																																																			
												</div>											    
											    <button id="userSubmit" type="button" class="btn btn-default">Submit</button>
											    <div>&nbsp;</div>
											    <div class="form-group col-md-12 col-md-offset-2">
													 <label id="nodatarecords" style="display:none">No Records</label>
													 <label id="saved" style="display:none">Record Saved Successfully</label>
													 <label id="notsaved" style="display:none">Record not Saved</label>	
													 <label id="notdeleted" style="display:none">Record not Deleted</label>	
													 <label id="deleted" style="display:none">Record Deleted Successfully</label>	
													 <label id="mandatory" style="display:none">Name is Manadatory</label>												
											    </div>
										     </form> 
										</div>
									</div>
						
								</div>
						</div><!-- row one ending -->
						<div class="row"> <!-- row two starting -->
							<!-- <div class="col-md-2"></div>-->
							<div class="tables"><!-- tables starting -->
							<div class="table-responsive bs-example widget-shadow" style="display:inline" id="sourceTable">							
								<table id="dataMangamenttable" class="table table-bordered">
									 <thead>
									  	<tr>
									  		 <th>#</th>
									  		 <th>Name</th>
									  		 <th>&nbsp;</th>									  		 									  		
									  	</tr>
									  </thead>
									  <tbody id="sourceTableBody">
									  		<tr>
									  		 	 <th scope="row">1</th>
									  		 	 <td>Jeevan</td>
									  		 	 <td>Kumar</td>
									  		 	
									  		 </tr>
									  		 <tr>
									  		 	 <th scope="row">2</th>
									  		 	 <td>pattabhi</td>
									  		 	 <td>Alladi</td>
									  		 	
									  		 	 
									  		 </tr>
									  		  <tr>
									  		 	 <th scope="row">3</th>
									  		 	 <td>Prakash</td>
									  		 	 <td>Meruva</td>
									  		 	
									  		 	 
									  		 </tr>
									  		  <tr>
									  		 	 <th scope="row">4</th>
									  		 	 <td>Suma</td>
									  		 	 <td>Goli</td>
									  		 	
									  		 	 
									  		 </tr>
									  		  <tr>
									  		 	 <th scope="row">5</th>
									  		 	 <td>Raj</td>
									  		 	 <td>Kumar</td>
									  		 	
									  		 	 
									  		 </tr>
									  		  <tr>
									  		 	 <th scope="row">6</th>
									  		 	 <td>Pavani</td>
									  		 	 <td>Akumalla</td>
									  		 	
									  		 	 
									  		 </tr>
									  		  <tr>
									  		 	 <th scope="row">7</th>
									  		 	 <td>Nagesh</td>
									  		 	 <td>chow</td>
									  		 	
									  		 	 
									  		 </tr>
									  		  <tr>
									  		 	 <th scope="row">8</th>
									  		 	 <td>Ambarish</td>
									  		 	 <td>Amba</td>
									  		 	
									  		 	 
									  		 </tr>
									  		  <tr>
									  		 	 <th scope="row"></th>
									  		 	 <td>Karthik</td>
									  		 	 <td>M</td>									  		 										  		 	
									  		 </tr>
									  		  <tr>
									  		 	 <th scope="row">10</th>
									  		 	 <td>Siva</td>
									  		 	 <td>Raju</td>									  		 										  		 	
									  		 </tr>
									  		   <tr>
									  		 	 <th scope="row">11</th>
									  		 	 <td>Manju</td>
									  		 	 <td>sri</td>									  		 										  		 	
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
			
			<!-- including footer content  -->
			<%@include file="footer.jsp"%>
			<script src="${pageContext.request.contextPath}/js/datamanageajax.js"></script>
			<script src="${pageContext.request.contextPath}/js/datatable.js"></script>
			<script>
			$(document).ready(function() {
			    $('#dataMangamenttable').DataTable();
			} );
			</script>
	</body>
</html>