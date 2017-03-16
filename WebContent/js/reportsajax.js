// Empty JS for your own code to be here

var addReportflag=false;
var addReportCount=0;
var reportTitle="reportTitle";
var sector="sector";
var region="region";
var country="country";

$(document).ready(function(){
		                      					
    $("#userSubmit").click(function()
    		{
    	$("#displayMsg").hide();
    	
    	var userform=document.getElementById("dataForm");    	

    	var dataformVal=$("#dataForm");
		var formData = dataformVal.serialize();
		
        $.ajax({url: "/lnganalysis/reports", 
				type:"post",
				data:formData,			
				contentType:"application/x-www-form-urlencoded",
				processData:false,
				cache:false,
				success: dataResult});
    		});
    
    	$("#addSource").click(function(){    		    		
    		addReport()});
    	        	
});
$(document).on("click","button",function(){ 
	$("#displayMsg").hide();

	var trid = $(this).closest('tr').attr('id');
	
	if($(this).text()=='Delete')
	{		
		
		deleteReport(this,$("#reportTitle"+trid).text());
	}
	else if($(this).text()=='Save')
	{
		if($("#reportTitle"+trid).val()=='')
		{	
			$("#displayMsg").html(REPORT_NAME_MANDATORY);
			$("#displayMsg").show();
		}	
		else
		saveReport(trid);
	}	
});
function saveReport(rowId)
{	
	var sendData=createReportJsonObject(rowId);
	var resultRes;
	var requestUrl;
	requestUrl="/lnganalysis/reports?action=save";
	
	//JSON.stringify(sendData)
	if(!requestUrl=='')
	{
		 $.ajax({url: requestUrl, 
				type:"post",
				
				data:{reportData:sendData},			
				
				success:function(responseData)
				{
					recordSaved(responseData,rowId);
				}});
		 
	}
}
function createReportJsonObject(rowId)
{
	var newReportTitle=$("#"+reportTitle+rowId).val();
	var newSector=$("#"+sector+rowId).val();
	var newRegion=$("#"+region+rowId).val();
	var newCountry=$("#"+country+rowId).val();	
		
	var	jsonString='{"reportTitle":"'+newReportTitle+'","sector":"'+newSector+'","region":"'+newRegion+'","country":"'+newCountry+'"}';//,"password":"'+newPassword+'"}';
	
	return jsonString;
	
}
function recordSaved(responseData,rowId)
{
//		alert(responseData);
	    if(responseData==SUCCESS)
	    {	
	    	$("#displayMsg").html(RECORD_SAVED);
	    	$("#displayMsg").show();
	    	updateElementVal(reportTitle,rowId);
	    	updateElementVal(sector,rowId);
	    	updateElementVal(region,rowId);
	    	updateElementVal(country,rowId);
	    	$("#addReportSaveButton"+rowId).text("Saved");
	    	$("#addReportSaveButton"+rowId).prop('disabled',true);
	    	$("#addReportDeleteButton"+rowId).show();
	    }	
	    else if(responseData==FAIL)
	    {
	    	$("#displayMsg").html(RECORD_NOT_SAVED);
	    	$("#displayMsg").show();
	    }
	    else if(responseData==APP_ERROR)
	    {
	    	$("#displayMsg").html(APPLICATION_ERROR);
	    	$("#displayMsg").show();
	    }
	    else if(responseData==RECORD_ALREADY_EXISTS)
	    {
	    	$("#displayMsg").html(RECORD_ALREADY_EXISTS);
	    	$("#displayMsg").show();
	    }
	    	
	    	
}
function updateElementVal(inputName,rowId)
{
	var innerHtml=$("#"+inputName+rowId).val();
	$("#td"+inputName+rowId).empty();
	$("#td"+inputName+rowId).html(innerHtml);	
	return innerHtml;
}
function deleteReport(currElem,reportTitle)
{
		
	var requestUrl="/lnganalysis/reports?action=delete";
	if(!requestUrl=='')
	{
		 $.ajax({url: requestUrl, 
				type:"post",				
				data:{reportTitle:reportTitle},							
				success:function(responseData)
				{
					recordDeleted(currElem,responseData);					
						
				}});
		 
	}
}
function recordDeleted(currElem,responseData)
{
		if(responseData==SUCCESS)
		{
			if(!addSourceflag)
			{				
				var table=$('#reportTablepagination').DataTable();
				var selectedRow=$(currElem).closest('tr');
				table.row(selectedRow).remove().draw(false);
			}
			else
			{
				$(currElem).closest('tr').remove();
			}			
			$("#displayMsg").html(RECORD_DELETED);
			$("#displayMsg").show();						
			
		}
		else if(responseData==FAIL)
		{	
			$("#displayMsg").html(RECORD_NOT_DELETED);
			$("#displayMsg").show();
		}
		else if(responseData==APP_ERROR)
		{	
			$("#displayMsg").html(APPLICATION_ERROR);
			$("#displayMsg").show();
		}
		
}
function addReport()
{
	$("#reportTable").hide();
	$('#reportTablepagination').DataTable().destroy();
	var htmlString=$("#reportTableBody").html();	
	
	if(!addReportflag)
	{
		$("#reportTableBody").empty();
		htmlString="";
		addReportCount=0;
	}
	
	var enteredReportTitle;
	var enteredSector;
	var enteredRegion;
	var enteredCountry;
	
	
	if(addReportCount>0)
	{
		
		enteredReportTile=$("#reportTitle"+(addReportCount-1)).val();
		enteredSector=$("#sector"+(addReportCount-1)).val();
		enteredLastName=$("#region"+(addReportCount-1)).val();
		enteredMobile=$("#country"+(addReportCount-1)).val();		
		
	}	
		
	var reportTitleElement="<input style='width:350px' id='reportTitle"+addReportCount+"' type='text' name='reportTitle"+addReportCount+"'>";
	var sectorElement="<input id='sector"+addReportCount+"' type='text' name='sector"+addReportCount+"'>";
	var regionElement="<input id='region"+addReportCount+"'type='text' name='region"+addReportCount+"'>";
	var countryElement="<input id='country"+addReportCount+"' type='text' name='country"+addReportCount+"'>";	
	
	
	addReportflag=true;
	var htmlContent=htmlString+"<tr id='"+addReportCount+"'><th scope=\"row\">&nbsp;</th><td id='tdreportTitle"+addReportCount+"'>"+reportTitleElement+"</td><td id='tdsector"+addReportCount+"'>"+sectorElement+"</td><td id='tdregion"+addReportCount+"'>"+regionElement+"</td><td id='tdcountry"+addReportCount+"'>"+countryElement+"</td>"+
						"<td id='tdsaveButton"+addReportCount+"'><div class='col-md-3'><button id='addReportSaveButton"+addReportCount+"' type=\"button\" class=\"btn btn-default btn-sm\">Save</button></div>"+
						"<div class='col-md-2'><button  id='addReportDeleteButton"+addReportCount+"' type=\"button\" class=\"btn btn-default btn-sm\">Delete</button></div></td></tr>";	
							
	
	$("#reportTableBody").html(htmlContent);
	$("#addReportDeleteButton"+addReportCount).hide();
	if(addReportCount>0)
	{
		
		$("#reportTitle"+(addReportCount-1)).attr('value',enteredReportTitle);		
		$("#sector"+(addReportCount-1)).attr('value',enteredSector);
		$("#region"+(addReportCount-1)).attr('value',enteredRegion);
		$("#country"+(addReportCount-1)).attr('value',enteredCountry);		
				
	}	
	addReportCount++;
	$("#reportTable").show();
}
function dataResult(dataListResponse)
{
		try{			
			$("#reportTable").hide();
			$('#reportTablepagination').DataTable().destroy();			
			 if(dataListResponse==NO_DATA)
			 {
				 $("#displayMsg").html(NO_RECORDS_SOURCE);
				 $("#displayMsg").show();				 
			 }
			 else if(dataListResponse==SESSION_EXPIRED)
			 {
					$("#displayMsg").html(SESSION_EXPIRED_MSG);
					$("#displayMsg").show();
			 }
			 else
			 {
					var reportsArray=JSON.parse(dataListResponse);						
						var htmlContent="";	
						var count=1;
						for(var i=0;i<reportsArray.length;i++)
							{
								var val=reportsArray[i];					
								
					//			alert(val.name+": "+ val.records+":"+ val.totalrecords);
								htmlContent=htmlContent+"<tr id='"+i+"'><th scope=\"row\">&nbsp;</th><td id='reportTitle"+i+"'>"+val.title+"</td><td id='sector"+i+"'>"+val.sector+"</td><td id='region"+i+"'>"+val.region+"</td><td id='country"+i+"'>"+val.country+"</td>"+
											"<td id='tddeleteButton"+i+"'><div class='col-md-6'><button id='searchdeleteSourceButton"+i+"' type=\"button\" class=\"btn btn-default btn-sm\">Delete</button></div></td></tr>"+
//											"<div class='col-md-2'><button id='deleteSourceButton"+i+"' type=\"button\" class=\"btn btn-default btn-sm col-md-pull-5\">Delete</button></div></td></tr>";																																
								count++;
							}
						  
						   addSourceflag=false;
						   
						   $("#reportTableBody").html(htmlContent);
						   $("#reportTable").show();
						   $('#reportTablepagination').DataTable({
							   "order": [[ 1, "asc" ]],
							   "aoColumnDefs": [ { "bSortable": false, "aTargets": [0,5] } ],
							  
						   });
						   						 						
			 	}
			 	
			}
			catch(JSONException)
			{
				if(dataListResponse==APP_ERROR)
			    {
			    	$("#displayMsg").html(APPLICATION_ERROR);
			    	$("#displayMsg").show();
			    }
			}
}
