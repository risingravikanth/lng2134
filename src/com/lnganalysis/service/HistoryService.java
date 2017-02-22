package com.lnganalysis.service;

import java.util.Date;
import java.util.List;

import com.lnganalysis.entities.domain.History;
import com.lnganalysis.entities.domain.User;

public interface HistoryService {
	public List<History> readHistoryForDateRange(Date startDate,Date endDate);
	public List<History> readUserHistoryForDateRange(User user,Date startDate,Date endDate);
}
