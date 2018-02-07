package com.lnganalysis.actions;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.lnganalysis.constants.ApplicationConstants;
import com.lnganalysis.helper.JsonResponse;
import com.lnganalysis.service.FileUploadService;
import com.lnganalysis.service.impl.FileUploadServiceImpl;

public class RecordCountServlet extends HttpServlet{
	static final Logger logger=Logger.getLogger(RecordCountServlet.class);
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		
		PrintWriter out = null;
		try {
			logger.info("Class- RecordCountServlet - doPost");
			out = response.getWriter();
			FileUploadService fus=new FileUploadServiceImpl();
			int exploration=fus.getExplorationCount();
			int refineries=fus.getRefineriesCount();
			int crudeoil=fus.getCrudeOilCount();
			int naturalGas=fus.getNaturalGasCount();
			int lng=fus.getLngCount();
			int storage=fus.getStorageCount();
			int pipeline=fus.getPipeLineCount();
			int smallScaleLngCount=fus.getSmallScaleLngCount();
			Map tabCount=new HashMap();
			HttpSession session=request.getSession();
			 session.setAttribute(ApplicationConstants.EXPLORATION_COUNT,exploration);
			 session.setAttribute(ApplicationConstants.REFINERY_COUNT, refineries);
			 session.setAttribute(ApplicationConstants.CRUDEOIL_COUNT,crudeoil);
			 session.setAttribute(ApplicationConstants.NATURALGAS_COUNT,naturalGas);
			 session.setAttribute(ApplicationConstants.LNG_COUNT ,lng);
			 session.setAttribute(ApplicationConstants.STORAGE_COUNT,storage);
			 session.setAttribute(ApplicationConstants.PIPELINE_COUNT,pipeline);
			 session.setAttribute(ApplicationConstants.SMALLSCALELNG_COUNT,smallScaleLngCount);
			 
			tabCount.put(ApplicationConstants.EXPLORATION_COUNT, exploration);
			tabCount.put(ApplicationConstants.REFINERY_COUNT, refineries);
			tabCount.put(ApplicationConstants.CRUDEOIL_COUNT, crudeoil);
			tabCount.put(ApplicationConstants.NATURALGAS_COUNT, naturalGas);
			tabCount.put(ApplicationConstants.LNG_COUNT, lng);
			tabCount.put(ApplicationConstants.STORAGE_COUNT, storage);
			tabCount.put(ApplicationConstants.PIPELINE_COUNT, pipeline);
			tabCount.put(ApplicationConstants.SMALLSCALELNG_COUNT,smallScaleLngCount);
			String jsonResponse=JsonResponse.createRecordCountResponse(tabCount);
			out.write(jsonResponse);
			
		} catch (Exception e) {
			logger.error("Exception in RecordCountServlet:"+e);
			
		}
	}
	 public void doGet(HttpServletRequest request, 
            HttpServletResponse response)throws ServletException,java.io.IOException
	 {
		 doPost(request,response);
	 }
}
