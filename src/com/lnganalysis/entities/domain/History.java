package com.lnganalysis.entities.domain;

import java.util.Date;

public class History {
	private int id;
	private int explorationCount;
	private int crudeOilCount;
	private int naturalGasCount;
	private int refineriesCount;
	private int storageCount;
	private int lngCount;
	private int pipelinesCount;
	private int supplyDemandCount;
	private int contractsCount;
	private int companyOilGasCount;
	private int smallScaleLngCount;
	private User user;
	private Date createdDate;
	
	
	public int getExplorationCount() {
		return explorationCount;
	}
	public void setExplorationCount(int explorationCount) {
		this.explorationCount = explorationCount;
	}
	public int getCrudeOilCount() {
		return crudeOilCount;
	}
	public void setCrudeOilCount(int crudeOilCount) {
		this.crudeOilCount = crudeOilCount;
	}
	public int getNaturalGasCount() {
		return naturalGasCount;
	}
	public void setNaturalGasCount(int naturalGasCount) {
		this.naturalGasCount = naturalGasCount;
	}	
	public int getRefineriesCount() {
		return refineriesCount;
	}
	public void setRefineriesCount(int refineriesCount) {
		this.refineriesCount = refineriesCount;
	}
	public int getStorageCount() {
		return storageCount;
	}
	public void setStorageCount(int storageCount) {
		this.storageCount = storageCount;
	}
	public int getLngCount() {
		return lngCount;
	}
	public void setLngCount(int lngCount) {
		this.lngCount = lngCount;
	}
	public int getPipelinesCount() {
		return pipelinesCount;
	}
	public void setPipelinesCount(int pipelinesCount) {
		this.pipelinesCount = pipelinesCount;
	}
	
	public int getSupplyDemandCount() {
		return supplyDemandCount;
	}
	public void setSupplyDemandCount(int supplyDemandCount) {
		this.supplyDemandCount = supplyDemandCount;
	}
	
	public int getCompanyOilGasCount() {
		return companyOilGasCount;
	}
	public void setCompanyOilGasCount(int companyOilGasCount) {
		this.companyOilGasCount = companyOilGasCount;
	}
	public int getContractsCount() {
		return contractsCount;
	}
	public void setContractsCount(int contractsCount) {
		this.contractsCount = contractsCount;
	}
	
	public int getSmallScaleLngCount() {
		return smallScaleLngCount;
	}
	public void setSmallScaleLngCount(int smallScaleLngCount) {
		this.smallScaleLngCount = smallScaleLngCount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
