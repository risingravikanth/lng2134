package com.lnganalysis.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.lnganalysis.dao.domain.HistoryDao;
import com.lnganalysis.dao.domain.impl.HistoryDaoImpl;
import com.lnganalysis.entities.domain.History;
import com.lnganalysis.entities.domain.User;
import com.lnganalysis.service.HistoryService;

public class HistoryServiceImpl implements HistoryService {
	static final Logger logger=Logger.getLogger(HistoryServiceImpl.class);
	@Override
	public List<History> readHistoryForDateRange(Date startDate, Date endDate) {
		// TODO Auto-generated method stub		
		HistoryDao historyDao=null;
		List<History> history=null;
		try
		{
			historyDao=new HistoryDaoImpl();
			history=historyDao.readHistoryForDateRange(startDate, endDate);
		}
		catch(Exception e)
		{
			logger.error("Exception in HistoryServiceImpl - Method readHistoryForDateRange:"+e);			
		}
		return history;
	}

	@Override
	public List<History> readUserHistoryForDateRange(User user,Date startDate,
			Date endDate) {
		// TODO Auto-generated method stub
		HistoryDao historyDao=null;
		List<History> history=null;
		try
		{
			historyDao=new HistoryDaoImpl();
			history=historyDao.readUserHistoryForDateRange(user, startDate, endDate);
		}
		catch(Exception e)
		{
			logger.error("Exception in HistoryServiceImpl - Method readUserHistoryForDateRange:"+e);
			
		}
		return history;
	}

}
