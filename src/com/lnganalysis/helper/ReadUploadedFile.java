package com.lnganalysis.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.lnganalysis.constants.ApplicationConstants;
import com.lnganalysis.constants.LngData;
import com.lnganalysis.dao.domain.impl.CompanyOilGasDaoImpl;
import com.lnganalysis.dao.domain.impl.ContractsDaoImpl;
import com.lnganalysis.dao.domain.impl.CrudeOilDaoImpl;
import com.lnganalysis.dao.domain.impl.ExplorationDaoImpl;
import com.lnganalysis.dao.domain.impl.HistoryDaoImpl;
import com.lnganalysis.dao.domain.impl.LngDaoImpl;
import com.lnganalysis.dao.domain.impl.NaturalGasDaoImpl;
import com.lnganalysis.dao.domain.impl.PipelineDaoImpl;
import com.lnganalysis.dao.domain.impl.RefineryDaoImpl;
import com.lnganalysis.dao.domain.impl.SmallScaleLngDaoImpl;
import com.lnganalysis.dao.domain.impl.StorageDaoImpl;
import com.lnganalysis.dao.domain.impl.SupplyDemandDaoImpl;
import com.lnganalysis.dto.Tab;
import com.lnganalysis.entities.domain.CompanyOilGas;
import com.lnganalysis.entities.domain.Contracts;
import com.lnganalysis.entities.domain.CrudeOil;
import com.lnganalysis.entities.domain.Exploration;
import com.lnganalysis.entities.domain.History;
import com.lnganalysis.entities.domain.Lng;
import com.lnganalysis.entities.domain.NaturalGas;
import com.lnganalysis.entities.domain.PipeLine;
import com.lnganalysis.entities.domain.Refinery;
import com.lnganalysis.entities.domain.SmallScaleLng;
import com.lnganalysis.entities.domain.Storage;
import com.lnganalysis.entities.domain.User;
import com.lnganalysis.fileupload.util.ExcelDataValidation;
import com.lnganalysis.fileupload.util.ReadExcelFile;



