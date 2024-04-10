package com.resustainability.reisp.model;

import java.util.List;

import com.resustainability.reisp.model.IWM;

public class IWMPaginationObject {
	private int iTotalDisplayRecords; 
	private int iTotalRecords;
	private List<IWM> aaData;
	
	public int getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public List<IWM> getAaData() {
		return aaData;
	}
	public void setAaData(List<IWM> aaData) {
		this.aaData = aaData;
	}
	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
}
