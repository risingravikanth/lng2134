package com.lnganalysis.fileupload.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.lnganalysis.constants.LngData;
import com.lnganalysis.dto.Tab;
import com.lnganalysis.entities.domain.Contracts;
import com.lnganalysis.entities.domain.CrudeOil;
import com.lnganalysis.entities.domain.Exploration;
import com.lnganalysis.entities.domain.Lng;
import com.lnganalysis.entities.domain.NaturalGas;
import com.lnganalysis.entities.domain.PipeLine;
import com.lnganalysis.entities.domain.Refinery;
import com.lnganalysis.entities.domain.Storage;
import com.lnganalysis.entities.domain.SupplyDemand;

public class ReadExcelFile {
	static final Logger logger=Logger.getLogger(ReadExcelFile.class);
	static final DataFormatter df=new DataFormatter();
	static final String BLANK="";
	public Map<String,List> readExcelData(Workbook wb,List<Tab> tabsList)
	{
		logger.info("Class - ReadExcelFile - readExcelData()");
		int sheetCount=wb.getNumberOfSheets();		
		Map<String,List> populatedData=new HashMap<String,List>();
		
		for(int i=0;i<sheetCount;i++)
		{
			Sheet sheet=wb.getSheetAt(i);
			if(sheet.getSheetName().toLowerCase().equalsIgnoreCase(LngData.EXPLORATION.toString()))
			{
				Tab tab=new Tab();
				List<Exploration> explorationList=populateExplorationData(sheet,tab);
				if(tab!=null && tab.getTotalRecords()>0)
					tabsList.add(tab);
				populatedData.put(sheet.getSheetName().toLowerCase(),explorationList);
				
			}
			else if(sheet.getSheetName().toLowerCase().equalsIgnoreCase(LngData.REFINERIES.toString()))
			{
				Tab tab=new Tab();
				List<Refinery> refineryList=populateRefineryData(sheet,tab);
				if(tab!=null && tab.getTotalRecords()>0)
					tabsList.add(tab);
				populatedData.put(sheet.getSheetName().toLowerCase(),refineryList);
				
			}
			else if(sheet.getSheetName().toLowerCase().equalsIgnoreCase(LngData.STORAGE.toString()))
			{
				Tab tab=new Tab();
				List<Storage> storageList=populateStorageData(sheet,tab);
				if(tab!=null && tab.getTotalRecords()>0)
					tabsList.add(tab);
				populatedData.put(sheet.getSheetName().toLowerCase(),storageList);
				
			}
			else if(sheet.getSheetName().toLowerCase().equalsIgnoreCase(LngData.LNG.toString()))
			{
				Tab tab=new Tab();
				List<Lng> lngList=populateLngData(sheet,tab);
				if(tab!=null && tab.getTotalRecords()>0)
					tabsList.add(tab);
				populatedData.put(sheet.getSheetName().toLowerCase(),lngList);
				
			}
			else if(sheet.getSheetName().toLowerCase().equalsIgnoreCase(LngData.PIPELINES.toString()))
			{
				Tab tab=new Tab();
				List<PipeLine> pipeLineList=populatePipeLinesData(sheet, tab);
				if(tab!=null && tab.getTotalRecords()>0)
					tabsList.add(tab);
				populatedData.put(sheet.getSheetName().toLowerCase(),pipeLineList);
				
			}
			else if(sheet.getSheetName().toLowerCase().equalsIgnoreCase(LngData.CRUDEOIL.toString()))
			{
				Tab tab=new Tab();
				List<CrudeOil> crudeOilList=populateCrudeOilData(sheet, tab);
				if(tab!=null && tab.getTotalRecords()>0)
					tabsList.add(tab);
				populatedData.put(sheet.getSheetName().toLowerCase(),crudeOilList);
				
			}
			else if(sheet.getSheetName().toLowerCase().equalsIgnoreCase(LngData.NATURALGAS.toString()))
			{
				Tab tab=new Tab();
				List<NaturalGas> naturalGasList=populateNaturalGasData(sheet, tab);
				if(tab!=null && tab.getTotalRecords()>0)
					tabsList.add(tab);
				populatedData.put(sheet.getSheetName().toLowerCase(),naturalGasList);
				
			}
			else if(sheet.getSheetName().toLowerCase().equalsIgnoreCase(LngData.SUPPLYDEMAND.toString()))
			{
				Tab tab=new Tab();
				List<SupplyDemand> supplyDemandList=populateSupplyDemandData(sheet,tab);
				if(tab!=null && tab.getTotalRecords()>0)
					tabsList.add(tab);
				populatedData.put(sheet.getSheetName(),supplyDemandList);
			}
			else if(sheet.getSheetName().equalsIgnoreCase(LngData.CONTRACTS.toString()))
			{
				Tab tab=new Tab();
				List<Contracts> contractsList=populateContractsData(sheet,tab);
				if(tab!=null && tab.getTotalRecords()>0)
					tabsList.add(tab);
				populatedData.put(sheet.getSheetName(), contractsList);
			}
		}
		
		return populatedData;
	}
	private List<Contracts> populateContractsData(Sheet sheet,Tab tab)
	{
		logger.info("Class - ReadExcelFile - populateContractsData()");
		int columnNo=0;
		List<Contracts> contractsList=new ArrayList<Contracts>();
		int rowCount=sheet.getLastRowNum();
		
		int totalRecords=0;
		StringBuffer recordsList=new StringBuffer("");					
		Set<String> columnNamesSet=new HashSet<String>();		
//		DataFormatter df=new DataFormatter();
		int linebreak=1;
		for(int i=1;i<=rowCount;i++)
		{
			Row row=sheet.getRow(i);
			Contracts contracts=new Contracts();
			try
			{
				columnNo=0;contracts.setContractIndicator(null==row.getCell(0) || null==df.formatCellValue(row.getCell(0)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(0)))?BLANK:df.formatCellValue(row.getCell(0)));
				columnNo=1;contracts.setYear(null==row.getCell(1)|| null==df.formatCellValue(row.getCell(1)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(1)))?0:Integer.parseInt(df.formatCellValue(row.getCell(1))));
				columnNo=2;contracts.setExportTerminal(null==row.getCell(2)|| null==df.formatCellValue(row.getCell(2)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(2)))?BLANK:df.formatCellValue(row.getCell(2)));
				columnNo=3;contracts.setExportCountry(null==row.getCell(3)|| null==df.formatCellValue(row.getCell(3)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(3)))?BLANK:df.formatCellValue(row.getCell(3)));
				columnNo=4;contracts.setExportCompany(null==row.getCell(4)|| null==df.formatCellValue(row.getCell(4)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(4)))?BLANK:df.formatCellValue(row.getCell(4)));
				columnNo=5;contracts.setImportTerminal(null==row.getCell(5)|| null==df.formatCellValue(row.getCell(5)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(5)))?BLANK:df.formatCellValue(row.getCell(5)));
				columnNo=6;contracts.setImportCountry(null==row.getCell(6)|| null==df.formatCellValue(row.getCell(6)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(6)))?BLANK:df.formatCellValue(row.getCell(6)));
				columnNo=7;contracts.setImportCompany(null==row.getCell(7)|| null==df.formatCellValue(row.getCell(7)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(7)))?BLANK:df.formatCellValue(row.getCell(7)));
				columnNo=8;contracts.setContractedQuantity(null==row.getCell(8)|| null==df.formatCellValue(row.getCell(8)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(8)))?0:Float.valueOf(df.formatCellValue(row.getCell(8))));
				columnNo=9;contracts.setContractAgreementDate(null==row.getCell(9)|| null==df.formatCellValue(row.getCell(9)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(9)))?BLANK:df.formatCellValue(row.getCell(9)));
				columnNo=10;contracts.setContractStartFrom(null==row.getCell(10) || null==df.formatCellValue(row.getCell(10)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(10)))?0:Integer.parseInt(df.formatCellValue(row.getCell(10))));
				columnNo=11;contracts.setContractEndsIn(null==row.getCell(11) || null==df.formatCellValue(row.getCell(11)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(11)))?0:Integer.parseInt(df.formatCellValue(row.getCell(11))));
				columnNo=12;contracts.setTypeOfTransportation(null==row.getCell(12)|| null==df.formatCellValue(row.getCell(12)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(12)))?BLANK:df.formatCellValue(row.getCell(12)));
				columnNo=13;contracts.setContractAgreementStatus(null==row.getCell(13)|| null==df.formatCellValue(row.getCell(13)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(13)))?BLANK:df.formatCellValue(row.getCell(13)));
				columnNo=14;contracts.setContractAdditionalDetails(null==row.getCell(14)|| null==df.formatCellValue(row.getCell(14)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(14)))?BLANK:df.formatCellValue(row.getCell(14)));
				columnNo=15;contracts.setSources(null==row.getCell(15)|| null==df.formatCellValue(row.getCell(15)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(15)))?BLANK:df.formatCellValue(row.getCell(15)));
				contractsList.add(contracts);
			}
			catch(Exception e)
			{	
				logger.info("Class - ReadExcelFile - populateContractsData():"+e);
				totalRecords++;
				String columnName=getHeaderValues(sheet, columnNo);
				recordsList.append((row.getRowNum()+1)+",");
				if(totalRecords==(12*linebreak))
				{	
					recordsList.append(" ");// Adding space for rendering in front end;
					linebreak++;
				}	
				columnNamesSet.add(columnName);
				
				
			}
		
		}		
		if(totalRecords>0)
		{
			
			createTabData(tab,sheet.getSheetName().toUpperCase(),totalRecords,recordsList,columnNamesSet);
			logger.info("Contracts totalRecords:"+ totalRecords+"recordsList:"+recordsList);
		}
		logger.info("Total objects set for NaturalGas:"+contractsList.size());
		return contractsList;
	}
	private List<SupplyDemand> populateSupplyDemandData(Sheet sheet,Tab tab)
	{
		logger.info("Class - ReadExcelFile - populateSupplyDemandData");
		int columnNo=0;
		List<SupplyDemand> supplyDemandList=new ArrayList<SupplyDemand>();
		int rowCount=sheet.getLastRowNum();
		final String  hypen="-";
		int totalRecords=0;
		StringBuffer recordsList=new StringBuffer("");					
		Set<String> columnNamesSet=new HashSet<String>();		
		int linebreak=1;
//		DataFormatter df=new DataFormatter();
		for(int i=1;i<=rowCount;i++)
		{
			Row row=sheet.getRow(i);
			SupplyDemand sd=new SupplyDemand();
			try
			{
							
				columnNo=0;sd.setTradeType(null==row.getCell(0) || null==df.formatCellValue(row.getCell(0))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(0)))?BLANK:df.formatCellValue(row.getCell(0)));
				columnNo=1;sd.setRegion(null==row.getCell(1)|| null==df.formatCellValue(row.getCell(1))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(1)))?BLANK:df.formatCellValue(row.getCell(1)));
				columnNo=2;sd.setCountry(null==row.getCell(2)|| null==df.formatCellValue(row.getCell(2))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(2)))?BLANK:df.formatCellValue(row.getCell(2)));
				
				columnNo=3;
				if(null!=row.getCell(3) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(3))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(3))))
					sd.setYear2000(Float.valueOf(df.formatCellValue(row.getCell(3))));
				columnNo=4;
				if(null!=row.getCell(4) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(4))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(4))))
					sd.setYear2001(Float.valueOf(df.formatCellValue(row.getCell(4))));
				columnNo=5;
				if(null!=row.getCell(5) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(5))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(5))))
					sd.setYear2002(Float.valueOf(df.formatCellValue(row.getCell(5))));
				columnNo=6;
				if(null!=row.getCell(6) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(6))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(6))))
					sd.setYear2003(Float.valueOf(df.formatCellValue(row.getCell(6))));
				columnNo=7;
				if(null!=row.getCell(7) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(7))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(7))))
					sd.setYear2004(Float.valueOf(df.formatCellValue(row.getCell(7))));
				columnNo=8;
				if(null!=row.getCell(8) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(8))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(8))))
					sd.setYear2005(Float.valueOf(df.formatCellValue(row.getCell(8))));
				columnNo=9;
				if(null!=row.getCell(9) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(9))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(9))))
					sd.setYear2006(Float.valueOf(df.formatCellValue(row.getCell(9))));
				columnNo=10;
				if(null!=row.getCell(10) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(10))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(10))))
					sd.setYear2007(Float.valueOf(df.formatCellValue(row.getCell(10))));
				
				
				columnNo=11;
				if(null!=row.getCell(11) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(11))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(11))))
					sd.setYear2008(Float.valueOf(df.formatCellValue(row.getCell(11))));
				columnNo=12;
				if(null!=row.getCell(12) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(12))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(12))))
					sd.setYear2009(Float.valueOf(df.formatCellValue(row.getCell(12))));
				columnNo=13;
				if(null!=row.getCell(13) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(13))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(13))))
					sd.setYear2010(Float.valueOf(df.formatCellValue(row.getCell(13))));
				columnNo=14;
				if(null!=row.getCell(14) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(14))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(14))))
					sd.setYear2011(Float.valueOf(df.formatCellValue(row.getCell(14))));
				columnNo=15;
				if(null!=row.getCell(15) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(15))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(15))))
					sd.setYear2012(Float.valueOf(df.formatCellValue(row.getCell(15))));
				columnNo=16;
				if(null!=row.getCell(16) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(16))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(16))))
					sd.setYear2013(Float.valueOf(df.formatCellValue(row.getCell(16))));
				columnNo=17;
				if(null!=row.getCell(17) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(17))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(17))))
					sd.setYear2014(Float.valueOf(df.formatCellValue(row.getCell(17))));
				columnNo=18;
				if(null!=row.getCell(18) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(18))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(18))))
					sd.setYear2015(Float.valueOf(df.formatCellValue(row.getCell(18))));
				columnNo=19;
				if(null!=row.getCell(19) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(19))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(19))))
					sd.setYear2016(Float.valueOf(df.formatCellValue(row.getCell(19))));
				columnNo=20;
				if(null!=row.getCell(20) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(20))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(20))))
					sd.setYear2017(Float.valueOf(df.formatCellValue(row.getCell(20))));
				
				
				columnNo=21;
				if(null!=row.getCell(21) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(21))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(21))))
					sd.setYear2018(Float.valueOf(df.formatCellValue(row.getCell(21))));
				columnNo=22;
				if(null!=row.getCell(22) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(22))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(22))))
					sd.setYear2019(Float.valueOf(df.formatCellValue(row.getCell(22))));
				columnNo=23;
				if(null!=row.getCell(23) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(23))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(23))))
					sd.setYear2020(Float.valueOf(df.formatCellValue(row.getCell(23))));
				columnNo=24;
				if(null!=row.getCell(24) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(24))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(24))))
					sd.setYear2021(Float.valueOf(df.formatCellValue(row.getCell(24))));
				columnNo=25;
				if(null!=row.getCell(25) && !hypen.equalsIgnoreCase(df.formatCellValue(row.getCell(25))) && !BLANK.equalsIgnoreCase(df.formatCellValue(row.getCell(25))))
					sd.setYear2022(Float.valueOf(df.formatCellValue(row.getCell(25))));
				
				
				
			
				
