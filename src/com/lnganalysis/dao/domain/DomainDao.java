package com.lnganalysis.dao.domain;

import java.util.List;
import java.util.Set;

public interface DomainDao {
	public void save(List<Object> list)throws Exception;
	public void upate(List<Object> list)throws Exception;
	public List<Object> read();
	public int getLastRecordNum()throws Exception;
	public void delete(Set<String> names)throws Exception;
	public void delete(String name)throws Exception; //This method deletes records of selected terminal
	public List<String> readTerminals() throws Exception;
	
}
