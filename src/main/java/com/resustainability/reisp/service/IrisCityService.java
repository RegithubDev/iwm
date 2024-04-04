package com.resustainability.reisp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resustainability.reisp.dao.IrisCityDao;
import com.resustainability.reisp.model.City;
import com.resustainability.reisp.model.SBU;


@Service
public class IrisCityService {

	@Autowired
	IrisCityDao dao;

	public int getTotalRecords(City obj, String searchParameter) throws Exception {
		return dao.getTotalRecords(obj,searchParameter);
	}

	public List<City> getCityList(City obj, int startIndex, int offset, String searchParameter) throws Exception {
		return dao.getCityList(obj,startIndex,offset,searchParameter);
	}

	public boolean addCityIris(City obj) throws Exception {
		return dao.addCityIris(obj);
	}

	public City getCityDetails(City user)throws Exception {
		return dao.getCityDetails(user);
	}

	public boolean updateCityIris(City obj) throws Exception {
		return dao.updateCityIris(obj);
	}
	public List<City> getStateFilterListForCity(City obj)throws Exception {
		return dao.getStateFilterListForCity(obj);
	}
	public List<City> getCityFilterListForCity(City obj)throws Exception {
		return dao.getCityFilterListForCity(obj);
	}

	public List<City> getStatusFilterListForCity(City obj)throws Exception {
		return dao.getStatusFilterListForCity(obj);
	}

	public List<City> getStateList(City obj) throws Exception {
		return dao.getStateList(obj);
	}
}