//				columnNo=4;sd.setYear2001((null==row.getCell(4) || hypen.equalsIgnoreCase(row.getCell(4).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(4).getNumericCellValue()).floatValue());
//				columnNo=5;sd.setYear2002((null==row.getCell(5) || hypen.equalsIgnoreCase(row.getCell(5).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(5).getNumericCellValue()).floatValue());
//				columnNo=6;sd.setYear2003((null==row.getCell(6) || hypen.equalsIgnoreCase(row.getCell(6).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(6).getNumericCellValue()).floatValue());
//				columnNo=7;sd.setYear2004((null==row.getCell(7) || hypen.equalsIgnoreCase(row.getCell(7).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(7).getNumericCellValue()).floatValue());
//				columnNo=8;sd.setYear2005((null==row.getCell(8) || hypen.equalsIgnoreCase(row.getCell(8).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(8).getNumericCellValue()).floatValue());
//				columnNo=9;sd.setYear2006((null==row.getCell(9) || hypen.equalsIgnoreCase(row.getCell(9).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(9).getNumericCellValue()).floatValue());
//				columnNo=10;sd.setYear2007((null==row.getCell(10) || hypen.equalsIgnoreCase(row.getCell(10).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(10).getNumericCellValue()).floatValue());
//				columnNo=11;sd.setYear2008((null==row.getCell(11) || hypen.equalsIgnoreCase(row.getCell(11).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(11).getNumericCellValue()).floatValue());
//				columnNo=12;sd.setYear2009((null==row.getCell(12) || hypen.equalsIgnoreCase(row.getCell(12).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(12).getNumericCellValue()).floatValue());
//				columnNo=13;sd.setYear2010((null==row.getCell(13) || hypen.equalsIgnoreCase(row.getCell(13).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(13).getNumericCellValue()).floatValue());
//				columnNo=14;sd.setYear2011((null==row.getCell(14) || hypen.equalsIgnoreCase(row.getCell(14).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(14).getNumericCellValue()).floatValue());
//				columnNo=15;sd.setYear2012((null==row.getCell(15) || hypen.equalsIgnoreCase(row.getCell(15).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(15).getNumericCellValue()).floatValue());
//				columnNo=16;sd.setYear2013((null==row.getCell(16) || hypen.equalsIgnoreCase(row.getCell(16).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(16).getNumericCellValue()).floatValue());
//				columnNo=17;sd.setYear2014((null==row.getCell(17) || hypen.equalsIgnoreCase(row.getCell(17).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(17).getNumericCellValue()).floatValue());
//				columnNo=18;sd.setYear2015((null==row.getCell(18) || hypen.equalsIgnoreCase(row.getCell(18).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(18).getNumericCellValue()).floatValue());
//				
//				columnNo=19;sd.setYear2016((null==row.getCell(19) || hypen.equalsIgnoreCase(row.getCell(19).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(19).getNumericCellValue()).floatValue());
//				columnNo=20;sd.setYear2017((null==row.getCell(20) || hypen.equalsIgnoreCase(row.getCell(20).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(20).getNumericCellValue()).floatValue());
//				columnNo=21;sd.setYear2018((null==row.getCell(21) || hypen.equalsIgnoreCase(row.getCell(21).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(21).getNumericCellValue()).floatValue());
//				columnNo=22;sd.setYear2019((null==row.getCell(22) || hypen.equalsIgnoreCase(row.getCell(22).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(22).getNumericCellValue()).floatValue());
//				columnNo=23;sd.setYear2020((null==row.getCell(23) || hypen.equalsIgnoreCase(row.getCell(23).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(23).getNumericCellValue()).floatValue());
//				columnNo=24;sd.setYear2021((null==row.getCell(24) || hypen.equalsIgnoreCase(row.getCell(24).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(24).getNumericCellValue()).floatValue());
//				columnNo=25;sd.setYear2022((null==row.getCell(25) || hypen.equalsIgnoreCase(row.getCell(25).getStringCellValue()))?0:BigDecimal.valueOf(row.getCell(25).getNumericCellValue()).floatValue());
								
				supplyDemandList.add(sd);
			}
			catch(Exception e)
			{				
				logger.error("Exception in ReadExcelFile - populateSupplyDemandData():"+e);
				totalRecords++;
				String columnName=getHeaderValues(sheet, columnNo);
				if(columnName.contains(".0"))
					columnName=columnName.substring(0,columnName.length()-2);
				recordsList.append((row.getRowNum()+1)+",");
				if(totalRecords==(12*linebreak))
				{	
					recordsList.append(" ");// Adding space for rendering in front end;
					linebreak++;
				}	
				columnNamesSet.add(columnName);
								
			}
		
		}		
		if(totalRecords>0)
		{
			
			createTabData(tab,sheet.getSheetName().toUpperCase(),totalRecords,recordsList,columnNamesSet);
			logger.info("SupplyDemand totalRecords:"+ totalRecords+"recordsList:"+recordsList);
		}
	logger.info("Total objects set for SupplyDemand:"+supplyDemandList.size());
	return supplyDemandList;
	}
	private  List<NaturalGas> populateNaturalGasData(Sheet sheet,Tab tab)
	{
		logger.info("Class - ReadExcelFile - populateNaturalGasData()");
		int columnNo=0;
		List<NaturalGas> naturalList=new ArrayList<NaturalGas>();
		int rowCount=sheet.getLastRowNum();
		
		int totalRecords=0;
		StringBuffer recordsList=new StringBuffer("");					
		Set<String> columnNamesSet=new HashSet<String>();		
		int linebreak=1;
		for(int i=1;i<=rowCount;i++)
		{
			Row row=sheet.getRow(i);
			NaturalGas n=new NaturalGas();
			try
			{
				columnNo=0;n.setField(null==row.getCell(0) || null==df.formatCellValue(row.getCell(0)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(0)))?BLANK:df.formatCellValue(row.getCell(0)));
				columnNo=1;n.setRegion(null==row.getCell(1)|| null==df.formatCellValue(row.getCell(1)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(1)))?BLANK:df.formatCellValue(row.getCell(1)));
				columnNo=2;n.setCountry(null==row.getCell(2)|| null==df.formatCellValue(row.getCell(2)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(2)))?BLANK:df.formatCellValue(row.getCell(2)));
				columnNo=3;n.setLocation(null==row.getCell(3)|| null==df.formatCellValue(row.getCell(3)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(3)))?BLANK:df.formatCellValue(row.getCell(3)));
				columnNo=4;n.setBasin(null==row.getCell(4)|| null==df.formatCellValue(row.getCell(4)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(4)))?BLANK:df.formatCellValue(row.getCell(4)));
				columnNo=5;n.setStatus(null==row.getCell(5)|| null==df.formatCellValue(row.getCell(5)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(5)))?BLANK:df.formatCellValue(row.getCell(5)));
				columnNo=6;n.setOnshoreOrOffshore(null==row.getCell(6)|| null==df.formatCellValue(row.getCell(6)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(6)))?BLANK:df.formatCellValue(row.getCell(6)));
				columnNo=7;n.setProductionStartDate(null==row.getCell(7)|| null==df.formatCellValue(row.getCell(7)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(7)))?null:new Date(df.formatCellValue(row.getCell(7))));
				columnNo=8;n.setCurrentOperator(null==row.getCell(8)|| null==df.formatCellValue(row.getCell(8)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(8)))?BLANK:df.formatCellValue(row.getCell(8)));
				columnNo=9;n.setCurrentOwners(null==row.getCell(9)|| null==df.formatCellValue(row.getCell(9)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(9)))?BLANK:df.formatCellValue(row.getCell(9)));
				columnNo=10;n.setCurrentOwnership(null==row.getCell(10) || null==df.formatCellValue(row.getCell(10))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(10)))?0:Double.valueOf(df.formatCellValue(row.getCell(10))));
				
