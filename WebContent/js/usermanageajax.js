// Empty JS for your own code to be here

var addUserflag=false;
var addUserCount=0;
var userName="userName";
var firstName="firstName";
var lastName="lastName";
var mobile="mobile";
var email="email";
//var password="password";
var address="address";
var admin="admin";
var role="role";
var image="image";

var update="Update";
var save="Save";
var edit="Edit";
var deleteVar="Delete";

$(document).ready(function(){
		                      
    
    $("#userSubmit").click(function()
    {
    	 $("#displayMsg").hide();
    	 $("#userTable").hide();
    	
    	var userform=document.getElementById("userForm");
    	

    	var userformVal=$("#userForm");
		var userformData = userformVal.serialize();
		
//		alert(loginformData);
		
//		var userName=$("#userName").val();
//		var pwd=$("#password").val();
//		loginformData.append("userName",userName);
//		loginformData.append("password",pwd);
//		
//		var loginFormData=loginformVal.serialize();
//		{userName:userName,password:pwd}
//		form.serialize();
//		alert(loginformData);
        $.ajax({url: "/lnganalysis/users", 
				type:"post",
				data:userformData,			
				contentType:"application/x-www-form-urlencoded",
				processData:false,
				cache:false,
				success: userResult});
    		});
    
    	$("#addUser").click(function(){    		    		
    		addUser()});
    	        	
});
//On click on edit user
$(document).on("click","button",function(){ 
	
	var trid = $(this).closest('tr').attr('id');
	$("#displayMsg").hide();
//    $("#passwordmandatory").hide();
//    $("#nouserrecords").hide();
//	 $("#emailmandatory").hide();
//	 $("#notupdated").hide();
//	 $("#updated").hide();
//	 $("#notsaved").hide();
//	 $("#saved").hide();
//	 $("#notdeleted").hide();
//	 $("#deleted").hide();
//	 $("#usernotexists").hide();
    if($(this).text()==edit)
    {
    
    	var action=$(this).text();
//    	 var trid = $(this).closest('tr').attr('id');
//         alert('got tr id:'+trid);
    	$(this).text(update);
    	   	
//    	alert($("#userName"+trid).text());
//       	rowEdit(userName,trid,action);
    	rowEdit(email,trid,action);
//    	rowEdit(password,trid,action);
    	rowEdit(firstName,trid,action);
    	rowEdit(lastName,trid,action);
    	rowEdit(mobile,trid,action);    	
    	rowEdit(address,trid,action);
    	rowEdit(admin,trid,action);
    	rowEdit(role,trid,action);
//    	rowEdit(image,trid,action);        	
    	
    }
    else if($(this).text()==update || $(this).text()==save)
    {
    	var action=$(this).text();
    	  
    	if($("#edit"+email+trid).val()=='') 
    	{
    		$("#displayMsg").html(EMAIL_REQUIRED);
    		$("#displayMsg").show();
    	}    	
    	else
    	{
    		
//    		 $("#nouserrecords").hide();
//        	 $("#emailmandatory").hide();
//        	 $("#notupdated").hide();
//        	 $("#updated").hide();
//        	 $("#notsaved").hide();
//        	 $("#saved").hide();
//        	 $("#notdeleted").hide();
//        	 $("#deleted").hide();
//        	 $("#usernotexists").hide();
    		var emailValidate=validateEmail($("#edit"+email+trid).val());
    		var mobileValidate=validateMobile($("#edit"+mobile+trid).val());
    		if(!emailValidate && !mobileValidate)
    		createJsonRequest(action,trid,this);
//    		$(this).text("Edit");
//    		if(recordUpdateOrSave=='updated' || recordUpdateOrSave=='saved')
//    		{
//    			$(this).text("Edit");
//    			if(recordUpdateOrSave=='updated')
//    				$("#updated").show();    			
//    			else if(recordUpdateOrSave=='saved')
//    				$("#saved").show();
//    			updateElementVal(userName,trid);
//            	updateElementVal(firstName,trid);
//            	updateElementVal(lastName,trid);
//            	updateElementVal(mobile,trid);
//            	updateElementVal(email,trid);
//            	updateElementVal(address,trid);
//            	updateElementVal(admin,trid);
//            	updateElementVal(role,trid);
//            	updateElementVal(image,trid);
//    		}
//    		else
//    		{
//    			if(action=='Update')
//    				$("#notupdated").show();
//    			else
//    				$("#notsaved").show();
//    		}
        	
    	}    	    	
    	
//    	 var userNameText=inputElements("edituserName",trid);//"<input type='text' name='userName' value='"+$("#userName"+trid).text()+"'>" ;
//    	 $("#userName"+trid).empty();
//    	 $("#userName"+trid).html(userNameText);
    }else if($(this).text()==deleteVar)
	{
    	 
//    	 $("#nouserrecords").hide();
//    	 $("#emailmandatory").hide();
//    	 $("#notupdated").hide();
//    	 $("#updated").hide();
//    	 $("#notsaved").hide();
//    	 $("#saved").hide();
//    	 $("#notdeleted").hide();
//    	 $("#deleted").hide();
//    	 $("#usernotexists").hide();
    	 
    	if($("#edit"+email+trid).val()=='')
    	{
    		$(this).closest('tr').remove();
    		
    	}
    	else
    	{
    		if($("#email"+trid).text()!='')
        	{
//        		alert($("#email"+trid).text());
        		deleteUser(this,$("#email"+trid).text());
        	}
        	else if($("#editemail"+trid).val()!='')
        	{
//        		alert($("#editemail"+trid).val());
        		deleteUser(this,$("#editemail"+trid).val());
        	}
    	}
    	    	
//    	 $(this).closest('tr').remove();
    	 
	}
    
});
function validateEmail(emailId)
{
		
	var atpos = emailId.indexOf("@");
    var dotpos = emailId.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=emailId.length) {
//        document.getElementById('errorEmail').innerText="Please enter the valid Email";
//        document.getElementById("email").style.borderColor = "#E34234";
        $("#displayMsg").html("Please Enter a Valid Email");
        $("#displayMsg").show();
        return true;
    }
}
function validateMobile(mobile)
{
	
	if(isNaN(mobile))
    {
		 $("#displayMsg").html("Please Enter only Numerics");
	     $("#displayMsg").show();
       return true; 
    }
    else if (mobile.length <= 9 || mobile.length >10)
    {
    	 $("#displayMsg").html("Please Enter valid Mobile Number");
	     $("#displayMsg").show();         
         return true;
    }
}
function deleteUser(event,email)
{
//	alert(email);
	var requestUrl="/lnganalysis/users?action=delete";
	if(!requestUrl=='')
	{
		 $.ajax({url: requestUrl, 
				type:"post",
				
				data:{userData:email},			
				
				success:function(responseData)
				{
//					alert(responseData);
					if(responseData==SUCCESS)
					{						
						 $(event).closest('tr').remove();
						 $("#displayMsg").html(RECORD_DELETED)
						 $("#displayMsg").show();
					}
					else if(responseData==USER_NOT_EXISTS)
					{
						$("#displayMsg").html(USER_NOT_EXISTS_MSG);
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
					else if(responseData==SESSION_EXPIRED)
					{
							$("#displayMsg").html(SESSION_EXPIRED_MSG);
							$("#displayMsg").show();
					}	
						
				}});
		 
	}
}
function createJsonRequest(action,rowId,event)
{
	
	
	var sendData=createJsonObject(action,rowId);
	var resultRes;
	var requestUrl;
	if(action==update)
	{
		requestUrl="/lnganalysis/users?action=update";
	}
	else if(action==save)
	{
		requestUrl="/lnganalysis/users?action=save";
	}
	//JSON.stringify(sendData)
	if(!requestUrl=='')
	{
		 $.ajax({url: requestUrl, 
				type:"post",
				
				data:{userData:sendData},			
				
				success:function(responseData)
				{
					recordUpdatedOrSaved(responseData,rowId,event,action);
				}});
		 
	}
	
//	return resultRes;
}
function recordUpdatedOrSaved(responseData,rowId,event,action)
{
//	alert(responseData+":"+rowId);
	
		if(responseData==SUCCESS)
		{
			$(event).text(edit);
			if(action==update)
			{		
				$("#displayMsg").html(RECORD_UPDATED);
				$("#displayMsg").show();    						
			}
			else if(action==save)
			{
				$("#displayMsg").html(RECORD_SAVED);
				$("#displayMsg").show();
			}	
				
	//			updateElementVal(userName,rowId);
				updateElementVal(email,rowId);
	//			updateElementVal(password,rowId);
	        	updateElementVal(firstName,rowId);
	        	updateElementVal(lastName,rowId);
	        	updateElementVal(mobile,rowId);        	
	        	updateElementVal(address,rowId);
	        	updateElementVal(admin,rowId);
	        	updateElementVal(role,rowId);
	//        	updateElementVal(image,rowId);
		}
		else if(responseData==FAIL)
		{
			if(action==update)
			{		
				$("#displayMsg").html(RECORD_NOT_UPDATED);
				$("#displayMsg").show();    						
			}
			else if(action==save)
			{
				$("#displayMsg").html(RECORD_NOT_SAVED);
				$("#displayMsg").show();
			}	
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
		
		
}
function createJsonObject(action,rowId)
{
//	var newUserName=$("#edit"+userName+rowId).val();
	var newEmail=$("#edit"+email+rowId).val();
//	var newPassword=$("#edit"+password+rowId).val();
	var newFirstName=$("#edit"+firstName+rowId).val();
	var newLastName=$("#edit"+lastName+rowId).val();
	var newMobile=$("#edit"+mobile+rowId).val();	
	var newAddress=$("#edit"+address+rowId).val();
	var newAdmin=$("#edit"+admin+rowId).val();
	var newRole=$("#edit"+role+rowId).val();
//	var newImage=$("#edit"+image+rowId).val();
	
//	if(action=='Update')
	var	jsonString='{"firstName":"'+newFirstName+'","lastName":"'+newLastName+'","mobile":"'+newMobile+'","email":"'+newEmail+'","address":"'+newAddress+'","admin":"'+newAdmin+'","role":"'+newRole+'"}';//,"password":"'+newPassword+'"}';
//	else if(action=='Save')
//		jsonString='{"firstName":"'+newFirstName+'","lastName":"'+newLastName+'","mobile":"'+newMobile+'","email":"'+newEmail+'","address":"'+newAddress+'","admin":"'+newAdmin+'","role":"'+newRole+'","password":"'+newPassword+'"}';
	
	return jsonString;
	
}
function rowEdit(elementName,rowId,action)
{
	var uniqueid="#"+elementName;
	var userNameText=inputElements(elementName,rowId,action);//"<input type='text' name='userName' value='"+$("#userName"+trid).text()+"'>" ;
	$(uniqueid+rowId).empty();
	$(uniqueid+rowId).html(userNameText);
}
function inputElements(inputName,rowId,action)
{
	var element="";
	if(action==edit)
	{
		if(inputName=='address')
		{			
			
			var elementName=inputName+rowId;
			var elementVal=$("#"+inputName+rowId).text();
		    element="<textarea id='edit"+elementName+"' name='"+elementName+"'>"+elementVal+"</textarea>";
		}
		else if(inputName=='email')
		{
			
			var elementName=inputName+rowId;
			var elementVal=$("#"+inputName+rowId).text();
			element="<input id='edit"+elementName+"' type='text' name='"+elementName+"' value='"+elementVal+"' disabled>";
		}
		else
		{
			var elementName=inputName+rowId;
			var elementVal=$("#"+inputName+rowId).text();
			element="<input id='edit"+elementName+"' type='text' name='"+elementName+"' value='"+elementVal+"'>";
		}
		
	}
	
	return element;
}
function updateElementVal(inputName,rowId)
{
	var innerHtml=$("#edit"+inputName+rowId).val();
	$("#"+inputName+rowId).empty();
	$("#"+inputName+rowId).html(innerHtml);	
	return innerHtml;
}
//On click on update User
//$(document).on('click', '#updateUser', function(){ 
//    alert('update User');
//});


function addUser()
{
	 $("#userTable").hide();
//	 $("#nouserrecords").hide();
//	 $("#emailmandatory").hide();
//	 $("#notupdated").hide();
//	 $("#updated").hide();
//	 $("#notsaved").hide();
//	 $("#saved").hide();
//	 $("#notdeleted").hide();
//	 $("#deleted").hide();
//	 $("#usernotexists").hide();
//	alert($("#userTableBody").html());
	var htmlString=$("#userTableBody").html();	
	
	if(!addUserflag)
	{
		$("#userTableBody").empty();
		htmlString="";
		addUserCount=0;
	}
//	var enteredUserName;
	var enteredEmail;
	var enteredPassword;
	var enteredFirstName;
	var enteredLastName;
	var enteredMobile;	
	var enteredAddress;
	var enteredAdmin;
	var enterdRole;
//	var enteredImage;
	
	if(addUserCount>0)
	{
//		enteredUserName=$("#edituserName"+(addUserCount-1)).val();
		enteredEmail=$("#editemail"+(addUserCount-1)).val();
//		enteredPassword=$("#editpassword"+(addUserCount-1)).val();
		enteredFirstName=$("#editfirstName"+(addUserCount-1)).val();
		enteredLastName=$("#editlastName"+(addUserCount-1)).val();
		enteredMobile=$("#editmobile"+(addUserCount-1)).val();		
		enteredAddress=$("#editaddress"+(addUserCount-1)).val();
		enteredAdmin=$("#editadmin"+(addUserCount-1)).val();
		enteredRole=$("#editrole"+(addUserCount-1)).val();
//		enteredImage=$("#editimage"+(addUserCount-1)).val();
				
	}	

		
//	var userNameElement="<input id='edituserName"+addUserCount+"' type='text' name='userName"+addUserCount+"'>";// value='"+$('#edituserName'+addUserCount).val()+"'>";
	var emailElement="<input id='editemail"+addUserCount+"' type='text' name='email"+addUserCount+"'>";
//	var passwordElement="<input id='editpassword"+addUserCount+"' type='text' name='password"+addUserCount+"'>";
	var firstNameElement="<input id='editfirstName"+addUserCount+"' type='text' name='firstName"+addUserCount+"'>";
	var lastNameElement="<input id='editlastName"+addUserCount+"'type='text' name='lastName"+addUserCount+"'>";
	var mobileElement="<input id='editmobile"+addUserCount+"' type='text' name='mobile"+addUserCount+"'>";	
	var addressElement="<textarea id='editaddress"+addUserCount+"' name='address"+addUserCount+"'/>";
	var adminElement="<input id='editadmin"+addUserCount+"' type='text' name='admin"+addUserCount+"'>";
	var roleElement="<input id='editrole"+addUserCount+"' type='text' name='role"+addUserCount+"'>";
//	var imageElement="<input id='editimage"+addUserCount+"' type='text' name='imageName"+addUserCount+"'>";
	
	addUserflag=true;
	var htmlContent=htmlString+"<tr id='"+addUserCount+"'><th scope=\"row\">&nbsp;</th><td id='email"+addUserCount+"'>"+emailElement+"</td><td id='firstName"+addUserCount+"'>"+firstNameElement+"</td><td id='lastName"+addUserCount+"'>"+lastNameElement+"</td><td id='mobile"+addUserCount+"'>"+mobileElement+"</td><td id='address"+addUserCount+"'>"+addressElement+"</td><td id='admin"+addUserCount+"'>"+adminElement+"</td><td id='role"+addUserCount+"'>"+roleElement+"</td>"+//<td id='image"+addUserCount+"'>"+imageElement+"</td>"+
							"<td style='border-right:none' id='saveButton'><button id='addUserSaveButton"+addUserCount+"' type=\"button\" class=\"btn btn-default btn-sm\">Save</button>"+
							"<td style='border-left:none'><button  id='addUserDelete"+addUserCount+"' type=\"button\" class=\"btn btn-default btn-sm\">Delete</button>";
									"</td></tr>";
							
	
	$("#userTableBody").html(htmlContent);
	if(addUserCount>0)
	{
//		$("#edituserName"+(addUserCount-1)).attr('value',enteredUserName);
		$("#editemail"+(addUserCount-1)).attr('value',enteredEmail);
//		$("#editpassword"+(addUserCount-1)).attr('value',enteredPassword);
		$("#editfirstName"+(addUserCount-1)).attr('value',enteredFirstName);
		$("#editlastName"+(addUserCount-1)).attr('value',enteredLastName);
		$("#editmobile"+(addUserCount-1)).attr('value',enteredMobile);		
		$("#editaddress"+(addUserCount-1)).attr('value',enteredAddress);
		$("#editadmin"+(addUserCount-1)).attr('value',enteredAdmin);
		$("#editrole"+(addUserCount-1)).attr('value',enteredRole);
//		$("#editimage"+(addUserCount-1)).attr('value',enteredImage);
		
	}	
	addUserCount++;
	$("#userTable").show();
}
function userResult(usersListResponse)
{
//		alert(responseData);
//	$("#emailmandatory").hide();
//	$("#notupdated").hide();
//	$("#notsaved").hide();
//	$("#updated").hide();
//	$("#saved").hide();
		try{
			 $("#userTable").hide();
			 if(usersListResponse==NO_DATA)
			 {
				 $("#displayMsg").html(NO_RECORDS);
				 $("#displayMsg").show();				 
			 }
			 else if(usersListResponse==APP_ERROR)
			 {
				 $("#displayMsg").html(APPLICATION_ERROR);
				 $("#displayMsg").show();
			 }
			 else if(usersListResponse==SESSION_EXPIRED)
			 {
					$("#displayMsg").html(SESSION_EXPIRED_MSG);
					$("#displayMsg").show();
			 }
			 else
			 {
					var usersArray=JSON.parse(usersListResponse);
					//	var array=jsonObjetoArray();
						var htmlContent="";
//						alert(jsonObj[0]);
//						style='border-right:none'
						var count=1;
						for(var i=0;i<usersArray.length;i++)
							{
								var val=usersArray[i];					
								
					//			alert(val.name+": "+ val.records+":"+ val.totalrecords);
								htmlContent=htmlContent+"<tr id='"+i+"'><th scope=\"row\">&nbsp;</th><td id='email"+i+"'>"+val.email+"</td><td id='firstName"+i+"'>"+val.firstName+"</td><td id='lastName"+i+"'>"+val.lastName+"</td><td id='mobile"+i+"'>"+val.mobile+"</td><td id='address"+i+"'>"+val.address+"</td><td id='admin"+i+"'>"+val.admin+"</td><td id='role"+i+"'>"+val.role+"</td>"+//<td id='image"+i+"'>"+val.image+"</td>"+
											"<td style='border-right:none' id='tdeditButton"+i+"'><button id='editUserButton"+i+"' type=\"button\" class=\"btn btn-default btn-sm\">Edit</button></td>"+
											"<td style='border-left:none' id='tddeleteButton"+i+"'><button id='deleteUserButton"+i+"' type=\"button\" class=\"btn btn-default btn-sm col-md-pull-5\">Delete</button></td></tr>";
												
												
								count++;
							}
						  
						   addUserflag=false;
						   $("#userTableBody").html(htmlContent);
						   $("#userTable").show();
					//	alert(jsonObj);
			 }
			
				}
				catch(JSONException)
				{
					alert(historyResponse);
				}
}
