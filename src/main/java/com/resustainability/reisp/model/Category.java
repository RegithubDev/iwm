package com.resustainability.reisp.model;

public class Category {

	private String id
    ,category_code
    ,category_name
    ,sbu_code,sbu_name
    ,created_by
    ,modified_date,sbu
    ,created_date
    ,modified_by,status;

	public String getSbu() {
		return sbu;
	}

	public void setSbu(String sbu) {
		this.sbu = sbu;
	}

	public String getSbu_name() {
		return sbu_name;
	}

	public void setSbu_name(String sbu_name) {
		this.sbu_name = sbu_name;
	}

	public String getId() {
		return id;
	}

	public String getCategory_code() {
		return category_code;
	}

	public String getCategory_name() {
		return category_name;
	}

	public String getSbu_code() {
		return sbu_code;
	}

	public String getCreated_by() {
		return created_by;
	}

	public String getModified_date() {
		return modified_date;
	}

	public String getCreated_date() {
		return created_date;
	}

	public String getModified_by() {
		return modified_by;
	}

	public String getStatus() {
		return status;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public void setSbu_code(String sbu_code) {
		this.sbu_code = sbu_code;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
