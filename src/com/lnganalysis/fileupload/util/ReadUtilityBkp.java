package com.lnganalysis.fileupload.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.lnganalysis.entities.domain.Exploration;

public class ReadUtilityBkp {
 
		public static List getExplorationList(XSSFSheet sheet)
		{
			List explorationList=null;
			try
			{
				explorationList=new ArrayList();
				
				int rowCount=sheet.getLastRowNum();
				
				String [] headers=getHeaderValues(sheet);
				
							
				for(int i=1;i<=rowCount;i++)
				{				
					Exploration e=new Exploration();
					Class pojoClass=e.getClass();
					Field fields[]=pojoClass.getDeclaredFields();
					XSSFRow row=sheet.getRow(i);
					int cellCount=row.getLastCellNum();
					for(int j=0;j<cellCount;j++)
					{
						String sheaders=headers[j].replace(" ","");
						for(int k=0;k<fields.length;k++)
						{							
							String sfield=fields[k].getName();
							if(sheaders.equalsIgnoreCase(sfield))
							{
								String fieldName=fields[k].getName();
								String methodFirstChar=fieldName.substring(0,1).toUpperCase();
								String methodName="set"+methodFirstChar+fieldName.substring(1);
								System.out.println("hi final methodName:"+methodName);
								Class[] methodArgs=new Class[1];
								methodArgs[0]=String.class;
								Method m=pojoClass.getMethod(methodName, methodArgs);
								m.invoke(e, row.getCell(j).getStringCellValue());
								break;	
							}
							
							
						}
						
						
					}
					
					explorationList.add(e);
				}
			}
			catch(Exception e)
			{
			 System.out.println(e);	
			}
			return explorationList;
		}
		private static String getMethodName(String methodname)
		{			
			return new String();
		}
		private static String[] getHeaderValues(XSSFSheet sheet)
		{
			XSSFRow  headerRow=sheet.getRow(0);
			int cellCount=headerRow.getLastCellNum();
			String[] headers=new String[cellCount];
			
			for(int i=0;i<cellCount;i++)
			   headers[i]=removeSpecialAndNumCharacters(headerRow.getCell(i).toString());
			return headers;
		}
		private static String removeSpecialAndNumCharacters(String headerValue)
		{

			headerValue=headerValue.replaceAll(" ","");
			Pattern p = Pattern.compile("[^A-za-z]", Pattern.CASE_INSENSITIVE);
		    Matcher m = p.matcher(headerValue);
		    
		      System.out.println(headerValue);
		      int count = 0;
		      while (m.find()) {
		         count = count+1;
		         System.out.println("position "  + m.start() + ": " + headerValue.charAt(m.start()));
		         char c=headerValue.charAt(m.start());
		         switch(c)
		         {
		         	case '/':
		         			headerValue=headerValue.replaceAll("/","Or");
		         			break;
		         	case '&':
		         			headerValue=headerValue.replaceAll("&","And");
		         			break;
		         	case '-':
	         				headerValue=headerValue.replaceAll("-","");
	         				break;
		         	case '(':
		         			headerValue=headerValue.substring(0,m.start());
		         			break;
		         	case '2':
		         			headerValue=headerValue.replaceAll("2","Two");
		         			break;
		         	case '3':
		         		headerValue=headerValue.replaceAll("3","Three");
	         			break;
		         	
		         }
		         break;
//		         if(c=='/')
//		          System.out.println(true);
		      }
		      
		      System.out.println("There are " + count + " special characters");
			return headerValue;
		}
}
