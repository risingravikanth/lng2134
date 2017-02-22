<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="./images/favicon.ico" type="image/x-icon">

    <title>LngAnalysis</title>

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/jquery-ui.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
  </head>
  <body style="background-color:#49247A"> <!--style="background-color:#49247A"-->

    <div class="container-fluid">
	<!-- <%@include file="header.jsp"%>-->
	<div class="row"><!-- This is second row -->
		<div class="col-md-4">
	
		</div>
		<div class="col-md-5">
			<!--<div class="progress progress-striped active">
				<div class="progress-bar progress-success">
				</div>
			</div>-->
			
				<form role="form" class="form-inline">
				<div class="form-group">
					 
					<label style="color:white">
						This is admin Page
					</label>
					
				</div>
				
				
				<button type="submit" class="btn btn-primary">
					Submit
				</button>
			</form>
			
			
		</div>
		<div class="col-md-3">
		</div>
		
	</div>
	<div class="row">
		<div class="col-md-12">
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
		</div>
		<div class="col-md-6">
			<table id="historyTable" class="table table-condensed table-bordered" style="display:none">
				<thead>
					<tr style="color:white">
						<th>
							#
						</th>
						<th>
							Tab
						</th>
						<th>
							Records
						</th>
						<th>
							Total Records
						</th>
					</tr>
				</thead>
				<tbody id="errorTableBody">
					<!--  Error content include dynamically in Scripting -->
				</tbody>
			</table>
		</div>
		<div class="col-md-3"></div>
	</div>
	"<div class='col-md-4 col-md-pull-2'><button id=\"\" type=\"button\" class=\"btn btn-default\">Edit</button></div>"+
												"<div class='col-md-4'><button id=\"\" type=\"button\" class=\"btn btn-default\">Delete</button></div>"+
												"<div class='col-md-4'><button id=\"\" type=\"button\" class=\"btn btn-default\">Delete</button></div></td></tr>";
</div>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
    <script src="${pageContext.request.contextPath}/js/ajax.js"></script>
  </body>
</html>