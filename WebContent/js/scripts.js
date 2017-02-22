// Empty JS for your own code to be here

function openFileBrowseWindow()
{
			$("#displayMsg").hide();		
			$("#errorTable").hide();
			$("#uploadfile").click();
			var textValue=document.getElementById("fileId");
					
			/*  This is for just back up purpose
					
					var filePath = document.getElementById("datafile").value;
			var fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
			
			 $(":file").change(function(){
			 alert($(":file").val())
			 textValue.value=$(":file").val()});*/
			
			 if( navigator.userAgent.toLowerCase().indexOf('chrome') > -1 ){
					// Do something in Chrome
					//alert('I am in chrome browser');				 	
					 $(":file").change(function(){
							var filePath=$(":file").val();
							var fileName=filePath.substring(filePath.lastIndexOf("\\")+1);
						textValue.value=fileName});
				}
			else{
				var fileName=document.getElementById("uploadfile").value;
				textValue.value=fileName;
			}		
			
}
function renderfileUploadResult(responseData)
{
	$("#loadingimage").hide();
	$("#errorTable").hide();
	if(responseData==SUCCESS)
	{
		 $("#displayMsg").html(UPLOAD_SUCCESS);
		 $("#displayMsg").show();
	}
	else if(responseData==APP_ERROR)
	{
		$("#displayMsg").html(APPLICATION_ERROR);
		$("#displayMsg").show();
	}
	else if(responseData==SESSION_EXPIRED)
	{
		$("#displayMsg").html(SESSION_EXPIRED_MSG);
		$("#displayMsg").show();
	}
	else if(responseData==INVALID_DATA_SHEET)
	{
		$("#displayMsg").html(INVALID_DATA_SHEET_MSG);
		$("#displayMsg").show();
	}
	else if(responseData==DUPLICATE_ENTRY)
	{
		$("#displayMsg").html(DUPLICATE_ENTRY_MSG);
		$("#displayMsg").show();
	}
	else
	{
				try{
		//			alert(responseData);
			var jsonResObj=JSON.parse(responseData);
			
			var jsonResKeys=Object.keys(jsonResObj);
			var key=jsonResKeys[0];
			var jsonResObjValue=jsonResObj[key];
			
			
			var jsonResObjValArray=jsonResObjValue;//JSON.parse(responseData);
		//	var array=jsonObjetoArray();
			var htmlContent="";
//			alert(jsonObj[0]);
			var count=1;
			var styleVal="";
			for(var i=0;i<jsonResObjValArray.length;i++)
				{
					var val=jsonResObjValArray[i];					
					if(val.name=="EXPLORATION")
					{
						styleVal='<span class="label label-success">';
					}
					else if(val.name=="REFINERIES")
					{
						styleVal='<span class="label label-danger">';
					}
					else if(val.name=="LNG")
					{
						styleVal='<span class="label label-info">';
					}
					else if(val.name=="STORAGE")
					{
						styleVal='<span class="label label-warning">';
					}
					else if(val.name=="CRUDEOIL")
					{
						styleVal='<span class="label label-primary">';
					}
					else if(val.name=="NATURALGAS")
					{
						styleVal='<span class="label label-default">';
					}
					else if(val.name=="PIPELINES")
					{
						styleVal='<span class="label label-info">';
					}
					
		//			alert(val.name+": "+ val.records+":"+ val.totalrecords);
					htmlContent=htmlContent+"<tr><th scope=\"row\">"+count+"</th><td>"+styleVal+val.name+"</td><td>"+ val.records+"</td><td>"+val.totalrecords+"</td><td>"+val.description+"</td></tr>";
					count++;
				}
			   if(key==INCORRECT_DATA)
			   {
				   $("#displayMsg").html(INCORRECT_DATA_MSG);
				   $("#displayMsg").show();
			   } 
			  	
			   else
			   {
				   $("#displayMsg").html(DATA_VALIDATION_FAIL_MSG);
				   $("#displayMsg").show();
			   }	   
				
			   
			   $("#errorTableBody").html(htmlContent);
			   $("#errorTable").show();
		//	alert(jsonObj);
			}
			catch(JSONException)
			{
				alert(responseData);
			}
	}
	//document.getElementById("textId").value="";

}
function historyResult(historyResponse)
{
//	alert(historyResponse);
	try{
		$("#historyTable").hide();
		$('#historyTablepagination').DataTable().destroy();
		 if(historyResponse==NO_DATA)
		 {
			 $("#displayMsg").html(NO_RECORDS_PERIOD);
			 $("#displayMsg").show();
		 }
		 else if(historyResponse==APP_ERROR)
		 {
			 $("#displayMsg").html(APPLICATION_ERROR);
			 $("#displayMsg").show();
		 }
		 else if(historyResponse==SESSION_EXPIRED)
		 {
				$("#displayMsg").html(SESSION_EXPIRED_MSG);
				$("#displayMsg").show();
		 }
		 else
		 {
				var historyArray=JSON.parse(historyResponse);
				//	var array=jsonObjetoArray();
					var htmlContent="";
//					alert(jsonObj[0]);
					var count=1;
					for(var i=0;i<historyArray.length;i++)
						{
							var val=historyArray[i];					
							
				//			alert(val.name+": "+ val.records+":"+ val.totalrecords);
							htmlContent=htmlContent+"<tr><th>"+count+"</th><td>"+val.email+"</td><td>"+ val.createdDate+"</td><td>"+val.exploration+"</td><td>"+val.refinery+"</td><td>"+val.crudeoil+"</td><td>"+val.naturalGas+"</td><td>"+val.storage+"</td><td>"+val.lng+"</td><td>"+val.pipeline+"</td></tr>";
							count++;
						}
					  
					   
					   $("#historyTableBody").html(htmlContent);
					   $("#historyTable").show();
					   $('#historyTablepagination').DataTable({
						   "aoColumnDefs": [ { "bSortable": false, "aTargets": [2,3,4,5,6,7,8,9] } ]
					   });
		 }
		
			}
			catch(JSONException)
			{
				alert(historyResponse);
			}
}
function userAuditResult(userAuditResponse)
{
//	alert(historyResponse);
	try{
		$("#userAuditTable").hide();
		$('#userAuditTablepagination').DataTable().destroy();
		 if(userAuditResponse==NO_DATA)
		 {
			 $("#displayMsg").html(NO_RECORDS_PERIOD);
			 $("#displayMsg").show();
		 }
		 else if(userAuditResponse==APP_ERROR)
		 {
			 $("#displayMsg").html(APPLICATION_ERROR);
			 $("#displayMsg").show();
		 }
		 else if(userAuditResponse==SESSION_EXPIRED)
			{
				$("#displayMsg").html(SESSION_EXPIRED_MSG);
				$("#displayMsg").show();
			}
		 else
		 {
				var userAuditArray=JSON.parse(userAuditResponse);
				//	var array=jsonObjetoArray();
					var htmlContent="";
//					alert(jsonObj[0]);
					var count=1;
					for(var i=0;i<userAuditArray.length;i++)
						{
							var val=userAuditArray[i];					
							
				//			alert(val.name+": "+ val.records+":"+ val.totalrecords);
							htmlContent=htmlContent+"<tr><th>"+count+"</th><td>"+val.user+"</td><td>"+ val.createdDate+"</td><td>"+val.action+"</td><td>"+val.comments+"</td></tr>";
							count++;
						}
					  
					   
					   $("#userAuditTableBody").html(htmlContent);
					   $("#userAuditTable").show();
					   $('#userAuditTablepagination').DataTable({
						   "aoColumnDefs": [ { "bSortable": false, "aTargets": [2,3,4] } ]
					   });
		 }
		
			}
			catch(JSONException)
			{
				alert(userAuditResponse);
			}
}
function getTabCount(countsResponse)
{
	var tabCountArray=JSON.parse(countsResponse);	
		for(var i=0;i<tabCountArray.length;i++)
			{
				var val=tabCountArray[i];					
				
//				alert(val.EXPLORATION+": "+ val.REFINERIES+":"+ val.CRUDEOIL);
				
				$("#explorationCount").html(val.explorationCount);
				$("#refineriesCount").html(val.refineryCount);
				$("#crudeOilCount").html(val.crudeoilCount);
				$("#naturalGasCount").html(val.naturalGasCount);
				$("#lngCount").html(val.lngCount);
				$("#storageCount").html(val.storageCount);
				$("#pipeLineCount").html(val.pipelineCount);
			}		  		 		  
}
// Below is the Ram code
function loginFormValidation() 
{
	var password = document.forms["loginform"]["password"].value;

	var ok = false;
	if (password == null || password == "") {
		document.getElementById('errorpwd').innerText="Please enter the password";
		document.getElementById("password").style.borderColor = "#E34234";
		return false;
	} else {
		return true;	
	}
}

