package com.resustainability.reisp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resustainability.reisp.dao.IrisRoleDao;
import com.resustainability.reisp.model.Role;
import com.resustainability.reisp.model.SBU;


@Service
public class IrisRoleService {

	@Autowired
	IrisRoleDao dao;

	public int getTotalRecords(Role obj, String searchParameter) throws Exception {
		return dao.getTotalRecords(obj,searchParameter);
	}

	public List<Role> getRoleList(Role obj, int startIndex, int offset, String searchParameter) throws Exception {
		return dao.getRoleList(obj,startIndex,offset,searchParameter);
	}

	public boolean addRoleIris(Role obj) throws Exception {
		return dao.addRoleIris(obj);
	}

	public Role getRoleDetails(Role user)throws Exception {
		return dao.getRoleDetails(user);
	}

	public boolean updateRoleIris(Role obj) throws Exception {
		return dao.updateRoleIris(obj);
	}
	public List<Role> getSBUFilterListForRole(Role obj)throws Exception {
		return dao.getSBUFilterListForRole(obj);
	}
	public List<Role> getRoleFilterListForRole(Role obj)throws Exception {
		return dao.getRoleFilterListForRole(obj);
	}

	public List<Role> getStatusFilterListForRole(Role obj)throws Exception {
		return dao.getStatusFilterListForRole(obj);
	}

	public List<Role> getSBUList(Role obj) throws Exception {
		return dao.getSBUList(obj);
	}

	public List<Role> getRolesAthenticationForMobile(Role obj) throws Exception {
		return dao.getRolesAthenticationForMobile(obj);
	}
}
