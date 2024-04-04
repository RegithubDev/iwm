package com.resustainability.reisp.model;

import java.util.List;

public class DataManagementObject {
	private int iTotalDisplayRecords; 
	private int iTotalRecords;
	private List<DataManagement> aaData;
	
	public int getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public List<DataManagement> getAaData() {
		return aaData;
	}
	public void setAaData(List<DataManagement> aaData) {
		this.aaData = aaData;
	}
	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
}
