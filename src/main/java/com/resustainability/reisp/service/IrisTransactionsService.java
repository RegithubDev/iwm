package com.resustainability.reisp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resustainability.reisp.dao.IrisTransactionsDao;
import com.resustainability.reisp.dao.IrisUserDao;
import com.resustainability.reisp.model.Transaction;
import com.resustainability.reisp.model.User;


@Service
public class IrisTransactionsService {

	@Autowired
	IrisTransactionsDao dao;

	public boolean uploadCollectData(Transaction obj) throws Exception{
		return dao.uploadCollectData(obj);
	}

	public boolean uploadBMWProcessingData(Transaction obj) throws Exception{
		return dao.uploadBMWProcessingData(obj);
	}

	public boolean uploadBMWDistributeData(Transaction obj)throws Exception{
		return dao.uploadBMWDistributeData(obj);
	}

	public boolean uploadMSWDistributeData(Transaction obj) throws Exception{
		return dao.uploadMSWDistributeData(obj);
	}

	public boolean uploadMSWProcessingData(Transaction obj)throws Exception{
		return dao.uploadMSWProcessingData(obj);
	}

	public boolean uploadIWMDisposalData(Transaction obj)throws Exception{
		return dao.uploadIWMDisposalData(obj);
	}

	public boolean uploadIWMLeftoverstockData(Transaction obj) throws Exception{
		return dao.uploadIWMLeftoverstockData(obj);
	}


}