function passwordChangeValidation() {
	var newPassword = document.getElementById("newPassword").value;
	var confirmPassword = document.getElementById("confirmPassword").value;
	var currentPassword = document.getElementById("currentPassword").value;
	var ok = false;
	if (currentPassword == null || currentPassword == "") {
		document.getElementById('errorcurrentPassword').innerText="Please enter the current password";
		document.getElementById("currentPassword").style.borderColor = "#E34234";
		return false;
	}else if (newPassword == null || newPassword == "") {
		document.getElementById('errornewPassword').innerText="Please enter the  new password";
		document.getElementById("newPassword").style.borderColor = "#E34234";
		return false;
	
	}else if (confirmPassword == null
			|| confirmPassword == "") {
		document.getElementById('errorconfirmPassword').innerText="Please enter the cofirm password";
		document.getElementById("confirmPassword").style.borderColor = "#E34234";
		return false;
	} else if ((newPassword != null || newPassword != "")
			&& ((confirmPassword != null || confirmPassword != ""))
			&& (newPassword != confirmPassword)) {
		document.getElementById('errormismatch').innerText="Passwords are not match...please try again";
		document.getElementById("newPassword").value = "";
		document.getElementById("confirmPassword").value = "";
		document.getElementById("newPassword").style.borderColor = "#E34234";
		document.getElementById("confirmPassword").style.borderColor = "#E34234";
		return false
	} else {
		return true;
	}
}

function emailValidation() {
	var email = document.getElementById("email").value;
	var mobile = document.getElementById("mobile").value;
	var atpos = email.indexOf("@");
    var dotpos = email.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=email.length) {
        document.getElementById('errorEmail').innerText="Please enter the valid Email";
        document.getElementById("email").style.borderColor = "#E34234";
        return false;
    }
    else if(isNaN(mobile))
    {
       document.getElementById('errorMobile').innerText="Please enter the Numaric Values";
       document.getElementById("mobile").style.borderColor = "#E34234";
       return false; 
    }
    else if (mobile.length <= 9)
    {
         document.getElementById('errorMobileLength').innerText="Mobile number length less";
         document.getElementById("mobile").style.borderColor = "#E34234";
         return false;
    }else{
    	return true;
    }
}



    
    
    
