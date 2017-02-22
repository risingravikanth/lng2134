// Empty JS for your own code to be here


$(document).ready(function(){
	
	//		$("#errorTable").hide();
	//Ajax call for file upload
    $("#fileuploadsubmit").click(function(){
		//$.post("fileupload");
//		alert($('input[type=file]')[0].files[0].val());
    	
//    	alert($("#updateRecords").is(":checked"));
    	var action="";
    	if($("#updateRecords").is(":checked"))
    		action="update";
    	else
    		action="insert";
    	var form=document.getElementById("formId");
    	
    	var formVal=$("#formId")[0];
		var formData = new FormData(formVal);
		
//    	alert($("#fileId").val().split("\\").pop());
    	var fileName=$("#fileId").val().split("\\").pop();
//    	alert(fileName);
    	var dotIndex=fileName.indexOf(".");
    	var fileTypeName=fileName.substring(dotIndex+1,fileName.length);
    	
		
		/*var x=$("#formId").serializeArray();
		$.each(x,function(i,field)
		{
			formData.append(field.name+":"+field.value+" ");
		});*/
      //  formData.append('file', document.getElementById("inputfile").files[0]);
//		alert(formData);
    	if(fileName==null || fileName=="")
    	{
    		$("#displayMsg").html(UPLOAD_FILE_ERROR);
    		$("#displayMsg").show();
    	}
    	else
    	{
    		if(fileTypeName=="xls" || fileTypeName=="xlsx")
        	{
        		$("#loadingimage").show();
        		  $.ajax({url: "/lnganalysis/fileupload?action="+action, 
      				type:"post",
      				data:formData,
      				mimeType:"multipart/form-data",
      				contentType:false,
      				processData:false,
      				cache:false,
      				success: renderfileUploadResult});
        	}
        	else
        	{
        		$("#displayMsg").html(INVALID_FILE);
        		$("#displayMsg").show();
        	}	
    	}
    	
    		    	
});
                  
  
    
$("#historySubmit").click(function()
    {
    	if($("#startDate").val()=='')
    	{
    		$("#displayMsg").html("Start Date is Required");
    		$("#displayMsg").show();
    	}				
    	else if($("#endDate").val()=='')
    	{
    		$("#displayMsg").html("End Date is Required");
    		$("#displayMsg").show();
    	}					
    	else
    	{
    		var loginform=document.getElementById("historyForm");        	
        	var loginformVal=$("#historyForm");
    		var loginformData = loginformVal.serialize();
    		
            $.ajax({url: "/lnganalysis/history", 
    				type:"post",
    				data:loginformData,			
    				contentType:"application/x-www-form-urlencoded",
    				processData:false,
    				cache:false,
    				success: historyResult});
        		
    	}
});
  
    
$("#userAuditSubmit").click(function()
    	    {
    	    	if($("#startDate").val()=='')
    	    	{
    	    		$("#displayMsg").html(START_DATE);
    	    		$("#displayMsg").show();
    	    	}	    					
    	    	else if($("#endDate").val()=='')
    	    	{
    	    		$("#displayMsg").html(END_DATE);
    	    		$("#displayMsg").show();
    	    	}	
    					
    	    	else
    	    	{
    	    		var loginform=document.getElementById("userAuditForm");        	
    	        	var loginformVal=$("#userAuditForm");
    	    		var loginformData = loginformVal.serialize();
    	    		
    	            $.ajax({url: "/lnganalysis/useraudit", 
    	    				type:"post",
    	    				data:loginformData,			
    	    				contentType:"application/x-www-form-urlencoded",
    	    				processData:false,
    	    				cache:false,
    	    				success: userAuditResult});
    	        		
    	    	}
});
    
  	
    
$("#forgotpwdsubmit").click(function(){
    	
    	if($("#forgotpwdemail").val()=='')
			$("#emailforpwdreset").show();
		else
		{
			var email=$("#forgotpwdemail").val();
			 $.ajax({url: "/lnganalysis/forgotpwd", 
					type:"post",    					
					data:{emailId:email},			    					
					success:function(responseData)
					{
						if(responseData==SUCCESS)
						{
							$("#forgotpwdMsg").html(CHECK_WITH_ADMIN);
							$("#forgotpwdMsg").show();
						}								
						else if(responseData==FAIL)
						{
							$("#forgotpwdMsg").html(MAIL_SEND_FAIL);
							$("#forgotpwdMsg").show();
						}								
						else if(responseData==APP_ERROR)
						{
							$("#forgotpwdMsg").html(APPLICATION_ERROR);
							$("#forgotpwdMsg").show();
						}
    					$("#myModal").modal("hide");
							
					}});
		}
    });

$("#tabCount").click(function(e){
//	alert("clicks refresh");
  e.stopPropagation();
  $.ajax({url: "/lnganalysis/getcount", 
		type:"post",    										    				
		success:getTabCount		
							
		});
});
    	
}); // This the closing of document.onReady()
