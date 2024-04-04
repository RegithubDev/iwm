package com.resustainability.reisp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resustainability.reisp.dao.IrisSiteDao;
import com.resustainability.reisp.model.Site;


@Service
public class IrisSiteService {

	@Autowired
	IrisSiteDao dao;

	public int getTotalRecords(Site obj, String searchParameter) throws Exception {
		return dao.getTotalRecords(obj,searchParameter);
	}

	public List<Site> getSiteList(Site obj, int startIndex, int offset, String searchParameter) throws Exception {
		return dao.getSiteList(obj,startIndex,offset,searchParameter);
	}

	public boolean addSiteIris(Site obj) throws Exception {
		return dao.addSiteIris(obj);
	}

	public Site getSiteDetails(Site user)throws Exception {
		return dao.getSiteDetails(user);
	}

	public boolean updateSiteIris(Site obj) throws Exception {
		return dao.updateSiteIris(obj);
	}

	public List<Site> getSBUFilterListForSite(Site obj)throws Exception {
		return dao.getSBUFilterListForSite(obj);
	}

	public List<Site> getStateFilterListForSite(Site obj) throws Exception {
		return dao.getStateFilterListForSite(obj);
	}

	public List<Site> getCityFilterListForSite(Site obj)throws Exception {
		return dao.getCityFilterListForSite(obj);
	}

	public List<Site> getSiteList(Site site) throws Exception {
		return dao.getSiteList(site);
	}
}
