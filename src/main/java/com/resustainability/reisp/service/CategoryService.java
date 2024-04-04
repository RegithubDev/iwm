package com.resustainability.reisp.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resustainability.reisp.dao.CategoryDao;
import com.resustainability.reisp.model.Category;
import com.resustainability.reisp.model.Company;
import com.resustainability.reisp.model.Category;

@Service
public class CategoryService {
	@Autowired
	CategoryDao dao;

	public boolean addCategory(Category obj)  throws Exception {
		return dao.addCategory(obj);
	}

	public boolean updateCategory(Category obj) throws Exception  {
		return dao.updateCategory(obj);
	}

	public List<Category> getSBUList(Category obj) throws Exception {
		return dao.getSBUList(obj);
	}

	public List<Category> getStatusFilterListForCategory(Category obj) throws Exception {
		return dao.getStatusFilterListForCategory(obj);
	}
	public List<Category> getSBUFilterListForCategory(Category obj) throws Exception {
		return dao.getSBUFilterListForCategory(obj);
	}


	public List<Category> checkUniqueIfForCategory(Category obj) throws Exception {
		return dao.checkUniqueIfForCategory(obj);
	}

	public List<Category> getCategoryFilterListForCategory(Category obj) throws Exception {
		return dao.getCategoryFilterListForCategory(obj);
	}

	public int getTotalRecords(Category obj, String searchParameter) throws Exception {
		return dao.getTotalRecords(obj,searchParameter);
	}

	public List<Category> getCategoryList(Category obj, int startIndex, int offset, String searchParameter) throws Exception {
		return dao.getCategoryList(obj,startIndex,offset,searchParameter);
	}
	
}
