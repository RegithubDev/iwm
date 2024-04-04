package com.resustainability.reisp.model;

import java.util.List;

public class CategoryPaginationObject {
	private int iTotalDisplayRecords; 
	private int iTotalRecords;
	private List<Category> aaData;
	
	public int getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public List<Category> getAaData() {
		return aaData;
	}
	public void setAaData(List<Category> aaData) {
		this.aaData = aaData;
	}
	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
}