//				System.out.println("NaturalGas first");
				
				columnNo=11;n.setHistoricOperator(null==row.getCell(11)|| null==df.formatCellValue(row.getCell(11)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(11)))?BLANK:df.formatCellValue(row.getCell(11)));
				columnNo=12;n.setHistoricOwners(null==row.getCell(12)|| null==df.formatCellValue(row.getCell(12)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(12)))?BLANK:df.formatCellValue(row.getCell(12)));
				columnNo=13;n.setHistoricOwnership(null==row.getCell(13)|| null==df.formatCellValue(row.getCell(13))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(13)))?0:Double.valueOf(df.formatCellValue(row.getCell(13))));
				columnNo=14;n.setHistoricEquityYear(null==row.getCell(14)|| null==df.formatCellValue(row.getCell(14))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(14)))?0:Integer.parseInt(df.formatCellValue(row.getCell(14))));
				columnNo=15;n.setSourceEquity(null==row.getCell(15)|| null==df.formatCellValue(row.getCell(15)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(15)))?BLANK:df.formatCellValue(row.getCell(15)));
				columnNo=16;n.setYear2005(null==row.getCell(16)|| null==df.formatCellValue(row.getCell(16))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(16)))?0:Double.valueOf(df.formatCellValue(row.getCell(16))));
				columnNo=17;n.setYear2006(null==row.getCell(17)|| null==df.formatCellValue(row.getCell(17))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(17)))?0:Double.valueOf(df.formatCellValue(row.getCell(17))));
				columnNo=18;n.setYear2007(null==row.getCell(18)|| null==df.formatCellValue(row.getCell(18))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(18)))?0:Double.valueOf(df.formatCellValue(row.getCell(18))));
				columnNo=19;n.setYear2008(null==row.getCell(19)|| null==df.formatCellValue(row.getCell(19))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(19)))?0:Double.valueOf(df.formatCellValue(row.getCell(19))));
				columnNo=20;n.setYear2009(null==row.getCell(20)|| null==df.formatCellValue(row.getCell(20))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(20)))?0:Double.valueOf(df.formatCellValue(row.getCell(20))));
				
//				System.out.println("NaturalGas second");
				
				columnNo=21;n.setYear2010(null==row.getCell(21)|| null==df.formatCellValue(row.getCell(21))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(21)))?0:Double.valueOf(df.formatCellValue(row.getCell(21))));
				columnNo=22;n.setYear2011(null==row.getCell(22)|| null==df.formatCellValue(row.getCell(22))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(22)))?0:Double.valueOf(df.formatCellValue(row.getCell(22))));
				columnNo=23;n.setYear2012(null==row.getCell(23)|| null==df.formatCellValue(row.getCell(23))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(23)))?0:Double.valueOf(df.formatCellValue(row.getCell(23))));
				columnNo=24;n.setYear2013(null==row.getCell(24)|| null==df.formatCellValue(row.getCell(24))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(24)))?0:Double.valueOf(df.formatCellValue(row.getCell(24))));
				columnNo=25;n.setYear2014(null==row.getCell(25)|| null==df.formatCellValue(row.getCell(25))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(25)))?0:Double.valueOf(df.formatCellValue(row.getCell(25))));
				columnNo=26;n.setNotes(null==row.getCell(26)|| null==df.formatCellValue(row.getCell(26)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(26)))?BLANK:df.formatCellValue(row.getCell(26)));
				
				naturalList.add(n);
			}
			catch(Exception e)
			{	
				logger.info("Class - ReadExcelFile - populateNaturalGasData():"+e);
				totalRecords++;
				String columnName=getHeaderValues(sheet, columnNo);
				recordsList.append((row.getRowNum()+1)+",");
				if(totalRecords==(12*linebreak))
				{	
					recordsList.append(" ");// Adding space for rendering in front end;
					linebreak++;
				}	
				columnNamesSet.add(columnName);
				
				
			}
		
		}		
		if(totalRecords>0)
		{
			
			createTabData(tab,sheet.getSheetName().toUpperCase(),totalRecords,recordsList,columnNamesSet);
			logger.info("NaturalGas totalRecords:"+ totalRecords+"recordsList:"+recordsList);
		}
		logger.info("Total objects set for NaturalGas:"+naturalList.size());
		return naturalList;
		
		
		
	}
	private List<CrudeOil> populateCrudeOilData(Sheet sheet,Tab tab)
	{
		logger.info("Class - ReadExcelFile - populateCrudeOilData()");
		int columnNo=0;
		List<CrudeOil> crudeOilList=new ArrayList<CrudeOil>();
		int rowCount=sheet.getLastRowNum();
		
		int totalRecords=0;
		StringBuffer recordsList=new StringBuffer("");					
		Set<String> columnNamesSet=new HashSet<String>();		
		int linebreak=1;
		for(int i=1;i<=rowCount;i++)
		{
			Row row=sheet.getRow(i);
			CrudeOil c=new CrudeOil();
			try
			{
				columnNo=0;c.setField(null==row.getCell(0) || null==df.formatCellValue(row.getCell(0))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(0)))?BLANK:df.formatCellValue(row.getCell(0)));
				columnNo=1;c.setRegion(null==row.getCell(1)|| null==df.formatCellValue(row.getCell(1))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(1)))?BLANK:df.formatCellValue(row.getCell(1)));
				columnNo=2;c.setCountry(null==row.getCell(2)|| null==df.formatCellValue(row.getCell(2))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(2)))?BLANK:df.formatCellValue(row.getCell(2)));
				columnNo=3;c.setLocation(null==row.getCell(3)|| null==df.formatCellValue(row.getCell(3))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(3)))?BLANK:df.formatCellValue(row.getCell(3)));
				columnNo=4;c.setBasin(null==row.getCell(4)|| null==df.formatCellValue(row.getCell(4))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(4)))?BLANK:df.formatCellValue(row.getCell(4)));
				columnNo=5;c.setStatus(null==row.getCell(5)|| null==df.formatCellValue(row.getCell(5))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(5)))?BLANK:df.formatCellValue(row.getCell(5)));
				columnNo=6;c.setOnshoreOrOffshore(null==row.getCell(6)|| null==df.formatCellValue(row.getCell(6))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(6)))?BLANK:df.formatCellValue(row.getCell(6)));
				columnNo=7;c.setProductionStartDate(null==row.getCell(7) || null==df.formatCellValue(row.getCell(7))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(7)))?null:new Date(df.formatCellValue(row.getCell(7))));
				columnNo=8;c.setCurrentOperator(null==row.getCell(8)|| null==df.formatCellValue(row.getCell(8))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(8)))?BLANK:df.formatCellValue(row.getCell(8)));
				columnNo=9;c.setCurrentOwners(null==row.getCell(9)|| null==df.formatCellValue(row.getCell(9))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(9)))?BLANK:df.formatCellValue(row.getCell(9)));
				columnNo=10;c.setCurrentOwnership(null==row.getCell(10) || null==df.formatCellValue(row.getCell(10))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(10)))?0:Double.valueOf(df.formatCellValue(row.getCell(10))));
				
//				System.out.println("crude Oil first");
				
				columnNo=11;c.setHistoricOperator(null==row.getCell(11)|| null==df.formatCellValue(row.getCell(11))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(11)))?BLANK:df.formatCellValue(row.getCell(11)));
				columnNo=12;c.setHistoricOwners(null==row.getCell(12)|| null==df.formatCellValue(row.getCell(12))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(12)))?BLANK:df.formatCellValue(row.getCell(12)));
				columnNo=13;c.setHistoricOwnership(null==row.getCell(13)|| null==df.formatCellValue(row.getCell(13))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(13)))?0:Double.valueOf(df.formatCellValue(row.getCell(13))));
				columnNo=14;c.setHistoricEquityYear(null==row.getCell(14)|| null==df.formatCellValue(row.getCell(14))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(14)))?0:Integer.parseInt(df.formatCellValue(row.getCell(14))));
				columnNo=15;c.setSourceEquity(null==row.getCell(15)|| null==df.formatCellValue(row.getCell(15))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(15)))?BLANK:df.formatCellValue(row.getCell(15)));
				columnNo=16;c.setYear2005(null==row.getCell(16)|| null==df.formatCellValue(row.getCell(16))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(16)))?0:Double.valueOf(df.formatCellValue(row.getCell(16))));
				columnNo=17;c.setYear2006(null==row.getCell(17)|| null==df.formatCellValue(row.getCell(17))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(17)))?0:Double.valueOf(df.formatCellValue(row.getCell(17))));
				columnNo=18;c.setYear2007(null==row.getCell(18)|| null==df.formatCellValue(row.getCell(18))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(18)))?0:Double.valueOf(df.formatCellValue(row.getCell(18))));
				columnNo=19;c.setYear2008(null==row.getCell(19)|| null==df.formatCellValue(row.getCell(19))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(19)))?0:Double.valueOf(df.formatCellValue(row.getCell(19))));
				columnNo=20;c.setYear2009(null==row.getCell(20)|| null==df.formatCellValue(row.getCell(20))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(20)))?0:Double.valueOf(df.formatCellValue(row.getCell(20))));
				
//				System.out.println("crude Oil second");
				
				columnNo=21;c.setYear2010(null==row.getCell(21)|| null==df.formatCellValue(row.getCell(21))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(21)))?0:Double.valueOf(df.formatCellValue(row.getCell(21))));
				columnNo=22;c.setYear2011(null==row.getCell(22)|| null==df.formatCellValue(row.getCell(22))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(22)))?0:Double.valueOf(df.formatCellValue(row.getCell(22))));
				columnNo=23;c.setYear2012(null==row.getCell(23)|| null==df.formatCellValue(row.getCell(23))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(23)))?0:Double.valueOf(df.formatCellValue(row.getCell(23))));
				columnNo=24;c.setYear2013(null==row.getCell(24)|| null==df.formatCellValue(row.getCell(24))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(24)))?0:Double.valueOf(df.formatCellValue(row.getCell(24))));
				columnNo=25;c.setYear2014(null==row.getCell(25)|| null==df.formatCellValue(row.getCell(25))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(25)))?0:Double.valueOf(df.formatCellValue(row.getCell(25))));
				columnNo=26;c.setNotes(null==row.getCell(26)|| null==df.formatCellValue(row.getCell(26))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(26)))?BLANK:df.formatCellValue(row.getCell(26)));		
				
				crudeOilList.add(c);
			}
			catch(Exception e)
			{				
				logger.error("Exception in ReadExcelFile - populateCrudeOilData():"+e);
				totalRecords++;
				String columnName=getHeaderValues(sheet, columnNo);
				recordsList.append((row.getRowNum()+1)+",");
				if(totalRecords==(12*linebreak))
				{	
					recordsList.append(" ");// Adding space for rendering in front end;
					linebreak++;
				}	
				columnNamesSet.add(columnName);
				
				
			}
		
		}		
		if(totalRecords>0)
		{
			
			createTabData(tab,sheet.getSheetName().toUpperCase(),totalRecords,recordsList,columnNamesSet);
			logger.info("CrudeOil totalRecords:"+ totalRecords+"recordsList:"+recordsList);
		}
	logger.info("Total objects set for CrudeOil:"+crudeOilList.size());
	return crudeOilList;
		
		
	}
	private List<PipeLine> populatePipeLinesData(Sheet sheet,Tab tab)
	{
		logger.info("Class - ReadExcelFile - populatePipeLinesData()");
		int columnNo=0;
		List<PipeLine> pipeLineList=new ArrayList<PipeLine>();
		int rowCount=sheet.getLastRowNum();
		
		int totalRecords=0;
		StringBuffer recordsList=new StringBuffer("");					
		Set<String> columnNamesSet=new HashSet<String>();		
		int linebreak=1;
		for(int i=1;i<=rowCount;i++)
		{
			Row row=sheet.getRow(i);
			PipeLine p=new PipeLine();
			try
			{
				columnNo=0;p.setPipeline(null==row.getCell(0) || null==df.formatCellValue(row.getCell(0))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(0)))?BLANK:df.formatCellValue(row.getCell(0)));
				columnNo=1;p.setSubPipelines(null==row.getCell(1)|| null==df.formatCellValue(row.getCell(1))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(1)))?BLANK:df.formatCellValue(row.getCell(1)));
				columnNo=2;p.setStatus(null==row.getCell(2)|| null==df.formatCellValue(row.getCell(2))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(2)))?BLANK:df.formatCellValue(row.getCell(2)));
				columnNo=3;p.setCommodity(null==row.getCell(3)|| null==df.formatCellValue(row.getCell(3))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(3)))?BLANK:df.formatCellValue(row.getCell(3)));
				columnNo=4;p.setStartPoint(null==row.getCell(4)|| null==df.formatCellValue(row.getCell(4))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(4)))?BLANK:df.formatCellValue(row.getCell(4)));
				columnNo=5;p.setEndPoint(null==row.getCell(5)|| null==df.formatCellValue(row.getCell(5))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(5)))?BLANK:df.formatCellValue(row.getCell(5)));
				columnNo=6;p.setCountry(null==row.getCell(6)|| null==df.formatCellValue(row.getCell(6))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(6)))?BLANK:df.formatCellValue(row.getCell(6)));
				columnNo=7;p.setRegion(null==row.getCell(7)|| null==df.formatCellValue(row.getCell(7))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(7)))?BLANK:df.formatCellValue(row.getCell(7)));
				columnNo=8;p.setStartCountry(null==row.getCell(8)|| null==df.formatCellValue(row.getCell(8))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(8)))?BLANK:df.formatCellValue(row.getCell(8)));
				columnNo=9;p.setStartRegion(null==row.getCell(9)|| null==df.formatCellValue(row.getCell(9))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(9)))?BLANK:df.formatCellValue(row.getCell(9)));
				columnNo=10;p.setEndCountry(null==row.getCell(10)|| null==df.formatCellValue(row.getCell(10))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(10)))?BLANK:df.formatCellValue(row.getCell(10)));
				
