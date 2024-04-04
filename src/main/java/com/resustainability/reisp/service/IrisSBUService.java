package com.resustainability.reisp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resustainability.reisp.dao.IrisSBUDao;
import com.resustainability.reisp.model.SBU;


@Service
public class IrisSBUService {

	@Autowired
	IrisSBUDao dao;

	public int getTotalRecords(SBU obj, String searchParameter) throws Exception {
		return dao.getTotalRecords(obj,searchParameter);
	}

	public List<SBU> getSBUList(SBU obj, int startIndex, int offset, String searchParameter) throws Exception {
		return dao.getSBUList(obj,startIndex,offset,searchParameter);
	}

	public boolean addSBUIris(SBU obj) throws Exception {
		return dao.addSBUIris(obj);
	}

	public SBU getSBUDetails(SBU user)throws Exception {
		return dao.getSBUDetails(user);
	}

	public boolean updateSBUIris(SBU obj) throws Exception {
		return dao.updateSBUIris(obj);
	}

	public List<SBU> getSBUFilterListForSBU(SBU obj)throws Exception {
		return dao.getSBUFilterListForSBU(obj);
	}

	public List<SBU> getStatusFilterListForSBU(SBU obj)throws Exception {
		return dao.getStatusFilterListForSBU(obj);
	}
}
