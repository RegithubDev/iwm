package com.resustainability.reisp.model;

import java.util.List;

public class SBUPaginationObject {
	private int iTotalDisplayRecords; 
	private int iTotalRecords;
	private List<SBU> aaData;
	
	public int getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public List<SBU> getAaData() {
		return aaData;
	}
	public void setAaData(List<SBU> aaData) {
		this.aaData = aaData;
	}
	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
}