//				System.out.println("first pipelines");
				
				columnNo=11;p.setEndRegion(null==row.getCell(11)|| null==df.formatCellValue(row.getCell(11))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(11)))?BLANK:df.formatCellValue(row.getCell(11)));
				columnNo=12;p.setRoute(null==row.getCell(12)|| null==df.formatCellValue(row.getCell(12))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(12)))?BLANK:df.formatCellValue(row.getCell(12)));
				columnNo=13;p.setPipelineType(null==row.getCell(13)|| null==df.formatCellValue(row.getCell(13))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(13)))?BLANK:df.formatCellValue(row.getCell(13)));
				columnNo=14;p.setOnshoreOrOffshore(null==row.getCell(14)|| null==df.formatCellValue(row.getCell(14))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(14)))?BLANK:df.formatCellValue(row.getCell(14)));
				columnNo=15;p.setStartDate(null==row.getCell(15) || null==df.formatCellValue(row.getCell(15))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(15)))?null:new Date(df.formatCellValue(row.getCell(15))));
				columnNo=16;p.setCommodityDetails(null==row.getCell(16)|| null==df.formatCellValue(row.getCell(16))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(16)))?BLANK:df.formatCellValue(row.getCell(16)));
				columnNo=17;p.setBasicDetailsSource(null==row.getCell(17)|| null==df.formatCellValue(row.getCell(17))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(17)))?BLANK:df.formatCellValue(row.getCell(17)));
				columnNo=18;p.setBasicDetailNotes(null==row.getCell(18)|| null==df.formatCellValue(row.getCell(18))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(18)))?BLANK:df.formatCellValue(row.getCell(18)));
				columnNo=19;p.setOperator(null==row.getCell(19)|| null==df.formatCellValue(row.getCell(19))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(19)))?BLANK:df.formatCellValue(row.getCell(19)));
				columnNo=20;p.setEquityPartners(null==row.getCell(20)|| null==df.formatCellValue(row.getCell(20))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(20)))?BLANK:df.formatCellValue(row.getCell(20)));
				
//				System.out.println("second pipelines");
				
				columnNo=21;p.setEquityStakes(null==row.getCell(21) || null==df.formatCellValue(row.getCell(21))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(21)))?0:Double.valueOf(df.formatCellValue(row.createCell(21))));
				columnNo=22;p.setCompanySource(null==row.getCell(22)|| null==df.formatCellValue(row.getCell(22))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(22)))?BLANK:df.formatCellValue(row.getCell(22)));
				columnNo=23;p.setCompanyNotes(null==row.getCell(23)|| null==df.formatCellValue(row.getCell(23))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(23)))?BLANK:df.formatCellValue(row.getCell(23)));
				columnNo=24;p.setLength(null==row.getCell(24)|| null==df.formatCellValue(row.getCell(24))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(24)))?0:Double.valueOf(df.formatCellValue(row.createCell(24))));
				columnNo=25;p.setDiameter(null==row.getCell(25)|| null==df.formatCellValue(row.getCell(25))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(25)))?0:Double.valueOf(df.formatCellValue(row.createCell(25))));
//				if(row.getCell(25)!=null)
//				{
//					if(row.getCell(25).getCellType()== Cell.CELL_TYPE_STRING)
//					{	
//							p.setDiameter(row.getCell(25).getStringCellValue());
//					}	
//					else if(row.getCell(25).getCellType()==Cell.CELL_TYPE_NUMERIC)
//					{	
//						p.setDiameter(String.valueOf(row.getCell(25).getNumericCellValue()));
//					}	
//				}
//				else
//					p.setDiameter("");
				
				columnNo=26;p.setCapacity(null==row.getCell(26)|| null==df.formatCellValue(row.getCell(26))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(26)))?0:Double.valueOf(df.formatCellValue(row.createCell(26))));
				columnNo=27;p.setCapex(null==row.getCell(27)|| null==df.formatCellValue(row.getCell(27))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(27)))?0:Double.valueOf(df.formatCellValue(row.createCell(27))));
				columnNo=28;p.setParameterSource(null==row.getCell(28)|| null==df.formatCellValue(row.getCell(28))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(28)))?BLANK:df.formatCellValue(row.getCell(28)));
				columnNo=29;p.setParameterNotes(null==row.getCell(29)|| null==df.formatCellValue(row.getCell(29))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(29)))?BLANK:df.formatCellValue(row.getCell(29)));
				
				pipeLineList.add(p);
			}
			catch(Exception e)
			{
				logger.error("Exception in ReadExcelFile -populatePipeLinesData():"+e);
				totalRecords++;
				String columnName=getHeaderValues(sheet, columnNo);
				recordsList.append((row.getRowNum()+1)+",");
				if(totalRecords==(12*linebreak))
				{	
					recordsList.append(" ");// Adding space for rendering in front end;
					linebreak++;
				}	
				columnNamesSet.add(columnName);
				
				
			}
		
		}		
		if(totalRecords>0)
		{
			
			createTabData(tab,sheet.getSheetName().toUpperCase(),totalRecords,recordsList,columnNamesSet);
			logger.info("PipeLine totalRecords:"+ totalRecords+"recordsList:"+recordsList);
		}
		logger.info("Total objects set for PipeLine:"+pipeLineList.size());
	return pipeLineList;
		
		
		
	}
	private List<Lng> populateLngData(Sheet sheet,Tab tab)
	{
		logger.info("Class - ReadExcelFile - populateLngData()");
		int columnNo=0;
		List<Lng> lngList=new ArrayList<Lng>();
		int rowCount=sheet.getLastRowNum();
		
		int totalRecords=0;
		StringBuffer recordsList=new StringBuffer("");					
		Set<String> columnNamesSet=new HashSet<String>();	
		int linebreak=1;
		for(int i=1;i<=rowCount;i++)
		{
			if(i==191)
				System.out.println(i);
			 Row row=sheet.getRow(i);
			 Lng l=new Lng();
				try
				{
					columnNo=0;l.setName(null==row.getCell(0)||null==df.formatCellValue(row.getCell(0)) || (BLANK).equals(df.formatCellValue(row.getCell(0)))?BLANK:df.formatCellValue(row.getCell(0)));
					columnNo=1;l.setCountry(null==row.getCell(1)||null==df.formatCellValue(row.getCell(1)) || (BLANK).equals(df.formatCellValue(row.getCell(1)))?BLANK:df.formatCellValue(row.getCell(1)));
					columnNo=2;l.setArea(null==row.getCell(2)||null==df.formatCellValue(row.getCell(2)) || (BLANK).equals(df.formatCellValue(row.getCell(2)))?BLANK:df.formatCellValue(row.getCell(2)));
					columnNo=3;l.setRegion(null==row.getCell(3)||null==df.formatCellValue(row.getCell(3)) || (BLANK).equals(df.formatCellValue(row.getCell(3)))?BLANK:df.formatCellValue(row.getCell(3)));
					columnNo=4;l.setType(null==row.getCell(4)||null==df.formatCellValue(row.getCell(4)) || (BLANK).equals(df.formatCellValue(row.getCell(4)))?BLANK:df.formatCellValue(row.getCell(4)));
					columnNo=5;l.setStatus(null==row.getCell(5)||null==df.formatCellValue(row.getCell(5)) || (BLANK).equals(df.formatCellValue(row.getCell(5)))?BLANK:df.formatCellValue(row.getCell(5)));
					columnNo=6;l.setFeedDetails(null==row.getCell(6)||null==df.formatCellValue(row.getCell(6)) || (BLANK).equals(df.formatCellValue(row.getCell(6)))?BLANK:df.formatCellValue(row.getCell(6)));
					columnNo=7;l.setFidDetails(null==row.getCell(7)||null==df.formatCellValue(row.getCell(7)) || (BLANK).equals(df.formatCellValue(row.getCell(7)))?BLANK:df.formatCellValue(row.getCell(7)));
					columnNo=8;l.setConstructionStatusDetails(null==row.getCell(8)||null==df.formatCellValue(row.getCell(8)) || (BLANK).equals(df.formatCellValue(row.getCell(8)))?BLANK:df.formatCellValue(row.getCell(8)));
					columnNo=9;l.setSources(null==row.getCell(9)||null==df.formatCellValue(row.getCell(9)) || (BLANK).equals(df.formatCellValue(row.getCell(9)))?BLANK:df.formatCellValue(row.getCell(9)));
					columnNo=10;l.setOtherStatusDetails(null==row.getCell(10)||null==df.formatCellValue(row.getCell(10)) || (BLANK).equals(df.formatCellValue(row.getCell(10)))?BLANK:df.formatCellValue(row.getCell(10)));
					
//					System.out.println("LNG first");
					 
					columnNo=11;l.setStatusDate(null==row.getCell(11) || null==df.formatCellValue(row.getCell(11)) || (BLANK).equals(df.formatCellValue(row.getCell(11)))?null:new Date(df.formatCellValue(row.getCell(11))));
					columnNo=12;l.setStatusSource(null==row.getCell(12)||null==df.formatCellValue(row.getCell(12)) || (BLANK).equals(df.formatCellValue(row.getCell(12)))?BLANK:df.formatCellValue(row.getCell(12)));
					columnNo=13;l.setOnshoreOrOffshore(null==row.getCell(13)||null==df.formatCellValue(row.getCell(13)) || (BLANK).equals(df.formatCellValue(row.getCell(13)))?BLANK:df.formatCellValue(row.getCell(13)));
					columnNo=14;l.setExpectedStartYear(null==row.getCell(14) || null==df.formatCellValue(row.getCell(14)) || (BLANK).equals(df.formatCellValue(row.getCell(14)))?null:new Date(df.formatCellValue(row.getCell(14))));
					columnNo=15;l.setScheduledStartYear(null==row.getCell(15)|| null==df.formatCellValue(row.getCell(15)) || (BLANK).equals(df.formatCellValue(row.getCell(15)))?null:new Date(df.formatCellValue(row.getCell(15))));
					columnNo=16;l.setDelayOrInitialStartYear(null==row.getCell(16)|| null==df.formatCellValue(row.getCell(16)) || (BLANK).equals(df.formatCellValue(row.getCell(16)))?null:new Date(df.formatCellValue(row.getCell(16))));
					columnNo=17;l.setDelayDetails(null==row.getCell(17)||null==df.formatCellValue(row.getCell(17)) || (BLANK).equals(df.formatCellValue(row.getCell(17)))?BLANK:df.formatCellValue(row.getCell(17)));
					columnNo=18;l.setTechnologyDetails(null==row.getCell(18)||null==df.formatCellValue(row.getCell(18)) || (BLANK).equals(df.formatCellValue(row.getCell(18)))?BLANK:df.formatCellValue(row.getCell(18)));													
					columnNo=19;l.setNumberOfTrainsOrNumberOfVaporizers(null==row.getCell(19)|| null==df.formatCellValue(row.getCell(19)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(19)))?0:Double.valueOf(df.formatCellValue(row.getCell(19))));
					columnNo=20;l.setCapacity(null==row.getCell(20)|| null==df.formatCellValue(row.getCell(20)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(20)))?0:Double.valueOf(df.formatCellValue(row.getCell(20))));
					
//					 System.out.println("LNG second");
					 									
					columnNo=21;l.setCapacityYear(null==row.getCell(21) || null==df.formatCellValue(row.getCell(21)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(21)))?0:Integer.parseInt(df.formatCellValue(row.getCell(21))));
					columnNo=22;l.setExpansionDetail(null==row.getCell(22)||null==df.formatCellValue(row.getCell(22)) || (BLANK).equals(df.formatCellValue(row.getCell(22)))?BLANK:df.formatCellValue(row.getCell(22)));
					columnNo=23;l.setSource(null==row.getCell(23)||null==df.formatCellValue(row.getCell(23)) || (BLANK).equals(df.formatCellValue(row.getCell(23)))?BLANK:df.formatCellValue(row.getCell(23)));
					columnNo=24;l.setAdditionalProducts(null==row.getCell(24)||null==df.formatCellValue(row.getCell(24)) || (BLANK).equals(df.formatCellValue(row.getCell(24)))?BLANK:df.formatCellValue(row.getCell(24)));														
					columnNo=25;l.setAdditionalProductsProduction(null==row.getCell(25) || null==df.formatCellValue(row.getCell(25)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(25)))?0:Double.valueOf(df.formatCellValue(row.getCell(25))));
					columnNo=26;l.setAdditionalProductsProductionUnit(null==row.getCell(26)||null==df.formatCellValue(row.getCell(26)) || (BLANK).equals(df.formatCellValue(row.getCell(26)))?BLANK:df.formatCellValue(row.getCell(26)));
					columnNo=27;l.setNumberOfStorageTanks(null==row.getCell(27)|| null==df.formatCellValue(row.getCell(27)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(27)))?0:Double.valueOf(df.formatCellValue(row.getCell(27))));
					columnNo=28;l.setTotalLngStorageCapacity(null==row.getCell(28)|| null==df.formatCellValue(row.getCell(28)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(28)))?0:Double.valueOf(df.formatCellValue(row.getCell(28))));
					columnNo=29;l.setSourcesOther(null==row.getCell(29)||null==df.formatCellValue(row.getCell(29)) || (BLANK).equals(df.formatCellValue(row.getCell(29)))?BLANK:df.formatCellValue(row.getCell(29)));
					columnNo=30;l.setOperator(null==row.getCell(30)||null==df.formatCellValue(row.getCell(30)) || (BLANK).equals(df.formatCellValue(row.getCell(30)))?BLANK:df.formatCellValue(row.getCell(30)));
