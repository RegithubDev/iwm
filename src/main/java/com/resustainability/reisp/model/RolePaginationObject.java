package com.resustainability.reisp.model;

import java.util.List;

public class RolePaginationObject {
	private int iTotalDisplayRecords; 
	private int iTotalRecords;
	private List<Role> aaData;
	
	public int getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public List<Role> getAaData() {
		return aaData;
	}
	public void setAaData(List<Role> aaData) {
		this.aaData = aaData;
	}
	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
}
