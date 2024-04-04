package com.resustainability.reisp.model;

public class Role {

	private String id
    ,sbu_code,roles
    ,role_name
    ,status
    ,created_by
    ,modified_date
    ,created_date
    ,modified_by,sbu,sbu_name;

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getId() {
		return id;
	}

	public String getSbu_code() {
		return sbu_code;
	}

	public String getRole_name() {
		return role_name;
	}

	public String getStatus() {
		return status;
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

	public String getSbu() {
		return sbu;
	}

	public String getSbu_name() {
		return sbu_name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSbu_code(String sbu_code) {
		this.sbu_code = sbu_code;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public void setSbu(String sbu) {
		this.sbu = sbu;
	}

	public void setSbu_name(String sbu_name) {
		this.sbu_name = sbu_name;
	}
	
	
}