//					
////					System.out.println("LNG third");
//					
					columnNo=31;l.setEquityPartners(null==row.getCell(31)||null==df.formatCellValue(row.getCell(31)) || (BLANK).equals(df.formatCellValue(row.getCell(31)))?BLANK:df.formatCellValue(row.getCell(31)));
					columnNo=32;l.setEquityStakes(null==row.getCell(32)|| null==df.formatCellValue(row.getCell(32)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(32)))?0:Double.valueOf(df.formatCellValue(row.getCell(32))));
					columnNo=33;l.setEquityNotes(null==row.getCell(33)||null==df.formatCellValue(row.getCell(33)) || (BLANK).equals(df.formatCellValue(row.getCell(33)))?BLANK:df.formatCellValue(row.getCell(33)));
					columnNo=34;l.setHistoricOperator(null==row.getCell(34)||null==df.formatCellValue(row.getCell(34)) || (BLANK).equals(df.formatCellValue(row.getCell(34)))?BLANK:df.formatCellValue(row.getCell(34)));
					columnNo=35;l.setHistoricEquityPartner(null==row.getCell(35)||null==df.formatCellValue(row.getCell(35)) || (BLANK).equals(df.formatCellValue(row.getCell(35)))?BLANK:df.formatCellValue(row.getCell(35)));
					columnNo=36;l.setHistoricEquityStake(null==row.getCell(36)|| null==df.formatCellValue(row.getCell(36)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(36)))?0:Double.valueOf(df.formatCellValue(row.getCell(36))));
					columnNo=37;l.setHistoricEquityYear(null==row.getCell(37)|| null==df.formatCellValue(row.getCell(37)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(37)))?0:Integer.parseInt(df.formatCellValue(row.getCell(37))));
					columnNo=38;l.setEquitySources(null==row.getCell(38)||null==df.formatCellValue(row.getCell(38)) || (BLANK).equals(df.formatCellValue(row.getCell(38)))?BLANK:df.formatCellValue(row.getCell(38)));
					columnNo=39;l.setFeedOrInputType(null==row.getCell(39)||null==df.formatCellValue(row.getCell(39)) || (BLANK).equals(df.formatCellValue(row.getCell(39)))?BLANK:df.formatCellValue(row.getCell(39)));
					columnNo=40;l.setFeedOrInputName(null==row.getCell(40)||null==df.formatCellValue(row.getCell(40)) || (BLANK).equals(df.formatCellValue(row.getCell(40)))?BLANK:df.formatCellValue(row.getCell(40)));
//					
////					System.out.println("LNG fourth");
//					
					columnNo=41;l.setFeedOrInputDetails(null==row.getCell(41)||null==df.formatCellValue(row.getCell(41)) || (BLANK).equals(df.formatCellValue(row.getCell(41)))?BLANK:df.formatCellValue(row.getCell(41)));
					columnNo=42;l.setDisttributionOrOutputType(null==row.getCell(42)||null==df.formatCellValue(row.getCell(42)) || (BLANK).equals(df.formatCellValue(row.getCell(42)))?BLANK:df.formatCellValue(row.getCell(42)));
					columnNo=43;l.setDisttributionOrOutputName(null==row.getCell(43)||null==df.formatCellValue(row.getCell(43)) || (BLANK).equals(df.formatCellValue(row.getCell(43)))?BLANK:df.formatCellValue(row.getCell(43)));
					columnNo=44;l.setDisttributionOrOutputDetails(null==row.getCell(44)||null==df.formatCellValue(row.getCell(44)) || (BLANK).equals(df.formatCellValue(row.getCell(44)))?BLANK:df.formatCellValue(row.getCell(44)));
					columnNo=45;l.setJettyInfo_m3(null==row.getCell(45)|| null==df.formatCellValue(row.getCell(45)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(45)))?0:Double.valueOf(df.formatCellValue(row.getCell(45))));
					columnNo=46;l.setCapex(null==row.getCell(46)|| null==df.formatCellValue(row.getCell(46)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(46)))?0:Double.valueOf(df.formatCellValue(row.getCell(46))));
					columnNo=47;l.setCapexYear(null==row.getCell(47)|| null==df.formatCellValue(row.getCell(47)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(47)))?0:Integer.parseInt(df.formatCellValue(row.getCell(47))));
					columnNo=48;l.setCapexDetails(null==row.getCell(48)||null==df.formatCellValue(row.getCell(48)) || (BLANK).equals(df.formatCellValue(row.getCell(48)))?BLANK:df.formatCellValue(row.getCell(48)));
					columnNo=49;l.setSources1(null==row.getCell(49)||null==df.formatCellValue(row.getCell(49)) || (BLANK).equals(df.formatCellValue(row.getCell(49)))?BLANK:df.formatCellValue(row.getCell(49)));
					columnNo=50;l.setConstructionStart(null==row.getCell(50)|| null==df.formatCellValue(row.getCell(50)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(50)))?0:Integer.parseInt(df.formatCellValue(row.getCell(50))));
