package com.lnganalysis.fileupload.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.lnganalysis.constants.ApplicationConstants;
import com.lnganalysis.constants.LngData;
import com.lnganalysis.dto.Tab;
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
import com.lnganalysis.helper.DataValidationHelper;
import com.lnganalysis.helper.SourceHelper;

public class ExcelDataValidation {
	static final Logger logger=Logger.getLogger(ExcelDataValidation.class);		
	public List<Tab> validateExcelData(Map listOfSheets)throws Exception
	{
		logger.info("Class - ExcelDataValidation - validateExcelData()");
		List<Tab> errorTabList=new ArrayList<Tab>();
		Set<String> keys=listOfSheets.keySet();
		Tab explorationTab=null;
		Tab refineryTab=null;
		Tab storageTab=null;
		Tab crudeOilTab=null;
		Tab naturalGasTab=null;
		Tab lngTab=null;
		Tab pipelineTab=null;
		Tab supplyDemandTab=null;
		Tab contractsTab=null;
		Tab companyOilGasTab=null;
		Tab smallScaleLngTab=null;
		
		List<Exploration> explorationList=null;
		List<Refinery> refineryList=null;
		List<Storage> storageList=null;
		List<CrudeOil> crudeOilList=null;
		List<NaturalGas> naturalGasList=null;
		List<Lng> lngList=null;
		List<PipeLine> pipeLineList=null;
		List<SupplyDemand> supplyDemandList=null;
		List<Contracts> contractsList=null;
		List<CompanyOilGas> companyOilGasList=null;
		List<SmallScaleLng> smallScaleLngList=null;
		for(String key:keys)
		{
			if(key.equalsIgnoreCase(LngData.EXPLORATION.toString()))
			{
				explorationList=(List)listOfSheets.get(key);
				explorationTab=validateExplorationData(explorationList,LngData.EXPLORATION.toString());								
				if(explorationTab.getTotalRecords()>0)
					errorTabList.add(explorationTab);
//				else
//				{									
//					ExplorationDaoImpl explorationDao=new ExplorationDaoImpl();
////					explorationDao.save(list);
//				}
			}
			else if(key.equalsIgnoreCase(LngData.REFINERIES.toString()))
			{
				refineryList=(List)listOfSheets.get(key);
				refineryTab=validateRefineriesData(refineryList,LngData.REFINERIES.toString());				
				
				if(refineryTab.getTotalRecords()>0)
					errorTabList.add(refineryTab);
//				else
//				{
//					RefineryDaoImpl refineryDao=new RefineryDaoImpl();
////					refineryDao.save(list);
//				}
			}
			else if(key.equalsIgnoreCase(LngData.STORAGE.toString()))
			{
				storageList=(List)listOfSheets.get(key);
				storageTab=validateStorageData(storageList,LngData.STORAGE.toString());				
//				
				if(storageTab.getTotalRecords()>0)
					errorTabList.add(storageTab);
//				else
//				{
//					StorageDaoImpl storageDao=new StorageDaoImpl();
////					storageDao.save(list);
//				}
			}
			else if(key.equalsIgnoreCase(LngData.CRUDEOIL.toString()))
			{
				crudeOilList=(List)listOfSheets.get(key); 
				crudeOilTab=validateCrudeOilData(crudeOilList,LngData.CRUDEOIL.toString());				

				if(crudeOilTab.getTotalRecords()>0)
					errorTabList.add(crudeOilTab);
//				else
//				{
//					CrudeOilDaoImpl crudeOilDao=new CrudeOilDaoImpl();
////					crudeOilDao.save(list);
//				}
			}
			else if(key.equalsIgnoreCase(LngData.NATURALGAS.toString()))
			{
				naturalGasList=(List)listOfSheets.get(key);
				naturalGasTab=validateNaturalGasData(naturalGasList,LngData.NATURALGAS.toString());				
				
				if(naturalGasTab.getTotalRecords()>0)
					errorTabList.add(naturalGasTab);
//				else
//				{
//					NaturalGasDaoImpl naturalGasDao=new NaturalGasDaoImpl();
////					naturalGasDao.save(list);
//				}
			}
			else if(key.equalsIgnoreCase(LngData.LNG.toString()))
			{
				lngList=(List)listOfSheets.get(key);
				lngTab=validateLngData(lngList,LngData.LNG.toString());				
				
				if(lngTab.getTotalRecords()>0)
					errorTabList.add(lngTab);
//				else
//				{
//					LngDaoImpl lngDao=new LngDaoImpl();
////					lngDao.save(list);
//				}
			}
			else if(key.equalsIgnoreCase(LngData.PIPELINES.toString()))
			{
				pipeLineList=(List)listOfSheets.get(key);
				pipelineTab=validatePipelinesData(pipeLineList,LngData.PIPELINES.toString());				
				
				if(pipelineTab.getTotalRecords()>0)
					errorTabList.add(pipelineTab);
//				else
//				{
//					PipelineDaoImpl pipelineDao=new PipelineDaoImpl();
////					pipelineDao.save(list);
//				}
			}
			else if(key.equalsIgnoreCase(LngData.SUPPLYDEMAND.toString()))
			{
				supplyDemandList=(List)listOfSheets.get(key);
				supplyDemandTab=validateSupplyDemandData(supplyDemandList,LngData.SUPPLYDEMAND.toString());				
				
				if(supplyDemandTab.getTotalRecords()>0)
					errorTabList.add(supplyDemandTab);
				
			}
			else if(key.equalsIgnoreCase(LngData.CONTRACTS.toString()))
			{
				contractsList=(List)listOfSheets.get(key);
				contractsTab=validateContractsData(contractsList,LngData.CONTRACTS.toString());				
				
				if(contractsTab.getTotalRecords()>0)
					errorTabList.add(contractsTab);
				
			}
			else if(key.equalsIgnoreCase(LngData.PRODUCTION_COMPANY_OILGAS.toString()))
			{
				companyOilGasList=(List)listOfSheets.get(key);
				companyOilGasTab=validateCompanyOilGasData(companyOilGasList,LngData.PRODUCTION_COMPANY_OILGAS.toString());				
				
				if(companyOilGasTab.getTotalRecords()>0)
					errorTabList.add(companyOilGasTab);
				
			}
			else if(key.equalsIgnoreCase(LngData.SMALLSCALELNG.toString()))
			{
				smallScaleLngList=(List)listOfSheets.get(key);
				smallScaleLngTab=validateSmallScaleLngData(smallScaleLngList,LngData.SMALLSCALELNG.toString());				
				
				if(smallScaleLngTab.getTotalRecords()>0)
					errorTabList.add(smallScaleLngTab);
				
			}
				
		}
//		if(!(errorTabList.size()>0))
//		{
//			ExplorationDaoImpl explorationDao=new ExplorationDaoImpl();
//			RefineryDaoImpl refineryDao=new RefineryDaoImpl();
//			StorageDaoImpl storageDao=new StorageDaoImpl();
//			CrudeOilDaoImpl crudeOilDao=new CrudeOilDaoImpl();
//			NaturalGasDaoImpl naturalGasDao=new NaturalGasDaoImpl();
//			LngDaoImpl lngDao=new LngDaoImpl();
//			PipelineDaoImpl pipelineDao=new PipelineDaoImpl();
//						
//			explorationDao.save(explorationList);
//			refineryDao.save(refineryList);
//			storageDao.save(storageList);
//		    crudeOilDao.save(crudeOilList);
//		    naturalGasDao.save(naturalGasList);
//		    lngDao.save(lngList);
//		    pipelineDao.save(pipeLineList);
//		}
		return errorTabList;
	}
	
