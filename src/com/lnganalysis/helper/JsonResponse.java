package com.lnganalysis.helper;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.lnganalysis.constants.ApplicationConstants;
import com.lnganalysis.dto.Tab;
import com.lnganalysis.entities.domain.History;
import com.lnganalysis.entities.domain.User;
import com.lnganalysis.entities.domain.UserAudit;
import com.lnganalysis.entities.source.Countries;
import com.lnganalysis.entities.source.ImportCountries;
import com.lnganalysis.entities.source.LngSource;
import com.lnganalysis.entities.source.PipeLineSource;
import com.lnganalysis.entities.source.RefinerySource;
import com.lnganalysis.entities.source.Region;
import com.lnganalysis.entities.source.SingleSource;
import com.lnganalysis.entities.source.Status;
import com.lnganalysis.entities.source.StorageSource;
import com.lnganalysis.entities.source.Type;

public class JsonResponse {
	static final Logger logger=Logger.getLogger(JsonResponse.class);
	public static String createFileUploadResponse(Map<String,List<Tab>> errorTabMap)
	{
		logger.info("Class - JsonResponse - createFileUploadResponse()");
		String response=null;		
		if(errorTabMap!=null)
		{
			
			List<Tab> tabs=null;
			String resKey=null;
			JSONObject jsonResObj=new JSONObject();
			if(errorTabMap.get(ApplicationConstants.DATA_VALIDATION_FAIL)!=null)
			{
				logger.info("Class - JsonResponse - createFileUploadResponse() - invalidata");
				tabs=errorTabMap.get(ApplicationConstants.DATA_VALIDATION_FAIL);
				resKey=ApplicationConstants.DATA_VALIDATION_FAIL;
			}
			else if(errorTabMap.get(ApplicationConstants.INCORRECT_DATA)!=null)
			{
				logger.info("Class - JsonResponse - createFileUploadResponse() - incorrectdata");
				tabs=errorTabMap.get(ApplicationConstants.INCORRECT_DATA);
				resKey=ApplicationConstants.INCORRECT_DATA;
			}
			else if(errorTabMap.get(ApplicationConstants.INVALID_DATA_SHEET)!=null)
			{
				logger.info("Class - JsonResponse - createFileUploadResponse() - invalidDataSheet");
				tabs=errorTabMap.get(ApplicationConstants.INCORRECT_DATA);
				response=ApplicationConstants.INVALID_DATA_SHEET;
			}
//			
			if(null!=tabs && tabs.size()>0)
			{
				JSONArray array=new JSONArray();
				for(Tab tab:tabs)
				{
					 JSONObject jsonObj=new JSONObject();
					 jsonObj.put("name", tab.getName());
				      jsonObj.put("records",tab.getRecords());
				      jsonObj.put("totalrecords",tab.getTotalRecords());
				      jsonObj.put("description",tab.getDescription());
				      array.add(jsonObj);
				}
				jsonResObj.put(resKey, array);
				response=jsonResObj.toString();		      
			}
		}
		else
			response=ApplicationConstants.SUCCESS;
		
//		System.out.println(response);
		return response;
		
		
	}
	public static String createHistoryResponse(List<History> historyList)
	{
		logger.info("Class - JsonResponse - createHistoryResponse()");
		String response=null;
		if(historyList.size()>0)
		{
			JSONArray array=new JSONArray();
			for(History history:historyList)
			{
				 JSONObject jsonObj=new JSONObject();
				 							
				  jsonObj.put("email",history.getUser().getEmail());
			      jsonObj.put("createdDate",history.getCreatedDate().toString());
			      jsonObj.put("exploration",history.getExplorationCount());
			      jsonObj.put("refinery",history.getRefineriesCount());
			      jsonObj.put("crudeoil",history.getCrudeOilCount());
			      jsonObj.put("naturalGas",history.getNaturalGasCount());
			      jsonObj.put("storage",history.getStorageCount());
			      jsonObj.put("lng",history.getLngCount());
			      jsonObj.put("pipeline",history.getPipelinesCount());
			      
			      array.add(jsonObj);
			}
			
			response=array.toString();		      
		}
		return response;
	}
	public static String createUsersListResponse(List<User> usersList)
	{
		logger.info("Class - JsonResponse - createUsersListResponse()");
		String response=null;
		if(usersList.size()>0)
		{
			JSONArray array=new JSONArray();
			for(User user:usersList)
			{
				 JSONObject jsonObj=new JSONObject();
				 							 
//				  jsonObj.put("userName",user.getUserName());
			      jsonObj.put("firstName",user.getFirstName());
			      jsonObj.put("lastName",user.getLastName());
			      jsonObj.put("mobile",user.getMobile());
			      jsonObj.put("email",user.getEmail());
			      jsonObj.put("address",user.getAddress());
			      jsonObj.put("admin",user.getAdmin());
			      jsonObj.put("role",user.getRole());
//			      jsonObj.put("password", user.getPassword());
//			      jsonObj.put("image",user.getUserImage());
			      
			      array.add(jsonObj);
			}
			response=array.toString();
		}	
		return response;
	}
	public static String createSourceListResponse(List<Object> sourceList)
	{
		logger.info("Class - JsonResponse - createSourceListResponse()");
		String response=null;		
		JSONArray array=new JSONArray();
		Object source=sourceList.get(0);
			
			if(source instanceof ImportCountries)
			{
				
				for(Object sourceCountries:sourceList)
				{
					JSONObject jsonObj=new JSONObject();
					ImportCountries country=(ImportCountries)sourceCountries;										
					jsonObj.put("name",country.getName());
					array.add(jsonObj);
				}
			}
			if(source instanceof Countries)
			{
				
				for(Object sourceCountries:sourceList)
				{
					JSONObject jsonObj=new JSONObject();
					Countries country=(Countries)sourceCountries;										
					jsonObj.put("name",country.getName());
					array.add(jsonObj);
				}
			}
			else if(source instanceof LngSource)
			{
				
				for(Object lngSource:sourceList)
				{
					JSONObject jsonObj=new JSONObject();
					LngSource lng=(LngSource)lngSource;										
					jsonObj.put("name",lng.getName());
					array.add(jsonObj);
				}
			}
			else if(source instanceof PipeLineSource)
			{
				
				for(Object pipelineSource:sourceList)
				{
					JSONObject jsonObj=new JSONObject();
					PipeLineSource pipeline=(PipeLineSource)pipelineSource;										
					jsonObj.put("name",pipeline.getName());
					array.add(jsonObj);
				}
			}
			else if(source instanceof RefinerySource)
			{
				
				for(Object refinerySource:sourceList)
				{
					JSONObject jsonObj=new JSONObject();
					RefinerySource refinery=(RefinerySource)refinerySource;										
					jsonObj.put("name",refinery.getName());
					array.add(jsonObj);
				}
			}
			else if(source instanceof Region)
			{
				
				for(Object sourceRegion:sourceList)
				{
					JSONObject jsonObj=new JSONObject();
					Region region=(Region)sourceRegion;										
					jsonObj.put("name",region.getName());
					array.add(jsonObj);
				}
			}
			else if(source instanceof SingleSource)
			{
				
				for(Object singleSource:sourceList)
				{
					JSONObject jsonObj=new JSONObject();
					SingleSource operator=(SingleSource)singleSource;										
					jsonObj.put("name",operator.getName());
					array.add(jsonObj);
				}
			}
			else if(source instanceof Status)
			{
				
				for(Object statusSource:sourceList)
				{
					JSONObject jsonObj=new JSONObject();
					Status status=(Status)statusSource;										
					jsonObj.put("name",status.getName());
					array.add(jsonObj);
				}
			}
			else if(source instanceof StorageSource)
			{
				
				for(Object storageSource:sourceList)
				{
					JSONObject jsonObj=new JSONObject();
					StorageSource storage=(StorageSource)storageSource;										
					jsonObj.put("name",storage.getName());
					array.add(jsonObj);
				}
			}	
			else if(source instanceof Type)
			{
				
				for(Object typeSource:sourceList)
				{
					JSONObject jsonObj=new JSONObject();
					Type type=(Type)typeSource;										
					jsonObj.put("name",type.getName());
					array.add(jsonObj);
				}
			}
			response=array.toString();
		
		return response;
	}
	public static String createUserAuditResponse(List<UserAudit> auditList)
	{
		logger.info("Class - JsonResponse - createUserAuditResponse()");
		String response=null;
		SimpleDateFormat sdf=new SimpleDateFormat("dd-M-yyyy HH:mm:ss");
		if(auditList.size()>0)
		{
			JSONArray array=new JSONArray();
			for(UserAudit userAudit:auditList)
			{
				 JSONObject jsonObj=new JSONObject();
				 							 
//				  
			      jsonObj.put("user",userAudit.getCreatedBy());
			      jsonObj.put("createdDate",sdf.format(userAudit.getCreatedDate()));
			      if(null!=userAudit.getAction())
			      jsonObj.put("action",userAudit.getAction());
			      else
			    	  jsonObj.put("action","");
			      jsonObj.put("comments",userAudit.getComments());
			    			      
			      array.add(jsonObj);
			}
			response=array.toString();
		}	
		return response;
	}
	public static String createRecordCountResponse(Map tabCount)
	{
		logger.info("Class - JsonResponse - createRecordCountResponse()");
		String response=null;
		
		 if(tabCount!=null)
		 {
			 
			JSONArray array=new JSONArray();			
			JSONObject jsonObj=new JSONObject();
				 							 
				  
			jsonObj.put(ApplicationConstants.EXPLORATION_COUNT,tabCount.get(ApplicationConstants.EXPLORATION_COUNT));			
			jsonObj.put(ApplicationConstants.REFINERY_COUNT, tabCount.get(ApplicationConstants.REFINERY_COUNT));
			jsonObj.put(ApplicationConstants.CRUDEOIL_COUNT, tabCount.get(ApplicationConstants.CRUDEOIL_COUNT));
			jsonObj.put(ApplicationConstants.NATURALGAS_COUNT, tabCount.get(ApplicationConstants.NATURALGAS_COUNT));
			jsonObj.put(ApplicationConstants.LNG_COUNT, tabCount.get(ApplicationConstants.LNG_COUNT));
			jsonObj.put(ApplicationConstants.STORAGE_COUNT, tabCount.get(ApplicationConstants.STORAGE_COUNT));
			jsonObj.put(ApplicationConstants.PIPELINE_COUNT, tabCount.get(ApplicationConstants.PIPELINE_COUNT));			 			     
			array.add(jsonObj);			
			response=array.toString();
		}	
		return response;
	}
	public static String createTerminalsResponse(List<String> terminalsList)
	{
		String response=null;		
		JSONArray array=new JSONArray();
		for(String terminal:terminalsList)
		{
			JSONObject jsonObj=new JSONObject();										
			jsonObj.put("name",terminal);
			array.add(jsonObj);
		}
		response=array.toString();
		return response;
	}
}