//					
////					System.out.println("LNG five");
//					
					columnNo=51;l.setConstructionEnd(null==row.getCell(51)|| null==df.formatCellValue(row.getCell(51)) || (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(51)))?0:Integer.parseInt(df.formatCellValue(row.getCell(51))));
					columnNo=52;l.setConstructionCompanyName(null==row.getCell(52)||null==df.formatCellValue(row.getCell(52)) || (BLANK).equals(df.formatCellValue(row.getCell(52)))?BLANK:df.formatCellValue(row.getCell(52)));
					columnNo=53;l.setConstructionContractDetails(null==row.getCell(53)||null==df.formatCellValue(row.getCell(53)) || (BLANK).equals(df.formatCellValue(row.getCell(53)))?BLANK:df.formatCellValue(row.getCell(53)));
					columnNo=54;l.setOtherContractsDetails(null==row.getCell(54)||null==df.formatCellValue(row.getCell(54)) || (BLANK).equals(df.formatCellValue(row.getCell(54)))?BLANK:df.formatCellValue(row.getCell(54)));
					columnNo=55;l.setLngTerminalOtherNames(null==row.getCell(55)||null==df.formatCellValue(row.getCell(55)) || (BLANK).equals(df.formatCellValue(row.getCell(55)))?BLANK:df.formatCellValue(row.getCell(55)));
					columnNo=56;l.setRelatedCompanies(null==row.getCell(56)||null==df.formatCellValue(row.getCell(56)) || (BLANK).equals(df.formatCellValue(row.getCell(56)))?BLANK:df.formatCellValue(row.getCell(56)));
					columnNo=57;l.setRelatedCompanyDetails(null==row.getCell(57)||null==df.formatCellValue(row.getCell(57)) || (BLANK).equals(df.formatCellValue(row.getCell(57)))?BLANK:df.formatCellValue(row.getCell(57)));
					columnNo=58;l.setSources2(null==row.getCell(58)||null==df.formatCellValue(row.getCell(58)) || (BLANK).equals(df.formatCellValue(row.getCell(58)))?BLANK:df.formatCellValue(row.getCell(58)));
					columnNo=59;l.setMoreInfo(null==row.getCell(59)||null==df.formatCellValue(row.getCell(59)) || (BLANK).equals(df.formatCellValue(row.getCell(59)))?BLANK:df.formatCellValue(row.getCell(59)));
					columnNo=60;l.setUnits(null==row.getCell(60)||null==df.formatCellValue(row.getCell(60)) || (BLANK).equals(df.formatCellValue(row.getCell(60)))?BLANK:df.formatCellValue(row.getCell(60)));
					
					lngList.add(l);
				}
				catch(Exception e)
				{
					
					logger.error("Exception in ReadExcelFile - populateLngData():"+e);
					totalRecords++;
					String columnName=getHeaderValues(sheet, columnNo);
					recordsList.append((row.getRowNum()+1)+",");
					if(totalRecords==(12*linebreak))
					{	
						recordsList.append(" ");// Adding space for rendering in front end;
						linebreak++;
					}	
					columnNamesSet.add(columnName);
					
					
				}
			
		}		
		if(totalRecords>0)
		{
			
			createTabData(tab,sheet.getSheetName().toUpperCase(),totalRecords,recordsList,columnNamesSet);
			logger.info("Lng totalRecords:"+ totalRecords+"recordsList:"+recordsList);
		}
		logger.info("Total objects set for Lng:"+lngList.size());
		return lngList;
									

	}
	
	private List<Storage> populateStorageData(Sheet sheet,Tab tab)
	{	
		logger.info("Class - ReadExcelFile - populateStorageData()");
		int columnNo=0;
		List<Storage> storageList=new ArrayList<Storage>();
		int rowCount=sheet.getLastRowNum();
		
		int totalRecords=0;
		StringBuffer recordsList=new StringBuffer("");			
		Set<String> columnNamesSet=new HashSet<String>();	
		int linebreak=1;
		for(int i=1;i<=rowCount;i++)
		{
			Row row=sheet.getRow(i);
			Storage s=new Storage();	

				try
				{
					columnNo=0;s.setTankFarm(null==row.getCell(0) || null==df.formatCellValue(row.getCell(0))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(0)))?"":df.formatCellValue(row.getCell(0)));
					columnNo=1;s.setRegion(null==row.getCell(1)|| null==df.formatCellValue(row.getCell(1))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(1)))?"":df.formatCellValue(row.getCell(1)));
					columnNo=2;s.setCountry(null==row.getCell(2)|| null==df.formatCellValue(row.getCell(2))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(2)))?"":df.formatCellValue(row.getCell(2)));
					columnNo=3;s.setLocation(null==row.getCell(3)|| null==df.formatCellValue(row.getCell(3))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(3)))?"":df.formatCellValue(row.getCell(3)));
					columnNo=4;s.setStatus(null==row.getCell(4)|| null==df.formatCellValue(row.getCell(4))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(4)))?"":df.formatCellValue(row.getCell(4)));
					columnNo=5;s.setCommencementDate(null==row.getCell(5)|| null==df.formatCellValue(row.getCell(5))||("").equalsIgnoreCase(df.formatCellValue(row.getCell(5)))?null:new Date(df.formatCellValue(row.getCell(5))));
					columnNo=6;s.setCommencementSource(null==row.getCell(6)|| null==df.formatCellValue(row.getCell(6))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(6)))?"":df.formatCellValue(row.getCell(6)));
					columnNo=7;s.setCurrentOperator(null==row.getCell(7)|| null==df.formatCellValue(row.getCell(7))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(7)))?"":df.formatCellValue(row.getCell(7)));
					columnNo=8;s.setCurrentOwners(null==row.getCell(8)|| null==df.formatCellValue(row.getCell(8))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(8)))?"":df.formatCellValue(row.getCell(8)));
					columnNo=9;s.setCurrentOwnership(null==row.getCell(9)|| null==df.formatCellValue(row.getCell(9))||("").equalsIgnoreCase(df.formatCellValue(row.getCell(9)))?0:Double.valueOf(df.formatCellValue(row.getCell(9))));
					columnNo=10;s.setOwnershipNotes(null==row.getCell(10)|| null==df.formatCellValue(row.getCell(10))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(10)))?"":df.formatCellValue(row.getCell(10)));
					
			//		System.out.println("Storage First");
					
					columnNo=11;s.setHistoricOperator(null==row.getCell(11)|| null==df.formatCellValue(row.getCell(11))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(11)))?"":df.formatCellValue(row.getCell(11)));
					columnNo=12;s.setHistoricOwners(null==row.getCell(12)|| null==df.formatCellValue(row.getCell(12))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(12)))?"":df.formatCellValue(row.getCell(12)));
					columnNo=13;s.setHistoricOwnership(null==row.getCell(13)|| null==df.formatCellValue(row.getCell(13))||("").equalsIgnoreCase(df.formatCellValue(row.getCell(13)))?0:Double.valueOf(df.formatCellValue(row.getCell(13))));
					columnNo=14;s.setHistoricalEquityYear(null==row.getCell(14)|| null==df.formatCellValue(row.getCell(14))||("").equalsIgnoreCase(df.formatCellValue(row.getCell(14)))?0:Integer.parseInt(df.formatCellValue(row.getCell(14))));
					columnNo=15;s.setEquitySource(null==row.getCell(15)|| null==df.formatCellValue(row.getCell(15))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(15)))?"":df.formatCellValue(row.getCell(15)));
					columnNo=16;s.setProductsStored(null==row.getCell(16)|| null==df.formatCellValue(row.getCell(16))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(16)))?"":df.formatCellValue(row.getCell(16)));
					columnNo=17;s.setModeOfAccess(null==row.getCell(17)|| null==df.formatCellValue(row.getCell(17))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(17)))?"":df.formatCellValue(row.getCell(17)));
					columnNo=18;s.setCapacityM3(null==row.getCell(18)|| null==df.formatCellValue(row.getCell(18))||("").equalsIgnoreCase(df.formatCellValue(row.getCell(18)))?0:Double.valueOf(df.formatCellValue(row.getCell(18))));
					columnNo=19;s.setCapacityYear(null==row.getCell(19)|| null==df.formatCellValue(row.getCell(19))||("").equalsIgnoreCase(df.formatCellValue(row.getCell(19)))?0:Integer.parseInt(df.formatCellValue(row.getCell(19))));
					columnNo=20;s.setTanks(null==row.getCell(20)|| null==df.formatCellValue(row.getCell(20))||("").equalsIgnoreCase(df.formatCellValue(row.getCell(20)))?0:Double.valueOf(df.formatCellValue(row.getCell(20))));
					
			//		System.out.println("Storage second");
					
					columnNo=21;s.setTankSizeRange_min_m3(null==row.getCell(21)|| null==df.formatCellValue(row.getCell(21))||("").equalsIgnoreCase(df.formatCellValue(row.getCell(21)))?0:Double.valueOf(df.formatCellValue(row.getCell(21))));
					columnNo=22;s.setTankSizeRange_max_m3(null==row.getCell(22)|| null==df.formatCellValue(row.getCell(22))||("").equalsIgnoreCase(df.formatCellValue(row.getCell(22)))?0:Double.valueOf(df.formatCellValue(row.getCell(22))));
					columnNo=23;s.setCapacitySource(null==row.getCell(23)|| null==df.formatCellValue(row.getCell(23))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(23)))?"":df.formatCellValue(row.getCell(23)));
					columnNo=24;s.setCapitalInvestment(null==row.getCell(24)|| null==df.formatCellValue(row.getCell(24))||("").equalsIgnoreCase(df.formatCellValue(row.getCell(24)))?0:Double.valueOf(df.formatCellValue(row.getCell(24))));
					columnNo=25;s.setCapexSource(null==row.getCell(25)|| null==df.formatCellValue(row.getCell(25))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(25)))?"":df.formatCellValue(row.getCell(25)));
					columnNo=26;s.setNotes(null==row.getCell(26)|| null==df.formatCellValue(row.getCell(26))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(26)))?"":df.formatCellValue(row.getCell(26)));
					
					storageList.add(s);
				}
				catch(Exception e)
				{
					logger.error("Exception in ReadExcelFile - populateStorageData():"+e);
					totalRecords++;
					String columnName=getHeaderValues(sheet, columnNo);
					recordsList.append((row.getRowNum()+1)+",");
					if(totalRecords==(12*linebreak))
					{	
						recordsList.append(" ");// Adding space for rendering in front end;
						linebreak++;
					}	
					columnNamesSet.add(columnName);
					
					
				}
			
		}		
		if(totalRecords>0)
		{
			
			createTabData(tab,sheet.getSheetName().toUpperCase(),totalRecords,recordsList,columnNamesSet);
			logger.info("Storage totalRecords:"+ totalRecords+"recordsList:"+recordsList);
		}
		logger.info("Total objects set for Storage:"+storageList.size());
		return storageList;
		
	}
	private List<Refinery> populateRefineryData(Sheet sheet,Tab tab)
	{
		logger.info("Class - ReadExcelFile - populateNaturalGasData()");
		int columnNo=0;
		List<Refinery> refineryList=new ArrayList<Refinery>();
		int rowCount=sheet.getLastRowNum();
		
		int totalRecords=0;
		StringBuffer recordsList=new StringBuffer("");							
		Set<String> columnNamesSet=new HashSet<String>();
		int linebreak=1;
		for(int i=1;i<=rowCount;i++)
		{
			Row row=sheet.getRow(i);
			Refinery r=new Refinery();					
			try
			{
//				System.out.println(row.getRowNum());
				columnNo=0;r.setName(null==row.getCell(0)||null==df.formatCellValue(row.getCell(0))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(0)))?BLANK:df.formatCellValue(row.getCell(0)));
				columnNo=1;r.setLocation(null==row.getCell(1)||null==df.formatCellValue(row.getCell(1))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(1)))?BLANK:df.formatCellValue(row.getCell(1)));
				columnNo=2;r.setCountry(null==row.getCell(2)||null==df.formatCellValue(row.getCell(2))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(2)))?BLANK:df.formatCellValue(row.getCell(2)));
				columnNo=3;r.setRegion(null==row.getCell(3)||null==df.formatCellValue(row.getCell(3))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(3)))?BLANK:df.formatCellValue(row.getCell(3)));
				columnNo=4;r.setStatus(null==row.getCell(4)||null==df.formatCellValue(row.getCell(4))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(4)))?BLANK:df.formatCellValue(row.getCell(4)));
				columnNo=5;r.setCapacityYear(null==row.getCell(5) || null==df.formatCellValue(row.getCell(5))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(5)))?0:Integer.parseInt(df.formatCellValue(row.getCell(5)))); 
				columnNo=6;r.setStatusDetails(null==row.getCell(6)||null==df.formatCellValue(row.getCell(6))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(6)))?BLANK:df.formatCellValue(row.getCell(6)));
				columnNo=7;r.setStatusDate(null==row.getCell(7) || null==df.formatCellValue(row.getCell(7))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(7)))?null:new Date(df.formatCellValue(row.getCell(7)))); // Later this one needs to change to String
				columnNo=8;r.setStatusSource(null==row.getCell(8)||null==df.formatCellValue(row.getCell(8))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(8)))?BLANK:df.formatCellValue(row.getCell(8)));
				columnNo=9;r.setMoreInfo(null==row.getCell(9)||null==df.formatCellValue(row.getCell(9))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(9)))?BLANK:df.formatCellValue(row.getCell(9)));
				columnNo=10;r.setType(null==row.getCell(10)||null==df.formatCellValue(row.getCell(10))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(10)))?BLANK:df.formatCellValue(row.getCell(10)));
				
