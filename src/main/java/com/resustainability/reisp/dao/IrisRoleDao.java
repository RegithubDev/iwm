package com.resustainability.reisp.dao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.StringUtils;

import com.resustainability.reisp.model.Role;

@Repository
public class IrisRoleDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSource dataSource;

	@Autowired
	DataSourceTransactionManager transactionManager;

	public int getTotalRecords(Role obj, String searchParameter) throws Exception {
		int totalRecords = 0;
		try {
			int arrSize = 0;
			String qry = "select count(DISTINCT um.role_name) as total_records FROM [roles] um "
					+ "left join sbu s on um.sbu_code = s.sbu_code "
			+ " where um.role_name <> '' ";
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getRole_name())) {
				qry = qry + " and  um.role_name = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				qry = qry + " and  um.sbu_code = ? ";
				arrSize++;
			}
		
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getStatus())) {
				qry = qry + " and um.status = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(searchParameter)) {
				qry = qry + " and (um.role_name like ? or um.status like ? or s.sbu_name = ?)";
				arrSize++;
				arrSize++;
				arrSize++;
			}	
			
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getRole_name())) {
				pValues[i++] = obj.getRole_name();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				pValues[i++] = obj.getSbu_code();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getStatus())) {
				pValues[i++] = obj.getStatus();
			}
			if(!StringUtils.isEmpty(searchParameter)) {
				pValues[i++] = "%"+searchParameter+"%";
				pValues[i++] = "%"+searchParameter+"%";
				pValues[i++] = "%"+searchParameter+"%";
			}
			
			totalRecords = jdbcTemplate.queryForObject( qry,pValues,Integer.class);
		}catch(Exception e){ 
			e.printStackTrace();
			throw new Exception(e);
		}
		return totalRecords;
	}

	public List<Role> getRoleList(Role obj, int startIndex, int offset, String searchParameter) throws Exception {
		List<Role> objsList = null;
		try {
			int arrSize = 0;
			jdbcTemplate = new JdbcTemplate(dataSource);
			String qry = "SELECT s.[id],s.sbu_code"
					+ "        ,ss.[sbu_name]"
					+ "      ,s.[role_name]"
					+ "      ,s.[status]"
					+ "      ,um.user_name as [created_by]"
					+ "      ,FORMAT (s.created_date, 'dd-MMM-yy') as [created_date]"
					+ "      ,um1.user_name as [modified_by]"
					+ "      ,FORMAT (s.modified_date, 'dd-MMM-yy') as [modified_date] FROM [roles] s  "
					+ "left join sbu ss on s.sbu_code = ss.sbu_code "
					+ " left join user_management um on s.created_by = um.id   "
					+ " left join user_management um1 on s.modified_by = um1.id  "
					+ "where s.id is not null  ";
			
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getRole_name())) {
				qry = qry + " and  s.role_name = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				qry = qry + " and  s.sbu_code = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getStatus())) {
				qry = qry + " and s.status = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(searchParameter)) {
				qry = qry + " and (s.role_name like ? or um.status like ? or ss.sbu_name like ?)";
				arrSize++;
				arrSize++;
				arrSize++;
			}	
			if(!StringUtils.isEmpty(startIndex) && !StringUtils.isEmpty(offset)) {
				qry = qry + " ORDER BY um.user_name asc offset ? rows  fetch next ? rows only";	
				arrSize++;
				arrSize++;
			}
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getRole_name())) {
				pValues[i++] = obj.getRole_name();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				pValues[i++] = obj.getSbu_code();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getStatus())) {
				pValues[i++] = obj.getStatus();
			}
			if(!StringUtils.isEmpty(searchParameter)) {
				pValues[i++] = "%"+searchParameter+"%";
				pValues[i++] = "%"+searchParameter+"%";
				pValues[i++] = "%"+searchParameter+"%";
			}
			if(!StringUtils.isEmpty(startIndex) && !StringUtils.isEmpty(offset)) {
				pValues[i++] = startIndex;
				pValues[i++] = offset;
			}
			objsList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<Role>(Role.class));	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return objsList;
	}

	public boolean addRoleIris(Role obj) throws Exception {
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String insertQry = "INSERT INTO [roles] "
					+ "		( sbu_code"
					+ "      ,role_name"
					+ "      ,status"
					+ "      ,created_by,created_date) "
					+ "		VALUES "
					+ "		( :sbu_code"
					+ "      ,:role_name"
					+ "      ,:status"
					+ "      ,:created_by,getdate())";
			BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(obj);		 
		    count = namedParamJdbcTemplate.update(insertQry, paramSource);
			if(count > 0) {
				flag = true;
			}
			transactionManager.commit(status);
		}catch (Exception e) {
			transactionManager.rollback(status);
			e.printStackTrace();
			throw new Exception(e);
		}
		return flag;
	}

	public Role getRoleDetails(Role user) throws Exception {
		Role obj = null;
		try {
			String qry = "SELECT s.[id]"
					+ "        , [sbu_code]"
					+ "      ,[role_name]"
					+ "      ,[status]"
					+ "      ,um.user_name as [created_by]"
					+ "      ,FORMAT (um.created_date, 'dd-MMM-yy') as[created_date]"
					+ "      ,um1.user_name as [modified_by]"
					+ "      ,FORMAT (um.modified_date, 'dd-MMM-yy') as[modified_date] FROM [roles] s  "
					+ " left join user_management um on s.created_by = um.id   "
					+ " left join user_management um1 on s.modified_by = um1.id  "
					+ "where um.id is not null  ";
			int arrSize = 0;
			if(!StringUtils.isEmpty(user) && !StringUtils.isEmpty(user.getId())) {
				qry = qry + " and um.id = ? ";
				arrSize++;
			}
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(user) && !StringUtils.isEmpty(user.getId())) {
				pValues[i++] = user.getId();
			}
			obj = (Role)jdbcTemplate.queryForObject(qry, pValues, new BeanPropertyRowMapper<Role>(Role.class));

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return obj;
	}

	public boolean updateRoleIris(Role obj) throws Exception {
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String insertQry = "UPDATE [roles] set sbu_code= :sbu_code,"
					+ "      role_name= :role_name"
					+ "      ,status= :status,modified_date= getdate(),modified_by= :modified_by"
					+ " where id =  '"+obj.getId()+"'";
			BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(obj);		 
		    count = namedParamJdbcTemplate.update(insertQry, paramSource);
			if(count > 0) {
				flag = true;
			}
			transactionManager.commit(status);
		}catch (Exception e) {
			transactionManager.rollback(status);
			e.printStackTrace();
			throw new Exception(e);
		}
		return flag;
	}

	public List<Role> getRoleFilterListForRole(Role obj) throws Exception {
		List<Role> objsList = null;
		try {
			int arrSize = 0;
			jdbcTemplate = new JdbcTemplate(dataSource);
			String qry = "SELECT id,role_name from [roles] um  where um.role_name is not null ";
			
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getRole_name())) {
				qry = qry + " and  um.role_name = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				 String input = obj.getSbu_code();
				 StringBuilder concatenated = new StringBuilder();
				qry = qry + " and  um.sbu_code in (";
				 if (input.contains(",")) {
					 String [] arr = input.split(",");
					 for(String arrObj : arr) {
						 qry = qry + " ?,";
						 arrSize++;
					 }
				    qry =  qry.trim().replaceAll(",$", "");
					qry = qry + " )";
				 }else {
					 qry = qry + " ?)";
					 arrSize++;
				 }
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getStatus())) {
				qry = qry + " and um.status = ? ";
				arrSize++;
			}
			qry = qry + " group by id,role_name order by um.role_name asc";
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getRole_name())) {
				pValues[i++] = obj.getRole_name();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				 String input = obj.getSbu_code();
				 if (input.contains(",")) {
					 String [] arr = input.split(",");
					 for(String arrObj : arr) {
						 pValues[i++] = arrObj ;
					 }
				
			     }else {
			    	 pValues[i++] = obj.getSbu_code();
			     }
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getStatus())) {
				pValues[i++] = obj.getStatus();
			}
			objsList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<Role>(Role.class));	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return objsList;
	}
	
	public List<Role> getSBUFilterListForRole(Role obj) throws Exception {
		List<Role> objsList = null;
		try {
			int arrSize = 0;
			jdbcTemplate = new JdbcTemplate(dataSource);
			String qry = "SELECT um.[sbu_code],ss.sbu_name from [roles] um left join sbu ss on um.sbu_code = ss.sbu_code   where um.role_name is not null ";
			
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getRole_name())) {
				qry = qry + " and  um.role_name = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				qry = qry + " and  um.sbu_code = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getStatus())) {
				qry = qry + " and um.status = ? ";
				arrSize++;
			}
			qry = qry + " group by um.[sbu_code],sbu_name order by ss.sbu_name asc";
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getRole_name())) {
				pValues[i++] = obj.getRole_name();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				pValues[i++] = obj.getSbu_code();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getStatus())) {
				pValues[i++] = obj.getStatus();
			}
			objsList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<Role>(Role.class));	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return objsList;
	}

	public List<Role> getStatusFilterListForRole(Role obj) throws Exception {
		List<Role> objsList = null;
		try {
			int arrSize = 0;
			jdbcTemplate = new JdbcTemplate(dataSource);
			String qry = "SELECT distinct(um.[status]) from [roles] um where status is not null ";
			
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getRole_name())) {
				qry = qry + " and  um.role_name = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				qry = qry + " and  um.sbu_code = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getStatus())) {
				qry = qry + " and um.status = ? ";
				arrSize++;
			}
			qry = qry + " order by um.status asc";
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getRole_name())) {
				pValues[i++] = obj.getRole_name();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				pValues[i++] = obj.getSbu_code();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getStatus())) {
				pValues[i++] = obj.getStatus();
			}
			objsList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<Role>(Role.class));	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return objsList;
	}

	public List<Role> getSBUList(Role obj) throws Exception {
		List<Role> objsList = null;
		try {
			int arrSize = 0;
			jdbcTemplate = new JdbcTemplate(dataSource);
			String qry = "SELECT id,sbu_code,sbu_name from [sbu] um where status <> 'Inactive' ";
			
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				qry = qry + " and  um.sbu_code = ? ";
				arrSize++;
			}
			qry = qry + " order by um.sbu_name asc";
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				pValues[i++] = obj.getSbu_code();
			}
			objsList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<Role>(Role.class));	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return objsList;
	}

	public List<Role> getRolesAthenticationForMobile(Role obj) throws Exception {
		List<Role> objsList = null;
		try {
			int arrSize = 0;
			jdbcTemplate = new JdbcTemplate(dataSource);
			String qry = "SELECT id,sbu_code,role_name from [roles] um where status <> 'Inactive' ";
			
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				qry = qry + " and  um.sbu_code = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getRoles())) {
				 String input = obj.getRoles();
				qry = qry + " and  um.id in(  ";
				 if (input.contains(",")) {
					 String [] arr = input.split(",");
					 for(String arrObj : arr) {
						 qry = qry + " ?,";
						 arrSize++;
					 }
				    qry =  qry.trim().replaceAll(",$", "");
					qry = qry + " )";
				 }else {
					 qry = qry + " ?)";
					 arrSize++;
				 }
			}
			qry = qry + " order by um.role_name asc";
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				pValues[i++] = obj.getSbu_code();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getRoles())) {
				 String input = obj.getRoles();
				 if (input.contains(",")) {
					 String [] arr = input.split(",");
					 for(String arrObj : arr) {
						 pValues[i++] = arrObj ;
					 }
				
			     }else {
			    	 pValues[i++] = obj.getRoles();
			     }
			}
			objsList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<Role>(Role.class));	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return objsList;
	}

	
	}

	
	
	

