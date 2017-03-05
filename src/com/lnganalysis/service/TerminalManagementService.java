package com.lnganalysis.service;

import java.util.List;

public interface TerminalManagementService {
	public List<String> readData(String sourceType);
	public String deleteData(String sourceType,String sourceName);
}