//				System.out.println(" Refinery First");
				
				columnNo=11;r.setStartYear(null==row.getCell(11)|| null==df.formatCellValue(row.getCell(11))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(11)))?null:new Date(df.formatCellValue(row.getCell(11))));
				columnNo=12;r.setDecomissionedYear(null==row.getCell(12)|| null==df.formatCellValue(row.getCell(12))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(12)))?null:new Date(df.formatCellValue(row.getCell(12))));
				columnNo=13;r.setAssetOrStartSource(null==row.getCell(13)||null==df.formatCellValue(row.getCell(13))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(13)))?BLANK:df.formatCellValue(row.getCell(13)));
				columnNo=14;r.setCurrentOperator(null==row.getCell(14)||null==df.formatCellValue(row.getCell(14))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(14)))?BLANK:df.formatCellValue(row.getCell(14)));
				columnNo=15;r.setCurrentEquityPartners(null==row.getCell(15)||null==df.formatCellValue(row.getCell(15))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(15)))?BLANK:df.formatCellValue(row.getCell(15)));
				columnNo=16;r.setCurrentEquityStakes(null==row.getCell(16)|| null==df.formatCellValue(row.getCell(16))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(16)))?0:Double.valueOf(df.formatCellValue(row.getCell(16))));
				columnNo=17;r.setEquityDetails(null==row.getCell(17)||null==df.formatCellValue(row.getCell(17))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(17)))?BLANK:df.formatCellValue(row.getCell(17)));
				columnNo=18;r.setHistoricOperator(null==row.getCell(18)||null==df.formatCellValue(row.getCell(18))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(18)))?BLANK:df.formatCellValue(row.getCell(18)));
				columnNo=19;r.setHistoricEquityPartners(null==row.getCell(19)||null==df.formatCellValue(row.getCell(19))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(19)))?BLANK:df.formatCellValue(row.getCell(19)));
				columnNo=20;r.setHistoricEquityStakes(null==row.getCell(20)|| null==df.formatCellValue(row.getCell(20))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(20)))?0:Double.valueOf(df.formatCellValue(row.getCell(20))));
				
//				System.out.println("Refinery second");
				
				columnNo=21;r.setHistoricEquityYear(null==row.getCell(21)||null==df.formatCellValue(row.getCell(21))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(21)))?0:Integer.parseInt(df.formatCellValue(row.getCell(21))));
				columnNo=22;r.setEquitySource(null==row.getCell(22)||null==df.formatCellValue(row.getCell(22))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(22)))?BLANK:df.formatCellValue(row.getCell(22)));
				columnNo=23;r.setRefiningCapacity(null==row.getCell(23)|| null==df.formatCellValue(row.getCell(23))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(23)))?0:Double.valueOf(df.formatCellValue(row.getCell(23))));
				columnNo=24;r.setVduCapacity(null==row.getCell(24)|| null==df.formatCellValue(row.getCell(24))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(24)))?0:Double.valueOf(df.formatCellValue(row.getCell(24))));
				columnNo=25;r.setCokingCapacity(null==row.getCell(25)|| null==df.formatCellValue(row.getCell(25))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(25)))?0:Double.valueOf(df.formatCellValue(row.getCell(25))));
				columnNo=26;r.setFcc(null==row.getCell(26)|| null==df.formatCellValue(row.getCell(26))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(26)))?0:Double.valueOf(df.formatCellValue(row.getCell(26))));
				columnNo=27;r.setHydroCrackingCapacity(null==row.getCell(27)|| null==df.formatCellValue(row.getCell(27))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(27)))?0:Double.valueOf(df.formatCellValue(row.getCell(27))));
				columnNo=28;r.setSourceCapacities(null==row.getCell(28)||null==df.formatCellValue(row.getCell(28))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(28)))?BLANK:df.formatCellValue(row.getCell(28)));
				columnNo=29;r.setCrudeStorageUnitOrTanksNo(null==row.getCell(29)|| null==df.formatCellValue(row.getCell(29))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(29)))?0:Double.valueOf(df.formatCellValue(row.getCell(29))));
				columnNo=30;r.setCrudeStorageCapacity(null==row.getCell(30)|| null==df.formatCellValue(row.getCell(30))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(30)))?0:Double.valueOf(df.formatCellValue(row.getCell(30))));
				
//				System.out.println("Refinery Three");
				
				
				columnNo=31;r.setNelsonComplexityIndex(null==row.getCell(31)|| null==df.formatCellValue(row.getCell(31))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(31)))?0:Double.valueOf(df.formatCellValue(row.getCell(31))));
				columnNo=32;r.setCrudeThroughput(null==row.getCell(32)|| null==df.formatCellValue(row.getCell(32))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(32)))?0:Double.valueOf(df.formatCellValue(row.getCell(32))));
				columnNo=33;r.setCrudeType(null==row.getCell(33)||null==df.formatCellValue(row.getCell(33))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(33)))?BLANK:df.formatCellValue(row.getCell(33)));
				columnNo=34;r.setApi(null==row.getCell(34)|| null==df.formatCellValue(row.getCell(34))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(34)))?0:Double.valueOf(df.formatCellValue(row.getCell(34))));
				columnNo=35;r.setSulphur(null==row.getCell(35)|| null==df.formatCellValue(row.getCell(35))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(35)))?0:Double.valueOf(df.formatCellValue(row.getCell(35))));
				columnNo=36;r.setSourceInput(null==row.getCell(36)||null==df.formatCellValue(row.getCell(36))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(36)))?BLANK:df.formatCellValue(row.getCell(36)));
				columnNo=37;r.setVisbreakingCapacity(null==row.getCell(37)|| null==df.formatCellValue(row.getCell(37))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(37)))?0:Double.valueOf(df.formatCellValue(row.getCell(37))));
				columnNo=38;r.setReformerCapacity(null==row.getCell(38)|| null==df.formatCellValue(row.getCell(38))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(38)))?0:Double.valueOf(df.formatCellValue(row.getCell(38))));
				columnNo=39;r.setHydrotreatingCapacity(null==row.getCell(39)|| null==df.formatCellValue(row.getCell(39))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(39)))?0:Double.valueOf(df.formatCellValue(row.getCell(39))));
				columnNo=40;r.setAlkylationCapacity(null==row.getCell(40)|| null==df.formatCellValue(row.getCell(40))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(40)))?0:Double.valueOf(df.formatCellValue(row.getCell(40))));
				
//				System.out.println("Refinery Four");
				
				columnNo=41;r.setAlkylationCapacityUnit(null==row.getCell(41)||null==df.formatCellValue(row.getCell(41))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(41)))?BLANK:df.formatCellValue(row.getCell(41)));
				columnNo=42;r.setAromaticsCapacity(null==row.getCell(42)|| null==df.formatCellValue(row.getCell(42))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(42)))?0:Double.valueOf(df.formatCellValue(row.getCell(42))));
				columnNo=43;r.setAromaticsCapacityUnit(null==row.getCell(43)||null==df.formatCellValue(row.getCell(43))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(43)))?BLANK:df.formatCellValue(row.getCell(43)));
				columnNo=44;r.setIsomerizationCapacity(null==row.getCell(44)|| null==df.formatCellValue(row.getCell(44))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(44)))?0:Double.valueOf(df.formatCellValue(row.getCell(44))));
				columnNo=45;r.setPolymerizationCapacity(null==row.getCell(45)|| null==df.formatCellValue(row.getCell(45))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(45)))?0:Double.valueOf(df.formatCellValue(row.getCell(45))));
				columnNo=46;r.setPolymerizationCapacityUnit(null==row.getCell(46)||null==df.formatCellValue(row.getCell(46))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(46)))?BLANK:df.formatCellValue(row.getCell(46)));
				columnNo=47;r.setLubesCapacity(null==row.getCell(47)|| null==df.formatCellValue(row.getCell(47))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(47)))?0:Double.valueOf(df.formatCellValue(row.getCell(47))));
				columnNo=48;r.setLubesCapacityUnit(null==row.getCell(48)||null==df.formatCellValue(row.getCell(48))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(48)))?BLANK:df.formatCellValue(row.getCell(48)));
				columnNo=49;r.setOxygenatesCapacity(null==row.getCell(49)|| null==df.formatCellValue(row.getCell(49))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(49)))?0:Double.valueOf(df.formatCellValue(row.getCell(49))));
				columnNo=50;r.setOxygenatesCapacityUnit(null==row.getCell(50)||null==df.formatCellValue(row.getCell(50))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(50)))?BLANK:df.formatCellValue(row.getCell(50)));
				
//				System.out.println("Refinery five");
				
				columnNo=51;r.setCokeCapacity(null==row.getCell(51)|| null==df.formatCellValue(row.getCell(51))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(51)))?0:Double.valueOf(df.formatCellValue(row.getCell(51))));
				columnNo=52;r.setCokeCapacityUnit(null==row.getCell(52)||null==df.formatCellValue(row.getCell(52))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(52)))?BLANK:df.formatCellValue(row.getCell(52)));
				columnNo=53;r.setSulphurCapacity(null==row.getCell(53)|| null==df.formatCellValue(row.getCell(53))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(53)))?0:Double.valueOf(df.formatCellValue(row.getCell(53))));
				columnNo=54;r.setSulphurCapacityUnit(null==row.getCell(54)||null==df.formatCellValue(row.getCell(54))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(54)))?BLANK:df.formatCellValue(row.getCell(54)));
				columnNo=55;r.setHydrogenCapacity(null==row.getCell(55)|| null==df.formatCellValue(row.getCell(55))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(55)))?0:Double.valueOf(df.formatCellValue(row.getCell(55))));
				columnNo=56;r.setHydrogenCapacityUnit(null==row.getCell(56)||null==df.formatCellValue(row.getCell(56))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(56)))?BLANK:df.formatCellValue(row.getCell(56)));
				columnNo=57;r.setAsphaltCapacity(null==row.getCell(57)|| null==df.formatCellValue(row.getCell(57))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(57)))?0:Double.valueOf(df.formatCellValue(row.getCell(57))));
				columnNo=58;r.setAsphaltCapacityUnit(null==row.getCell(58)||null==df.formatCellValue(row.getCell(58))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(58)))?BLANK:df.formatCellValue(row.getCell(58)));
				columnNo=59;r.setOthersCapacity(null==row.getCell(59)|| null==df.formatCellValue(row.getCell(59))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(59)))?0:Double.valueOf(df.formatCellValue(row.getCell(59))));
				columnNo=60;r.setRefineryProducts(null==row.getCell(60)||null==df.formatCellValue(row.getCell(60))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(60)))?BLANK:df.formatCellValue(row.getCell(60)));
				
//				System.out.println("Refinery six");
				
				columnNo=61;r.setSourceProducts(null==row.getCell(61)||null==df.formatCellValue(row.getCell(61))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(61)))?BLANK:df.formatCellValue(row.getCell(61)));
				columnNo=62;r.setRefineryUtilization(null==row.getCell(62)|| null==df.formatCellValue(row.getCell(62))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(62)))?0:Double.valueOf(df.formatCellValue(row.getCell(62))));
				columnNo=63;r.setGrm(null==row.getCell(63)|| null==df.formatCellValue(row.getCell(63))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(63)))?0:Double.valueOf(df.formatCellValue(row.getCell(63))));
				columnNo=64;r.setCapex(null==row.getCell(64)|| null==df.formatCellValue(row.getCell(64))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(64)))?0:Double.valueOf(df.formatCellValue(row.getCell(64))));
				columnNo=65;r.setCapexYear(null==row.getCell(65)|| null==df.formatCellValue(row.getCell(65))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(65)))?0:Integer.parseInt(df.formatCellValue(row.getCell(65))));// This is also an int or text
				columnNo=66;r.setCapexDetails(null==row.getCell(66)||null==df.formatCellValue(row.getCell(66))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(66)))?BLANK:df.formatCellValue(row.getCell(66)));
				columnNo=67;r.setSourceCapex(null==row.getCell(67)||null==df.formatCellValue(row.getCell(67))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(67)))?BLANK:df.formatCellValue(row.getCell(67)));
				columnNo=68;r.setConstructionCompanyName(null==row.getCell(68)||null==df.formatCellValue(row.getCell(68))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(68)))?BLANK:df.formatCellValue(row.getCell(68)));
				columnNo=69;r.setConstructionContractDetails(null==row.getCell(69)||null==df.formatCellValue(row.getCell(69))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(69)))?BLANK:df.formatCellValue(row.getCell(69)));
				columnNo=70;r.setRefineryOtherNames(null==row.getCell(70)||null==df.formatCellValue(row.getCell(70))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(70)))?BLANK:df.formatCellValue(row.getCell(70)));
				
