package com.resustainability.reisp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resustainability.reisp.dao.IrisStateDao;
import com.resustainability.reisp.model.State;


@Service
public class IrisStateService {

	@Autowired
	IrisStateDao dao;

	public int getTotalRecords(State obj, String searchParameter) throws Exception {
		return dao.getTotalRecords(obj,searchParameter);
	}

	public List<State> getStateList(State obj, int startIndex, int offset, String searchParameter) throws Exception {
		return dao.getStateList(obj,startIndex,offset,searchParameter);
	}

	public boolean addStateIris(State obj) throws Exception {
		return dao.addStateIris(obj);
	}

	public State getStateDetails(State user)throws Exception {
		return dao.getStateDetails(user);
	}

	public boolean updateStateIris(State obj) throws Exception {
		return dao.updateStateIris(obj);
	}

	public List<State> getStateFilterListForState(State obj)throws Exception {
		return dao.getStateFilterListForState(obj);
	}

	public List<State> getStatusFilterListForState(State obj)throws Exception {
		return dao.getStatusFilterListForState(obj);
	}
}
