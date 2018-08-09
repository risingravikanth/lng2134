package com.lnganalysis.helper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.lnganalysis.constants.ApplicationConstants;
import com.lnganalysis.entities.domain.CompanyOilGas;
import com.lnganalysis.entities.domain.Contracts;
import com.lnganalysis.entities.domain.CrudeOil;
import com.lnganalysis.entities.domain.Exploration;
import com.lnganalysis.entities.domain.Lng;
import com.lnganalysis.entities.domain.NaturalGas;
import com.lnganalysis.entities.domain.PipeLine;
import com.lnganalysis.entities.domain.Refinery;
import com.lnganalysis.entities.domain.SmallScaleLng;
import com.lnganalysis.entities.domain.Storage;
import com.lnganalysis.entities.domain.SupplyDemand;

public class DataValidationHelper {
    static final Logger logger=Logger.getLogger(DataValidationHelper.class);
    static final String BLANK="";
	public  boolean validateCountries(Object domainObject,List<String> countriesList)throws Exception
	{
		logger.info("Class - DataValidationHelper - validateCountries()");
		if(domainObject instanceof Exploration)
		{
			boolean flag=false;
			Exploration exploration=(Exploration)domainObject;
			if(null!=exploration.getCountry() && !(BLANK).equalsIgnoreCase(exploration.getCountry()))
			{
				for(int i=0;i<countriesList.size();i++)
				{
					if(exploration.getCountry().equalsIgnoreCase(countriesList.get(i)))
						flag=true;					
				}
				return flag;
			}							   			    			
			
		}
		if(domainObject instanceof CrudeOil)
		{
			boolean flag=false;
			CrudeOil crudeOil=(CrudeOil)domainObject;
			if(null!=crudeOil.getCountry() && !(BLANK).equalsIgnoreCase(crudeOil.getCountry()))
			{
				for(int i=0;i<countriesList.size();i++)
				{
					if(crudeOil.getCountry().equalsIgnoreCase(countriesList.get(i)))
						flag=true;					
				}
				return flag;
			}								
		}
		if(domainObject instanceof NaturalGas)
		{
			boolean flag=false;
			NaturalGas naturalGas=(NaturalGas)domainObject;
			if(null!=naturalGas.getCountry() && !(BLANK).equalsIgnoreCase(naturalGas.getCountry()))
			{
				for(int i=0;i<countriesList.size();i++)
				{
					if(naturalGas.getCountry().equalsIgnoreCase(countriesList.get(i)))
						flag=true;					
				}
				return flag;
			}
			
			
		}
		if(domainObject instanceof Refinery)
		{
			boolean flag=false;
			Refinery refinery=(Refinery)domainObject;
			if(null!=refinery.getCountry() && !(BLANK).equalsIgnoreCase(refinery.getCountry()))
			{
				for(int i=0;i<countriesList.size();i++)
				{
					if(refinery.getCountry().equalsIgnoreCase(countriesList.get(i)))
						flag=true;					
				}
				return flag;
			}
			
		
		}
		if(domainObject instanceof Storage)
		{
			boolean flag=false;
			Storage storage=(Storage)domainObject;
			if(null!=storage.getCountry() && !(BLANK).equalsIgnoreCase(storage.getCountry()))
			{
				for(int i=0;i<countriesList.size();i++)
				{
					if(storage.getCountry().equalsIgnoreCase(countriesList.get(i)))
						flag=true;					
				}
				return flag;
			}
			
		
		}
		if(domainObject instanceof Lng)
		{
			boolean flag=false;
			Lng lng=(Lng)domainObject;
			if(null!=lng.getCountry() && !(BLANK).equalsIgnoreCase(lng.getCountry()))
			{
				for(int i=0;i<countriesList.size();i++)
				{
					if(lng.getCountry().equalsIgnoreCase(countriesList.get(i)))
						flag=true;					
				}
				return flag;
			}
						
		}
		if(domainObject instanceof PipeLine)
		{
			boolean flag=false;
			PipeLine pipeLine=(PipeLine)domainObject;
			if(null!=pipeLine.getCountry() && !(BLANK).equalsIgnoreCase(pipeLine.getCountry()))
			{
				for(int i=0;i<countriesList.size();i++)
				{
					if(pipeLine.getCountry().equalsIgnoreCase(countriesList.get(i)))
						flag=true;					
				}
				return flag;
			}
						
		}
		if(domainObject instanceof SupplyDemand)
		{
			boolean flag=false;
			SupplyDemand supplyDemand=(SupplyDemand)domainObject;
			if(null!=supplyDemand.getCountry() && !(BLANK).equalsIgnoreCase(supplyDemand.getCountry()))
			{
				for(int i=0;i<countriesList.size();i++)
				{
					if(supplyDemand.getCountry().equalsIgnoreCase(countriesList.get(i)))
						flag=true;					
				}
				return flag;
			}
						
		}
		if(domainObject instanceof CompanyOilGas)
		{
			boolean flag=false;
			CompanyOilGas cog=(CompanyOilGas)domainObject;
			if(null!=cog.getCountry() && !(BLANK).equalsIgnoreCase(cog.getCountry()))
			{
				for(int i=0;i<countriesList.size();i++)
				{
					if(cog.getCountry().equalsIgnoreCase(countriesList.get(i)))
						flag=true;					
				}
				return flag;
			}
		}
		if(domainObject instanceof SmallScaleLng)
		{
			boolean flag=false;
			SmallScaleLng ssl=(SmallScaleLng)domainObject;
			if(null!=ssl.getCountry() && !(BLANK).equalsIgnoreCase(ssl.getCountry()))
			{
				for(int i=0;i<countriesList.size();i++)
				{
					if(ssl.getCountry().equalsIgnoreCase(countriesList.get(i)))
						flag=true;					
				}
				return flag;
			}
		}
		return true;// If above all is not satisfied that means the condition in called method should not be true
	}
	public boolean validateCountries(Object domainObject,List<String> countriesList,String countryType)
	{
		logger.info("Class - DataValidationHelper - validateCountries() override  method");
		if(domainObject instanceof Contracts)
		{
			boolean flag=false;
			Contracts contracts=(Contracts)domainObject;
			if(null!=countryType && "export".equalsIgnoreCase(countryType))
			{
				if(null!=contracts.getExportCountry() && !(BLANK).equalsIgnoreCase(contracts.getExportCountry()))
				{
					for(int i=0;i<countriesList.size();i++)
					{
						if(contracts.getExportCountry().equalsIgnoreCase(countriesList.get(i)))
							flag=true;					
					}
					return flag;
				}
			}
			else
			{
				if(null!=contracts.getImportCountry() && !(BLANK).equalsIgnoreCase(contracts.getImportCountry()))
				{
					for(int i=0;i<countriesList.size();i++)
					{
						if(contracts.getImportCountry().equalsIgnoreCase(countriesList.get(i)))
							flag=true;					
					}
					return flag;
				}
			}
			
						
		}
		return true;
	}
	public boolean validateRegion(Object domainObject,List<String> regionList)throws Exception
	{
		logger.info("Class - DataValidationHelper - validateRegion()");
		if(domainObject instanceof Exploration)
		{
			boolean flag=false;
			Exploration exploration=(Exploration)domainObject;
			if(null!=exploration.getRegion() && !(BLANK).equalsIgnoreCase(exploration.getRegion()))
			{
				for(int i=0;i<regionList.size();i++)
				{
					if(exploration.getRegion().equalsIgnoreCase(regionList.get(i)))
						flag=true;					
				}
				return flag;
			}						
		}
		if(domainObject instanceof CrudeOil)
		{
			boolean flag=false;
			CrudeOil crudeOil=(CrudeOil)domainObject;
			if(null!=crudeOil.getRegion() && !(BLANK).equalsIgnoreCase(crudeOil.getRegion()))
			{
				for(int i=0;i<regionList.size();i++)
				{
					if(crudeOil.getRegion().equalsIgnoreCase(regionList.get(i)))
						flag=true;					
				}
				return flag;
			}					
		}
		if(domainObject instanceof NaturalGas)
		{
			boolean flag=false;
			NaturalGas naturalGas=(NaturalGas)domainObject;
			if(null!=naturalGas.getRegion() && !(BLANK).equalsIgnoreCase(naturalGas.getRegion()))
			{
				for(int i=0;i<regionList.size();i++)
				{
					if(naturalGas.getRegion().trim().equalsIgnoreCase(regionList.get(i)))
						flag=true;					
				}
				return flag;
			}
						
		}
		if(domainObject instanceof Refinery)
		{
			boolean flag=false;
			Refinery refinery=(Refinery)domainObject;
			if(null!=refinery.getRegion() && !(BLANK).equalsIgnoreCase(refinery.getRegion()))
			{
				for(int i=0;i<regionList.size();i++)
				{
					if(refinery.getRegion().equalsIgnoreCase(regionList.get(i)))
						flag=true;					
				}
				return flag;
			}
			
		
		}
		if(domainObject instanceof Storage)
		{
			boolean flag=false;
			Storage storage=(Storage)domainObject;
			if(null!=storage.getRegion() && !(BLANK).equalsIgnoreCase(storage.getRegion()))
			{
				for(int i=0;i<regionList.size();i++)
				{
					if(storage.getRegion().equalsIgnoreCase(regionList.get(i)))
						flag=true;					
				}
				return flag;
			}
			
		
		}
		if(domainObject instanceof Lng)
		{
			boolean flag=false;
			Lng lng=(Lng)domainObject;
			if(null!=lng.getRegion() && !(BLANK).equalsIgnoreCase(lng.getRegion()))
			{
				for(int i=0;i<regionList.size();i++)
				{
					if(lng.getRegion().equalsIgnoreCase(regionList.get(i)))
						flag=true;					
				}
				return flag;
			}
					
		}
		if(domainObject instanceof PipeLine)
		{
			boolean flag=false;
			PipeLine pipeLine=(PipeLine)domainObject;
			if(null!=pipeLine.getRegion() && !(BLANK).equalsIgnoreCase(pipeLine.getRegion()))
			{
				for(int i=0;i<regionList.size();i++)
				{
					if(pipeLine.getRegion().equalsIgnoreCase(regionList.get(i)))
						flag=true;					
				}
				return flag;
			}
					
		}
		if(domainObject instanceof SupplyDemand)
		{
			boolean flag=false;
			SupplyDemand supplyDemand=(SupplyDemand)domainObject;
			if(null!=supplyDemand.getRegion() && !(BLANK).equalsIgnoreCase(supplyDemand.getRegion()))
			{
				for(int i=0;i<regionList.size();i++)
				{
					if(supplyDemand.getRegion().equalsIgnoreCase(regionList.get(i)))
						flag=true;					
				}
				return flag;
			}
					
		}
		if(domainObject instanceof CompanyOilGas)
		{
			boolean flag=false;
			CompanyOilGas cog=(CompanyOilGas)domainObject;
			if(null!=cog.getRegion() && !(BLANK).equalsIgnoreCase(cog.getRegion()))
			{
				for(int i=0;i<regionList.size();i++)
				{
					if(cog.getRegion().equalsIgnoreCase(regionList.get(i)))
						flag=true;					
				}
				return flag;
			}
					
		}
		return true;// If above all is not satisfied that means the condition in called method should not be true
	}
	public boolean validateLngType(Lng lng)
	{
		logger.info("Class - DataValidationHelper - validateLngType()");
//			Lng lng=(Lng)domainObject;
			if(null!=lng.getType() && !(BLANK).equalsIgnoreCase(lng.getType()))
				return (lng.getType().equalsIgnoreCase(ApplicationConstants.LIQUEFACTION) || lng.getType().equalsIgnoreCase(ApplicationConstants.REGASIFICATION));
			
			return true;
		
	}
	public boolean validateStatus(Object domainObject,List<String> statusList)throws Exception
	{		
		logger.info("Class - DataValidationHelper - validateStatus()");
		if(domainObject instanceof Exploration)
		{
			boolean flag=false;
			Exploration exploration=(Exploration)domainObject;
			if(null!=exploration.getStatus() && !(BLANK).equalsIgnoreCase(exploration.getStatus()))
			{
				for(int i=0;i<statusList.size();i++)
				{
					if(exploration.getStatus().equalsIgnoreCase(statusList.get(i)))
						flag=true;					
				}
				return flag;
			}
			
			
		}
		if(domainObject instanceof CrudeOil)
		{
			boolean flag=false;
			CrudeOil crudeOil=(CrudeOil)domainObject;
			if(null!=crudeOil.getStatus() && !(BLANK).equalsIgnoreCase(crudeOil.getStatus()))
			{
				for(int i=0;i<statusList.size();i++)
				{
					if(crudeOil.getStatus().equalsIgnoreCase(statusList.get(i)))
						flag=true;					
				}
				return flag;
			}					
		}
		if(domainObject instanceof NaturalGas)
		{
			boolean flag=false;
			NaturalGas naturalGas=(NaturalGas)domainObject;
			if(null!=naturalGas.getStatus() && !(BLANK).equalsIgnoreCase(naturalGas.getStatus()))
			{
				for(int i=0;i<statusList.size();i++)
				{
					if(naturalGas.getStatus().equalsIgnoreCase(statusList.get(i)))
						flag=true;					
				}
				return flag;
			}
			
			
		}
		if(domainObject instanceof Refinery)
		{
			boolean flag=false;
			Refinery refinery=(Refinery)domainObject;
			if(null!=refinery.getStatus() && !(BLANK).equalsIgnoreCase(refinery.getStatus()))
			{
				for(int i=0;i<statusList.size();i++)
				{
					if(refinery.getStatus().equalsIgnoreCase(statusList.get(i)))
						flag=true;					
				}
				return flag;
			}
			
		
		}
		if(domainObject instanceof Storage)
		{
			boolean flag=false;
			Storage storage=(Storage)domainObject;
			if(null!=storage.getStatus() && !(BLANK).equalsIgnoreCase(storage.getStatus()))
			{
				for(int i=0;i<statusList.size();i++)
				{
					if(storage.getStatus().equalsIgnoreCase(statusList.get(i)))
						flag=true;					
				}
				return flag;
				
			}
			
		}
		if(domainObject instanceof Lng)
		{
			boolean flag=false;
			Lng lng=(Lng)domainObject;
			if(null!=lng.getStatus() && !(BLANK).equalsIgnoreCase(lng.getStatus()))
			{
				for(int i=0;i<statusList.size();i++)
				{
					if(lng.getStatus().equalsIgnoreCase(statusList.get(i)))
						flag=true;					
				}
				return flag;
			}
						
		}
		if(domainObject instanceof PipeLine)
		{
			boolean flag=false;
			PipeLine pipeLine=(PipeLine)domainObject;
			if(null!=pipeLine.getStatus() && !(BLANK).equalsIgnoreCase(pipeLine.getStatus()))
			{
				for(int i=0;i<statusList.size();i++)
				{
					if(pipeLine.getStatus().equalsIgnoreCase(statusList.get(i)))
						flag=true;					
				}
				return flag;
			}
						
		}
		if(domainObject instanceof SmallScaleLng)
		{
			boolean flag=false;
			SmallScaleLng smallScaleLng=(SmallScaleLng)domainObject;
			if(null!=smallScaleLng.getStatus() && !(BLANK).equalsIgnoreCase(smallScaleLng.getStatus()))
			{
				for(int i=0;i<statusList.size();i++)
				{
					if(smallScaleLng.getStatus().equalsIgnoreCase(statusList.get(i)))
						flag=true;					
				}
				return flag;
			}
						
		}
		return true;// If above all is not satisfied that means the condition in called method should not be true
	}
	public boolean validateOperator(Object domainObject,List<String> singleSourceList)throws Exception
	{
		logger.info("Class - DataValidationHelper - validateOperator()");
		if(domainObject instanceof Exploration)
		{
			boolean flag=false;
			Exploration exploration=(Exploration)domainObject;
			if(null!=exploration.getOperator() && !(BLANK).equalsIgnoreCase(exploration.getOperator()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(exploration.getOperator().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;					
				}
				return flag;
			}					
		}
//		if(domainObject instanceof CrudeOil)
//		{
//			
//		
//		}
//		if(domainObject instanceof NaturalGas)
//		{
//			
//			
//		}
//		if(domainObject instanceof Refinery)
//		{
//		
//		
//		}
//		if(domainObject instanceof Storage)
//		{
//			
//		
//		}
//		if(domainObject instanceof Lng)
//		{
//						
//		}
		if(domainObject instanceof PipeLine)
		{
			boolean flag=false;
			PipeLine pipeLine=(PipeLine)domainObject;
			if(null!=pipeLine.getOperator() && !(BLANK).equalsIgnoreCase(pipeLine.getOperator()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(pipeLine.getOperator().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;
				}
				return flag;
			}
		}
		
		return true;// If above all is not satisfied that means the condition in called method should not be true
	}
	// SmallScaleLng column
	public boolean validateTechnologyProviderCompany(SmallScaleLng ssl,List<String> singleSourceList)
	{
		boolean flag=false;
		
		if(null!=ssl.getTechnologyProviderCompany() && !(BLANK).equalsIgnoreCase(ssl.getTechnologyProviderCompany()))
		{
			for(int i=0;i<singleSourceList.size();i++)
			{
				if(ssl.getTechnologyProviderCompany().equalsIgnoreCase(singleSourceList.get(i)))
					flag=true;
			}
			return flag;
		}
		return true;
	}
	//SmallScaleLng column
	public boolean validateCompany(SmallScaleLng ssl,List<String> singleSourceList)
	{
		boolean flag=false;
		
		if(null!=ssl.getCompany() && !(BLANK).equalsIgnoreCase(ssl.getCompany()))
		{
			for(int i=0;i<singleSourceList.size();i++)
			{
				if(ssl.getCompany().equalsIgnoreCase(singleSourceList.get(i)))
					flag=true;
			}
			return flag;
		}
		return true;
	}
	public boolean validateType(Object domainObject,List<String> typeList)throws Exception
	{
		logger.info("Class - DataValidationHelper - validateType()");
		if(domainObject instanceof Refinery)
		{
			boolean flag=false;
			Refinery refinery=(Refinery)domainObject;
			if(null!=refinery.getType() && !(BLANK).equalsIgnoreCase(refinery.getType()))
			{
				for(int i=0;i<typeList.size();i++)
				{
					if(refinery.getType().equalsIgnoreCase(typeList.get(i)))
						flag=true;
				}
				return flag;
			}
		}
		if(domainObject instanceof SmallScaleLng)
		{
			boolean flag=false;
			SmallScaleLng smallScaleLng=(SmallScaleLng)domainObject;
			if(null!=smallScaleLng.getType() && !(BLANK).equalsIgnoreCase(smallScaleLng.getType()))
			{
				for(int i=0;i<typeList.size();i++)
				{
					if(smallScaleLng.getType().equalsIgnoreCase(typeList.get(i)))
						flag=true;
				}
				return flag;
			}
		}
		return true;//If above all is not satisfied that means the condition in called method should not be true
	}
	public boolean validateCurrentOperator(Object domainObject,List<String> singleSourceList)throws Exception
	{
		logger.info("Class - DataValidationHelper - validateCurrentOperator()");
		if(domainObject instanceof Refinery)
		{
			boolean flag=false;
			Refinery refinery=(Refinery)domainObject;
			if(null!=refinery.getCurrentOperator() && !(BLANK).equalsIgnoreCase(refinery.getCurrentOperator()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(refinery.getCurrentOperator().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;
				}
				return flag;
			}
		}
		if(domainObject instanceof Storage)
		{
			boolean flag=false;
			Storage storage=(Storage)domainObject;
			if(null!=storage.getCurrentOperator() && !(BLANK).equalsIgnoreCase(storage.getCurrentOperator()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(storage.getCurrentOperator().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;
				}
				return flag;
			}
		}
		// This is for operator column in Lng
		if(domainObject instanceof Lng)
		{
			boolean flag=false;
			Lng lng=(Lng)domainObject;
			if(null!=lng.getOperator() && !(BLANK).equalsIgnoreCase(lng.getOperator()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(lng.getOperator().equalsIgnoreCase(singleSourceList.get(i)))
							flag=true;
				}
				return flag;
			}
		}
		if(domainObject instanceof CrudeOil)
		{
			boolean flag=false;
			CrudeOil crudeOil=(CrudeOil)domainObject;
			if(null!=crudeOil.getCurrentOperator() && !(BLANK).equalsIgnoreCase(crudeOil.getCurrentOperator()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(crudeOil.getCurrentOperator().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;
				}
				return flag;
			}
		}
		if(domainObject instanceof NaturalGas)
		{
			boolean flag=false;
			NaturalGas naturalGas=(NaturalGas)domainObject;
			if(null!=naturalGas.getCurrentOperator() && !(BLANK).equalsIgnoreCase(naturalGas.getCurrentOperator()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(naturalGas.getCurrentOperator().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;
				}
				return flag;
			}
		}
		return true;//If above all is not satisfied that means the condition in called method should not be true
	}
	public boolean validateCurrentOwners(Object domainObject,List<String> singleSourceList)throws Exception
	{
		logger.info("Class - DataValidationHelper - validateCurrentOwners()");
		if(domainObject instanceof Storage)
		{
			boolean flag=false;
			Storage storage=(Storage)domainObject;
			if(null!=storage.getCurrentOwners() && !(BLANK).equalsIgnoreCase(storage.getCurrentOwners()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(storage.getCurrentOwners().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;
				}
				return flag;
			}
		}
		if(domainObject instanceof CrudeOil)
		{
			boolean flag=false;
			CrudeOil crudeOil=(CrudeOil)domainObject;
			if(null!=crudeOil.getCurrentOwners() && !(BLANK).equalsIgnoreCase(crudeOil.getCurrentOwners()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(crudeOil.getCurrentOwners().trim().equalsIgnoreCase(singleSourceList.get(i)))	
						flag=true;
				}
				
				return flag;
			}
		}
		if(domainObject instanceof NaturalGas)
		{
			boolean flag=false;
			NaturalGas naturalGas=(NaturalGas)domainObject;
			if(null!=naturalGas.getCurrentOwners() && !(BLANK).equalsIgnoreCase(naturalGas.getCurrentOwners()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(naturalGas.getCurrentOwners().trim().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;
				}
				return flag;
			}
		}
		if(domainObject instanceof CompanyOilGas)
		{
			boolean flag=false;
			CompanyOilGas companyOilGas=(CompanyOilGas)domainObject;
			if(null!=companyOilGas.getName() && !(BLANK).equalsIgnoreCase(companyOilGas.getName()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(companyOilGas.getName().trim().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;
				}
				return flag;
			}
		}
		return true;//If above all is not satisfied that means the condition in called method should not be true
	}
	public boolean validateCurrentEquityPartners(Object domainObject,List<String> singleSourceList)throws Exception
	{
		logger.info("Class - DataValidationHelper - validateCurrentEquityPartners()");
		if(domainObject instanceof Refinery)
		{
			boolean flag=false;
			Refinery refinery=(Refinery)domainObject;
			if(null!=refinery.getCurrentEquityPartners() && !(BLANK).equalsIgnoreCase(refinery.getCurrentEquityPartners()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(refinery.getCurrentEquityPartners().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;
				}
				return flag;
			}
		}
		if(domainObject instanceof Lng)
		{
			boolean flag=false;
			Lng lng=(Lng)domainObject;
			if(null!=lng.getEquityPartners() && !(BLANK).equalsIgnoreCase(lng.getEquityPartners()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(lng.getEquityPartners().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;
				}
				return flag;
			}
		}
		
		return true;//If above all is not satisfied that means the condition in called method should not be true
		
	}
	public boolean validateHistoricEquityPartners(Object domainObject,List<String> singleSourceList)throws Exception
	{		
		logger.info("Class - DataValidationHelper - validateHistoricEquityPartners()");
		if(domainObject instanceof Refinery)
		{
			boolean flag=false;
			Refinery refinery=(Refinery)domainObject;
			if(null!=refinery.getHistoricEquityPartners() && !(BLANK).equalsIgnoreCase(refinery.getHistoricEquityPartners()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(refinery.getHistoricEquityPartners().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;
				}
				return flag;
			}
		}
		if(domainObject instanceof Lng)
		{
			boolean flag=false;
			Lng lng=(Lng)domainObject;
			if(null!=lng.getHistoricEquityPartner() && !(BLANK).equalsIgnoreCase(lng.getHistoricEquityPartner()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(lng.getHistoricEquityPartner().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;
				}
				return flag;
			}
			
		}
		
		return true;//If above all is not satisfied that means the condition in called method should not be true
	}
	public boolean validateHistoricOperator(Object domainObject,List<String> singleSourceList)throws Exception
	{
		logger.info("Class - DataValidationHelper - validateHistoricOperator()");
		if(domainObject instanceof Refinery)
		{
			boolean flag=false;
			Refinery refinery=(Refinery)domainObject;
			if(null!=refinery.getHistoricOperator() && !(BLANK).equalsIgnoreCase(refinery.getHistoricOperator()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(refinery.getHistoricOperator().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;
				}
				return flag;
			}
		}
		if(domainObject instanceof Storage)
		{
			boolean flag=false;
			Storage storage=(Storage)domainObject;
			if(null!=storage.getHistoricOperator() && !(BLANK).equalsIgnoreCase(storage.getHistoricOperator()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(storage.getHistoricOperator().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;
				}
				return flag;
			}
		}
		if(domainObject instanceof Lng)
		{
			boolean flag=false;
			Lng lng=(Lng)domainObject;
			if(null!=lng.getHistoricOperator() && !(BLANK).equalsIgnoreCase(lng.getHistoricOperator()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(lng.getHistoricOperator().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;
				}
				return flag;
			}
		}
		if(domainObject instanceof CrudeOil)
		{
			boolean flag=false;
			CrudeOil crudeOil=(CrudeOil)domainObject;
			if(null!=crudeOil.getHistoricOperator() && !(BLANK).equalsIgnoreCase(crudeOil.getHistoricOperator()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(crudeOil.getHistoricOperator().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;
				}
				return flag;
			}
		}
		if(domainObject instanceof NaturalGas)
		{
			boolean flag=false;
			NaturalGas naturalGas=(NaturalGas)domainObject;
			if(null!=naturalGas.getHistoricOperator() && !(BLANK).equalsIgnoreCase(naturalGas.getHistoricOperator()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(naturalGas.getHistoricOperator().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;
				}
				return flag;
			}
		}
		return true;//If above all is not satisfied that means the condition in called method should not be true
	}
	public boolean validateHistoricOwners(Object domainObject,List<String> singleSourceList)throws Exception
	{
		logger.info("Class - DataValidationHelper - validateHistoricOwners()");
		if(domainObject instanceof Storage)
		{
			boolean flag=false;
			Storage storage=(Storage)domainObject;
			if(null!=storage.getHistoricOwners() && !(BLANK).equalsIgnoreCase(storage.getHistoricOwners()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(storage.getHistoricOwners().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;
				}
				return flag;
			}
		}
		if(domainObject instanceof CrudeOil)
		{
			boolean flag=false;
			CrudeOil crudeOil=(CrudeOil)domainObject;
			if(null!=crudeOil.getHistoricOwners() && !(BLANK).equalsIgnoreCase(crudeOil.getHistoricOwners()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(crudeOil.getHistoricOwners().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;					
				}
				return flag;
			}
		}
		if(domainObject instanceof NaturalGas)
		{
			boolean flag=false;
			NaturalGas naturalGas=(NaturalGas)domainObject;
			if(null!=naturalGas.getHistoricOwners() && !(BLANK).equalsIgnoreCase(naturalGas.getHistoricOwners()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(naturalGas.getHistoricOwners().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;					
				}
				return flag;
			}
		}
		return true;//If above all is not satisfied that means the condition in called method should not be true
	}
	public boolean validateEquityPartners(Object domainObject,List<String> singleSourceList)throws Exception
	{
		logger.info("Class - DataValidationHelper - validateEquityPartners()");
		if(domainObject instanceof Exploration)
		{
			boolean flag=false;
			Exploration exploration=(Exploration)domainObject;
			if(null!=exploration.getEquityPartners() && !(BLANK).equalsIgnoreCase(exploration.getEquityPartners()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(exploration.getEquityPartners().equalsIgnoreCase(singleSourceList.get(i)))
							flag=true;										
				}
				return flag;
			}						
		}
		if(domainObject instanceof PipeLine)
		{
			boolean flag=false;
			PipeLine pipeLine=(PipeLine)domainObject;
			if(null!=pipeLine.getEquityPartners() && !(BLANK).equalsIgnoreCase(pipeLine.getEquityPartners()))
			{
				for(int i=0;i<singleSourceList.size();i++)
				{
					if(pipeLine.getEquityPartners().equalsIgnoreCase(singleSourceList.get(i)))
						flag=true;
				}
				return flag;
			}
		}
		return true;// If above all is not satisfied that means the condition in called method should not be true
	}
	public boolean validateEquityStakes(Object domainObject,List list,Set<String> tracker)
	{
		logger.info("Class - DataValidationHelper - validateEquityStakes()");
		double totalEquityStakes=0;	
		if(domainObject instanceof PipeLine)
		{
			PipeLine pipeLineDomainObject=(PipeLine)domainObject;
					if(!tracker.contains(pipeLineDomainObject.getPipeline()))
					{
						for(int j=0;j<list.size();j++)
						{
							PipeLine pipeLine=(PipeLine)list.get(j);
							if(pipeLineDomainObject.getPipeline().equalsIgnoreCase(pipeLine.getPipeline()))
							{
								totalEquityStakes=totalEquityStakes+pipeLine.getEquityStakes();
							}
						}
						if(round(totalEquityStakes)==100)	
						{	
							tracker.add(pipeLineDomainObject.getPipeline());
							return true;
						}	
						else
							return false;
							
					}													
			
		  }	
		if(domainObject instanceof Lng)
		{
			Lng lngDomainObject=(Lng)domainObject;
					if(!tracker.contains(lngDomainObject.getName()))
					{
						for(int j=0;j<list.size();j++)
						{
							Lng lng=(Lng)list.get(j);
							if(lngDomainObject.getName().equalsIgnoreCase(lng.getName()))
							{
								totalEquityStakes=totalEquityStakes+lng.getEquityStakes();
							}
						}
						if(round(totalEquityStakes)==100)	
						{	
							tracker.add(lngDomainObject.getName());
							return true;
						}	
						else
							return false;
							
					}													
			
		  }	
		if(domainObject instanceof Refinery)
		{
			Refinery refineryDomainObject=(Refinery)domainObject;
					if(!tracker.contains(refineryDomainObject.getName()))
					{
						for(int j=0;j<list.size();j++)
						{
							Refinery refinery=(Refinery)list.get(j);
							if(refineryDomainObject.getName().equalsIgnoreCase(refinery.getName()))
							{
								totalEquityStakes=totalEquityStakes+refinery.getCurrentEquityStakes();
							}
						}
						if(round(totalEquityStakes)==100)	
						{	
							tracker.add(refineryDomainObject.getName());
							return true;
						}	
						else
							return false;
							
					}													
			
		  }	
		return true;// If above all is not satisfied that means the condition in called method should not be true
	}
	public boolean validateHistoricEquityStakes(Object domainObject,List list,Set<String> tracker)
	{
		logger.info("Class - DataValidationHelper - validateHistoricEquityStakes()");
		double totalHistoricEquityStakes=0;
		
		if(domainObject instanceof Lng)
		{
			
			Lng lngDomainObject=(Lng)domainObject;
//				if(0.0!=lngDomainObject.getHistoricEquityStake())
//				{
					if(!tracker.contains(lngDomainObject.getName()))
					{
						for(int j=0;j<list.size();j++)
						{
							Lng lng=(Lng)list.get(j);
							if(lngDomainObject.getName().equalsIgnoreCase(lng.getName()))
							{
								totalHistoricEquityStakes=totalHistoricEquityStakes+lng.getHistoricEquityStake();
							}
						}
						if(round(totalHistoricEquityStakes)==100)	
						{	
							tracker.add(lngDomainObject.getName());
							return true;
						}	
						else
							return false;
							
					}		
//				}
																
			
		  }	
		if(domainObject instanceof Refinery)
		{
			Refinery refineryDomainObject=(Refinery)domainObject;
			if(0.0!=refineryDomainObject.getHistoricEquityStakes())
			{
					if(!tracker.contains(refineryDomainObject.getName()))
					{
						for(int j=0;j<list.size();j++)
						{
							Refinery refinery=(Refinery)list.get(j);
							if(refineryDomainObject.getName().equalsIgnoreCase(refinery.getName()))
							{
								totalHistoricEquityStakes=totalHistoricEquityStakes+refinery.getHistoricEquityStakes();
							}
						}
						if(round(totalHistoricEquityStakes)==100)	
						{	
							tracker.add(refineryDomainObject.getName());
							return true;
						}	
						else
							return false;
							
					}	
			}		
			
		  }	
		return true;
	}
	public boolean validateCurrentOwnerShip(Object domainObject,List list,Set<String> tracker)
	{
		logger.info("Class - DataValidationHelper - validateCurrentOwnerShip()");
		double totalCurrentOwnerShip=0;	
		if(domainObject instanceof Storage)
		{
			Storage storageDomainObject=(Storage)domainObject;
			
				if(!tracker.contains(storageDomainObject.getTankFarm()))
				{
							for(int j=0;j<list.size();j++)
							{
								Storage storage=(Storage)list.get(j);
								if(storageDomainObject.getTankFarm().equalsIgnoreCase(storage.getTankFarm()))
								{
									totalCurrentOwnerShip=totalCurrentOwnerShip+storage.getCurrentOwnership();
								}
							}
							if(round(totalCurrentOwnerShip)==100)	
							{	
								tracker.add(storageDomainObject.getTankFarm());
								return true;
							}	
							else
								return false;
								
				}													
				
			  
		}
		if(domainObject instanceof CrudeOil)
		{
			CrudeOil crudeOilDomainObject=(CrudeOil)domainObject;
			
				if(!tracker.contains(crudeOilDomainObject.getField()))
				{
							for(int j=0;j<list.size();j++)
							{
								CrudeOil crudeOil=(CrudeOil)list.get(j);
								if(crudeOilDomainObject.getField().equalsIgnoreCase(crudeOil.getField()))
								{
									totalCurrentOwnerShip=totalCurrentOwnerShip+crudeOil.getCurrentOwnership();
								}
							}
							if(round(totalCurrentOwnerShip)==100)	
							{	
								tracker.add(crudeOilDomainObject.getField());
								return true;
							}	
							else
								return false;
								
				}													
				
			  
		}
		if(domainObject instanceof NaturalGas)
		{
			NaturalGas naturalGasDomainObject=(NaturalGas)domainObject;
			
				if(!tracker.contains(naturalGasDomainObject.getField()))
				{
							for(int j=0;j<list.size();j++)
							{
								NaturalGas naturalGas=(NaturalGas)list.get(j);
								if(naturalGasDomainObject.getField().equalsIgnoreCase(naturalGas.getField()))
								{
									totalCurrentOwnerShip=totalCurrentOwnerShip+naturalGas.getCurrentOwnership();
								}
							}
							if(round(totalCurrentOwnerShip)==100)	
							{	
								tracker.add(naturalGasDomainObject.getField());
								return true;
							}	
							else
								return false;
								
				}																
			  
		}
		return true;// If above all is not satisfied that means the condition in called method should not be true
	}
	public boolean validateHistoricOwnerShip(Object domainObject,List list,Set<String> tracker)
	{
		logger.info("Class - DataValidationHelper - validateHistoricOwnerShip()");
		double totalHistoricOwnerShip=0;	
		if(domainObject instanceof Storage)
		{
			Storage storageDomainObject=(Storage)domainObject;
				if(0.0!=storageDomainObject.getHistoricOwnership())
				{
					if(!tracker.contains(storageDomainObject.getTankFarm()))
					{
								for(int j=0;j<list.size();j++)
								{
									Storage storage=(Storage)list.get(j);
									if(storageDomainObject.getTankFarm().equalsIgnoreCase(storage.getTankFarm()))
									{
										totalHistoricOwnerShip=totalHistoricOwnerShip+storage.getHistoricOwnership();
									}
								}
								if(round(totalHistoricOwnerShip)==100)	
								{	
									tracker.add(storageDomainObject.getTankFarm());
									return true;
								}	
								else
									return false;
									
					}		
				}																		
			  
		}
		if(domainObject instanceof CrudeOil)
		{
			CrudeOil crudeOilDomainObject=(CrudeOil)domainObject;
				if(0.0!=crudeOilDomainObject.getHistoricOwnership())
				{
					if(!tracker.contains(crudeOilDomainObject.getField()))
					{
								for(int j=0;j<list.size();j++)
								{
									CrudeOil crudeOil=(CrudeOil)list.get(j);
									if(crudeOilDomainObject.getField().equalsIgnoreCase(crudeOil.getField()))
									{
										totalHistoricOwnerShip=totalHistoricOwnerShip+crudeOil.getHistoricOwnership();
									}
								}
								if(round(totalHistoricOwnerShip)==100)	
								{	
									tracker.add(crudeOilDomainObject.getField());
									return true;
								}	
								else
									return false;
									
					}			
				}
																					  
		}
		if(domainObject instanceof NaturalGas)
		{
			NaturalGas naturalGasDomainObject=(NaturalGas)domainObject;
				if(0.0!=naturalGasDomainObject.getHistoricOwnership())
				{
					if(!tracker.contains(naturalGasDomainObject.getField()))
					{
								for(int j=0;j<list.size();j++)
								{
									NaturalGas naturalGas=(NaturalGas)list.get(j);
									if(naturalGasDomainObject.getField().equalsIgnoreCase(naturalGas.getField()))
									{
										totalHistoricOwnerShip=totalHistoricOwnerShip+naturalGas.getHistoricOwnership();
									}
								}
								if(round(totalHistoricOwnerShip)==100)	
								{	
									tracker.add(naturalGasDomainObject.getField());
									return true;
								}	
								else
									return false;
									
					}		
				}
																			
			  
		}
		return true;// If above all is not satisfied that means the condition in called method should not be true
	}
	
	public boolean validateOnShoreOrOffshore(Object domainObject)
	{
		logger.info("Class - DataValidationHelper - validateOnShoreOrOffshore()");
		if(domainObject instanceof Exploration)
		{
			Exploration exploration=(Exploration)domainObject;
			if(null!=exploration.getOnShoreOrOffShore() && !(BLANK).equalsIgnoreCase(exploration.getOnShoreOrOffShore()))
			return (exploration.getOnShoreOrOffShore().equalsIgnoreCase(ApplicationConstants.ONSHORE) || exploration.getOnShoreOrOffShore().equalsIgnoreCase(ApplicationConstants.OFFSHORE));
				
		}
		if(domainObject instanceof CrudeOil)
		{
			CrudeOil crudeOil=(CrudeOil)domainObject;
			if(null!=crudeOil.getOnshoreOrOffshore() && !(BLANK).equalsIgnoreCase(crudeOil.getOnshoreOrOffshore()))
			return (crudeOil.getOnshoreOrOffshore().equalsIgnoreCase(ApplicationConstants.ONSHORE) || crudeOil.getOnshoreOrOffshore().equalsIgnoreCase(ApplicationConstants.OFFSHORE));
		
		}
		if(domainObject instanceof NaturalGas)
		{
			NaturalGas naturalGas=(NaturalGas)domainObject;
			if(null!=naturalGas.getOnshoreOrOffshore() && !(BLANK).equalsIgnoreCase(naturalGas.getOnshoreOrOffshore()))
			return (naturalGas.getOnshoreOrOffshore().equalsIgnoreCase(ApplicationConstants.ONSHORE) || naturalGas.getOnshoreOrOffshore().equalsIgnoreCase(ApplicationConstants.OFFSHORE));
			
		}
//		if(domainObject instanceof Refinery)
//		{
//			Refinery refinery=(Refinery)domainObject;
//			
//		
//		}
//		if(domainObject instanceof Storage)
//		{
//			Storage storage=(Storage)domainObject;
//			
//		
//		}
		if(domainObject instanceof Lng)
		{
			Lng lng=(Lng)domainObject;
			if(null!=lng.getOnshoreOrOffshore() && !(BLANK).equalsIgnoreCase(lng.getOnshoreOrOffshore()))
			return (lng.getOnshoreOrOffshore().equalsIgnoreCase(ApplicationConstants.ONSHORE) || lng.getOnshoreOrOffshore().equalsIgnoreCase(ApplicationConstants.OFFSHORE));
		}
		if(domainObject instanceof PipeLine)
		{
			PipeLine pipeLine=(PipeLine)domainObject;
			if(null!=pipeLine.getOnshoreOrOffshore() && !(BLANK).equalsIgnoreCase(pipeLine.getOnshoreOrOffshore()))
			return (pipeLine.getOnshoreOrOffshore().equalsIgnoreCase(ApplicationConstants.ONSHORE) || pipeLine.getOnshoreOrOffshore().equalsIgnoreCase(ApplicationConstants.OFFSHORE));
		}
		return true;
	}
	public Set<String> validateRefinerySpecificFields(Refinery refinery,List<String> refinerySourceList)throws Exception
	{
		logger.info("Class - DataValidationHelper - validateRefinerySpecificFields()");
		
		Set description=new HashSet<String>();
		
			
			if(null!=refinery.getAlkylationCapacityUnit() && !(BLANK).equalsIgnoreCase(refinery.getAlkylationCapacityUnit()))
			{
				boolean alkylationCapacityUnit=false;
				 for(int i=0;i<refinerySourceList.size();i++)
				 {
					 if(refinery.getAlkylationCapacityUnit().trim().equalsIgnoreCase(refinerySourceList.get(i)))
							alkylationCapacityUnit=true;
				 }
					if(!alkylationCapacityUnit)	
						description.add(ApplicationConstants.COLUMN_HEADER_ALKYLATION_CAPACITY_UNIT);
			}
			
				
			if(null!=refinery.getAromaticsCapacityUnit() && !(BLANK).equalsIgnoreCase(refinery.getAromaticsCapacityUnit()))
			{
				boolean aromaticsCapacityUnit=false;
				for(int i=0;i<refinerySourceList.size();i++)
				{
					if(refinery.getAromaticsCapacityUnit().trim().equalsIgnoreCase(refinerySourceList.get(i)))
						aromaticsCapacityUnit=true;
				}				
					if(!aromaticsCapacityUnit)
						 description.add(ApplicationConstants.COLUMN_HEADER_AROMATICS_CAPACITY_UNIT);
			}
			
			if(null!=refinery.getPolymerizationCapacityUnit() && !(BLANK).equalsIgnoreCase(refinery.getPolymerizationCapacityUnit()))
			{
				boolean polymerizationCapacityUnit=false;
				for(int i=0;i<refinerySourceList.size();i++)
				{
					if(refinery.getPolymerizationCapacityUnit().trim().equalsIgnoreCase(refinerySourceList.get(i)))
						polymerizationCapacityUnit=true;
				}				
					if(!polymerizationCapacityUnit)
						 description.add(ApplicationConstants.COLUMN_HEADER_POLMERIZATION_CAPACITY_UNIT);
			}
			
			if(null!=refinery.getLubesCapacityUnit() && !(BLANK).equalsIgnoreCase(refinery.getLubesCapacityUnit()))
			{
				boolean lubesCapacityUnit=false;
				for(int i=0;i<refinerySourceList.size();i++)
				{
					if(refinery.getLubesCapacityUnit().trim().equalsIgnoreCase(refinerySourceList.get(i)))
						lubesCapacityUnit=true;
				}				
					if(!lubesCapacityUnit)
						 description.add(ApplicationConstants.COLUMN_HEADER_LUBES_CAPACITY_UNIT);
			}
			
			if(null!=refinery.getOxygenatesCapacityUnit() && !(BLANK).equalsIgnoreCase(refinery.getOxygenatesCapacityUnit()))
			{
				boolean oxygenatesCapacityUnit=false;
				for(int i=0;i<refinerySourceList.size();i++)
				{
					if(refinery.getOxygenatesCapacityUnit().trim().equalsIgnoreCase(refinerySourceList.get(i)))
						oxygenatesCapacityUnit=true;
				}
				if(!oxygenatesCapacityUnit)
					description.add(ApplicationConstants.COLUMN_HEADER_OXYGENATES_CAPACITY_UNIT);
			}
			if(null!=refinery.getCokeCapacityUnit() && !(BLANK).equalsIgnoreCase(refinery.getCokeCapacityUnit()))
			{
				boolean cokeCapacityUnit=false;
				for(int i=0;i<refinerySourceList.size();i++)
				{
					if(refinery.getCokeCapacityUnit().trim().equalsIgnoreCase(refinerySourceList.get(i))) 
						cokeCapacityUnit=true;
				}
				if(!cokeCapacityUnit)
					description.add(ApplicationConstants.COLUMN_HEADER_COKE_CAPACITY_UNIT);
			}
			if(null!=refinery.getSulphurCapacityUnit() && !(BLANK).equalsIgnoreCase(refinery.getSulphurCapacityUnit()))
			{
				boolean sulphurCapacityUnit=false;
				for(int i=0;i<refinerySourceList.size();i++)
				{
					if(refinery.getSulphurCapacityUnit().trim().equalsIgnoreCase(refinerySourceList.get(i)))
						sulphurCapacityUnit=true;
				}
				if(!sulphurCapacityUnit)
					description.add(ApplicationConstants.COLUMN_HEADER_SULPHUR_CAPACITY_UNIT);
			}
			
			if(null!=refinery.getHydrogenCapacityUnit() && !(BLANK).equalsIgnoreCase(refinery.getHydrogenCapacityUnit()))
			{
				boolean hydrogenCapacityUnit=false;
				for(int i=0;i<refinerySourceList.size();i++)
				{
					if(refinery.getHydrogenCapacityUnit().trim().equalsIgnoreCase(refinerySourceList.get(i)))
						hydrogenCapacityUnit=true;
				}
				if(!hydrogenCapacityUnit)
					description.add(ApplicationConstants.COLUMN_HEADER_HYDROGEN_CAPACITY_UNIT);
			}
			
			if(null!=refinery.getAsphaltCapacityUnit() && !(BLANK).equalsIgnoreCase(refinery.getAsphaltCapacityUnit()))
			{
				boolean asphaltCapacityUnit=false;
				for(int i=0;i<refinerySourceList.size();i++)
				{
					if(refinery.getAsphaltCapacityUnit().trim().equalsIgnoreCase(refinerySourceList.get(i)))
						asphaltCapacityUnit=true;
				}
				if(!asphaltCapacityUnit)
					description.add(ApplicationConstants.COLUMN_HEADER_ASPHALT_CAPACITY_UNIT);
			}
		return description;
	}
	public Set<String> validateStorageSpecificFields(Storage storage,List<String> storageSourceList)throws Exception
	{
		logger.info("Class - DataValidationHelper - validateStorageSpecificFields()");
		Set<String> description=new HashSet<String>();
		if(null!=storage.getProductsStored() && !(BLANK).equalsIgnoreCase(storage.getProductsStored()))
		{
			boolean productsStored=false;
			for(int i=0;i<storageSourceList.size();i++)
			{
				
				if(storage.getProductsStored().trim().equalsIgnoreCase(storageSourceList.get(i)))
					productsStored=true;
			}
			if(!productsStored)
				description.add(ApplicationConstants.COLUMN_HEADER_PRODUCTS_STORED);
		}
		
		if(null!=storage.getModeOfAccess() && !(BLANK).equalsIgnoreCase(storage.getModeOfAccess()))
		{
			boolean modeOfAccess=false;
			for(int i=0;i<storageSourceList.size();i++)
			{
				if(storage.getModeOfAccess().trim().equalsIgnoreCase(storageSourceList.get(i)))
					modeOfAccess=true;
			}
			if(!modeOfAccess)
				description.add(ApplicationConstants.COLUMN_HEADER_MODE_OF_ACCESS);
		}
		return description;
	}
	public Set<String> validateLngSpecificFields(Lng lng,List<String> lngSourceList)throws Exception
	{
		logger.info("Class - DataValidationHelper - validateLngSpecificFields()");
		Set<String> description=new HashSet<String>();
		if(null!=lng.getFeedDetails() && !(BLANK).equalsIgnoreCase(lng.getFeedDetails()))
		{
			boolean feedDetails=false;
			for(int i=0;i<lngSourceList.size();i++)
			{
				if(lng.getFeedDetails().trim().equalsIgnoreCase(lngSourceList.get(i)))
					feedDetails=true;
			}
			if(!feedDetails)
				description.add(ApplicationConstants.COLUMN_HEADER_FEED_DETAILS);
		}
		if(null!=lng.getFidDetails() && !(BLANK).equalsIgnoreCase(lng.getFidDetails()))
		{
			
			boolean fidDetails=false;
			for(int i=0;i<lngSourceList.size();i++)
			{
				if(lng.getFidDetails().trim().equalsIgnoreCase(lngSourceList.get(i)))
					fidDetails=true;
				
			}
			if(!fidDetails)
				description.add(ApplicationConstants.COLUMN_HEADER_FID_DETAILS);
		}
		if(null!=lng.getConstructionStatusDetails() && !(BLANK).equalsIgnoreCase(lng.getConstructionStatusDetails()))
		{
			boolean constructionStatusDetails=false;
			for(int i=0;i<lngSourceList.size();i++)
			{
				if(lng.getConstructionStatusDetails().trim().equalsIgnoreCase(lngSourceList.get(i)))
					constructionStatusDetails=true;
			}
			if(!constructionStatusDetails)
				description.add(ApplicationConstants.COLUMN_HEADER_CONSTRUCTION_STATUS_DETAILS);
		}
		if(null!=lng.getTechnologyDetails() && !(BLANK).equalsIgnoreCase(lng.getTechnologyDetails()))
		{
			boolean technologyDetails=false;
			for(int i=0;i<lngSourceList.size();i++)
			{
				if(lng.getTechnologyDetails().trim().equalsIgnoreCase(lngSourceList.get(i)))
					technologyDetails=true;
			}
			if(!technologyDetails)
				description.add(ApplicationConstants.COLUMN_HEADER_TECHNOLOGY_DETAILS);
		}
		if(null!=lng.getAdditionalProducts() && !(BLANK).equalsIgnoreCase(lng.getAdditionalProducts()))
		{
			boolean additionalProducts=false;
			for(int i=0;i<lngSourceList.size();i++)
			{
				if(lng.getAdditionalProducts().trim().equalsIgnoreCase(lngSourceList.get(i)))
					additionalProducts=true;
			}
			if(!additionalProducts)
				description.add(ApplicationConstants.COLUMN_HEADER_ADDITIONAL_PRODUCTS);
		}
		if(null!=lng.getAdditionalProductsProductionUnit() && !(BLANK).equalsIgnoreCase(lng.getAdditionalProductsProductionUnit()))
		{
			boolean additionalProductsProductionUnit=false;
			for(int i=0;i<lngSourceList.size();i++)
			{
				if(lng.getAdditionalProductsProductionUnit().trim().equalsIgnoreCase(lngSourceList.get(i)))
					additionalProductsProductionUnit=true;
			}
			if(!additionalProductsProductionUnit)
				description.add(ApplicationConstants.COLUMN_HEADER_ADDITIONAL_PRODUCTS_PRODUCTION_UNIT);
		}
		if(null!=lng.getFeedOrInputType() && !(BLANK).equalsIgnoreCase(lng.getFeedOrInputType()))
		{
			boolean feedOrInputType=false;
			for(int i=0;i<lngSourceList.size();i++)
			{
				if(lng.getFeedOrInputType().equalsIgnoreCase(lngSourceList.get(i)))
					feedOrInputType=true;
			}
			if(!feedOrInputType)
				description.add(ApplicationConstants.COLUMN_HEADER_FEED_OR_INPUT_TYPE);
		}
		if(null!=lng.getDisttributionOrOutputType() && !(BLANK).equalsIgnoreCase(lng.getDisttributionOrOutputType()))
		{
			boolean disttributionOrOutputType=false;
			for(int i=0;i<lngSourceList.size();i++)
			{
				if(lng.getDisttributionOrOutputType().trim().equalsIgnoreCase(lngSourceList.get(i)))
					disttributionOrOutputType=true;
			}
			if(!disttributionOrOutputType)
				description.add(ApplicationConstants.COLUMN_HEADER_DISTRIBUTION_OR_OUTPUT_TYPE);
		}
		if(null!=lng.getUnits() && !(BLANK).equalsIgnoreCase(lng.getUnits()))
		{
			boolean units=false;
			for(int i=0;i<lngSourceList.size();i++)
			{
				if(lng.getUnits().trim().equalsIgnoreCase(lngSourceList.get(i)))
					units=true;
			}
			if(!units)
				description.add(ApplicationConstants.COLUMN_HEADER_UNITS);
		}
		return description;
	}
	public Set<String> validatePipeLineSpecificFields(PipeLine pipeLine,List<String> pipeLineSourceList,List<String> countriesList,List<String> regionList)throws Exception
	{
		logger.info("Class - DataValidationHelper - validatePipeLineSpecificFields()");
		Set<String> description=new HashSet<String>();
		if(null!=pipeLine.getCommodity() && !(BLANK).equalsIgnoreCase(pipeLine.getCommodity()))
		{
			boolean commodity=false;
			for(int i=0;i<pipeLineSourceList.size();i++)
			{
				if(pipeLine.getCommodity().trim().equalsIgnoreCase(pipeLineSourceList.get(i)))
					commodity=true;
			}
			if(!commodity)
				description.add(ApplicationConstants.COLUMN_HEADER_COMMODITY);
		}
		if(null!=pipeLine.getStartCountry() && !(BLANK).equalsIgnoreCase(pipeLine.getStartCountry()))
		{
			boolean startCountry=false;
			for(int i=0;i<countriesList.size();i++)
			{
				if(pipeLine.getStartCountry().trim().equalsIgnoreCase(countriesList.get(i)))
					startCountry=true;
					
			}
			if(!startCountry)
				description.add(ApplicationConstants.COLUMN_HEADER_START_COUNTRY);
		}
		if(null!=pipeLine.getStartRegion() && !(BLANK).equalsIgnoreCase(pipeLine.getStartRegion()))
		{
			boolean startRegion=false;
			for(int i=0;i<regionList.size();i++)
			{
				if(pipeLine.getStartRegion().trim().equalsIgnoreCase(regionList.get(i)))
					startRegion=true;
					
			}
			if(!startRegion)
				description.add(ApplicationConstants.COLUMN_HEADER_START_REGION);
		}
		if(null!=pipeLine.getEndCountry() && !(BLANK).equalsIgnoreCase(pipeLine.getEndCountry()))
		{
			boolean endCountry=false;
			for(int i=0;i<countriesList.size();i++)
			{
				if(pipeLine.getEndCountry().trim().equalsIgnoreCase(countriesList.get(i)))
					endCountry=true;
					
			}
			if(!endCountry)
				description.add(ApplicationConstants.COLUMN_HEADER_END_COUNTRY);
		}
		if(null!=pipeLine.getEndRegion() && !(BLANK).equalsIgnoreCase(pipeLine.getEndRegion()))
		{
			boolean endRegion=false;
			for(int i=0;i<regionList.size();i++)
			{
				if(pipeLine.getEndRegion().trim().equalsIgnoreCase(regionList.get(i)))
					endRegion=true;
					
			}
			if(!endRegion)
				description.add(ApplicationConstants.COLUMN_HEADER_END_REGION);
		}
		if(null!=pipeLine.getPipelineType() && !(BLANK).equalsIgnoreCase(pipeLine.getPipelineType()))
		{
			boolean pipelineType=false;
			for(int i=0;i<pipeLineSourceList.size();i++)
			{
				if(pipeLine.getPipelineType().trim().equalsIgnoreCase(pipeLineSourceList.get(i)))
					pipelineType=true;
			}
			if(!pipelineType)
				description.add(ApplicationConstants.COLUMN_HEADER_PIPELINE_TYPE);
		}
		if(null!=pipeLine.getParentChildRelation() && !(BLANK).equalsIgnoreCase(pipeLine.getParentChildRelation()) && ApplicationConstants.PARENT.equalsIgnoreCase(pipeLine.getParentChildRelation()))
		{
			boolean pipeLineLength=false;
			if(pipeLine.getLength()!=0)
				pipeLineLength=true;
			if(!pipeLineLength)
				description.add(ApplicationConstants.COLUMN_HEADER_LENGTH);
		}
		return description;
	}
	public boolean validateOilGasType(CompanyOilGas cog)
	{
		boolean flag=false;
		if(ApplicationConstants.CRUDEOIL.equalsIgnoreCase(cog.getType()) || ApplicationConstants.NATURALGAS.equalsIgnoreCase(cog.getType()))
			flag=true;
		return flag;	
	}
	public boolean validateParentChildRelation(PipeLine p)
	{
		boolean flag=false;
		if(ApplicationConstants.PARENT.equalsIgnoreCase(p.getParentChildRelation()) || ApplicationConstants.CHILD.equalsIgnoreCase(p.getParentChildRelation()))
			flag=true;
		return flag;
	}
	public Set<String> validateSmallScaleLngSpecificFields(SmallScaleLng ssl,List<String> sslSourceList)throws Exception
	{
		logger.info("Class - DataValidationHelper - validateSmallScaleLngSpecificFields()");
		Set<String> description=new HashSet<String>();
		if(null!=ssl.getTechnology() && !(BLANK).equalsIgnoreCase(ssl.getTechnology()))
		{
			boolean technology=false;
			for(int i=0;i<sslSourceList.size();i++)
			{
				if(ssl.getTechnology().trim().equalsIgnoreCase(sslSourceList.get(i)))
					technology=true;
			}
			if(!technology)
				description.add(ApplicationConstants.COLUMN_HEADER_TECHNOLOGY);
		}
		if(null!=ssl.getLiquefactionCapcityUnit() && !(BLANK).equalsIgnoreCase(ssl.getLiquefactionCapcityUnit()))
		{
			boolean liqueCapUnit=false;
			for(int i=0;i<sslSourceList.size();i++)
			{
				if(ssl.getLiquefactionCapcityUnit().trim().equalsIgnoreCase(sslSourceList.get(i)))
					liqueCapUnit=true;
			}
			if(!liqueCapUnit)
				description.add(ApplicationConstants.COLUMN_HEADER_LIQUEFACATION_UNIT);
		}
		if(null!=ssl.getRegasificationCapcityUnit() && !(BLANK).equalsIgnoreCase(ssl.getRegasificationCapcityUnit()))
		{
			boolean regasCapUnit=false;
			for(int i=0;i<sslSourceList.size();i++)
			{
				if(ssl.getRegasificationCapcityUnit().trim().equalsIgnoreCase(sslSourceList.get(i)))
					regasCapUnit=true;
			}
			if(!regasCapUnit)
				description.add(ApplicationConstants.COLUMN_HEADER_REGASIFICATION_UNIT);
		}
		if(null!=ssl.getBunkeringCapacityUnit() && !(BLANK).equalsIgnoreCase(ssl.getBunkeringCapacityUnit()))
		{
			boolean bunkeringCapUnit=false;
			for(int i=0;i<sslSourceList.size();i++)
			{
				if(ssl.getBunkeringCapacityUnit().trim().equalsIgnoreCase(sslSourceList.get(i)))
					bunkeringCapUnit=true;
			}
			if(!bunkeringCapUnit)
				description.add(ApplicationConstants.COLUMN_HEADER_BUNKERING_UNIT);
		}		
		if(null!=ssl.getDistributionType() && !(BLANK).equalsIgnoreCase(ssl.getDistributionType()))
		{
			boolean distributionType=false;
			for(int i=0;i<sslSourceList.size();i++)
			{
				if(ssl.getBunkeringCapacityUnit().trim().equalsIgnoreCase(sslSourceList.get(i)))
					distributionType=true;
			}
			if(!distributionType)
				description.add(ApplicationConstants.COLUMN_HEADER_DISTRIBUTIONTYPE);
		}
		return description;
	}	
	private double round(double value)
	{
		return (double)(Math.round((value)*100)/100);
	}
//	public void populateAllColumnsListsFromDB()
//	{
//		try
//		{
//			countriesList=getCountriesList();
//			singleSourceList=getSingleSourceList();
//			statusList=getStatusList();
//			regionList=getRegionList();
//			typeList=getTypeList();
//			refinerySourceList=getRefinerySourceList();
//			storageSourceList=getStorageSourceList();
//			lngSourceList=getLngSourceList();
//			pipeLineSourceList=getPipeLineSourceList();
//		}
//		catch(Exception e)
//		{
//			System.out.println("Exception in DataValidationHelper - Method populateAllColumnsListsFromDB():"+e);
//		}
//		
//		System.out.println("Hi i called these many times");
//	}
	
}
