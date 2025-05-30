package com.resustainability.reisp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resustainability.reisp.dao.DashBoardWeighBridgeDao;
import com.resustainability.reisp.model.DashBoardWeighBridge;
import com.resustainability.reisp.model.IWM;
import com.resustainability.reisp.model.Project;
@Service
public class DashBoardWeighBridgeService {
	@Autowired
	DashBoardWeighBridgeDao dao;

	public List<DashBoardWeighBridge> getDashboards(DashBoardWeighBridge obj) throws Exception{
		return dao.getDashboards(obj);
	}

	public List<DashBoardWeighBridge> getSBUsList(DashBoardWeighBridge obj)  throws Exception{
		return dao.getSBUsList(obj);
	}

	public List<DashBoardWeighBridge> getDashboardsDaily(DashBoardWeighBridge obj) throws Exception {
		return dao.getDashboardsDaily(obj);
	}

	public List<DashBoardWeighBridge> getMSWDataWithSiteID(DashBoardWeighBridge obj)  throws Exception {
		return dao.getMSWDataWithSiteID(obj);
	}

	public List<DashBoardWeighBridge> getCNDDataWithSiteID(DashBoardWeighBridge obj)   throws Exception {
		return dao.getCNDDataWithSiteID(obj);
	}

	public List<DashBoardWeighBridge> getProjectssList(DashBoardWeighBridge obj)    throws Exception {
		return dao.getProjectssList(obj);
	}

	public List<DashBoardWeighBridge> getLogsList(DashBoardWeighBridge obj) throws Exception {
		return dao.getLogsList(obj);
	
	}

	public List<DashBoardWeighBridge> getWeighBridgeList(DashBoardWeighBridge obj) {
		return dao.getWeighBridgeList(obj);
	}

	public List<DashBoardWeighBridge> getMSWManualDataWithSiteID(DashBoardWeighBridge obj) throws Exception {
		return dao.getMSWManualDataWithSiteID(obj);
	}

	public List<DashBoardWeighBridge> getTransactionsList(DashBoardWeighBridge obj)  throws Exception {
		return dao.getTransactionsList(obj);
	}

	public List<DashBoardWeighBridge> getMonthList(DashBoardWeighBridge obj) throws Exception {
		return dao.getMonthList(obj);
	}

	public List<DashBoardWeighBridge> getCustomerCodeList(DashBoardWeighBridge obj) throws Exception {
		return dao.getCustomerCodeList(obj);
	}

	public List<DashBoardWeighBridge> getTransactionsList1(DashBoardWeighBridge obj) throws Exception {
		return dao.getTransactionsList1(obj);
	}

	public List<DashBoardWeighBridge> getLogsReportBMW(DashBoardWeighBridge obj) throws Exception {
		return dao.getLogsReportBMW(obj);
	}

	public List<DashBoardWeighBridge> getLogsReportALL(DashBoardWeighBridge obj) throws Exception {
		return dao.getLogsReportALL(obj);
	}

	public Object uploadIWMRecords(List<IWM> resultList)  throws Exception {
		return dao.uploadIWMRecords(resultList);
		
	}

	public List<DashBoardWeighBridge> projectsIWMList(String string)  throws Exception {
		return dao.projectsIWMList(string);
		
	}

	public Object uploadIWM3Records(List<IWM> resultList, String palnt) throws Exception {
		return dao.uploadIWM3Records(resultList,palnt);
		
	}

	public boolean delete(Project obj)  throws Exception {
		return dao.delete(obj);
	}
}
