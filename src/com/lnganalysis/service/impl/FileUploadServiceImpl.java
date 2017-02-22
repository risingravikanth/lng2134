package com.lnganalysis.service.impl;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;

import com.lnganalysis.constants.ApplicationConstants;
import com.lnganalysis.dao.domain.DomainDao;
import com.lnganalysis.dao.domain.impl.CrudeOilDaoImpl;
import com.lnganalysis.dao.domain.impl.ExplorationDaoImpl;
import com.lnganalysis.dao.domain.impl.LngDaoImpl;
import com.lnganalysis.dao.domain.impl.NaturalGasDaoImpl;
import com.lnganalysis.dao.domain.impl.PipelineDaoImpl;
import com.lnganalysis.dao.domain.impl.RefineryDaoImpl;
import com.lnganalysis.dao.domain.impl.StorageDaoImpl;
import com.lnganalysis.dto.Tab;
import com.lnganalysis.entities.domain.User;
import com.lnganalysis.helper.JsonResponse;
import com.lnganalysis.helper.ReadUploadedFile;
import com.lnganalysis.service.FileUploadService;

public class FileUploadServiceImpl implements FileUploadService {
	static final Logger logger=Logger.getLogger(FileUploadServiceImpl.class);
	@Override
	public String uploadFileService(InputStream is, User user,String action) {
		// TODO Auto-generated method stub
		String jsonRes=null;
		try
		{
			ReadUploadedFile uploadedFile=new ReadUploadedFile();
			Map<String, List<Tab>> uploadedFileMap=uploadedFile.readUploadFile(is,user,action);
		    jsonRes=JsonResponse.createFileUploadResponse(uploadedFileMap);			
		}
		catch(ConstraintViolationException cve)
		{
			logger.error("Exception in FileUploadServiceImpl - uploadFileService():"+cve);
			jsonRes=ApplicationConstants.DUPLICATE_ENTRY;
		}
		catch(Exception e)
		{
			logger.error("Exception in FileUploadServiceImpl - uploadFileService():"+e);
			jsonRes=ApplicationConstants.APP_EXCEPTION;
		}
		return jsonRes;
	}

	@Override
	public void writeFile(FileItem fi,String filePath) {
		// TODO Auto-generated method stub
//		  Get the uploaded file parameters
//	    String fieldName = fi.getFieldName();
		
		try
		{
			InputStream is=UserManagementServiceImpl.class.getClassLoader().getResourceAsStream(ApplicationConstants.APP_PROPERTIES);
		  	 Properties properties=new Properties();
		  	 properties.load(is);
	        SimpleDateFormat sdf = new SimpleDateFormat(properties.getProperty("EXCEL_FILE_FORMAT_DATE_TIME"));//hh:mm:ss");
		    String dateString=sdf.format(new Date());
	        
	        String fileName = dateString+"_"+fi.getName();
	        File file=null;
			 // Write the file to specified folder path
	       	if( fileName.lastIndexOf("\\") >= 0 ){
	            	
		               file = new File( filePath+
		               fileName.substring( fileName.lastIndexOf("\\"))) ;
		            }else{		            	
		               file = new File( filePath+
		               fileName.substring(fileName.lastIndexOf("\\")+1)) ;
		            }
		         fi.write( file ) ;
		          
	        
		}
		catch(Exception e)
		{
			logger.error("Exception in FileUploadServiceImpl - writeFile():"+e);
		}
		
	}

	@Override
	public int getExplorationCount()throws Exception {
		// TODO Auto-generated method stub
		DomainDao exploration=new ExplorationDaoImpl();
		return exploration.getLastRecordNum();
	}

	@Override
	public int getRefineriesCount()throws Exception {
		// TODO Auto-generated method stub
		DomainDao refinery=new RefineryDaoImpl();
		return refinery.getLastRecordNum();
	}

	@Override
	public int getCrudeOilCount()throws Exception {
		// TODO Auto-generated method stub
		DomainDao crudeOil=new CrudeOilDaoImpl();
		return crudeOil.getLastRecordNum();
	}

	@Override
	public int getNaturalGasCount()throws Exception {
		// TODO Auto-generated method stub
		DomainDao naturalGas=new NaturalGasDaoImpl();
		return naturalGas.getLastRecordNum();
	}

	@Override
	public int getStorageCount()throws Exception {
		// TODO Auto-generated method stub
		DomainDao storage=new StorageDaoImpl();
		return storage.getLastRecordNum();
	}

	@Override
	public int getLngCount()throws Exception {
		// TODO Auto-generated method stub
		DomainDao lng=new LngDaoImpl();
		return lng.getLastRecordNum();
	}

	@Override
	public int getPipeLineCount()throws Exception {
		// TODO Auto-generated method stub
		DomainDao pipeline=new PipelineDaoImpl();
		return pipeline.getLastRecordNum();
	} 
       
       
	
	
}
