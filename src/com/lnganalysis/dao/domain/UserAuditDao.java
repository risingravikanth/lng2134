package com.lnganalysis.dao.domain;

import java.util.Date;
import java.util.List;

import com.lnganalysis.entities.domain.UserAudit;

public interface UserAuditDao {
	public void saveUserAudit(UserAudit userAudit)throws Exception;
	public List<UserAudit> readUserAudit(Date startDate,Date endDate)throws Exception;
}
