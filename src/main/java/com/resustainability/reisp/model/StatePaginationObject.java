package com.resustainability.reisp.model;

import java.util.List;

public class StatePaginationObject {
	private int iTotalDisplayRecords; 
	private int iTotalRecords;
	private List<State> aaData;
	
	public int getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public List<State> getAaData() {
		return aaData;
	}
	public void setAaData(List<State> aaData) {
		this.aaData = aaData;
	}
	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
}
