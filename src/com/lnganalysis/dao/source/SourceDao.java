package com.lnganalysis.dao.source;

import java.util.List;

public interface SourceDao {
	public void deleteSource(String name)throws Exception;
	public List<Object> readSource()throws Exception;
	public void saveSource(String name)throws Exception;
	public List findSource(String name)throws Exception;
}