//				System.out.println("Refinery seven");
				
				columnNo=71;r.setOtherSources(null==row.getCell(71)||null==df.formatCellValue(row.getCell(71))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(71)))?BLANK:df.formatCellValue(row.getCell(71)));
				columnNo=72;r.setContact(null==row.getCell(72)||null==df.formatCellValue(row.getCell(72))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(72)))?BLANK:df.formatCellValue(row.getCell(72)));
				columnNo=73;r.setGasolinePetrol(null==row.getCell(73)|| null==df.formatCellValue(row.getCell(73))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(73)))?0:Double.valueOf(df.formatCellValue(row.getCell(73))));
				columnNo=74;r.setLpg(null==row.getCell(74)|| null==df.formatCellValue(row.getCell(74))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(74)))?0:Double.valueOf(df.formatCellValue(row.getCell(74))));
				columnNo=75;r.setKerosine(null==row.getCell(75)|| null==df.formatCellValue(row.getCell(75))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(75)))?0:Double.valueOf(df.formatCellValue(row.getCell(75))));
				columnNo=76;r.setJetFuel(null==row.getCell(76)|| null==df.formatCellValue(row.getCell(76))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(76)))?0:Double.valueOf(df.formatCellValue(row.getCell(76))));
				columnNo=77;r.setDiesel(null==row.getCell(77)|| null==df.formatCellValue(row.getCell(77))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(77)))?0:Double.valueOf(df.formatCellValue(row.getCell(77))));
				columnNo=78;r.setPropylene(null==row.getCell(78)|| null==df.formatCellValue(row.getCell(78))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(78)))?0:Double.valueOf(df.formatCellValue(row.getCell(78))));
				columnNo=79;r.setLightNaphtha(null==row.getCell(79)|| null==df.formatCellValue(row.getCell(79))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(79)))?0:Double.valueOf(df.formatCellValue(row.getCell(79))));
				columnNo=80;r.setHeavyNaphtha(null==row.getCell(80)|| null==df.formatCellValue(row.getCell(80))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(80)))?0:Double.valueOf(df.formatCellValue(row.getCell(80))));
				
//				System.out.println("Refinery eight");
				
				columnNo=81;r.setKerojet(null==row.getCell(81)|| null==df.formatCellValue(row.getCell(81))|| (BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(81)))?0:Double.valueOf(df.formatCellValue(row.getCell(81))));
				columnNo=82;r.setBenzeneSaturationUnit(null==row.getCell(82)||null==df.formatCellValue(row.getCell(82))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(82)))?BLANK:df.formatCellValue(row.getCell(82)));
				columnNo=83;r.setProductsSources(null==row.getCell(83)||null==df.formatCellValue(row.getCell(83))||(BLANK).equalsIgnoreCase(df.formatCellValue(row.getCell(83)))?BLANK:df.formatCellValue(row.getCell(83)));
				
				refineryList.add(r);
			}
			catch(Exception e)
			{
				logger.error("Exception in ReadExcelFile - populateNaturalGasData():"+e);
				totalRecords++;
				String columnName=getHeaderValues(sheet, columnNo);
				recordsList.append((row.getRowNum()+1)+",");
				if(totalRecords==(12*linebreak))
				{	
					recordsList.append(" ");// Adding space for rendering in front end;
					linebreak++;
				}	
				columnNamesSet.add(columnName);
				
				
			}
			
		}
		if(totalRecords>0)
		{
			
			createTabData(tab,sheet.getSheetName().toUpperCase(),totalRecords,recordsList,columnNamesSet);
			logger.info("Refinery totalRecords:"+ totalRecords+"recordsList:"+recordsList);
		}
		logger.info("Total objects set for refinery:"+refineryList.size());
		return refineryList;
		
		
	}
	
	private List<Exploration> populateExplorationData(Sheet sheet,Tab tab)
	{
		logger.info("Class - ReadExcelFile - populateExplorationData()");
		int columnNo=0;
		List<Exploration> explorationDataList=new ArrayList<Exploration>();
		int rowCount=sheet.getLastRowNum();
		
		
		int totalRecords=0;
		StringBuffer recordsList=new StringBuffer("");					
		StringBuffer descriptionList=new StringBuffer("");	
		Set<String> columnNamesSet=new HashSet<String>();
		int linebreak=1;
		
		for(int i=1;i<=rowCount;i++)
		{
			Row row=sheet.getRow(i);
//			System.out.println(row.getRowNum());
			Exploration e=new Exploration();				
				try
				{
					columnNo=0;e.setBlockNo(null==row.getCell(0) || null==df.formatCellValue(row.getCell(0)) || ("").equalsIgnoreCase(df.formatCellValue(row.getCell(0)))?"":df.formatCellValue(row.getCell(0)));
					columnNo=1;e.setRegion(null==row.getCell(1)|| null==df.formatCellValue(row.getCell(1)) || ("").equalsIgnoreCase(df.formatCellValue(row.getCell(1)))?"":df.formatCellValue(row.getCell(1)));
					columnNo=2;e.setCountry(null==row.getCell(2)|| null==df.formatCellValue(row.getCell(2)) || ("").equalsIgnoreCase(df.formatCellValue(row.getCell(2)))?"":df.formatCellValue(row.getCell(2)));
					columnNo=3;e.setOnShoreOrOffShore(null==row.getCell(3)|| null==df.formatCellValue(row.getCell(3)) || ("").equalsIgnoreCase(df.formatCellValue(row.getCell(3)))?"":df.formatCellValue(row.getCell(3)));
					columnNo=4;e.setBasin(null==row.getCell(4)|| null==df.formatCellValue(row.getCell(4)) || ("").equalsIgnoreCase(df.formatCellValue(row.getCell(4)))?"":df.formatCellValue(row.getCell(4)));
					columnNo=5;e.setStatus(null==row.getCell(5)|| null==df.formatCellValue(row.getCell(5)) || ("").equalsIgnoreCase(df.formatCellValue(row.getCell(5)))?"":df.formatCellValue(row.getCell(5)));
					
		//			System.out.println("Exploration first");
					
					columnNo=6;e.setStartDate(null==row.getCell(6) || null==df.formatCellValue(row.getCell(6))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(6)))?null:new Date(df.formatCellValue(row.getCell(6))));
					columnNo=7;e.setOperator(null==row.getCell(7)|| null==df.formatCellValue(row.getCell(7)) || ("").equalsIgnoreCase(df.formatCellValue(row.getCell(7)))?"":df.formatCellValue(row.getCell(7)));
					columnNo=8;e.setEquityParterns(null==row.getCell(8)|| null==df.formatCellValue(row.getCell(8)) || ("").equalsIgnoreCase(df.formatCellValue(row.getCell(8)))?"":df.formatCellValue(row.getCell(8)));
					columnNo=9;e.setSourceEquity(null==row.getCell(9)|| null==df.formatCellValue(row.getCell(9)) || ("").equalsIgnoreCase(df.formatCellValue(row.getCell(9)))?"":df.formatCellValue(row.getCell(9)));
					columnNo=10;e.setArea(null==row.getCell(10)|| null==df.formatCellValue(row.getCell(10))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(10)))?0:Double.valueOf(df.formatCellValue(row.getCell(10))));
					columnNo=11;e.setLicenseEnddate(null==row.getCell(11)|| null==df.formatCellValue(row.getCell(11))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(11)))?null:new Date(df.formatCellValue(row.getCell(11))));
					
		//			System.out.println("Exploration second");
					
					columnNo=12;e.setWellsDrilled(null==row.getCell(12)|| null==df.formatCellValue(row.getCell(12))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(12)))?0:Double.valueOf(df.formatCellValue(row.getCell(12))));
					columnNo=13;e.setTwoDSeismicCompleted(null==row.getCell(13)|| null==df.formatCellValue(row.getCell(13))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(13)))?0:Double.valueOf(df.formatCellValue(row.getCell(13))));
					columnNo=14;e.setThreeDSeismic(null==row.getCell(14)|| null==df.formatCellValue(row.getCell(14))|| ("").equalsIgnoreCase(df.formatCellValue(row.getCell(14)))?0:Double.valueOf(df.formatCellValue(row.getCell(14))));
					columnNo=15;e.setMoreInfo(null==row.getCell(15)|| null==df.formatCellValue(row.getCell(15)) || ("").equalsIgnoreCase(df.formatCellValue(row.getCell(15)))?"":df.formatCellValue(row.getCell(15)));
					columnNo=16;e.setNotes(null==row.getCell(16)|| null==df.formatCellValue(row.getCell(16)) || ("").equalsIgnoreCase(df.formatCellValue(row.getCell(16)))?"":df.formatCellValue(row.getCell(16)));
					columnNo=17;e.setSource(null==row.getCell(17)|| null==df.formatCellValue(row.getCell(17)) || ("").equalsIgnoreCase(df.formatCellValue(row.getCell(17)))?"":df.formatCellValue(row.getCell(17)));
		//			System.out.println(row.getCell(18));
		//			System.out.println(row.getCell(18).getStringCellValue());
					columnNo=18;e.setLicenseNo(null==row.getCell(18)|| null==df.formatCellValue(row.getCell(18)) || ("").equalsIgnoreCase(df.formatCellValue(row.getCell(18)))?"":df.formatCellValue(row.getCell(18)));
//					columnNo=19;e.setRecordId(null==row.getCell(19)?0:Double.valueOf(row.getCell(19).getNumericCellValue()).intValue());
					
					explorationDataList.add(e);
				}
				catch(Exception ex)
				{
					logger.error("Exception in ReadExcelFile - populateExplorationData():"+ex);
					totalRecords++;
					String columnName=getHeaderValues(sheet, columnNo);
					recordsList.append((row.getRowNum()+1)+",");
					if(totalRecords==(12*linebreak))
					{	
						recordsList.append(" ");// Adding space for rendering in front end;
						linebreak++;
					}	
					columnNamesSet.add(columnName);																
				}
				
		}
		if(totalRecords>0)
		{
			createTabData(tab,sheet.getSheetName().toUpperCase(),totalRecords,recordsList,columnNamesSet);
			logger.info("Exploration totalRecords:"+ totalRecords+" columnNames:"+descriptionList+"recordsList:"+recordsList);
		}
		
		logger.info("Total objects set for Exploration:"+explorationDataList.size());
		return explorationDataList;
		
	}
	private void createTabData(Tab tab,String sheetName,int totalRecords,StringBuffer recordsList,Set<String> columnNames)
	{
		logger.info("Class - ReadExcelFile - createTabData()");
		StringBuffer columnList=new StringBuffer("");
		tab.setName(sheetName);
		if(recordsList.charAt(recordsList.length()-1)==32)
			recordsList.deleteCharAt(recordsList.length()-2);
		else
			recordsList.deleteCharAt(recordsList.length()-1);
		tab.setRecords(recordsList.toString());
		
		Object[] columnNameArray=columnNames.toArray();
		for(int i=0;i<columnNameArray.length;i++)
		{
			columnList.append(columnNameArray[i]);
			if(i<columnNameArray.length-1)
				columnList.append(",");
		}
		
		tab.setDescription(columnList.toString());
		tab.setTotalRecords(totalRecords);
		
	}
	private String getHeaderValues(Sheet sheet,int columnNo)
	{
		logger.info("Class - ReadExcelFile - getHeaderValues()");
		Row  headerRow=sheet.getRow(0);
		int cellCount=headerRow.getLastCellNum();
		String[] headers=new String[cellCount];
		
		for(int i=0;i<cellCount;i++)
		   headers[i]=headerRow.getCell(i).toString();
		
		String columName=headers[columnNo];
		return columName;
	}
	

}
