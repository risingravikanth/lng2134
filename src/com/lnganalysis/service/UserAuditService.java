package com.lnganalysis.service;

import java.util.Date;
import java.util.List;

import com.lnganalysis.entities.domain.UserAudit;

public interface UserAuditService {
	public void saveAudit(String emailId,Date currentDate,String comments,String loginFlag,String action);
	public List<UserAudit> readAudit(Date startDate,Date endDate);
}
