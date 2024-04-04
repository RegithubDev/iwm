package com.resustainability.reisp.model;

import java.util.List;

public class SitePaginationObject {
	private int iTotalDisplayRecords; 
	private int iTotalRecords;
	private List<Site> aaData;
	
	public int getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public List<Site> getAaData() {
		return aaData;
	}
	public void setAaData(List<Site> aaData) {
		this.aaData = aaData;
	}
	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
}
