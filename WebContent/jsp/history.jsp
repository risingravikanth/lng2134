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
		<script src="${pageContext.request.contextPath}/js/constants.js"></script>
		<link href="${pageContext.request.contextPath}/css/jquery-ui.css" rel="stylesheet">
		<!-- Bootstrap Core CSS -->
		<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel='stylesheet' type='text/css' />
			<!-- Custom CSS -->
		<link href="${pageContext.request.contextPath}/css/datatable.css" rel='stylesheet' type='text/css' />
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
										<h4>&nbsp;</h4>
									</div>
									<div class="col-sm-offset-3">
										<div class="form-body" data-example-id="simple-form-inline">
											<form class="form-inline" id="historyForm"  method="post"> 
												<div class="form-group">
													 <label for="exampleInputName2">Start Date</label>
													 <input type="text" id="startDate" name="startDate" class="form-control" id="exampleInputName2" placeholder="Start Date">
											    </div>
											    <div class="form-group">
											    	 <label for="exampleInputEmail2">End Date</label>
											    	 <input type="text" id="endDate" name="endDate" class="form-control" id="exampleInputEmail2" placeholder="End Date">
											    </div> 
											    <button id="historySubmit" type="button" class="btn btn-default">Submit</button>
											    <div>&nbsp;</div>
											    <div class="form-group col-md-12 col-md-offset-2">
													<label style="display:none" id="displayMsg"></label>													
											    </div>
											    
										     </form> 
										</div>
									</div>
						
								</div>
						</div><!-- row one ending -->
						<div class="row"> <!-- row two starting -->
							<!-- <div class="col-md-2"></div>-->
							
							<div class="tables"><!-- tables starting -->							
							<div class="table-responsive bs-example widget-shadow" style="display:none" id="historyTable">							
								<table  id="historyTablepagination" class="table">
									<thead>
										<tr>
											<th>S.NO</th>
											<th>User</th>
											<th>CREATED_DATE</th>
											<th>EXPLORATION</th>
											<th>REFINERIES</th>
											<th>CRUDEOIL</th>
											<th>NATURALGAS</th>
											<th>STORAGE</th>
											<th>LNG</th>
											<th>PIPELINE</th>
											<th>COMPANY_OILGAS</th>
											<th>SMALLSCALELNG</th>																															
										</tr>
									</thead>
									<tbody id="historyTableBody">
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
			 <script>
    			$("#startDate").datepicker({
    			      changeMonth: true,
    			      changeYear: true
    			    });
	  			$("#endDate").datepicker({
	  		      changeMonth: true,
	  		      changeYear: true
	  		    });
	  			
	  			 $("#startDate").focus(function(){
	  		    	$("#displayMsg").hide();
	  				  				
	  		    });
	  			 
	  			 $("#endDate").focus(function(){
	  				$("#displayMsg").hide();
	  				
	  		    });
	  			
    		</script>
    		<script src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script>
			<script src="${pageContext.request.contextPath}/js/dataTables.bootstrap.min.js"></script>
	</body>
</html>