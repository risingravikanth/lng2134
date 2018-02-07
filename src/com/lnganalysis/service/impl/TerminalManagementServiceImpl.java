package com.lnganalysis.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.lnganalysis.constants.ApplicationConstants;
import com.lnganalysis.dao.domain.DomainDao;
import com.lnganalysis.dao.domain.impl.CompanyOilGasDaoImpl;
import com.lnganalysis.dao.domain.impl.ContractsDaoImpl;
import com.lnganalysis.dao.domain.impl.CrudeOilDaoImpl;
import com.lnganalysis.dao.domain.impl.ExplorationDaoImpl;
import com.lnganalysis.dao.domain.impl.LngDaoImpl;
import com.lnganalysis.dao.domain.impl.NaturalGasDaoImpl;
import com.lnganalysis.dao.domain.impl.PipelineDaoImpl;
import com.lnganalysis.dao.domain.impl.RefineryDaoImpl;
import com.lnganalysis.dao.domain.impl.SmallScaleLngDaoImpl;
import com.lnganalysis.dao.domain.impl.StorageDaoImpl;
import com.lnganalysis.service.TerminalManagementService;

public class TerminalManagementServiceImpl implements TerminalManagementService{
	static final Logger logger=Logger.getLogger(DataManagementServiceImpl.class);
	@Override
	public String deleteData(String domainType, String sourceName) {
		// TODO Auto-generated method stub
		String response=null;
		try
		{
			DomainDao domainDao=getDomainDao(domainType);
			domainDao.delete(sourceName);
			response=ApplicationConstants.SUCCESS;
		}
		catch(Exception e)
		{
			logger.error("Exception in TerminalManagementServiceImpl - Method deleteData():"+e);
			response=ApplicationConstants.FAIL;
		}
		
		return response;
	}
	@Override
	public List<String> readData(String domainType) {
		// TODO Auto-generated method stub
		List<String> terminalsList=null;
		try
		{			
			DomainDao domainDao=getDomainDao(domainType);
			terminalsList=domainDao.readTerminals();	
		}
		catch(Exception e)
		{
			logger.error("Exception in DataManagementServiceImpl - Method readSourceData():"+e);			
		}					
		return terminalsList;
	}
	public DomainDao getDomainDao(String domainType)
	{
		DomainDao domainDao=null;
		if(null!=domainType && ("exploration").equalsIgnoreCase(domainType))
			domainDao=new ExplorationDaoImpl();
		else if(null!=domainType && ("naturalgas").equalsIgnoreCase(domainType))
			domainDao=new NaturalGasDaoImpl();
		else if(null!=domainType && ("crudeoil").equalsIgnoreCase(domainType))
			domainDao=new CrudeOilDaoImpl();
		else if(null!=domainType && ("refinery").equalsIgnoreCase(domainType))
			domainDao=new RefineryDaoImpl();
		else if(null!=domainType && ("storage").equalsIgnoreCase(domainType))
			domainDao=new StorageDaoImpl();
		else if(null!=domainType && ("lng").equalsIgnoreCase(domainType))
			domainDao=new LngDaoImpl();		
		else if(null!=domainType && ("pipeline").equalsIgnoreCase(domainType))
			domainDao=new PipelineDaoImpl();
		else if(null!=domainType && ("contracts").equalsIgnoreCase(domainType))
			domainDao=new ContractsDaoImpl();
		else if(null!=domainType && ("companywise").equalsIgnoreCase(domainType))
			domainDao=new CompanyOilGasDaoImpl();
		else if(null!=domainType && ("smallscalelng").equalsIgnoreCase(domainType))
			domainDao=new SmallScaleLngDaoImpl();
		
		return domainDao;
	}
	

}
