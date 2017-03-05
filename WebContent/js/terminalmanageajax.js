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
		
        $.ajax({url: "/lnganalysis/terminals", 
				type:"post",
				data:formData,			
				contentType:"application/x-www-form-urlencoded",
				processData:false,
				cache:false,
				success: dataResult});
    		});        	   	       
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
			deleteSource(this,$("#tddomainName"+trid).text());
	}
	
});
function deleteSource(event,domainName)
{

	var domainType=$("#sourceList option:selected").text();		
	var requestUrl="/lnganalysis/terminals?action=delete";
	if(!requestUrl=='')
	{
		 $.ajax({url: requestUrl, 
				type:"post",				
				data:{domainName:domainName,domainType:domainType},							
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
					var usersArray=JSON.parse(dataListResponse);						
						var htmlContent="";	
						var count=1;
						for(var i=0;i<usersArray.length;i++)
							{
								var val=usersArray[i];					
								
					//			alert(val.name+": "+ val.records+":"+ val.totalrecords);
								htmlContent=htmlContent+"<tr id='"+i+"'><th scope=\"row\">&nbsp;</th><td id='tddomainName"+i+"'><div class='col-md-6'>"+val.name+"</div></td>"+
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