	private Tab validateExplorationData(List<Exploration> explorationList,String tabName)throws Exception
	{
		logger.info("Class - ExcelDataValidation - validateExplorationData()");
		int totalRecords=0;
		StringBuffer recordsList=new StringBuffer("");
		Tab tab=new Tab();
		tab.setName(tabName);		
		int recordCount=2;
		DataValidationHelper dvh=new DataValidationHelper();
		SourceHelper sh=new SourceHelper();
		List<String> regionList=sh.getRegionList();
		List<String> countriesList=sh.getCountriesList();
		List<String> statusList=sh.getStatusList();
		List<String> singleSourceList=sh.getSingleSourceList();
		Set<String> description=new HashSet<String>();
		int linebreak=1;
		for(Exploration e: explorationList)
		{
			boolean validateRegion=dvh.validateRegion(e,regionList);
			if(!validateRegion)
				description.add(ApplicationConstants.COLUMN_HEADER_REGION);
			boolean validateCountries=dvh.validateCountries(e,countriesList);
			if(!validateCountries)
				description.add(ApplicationConstants.COLUMN_HEADER_COUNTRY);			
			boolean validateOnShoreOrOffshore=dvh.validateOnShoreOrOffshore(e);
			if(!validateOnShoreOrOffshore)
				description.add(ApplicationConstants.COLUMN_HEADER_ONSHORE_OR_OFFSHORE);
			boolean validateStatus=dvh.validateStatus(e,statusList);
			if(!validateStatus)
				description.add(ApplicationConstants.COLUMN_HEADER_STATUS);
			boolean validateOperator=dvh.validateOperator(e,singleSourceList);
			if(!validateOperator)
				description.add(ApplicationConstants.COLUMN_HEADER_OPERATOR);
			boolean validateEquityPartners=dvh.validateEquityPartners(e,singleSourceList);
			if(!validateEquityPartners)
				description.add(ApplicationConstants.COLUMN_HEADER_EQUITY_PARTNERS);
			
		
			
					if(!validateRegion || !validateCountries || !validateOnShoreOrOffshore  || !validateStatus || !validateOperator || !validateEquityPartners)
					{
						
						recordsList=recordsList.append(recordCount+",");
						if(totalRecords==(12*linebreak))
						{	
							recordsList.append(" ");// Adding space for rendering in front end;
							linebreak++;
						}	
						totalRecords++;
					}
					recordCount++;
		}
		createTabData(tab,recordsList,description,totalRecords);
		logger.info("Exploration -> Rows:"+tab.getRecords()+":Total records:"+tab.getTotalRecords()+" Decription:" + tab.getDescription());
		return tab;
		
	}
	private Tab validateRefineriesData(List<Refinery> refineryList,String tabName)throws Exception	
	{
		logger.info("Class - ExcelDataValidation - validateRefineriesData()");
		int totalRecords=0;
		StringBuffer recordsList=new StringBuffer("");
		Tab tab=new Tab();
		tab.setName(tabName);
		StringBuffer descriptionList=new StringBuffer("");
		int recordCount=2;
		int linebreak=1;
		Set<String> description=new HashSet<String>();
		Set<String> currentEquityStakes=new HashSet<String>();
		DataValidationHelper dvh=new DataValidationHelper();
		SourceHelper sh=new SourceHelper();
		List<String> countriesList=sh.getCountriesList();
		List<String> regionList=sh.getRegionList();
		List<String> statusList=sh.getStatusList();
		List<String> typeList=sh.getTypeList();
		List<String> singleSourceList=sh.getSingleSourceList();
		List<String> refinerySourceList=sh.getRefinerySourceList();
//		Set<String> historicEquityStakes=new HashSet<String>(); //This is not required
		for(Refinery e: refineryList)
		{
			
			boolean validateCountries=dvh.validateCountries(e,countriesList);
			if(!validateCountries)
				description.add(ApplicationConstants.COLUMN_HEADER_COUNTRY);
			
			boolean validateRegion=dvh.validateRegion(e,regionList);
			if(!validateRegion)
				description.add(ApplicationConstants.COLUMN_HEADER_REGION);
			
			boolean validateStatus=dvh.validateStatus(e,statusList);
			if(!validateStatus)
				description.add(ApplicationConstants.COLUMN_HEADER_STATUS);
			
			boolean validateType=dvh.validateType(e,typeList);
			if(!validateType)
				description.add(ApplicationConstants.COLUMN_HEADER_TYPE);
			
			boolean validateCurrentOperator=dvh.validateCurrentOperator(e,singleSourceList);
			if(!validateCurrentOperator)
				description.add(ApplicationConstants.COLUMN_HEADER_CURRENT_OPERATOR);
			
			boolean validateCurrentEquityPartners=dvh.validateCurrentEquityPartners(e,singleSourceList);
			if(!validateCurrentEquityPartners)
				description.add(ApplicationConstants.COLUMN_HEADER_CURRENT_EQUITY_PARTNERS);
			
			boolean validateCurrentEquityStakes=dvh.validateEquityStakes(e, refineryList, currentEquityStakes);// This is currentEquityStakes
			if(!validateCurrentEquityStakes)
				description.add(ApplicationConstants.COLUMN_HEADER_CURRENT_EQUITY_STAKES);// of:"+e.getName());
			
			boolean validateHistoricOperator=dvh.validateHistoricOperator(e,singleSourceList);
			if(!validateHistoricOperator)
				description.add(ApplicationConstants.COLUMN_HEADER_HISTORIC_OPERATOR);
			
			boolean validateHistoricEquityPartners=dvh.validateHistoricEquityPartners(e,singleSourceList);
			if(!validateHistoricEquityPartners)
				description.add(ApplicationConstants.COLUMN_HEADER_HISTORIC_EQUITY_PARTNERS);
			
			boolean  validateRefinerySpecificFields=true;
			Set<String> refinerySpecificFields=dvh.validateRefinerySpecificFields(e,refinerySourceList);
			if(refinerySpecificFields.size()>0)
			{
				validateRefinerySpecificFields=false;
				description.addAll(refinerySpecificFields);
			}
				
			
			// In Refineries still some stuff is there to validate******
//			boolean validateHistoricEquityStakes=DataValidationHelper.validateHistoricEquityStakes(e,refineryList,historicEquityStakes); //This is not required
//			if(!validateHistoricEquityStakes)
//				description.add("HistoricEquityStakes of:"+e.getName());
			
					if(!validateCountries || !validateRegion || !validateStatus || !validateType || !validateCurrentOperator || !validateCurrentEquityPartners || !validateCurrentEquityStakes || !validateHistoricOperator || !validateHistoricEquityPartners || !validateRefinerySpecificFields)// || !validateHistoricEquityStakes)
//					if(!validateRefinerySpecificFields)
					{
						
						recordsList=recordsList.append(recordCount+",");
						if(totalRecords==(12*linebreak))
						{	
							recordsList.append(" ");// Adding space for rendering in front end;
							linebreak++;
						}	
						totalRecords++;
					}
					recordCount++;
		}
		createTabData(tab,recordsList,description,totalRecords);
		logger.info("Refineris ->Rows:"+tab.getRecords()+":Total records:"+tab.getTotalRecords()+"Description:"+tab.getDescription());
		return tab;
		
	}
	
