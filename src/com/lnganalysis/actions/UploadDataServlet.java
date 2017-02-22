package com.lnganalysis.actions;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.log4j.Logger;

import com.lnganalysis.constants.ApplicationConstants;
import com.lnganalysis.entities.domain.User;
import com.lnganalysis.service.FileUploadService;
import com.lnganalysis.service.impl.FileUploadServiceImpl;


public class UploadDataServlet extends HttpServlet {
		   static final Logger logger=Logger.getLogger(UploadDataServlet.class);
		   private boolean isMultipart;
		   private String filePath;
		   private int maxFileSize = 50 * 1024*1024;
		   private int maxMemSize = 4 * 1024*1024;
		   private File file ;
		   static Logger log=Logger.getLogger(UploadDataServlet.class);
		   
		   public void init( ){
		      // Get the file location where it would be stored.
		      filePath = 
		             getServletContext().getInitParameter("file-upload"); 
		   }
		   public void doPost(HttpServletRequest request, 
		               HttpServletResponse response)
		              throws ServletException, java.io.IOException {
			   log.info("Class - UploadDataServlet - doPost");
			   java.io.PrintWriter out = response.getWriter( );
			   HttpSession session=request.getSession();
			   String action=request.getParameter("action");
			   User user=(User)session.getAttribute(ApplicationConstants.USER);
			   if(session.isNew() || null==user)
			   {
				   out.write(ApplicationConstants.SESSION_EXPIRED);
			   }
			   else
			   {
				   					 
				   isMultipart = ServletFileUpload.isMultipartContent(request); 	
				      
				   ServletRequestContext src=new ServletRequestContext(request);
				      
				      
				      if( !isMultipart ){
				    	 out.write("isMultipart");

				      }
				      DiskFileItemFactory factory = new DiskFileItemFactory();
				      // maximum size that will be stored in memory
//				      factory.setSizeThreshold(maxMemSize);
				      // Location to save data that is larger than maxMemSize.
//				      factory.setRepository(new File("c:\\temp"));

				      // Create a new file upload handler
				      ServletFileUpload upload = new ServletFileUpload(factory);
				      // maximum file size to be uploaded.
				      upload.setSizeMax( maxFileSize );

				      try{ 
				      // Parse the request to get file items.
				      List fileItems = upload.parseRequest(request);
				      		      			
				      // Process the uploaded file items
				      Iterator i = fileItems.iterator();


				      String uploadResponse=null;
				     
				      
				      while ( i.hasNext () ) 
				      {
				         FileItem fi = (FileItem)i.next();
				         
				        
				         if ( !fi.isFormField () )	
				         {
				        	 FileUploadService  fileUploadService=new FileUploadServiceImpl();
				        	 uploadResponse=fileUploadService.uploadFileService(fi.getInputStream(),user,action);
				        	 if(uploadResponse!=null && uploadResponse.equalsIgnoreCase(ApplicationConstants.SUCCESS))
				        		 fileUploadService.writeFile(fi,filePath);
				        	 			        			        		           		            		         
				         }
				         else
				         {
				        	 String fieldName=fi.getFieldName();
//				        	 System.out.println("fieldName:"+fieldName);
//				        	 
				        	
				         }
				      }		      		       		      		     		      		     
				      response.setContentType("application/json");
//				      
				      out.write(uploadResponse);//array.toString()
				      
				   }catch(Exception ex) {
					  logger.error("Exception in UploadDataServlet:"+ex);
					   out.write(ApplicationConstants.APP_EXCEPTION);
				       
				   }
			   }
			 
		  }
		   public void doGet(HttpServletRequest request, 
		                       HttpServletResponse response)
		        throws ServletException, java.io.IOException {
		       doPost(request, response); 
		       
		   } 
}
