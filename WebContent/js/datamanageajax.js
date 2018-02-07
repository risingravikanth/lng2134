// Empty JS for your own code to be here

var addSourceflag=false;
var addSourceCount=0;
var pagination=0;
$(document).ready(function(){
		                      					
    $("#userSubmit").click(function()
    		{
    	$("#displayMsg").hide();
    	
    	var userform=document.getElementById("dataForm");    	

    	var dataformVal=$("#dataForm");
		var formData = dataformVal.serialize();
		
        $.ajax({url: "/lnganalysis/data", 
				type:"post",
				data:formData,			
				contentType:"application/x-www-form-urlencoded",
				processData:false,
				cache:false,
				success: dataResult});
    		});
    
    	$("#addSource").click(function(){    		    		
    		addSource()});
    	        	
});
$(document).on("click","button",function(){ 
	$("#displayMsg").hide();

	var trid = $(this).closest('tr').attr('id');
	
	if($(this).text()=='Delete')
	{		
		
//		if($("#sourceName"+trid).val()=='')
//		{
//			$(this).closest('tr').remove();
//			
//		}
//		else
			deleteSource(this,$("#tdsourceName"+trid).text());
	}
	else if($(this).text()=='Save')
	{
		if($("#sourceName"+trid).val()=='')
		{	
			$("#displayMsg").html(SOURCE_NAME_MANDATORY);
			$("#displayMsg").show();
		}	
		else
		saveSource(event,$("#sourceName"+trid).val(),trid);
	}	
});
function saveSource(event,sourceName,trid)
{	
	var sourceType=$("#sourceList option:selected").text();		
	var requestUrl="/lnganalysis/data?action=save";
	if(!requestUrl=='')
	{
		 $.ajax({url: requestUrl, 
				type:"post",				
				data:{sourceName:sourceName,sourceType:sourceType},							
				success:function(responseData)
				{
					recordSaved(event,responseData,trid);					
						
				}});
		 
	}
}
function recordSaved(event,responseData,rowId)
{
//		alert(responseData);
	    if(responseData==SUCCESS)
	    {	
	    	$("#displayMsg").html(RECORD_SAVED);
	    	$("#displayMsg").show();
	    	updateElementVal(rowId);
	    	$("#saveSourceButton"+rowId).text("Saved");
	    	$("#saveSourceButton"+rowId).prop('disabled',true);
	    	$("#adddeleteSourceButton"+rowId).show();
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
function updateElementVal(rowId)
{
	var innerHtml=$("#sourceName"+rowId).val();
	$("#sourceName"+rowId).empty();
	$("#tdsourceName"+rowId).html(innerHtml);
}
function deleteSource(event,sourceName)
{

	var sourceType=$("#sourceList option:selected").text();		
	var requestUrl="/lnganalysis/data?action=delete";
	if(!requestUrl=='')
	{
		 $.ajax({url: requestUrl, 
				type:"post",				
				data:{sourceName:sourceName,sourceType:sourceType},							
				success:function(responseData)
				{
					recordDeleted(event,responseData);					
						
				}});
		 
	}
}
function recordDeleted(event,responseData)
{
		if(responseData==SUCCESS)
		{
			if(!addSourceflag)
			{				
				var table=$('#sourceTablepagination').DataTable();
				var selectedRow=$(event).closest('tr');
				table.row(selectedRow).remove().draw(false);
			}
			else
			{
				$(event).closest('tr').remove();
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
function addSource()
{		
	$("#displayMsg").hide();
	
	var htmlString=$("#sourceTableBody").html();			
	if(!addSourceflag)
	{
		$('#sourceTablepagination').DataTable().destroy();
		$("#sourceTableBody").empty();		
		htmlString="";
		addSourceCount=0;
		
	}
	var enteredSourceName="";	
	
	if(addSourceCount>0)
	{
		enteredSourceName=$("#sourceName"+(addSourceCount-1)).val();		
	}	
		
	var sourceNameElement="<input style='width:500px' id='sourceName"+addSourceCount+"' type='text' name='sourceName"+addSourceCount+"'>";// value='"+$('#edituserName'+addUserCount).val()+"'>";
	
	addSourceflag=true;
	var htmlContent=htmlString+"<tr id='"+addSourceCount+"'><th scope=\"row\">&nbsp;</th><td id='tdsourceName"+addSourceCount+"'>"+sourceNameElement+"</td>"+
								"<td id='tdsaveButton"+addSourceCount+"'><div><button id='saveSourceButton"+addSourceCount+"' type=\"button\" class=\"btn btn-default btn-sm\">Save</button>"+
								"&nbsp;&nbsp;<button  id='adddeleteSourceButton"+addSourceCount+"' type=\"button\" class=\"btn btn-default btn-sm\">Delete</button></div></td></tr>";														
	$("#sourceTableBody").html(htmlContent);
	$("#adddeleteSourceButton"+addSourceCount).hide();
	if(addSourceCount>0)
	{
		$("#sourceName"+(addSourceCount-1)).attr('value',enteredSourceName);	
		
	}	
	addSourceCount++;
	$("#sourceTable").show();
}
function dataResult(dataListResponse)
{
		try{			
			$("#sourceTable").hide();
			$('#sourceTablepagination').DataTable().destroy();			
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
					var dataArray=JSON.parse(dataListResponse);						
						var htmlContent="";	
						var count=1;
						for(var i=0;i<dataArray.length;i++)
							{
								var val=dataArray[i];					
								
					//			alert(val.name+": "+ val.records+":"+ val.totalrecords);
								htmlContent=htmlContent+"<tr id='"+i+"'><th scope=\"row\">&nbsp;</th><td id='tdsourceName"+i+"'><div class='col-md-6'>"+val.name+"</div></td>"+
											"<td id='tddeleteButton"+i+"'><div class='col-md-6'><button id='searchdeleteSourceButton"+i+"' type=\"button\" class=\"btn btn-default btn-sm\">Delete</button></div></td></tr>"+
//											"<div class='col-md-2'><button id='deleteSourceButton"+i+"' type=\"button\" class=\"btn btn-default btn-sm col-md-pull-5\">Delete</button></div></td></tr>";																																
								count++;
							}
						  
						   addSourceflag=false;
						   
						   $("#sourceTableBody").html(htmlContent);
						   $("#sourceTable").show();
						   $('#sourceTablepagination').DataTable({
							   "order": [[ 1, "asc" ]],
							   "aoColumnDefs": [ { "bSortable": false, "aTargets": [ 0,2] } ],
							  
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
