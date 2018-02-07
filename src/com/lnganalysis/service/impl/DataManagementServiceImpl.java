package com.lnganalysis.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.lnganalysis.constants.ApplicationConstants;
import com.lnganalysis.dao.source.SourceDao;
import com.lnganalysis.dao.source.impl.CountriesDaoImpl;
import com.lnganalysis.dao.source.impl.ImportCountriesDaoImpl;
import com.lnganalysis.dao.source.impl.LngSourceDaoImpl;
import com.lnganalysis.dao.source.impl.PipeLineSourceDaoImpl;
import com.lnganalysis.dao.source.impl.RefinerySourceDaoImpl;
import com.lnganalysis.dao.source.impl.RegionDaoImpl;
import com.lnganalysis.dao.source.impl.ReportsDaoImpl;
import com.lnganalysis.dao.source.impl.SingleSourceDaoImpl;
import com.lnganalysis.dao.source.impl.SmallScaleLngSourceDaoImpl;
import com.lnganalysis.dao.source.impl.StatusDaoImpl;
import com.lnganalysis.dao.source.impl.StorageSourceDaoImpl;
import com.lnganalysis.dao.source.impl.TypeDaoImpl;
import com.lnganalysis.service.DataManagementService;

public class DataManagementServiceImpl implements DataManagementService {
	static final Logger logger=Logger.getLogger(DataManagementServiceImpl.class);
	@Override
	public List<Object> readSourceData(String sourceType) {
		// TODO Auto-generated method stub
		List<Object> sourceList=null;
		try
		{			
			SourceDao sourceDao=getSourceDao(sourceType);
			sourceList=sourceDao.readSource();	
		}
		catch(Exception e)
		{
			logger.error("Exception in DataManagementServiceImpl - Method readSourceData():"+e);			
		}					
		return sourceList;
	}
	public SourceDao getSourceDao(String sourceType)
	{
		SourceDao sourceDao=null;
		if(null!=sourceType && ("ImportCountries").equalsIgnoreCase(sourceType))
			sourceDao=new ImportCountriesDaoImpl();	
		else if(null!=sourceType && ("countries").equalsIgnoreCase(sourceType))
			sourceDao=new CountriesDaoImpl();
		else if(null!=sourceType && ("lng").equalsIgnoreCase(sourceType))
			sourceDao=new LngSourceDaoImpl();		
		else if(null!=sourceType && ("pipeline").equalsIgnoreCase(sourceType))
			sourceDao=new PipeLineSourceDaoImpl();
		else if(null!=sourceType && ("refinery").equalsIgnoreCase(sourceType))
			sourceDao=new RefinerySourceDaoImpl();
		else if(null!=sourceType && ("region").equalsIgnoreCase(sourceType))
			sourceDao=new RegionDaoImpl();
		else if(null!=sourceType && ("operator").equalsIgnoreCase(sourceType))// This is singlesource
			sourceDao=new SingleSourceDaoImpl();
		else if(null!=sourceType && ("SmallScaleLng").equalsIgnoreCase(sourceType))
			sourceDao=new SmallScaleLngSourceDaoImpl();
		else if(null!=sourceType && ("status").equalsIgnoreCase(sourceType))
			sourceDao=new StatusDaoImpl();
		else if(null!=sourceType && ("storage").equalsIgnoreCase(sourceType))
			sourceDao=new StorageSourceDaoImpl();
		else if(null!=sourceType && ("type").equalsIgnoreCase(sourceType))
			sourceDao=new TypeDaoImpl();
		else if(null!=sourceType && ("reports").equalsIgnoreCase(sourceType))
			sourceDao=new ReportsDaoImpl();
		return sourceDao;
	}
	@Override
	public String deleteSourceData(String sourceType, String sourceName) {
		// TODO Auto-generated method stub
		String response=null;
		try
		{
			SourceDao sourceDao=getSourceDao(sourceType);
			sourceDao.deleteSource(sourceName);
			response=ApplicationConstants.SUCCESS;
		}
		catch(Exception e)
		{
			logger.error("Exception in DataManagementServiceImpl - Method deleteSourceData():"+e);
			response=ApplicationConstants.FAIL;
		}
		
		return response;
	}
	@Override
	public String saveSourceData(String sourceType, String sourceName) {
		// TODO Auto-generated method stub
		String response=null;
		try
		{
			SourceDao sourceDao=getSourceDao(sourceType);
			List result=sourceDao.findSource(sourceName);
			if(null!=result && result.size()>0)
				response=ApplicationConstants.RECORD_ALREADY_EXISTS;
			else
			{	
				sourceDao.saveSource(sourceName);
				response=ApplicationConstants.SUCCESS;
			}	
		}
		catch(Exception e)
		{
			logger.error("Exception in DataManagementServiceImpl - Method saveSourceData():"+e);
			response=ApplicationConstants.FAIL;
		}
		return response;
	}
}
