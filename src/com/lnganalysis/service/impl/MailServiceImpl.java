package com.lnganalysis.service.impl;

import java.awt.Font;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.lnganalysis.constants.ApplicationConstants;
import com.lnganalysis.service.MailService;

public class MailServiceImpl implements MailService {
	static final Logger logger=Logger.getLogger(MailServiceImpl.class);
//	@Override
	
	public String sendMailToAdmin(String email) {
		// TODO Auto-generated method stub
		
		String mailRes=null;		
	
	  
	     //compose the message  
	      try{  
		     InputStream is=UserManagementServiceImpl.class.getClassLoader().getResourceAsStream(ApplicationConstants.APP_PROPERTIES);
		  	 Properties properties=new Properties();
		  	 properties.load(is);
		 	 
			 String body=properties.getProperty("MAIL_TO_ADMIN_BODY")+email;					
			 String from=email;
			 String to=properties.getProperty("ADMIN_MAIL_ID");

			 Session session=getMailSession();
	         MimeMessage message = new MimeMessage(session);  
	         message.setFrom(new InternetAddress(from));  
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
	         message.setSubject(properties.getProperty("RESET_PWD_REQ_SUBJECT"));  
	         message.setText(body);  
	  
	         // Send message  
	         Transport.send(message);  
	         
	         mailRes=ApplicationConstants.SUCCESS;
	  
	      }catch (MessagingException mex) {
	    	  mailRes=ApplicationConstants.FAIL;
	    	  logger.error("Exception in MailServiceImpl - Method sendMailToAdmin():"+mex);
	      }
	      catch(Exception e)
	      {
	    	  logger.error("Exception in MailServiceImpl - Method sendMailToAdmin():"+e);
	      }
	      return mailRes;
	   }
		@Override
		public String sendMailToUser(String email, String resetpassword) {
			// TODO Auto-generated method stub
			String mailRes=null;						
		  
		     //compose the message  
		      try{  
		    	  InputStream is=UserManagementServiceImpl.class.getClassLoader().getResourceAsStream(ApplicationConstants.APP_PROPERTIES);
				  Properties properties=new Properties();
				  properties.load(is);
				 	 
		    	String body=properties.getProperty("MAIL_TO_USER_BODY1")+email+properties.getProperty("MAIL_TO_USER_BODY2")+resetpassword;
				String from=properties.getProperty("ADMIN_MAIL_ID");
				String to=email;
				
				 Session session=getMailSession();
		         MimeMessage message = new MimeMessage(session);  
		         message.setFrom(new InternetAddress(from));  
		         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		         message.setSubject(properties.getProperty("RESET_PWD"));  
		         message.setText(body);  
		  
		         // Send message  
		         Transport.send(message);  
		         logger.info("Mail message sent successfully....");  
		         mailRes=ApplicationConstants.SUCCESS;
		  
		      }catch (MessagingException mex) {
		    	  mailRes=ApplicationConstants.FAIL;		
		    	  logger.error("Exception in MailServiceImpl - Method sendMailToUser:"+mex);
		      }  
		      catch(Exception e)
		      {
		    	  logger.error("Exception in MailServiceImpl - Method sendMailToUser:"+e);
		      }
		      return mailRes;
		}  
	private Session getMailSession()
	{
		final String username = "javapro0725@gmail.com";
		final String password = "2javapro5";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
		return session;
	}
	
}