	private Tab validateStorageData(List<Storage> storageList,String tabName)throws Exception
	{
		logger.info("Class - ExcelDataValidation - validateStorageData()");
		int totalRecords=0;
		StringBuffer recordsList=new StringBuffer("");
		Tab tab=new Tab();
		tab.setName(tabName);
		StringBuffer descriptionList=new StringBuffer("");
		int recordCount=2;
		int linebreak=1;
		Set<String> description=new HashSet<String>();
		Set<String> currentOwnerShip=new HashSet<String>();
		DataValidationHelper dvh=new DataValidationHelper();
		SourceHelper sh=new SourceHelper();
		List<String> regionList=sh.getRegionList();
		List<String> countriesList=sh.getCountriesList();
		List<String> statusList=sh.getStatusList();
		List<String> singleSourceList=sh.getSingleSourceList();
		List<String> storageSourceList=sh.getStorageSourceList();
//		Set<String> historicOwnerShip=new HashSet<String>(); This is not required
		for(Storage e: storageList)
		{
			
			boolean validateRegion=dvh.validateRegion(e,regionList);
			if(!validateRegion)
				description.add(ApplicationConstants.COLUMN_HEADER_REGION);
			
			boolean validateCountries=dvh.validateCountries(e,countriesList);
			if(!validateCountries)
				description.add(ApplicationConstants.COLUMN_HEADER_COUNTRY);
			
			boolean validateStatus=dvh.validateStatus(e,statusList);
			if(!validateStatus)
				description.add(ApplicationConstants.COLUMN_HEADER_STATUS);
			
			boolean validateCurrentOperator=dvh.validateCurrentOperator(e,singleSourceList);
			if(!validateCurrentOperator)
				description.add(ApplicationConstants.COLUMN_HEADER_CURRENT_OPERATOR);
			
			boolean validateCurrentOwners=dvh.validateCurrentOwners(e,singleSourceList);
			if(!validateCurrentOwners)
				description.add(ApplicationConstants.COLUMN_HEADER_CURRENT_OWNERS);		
			
			boolean validateCurrentOwnership=dvh.validateCurrentOwnerShip(e,storageList,currentOwnerShip);
			if(!validateCurrentOwnership)
				description.add(ApplicationConstants.COLUMN_HEADER_CURRENT_OWNERSHIP);// of:"+ e.getTankFarm());
			
			boolean validateHistoricOperator=dvh.validateHistoricOperator(e,singleSourceList);
			if(!validateHistoricOperator)
				description.add(ApplicationConstants.COLUMN_HEADER_HISTORIC_OPERATOR);
			
			boolean validateHistoricOwners=dvh.validateHistoricOwners(e,singleSourceList);
			if(!validateHistoricOwners)
				description.add(ApplicationConstants.COLUMN_HEADER_HISTORIC_OWNERS);
			
			boolean  validateStorageSpecificFields=true;
			Set<String> storageSpecificFields=dvh.validateStorageSpecificFields(e,storageSourceList);
			if(storageSpecificFields.size()>0)
			{
				validateStorageSpecificFields=false;
				description.addAll(storageSpecificFields);
			}
//			This is not required
//			boolean validateHistoricOwnership=DataValidationHelper.validateHistoricOwnerShip(e,storageList, historicOwnerShip);
//			if(!validateHistoricOwnership)
//				description.add("HistoricOwnerShip of :"+e.getTankFarm());
			
					if(!validateRegion || !validateCountries || !validateStatus || !validateCurrentOperator || !validateCurrentOwners || !validateCurrentOwnership || !validateHistoricOperator || !validateHistoricOwners || !validateStorageSpecificFields )//|| !validateHistoricOwnership)
					{
						
						recordsList=recordsList.append(recordCount+",");
						if(totalRecords==(12*linebreak))
						{	
							recordsList.append(" ");// Adding space for rendering in front end;
							linebreak++;
						}	
						totalRecords++;
					}
					recordCount++;
		}
		createTabData(tab,recordsList,description,totalRecords);
		logger.info("Storage -> Rows:"+tab.getRecords()+":Total records:"+tab.getTotalRecords()+"Description:"+descriptionList.toString());
		return tab;
		
	}
	private Tab validateCrudeOilData(List<CrudeOil> crudeOilList,String tabName)throws Exception
	{
		logger.info("Class - ExcelDataValidation - validateCrudeOilData()");
		int totalRecords=0;
		StringBuffer recordsList=new StringBuffer("");
		Tab tab=new Tab();
		tab.setName(tabName);
		StringBuffer descriptionList=new StringBuffer("");
		int recordCount=2;
		int linebreak=1;
		Set<String> description=new HashSet<String>();
		Set<String> currentOwnerShipTracker=new HashSet<String>();
		DataValidationHelper dvh=new DataValidationHelper();
		SourceHelper sh=new SourceHelper();
		List<String> regionList=sh.getRegionList();
		List<String> countriesList=sh.getCountriesList();
		List<String> statusList=sh.getStatusList();
		List<String> singleSourceList=sh.getSingleSourceList();
//		Set<String> historicOwnerShipTracker=new HashSet<String>();This is not required
		for(CrudeOil e: crudeOilList)
		{
			boolean validateRegion=dvh.validateRegion(e,regionList);
			if(!validateRegion)
				description.add(ApplicationConstants.COLUMN_HEADER_REGION);
			boolean validateCountries=dvh.validateCountries(e,countriesList);
			if(!validateCountries)
				description.add(ApplicationConstants.COLUMN_HEADER_COUNTRY);
			boolean validateStatus=dvh.validateStatus(e,statusList);
			if(!validateStatus)
				description.add(ApplicationConstants.COLUMN_HEADER_STATUS);
			boolean validateOnShoreOrOffshore=dvh.validateOnShoreOrOffshore(e);
			if(!validateOnShoreOrOffshore)
				description.add(ApplicationConstants.COLUMN_HEADER_ONSHORE_OR_OFFSHORE);
			
			boolean validateCurrentOperator=dvh.validateCurrentOperator(e,singleSourceList);
			if(!validateCurrentOperator)
				description.add(ApplicationConstants.COLUMN_HEADER_CURRENT_OPERATOR);
			
			boolean validateCurrentOwners=dvh.validateCurrentOwners(e,singleSourceList);
			if(!validateCurrentOwners)
				description.add(ApplicationConstants.COLUMN_HEADER_CURRENT_OWNERS);
			
			boolean validateCurrentOwnerShip=dvh.validateCurrentOwnerShip(e,crudeOilList,currentOwnerShipTracker);
			if(!validateCurrentOwnerShip)
				description.add(ApplicationConstants.COLUMN_HEADER_CURRENT_OWNERSHIP);
			
			boolean validateHistoricOperator=dvh.validateHistoricOperator(e,singleSourceList);
			if(!validateHistoricOperator)
				description.add(ApplicationConstants.COLUMN_HEADER_HISTORIC_OPERATOR);
			
			boolean validateHistoricOwners=dvh.validateHistoricOwners(e,singleSourceList);
			if(!validateHistoricOwners)
				description.add(ApplicationConstants.COLUMN_HEADER_HISTORIC_OWNERS);
//			This is not required
//			boolean validateHistoricOwnerShip=DataValidationHelper.validateHistoricOwnerShip(e,crudeOilList,historicOwnerShipTracker);
//			if(!validateHistoricOwnerShip)
//				description.add("HistoricOwnerShip");
					if(!validateRegion || !validateCountries || !validateStatus || !validateOnShoreOrOffshore || !validateCurrentOperator || !validateCurrentOwners || !validateCurrentOwnerShip || !validateHistoricOperator || !validateHistoricOwners)//	|| !validateHistoricOwnerShip)
					{
						
						recordsList=recordsList.append(recordCount+",");
						if(totalRecords==(12*linebreak))
						{	
							recordsList.append(" ");// Adding space for rendering in front end;
							linebreak++;
						}	
						totalRecords++;
					}
					recordCount++;
		}
		createTabData(tab,recordsList,description,totalRecords);
		logger.info("In Crude Oil -> Rows:"+tab.getRecords()+":Total records:"+tab.getTotalRecords()+" : Description :"+tab.getDescription());
		return tab;
		
	}
	private Tab validateNaturalGasData(List<NaturalGas> naturalGasList,String tabName)throws Exception	
	{
		logger.info("Class - ExcelDataValidation - validateNaturalGasData()");
		int totalRecords=0;
		StringBuffer recordsList=new StringBuffer("");
		Tab tab=new Tab();
		tab.setName(tabName);
		StringBuffer descriptionList=new StringBuffer("");
		int recordCount=2;
		int linebreak=1;
		Set<String> description=new HashSet<String>();
		Set<String> currentOwnerShipTracker=new HashSet<String>();
		DataValidationHelper dvh=new DataValidationHelper();
		SourceHelper sh=new SourceHelper();
		List<String> regionList=sh.getRegionList();
		List<String> countriesList=sh.getCountriesList();
		List<String> statusList=sh.getStatusList();
		List<String> singleSourceList=sh.getSingleSourceList();
//		Set<String> historicOwnerShipTracker=new HashSet<String>();This is not required
		for(NaturalGas e: naturalGasList)
		{
			boolean validateRegion=dvh.validateRegion(e,regionList);
			if(!validateRegion)
				 description.add(ApplicationConstants.COLUMN_HEADER_REGION);
			boolean validateCountries=dvh.validateCountries(e,countriesList);
			if(!validateCountries)
				description.add(ApplicationConstants.COLUMN_HEADER_COUNTRY);
			
			boolean validateStatus=dvh.validateStatus(e,statusList);
			if(!validateStatus)
				description.add(ApplicationConstants.COLUMN_HEADER_STATUS);
			
			boolean validateOnShoreOrOffshore=dvh.validateOnShoreOrOffshore(e);
			if(!validateOnShoreOrOffshore)
				description.add(ApplicationConstants.COLUMN_HEADER_ONSHORE_OR_OFFSHORE);
			
			boolean validateCurrentOperator=dvh.validateCurrentOperator(e,singleSourceList);
			if(!validateCurrentOperator)
				description.add(ApplicationConstants.COLUMN_HEADER_CURRENT_OPERATOR);
			boolean validateCurrentOwners=dvh.validateCurrentOwners(e,singleSourceList);
			if(!validateCurrentOwners)
				description.add(ApplicationConstants.COLUMN_HEADER_CURRENT_OWNERS);
			
			boolean validateCurrentOwnerShip=dvh.validateCurrentOwnerShip(e,naturalGasList,currentOwnerShipTracker);
			if(!validateCurrentOwnerShip)
				description.add(ApplicationConstants.COLUMN_HEADER_CURRENT_OWNERSHIP);
			
			boolean validateHistroicOperator=dvh.validateHistoricOperator(e,singleSourceList);
			if(!validateHistroicOperator)
				description.add(ApplicationConstants.COLUMN_HEADER_HISTORIC_OPERATOR);
			
			boolean validateHistoricOwners=dvh.validateHistoricOwners(e,singleSourceList);
			if(!validateHistoricOwners)
				description.add(ApplicationConstants.COLUMN_HEADER_HISTORIC_OWNERS);
//			This is not required
//			boolean validateHistoricOwnerShip=DataValidationHelper.validateHistoricOwnerShip(e,naturalGasList,historicOwnerShipTracker);
//			if(!validateHistoricOwnerShip)
//				description.add("HistoricOwnerShip");
					if(!validateRegion || !validateCountries || !validateStatus || !validateOnShoreOrOffshore || !validateCurrentOperator || !validateCurrentOwners || !validateCurrentOwnerShip || !validateHistroicOperator || !validateHistoricOwners)// || !validateHistoricOwnerShip)					
					{
						
						recordsList=recordsList.append(recordCount+",");
						if(totalRecords==(12*linebreak))
						{	
							recordsList.append(" ");// Adding space for rendering in front end;
							linebreak++;
						}
						totalRecords++;
					}
					recordCount++;
		}
		createTabData(tab,recordsList,description,totalRecords);
		logger.info("In NaturalGas - >Rows:"+tab.getRecords()+":Total records:"+tab.getTotalRecords()+ "  Description:"+ tab.getDescription());
		return tab;
		
	}
	private Tab validateLngData(List<Lng> lngList,String tabName)throws Exception
	{
		logger.info("Class - ExcelDataValidation - validateLngData()");
		int totalRecords=0;
		StringBuffer recordsList=new StringBuffer("");
		Tab tab=new Tab();
		tab.setName(tabName);
		StringBuffer descriptionList=new StringBuffer("");
		int recordCount=2;
		Set<String> equityStakes=new HashSet<String>();
//		Set<String> historicEquityStakes=new HashSet<String>();
		Set<String> description=new HashSet<String>();
		DataValidationHelper dvh=new DataValidationHelper();
		SourceHelper sh=new SourceHelper();
		List<String> countriesList=sh.getCountriesList();
		List<String> regionList=sh.getRegionList();
		List<String> statusList=sh.getStatusList();
		List<String> singleSourceList=sh.getSingleSourceList();
		List<String> lngSourceList=sh.getLngSourceList();
		int linebreak=1;
		for(Lng e: lngList)
		{
//		for(int i=37;i<lngList.size();i++)
//		{
//			Lng e=lngList.get(i);
			boolean validateCountries=dvh.validateCountries(e,countriesList);
			if(!validateCountries)
				description.add(ApplicationConstants.COLUMN_HEADER_COUNTRY);
			
			boolean validateRegion=dvh.validateRegion(e,regionList);
			if(!validateRegion)
				description.add(ApplicationConstants.COLUMN_HEADER_REGION);
			
			boolean validateLngType= dvh.validateLngType(e);
			if(!validateLngType)
				description.add(ApplicationConstants.COLUMN_HEADER_TYPE);
			boolean validateStatus= dvh.validateStatus(e,statusList);
			if(!validateStatus)
				description.add(ApplicationConstants.COLUMN_HEADER_STATUS);
			// Feed deatials, FID details, Construction Status Details,Technology ,Additional Products , Additional Products Production Unit, columns need validate
			boolean validateOnShoreOrOffshore=dvh.validateOnShoreOrOffshore(e);
			if(!validateOnShoreOrOffshore)
				description.add(ApplicationConstants.COLUMN_HEADER_ONSHORE_OR_OFFSHORE);			
			
			boolean validateOperator=dvh.validateCurrentOperator(e,singleSourceList);
			if(!validateOperator)
				description.add(ApplicationConstants.COLUMN_HEADER_OPERATOR);
			
			boolean validateEquityPartner=dvh.validateCurrentEquityPartners(e,singleSourceList);
			if(!validateEquityPartner)
				description.add(ApplicationConstants.COLUMN_HEADER_EQUITY_PARTNERS);
			
			boolean validateEquityStakes=dvh.validateEquityStakes(e,lngList, equityStakes);
			if(!validateEquityStakes)
				description.add(ApplicationConstants.COLUMN_HEADER_EQUITY_STAKES);// of "+e.getName());
			
			boolean validateHistoricOperator=dvh.validateHistoricOperator(e,singleSourceList);
			if(!validateHistoricOperator)
				description.add(ApplicationConstants.COLUMN_HEADER_HISTORIC_OPERATOR);
			
			boolean validateHistoricEquityPartners=dvh.validateHistoricEquityPartners(e,singleSourceList);
			if(!validateHistoricEquityPartners)
				description.add(ApplicationConstants.COLUMN_HEADER_HISTORIC_EQUITY_PARTNERS);
			
			boolean  validateLngSpecificFields=true;
			Set<String> lngSpecificFields=dvh.validateLngSpecificFields(e,lngSourceList);
			if(lngSpecificFields.size()>0)
			{
				validateLngSpecificFields=false;
				description.addAll(lngSpecificFields);
			}
//			This is not required
//			boolean validateHistoricEquityStakes=DataValidationHelper.validateHistoricEquityStakes(e,lngList,historicEquityStakes);
//			if(!validateHistoricEquityStakes)
//				description.add("HistoricEquityStake of "+e.getName());
									
					if(!validateCountries || !validateRegion || !validateLngType || !validateStatus || !validateOnShoreOrOffshore || !validateOperator ||!validateEquityPartner || !validateEquityStakes || !validateHistoricOperator || !validateHistoricEquityPartners || !validateLngSpecificFields)//|| !validateHistoricEquityStakes)
					{
						
						recordsList=recordsList.append(recordCount+",");
						if(totalRecords==(12*linebreak))
						{	
							recordsList.append(" ");// Adding space for rendering in front end;
							linebreak++;
						}	
						totalRecords++;
					}
					recordCount++;
		}
		createTabData(tab,recordsList,description,totalRecords);
		
		logger.info("Lng -> Rows:"+tab.getRecords()+":Total records:"+tab.getTotalRecords()+":"+tab.getDescription());
		return tab;
		
	}
	private Tab validatePipelinesData(List<PipeLine> pipelinesList,String tabName)throws Exception
	{
		logger.info("Class - ExcelDataValidation - validatePipelinesData()");
		int totalRecords=0;
		StringBuffer recordsList=new StringBuffer("");
		Tab tab=new Tab();
		tab.setName(tabName);
		int recordCount=2;
		int linebreak=1;
		StringBuffer descriptionList=new StringBuffer("");
		Set<String> description=new HashSet<String>();
		Set<String> equityStakes=new HashSet<String>();
		DataValidationHelper dvh=new DataValidationHelper();
		SourceHelper sh=new SourceHelper();
		List<String> statusList=sh.getStatusList();
		List<String> countriesList=sh.getCountriesList();
		List<String> regionList=sh.getRegionList();
		List<String> singleSourceList=sh.getSingleSourceList();
		List<String> pipeLineSourceList=sh.getPipeLineSourceList();
		for(PipeLine e: pipelinesList)
		{
			boolean validateParentChildRelation=dvh.validateParentChildRelation(e);
			if(!validateParentChildRelation)
				description.add(ApplicationConstants.COLUMN_HEADER_PARENT_CHILD_RELATION);
			boolean validateStatus=dvh.validateStatus(e,statusList);
			if(!validateStatus)
				description.add(ApplicationConstants.COLUMN_HEADER_STATUS);
			boolean validateCountries=dvh.validateCountries(e,countriesList);
			if(!validateCountries)
				description.add(ApplicationConstants.COLUMN_HEADER_COUNTRY);
			boolean validateRegion=dvh.validateRegion(e,regionList);
			if(!validateRegion)
				description.add(ApplicationConstants.COLUMN_HEADER_REGION);
			
			
			boolean validateOnShoreOrOffshore=dvh.validateOnShoreOrOffshore(e);
			if(!validateOnShoreOrOffshore)
				description.add(ApplicationConstants.COLUMN_HEADER_ONSHORE_OR_OFFSHORE);
			
			boolean validateOperator=dvh.validateOperator(e,singleSourceList);
			if(!validateOperator)
				description.add(ApplicationConstants.COLUMN_HEADER_OPERATOR);
			
			boolean validateEquityPartners=dvh.validateEquityPartners(e,singleSourceList);
			if(!validateEquityPartners)
				description.add(ApplicationConstants.COLUMN_HEADER_EQUITY_PARTNERS); 
			
			boolean validateEquityStakes=dvh.validateEquityStakes(e,pipelinesList,equityStakes);
			if(!validateEquityStakes)
				description.add(ApplicationConstants.COLUMN_HEADER_EQUITY_STAKES);// of:"+e.getPipeline());
			
			boolean  validatePipeLineSpecificFields=true;
			Set<String> pipeLineSpecificFields=dvh.validatePipeLineSpecificFields(e,pipeLineSourceList,countriesList,regionList);
			if(pipeLineSpecificFields.size()>0)
			{
				validatePipeLineSpecificFields=false;
				description.addAll(pipeLineSpecificFields);
			}
			
		  
			
					if(!validateParentChildRelation || !validateStatus || !validateCountries || !validateRegion || !validateOnShoreOrOffshore || !validateOperator || !validateEquityPartners || !validateEquityStakes || !validatePipeLineSpecificFields)
					{
						
						recordsList.append(recordCount+",");
						if(totalRecords==(12*linebreak))
						{	
							recordsList.append(" ");// Adding space for rendering in front end;
							linebreak++;
						}	
						totalRecords++;
					}
					recordCount++;
		}
		createTabData(tab,recordsList,description,totalRecords);
		logger.info("PipeLines -> Rows:"+tab.getRecords()+":Total records:"+tab.getTotalRecords()+"Description:"+tab.getDescription());
		return tab;
		
	}
	private Tab validateSupplyDemandData(List<SupplyDemand> supplyDemandList,String tabName)throws Exception
	{
		logger.info("Class - ExcelDataValidation - validateSupplyDemandData()");
		int totalRecords=0;
		StringBuffer recordsList=new StringBuffer("");
		Tab tab=new Tab();
		tab.setName(tabName);
		int recordCount=2;
		int linebreak=1;		
		Set<String> description=new HashSet<String>();
		DataValidationHelper dvh=new DataValidationHelper();
		SourceHelper sh=new SourceHelper();
		
		List<String> countriesList=sh.getCountriesList();
		List<String> regionList=sh.getRegionList();
		for(SupplyDemand e: supplyDemandList)
		{
						
			boolean validateCountries=dvh.validateCountries(e,countriesList);
			if(!validateCountries)
				description.add(ApplicationConstants.COLUMN_HEADER_COUNTRY);
			boolean validateRegion=dvh.validateRegion(e,regionList);
			if(!validateRegion)
				description.add(ApplicationConstants.COLUMN_HEADER_REGION);
							  		
					if(!validateCountries || !validateRegion)
					{
						
						recordsList.append(recordCount+",");
//						if(totalRecords==(12*linebreak))
//						{	As we have we only two columns to validate line break is not required
//							recordsList.append(" ");// Adding space for rendering in front end;
//							linebreak++;
//						}	
						totalRecords++;
					}
					recordCount++;
		}
		createTabData(tab,recordsList,description,totalRecords);
		logger.info("SupplyDemand -> Rows:"+tab.getRecords()+":Total records:"+tab.getTotalRecords()+"Description:"+tab.getDescription());
		return tab;
		
	}
	private Tab validateContractsData(List<Contracts> contractsList,String tabName)throws Exception
	{
		logger.info("Class - ExcelDataValidation - validateContractsData()");
		int totalRecords=0;
		StringBuffer recordsList=new StringBuffer("");
		Tab tab=new Tab();
		tab.setName(tabName);
		int recordCount=2;
		int linebreak=1;		
		Set<String> description=new HashSet<String>();
		DataValidationHelper dvh=new DataValidationHelper();
		SourceHelper sh=new SourceHelper();
		
		List<String> countriesList=sh.getCountriesList();
		List<String> importCountriesList=sh.getImportCountriesList();
		
		for(Contracts e: contractsList)
		{
						
			boolean validateExportCountries=dvh.validateCountries(e,countriesList,"export");
			if(!validateExportCountries)
				description.add(ApplicationConstants.EXPORT_COLUMN_HEADER_COUNTRY);
			boolean validateImportCountries=dvh.validateCountries(e,importCountriesList,"import");
			if(!validateImportCountries)
				description.add(ApplicationConstants.IMPORT_COLUMN_HEADER_COUNTRY);
				
							  		
					if(!validateExportCountries || !validateImportCountries)
					{
						
						recordsList.append(recordCount+",");
//						if(totalRecords==(12*linebreak))
//						{	As we have we only two columns to validate line break is not required
//							recordsList.append(" ");// Adding space for rendering in front end;
//							linebreak++;
//						}	
						totalRecords++;
					}
					recordCount++;
		}
		createTabData(tab,recordsList,description,totalRecords);
		logger.info("Contracts -> Rows:"+tab.getRecords()+":Total records:"+tab.getTotalRecords()+"Description:"+tab.getDescription());
		return tab;
		
	}
	private Tab validateCompanyOilGasData(List<CompanyOilGas> companyOilGasList,String tabName)throws Exception
	{

		logger.info("Class - ExcelDataValidation - validateCompanyOilGasData()");
		int totalRecords=0;
		StringBuffer recordsList=new StringBuffer("");
		Tab tab=new Tab();
		tab.setName(tabName);
		int recordCount=2;
		int linebreak=1;		
		Set<String> description=new HashSet<String>();
		DataValidationHelper dvh=new DataValidationHelper();
		SourceHelper sh=new SourceHelper();
		
		List<String> countriesList=sh.getCountriesList();
		List<String> regionsList=sh.getRegionList();
		List<String> singleSourceList=sh.getSingleSourceList();
		
		for(CompanyOilGas cog: companyOilGasList)
		{
			boolean validateCompanyName=dvh.validateCurrentOwners(cog, singleSourceList);	
			if(!validateCompanyName)
				description.add(ApplicationConstants.COLUMN_HEADER_COMPANYNAME);
			boolean validateCountries=dvh.validateCountries(cog,countriesList);
			if(!validateCountries)
				description.add(ApplicationConstants.COLUMN_HEADER_COUNTRY);
			boolean validateRegions=dvh.validateRegion(cog,regionsList);
			if(!validateRegions)
				description.add(ApplicationConstants.COLUMN_HEADER_REGION);
			
			boolean oilGasType=dvh.validateOilGasType(cog);
			if(!oilGasType)
				description.add(ApplicationConstants.COLUMN_HEADER_TYPE);
				
							  		
					if(!validateCompanyName || !validateCountries || !validateRegions || !oilGasType)
					{
						
						recordsList.append(recordCount+",");
//						if(totalRecords==(12*linebreak))
//						{	As we have we only two columns to validate line break is not required
//							recordsList.append(" ");// Adding space for rendering in front end;
//							linebreak++;
//						}	
						totalRecords++;
					}
					recordCount++;
		}
		createTabData(tab,recordsList,description,totalRecords);
		logger.info("CompanyOilGas -> Rows:"+tab.getRecords()+":Total records:"+tab.getTotalRecords()+"Description:"+tab.getDescription());
		return tab;
		
	
	}
	private Tab validateSmallScaleLngData(List<SmallScaleLng> smallScaleLngList,String tabName)throws Exception
	{

		logger.info("Class - ExcelDataValidation - validateSmallScaleLngData()");
		int totalRecords=0;
		StringBuffer recordsList=new StringBuffer("");
		Tab tab=new Tab();
		tab.setName(tabName);
		int recordCount=2;
		int linebreak=1;		
		Set<String> description=new HashSet<String>();
		DataValidationHelper dvh=new DataValidationHelper();
		SourceHelper sh=new SourceHelper();
		
		List<String> countriesList=sh.getCountriesList();
		List<String> regionsList=sh.getRegionList();
		List<String> statusList=sh.getStatusList();
		List<String> smallScaleLngSourceList=sh.getSmallScaleLngSourceList();
		List<String> singleSourceList=sh.getSingleSourceList();
		
		for(SmallScaleLng ssl: smallScaleLngList)
		{
			boolean validateStatus=dvh.validateStatus(ssl, statusList);	
			if(!validateStatus)
				description.add(ApplicationConstants.COLUMN_HEADER_STATUS);
			
			boolean validateType=dvh.validateType(ssl, smallScaleLngSourceList);
			if(!validateType)
				description.add(ApplicationConstants.COLUMN_HEADER_TYPE);
			
			boolean validateCountries=dvh.validateCountries(ssl, countriesList);
			if(!validateCountries)
				description.add(ApplicationConstants.COLUMN_HEADER_COUNTRY);
			
			boolean validateRegions=dvh.validateRegion(ssl, regionsList);
			if(!validateRegions)
				description.add(ApplicationConstants.COLUMN_HEADER_REGION);
			
			boolean validateCompany=dvh.validateCompany(ssl,singleSourceList);
			if(!validateCompany)
				description.add(ApplicationConstants.COLUMN_HEADER_COMPANY);
			
			boolean validateTechProviderComp=dvh.validateTechnologyProviderCompany(ssl,singleSourceList);
			if(!validateTechProviderComp)
				description.add(ApplicationConstants.COLUMN_HEADER_TECHNOLOGY_PROVIDER_COMPANY);
			
			boolean validateSslSpecificFields=true;
			Set<String> sslSpecificFields=dvh.validateSmallScaleLngSpecificFields(ssl,smallScaleLngSourceList);
			if(sslSpecificFields.size()>0)
			{
				validateSslSpecificFields=false;
				description.addAll(sslSpecificFields);
			}		
			if(!validateStatus || !validateType || !validateCountries || !validateRegions || !validateCompany || !validateTechProviderComp || !validateSslSpecificFields)
			{
						logger.info("SmallScaleLngData -> validation failure");
						recordsList.append(recordCount+",");
//						if(totalRecords==(12*linebreak))
//						{	As we have we only two columns to validate line break is not required
//							recordsList.append(" ");// Adding space for rendering in front end;
//							linebreak++;
//						}	
						totalRecords++;
			}
			recordCount++;
		}
		createTabData(tab,recordsList,description,totalRecords);
		logger.info("SmallScaleLngData -> Rows:"+tab.getRecords()+":Total records:"+tab.getTotalRecords()+"Description:"+tab.getDescription());
		return tab;
		
	
	}
	private void createTabData(Tab tab,StringBuffer recordsList,Set<String> description,int totalRecords)
	{
		logger.info("Class - ExcelDataValidation - createTabData()");
		StringBuffer descriptionList=new StringBuffer("");
		tab.setTotalRecords(totalRecords);
		
		if(!("").equalsIgnoreCase(recordsList.toString()) && recordsList.length()>0)
		{
			if(recordsList.charAt(recordsList.length()-1)==32)
				recordsList.deleteCharAt(recordsList.length()-2); // To remove comma at the end;
			else
				recordsList.deleteCharAt(recordsList.length()-1); // To remove comma at the end;
		}
			
		tab.setRecords(recordsList.toString());
				
		Object[] descArray=description.toArray();
		for(int k=0;k<descArray.length;k++)
		{
			 descriptionList.append(descArray[k]);
			 if(k<descArray.length-1)
				 descriptionList.append(",");
		}
		tab.setDescription(descriptionList.toString());
		
	}
}
