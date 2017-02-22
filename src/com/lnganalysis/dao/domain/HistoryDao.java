package com.lnganalysis.dao.domain;

import java.util.Date;
import java.util.List;

import com.lnganalysis.entities.domain.History;
import com.lnganalysis.entities.domain.User;

public interface HistoryDao {
	public void saveHistory(History history)throws Exception;
	public List<History> readUserHistoryForDateRange(User user,Date fromDate,Date toDate)throws Exception;
	public List<History> readHistoryForDateRange(Date fromDate,Date toDate)throws Exception;
	public void deleteHistory(History history)throws Exception;
	public List<History> readUserHistory(User user)throws Exception;
}
