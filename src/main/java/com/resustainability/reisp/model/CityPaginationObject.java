package com.resustainability.reisp.model;

import java.util.List;

public class CityPaginationObject {
	private int iTotalDisplayRecords; 
	private int iTotalRecords;
	private List<City> aaData;
	
	public int getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public List<City> getAaData() {
		return aaData;
	}
	public void setAaData(List<City> aaData) {
		this.aaData = aaData;
	}
	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
}