public class ReadUploadedFile {
	static final Logger logger=Logger.getLogger(ReadUploadedFile.class);
//	private static FileInputStream fis=null;
//	private static List excelData=null;
//	public static void main(String args[])
//	{
//		try
//		{
//						
////			File f=new File("C:\\Jeevan\\Personal\\OGanalysisData\\Database Samples.xlsx");
//			File f=new File("C:\\Jeevan\\Personal\\OGanalysisData\\projectBkp\\Database Samples.xlsx");
//			fis=new FileInputStream(f);
//			Map<String,List<Tab>> errorTabMap=null;
//			errorTabMap=readUploadFile(fis,null);
//			System.out.println(errorTabMap);
//			JsonResponse.createFileUploadResponse(errorTabMap);
////			XSSFWorkbook uploadedFile=new XSSFWorkbook(fis);
////			int sheetCount=uploadedFile.getNumberOfSheets();
////			System.out.println(sheetCount);
////			Map excelSheetsData=new HashMap();
////			for(int i=0;i<sheetCount;i++)
////			{
////				XSSFSheet sheet=uploadedFile.getSheetAt(i);
////				List sheetsDataList=readData(sheet);
////				excelSheetsData.put(sheet.getSheetName().toLowerCase(),sheetsDataList);
////			}		
////			
////			//Here validate
////			List<Tab> tabList=DataValidationUtility.validateData(excelSheetsData);
//			
//		}
//		catch(Exception e)
//		{
//			System.out.println(e);
//		}
//		
//	}
	public Map<String,List<Tab>> readUploadFile(InputStream fis,User user,String action)throws Exception
	{
		logger.info("Class - ReadUploadedFile - readUploadFile()");
		List<Tab> invalidDataTabList=null;
		Map<String,List<Tab>> processedSheet=null;		
		ReadExcelFile readExcelFile=null;
		ExcelDataValidation excelDataValidaton=null;
		Workbook uploadedFile=null; 
		try
		{
			uploadedFile=WorkbookFactory.create(fis);
			//XSSFWorkbook uploadedFile=new XSSFWorkbook(fis); Comment this for time being
//			int sheetCount=uploadedFile.getNumberOfSheets();
		  	readExcelFile=new ReadExcelFile();
			List<Tab> readTabList=new ArrayList<Tab>();
			Map<String,List> excelSheetsData=readExcelFile.readExcelData(uploadedFile,readTabList);	
			if(excelSheetsData.size()==0)
			{
				processedSheet=new HashMap<String,List<Tab>>();
				processedSheet.put(ApplicationConstants.INVALID_DATA_SHEET, readTabList);
			}
			else
			{
				if(null!=readTabList && readTabList.size()>0)
				{
					processedSheet=new HashMap<String,List<Tab>>();
					processedSheet.put(ApplicationConstants.INCORRECT_DATA, readTabList);
					return processedSheet;
				}
				else
				{
					//Here validate
					excelDataValidaton=new ExcelDataValidation();
					
					invalidDataTabList=excelDataValidaton.validateExcelData(excelSheetsData);
//					invalidDataTabList=new ArrayList<Tab>();
					if(invalidDataTabList.size()>0)
					{
						processedSheet=new HashMap<String,List<Tab>>();
						processedSheet.put(ApplicationConstants.DATA_VALIDATION_FAIL, invalidDataTabList);
						return processedSheet;
					}
					else if(invalidDataTabList.size()==0)
					{
						if(null!=action && ("insert").equalsIgnoreCase(action))
						saveSheetsData(excelSheetsData,user);
						else 
						updateSheetsData(excelSheetsData,user);
					}
				}
			}
		}
		finally
		{
			uploadedFile.close();
		}
												
		return processedSheet;
		
	}
	private void updateSheetsData(Map<String,List> excelSheetsData,User user)throws Exception
	{
		logger.info("Class - ReadUploadedFile - updateSheetsData()");
    	History history=new History();	
		Set<String> keys=excelSheetsData.keySet(); 
		for(String key:keys)
		{
			if(key.equalsIgnoreCase(LngData.EXPLORATION.toString()))
			{
				List explorationList=(List)excelSheetsData.get(key);
				ExplorationDaoImpl explorationDao=new ExplorationDaoImpl();
				Set<String> namesSet=new HashSet<String>();
				for(int i=0;i<explorationList.size();i++)
				{
					Exploration exploration=(Exploration)explorationList.get(i);
					namesSet.add(exploration.getBlockNo());
				}				
				explorationDao.delete(namesSet);
				explorationDao.save(explorationList);
				history.setExplorationCount(explorationList.size());
			}
			else if(key.equalsIgnoreCase(LngData.REFINERIES.toString()))
			{
				List refineryList=(List)excelSheetsData.get(key);
				RefineryDaoImpl refineryDao=new RefineryDaoImpl();
				Set<String> namesSet=new HashSet<String>();
				for(int i=0;i<refineryList.size();i++)
				{
					Refinery refinery=(Refinery)refineryList.get(i);
					namesSet.add(refinery.getName());
				}
				refineryDao.delete(namesSet);
				refineryDao.save(refineryList);
				history.setRefineriesCount(refineryList.size());
			}
			else if(key.equalsIgnoreCase(LngData.CRUDEOIL.toString()))
			{
				List crudeOilList=(List)excelSheetsData.get(key);
				CrudeOilDaoImpl crudeOilDao=new CrudeOilDaoImpl();
				Set<String> namesSet=new HashSet<String>();
				for(int i=0;i<crudeOilList.size();i++)
				{
					CrudeOil crudeOil=(CrudeOil)crudeOilList.get(i);
					namesSet.add(crudeOil.getField());
				}
				crudeOilDao.delete(namesSet);
				crudeOilDao.save(crudeOilList);
				history.setCrudeOilCount(crudeOilList.size());
			}
			else if(key.equalsIgnoreCase(LngData.NATURALGAS.toString()))
			{
				List naturalGasList=(List)excelSheetsData.get(key);
				NaturalGasDaoImpl naturalGasDao=new NaturalGasDaoImpl();
				Set<String> namesSet=new HashSet<String>();
				for(int i=0;i<naturalGasList.size();i++)
				{
					NaturalGas naturalGas=(NaturalGas)naturalGasList.get(i);
					namesSet.add(naturalGas.getField());
				}
				naturalGasDao.delete(namesSet);
				naturalGasDao.save(naturalGasList);
				history.setNaturalGasCount(naturalGasList.size());
			}
			else if(key.equalsIgnoreCase(LngData.STORAGE.toString()))
			{
				List storageList=(List)excelSheetsData.get(key);
				StorageDaoImpl storageDao=new StorageDaoImpl();
				Set<String> namesSet=new HashSet<String>();
				for(int i=0;i<storageList.size();i++)
				{
					Storage storage=(Storage)storageList.get(i);
					namesSet.add(storage.getTankFarm());
				}
				storageDao.delete(namesSet);
				storageDao.save(storageList);
				history.setStorageCount(storageList.size());
			}
			else if(key.equalsIgnoreCase(LngData.LNG.toString()))
			{
				List lngList=(List)excelSheetsData.get(key);
				LngDaoImpl lngDao=new LngDaoImpl();
				Set<String> namesSet=new HashSet<String>();
				for(int i=0;i<lngList.size();i++)
				{
					Lng lng=(Lng)lngList.get(i);
					namesSet.add(lng.getName());
				}
				lngDao.delete(namesSet);
				lngDao.save(lngList);
				history.setLngCount(lngList.size());
			}
			else if(key.equalsIgnoreCase(LngData.PIPELINES.toString()))
			{
				List pipeLineList=(List)excelSheetsData.get(key);
				PipelineDaoImpl pipeLineDao=new PipelineDaoImpl();
				Set<String> namesSet=new HashSet<String>();
				for(int i=0;i<pipeLineList.size();i++)
				{
					PipeLine pipeLine=(PipeLine)pipeLineList.get(i);
					namesSet.add(pipeLine.getPipeline());
				}
				pipeLineDao.delete(namesSet);
				pipeLineDao.save(pipeLineList);
				history.setPipelinesCount(pipeLineList.size());
			}
			else if(key.equalsIgnoreCase(LngData.CONTRACTS.toString()))
			{
				List contractsList=(List)excelSheetsData.get(key);
				ContractsDaoImpl contractsDao=new ContractsDaoImpl();
				Set<String> namesSet=new HashSet<String>();
				for(int i=0;i<contractsList.size();i++)
				{
					Contracts contracts=(Contracts)contractsList.get(i);
					namesSet.add(contracts.getContractIndicator());
				}
				contractsDao.delete(namesSet);
				contractsDao.save(contractsList);
				history.setContractsCount(contractsList.size());
			}
			else if(key.equalsIgnoreCase(LngData.PRODUCTION_COMPANY_OILGAS.toString()))
			{
				List companyOilGasList=(List)excelSheetsData.get(key);
				CompanyOilGasDaoImpl companyOilGasDao=new CompanyOilGasDaoImpl();
				Set<String> namesSet=new HashSet<String>();
				for(int i=0;i<companyOilGasList.size();i++)
				{
					CompanyOilGas companyOilGas=(CompanyOilGas)companyOilGasList.get(i);
					namesSet.add(companyOilGas.getName());
				}
				companyOilGasDao.delete(namesSet);
				companyOilGasDao.save(companyOilGasList);
				history.setCompanyOilGasCount(companyOilGasList.size());
			}
			else if(key.equalsIgnoreCase(LngData.SMALLSCALELNG.toString()))
			{
				List smallScaleLngList=(List)excelSheetsData.get(key);
				SmallScaleLngDaoImpl smallScaleLngDao=new SmallScaleLngDaoImpl();
				Set<String> namesSet=new HashSet<String>();
				for(int i=0;i<smallScaleLngList.size();i++)
				{
					SmallScaleLng smallScaleLng=(SmallScaleLng)smallScaleLngList.get(i);
					namesSet.add(smallScaleLng.getTerminalName());
				}
				smallScaleLngDao.delete(namesSet);
				smallScaleLngDao.save(smallScaleLngList);
				history.setSmallScaleLngCount(smallScaleLngList.size());
			}
			
		}
		HistoryDaoImpl historyDao=new HistoryDaoImpl();
		history.setUser(user);
		history.setCreatedDate(new Date());
		historyDao.saveHistory(history);
		
    
	}
    private void saveSheetsData(Map<String,List> excelSheetsData,User user)throws Exception
    {
    	logger.info("Class - ReadUploadedFile - saveSheetsData()");
    	History history=new History();	
		Set<String> keys=excelSheetsData.keySet(); 
		for(String key:keys)
		{
			if(key.equalsIgnoreCase(LngData.EXPLORATION.toString()))
			{
				List explorationList=(List)excelSheetsData.get(key);
				ExplorationDaoImpl explorationDao=new ExplorationDaoImpl();
				explorationDao.save(explorationList);
				history.setExplorationCount(explorationList.size());
			}
			else if(key.equalsIgnoreCase(LngData.REFINERIES.toString()))
			{
				List refineryList=(List)excelSheetsData.get(key);
				RefineryDaoImpl refineryDao=new RefineryDaoImpl();
				refineryDao.save(refineryList);
				history.setRefineriesCount(refineryList.size());
			}
			else if(key.equalsIgnoreCase(LngData.CRUDEOIL.toString()))
			{
				List crudeOilList=(List)excelSheetsData.get(key);
				CrudeOilDaoImpl crudeOilDao=new CrudeOilDaoImpl();
				crudeOilDao.save(crudeOilList);
				history.setCrudeOilCount(crudeOilList.size());
			}
			else if(key.equalsIgnoreCase(LngData.NATURALGAS.toString()))
			{
				List naturalGasList=(List)excelSheetsData.get(key);
				NaturalGasDaoImpl naturalGasDao=new NaturalGasDaoImpl();
				naturalGasDao.save(naturalGasList);
				history.setNaturalGasCount(naturalGasList.size());
			}
			else if(key.equalsIgnoreCase(LngData.STORAGE.toString()))
			{
				List storageList=(List)excelSheetsData.get(key);
				StorageDaoImpl storageDao=new StorageDaoImpl();
				storageDao.save(storageList);
				history.setStorageCount(storageList.size());
			}
			else if(key.equalsIgnoreCase(LngData.LNG.toString()))
			{
				List lngList=(List)excelSheetsData.get(key);
				LngDaoImpl lngDao=new LngDaoImpl();
				lngDao.save(lngList);
				history.setLngCount(lngList.size());
			}
			else if(key.equalsIgnoreCase(LngData.PIPELINES.toString()))
			{
				List pipeLineList=(List)excelSheetsData.get(key);
				PipelineDaoImpl pipeLineDao=new PipelineDaoImpl();
				pipeLineDao.save(pipeLineList);
				history.setPipelinesCount(pipeLineList.size());
			}
			else if(key.equalsIgnoreCase(LngData.SUPPLYDEMAND.toString()))
			{
				List supplyDemandList=(List)excelSheetsData.get(key);
				SupplyDemandDaoImpl supplyDemandDao=new SupplyDemandDaoImpl();
				supplyDemandDao.save(supplyDemandList);
				history.setSupplyDemandCount(supplyDemandList.size());
			}
			else if(key.equalsIgnoreCase(LngData.CONTRACTS.toString()))
			{
				List contractsList=(List)excelSheetsData.get(key);
				ContractsDaoImpl contractsDao=new ContractsDaoImpl();
				contractsDao.save(contractsList);
				history.setContractsCount(contractsList.size());
			}
			else if(key.equalsIgnoreCase(LngData.PRODUCTION_COMPANY_OILGAS.toString()))
			{
				List companyOilGasList=(List)excelSheetsData.get(key);
				CompanyOilGasDaoImpl CompanyOilGasDao=new CompanyOilGasDaoImpl();
				CompanyOilGasDao.save(companyOilGasList);
				history.setCompanyOilGasCount(companyOilGasList.size());
			}
			else if(key.equalsIgnoreCase(LngData.SMALLSCALELNG.toString()))
			{
				List smallScaleLngList=(List)excelSheetsData.get(key);
				SmallScaleLngDaoImpl smallScaleLngDao=new SmallScaleLngDaoImpl();
				smallScaleLngDao.save(smallScaleLngList);
				history.setSmallScaleLngCount(smallScaleLngList.size());
			}
			
		}
		HistoryDaoImpl historyDao=new HistoryDaoImpl();
		history.setUser(user);
		history.setCreatedDate(new Date());
		historyDao.saveHistory(history);
		
    }
}

