package com.lnganalysis.service;

import java.util.List;

public interface DataManagementService {
	public List<Object> readSourceData(String sourceType);
	public String deleteSourceData(String sourceType,String sourceName);
	public String saveSourceData(String sourceType,String sourceName);
}
