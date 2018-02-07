package com.lnganalysis.helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lnganalysis.dao.source.SourceDao;
import com.lnganalysis.dao.source.impl.CountriesDaoImpl;
import com.lnganalysis.dao.source.impl.ImportCountriesDaoImpl;
import com.lnganalysis.dao.source.impl.LngSourceDaoImpl;
import com.lnganalysis.dao.source.impl.PipeLineSourceDaoImpl;
import com.lnganalysis.dao.source.impl.RefinerySourceDaoImpl;
import com.lnganalysis.dao.source.impl.RegionDaoImpl;
import com.lnganalysis.dao.source.impl.SingleSourceDaoImpl;
import com.lnganalysis.dao.source.impl.SmallScaleLngSourceDaoImpl;
import com.lnganalysis.dao.source.impl.StatusDaoImpl;
import com.lnganalysis.dao.source.impl.StorageSourceDaoImpl;
import com.lnganalysis.dao.source.impl.TypeDaoImpl;
import com.lnganalysis.entities.source.Countries;
import com.lnganalysis.entities.source.ImportCountries;
import com.lnganalysis.entities.source.LngSource;
import com.lnganalysis.entities.source.PipeLineSource;
import com.lnganalysis.entities.source.RefinerySource;
import com.lnganalysis.entities.source.Region;
import com.lnganalysis.entities.source.SingleSource;
import com.lnganalysis.entities.source.SmallScaleLngSource;
import com.lnganalysis.entities.source.Status;
import com.lnganalysis.entities.source.StorageSource;
import com.lnganalysis.entities.source.Type;

public class SourceHelper {
	static final Logger logger=Logger.getLogger(SourceHelper.class);
	public List<String> getPipeLineSourceList()throws Exception
	{
		
		SourceDao pipeLineSourceDao=new PipeLineSourceDaoImpl();
		List<String> populatePipeLineSourceList=new ArrayList<String>();
		List pipeLineSourceList=pipeLineSourceDao.readSource();
		for(Object pipeLineSourceObject:pipeLineSourceList)
		{
			PipeLineSource pipeLineSource=(PipeLineSource)pipeLineSourceObject;
			populatePipeLineSourceList.add(pipeLineSource.getName());
		}
		return populatePipeLineSourceList;
	}
	public  List<String> getLngSourceList()throws Exception
	{
		SourceDao lngSourceDao=new LngSourceDaoImpl();
		List<String> populateLngSourceList=new ArrayList<String>();
		List lngSourceList=lngSourceDao.readSource();
		for(Object lngSourceObject:lngSourceList)
		{
			LngSource lngSource=(LngSource)lngSourceObject;
			populateLngSourceList.add(lngSource.getName());
		}
		return populateLngSourceList;
	}
	public  List<String> getStorageSourceList()throws Exception
	{
		SourceDao storageSourceDao=new StorageSourceDaoImpl();
		List<String> populateStorageSourceList=new ArrayList<String>();
		List storageSourceList=storageSourceDao.readSource();
		for(Object storageSourceObject:storageSourceList)
		{
			StorageSource storage=(StorageSource)storageSourceObject;
			populateStorageSourceList.add(storage.getName());
		}
		return populateStorageSourceList;
	}
	public List<String> getRefinerySourceList()throws Exception
	{
		SourceDao refinerySourceDao=new RefinerySourceDaoImpl();
		List<String> populateRefinerySourceList=new ArrayList<String>();
		List refinerySourceList=refinerySourceDao.readSource();
		for(Object refinerySourceObject:refinerySourceList)
		{
			RefinerySource rs=(RefinerySource)refinerySourceObject;
			populateRefinerySourceList.add(rs.getName());
		}
		return populateRefinerySourceList;
	}
	 
	public List<String> getImportCountriesList()throws Exception
	{
		SourceDao importCountryDao=new ImportCountriesDaoImpl();
		List<String> populateCountriesList=new ArrayList<String>();
		List countryDaoList=importCountryDao.readSource();
		for(Object countriesObject:countryDaoList)
		{
			ImportCountries c=(ImportCountries)countriesObject;
			populateCountriesList.add(c.getName());
		}
		return populateCountriesList;
	}
	public List<String> getCountriesList()throws Exception
	{
		SourceDao countryDao=new CountriesDaoImpl();
		List<String> populateCountriesList=new ArrayList<String>();
		List countryDaoList=countryDao.readSource();
		for(Object countriesObject:countryDaoList)
		{
			Countries c=(Countries)countriesObject;
			populateCountriesList.add(c.getName());
		}
		return populateCountriesList;
	}
	public List<String> getSingleSourceList()throws Exception
	{
		SourceDao singleSourceDao=new SingleSourceDaoImpl();
		List<String> populateSourceList=new ArrayList<String>();
		List singleSourceDaoList=singleSourceDao.readSource();
		for(Object sourceObject:singleSourceDaoList)
		{
			SingleSource singleSource=(SingleSource)sourceObject;
			populateSourceList.add(singleSource.getName());
		}
		return populateSourceList;
		
	}
	public List<String> getStatusList()throws Exception
	{
		SourceDao statusDao=new StatusDaoImpl();
		List<String> populateStatusList=new ArrayList<String>();
		List statusDaoList=statusDao.readSource();
		for(Object statusObject:statusDaoList)
		{
			Status status=(Status)statusObject;
			populateStatusList.add(status.getName());
		}			
		return populateStatusList;
	}
	public  List<String> getRegionList()throws Exception
	{
		SourceDao regionDao=new RegionDaoImpl();
		List<String> populateRegionList=new ArrayList<String>();
		List regionDaoList=regionDao.readSource();
		for(Object regionObject:regionDaoList)
		{
			Region region=(Region)regionObject;
			populateRegionList.add(region.getName());
		}
		return populateRegionList;
	}
	public List<String> getTypeList()throws Exception
	{
		SourceDao typeDao=new TypeDaoImpl();
		List<String> popluateTypeList=new ArrayList<String>();
		List typeDaoList=typeDao.readSource();
		for(Object typeObject:typeDaoList)
		{
			Type type=(Type)typeObject;
			popluateTypeList.add(type.getName());
		}
		return popluateTypeList;
	}
	public List<String> getSmallScaleLngSourceList()throws Exception
	{
		SourceDao smallScaleLngSourceDao=new SmallScaleLngSourceDaoImpl();
		List<String> popluateSmallScaleLngSourceList=new ArrayList<String>();
		List smallScaleLngSourceDaoList=smallScaleLngSourceDao.readSource();
		for(Object sslngSourceObject:smallScaleLngSourceDaoList)
		{
			SmallScaleLngSource smallScaleLngSource=(SmallScaleLngSource)sslngSourceObject;
			popluateSmallScaleLngSourceList.add(smallScaleLngSource.getName());
		}
		return popluateSmallScaleLngSourceList;
	}
}
