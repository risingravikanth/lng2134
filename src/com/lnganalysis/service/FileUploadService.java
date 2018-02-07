package com.lnganalysis.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import com.lnganalysis.dto.Tab;
import com.lnganalysis.entities.domain.User;

public interface FileUploadService {
	public String uploadFileService(InputStream is,User user,String action);
	public void writeFile(FileItem fi,String filePath)throws Exception;
	public int getExplorationCount()throws Exception;
	public int getRefineriesCount()throws Exception;
	public int getCrudeOilCount()throws Exception;
	public int getNaturalGasCount()throws Exception;
	public int getStorageCount()throws Exception;
	public int getLngCount()throws Exception;
	public int getPipeLineCount()throws Exception;
	public int getSmallScaleLngCount()throws Exception;
	
	
}
